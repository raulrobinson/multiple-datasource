# Stage 1: Build Application
FROM maven:3.9.4-eclipse-temurin-17 AS build

WORKDIR /app

# Copy the POM file
COPY pom.xml ./
COPY central/pom.xml ./central/
COPY module-a/pom.xml ./module-a/
COPY module-b/pom.xml ./module-b/
COPY module-c/pom.xml ./module-c/

# Download dependencies and plugins to cache them in Docker layer for future builds.
RUN mvn dependency:go-offline

# Copy the source code
COPY . ./

# Execute the Maven build
RUN mvn clean package -DskipTests

# Stage 2: Execution Application
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy the JARs from the build stage to the final image.
COPY --from=build /app/central/target/central-0.0.1-SNAPSHOT.jar ./central.jar
COPY --from=build /app/module-a/target/module-a-1.0-SNAPSHOT.jar ./module-a.jar
COPY --from=build /app/module-b/target/module-b-1.0-SNAPSHOT.jar ./module-b.jar
COPY --from=build /app/module-c/target/module-c-1.0-SNAPSHOT.jar ./module-c.jar

# Create a classpath environment variable with the JARs.
ENV CLASSPATH=./central.jar:./module-a.jar:./module-b.jar:./module-c.jar

## Configure environment variables
#ENV SPRING_DATASOURCE_ONE_URL=jdbc:postgresql://localhost:15432/postgres
#ENV SPRING_DATASOURCE_ONE_USERNAME=postgres-one
#ENV SPRING_DATASOURCE_ONE_PASSWORD=postgres-one
#
#ENV SPRING_DATASOURCE_TWO_URL=jdbc:postgresql://localhost:25432/postgres
#ENV SPRING_DATASOURCE_TWO_USERNAME=postgres-two
#ENV SPRING_DATASOURCE_TWO_PASSWORD=postgres-two
#
#ENV SPRING_DATASOURCE_THREE_URL=jdbc:mysql://localhost:13306/test
#ENV SPRING_DATASOURCE_THREE_USERNAME=root
#ENV SPRING_DATASOURCE_THREE_PASSWORD=password

# Expose the port the app runs.
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/central.jar"]
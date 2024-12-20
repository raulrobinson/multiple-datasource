# Use image from Maven to build the project and then use OpenJDK to run the application.
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the packaged JAR file into the container
ARG JAR_FILE=target/multi-datasource-app.jar
COPY ${JAR_FILE} app.jar

# Expose the port that the application runs in
EXPOSE 8080

# Configure environment variables
ENV SPRING_DATASOURCE_ONE_URL=jdbc:postgresql://localhost:15432/postgres
ENV SPRING_DATASOURCE_ONE_USERNAME=postgres-one
ENV SPRING_DATASOURCE_ONE_PASSWORD=postgres-one

ENV SPRING_DATASOURCE_TWO_URL=jdbc:postgresql://localhost:25432/postgres
ENV SPRING_DATASOURCE_TWO_USERNAME=postgres-two
ENV SPRING_DATASOURCE_TWO_PASSWORD=postgres-two

ENV SPRING_DATASOURCE_THREE_URL=jdbc:mysql://localhost:13306/test
ENV SPRING_DATASOURCE_THREE_USERNAME=root
ENV SPRING_DATASOURCE_THREE_PASSWORD=password

ENTRYPOINT ["java", "-jar", "/app/app.jar"]

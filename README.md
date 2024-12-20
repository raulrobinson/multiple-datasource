# multiple-datasource

Central Service multiple datasource

## Getting Started

### Prerequisites

- Java 11+
- Maven 3.6.3+
- Docker 19.03.8+
- Docker Compose 1.25.0+
- Lombok Plugin

### Installing

1. Clone the repository

```shell
git clone https://github.com/raulrobinson/multiple-datasource.git
```

2. Build the project

```shell
mvn clean install
```

3. Run the project

```shell
mvn spring-boot:run
```

4. Access the Swagger

```shell
http://localhost:8080/swagger-ui/index.html
```

### Running the tests

1. Run the tests

```shell
mvn test
```

### Running with Docker

1. Build the image

```shell
docker build -t multiple-datasource .
```

2. Run the container

```shell
docker run -p 8080:8080 multiple-datasource
```

# Author
Raul Robinson Bolivar Navas - Software Developer
Linkedin: [Raul Robinson Bolivar Navas](https://www.linkedin.com/in/rasysbox/)

# License
MIT License
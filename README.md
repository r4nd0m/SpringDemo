# Getting started
## Requirements
- Docker
- Gradle
- Java 17+

## Run dev environment
- create DB container with `/scripts/create_mariadb.bat`
- run DB container with `/scripts/start_mariadb.bat`
- build and run the application with environment variable `spring.profiles.active=dev`
- after application stop also stop DB container with `/scripts/stop_mariadb.bat`

## API
- default SpringBoot Data REST API http://localhost:8080/api/
- custom endpoints:
  - http://localhost:8080/api/cars/findByName/{name}/{limit} - find car by name. Both parameters are optional.
  - http://localhost:8080/api/cars/findByOwner/{owner}/{limit} - find car by owner name. Both parameters are optional.
- API documentation URL http://localhost:8080/swagger-ui/index.html
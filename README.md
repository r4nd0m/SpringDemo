# Getting started
## Requirements
- Docker
- Gradle
- Java 17+

## Run dev environment
- create DB container by running `./scripts/create_mariadb.bat` from the project root directory
- create empty DB by running `./scripts/create_database.bat` from the project root directory
- run DB container by running `./scripts/start_mariadb.bat`  from the project root directory
- build and run the application with environment variable `spring.profiles.active=dev` (must be set in Run/Debug Configuration)
- after application stop also stop DB container with `./scripts/stop_mariadb.bat`

## API
- default SpringBoot Data REST API http://localhost:8080/api/ (JWT protected)
- some custom endpoints:
  - http://localhost:8080/api/cars/findByName/{name}/{limit} - find car by name. Both parameters are optional.
  - http://localhost:8080/api/cars/findByOwner/{owner}/{limit} - find car by owner name. Both parameters are optional.
- API documentation URL http://localhost:8080/swagger-ui/index.html
  - make sure to run ``/login`` first and use returned JWT to authenticate the following requests
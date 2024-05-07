# IMPORTANT! before building the container make sure to execute gradle build to create a JAR file

# build docker container
docker buildx b -f Dockerfile --build-arg JAR_FILE=build/libs/SpringDemo-0.0.1-SNAPSHOT.jar -t vkalenyuk/spring-demo .

# create network to connect the SpringBoot container with the MariaDB container
docker network create local-docker-network

# attach MariaDB container to the network
docker network connect local-docker-network mariadb-lts

# remove previously created container if present
docker rm springboot-demo

# start the SpringBoot container attached to the docker network
# and having the port mapping to the host to be accessible via http://localhost:8080
docker run -p 8080:8080 --network=local-docker-network --name springboot-demo vkalenyuk/spring-demo --attach
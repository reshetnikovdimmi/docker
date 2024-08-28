FROM openjdk:17-jdk-alpine
MAINTAINER DOCKER
COPY target/docker-0.0.1-SNAPSHOT.jar docker-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/docker-0.0.1-SNAPSHOT.jar"]
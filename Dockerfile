#define base docker image

FROM openjdk:18-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} graphql-api-backend.jar
ENTRYPOINT ["java","-jar","graphql-api-backend.jar"]
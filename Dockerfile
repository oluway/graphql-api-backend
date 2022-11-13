#define base docker image
FROM openjdk:11
LABEL maintainer:"olumide"
ADD target/graphql-0.0.1-SNAPSHOT.jar graphql.jar
ENTRYPOINT ["java", "-jar", "graphql.jar"]
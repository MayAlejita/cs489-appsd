# Using OpenJDK version 17 as the base image
FROM maven:3.8.3-openjdk-17 AS build

COPY target/dentalsurgeryapp-0.0.1-SNAPSHOT.jar dentalsurgeryapp-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "/dentalsurgeryapp-0.0.1-SNAPSHOT.jar"]
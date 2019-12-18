FROM java:8
EXPOSE 8080
ADD /target/microservice-0.0.1-SNAPSHOT.jar  microservice.jar
ENTRYPOINT ["java","-jar","microservice.jar"]
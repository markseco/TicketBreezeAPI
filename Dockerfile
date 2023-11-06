FROM openjdk:21
EXPOSE 8080
ADD target/ticketbreeze-api-docker.jar ticketbreeze-api-docker.jar
ENTRYPOINT ["java","-jar","/ticketbreeze-api-docker.jar"]
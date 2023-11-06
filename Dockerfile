FROM openjdk:21
EXPOSE 8080
ADD target/
ENTRYPOINT ["java","-jar",""]
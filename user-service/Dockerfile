FROM openjdk:17-oracle
COPY ./target/*.jar user-service.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/user-service.jar"]
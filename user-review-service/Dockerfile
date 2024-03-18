FROM openjdk:17-oracle
COPY ./target/*.jar user-review-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/user-review-service.jar"]
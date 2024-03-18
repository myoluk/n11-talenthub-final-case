FROM openjdk:17-oracle
COPY ./target/*.jar restaurant-service.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "/restaurant-service.jar"]
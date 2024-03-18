FROM openjdk:17-oracle
COPY ./target/*.jar kafka-logger-service.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "/kafka-logger-service.jar"]
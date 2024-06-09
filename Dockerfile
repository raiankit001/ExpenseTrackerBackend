FROM openjdk:11-jre-slim
COPY target\ExpenseTracker-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
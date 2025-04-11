FROM openjdk:17-jdk
COPY target/student-survey-1.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
EXPOSE 8080
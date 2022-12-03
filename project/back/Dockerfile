FROM openjdk:17-alpine
COPY target/back-1.0-SNAPSHOT.jar /services/app.jar
EXPOSE 8765
CMD ["java", "-jar", "/services/app.jar"]

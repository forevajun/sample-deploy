FROM openjdk:17-alpine
COPY target/web-1.0-SNAPSHOT.jar /services/app.jar
EXPOSE 8080
CMD ["java", "-jar", "/services/app.jar"]

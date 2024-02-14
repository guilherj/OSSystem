FROM openjdk:17-jdk-alpine
COPY target/OS-System.jar app.jar
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "app.jar" ]
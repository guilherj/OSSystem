FROM openjdk:17-jdk-alpine

RUN apt-get install maven -y
RUN mvn clean install

COPY --from=build /target/OS-System-1.0.0.jar app.jar

EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "app.jar" ]
FROM adoptopenjdk/openjdk11:alpine-jre

ARG JAR_FILE=target/*.jar

WORKDIR /javaFolder

COPY ${JAR_FILE} app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
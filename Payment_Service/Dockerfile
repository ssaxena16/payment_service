FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY target/*.jar app.jar

EXPOSE 5010

ENTRYPOINT ["java","-jar","app.jar","--spring.config.location=file:/config/application.properties"]
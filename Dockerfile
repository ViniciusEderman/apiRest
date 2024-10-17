    FROM openjdk:17-jdk-alpine
    RUN mkdir /application
    WORKDIR /application
    COPY target/*.jar /application/application.jar
    CMD ["java", "-jar", "/application/application.jar"]
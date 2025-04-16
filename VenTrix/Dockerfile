FROM openjdk:8u121-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ./target/VenTrix-0.0.1-SNAPSHOT.jar app.jar
RUN mkdir -p /app/tokens
EXPOSE 8890
ENTRYPOINT ["java","-jar","/app.jar"]
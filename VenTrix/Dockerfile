# Usa OpenJDK 21 (versión compatible con tu pom.xml)
FROM openjdk:21-jdk-slim

# Copia el JAR generado LOCALMENTE (debes compilarlo primero en tu máquina)
COPY ./target/VenTrix-0.0.1-SNAPSHOT.jar app.jar

# Crea la carpeta para tokens
RUN mkdir -p /app/tokens

EXPOSE 8890
ENTRYPOINT ["java", "-jar", "/app.jar"]
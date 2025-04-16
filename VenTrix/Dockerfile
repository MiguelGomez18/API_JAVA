FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copia el JAR generado localmente (asegúrate de que existe en target/*.jar)
COPY target/*.jar app.jar

# Crea el directorio para tokens
RUN mkdir -p /app/tokens

EXPOSE 8890

ENTRYPOINT ["java", "-jar", "app.jar"]
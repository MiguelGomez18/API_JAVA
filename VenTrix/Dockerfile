# Etapa de construcción
FROM eclipse-temurin:21-jdk-alpine AS builder

WORKDIR /app
COPY . .

# Configura el entorno correctamente antes de ejecutar Maven
RUN apt-get update && \
    apt-get install -y curl && \
    chmod +x mvnw &&
RUN mvn -DoutputFile=target/mvn-dependency-list.log -B -DskipTests clean dependency:list install

# Etapa final
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
RUN mkdir -p /app/tokens
EXPOSE 8890
ENTRYPOINT ["java", "-jar", "app.jar"]
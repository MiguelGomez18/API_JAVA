FROM eclipse-temurin:21-jdk AS builder

WORKDIR /app

# Copia el wrapper con permisos explícitos
COPY .mvn/ .mvn/
COPY mvnw .
RUN chmod +x mvnw

# Resto del proceso
COPY pom.xml .
RUN ./mvnw dependency:go-offline -B
COPY src/ src/
RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=builder /app/target/VenTrix-0.0.1-SNAPSHOT.jar app.jar
RUN mkdir -p /app/tokens && chmod -R 755 /app
EXPOSE 8890
ENTRYPOINT ["java", "-jar", "app.jar"]
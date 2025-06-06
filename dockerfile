# FROM eclipse-temurin:17-jdk-alpine

# WORKDIR /app

# # Copia el código fuente al contenedor
# COPY . /app

# # Verifica si Maven está instalado, si no, lo instala
# RUN if ! command -v mvn &> /dev/null; then \
#       apk add --no-cache maven; \
#     fi

# CMD ["mvn", "spring-boot:run"]


# # Build stage
# FROM maven:3.9.9-eclipse-temurin-17 AS build
# WORKDIR /app
# COPY . /app
# RUN mvn clean package -DskipTests

# # Run stage
# FROM eclipse-temurin:17-jdk-alpine
# WORKDIR /app
# COPY --from=build /app/target/ferremas-0.0.1-SNAPSHOT.jar app.jar
# EXPOSE 8080
# # Verifica si Maven está instalado, si no, lo instala
# RUN if ! command -v mvn &> /dev/null; then \
#       apk add --no-cache maven; \
#     fi
# ENTRYPOINT ["java", "-jar", "app.jar"]

FROM maven:3.9.9-eclipse-temurin-17 AS build
WORKDIR /app

# Copia solo los archivos de dependencias primero
COPY pom.xml ./
COPY .mvn/ .mvn/

# Descarga dependencias y las cachea en esta capa
RUN mvn dependency:go-offline

# Ahora copia el resto del código fuente
COPY src/ ./src/

# Compila el proyecto
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/ferremas-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
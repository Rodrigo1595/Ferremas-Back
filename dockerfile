FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copia el código fuente al contenedor
COPY . /app

# Verifica si Maven está instalado, si no, lo instala
RUN if ! command -v mvn &> /dev/null; then \
      apk add --no-cache maven; \
    fi

CMD ["mvn", "spring-boot:run"]
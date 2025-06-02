# Ferremas

Ferremas es una API RESTful desarrollada en Spring Boot para la gestión de productos, categorías, subcategorías, precios, usuarios, sucursales y pedidos en una ferretería.

## 🚀 Tecnologías usadas

- ![Java](https://img.shields.io/badge/Java-ED8B00?logo=java&logoColor=white) **Java 17+**
- ![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?logo=spring-boot&logoColor=white) **Spring Boot**
- ![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?logo=postgresql&logoColor=white) **PostgreSQL**
- ![Docker](https://img.shields.io/badge/Docker-2496ED?logo=docker&logoColor=white) **Docker & Docker Compose**
- ![Swagger](https://img.shields.io/badge/Swagger-85EA2D?logo=swagger&logoColor=black) **OpenAPI/Swagger**
- ![Lombok](https://img.shields.io/badge/Lombok-ED1C24?logo=lombok&logoColor=white) **Lombok**
- ![Maven](https://img.shields.io/badge/Maven-C71A36?logo=apache-maven&logoColor=white) **Maven**

## Características principales

- Gestión de productos con histórico de precios y control de precio activo.
- Asociación de productos a categorías y subcategorías.
- Gestión de usuarios, sucursales y pedidos.
- Documentación OpenAPI/Swagger disponible.
- Despliegue con Docker y Docker Compose.

## Estructura de servicios principales

### 🛠️ Productos

- `GET /api/productos`  
  Lista todos los productos con su precio actual.

- `GET /api/productos/{id}`  
  Obtiene un producto por su ID.

- `GET /api/productos/codigo/{codProducto}`  
  Obtiene un producto por su código (ej: FER-000001).

- `POST /api/productos`  
  Crea un producto (requiere precio inicial).

- `PUT /api/productos/{id}`  
  Actualiza un producto y registra un nuevo precio si corresponde.

- `DELETE /api/productos/{id}`  
  Elimina un producto.

- `GET /api/productos/{id}/precios`  
  Obtiene el histórico de precios de un producto.

- `GET /api/productos/categoria/{categoriaId}`  
  Lista productos por categoría.

### 📂 Categorías y Subcategorías

- `GET /api/categorias`  
  Lista todas las categorías.

- `POST /api/categorias`  
  Crea una nueva categoría.

- `GET /api/subcategorias`  
  Lista todas las subcategorías.

- `POST /api/subcategorias`  
  Crea una nueva subcategoría.

### 💲 Precios

- `GET /api/precios/{id}`  
  Obtiene un precio por ID.

- `POST /api/precios`  
  Crea un nuevo registro de precio para un producto.

### 👤 Usuarios

- `GET /api/usuarios/{id}`  
  Obtiene un usuario por ID.

- `POST /api/usuarios`  
  Crea un usuario.

- `GET /api/usuarios/correo/{correo}`  
  Busca usuario por correo.

### 🏢 Sucursales

- `GET /api/sucursales`  
  Lista todas las sucursales.

- `POST /api/sucursales`  
  Crea una sucursal.

### 📦 Pedidos

- `GET /api/pedidos`  
  Lista todos los pedidos.

- `POST /api/pedidos`  
  Crea un pedido.

## 🐳 Despliegue con Docker

1. Construye la imagen:
   ```sh
   docker build -t rodamigo95/ferremas:latest .
   ```

2. Sube la imagen a Docker Hub:
   ```sh
   docker push rodamigo95/ferremas:latest
   ```

3. Levanta los servicios:
   ```sh
   docker-compose up -d
   ```

## Documentación OpenAPI

Accede a la documentación interactiva en:  
`http://localhost:8080/swagger-ui.html`  
o  
`http://localhost:8080/swagger-ui/index.html`

---

**Autor:**  
[rodamigo95](https://github.com/rodamigo95)
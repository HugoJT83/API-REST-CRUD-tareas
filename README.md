# API REST con Spring Boot 4 y Java 21

Implementación de una **API RESTful** utilizando **Java 21** y **Spring Boot 4**; gestionado con **Maven** y que utiliza **H2** y **MySQL** como gestor de datos.

---

## Tecnologías y Herramientas

* **Lenguaje:** Java 21 (LTS)
* **Framework:** Spring Boot 4.x
* **Gestión de Dependencias:** Maven 3.9+
* **Persistencia:** Spring Data JPA
* **Base de Datos:** H2 (Memoria) / mySQL
* 
---

## Funcionalidades CRUD

El proyecto cuenta con gestión completa de tareas:

1. **GET** /api/tasks
2. **GET** /api/tasks/{id}
3. **POST** /api/tasks
4. **PUT** /api/tasks/{id}
5. **PATCH** /api/tasks/{id}/status
6. **DELETE** /api/tasks/{id}

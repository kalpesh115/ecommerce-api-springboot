Ecommerce API - Spring Boot

A RESTful E-Commerce API built using Spring Boot, Spring Security, JWT Authentication, Spring Data JPA, and MySQL.

Features
User Registration
User Login with JWT Authentication
Spring Security Integration
Product Management (CRUD)
Cart Management
Order Management
Global Exception Handling
MySQL Database Integration
Layered Architecture
REST APIs
Tech Stack
Java 21
Spring Boot 4
Spring Security
JWT
Spring Data JPA
Hibernate
MySQL
Maven
Lombok
Project Structure

src/main/java
├── controller
├── service
├── serviceImpl
├── repository
├── entity
├── dto
├── config
├── exception
└── util

API Endpoints
Authentication

POST /api/auth/register

POST /api/auth/login

Products

GET /api/products

GET /api/products/{id}

POST /api/products

PUT /api/products/{id}

DELETE /api/products/{id}

Cart

POST /api/cart/add

GET /api/cart

DELETE /api/cart/remove/{id}

Orders

POST /api/orders

GET /api/orders

Running the Project
Clone the repository

git clone https://github.com/kalpesh115/ecommerce-api-springboot.git

Configure MySQL in application.properties
Run

mvn clean install

mvn spring-boot

Access

http://localhost:8080

Future Enhancements
Role Based Authorization (ADMIN / USER)
Swagger Documentation
Docker Support
Stripe Payment Gateway
Redis Caching
AWS Deployment
Author

Kalpesh Rane

GitHub: https://github.com/kalpesh115

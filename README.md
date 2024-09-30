# springboot-transaction-rest-api

## Overview
This project is a simple Spring Boot application designed to manage transactions to the db. It allows you to:
- Insert Order and Payment data into a **MySQL database** via a **POST** request.
- Use **Spring Data JPA** for data persistence.

## Features
- **POST**: Insert Order and Payment data into the database only if both the operations are successful, otherwise it won't make a entry into the database.
- Database: Uses **MySQL**.
- ORM: Implemented using **Spring Data JPA** with Hibernate.

## Technologies
- **Java 17+**
- **Spring Boot 3+**
- **Spring Data JPA**
- **MySQL**
- **Lombok** (optional, for reducing boilerplate code)

## Prerequisites
Before you begin, ensure you have the following installed:
- Java 17 or later
- MySQL server
- Maven 3.x+

## Setup

1. **Clone the repository**:
    ```bash
    git clone https://github.com/NavneetMalva/springboot-transaction-rest-api.git
    cd springboot-transaction-rest-api
    ```

2. **Configure MySQL Database**:
   Create a MySQL database for the project.
    ```bash
    CREATE DATABASE searchfilterdb;
    ```

3. **Configure application.properties**:
   Set up your MySQL credentials in the `src/main/resources/application.properties` file:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/searchfilterdb
    spring.datasource.username=yourUsername
    spring.datasource.password=yourPassword
    spring.jpa.hibernate.ddl-auto=update

4. **Build the project**: 
   Run the following Maven command to build and package the project:
    ```bash
    mvn clean install
    ```

5. **Run the Application**: 
   You can now run the Spring Boot application with:
    ```bash
    mvn spring-boot:run
    ```

## Endpoints
1. **Insert Product**

   - URL: /api/v1/order
   - Method: `POST`
   - Request Body:
       ```JSON
      {
        "order": {
          "totalQuantity": 2,
          "totalPrice": 100.50,
          "shoppingCartId": 999
         },
       "payment": {
         "type": "DEBIT",
         "cardName": "John Smith",
         "cardNumber": "1234 1234 1234 1234",
         "expiryYear": 2025,
         "expiryMonth": 12,
         "cvc": 123
        }
      }
       ```
 - Response: 200 OK
      ```JSON 
   {
    "orderTrackingNumber": "83c8b1d5-f53d-4e71-aa7f-f8c6d87cf8f2",
     "status": "DONE",
     "message": "SUCCESS"
   }
   ```
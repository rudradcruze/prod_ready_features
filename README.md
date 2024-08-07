# Production Ready Features

## Overview

This project showcases a set of production-ready features implemented using Spring Boot, including exception handling, auditing, logging, and API integration. The main functionalities include managing employees and posts, with comprehensive error handling and logging mechanisms in place.

## Features

- **Global Exception Handling**: Using `@RestControllerAdvice` to handle exceptions globally.
- **Auditing**: Using Hibernate Envers and Spring Data JPA auditing.
- **Logging**: Configured with logback to handle different levels of logging and to output logs to a file.
- **API Integration**: Using Spring's `RestClient` to interact with external APIs.
- **Entity Management**: CRUD operations for employees and posts.
- **API Documentation**: Enabled OpenAPI documentation.

## Running the Application
1. Clone the repository: 
   ```bash
    git clone https://github.com/rudradcruze/prod_ready_features.git
    ```
2. Navigate to the project directory:
    ```bash
    cd prod_ready_features
    ```
3. Update the application.properties file with your database configurations.
4. Build the project:
    ```bash
    ./mvnw clean install
    ```
5. Run the application:
    ```bash
    ./mvnw spring-boot:run
    ```

## API Endpoints

### Employee Endpoints
* `GET /employees`: Retrieve all employees.
* `GET /employees/{id}`: Retrieve employee by ID.
* `POST /employees`: Create a new employee.
* `PUT /employees/{id}`: Update an existing employee.

### Post Endpoints
* `GET /posts`: Retrieve all posts.
* `GET /posts/{postId}`: Retrieve post by ID.
* `POST /posts`: Create a new post.
* `PUT /posts/{postId}`: Update an existing post.

## Audit Endpoints
* `GET /audit/posts/{postId}`: Retrieve audit history for a post.

## 🚀 About Me

Tech-savvy learner/programmer pushing boundaries of online tech. Passionate about new tools, seeking challenges to advance skills.

## 🔗 Social Links

![Name](https://img.shields.io/badge/Name-Francis%20Rudra%20D%20Cruze-yellowgreen?style=for-the-badge)
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/rudradcruze)
[![twitter](https://img.shields.io/badge/twitter-1DA1F2?style=for-the-badge&logo=twitter&logoColor=white)](https://twitter.com/rudradcruze)
[![Facebook](https://img.shields.io/badge/facebook-4267B2?style=for-the-badge&logo=facebook&logoColor=white)](https://facebook.com/rudradcruze)
[![francisrudra@gmail.com](https://img.shields.io/badge/gmail-4267B2?style=for-the-badge&logo=gmail&logoColor=white)](mailto:francisrudra@gmail.com)
# Recipe app backend

This is a simple recipe app backend built with Java 17, Spring Boot 3.5 and PostgreSQL.

It features a REST API for managing recipes and ingredients.

It also features a containerized database to use in development and testing.

### Setting up the project

1. Clone the repository:
   ```bash
   git clone https://github.com/cadupereira21/recipe-app-java.git

2. Move to the project directory:
   ```bash
   cd recipe-app-java
   ```

3. Build the project:
   ```bash
    ./mvnw clean install
    ```

4. Run the docker container:
   ```bash
   cd docker && docker compose up
   ```

5. Run the application

### Swagger Documentation
This project also features documentation using Swagger from SpringDoc OpenAPI. You can use it to see the available endpoints and test them.

If the server port is not changed, the API documentation is available at [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html).


### Design Choices
**Architecture**

For the sake of simplicity, this project is built using a monolithic architecture. This means that all the components of the application are contained in a single codebase and deployed together. This is a common approach for small projects and allows for faster development and easier deployment.

**Structure**

This project uses a MVC structure, in which the Controller handles the HTTP requests, the Service layer contains the business logic, and the Repository layer interacts with the database. There are also the Domain entities that represent the data model of the application and the DTOs which are used to separate the data that goes through the client, application and database.

**Error Handling**

For handling errors, this project uses a global exception handler that catches exceptions thrown by the application and returns a proper HTTP response with an error message. This allows for better error handling and debugging. Each error would have a error code and a message. This way we can easily identify the error and provide a meaningful message to the user.

**Database Management**

You can create, read, update and delete recipes. Each recipe has a name, description, ingredients, instructions, serving amout and a flag that tells if it is vegetarian.

The Recipe and Ingredient are separated entities but connected by a one-to-many relationship. Each recipe can have multiple ingredients, and each ingredient is unique to a recipe. This is not very scalable, since the amount of ingredients in the system will increase exponentially with the number of recipes, but it is a good starting point for the sake of time.

In the optimal scenario, the entities would be related by a many-to-many relationship, where each ingredient could be used in multiple recipes. This would allow for better management of the database, but it would also require more complex queries and data structures.

### To-do

- For a production-ready application, it would be necessary to implement Authentication and Authorization to protect the endpoints and ensure that only authorized users can access the data.

- It would also be necessary to implement integration and unit tests to ensure that the application works as expected and to catch any bugs before deploying to production.

- It would be necessary to optimize queries and create indexes to improve performance.
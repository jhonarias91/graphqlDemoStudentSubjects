
# GraphQL Demo: Student and Subjects Management

This project demonstrates the implementation of a **GraphQL server** and a **GraphQL client** using **Spring Boot** with **WebFlux**. It provides APIs to manage student data and their associated subjects, showcasing both query and mutation operations.

## Features

- **GraphQL Server**:
  - Fetch student details with associated subjects.
  - Create a new student with custom learning subjects.

- **GraphQL Client**:
  - Uses `HttpGraphQlClient` to interact with the server.
  - Demonstrates reactive programming with `Mono` and `Flux`.

## Technologies

- **Spring Boot**
- **Spring WebFlux**
- **GraphQL Java**
- **HttpGraphQlClient**
- **Reactor (Mono/Flux)**

## How to Run

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/jhonarias91/graphqlDemoStudentSubjects.git
   cd graphqlDemoStudentSubjects
   ```

2. **Build the Project**: Ensure you have **Java 17+** and **Maven** installed.
   ```bash
   mvn clean install
   ```

3. **Run the Application**: Start the application with:
   ```bash
   mvn spring-boot:run
   ```

4. **Test the GraphQL Server**: Open a browser or tool like **GraphQL Playground** at:
   ```
   http://localhost:8080/graphql
   ```

5. **Fetch student by ID**:
   ```graphql
   query {
     findStudent(id: 1) {
       id
       firstName
       lastName
       email
       learningSubjects {
         subjectName
         marksObtained
       }
     }
   }
   ```

6. **Create a new student**:
   ```graphql
   mutation {
     createStudent(student: {
       firstName: "John",
       lastName: "Doe",
       email: "john.doe@example.com",
       city: "New York",
       street: "5th Avenue",
       learningSubjects: [
         { subjectName: "Math", marksObtained: 90.0 },
         { subjectName: "Science", marksObtained: 85.0 }
       ]
     }) {
       id
       fullName
     }
   }
   ```

7. **Client Example**: The client (`StudentService`) demonstrates fetching a student by ID and creating a new student programmatically.

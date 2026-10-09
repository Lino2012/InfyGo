# InfyGo – Flight Booking REST API

InfyGo is a Spring Boot REST API application designed to manage flight searches, user registration, authentication, ticket booking, and payment processing. It uses Spring Data JPA and Hibernate for database operations and MySQL for persistent storage.

## Features

The application provides the following functionalities:

1. **User Registration** – Register new users and store their details.
2. **User Login** – Validate user login credentials.
3. **View Flight Sources** – Retrieve available flight departure locations.
4. **View Flight Destinations** – Retrieve available flight destination locations.
5. **Search Flights** – Search for flights based on source, destination, and journey date.
6. **Book Tickets** – Book a flight for a registered user, store passenger details, generate a PNR, and update seat availability.
7. **Process Payments** – Validate payment details and store payment/card information.

## Technologies Used

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate ORM
- MySQL
- Maven
- Postman
- Eclipse / Spring Tool Suite (STS)

## Project Architecture

The application follows a layered architecture:

- **Controller Layer** – Handles incoming HTTP requests and returns REST responses.
- **Service Layer** – Implements application business logic.
- **Repository Layer** – Performs database operations using Spring Data JPA.
- **Entity Layer** – Represents database tables, such as users, flights, bookings, passengers, and card details.
- **Database Layer** – Stores application data in MySQL.

The actual package names and class structure depend on the implementation in the project.

## Prerequisites

Ensure the following are installed:

- JDK 17 or a compatible version matching the project configuration
- Maven
- MySQL Server
- Eclipse or Spring Tool Suite
- Postman

## Database Setup

Create the MySQL database before running the application:

```sql
CREATE DATABASE infygo;
```

Configure your database connection in `src/main/resources/application.properties`.

Example configuration:

```properties
server.port=8086
server.servlet.context-path=/InfyGo

spring.datasource.url=jdbc:mysql://localhost:3306/infygo
spring.datasource.username=${DB_USERNAME:root}
spring.datasource.password=${DB_PASSWORD}
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

**Configuration notes:**

- Change the port and context path if your existing project uses different values.
- Set the `DB_PASSWORD` environment variable to your MySQL password.
- If your application already runs successfully with a different database configuration, retain those working settings.
- `spring.jpa.hibernate.ddl-auto=update` allows Hibernate to update the database schema based on mapped entities. Review this setting before using the application in production.
- Avoid committing real database passwords or other secrets to Git.

## API Base URL

When running locally with the example configuration above, the base URL is:

```text
http://localhost:8086/InfyGo
```

## API Endpoints

The following endpoint paths correspond to the project's required operations. HTTP methods and request formats should match the implemented controllers.

| Functionality | Method | Endpoint |
|---|---|---|
| User registration | POST | `/infygo/register` |
| User login | POST | `/infygo/login` |
| Get flight sources | GET | `/infygo/flights/sources` |
| Get flight destinations | GET | `/infygo/flights/destinations` |
| Search flights | GET | Flight search endpoint configured in the controller |
| Book a ticket | POST | `/infygo/book/{FlightId}/{UserId}` |
| Process payment | POST | `/infygo/payment` |

Replace any endpoint path or HTTP method in this table if your controller mappings differ.

## Testing with Postman

1. Start the MySQL server.
2. Create the `infygo` database.
3. Open the project in Eclipse or Spring Tool Suite.
4. Verify the database configuration.
5. Run the Spring Boot application.
6. Open Postman.
7. Send requests to the API using the configured base URL.
8. Test registration and login before testing operations that require an existing user.
9. Search for available flights using a valid source, destination, and journey date.
10. Book a flight using a valid flight ID and user ID.
11. Verify that the booking, PNR, and available-seat count are updated as expected.
12. Test payment validation with valid and invalid request data.

## Running the Application

### Using Eclipse / Spring Tool Suite

1. Import the project as an existing Maven project.
2. Wait for Maven dependencies to finish downloading.
3. Configure MySQL credentials.
4. Run the main Spring Boot application class.
5. Check the console for startup errors.

### Using Maven

Run these commands from the directory containing `pom.xml`:

```bash
mvn clean install
mvn spring-boot:run
```

## Database Tables

The application uses entity mappings to manage its database tables. Depending on the implemented entities, these may include:

- User details
- Flight details
- Booking and ticket details
- Passenger details
- Card or payment details

The actual table names and columns are determined by the entity mappings and database configuration.

## Author

Developed as a Spring Boot REST API project to demonstrate flight search, ticket booking, database persistence, and payment processing.

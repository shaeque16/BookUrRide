# BookUrRide

BookUrRide is a ride-booking application developed using Spring Boot. It provides secure and efficient ride-booking services with features like JWT-based authentication, role-based access control, and optimized database interactions.

# Features
Secure Authentication: Implements JWT-based authentication for user login and session management.

Role-Based Access Control (RBAC): Ensures that access to resources is restricted based on user roles (e.g., Admin, Rider, Driver).

Scalable Architecture: Modular design with clear separation of concerns for scalability and maintainability.

RESTful APIs: Provides easy-to-use endpoints for managing rides, users, and other resources.

# Technologies Used

Backend: Java 21, Spring Boot, Spring Security, Hibernate
Database: PostgreSQL
Authentication: JWT (JSON Web Tokens)
Build Tool: Maven

# API Endpoint

Authentication

POST /auth/signup - For registering a user

POST /auth/login - For authenticate and get JWT

POST /auth/onBoardNewDriver/{userId} - To onboard new driver (only admin have access)

Driver

POST /driver/ - Only driver role can check this endpoint

Rider

POST /rider/ - Only rider role can check this endpoint


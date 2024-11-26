
🛠️ Getting Started
Prerequisites
To set up and run this application, ensure you have:

Java (JDK 17 or later)
Maven (v3.6+)
A running instance of PostgreSQL/MySQL
Installation
Clone the repository:


git clone https://github.com/<your-username>/craft.git  
Navigate to the project directory:


cd craft  
Configure the database:

Update the application.properties or application.yml file with your database credentials.
properties

spring.datasource.url=jdbc:postgresql://localhost:5432/craft  
spring.datasource.username=<your-username>  
spring.datasource.password=<your-password>  
Build the project:


mvn clean install  
Run the application:

mvn spring-boot:run  
Access the API:

The backend will run on http://localhost:8080 by default.
Swagger API docs can be accessed at http://localhost:8080/swagger-ui.html.
📄 API Documentation
All API endpoints are documented using Swagger/OpenAPI.

Base URL: http://localhost:8080/api/v1
Endpoints Include:
/register: Handles user registration and account creation.
/authenticate: Allows users to log in and obtain JWT tokens for authentication.
/admin/viewallendpoints: Provides a list of all available API endpoints (restricted to admin access).
/tutor/material: Enables tutors to manage and upload teaching materials (e.g., documents, videos).
/tutor/viewalltutors: Fetches a list of all registered tutors.
/admin/settings: Allows admins to view and update application settings.
/admin/manage: Facilitates management tasks like user moderation, project approvals, and general oversight.
🛡️ Security
Authentication: Uses JWT tokens for secure and stateless sessions.
Authorization: Implements role-based access control (RBAC) to ensure appropriate resource access.
🌍 Why Craft Backend?
The Craft backend is designed to provide a seamless, scalable, and secure foundation for the DIY learning platform. With a focus on efficiency and modern practices, it enables rich interactions between the frontend and the server to deliver an exceptional user experience.

Together, let’s empower creativity and learning! 🎓✨

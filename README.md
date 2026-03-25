Task Management Application

A simple Spring Boot-based web application that allows users to register, log in, and manage their personal tasks.

--------------------------------------------------

Features:
- User registration and login
- Session-based authentication
- Create and view tasks
- Update task details and duration
- Update user profile (username, email, password)
- Logout functionality

--------------------------------------------------

Tech Stack:
- Backend: Java, Spring Boot, Spring MVC
- Frontend: JSP
- Build Tool: Maven
- Database: PostgreSQL

--------------------------------------------------

Project Structure:

src/main/java/com/project1/task_management_app/
    controller/
    service/
    repository/
    dao/
    entity/
    model/
    dto/
    exception/

Main Classes:
    TaskManagementAppApplication.java
    ServletInitializer.java

--------------------------------------------------

User Endpoints:

GET     /welcome                      - Landing page
GET     /register                     - Show registration page
POST    /register                     - Register user
GET     /login                        - Show login page
POST    /login                        - Login user
GET     /home                         - User dashboard
GET     /settings                     - Settings page
POST    /settings/updatePassword      - Update password
POST    /settings/updateUsername      - Update username
POST    /settings/updateEmail         - Update email
GET     /logout                       - Logout user

--------------------------------------------------

Task Endpoints:

GET     /showTasks        - Show all tasks
GET     /saveTask         - Show task form
POST    /saveTask         - Save new task
POST    /updateData       - Update task data
POST    /updateDuration   - Update task duration

--------------------------------------------------

Installation:

git clone https://github.com/arnabsarma-29/Task-Management.git
cd Task-Management
mvn clean install

--------------------------------------------------

Run Application:

mvn spring-boot:run

Open in browser:
http://localhost:8080/welcome

--------------------------------------------------

Key Concepts:
- MVC architecture
- Session management
- DTO pattern
- Exception handling
- Layered architecture

--------------------------------------------------

Notes:
- Configure your database in application.properties
- Session is required for protected routes
- Updating password logs the user out

--------------------------------------------------

Author:
https://github.com/arnabsarma-29

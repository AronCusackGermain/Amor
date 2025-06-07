# Birthday Celebration App

## Overview
The Birthday Celebration App is a Spring Boot application designed to manage birthday celebrations. It allows users to create and manage guest lists, and serves a beautiful HTML page for the celebration.

## Project Structure
```
birthday-celebration-app
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── example
│   │   │           └── birthday
│   │   │               ├── BirthdayCelebrationApp.java
│   │   │               ├── controller
│   │   │               │   └── BirthdayController.java
│   │   │               ├── model
│   │   │               │   └── Guest.java
│   │   │               └── repository
│   │   │                   └── GuestRepository.java
│   │   └── resources
│   │       ├── static
│   │       ├── templates
│   │       │   └── birthday.html
│   │       └── application.properties
│   └── test
│       └── java
│           └── com
│               └── example
│                   └── birthday
│                       └── BirthdayCelebrationAppTests.java
├── pom.xml
└── README.md
```

## Setup Instructions
1. **Clone the repository**:
   ```
   git clone <repository-url>
   cd birthday-celebration-app
   ```

2. **Build the project**:
   ```
   mvn clean install
   ```

3. **Run the application**:
   ```
   mvn spring-boot:run
   ```

4. **Access the application**:
   Open your web browser and navigate to `http://localhost:8080`.

## Usage
- The application serves a birthday celebration page where users can view and manage guest information.
- Guests can be added, updated, or removed through the provided interface.

## Technologies Used
- Java
- Spring Boot
- Thymeleaf (for HTML templating)
- Maven (for project management)

## Contributing
Contributions are welcome! Please feel free to submit a pull request or open an issue for any enhancements or bug fixes.
# Task Tracker Application

A Spring Boot application built following the [roadmap.sh Task Tracker](https://roadmap.sh/projects/task-tracker) project specification.

### About

This project is an implementation of the Task Tracker project from roadmap.sh. It provides a command-line interface for managing tasks with features to add, update, delete, and track task status.

### Prerequisites

- Java 11 or higher
- Maven 3.6.0 or higher
- Spring Boot 2.x or higher

### Getting Started

#### 1. Clone the Repository

```bash
git clone https://github.com/mohamed-zakariya/springboot-projects.git
cd springboot-projects
```

#### 2. Checkout the Task Tracker Branch

```bash
git checkout taskTracker-app
```

#### 3. Build the Project

```bash
mvn clean install
```

#### 4. Run the Application

```bash
mvn spring-boot:run
```

Or run the packaged JAR:

```bash
java -jar target/springboot-projects-1.0.0.jar
```

### Project Structure

```
springboot-projects/
├── src/
│   ├── main/
│   │   ├── java/
│   │   └── resources/
│   └── test/
├── pom.xml
└── README.md
```

### Features

- Add new tasks
- Update existing tasks
- Delete tasks
- View all tasks
- Track task status (TODO, IN_PROGRESS, DONE)

### Usage Examples

Once the application is running, you can interact with it through the command-line interface or API endpoints.

### Technologies Used

- Spring Boot
- Spring Framework
- Java
- Maven

### Original Project Reference

This implementation follows the specifications and requirements from:
[https://roadmap.sh/projects/task-tracker](https://roadmap.sh/projects/task-tracker)

### Contributing

Feel free to fork this repository and submit pull requests for any improvements.

### License

This project is open source and available under the MIT License.

---

For more information about the original task tracker project, visit [roadmap.sh/projects/task-tracker](https://roadmap.sh/projects/task-tracker)

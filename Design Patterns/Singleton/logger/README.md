# Application Configuration Manager (Singleton Design Pattern)

A Spring Boot application that demonstrates the **Singleton Design Pattern**. This project simulates a global configuration manager where multiple distinct clients (User Controller and Admin Controller) share the exact same instance and data state.

## 📖 Project Overview

[Image of Singleton Design Pattern structure]

**The Problem:**
In many systems, you need a single object to coordinate actions across the entire application (e.g., a Logger, Database Connection Pool, or Configuration Manager).
If you create a `new AppConfig()` every time a user makes a request:
1. You waste memory.
2. You lose data consistency (User A's counter won't match Admin B's view).

**The Solution:**
The **Singleton Pattern** ensures a class has only **one instance** and provides a global point of access to it.
* **Private Constructor:** No one can say `new AppConfig()`.
* **Static Instance:** The class holds its own single instance.
* **Static Accessor:** Everyone calls `AppConfig.getInstance()`.

## 🛠️ Tech Stack

* **Language:** Java 17+
* **Framework:** Spring Boot 3.x
* **Build Tool:** Maven
* **Concepts:** Creational Design Patterns, Thread Safety, Static Members

## 📂 Project Structure

```text
src/main/java/com/gautam/singleton/
│
├── service/
│   └── AppConfig.java        # <--- The Singleton Class (Manual Implementation)
│
├── controller/
│   ├── UserController.java   # <--- Client 1 (Writes data)
│   └── AdminController.java  # <--- Client 2 (Reads shared data)
│
└── SingletonApplication.java
```

### 🚀 How to Run

Prerequisites
* Java Development Kit (JDK) 17 or higher
* Maven

Steps
1. Clone the repository
   ```bash
   git clone https://github.com/Astrogeek77/Spring_boot_projects.git
   cd Spring_boot_projects
   ```
2. Build the project
   ```bash
   mvn clean install
   ```
3. Run the application
   ```bash
   mvn spring-boot:run
   ```
4. **Test the Pattern** Check the console logs immediately after startup. You will not see "Instance Created" yet (Lazy Loading).

### 📡 API Reference

1. User Access (Write Operation)
Simulates a user connecting to the app. This increments the connection counter inside the Singleton.
* URL: /user/access
* Method: GET
* Response:
```
User accessed. Total Connections: 1
```
2. Admin Access (Read Operation)
Simulates an admin checking the system status. This verifies that the Admin sees the changes made by the User.
* URL: /admin/stats
* Method: GET
* Response:
```
Admin Report: Current Connections = 1
```
## 🧠 Singleton Pattern Implementation Details

1.  **Private Constructor**:
    The most critical part. We hide the constructor so no other class can instantiate it.
    ```java
    private AppConfig() {
        System.out.println("Instance Created");
    }
    ```

2.  **Lazy Initialization**:
    The object is not created when the application starts. It is created only when the **first** request comes in.
    ```java
    public static synchronized AppConfig getInstance() {
        if (instance == null) {
            instance = new AppConfig(); // Created only once
        }
        return instance;
    }
    ```

3.  **Thread Safety (`synchronized`)**:
    We add the `synchronized` keyword to the method. This prevents a "Race Condition" where two users hitting the API at the exact same millisecond might accidentally create two instances.

---
Created for learning the Singleton Design Pattern in Java Spring Boot.

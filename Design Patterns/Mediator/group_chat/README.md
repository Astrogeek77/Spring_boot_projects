# Group Chat System (Mediator Design Pattern)

A Spring Boot application that demonstrates the **Mediator Design Pattern**. This project simulates a chat room where users communicate through a central "Hub" (the Mediator) rather than sending messages directly to each other, reducing dependency chaos.

## 📖 Project Overview



**The Problem: The "Many-to-Many" Complexity**
Imagine a system with 5 components that all need to talk to each other.
* If User A wants to speak, they need references to User B, C, D, and E.
* As the number of users grows, the connections grow exponentially (Mesh Network topology).
* This creates **tight coupling**; you can't change one user without breaking others.

**The Solution:**
The **Mediator Pattern** introduces a central interface (the Mediator) that encapsulates how a set of objects interact.
* **Star Topology:** Users only know about the Mediator.
* **Decoupling:** User A sends a message to the Mediator. The Mediator decides who receives it (B, C, D, etc.).

## 🛠️ Tech Stack

* **Language:** Java 17+
* **Framework:** Spring Boot 3.x
* **Build Tool:** Maven
* **Concepts:** Behavioral Design Patterns, Decoupling, Centralized Control

## 📂 Project Structure

```text
src/main/java/com/gautam/mediator/
│
├── mediator/                 # The "Hub"
│   ├── ChatMediator.java     # Interface (Defines the contract)
│   └── GroupChat.java        # Concrete Logic (Routes messages)
│
├── colleague/                # The "Participants"
│   ├── User.java             # Abstract Class (Holds reference to Mediator)
│   └── ChatUser.java         # Concrete Class (Sends/Receives)
│
├── controller/
│   └── ChatController.java   # Simulates the chat session
│
└── MediatorApplication.java
```
## 🚀 How to Run

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
   mvn spring-boot: run
   ```
4. **Test the Endpoint** Open your browser or Postman and go to:
``` http://localhost:8080/api/mediator/chat ```

## 📡 API Reference

### Run Chat Simulation
Executes a pre-defined script where users join a room and exchange messages. This endpoint triggers the internal logic to demonstrate how the Mediator routes messages.

* **URL:** `/api/mediator/chat`
* **Method:** `GET`
* **Response:**
    ```text
    Check Console Logs for Chat History
    ```

### Console Output
Check your terminal to see the routing logic in action. Notice that when "Alice" sends a message, she does **not** call `bob.receive()`. She simply calls `mediator.sendMessage()`.

```text
-----------------------------------
Alice Sending: Hello everyone! Is the meeting at 4?
Bob Received: Hello everyone! Is the meeting at 4?
Charlie Received: Hello everyone! Is the meeting at 4?
Diana Received: Hello everyone! Is the meeting at 4?
-----------------------------------
Charlie Sending: Yes Alice, see you there.
Alice Received: Yes Alice, see you there.
Bob Received: Yes Alice, see you there.
Diana Received: Yes Alice, see you there.
```

## 🧠 Mediator Pattern Implementation Details

1.  **The Colleague (`User.java`)**:
    Users hold a reference to the Mediator interface, but **not** to other users. This isolates the user classes from each other.
    ```java
    protected ChatMediator mediator;
    
    public void send(String msg) {
        // "I don't know who is in the room, I just tell the room."
        mediator.sendMessage(msg, this);
    }
    ```

2.  **The Mediator (`GroupChat.java`)**:
    The complex logic of *who gets the message* lives entirely here. This keeps the User classes clean and lightweight.
    ```java
    @Override
    public void sendMessage(String msg, User sender) {
        for (User u : this.users) {
            // Logic: Send to everyone EXCEPT the sender
            if (u != sender) {
                u.receive(msg);
            }
        }
    }
    ```

3.  **Simplified Maintenance**:
    Because the communication logic is centralized, if you want to add a "Private Message" feature or a "Kick User" feature,
    you only modify the `GroupChat` class. You do not need to touch the `ChatUser` code or worry about breaking connections
    between specific users.

---
Created for learning the Mediator Design Pattern in Java Spring Boot.

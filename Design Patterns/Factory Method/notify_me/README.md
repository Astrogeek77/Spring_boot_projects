# NotifyMe: Multi-Channel Notification Service 🔔

> A decoupled notification system demonstrating the **Factory Method Design Pattern** to dynamically select delivery channels (Email, SMS, Push) at runtime.

## 📖 Project Overview
**NotifyMe** is a backend service designed to handle user notifications across multiple platforms.

In a tightly coupled system, the main business logic would contain complex `if-else` blocks instantiating specific classes like `new SMSNotification()`. This project solves that tight coupling by implementing the **Factory Method Pattern**, allowing the application to ask for a "Notification" without needing to know the implementation details.

## 🏗️ Design Pattern: Factory Method
The core concept is to define an interface for creating an object, but let subclasses or a dedicated Factory decide which class to instantiate.

### Key Components
1.  **`Notification` (Interface):** Defines the common contract (`notifyUser`) that all channels must follow.
2.  **`EmailNotification` / `SMSNotification`:** Concrete implementations of the interface.
3.  **`NotificationFactory`:** The "Decision Maker." It accepts a parameter (e.g., "SMS") and returns the correct object instance.
4.  **`NotificationService`:** The Client. It depends *only* on the Interface and Factory, keeping it 100% decoupled from concrete logic.

## 🚀 Key Features
* **Loose Coupling:** The Service layer has zero knowledge of how notifications are sent.
* **Extensibility:** Adding a new channel (e.g., "Slack") requires creating one class and updating the Factory switch case—no changes to the Service or Controller are needed.
* **Centralized Logic:** Object creation logic is centralized in one place (The Factory), making maintenance easy.

## 🛠️ Tech Stack
* **Core:** Java 21, Spring Boot 3.x
* **Architecture:** Factory Method Design Pattern
* **Build Tool:** Maven

## 🏃 How to Run

1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/yourusername/notifyme.git](https://github.com/yourusername/notifyme.git)
    ```
2.  **Run the application:**
    ```bash
    mvn spring-boot:run
    ```
3.  The server will start on `http://localhost:8080`.

## 🔌 API Endpoints (Testing Guide)

### 1. Send Email
* **Request:** `POST /api/notify?type=EMAIL&message=Welcome+Aboard`
* **Console Output:** `📧 Sending EMAIL: Welcome Aboard`

### 2. Send SMS
* **Request:** `POST /api/notify?type=SMS&message=Your+OTP+is+1234`
* **Console Output:** `📱 Sending SMS: Your OTP is 1234`

### 3. Invalid Channel (Error Handling)
* **Request:** `POST /api/notify?type=FAX&message=Hello`
* **Result:** `500 Internal Server Error` (IllegalArgumentException: Unknown channel: FAX)

## 📝 Resume Summary
* **NotifyMe Service:** Implemented the **Factory Method Design Pattern** to decouple notification logic from the main application flow.
* **Architecture:** Achieved adherence to the **Open/Closed Principle**; new notification channels can be added with zero changes to existing Service business logic.

---
*Created by Gautam Jain to demonstrate Clean Code principles in Spring Boot.*

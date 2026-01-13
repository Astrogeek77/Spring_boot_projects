# Office Internet Firewall (Proxy Design Pattern)

A Spring Boot application that demonstrates the **Proxy Design Pattern**. This project simulates a corporate internet firewall where a "Proxy" stands between the employee and the real internet to filter out banned websites (like Facebook or TikTok) during work hours.

## 📖 Project Overview



**The Problem:**
Imagine you have a class `RealInternet` that connects to any website.
* If you give this class directly to employees, they can surf social media all day.
* Modifying the complex `RealInternet` class to add filtering logic violates the **Single Responsibility Principle** (it should only know how to connect, not how to police users).

**The Solution:**
The **Proxy Pattern** provides a surrogate or placeholder for another object to control access to it.
* **The Interface:** Both the Real object and the Proxy implement `Internet`.
* **The Proxy:** Intercepts the request. If the site is allowed, it passes the request to the `RealInternet`. If banned, it blocks it.

## 🛠️ Tech Stack

* **Language:** Java 17+
* **Framework:** Spring Boot 3.x
* **Build Tool:** Maven
* **Concepts:** Structural Design Patterns, Access Control, Delegation

## 📂 Project Structure

```text
src/main/java/com/gautam/proxy/
│
├── service/
│   ├── Internet.java         # <--- The Common Interface
│   ├── RealInternet.java     # <--- The Actual Service (Heavy lifter)
│   └── ProxyInternet.java    # <--- The Gatekeeper (Security logic)
│
├── controller/
│   └── InternetController.java
│
└── ProxyApplication.java
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
``` http://localhost:8080/api/proxy/browse?site=google.com ```

## 📡 API Reference

### Browse Internet
Simulates a user trying to access a website. The Proxy intercepts this request to check the URL against a banned list before deciding whether to complete the connection.

* **URL:** `/api/proxy/browse`
* **Method:** `GET`
* **Query Param:** `site` (e.g., `google.com`, `facebook.com`)

#### Scenario 1: Allowed Site
If the site is safe (e.g., `google.com`), the Proxy delegates the work to the Real Internet service.

* **Response:**
    ```json
    ["SUCCESS: Connected to google.com"]
    ```
* **Console Output:**
    ```text
    Connecting to google.com
    ```

#### Scenario 2: Banned Site
If the site is blacklisted (e.g., `facebook.com`), the Proxy blocks the request immediately. The Real Internet service is **never** called.

* **Response:**
    ```json
    ["BLOCKED: Access Denied: This site is blocked by corporate firewall."]
    ```
* **Console Output:**
    ```text
    Access Denied to facebook.com
    ```

## 🧠 Proxy Pattern Implementation Details

1.  **The Common Interface (`Internet.java`)**:
    This is crucial. By implementing the same interface, the Proxy looks exactly like the Real object to the client code. The client doesn't know (or care) that it is talking to a proxy instead of the real service.
    ```java
    public interface Internet {
        void connectTo(String host) throws Exception;
    }
    ```

2.  **The Protection Proxy (`ProxyInternet.java`)**:
    The proxy adds a layer of security logic *before* delegating to the real object. It acts as a gatekeeper.
    ```java
    @Override
    public void connectTo(String host) throws Exception {
        // 1. Security Check
        if (bannedSites.contains(host)) {
            throw new Exception("Access Denied");
        }
        
        // 2. Delegation to Real Object (only if check passes)
        realInternet.connectTo(host);
    }
    ```

3.  **Separation of Concerns**:
    The `RealInternet` class stays clean and focused purely on networking logic.
    It doesn't need to know about corporate policies, banned lists, or user permissions.
     All that "administrative" logic is isolated inside the `ProxyInternet`.

---
Created for learning the Proxy Design Pattern in Java Spring Boot.

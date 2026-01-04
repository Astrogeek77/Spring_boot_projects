## Social Media Aggregator (Adapter Pattern Implementation)
A Spring Boot application that demonstrates the Adapter Design Pattern. 
This project simulates fetching data from multiple disparate social media platforms (Twitter, Facebook) and unifying them into a single, consistent data format for the client application.

### 📖 Project Overview

* The Problem: In a real-world scenario, different social media platforms provide APIs with different structures (e.g., Twitter uses tweet_text while Facebook uses status). Consuming these directly makes the application code messy and tightly coupled to specific providers.
* The Solution: We use the Adapter Pattern to create a bridge.
  * Target Interface: A common SocialMediaAdapter interface that the app understands.
  * Adapters: Classes (TwitterAdapter, FacebookAdapter) that translate the external API data into a unified format (UnifiedPost).
  * Client: The application calls the common interface, unaware of the specific platform logic behind it.

### 🛠️ Tech Stack

* Language: Java 17+
* Framework: Spring Boot 3.x
* Build Tool: Maven
* Concepts: Dependency Injection, Adapter Design Pattern, REST APIs

### 📂 Project Structure

```
src/main/java/com/gautam/socialaggregator/
│
├── adapter/                  # The "Bridge" Layer
│   ├── SocialMediaAdapter.java   # <--- The Common Interface (Target)
│   ├── TwitterAdapter.java       # <--- Adapter for Twitter
│   └── FacebookAdapter.java      # <--- Adapter for Facebook
│
├── external/                 # The "Incompatible" Layer (Simulated 3rd Party APIs)
│   ├── TwitterApi.java
│   └── FacebookApi.java
│
├── model/
│   └── UnifiedPost.java      # The Unified Data Model
│
├── service/
│   └── SocialAggregatorService.java  # Aggregates data from all adapters
│
├── controller/
│   └── FeedController.java   # Exposes the data via REST
│
└── SocialAggregatorApplication.java
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
4. Access the Feed Open your browser or Postman and go to: http://localhost:8080/api/feed

### 📡 API Reference

Get Aggregated Feed
Returns a unified list of posts from all connected platforms.
* URL: /api/feed
* Method: GET
* Response Example:
  ```json
  [
    {
      id: "fb100",
      originalPlatform: "Facebook",
      author: "MetaUser",
      content: "Just updated my status",
      timestamp: "2026-01-04T21:08:08.2203311"
    },
    {
      id: "In101",
      originalPlatform: "Instagram",
      author: "Astrogeek",
      content: "Hey I am New on Insta",
      timestamp: "2026-01-04T21:08:08.2203311"
    },
    {
      id: "tw1",
      originalPlatform: "Twitter",
      author: "@dev_gautam",
      content: "Spring Boot is awesome!",
      timestamp: "2026-01-04T21:08:08.2203311"
    }
  ]
  ```

###  🧠 Design Pattern Implementation Details
1. The Interface (SocialMediaAdapter): Defines the contract: List<UnifiedPost> fetchPosts().
2. The Adapters:
  * TwitterAdapter: Inject TwitterApi, calls getTweets(), maps tweet_text -> content.
  * FacebookAdapter: Injects FacebookApi, calls getFacebookPosts(), maps status -> content.
3. Spring Dependency Injection: The service class asks for a list of adapters:
```java
public SocialAggregatorService(List<SocialMediaAdapter> adapters) { ... }
```
Spring automatically finds all classes implementing the interface and injects them. 
This makes the system Open/Closed Principle compliant—to add Instagram, you only need to create an InstagramAdapter,
and you don't need to change the Service code at all.

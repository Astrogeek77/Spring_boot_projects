# Legion: High-Efficiency Game Entity Manager ⚔️

> A memory-optimized backend service demonstrating the **Flyweight Design Pattern** to handle massive object scaling with minimal RAM footprint.

## 📖 Project Overview
**Legion** is a backend simulation of an MMORPG game engine designed to spawn thousands of Non-Player Characters (NPCs). 

In traditional "naive" implementations, creating 10,000 soldiers means loading 10,000 textures and sound files into memory, leading to `OutOfMemoryError` crashes. This project solves that scalability bottleneck by implementing the **Flyweight Pattern**, separating heavy, shared data from unique per-instance data.

## 🏗️ Design Pattern: Flyweight
The core concept is to share common state between multiple objects.

[Image of flyweight design pattern diagram showing shared state vs unique state]

### Key Concepts Implemented
1.  **Intrinsic State (Shared):** Data that remains constant across all instances (e.g., Texture, 3D Model, Sound). Stored in the `NpcType` class.
2.  **Extrinsic State (Unique):** Data that changes per instance (e.g., X/Y Coordinates, Health). Stored in the `Soldier` class.
3.  **Flyweight Factory:** A caching mechanism (`NpcFactory`) that ensures only **one** instance of each `NpcType` is ever created in memory, regardless of how many soldiers are spawned.

## 🚀 Key Features
* **Memory Optimization:** Reduces RAM usage drastically. Spawning 10,000 "Orcs" creates only **1** heavy `NpcType` object instead of 10,000.
* **Factory Caching:** Implements a `HashMap` cache to intercept object creation requests, returning existing instances (Cache Hits) instantly.
* **Scalability:** Demonstrates how game servers and graphical applications scale to handle massive entity counts.

## 🛠️ Tech Stack
* **Core:** Java 21, Spring Boot 3.x
* **Architecture:** Flyweight Design Pattern
* **Build Tool:** Maven

## 🏃 How to Run

1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/yourusername/legion.git](https://github.com/yourusername/legion.git)
    ```
2.  **Run the application:**
    ```bash
    mvn spring-boot:run
    ```
3.  The server will start on `http://localhost:8080`.

## 🔌 API Endpoints (Testing Guide)

### 1. Spawn Army (Simulation)
* **Request:** `GET /api/game/spawn`
* **Result:** `Army Spawned! Check Console Logs for Memory Optimization.`
* **Console Output (Proof of Optimization):**
    ```text
    --- Starting Simulation ---
    Creation: Loading heavy assets for [Orc]...  <-- Loaded ONCE (Intrinsic)
    Cache Hit: Returning existing [Orc]          <-- Reused (Flyweight)
    Cache Hit: Returning existing [Orc]          <-- Reused (Flyweight)
    Creation: Loading heavy assets for [Elf]...  <-- Loaded ONCE (Intrinsic)
    Cache Hit: Returning existing [Elf]          <-- Reused (Flyweight)
    --- Rendering Frame ---
    Rendering Orc at (0,0) using texture GreenSkin.png
    Rendering Orc at (10,5) using texture GreenSkin.png
    ```
## 📝 Resume Summary
* **Legion Game Engine:** Implemented the **Flyweight Design Pattern** to optimize memory usage for high-volume object creation.
* **Performance:** Reduced memory footprint by separating **Intrinsic State** (shared assets) from **Extrinsic State** (unique coordinates), allowing the system to scale to thousands of entities with minimal RAM overhead.

---
*Created by Gautam Jain to demonstrate Memory Optimization Patterns in Java.*    

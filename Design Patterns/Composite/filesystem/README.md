# File System Manager (Composite Pattern Implementation)

A Spring Boot application that demonstrates the **Composite Design Pattern**. This project simulates a hierarchical file system where individual items (Files) and containers (Folders) are treated uniformly, allowing for recursive operations like calculating the total size of a nested directory tree.

## 📖 Project Overview



**The Problem:**
In hierarchical systems (like file systems, organizational charts, or menus), you have "Leaf" objects (Files) and "Composite" objects (Folders).
Without the Composite pattern, the client code becomes messy. You have to check types constantly:
> *"If this is a Folder, loop through it. If it's a File, just get the size. Oh wait, if the Folder contains another Folder, I need another loop..."*

**The Solution:**
We use the **Composite Pattern** to create a tree structure.
* **Component (`FileSystemItem`):** A common interface for both Files and Folders.
* **Leaf (`File`):** Implements the logic for individual items.
* **Composite (`Folder`):** Implements the logic to manage children and delegates operations recursively.
* **Result:** The client can call `root.getSize()` without knowing or caring how deep the folder structure goes.

## 🛠️ Tech Stack

* **Language:** Java 17+
* **Framework:** Spring Boot 3.x
* **Build Tool:** Maven
* **Concepts:** Structural Design Patterns, Recursion, Polymorphism

## 📂 Project Structure

```text
src/main/java/com/gautam/filesystem/
│
├── component/                # The Common Interface
│   └── FileSystemItem.java   # <--- The contract (getName, getSize)
│
├── model/                    # The Concrete Classes
│   ├── File.java             # <--- The Leaf (Ends the tree)
│   ├── Folder.java           # <--- The Composite (Has children)
│
├── controller/
│   └── FileSystemController.java   # Builds the tree and tests it
│
└── FileSystemApplication.java
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
   mvn spring-boot: run
   ```
4. Test the Pattern Open your browser or Postman and go to:
   http://localhost:8080/api/filesystem

## 📡 API Reference

### Get File System Stats
Constructs a demo file tree (Root -> Music -> Songs) and calculates the total size recursively.

* **URL:** `/api/filesystem`
* **Method:** `GET`
* **Response:**
    ```text
    Root Folder Size: 2022 KB. (Check console for tree structure)
    ```

### Console Output
When you hit the API, check your terminal to see the Composite Pattern in action:
```text
--- FILE SYSTEM STRUCTURE ---
Folder: Root (Total Size: 2022KB)
  - File: Avengers.mp4 (2000KB)
Folder: Music (Total Size: 22KB)
  - File: ShapeOfYou.mp3 (10KB)
  - File: Believer.mp3 (12KB)

```

## 🧠 Composite Pattern Implementation Details

1.  **The Interface (`FileSystemItem`)**:
    Treats everything as an "Item". This is the key abstraction that allows the client to handle both simple files and complex folders using the same code.
    ```java
    public interface FileSystemItem {
        int getSize();
    }
    ```

2.  **The Recursion (`Folder.java`)**:
    The magic happens here. The folder iterates through its children list. It doesn't care if a child is a `File` or another `Folder`; it just calls `.getSize()` on it. This allows the calculation to cascade down the entire tree automatically.
    ```java
    public int getSize() {
        int total = 0;
        for (FileSystemItem item : children) {
            total += item.getSize(); // <--- Polymorphism + Recursion
        }
        return total;
    }
    ```

3.  **The Client Simplification**:
    Without the Composite pattern, the client would need complex loops and type checks (`instanceof Folder`). With the pattern, the client code is clean:
    ```java
    // Simple call regardless of complexity
    int totalSize = rootFolder.getSize();
    ```

---

Created for learning the Composite Design Pattern in Java Spring Boot.

# 🏰 Atlas‑Guild

A collaborative automation framework designed for web testing using **Java**, **Selenium WebDriver**. This project follows modern best practices—data-driven test execution.

---

## 🔹 Table of Contents

- [Overview](#overview)  
- [Features](#features)  
- [Tech Stack](#tech-stack)  
- [Prerequisites](#prerequisites)  
- [Getting Started](#getting-started)  
- [Project Structure](#project-structure)  
- [How to Run Tests](#how-to-run-tests)  
- [Extending the Framework](#extending-the-framework)  
- [Contributors](#contributors)  

---

## 🧭 Overview

**Atlas‑Guild** is a modular automation framework built for maintaining robust and scalable automated test suites. It provides best practices for test automation—including utility classes which helps to read the data from external resources.

---

## 🚀 Features

- **Data‑driven testing** via property and excel files
- **Test on browser** (Edge)
- Automatic **WebDriver** driver management with WebDriverManager

---

## 🛠️ Tech Stack

- Java 8+  
- Maven for dependency management  
- Selenium WebDriver  
- WebDriverManager  

---

## ⚙️ Prerequisites

- **Java JDK 8+** installed  
- **Maven 3.x** installed  
- At least one browser: Chrome, Firefox, or Edge

---

## 🚧 Getting Started

1. Clone the repo:
     ```bash
   git clone https://github.com/AkshayT010/Atlas‑Guild.git
   cd Atlas‑Guild
     
3. Install Dependencies
   mvn clean install


## 🚧 Project Structure
Atlas‑Guild/

- ├── pom.xml
- └── src/
-    ├── main/java/…
 -   │   ├── utils/          # Drivers, Config, Data providers
 -   └── test/java/…
 -       └── tests/          
        
## 🚧 How To run the classes
1.Run all tests
 -  mvn test
   
2.Run specific test suite
 -  mvn test -DsuiteXmlFile=testng-smoke.xml

3.Run a single test class
-  mvn -Dtest=LoginTests test



 

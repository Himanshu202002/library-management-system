# 📚 Library Management System

A Spring Boot RESTful application for managing library operations such as adding, updating, deleting, and searching books. It follows a clean architecture with Entity, Repository, Service, and Controller layers, and uses MongoDB as the database.

## 🚀 Features
- Add new books to the library  
- View all books  
- Search books by title or author  
- Update book details  
- Delete books  
- RESTful API design  
- MongoDB integration  
- Lombok for cleaner code  

## 🛠️ Tech Stack
- **Backend:** Spring Boot (Java)
- **Database:** MongoDB
- **Build Tool:** Maven
- **Libraries:** Spring Data MongoDB, Lombok
- **API Format:** JSON (RESTful)

## 📂 Project Structure
LibraryManagementSystem/
│
├── src/
│   ├── main/
│   │   ├── java/com/library_management_system/
│   │   │   ├── entity/BookEntity.java
│   │   │   ├── repository/BookRepository.java
│   │   │   ├── service/BookService.java
│   │   │   ├── controller/BookController.java
│   │   │   └── LibraryManagementSystemApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── static / templates (if any)
│   └── test/...
│
├── pom.xml
└── README.md

## ⚙️ Setup Instructions
1️⃣ Clone the Repository  


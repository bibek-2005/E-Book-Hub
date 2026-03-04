# 📚 Book Store REST API - Spring Boot Project

A fully functional **Book Store Backend Application** built using **Spring Boot, JPA, Hibernate, and MySQL**.

This project demonstrates real-world backend development concepts including CRUD operations, validation, exception handling, and clean architecture.

📸 Screenshots
🏗️ 1️⃣ Project Architecture Flow
<img width="1011" height="1638" alt="flow of project" src="https://github.com/user-attachments/assets/c6151d19-dd07-4f2c-ae19-54a70ef2110d" />

---

## 🚀 Features

✔ Create, Read, Update, Delete (CRUD) Books
✔ Search Books
✔ Input Validation using Jakarta Validation
✔ Custom Exception Handling
✔ Global Exception Handling
✔ Clean & Structured Validation Error Responses
✔ Proper HTTP Status Codes
✔ Layered Architecture (Controller → Service → Repository)
✔ MySQL Database Integration

---

## 🛠️ Tech Stack

* Java 17+
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL
* Maven
* Postman (for API Testing)

---

## 📂 Project Structure

```
com.example.BookStore
│
├── controller        → REST Controllers
├── service           → Business Logic
├── repository        → JPA Repositories
├── entity            → Database Entities
├── exception         → Custom & Global Exceptions
└── BookStoreApplication.java
```

---

## 🗄️ Database Configuration

Update `application.properties`:

```
spring.datasource.url=jdbc:mysql://localhost:3306/bookstore
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## 📌 API Endpoints

### 🔹 Create Book

```
POST /books
```

### 🔹 Get All Books

```
GET /books
```

### 🔹 Get Book By ID

```
GET /books/{id}
```

### 🔹 Update Book

```
PUT /books/{id}
```

### 🔹 Delete Book

```
DELETE /books/{id}
```

### 🔹 Search Book

```
GET /books/search?keyword=java
```

---

## ✅ Validation Example

* `@NotBlank` → Book title cannot be empty
* `@Min` → Price must be greater than 0

Clean validation errors are returned in structured JSON format.

---

## ❗ Exception Handling

* Custom `BookNotFoundException`
* Global exception handler using `@RestControllerAdvice`
* Proper HTTP status codes (400, 404, etc.)

---

## 📸 Sample JSON Request

```json
{
  "title": "Spring Boot Guide",
  "author": "John Doe",
  "price": 499,
  "stock": 20
}
```

---

## 🧠 What I Learned

* REST API Design
* JPA & Hibernate lifecycle
* Validation & BindingResult
* Exception Handling Best Practices
* Clean Code Structure
* Database Integration with Spring Boot

---

## 📈 Future Improvements

* Add DTO Layer
* Add Pagination & Sorting
* Add Swagger Documentation
* Add Authentication & Authorization (JWT)
* Deploy on Cloud (Render / AWS)

---

## 👨‍💻 Author

Developed as part of backend learning journey using Spring Boot.

---

⭐ If you like this project, give it a star!

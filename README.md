# Spring Data JPA Relationships Demo

This project demonstrates how to implement and manage various types of relationships using **Spring Boot** and **Spring Data JPA**. It features a practical example with `Employee`, `Department`, `Address`, and `Project` entities to show:

- One-to-One
- One-to-Many
- Many-to-One
- Many-to-Many relationships

---

## 📁 Technologies Used

- Java 17+
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL (or any other SQL database)
- Lombok
- Jackson (for JSON serialization/deserialization)

---

## 🧠 Features

- One-to-One: `Employee` ↔ `Address`
- Many-to-One: `Employee` → `Department`
- One-to-Many: `Department` → `Employee`
- Many-to-Many: `Employee` ↔ `Project`
- Cascade operations and foreign key handling
- Proper use of JSON annotations to avoid circular references

---

## 📦 Project Structure

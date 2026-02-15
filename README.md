# 📄 User Data Collection Form - Java Swing + SQL Server

This project is a simple **Java Swing application** to collect user information and store it in a **SQL Server database**.  

---

## 🛠 Features

- Collect **Username, Age, City, and Gender**  
- Store user input in **SQL Server** using JDBC  
- Show confirmation message after saving data  
- Beginner-friendly Swing GUI  

---

## 💻 Requirements

- Java JDK 11 or higher (tested with JDK 23)  
- **IntelliJ IDEA** or any Java IDE  
- SQL Server installed and running  
- Microsoft JDBC Driver for SQL Server ([Download Link](https://learn.microsoft.com/en-us/sql/connect/jdbc/download-microsoft-jdbc-driver-for-sql-server))  

---

## ⚙️ Setup Instructions

### 1. Create Database and Table in SQL Server

```sql
CREATE DATABASE UserDB;
GO

USE UserDB;
GO

CREATE TABLE UserData (
    Id INT IDENTITY(1,1) PRIMARY KEY,
    UserName NVARCHAR(50),
    Age INT,
    City NVARCHAR(50),
    Gender NVARCHAR(10)
);
GO

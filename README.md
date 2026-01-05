# 🍮 PT Pudding Menu Management System (Java GUI & MySQL)

PT Pudding Menu Management System is a Java-based desktop application with a graphical user interface (GUI) that integrates with a MySQL database. This application is designed to manage pudding menu data efficiently using full CRUD (Create, Read, Update, Delete) operations.

The system provides an interactive Swing-based interface that allows users to insert new menu items, view existing data, update menu details, and delete records directly from the database. Input validation, database connectivity handling, and real-time table updates are implemented to ensure data accuracy and usability.

---

## 🚀 Features
- Java Swing-based GUI application
- MySQL database integration (JDBC)
- CRUD operations (Insert, View, Update, Delete)
- Real-time data display using JTable
- Input validation for numeric fields (price & stock)
- Search menu by menu code
- Auto-generated menu code
- User-friendly pop-up notifications
- Modular database connection handler

---

## 🛠️ Tech Stack
- Java (Core Java)
- Java Swing (GUI)
- MySQL
- JDBC (MySQL Connector)
- Object-Oriented Programming (OOP)
- Desktop Application Development

---

## 🗂️ Database Structure
**Table: `datamenupudding`**
| Field | Description |
|-----|------------|
| KodeMenu | Primary key (Auto-generated) |
| NamaMenu | Menu name |
| HargaMenu | Menu price |
| StokMenu | Menu stock |

---

## ▶️ How to Run
1. Import the project into your Java IDE (IntelliJ / Eclipse / NetBeans)
2. Ensure MySQL is running and database `pt_pudding` is created
3. Import table `datamenupudding`
4. Add MySQL JDBC Connector to the project library
5. Run `GUI.java`

---

## 🎯 Learning Outcomes
- Building desktop applications using Java Swing
- Implementing database connectivity using JDBC
- Applying CRUD operations in real-world scenarios
- Managing UI events with ActionListener
- Validating user input to prevent invalid data
- Integrating GUI components with relational databases
## 🔖 Tags
Java, Java Swing, MySQL, JDBC, GUI Application, CRUD System, Desktop Application, Database Management

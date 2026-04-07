# shop-java
Java Maven console application for clothing store inventory management, product filtering, category reports, and discount handling.

# Magazin Inventory Management App

A Java console application for managing the inventory of a clothing and footwear store.

## Features
- add new products
- delete existing products
- update product price and quantity
- apply discounts for low-stock items
- display products by category
- filter products by name, price, color, size, and quantity
- display all products from inventory

## Technologies Used
- Java
- Maven
- Object-Oriented Programming

## Project Structure
- `AplicatieMagazin.java` - main entry point of the application
- `Inventar.java` - inventory management logic
- `DiscountManager.java` - discount handling
- `Produs.java` - base product class
- product-specific classes:
  - `Tricou.java`
  - `Hanorac.java`
  - `Maiou.java`
  - `PantaloniLungi.java`
  - `PantaloniScurti.java`
  - `IncaltaminteSport.java`
  - `IncaltaminteEleganta.java`
- `Marime.java` - size enum

## How to Run
1. clone the repository
2. open the project in IntelliJ IDEA or Visual Studio Code
3. make sure Java 17 and Maven are installed
4. run the main class:
   `AplicatieMagazin.java`

## What I Learned
Through this project, I practiced:
- object-oriented programming
- structuring a Java application using multiple classes
- working with inheritance and specialized product types
- managing inventory operations in a console-based application
- organizing a Maven project

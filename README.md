# Wool Management System

<p align="center">
  <strong>A Java Swing desktop application for managing the wool lifecycle from producer onboarding to storage, quality checks, transport, training, and trading.</strong>
</p>

<p align="center">
  <img alt="Java" src="https://img.shields.io/badge/Java-Desktop%20App-007396?style=for-the-badge&logo=openjdk&logoColor=white">
  <img alt="Swing" src="https://img.shields.io/badge/GUI-Java%20Swing-2C3E50?style=for-the-badge">
  <img alt="MySQL" src="https://img.shields.io/badge/Database-MySQL-0F5D7A?style=for-the-badge&logo=mysql&logoColor=white">
  <img alt="NetBeans" src="https://img.shields.io/badge/Built%20With-NetBeans-1B6AC6?style=for-the-badge&logo=apachenetbeanside&logoColor=white">
</p>

## Overview

Wool Management System is a module-based desktop application designed to support operational workflows across the wool supply chain. The project is implemented in **Java Swing** with a **MySQL backend** and follows a **NetBeans GUI Builder** style using `.java` and `.form` files.

The system brings together business functions that are often tracked separately, including:

- user login and role-based access
- wool information and producer details
- preprocessing workflows such as shearing, sorting, and dyeing
- storage and inventory handling
- quality certification and grading
- transport and vehicle tracking
- buying, selling, and billing
- employee and training support screens

## Highlights

- Desktop-first workflow for administrative use
- Multi-screen Swing interface built for NetBeans
- MySQL-backed records for operational data
- Separate modules for storage, quality, transport, and trade
- Customer and management-oriented login flows

## Core Modules

| Module | Purpose | Main Screens |
| --- | --- | --- |
| Authentication | Login, sign-up, and access flow | `Login.java`, `Login_Page.java`, `customer_login.java`, `Customer_Page.java` |
| Navigation | Entry screens and central dashboard | `Front1.java`, `Main_Frame.java`, `Management.java` |
| Wool Information | Basic wool and producer-related records | `wool_information.java`, `producer.java` |
| Preprocessing | Early-stage wool handling workflow | `wool_preprocessing.java`, `shearing.java`, `sorting.java`, `dyeing.java` |
| Storage | Storage locations and stored wool management | `wool_storage.java`, `Storing_place.java` |
| Quality | Quality checks, grading, and certification | `wool_quality.java` |
| Tracking & Transport | Vehicle arrangement and movement status | `wool_tracking.java`, `arrange_vehicles.java`, `Running_Vehicles.java`, `default_vehicles.java`, `new_vehicles.java` |
| Trading & Billing | Producer selling, buyer flow, and billing | `wool_trading.java`, `sell_by_former.java`, `buyer.java`, `billing.java`, `billing_producer.java` |
| Training & Staff | Training support and employee details | `wool_training.java`, `EmployeeDetails.java`, `EmpDetails.java` |

## Technology Stack

- **Language:** Java
- **UI:** Java Swing
- **Database:** MySQL
- **IDE Style:** Apache NetBeans / NetBeans GUI Builder
- **Utilities:** JDBC-style database connectivity and PDF-related helper classes

## Project Structure

```text
Wool_Management/
├─ README.md
└─ Wool_management/
   └─ src/
      ├─ Images/
      ├─ wool_management/
      ├─ Connect.java
      ├─ Front1.java
      ├─ Login.java
      ├─ Main_Frame.java
      ├─ Management.java
      ├─ wool_information.java
      ├─ wool_preprocessing.java
      ├─ wool_storage.java
      ├─ wool_quality.java
      ├─ wool_tracking.java
      ├─ wool_trading.java
      └─ ...additional module screens
```

## Getting Started

### 1. Prerequisites

Make sure the following are installed:

- JDK 8 or later
- MySQL Server
- Apache NetBeans

### 2. Clone the Repository

```bash
git clone https://github.com/kirubaharan181/Wool_Management.git
cd Wool_Management
```

### 3. Open in NetBeans

Open the project folder in NetBeans so the Swing forms and source files load correctly.

### 4. Configure the Database

Update the database connection values in the connection helper class used by the project, such as `Connect.java`.

Typical items to verify:

- MySQL host
- port
- database name
- username
- password

### 5. Prepare the Schema

Create or import the MySQL tables required by the application modules. Based on the current project scope, these typically cover:

- login and user records
- producer details
- wool or product records
- storage data
- vehicle or shipment tracking
- quality or certification data
- buyer, billing, and transaction records
- market trend or training-related data

If you maintain this project further, adding a versioned SQL schema file to the repository would make setup much easier for new contributors.

### 6. Run the Application

Use the main entry screen configured in your IDE. In this project, `Login.java` or `Front1.java` are the most likely startup classes depending on your preferred flow.

## Typical Workflow

### Management Flow

1. Log in to the system
2. Manage producer and wool information
3. Record preprocessing and quality details
4. Allocate storage or transport vehicles
5. Track movement and update operational status
6. Process trade and billing activities

### Customer Flow

1. Sign up or log in
2. Browse available wool-related information
3. Interact with trading screens
4. View billing and order-related details

## Database Notes

This repository currently presents the application structure clearly, but the database setup appears to rely on local configuration. If you want the project to be easier to install and demo, the next high-value additions would be:

- an exported SQL schema
- sample seed data
- screenshots of the main UI screens
- a short demo video or GIF

## Why This Project Stands Out

This project models more than a simple inventory system. It aims to cover multiple stages of the wool business lifecycle inside one desktop application, including:

- operational management
- quality assurance
- logistics tracking
- marketplace interaction
- training support

That broader scope makes it a solid academic or portfolio project for showcasing Java desktop development with domain-oriented module design.

## Suggested Next Improvements

- add a complete SQL setup script
- add screenshots for each major module
- document the role permissions more explicitly
- move database configuration into a dedicated config file
- add input validation and error-handling notes to the README
- package the app with a runnable distribution flow

## Contributing

Contributions that improve documentation, schema setup, validation, usability, or code structure are useful. If you extend the project, keep module names and workflows consistent so the desktop navigation remains easy to follow.

## License

No license file is currently documented in the repository. If you plan to share or reuse this project broadly, add an explicit license.

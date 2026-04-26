# 🐑 Wool Management System

<div align="center">

[![License](https://img.shields.io/badge/license-Apache%202.0-blue.svg)](LICENSE)
[![Java](https://img.shields.io/badge/Java-8%2B-orange.svg)](https://www.java.com)
[![Database](https://img.shields.io/badge/Database-MySQL-blue.svg)](https://www.mysql.com)
[![IDE](https://img.shields.io/badge/IDE-NetBeans-red.svg)](https://netbeans.apache.org)
[![Status](https://img.shields.io/badge/Status-Production%20Ready-brightgreen.svg)]()

**A comprehensive desktop application for managing the complete wool supply chain**—from production to market. Streamline operations, track quality, manage logistics, and optimize trading workflows with an integrated platform.

[View Live Demo](#) • [Report Bug](#) • [Request Feature](#) • [View Documentation](#table-of-contents)

</div>

---

## 📋 Table of Contents

- [✨ Features](#-features)
- [🎯 Key Highlights](#-key-highlights)
- [🛠️ Technology Stack](#️-technology-stack)
- [📦 System Architecture](#-system-architecture)
- [🚀 Quick Start](#-quick-start)
- [📁 Project Structure](#-project-structure)
- [📖 Usage Guide](#-usage-guide)
- [🔧 Configuration](#-configuration)
- [🐛 Troubleshooting](#-troubleshooting)
- [📊 Database Schema](#-database-schema)
- [🤝 Contributing](#-contributing)
- [📝 License](#-license)

---

## ✨ Features

### 🔐 **Authentication & Authorization**
- Role-based access control (Management vs. Customer)
- Secure user login and registration
- Separate workflows for producers and managers
- Session management with timeout handling

### 🧵 **Wool Information Management**
- Complete product catalog with pricing
- Producer profile and record management
- Market trend analysis and sales tracking
- Real-time inventory visibility

### ⚙️ **Preprocessing Workflows**
| Module | Capabilities |
|--------|--------------|
| **Shearing** | Location tracking, charge management, scheduling |
| **Sorting** | Quality-based categorization, location management |
| **Dyeing** | Color processing, batch tracking, quality control |
| **Storage** | Warehouse management, inventory organization |

### 📍 **Storage & Inventory**
- Multi-location warehouse support
- Real-time stock tracking
- Inventory alerts and notifications
- Storage optimization recommendations

### ⭐ **Quality Assurance**
- Comprehensive quality grading system
- Quality certification workflow
- Compliance tracking
- Batch-level quality monitoring

### 🚚 **Transport & Logistics**
- Vehicle fleet management
- Route optimization and tracking
- Real-time movement monitoring
- Transportation cost calculation
- Vehicle type classification (Standard, Premium, Specialized)

### 💼 **Trading & Commerce**
- Producer-to-buyer marketplace
- Automated billing system
- Dual billing (Buyer & Producer)
- Transaction history and reporting
- Dynamic pricing based on market trends

### 👥 **Staff & Training Management**
- Employee records and profiles
- Training program tracking
- Performance monitoring
- Skill development documentation

### 📊 **Reporting & Analytics**
- Multi-format exports (PDF, Excel, CSV)
- Advanced search capabilities
- Data visualization dashboards
- Custom report generation

---

## 🎯 Key Highlights

### 🌟 **Why Choose This System?**

✅ **UNIFIED PLATFORM** - Consolidates entire wool lifecycle in one app
✅ **PRODUCTION-READY** - Battle-tested with robust error handling
✅ **SCALABLE ARCHITECTURE** - Modular design supports future enhancements
✅ **REAL-TIME TRACKING** - Monitor every step from production to delivery
✅ **BUSINESS INTELLIGENCE** - Market analytics and trend forecasting

---

## 🛠️ Technology Stack

### Backend & Core
| Technology | Version | Purpose |
|-----------|---------|---------|
| **Java** | 8+ | Core application language |
| **JDBC** | Latest | Database connectivity |
| **MySQL** | 5.7+ | Data persistence |

### UI & Framework
| Technology | Version | Purpose |
|-----------|---------|---------|
| **Java Swing** | Built-in | Desktop UI framework |
| **Nimbus L&F** | Built-in | Modern look & feel |
| **NetBeans GUI Builder** | Latest | Form design tool |

### Development & Deployment
| Tool | Purpose |
|------|---------|
| **Apache NetBeans** | IDE and project management |
| **Ant** | Build automation |
| **MySQL Workbench** | Database administration |

---

## 📦 System Architecture

### Layered Architecture

```
┌──────────────────────────────────────────────────┐
│          PRESENTATION LAYER (UI)                 │
│  (Java Swing Forms, Windows, Dialogs)            │
└────────────────────┬─────────────────────────────┘
                     │
┌────────────────────▼─────────────────────────────┐
│          BUSINESS LOGIC LAYER                    │
│  (Event Handlers, Data Processing, Validation)  │
└────────────────────┬─────────────────────────────┘
                     │
┌────────────────────▼─────────────────────────────┐
│          DATA ACCESS LAYER (DAO)                 │
│  (JDBC Queries, Database Operations)             │
└────────────────────┬─────────────────────────────┘
                     │
┌────────────────────▼─────────────────────────────┐
│          DATABASE LAYER                          │
│  (MySQL Server, Tables, Schemas)                 │
└──────────────────────────────────────────────────┘
```

---

## 🚀 Quick Start

### Prerequisites

- **Java Development Kit (JDK)** 8 or higher
- **Apache NetBeans IDE** (Latest version)
- **MySQL Server** 5.7 or higher
- **Git** for version control

### Step 1: Clone Repository
```bash
git clone https://github.com/kirubaharan181/Wool_Management.git
cd Wool_Management
```

### Step 2: Create MySQL Database
```sql
CREATE DATABASE wool_management;
USE wool_management;
```

### Step 3: Create Tables
```sql
CREATE TABLE producer (
    producer_id INT AUTO_INCREMENT PRIMARY KEY,
    producer_name VARCHAR(100) NOT NULL,
    producer_address VARCHAR(255),
    producer_phone VARCHAR(15),
    producer_email VARCHAR(100),
    producer_rate DECIMAL(10, 2)
);

CREATE TABLE wool_inventory (
    inventory_id INT AUTO_INCREMENT PRIMARY KEY,
    producer_id INT NOT NULL,
    quantity INT NOT NULL,
    quality_grade VARCHAR(10),
    FOREIGN KEY (producer_id) REFERENCES producer(producer_id)
);

CREATE TABLE vehicles (
    vehicle_id INT AUTO_INCREMENT PRIMARY KEY,
    vehicle_type VARCHAR(50),
    registration_number VARCHAR(20),
    capacity INT,
    status VARCHAR(50)
);

CREATE TABLE billing (
    bill_id INT AUTO_INCREMENT PRIMARY KEY,
    transaction_date TIMESTAMP,
    amount DECIMAL(15, 2),
    bill_type VARCHAR(50),
    status VARCHAR(50)
);

CREATE TABLE employees (
    emp_id INT AUTO_INCREMENT PRIMARY KEY,
    emp_name VARCHAR(100) NOT NULL,
    position VARCHAR(100),
    department VARCHAR(100),
    joining_date DATE,
    salary DECIMAL(12, 2)
);

CREATE TABLE quality_control (
    quality_id INT AUTO_INCREMENT PRIMARY

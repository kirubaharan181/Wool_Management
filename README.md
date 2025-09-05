# Wool Management System — From Farm to Fabric

A Java Swing + MySQL desktop application that digitises the Indian wool supply chain — from producers to storage, transport, quality certification, and trading — with an easy GUI and a simple database backend.

> **Why this exists:** the wool sector struggles with transparency, traceability, inventory and direct trading. This app centralises market info, tracking, storage, quality, marketplace and training in one place.

---

## ✨ Features (Modules)
- **Wool Information:** producer directory and market trends.
- **Wool Tracking:** monitor consignments & vehicles; statuses like *ARRANGED*, *RUNNING* or *DEFAULT*; delivery updates.
- **Quality Assurance:** record grades & digital certificates for trust in transactions.
- **Storage:** inventory CRUD (add/update/search/print) and storage locations.
- **Trading:** internal marketplace for direct farmer↔buyer deals.
- **Training:** region/state-wise artisans and educational resources.
- **Secure Login:** Manager & Customer roles.

---

## 🧱 Architecture
[ Java Swing UI ] <—> [ Java business logic ] <—> [ MySQL Database ]

yaml
Copy code
Minimal, dependable desktop stack: **Java 8+ (Swing GUI) + MySQL**, developed in **NetBeans**.

---

## 🗂 Recommended Repository Structure
WoolManagement/
├─ docs/
│ └─ report.pdf # Your project report/screens
├─ database/
│ ├─ schema.sql # Tables for login, producer, certi, new_product, store_product, trend
│ └─ demo-data.sql # Small starter dataset
├─ src/
│ ├─ main/java/com/woolapp/
│ │ ├─ Main.java # launches Login or Front page
│ │ ├─ auth/ # Login, SignUp
│ │ ├─ db/ConnectionProvider.java # JDBC connection (reads db.properties)
│ │ ├─ model/ # POJOs: Producer, Product, Trend, Certificate, Shipment, User
│ │ ├─ ui/ # Swing frames/panels
│ │ └─ modules/
│ │ ├─ info/ # Producer & Trend screens
│ │ ├─ tracking/ # Vehicles/Shipments
│ │ ├─ quality/ # Certificates/Grades
│ │ ├─ storage/ # Inventory CRUD
│ │ ├─ trading/ # Marketplace UI
│ │ └─ training/ # Education directory
│ └─ main/resources/
│ └─ db.properties.example # DB config template
├─ README.md
└─ LICENSE (optional)

yaml
Copy code

---

## 🔧 Prerequisites
- **JDK 8+**
- **MySQL 8** (or 5.7) running locally
- **NetBeans IDE** (any recent build)

---

## ⚙️ Setup (Quick Start)
1. **Clone or open** the project in NetBeans.
2. Create database and tables:
   ```sql
   CREATE DATABASE wool_db DEFAULT CHARACTER SET utf8mb4;
   USE wool_db;
   SOURCE database/schema.sql;
   SOURCE database/demo-data.sql;
Configure DB credentials:

text
Copy code
src/main/resources/db.properties.example → src/main/resources/db.properties
Then edit db.url, db.username, db.password.

Choose Main Class: set Login.java (or Front1.java) as the main class in NetBeans.

Run ▶️

▶️ How to Use
Login as Manager or Customer (create a customer in SignUp → login table).

Use the Dashboard to open modules:

Info → producers + market trends.

Tracking → vehicles/shipments and current status.

Storage → inventory CRUD & storage place.

Quality → add/view grade certificates.

Trading → buy/sell wool (listings).

Training → learning materials & artisan directory.

🗃 Database
Tables used
login — users & roles

producer — producer master data and rates

certi — quality certifications

new_product — stored wool items

store_product — consignments/transport

trend — market trend snapshots

Schema (database/schema.sql)
sql
Copy code
-- Wool Management System - baseline schema
CREATE DATABASE IF NOT EXISTS wool_db DEFAULT CHARACTER SET utf8mb4;
USE wool_db;

-- Users & roles
CREATE TABLE IF NOT EXISTS login (
  username       VARCHAR(50) PRIMARY KEY,
  password_hash  VARCHAR(255) NOT NULL,
  role           ENUM('MANAGER','CUSTOMER') NOT NULL DEFAULT 'CUSTOMER',
  created_at     TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Producers
CREATE TABLE IF NOT EXISTS producer (
  producer_id    INT AUTO_INCREMENT PRIMARY KEY,
  name           VARCHAR(120) NOT NULL,
  state          VARCHAR(100),
  contact        VARCHAR(60),
  rate           DECIMAL(10,2),
  cert_id        INT NULL,
  created_at     TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Certifications
CREATE TABLE IF NOT EXISTS certi (
  cert_id        INT AUTO_INCREMENT PRIMARY KEY,
  producer_id    INT NOT NULL,
  certification_no VARCHAR(64),
  grade          VARCHAR(16),
  issued_at      DATE,
  valid_till     DATE,
  CONSTRAINT fk_certi_producer FOREIGN KEY (producer_id) REFERENCES producer(producer_id)
);

-- Inventory
CREATE TABLE IF NOT EXISTS new_product (
  product_id     INT AUTO_INCREMENT PRIMARY KEY,
  producer_id    INT,
  wool_type      VARCHAR(50),
  weight_kg      DECIMAL(10,2),
  rate           DECIMAL(10,2),
  storage_place  VARCHAR(120),
  created_at     TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT fk_np_producer FOREIGN KEY (producer_id) REFERENCES producer(producer_id)
);

-- Shipments / Transport
CREATE TABLE IF NOT EXISTS store_product (
  shipment_id    INT AUTO_INCREMENT PRIMARY KEY,
  product_id     INT NOT NULL,
  vehicle_no     VARCHAR(30),
  status         ENUM('ARRANGED','RUNNING','DEFAULT','DELIVERED') DEFAULT 'ARRANGED',
  destination    VARCHAR(120),
  eta            DATE,
  updated_at     TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  CONSTRAINT fk_sp_product FOREIGN KEY (product_id) REFERENCES new_product(product_id)
);

-- Market trends
CREATE TABLE IF NOT EXISTS trend (
  trend_id       INT AUTO_INCREMENT PRIMARY KEY,
  region         VARCHAR(100),
  price_index    DECIMAL(10,2),
  published_at   DATE,
  notes          TEXT
);
Demo Data (database/demo-data.sql)
sql
Copy code
USE wool_db;

-- demo manager (plain text for demo only)
INSERT INTO login (username, password_hash, role) VALUES
('admin', 'admin123', 'MANAGER')
ON DUPLICATE KEY UPDATE password_hash=VALUES(password_hash), role=VALUES(role);

-- sample producers
INSERT INTO producer (name, state, contact, rate) VALUES
('Alpha Wool Co.', 'Rajasthan', 'alpha@example.com', 320.00),
('Himalayan Wool', 'Himachal Pradesh', 'hima@example.com', 410.00);

-- sample certificate
INSERT INTO certi (producer_id, certification_no, grade, issued_at, valid_till)
VALUES (1, 'CERT-001', 'A', '2024-01-10', '2025-01-10');

-- sample products
INSERT INTO new_product (producer_id, wool_type, weight_kg, rate, storage_place)
VALUES (1, 'Merino', 120.5, 350.00, 'Warehouse A'),
       (2, 'Cashmere Blend', 80.0, 420.00, 'Warehouse B');

-- sample shipments
INSERT INTO store_product (product_id, vehicle_no, status, destination, eta)
VALUES (1, 'TN-09-1234', 'ARRANGED', 'Jaipur', '2025-09-20'),
       (2, 'HP-33-5678', 'RUNNING',  'Delhi',  '2025-09-12');

-- market trends
INSERT INTO trend (region, price_index, published_at, notes)
VALUES ('North', 102.5, '2025-08-15', 'Seasonal uptick observed');
DB Config (src/main/resources/db.properties.example)
properties
Copy code
# Copy to src/main/resources/db.properties and edit for your environment
db.url=jdbc:mysql://localhost:3306/wool_db
db.username=root
db.password=change-me
db.pool.size=10
🧭 Typical User Flows
Manager: login → dashboard → certify wool → update inventory → assign vehicle → track status → complete delivery → view trends.

Customer: sign up/login → view trends & listings → buy → track shipment.

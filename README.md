# Wool Management System — From Farm to Fabric

A **Java Swing desktop application** with a **MySQL backend** to manage the Indian wool supply chain — covering production, storage, transport, certification, and trading.  
This project was developed in **NetBeans** using **Swing GUI builder** (`.form` + `.java` files).

---

## ✨ Features (Modules)

- **Login & Authentication**
  - `Login.java`, `Login_Page.java`, `customer_login.java`, `Customer_Page.java`
  - Manages Manager and Customer logins, sign-up, and access control.

- **Dashboard / Navigation**
  - `Front1.java`, `Main_Frame.java`, `Management.java`
  - Provides central navigation to modules after login.

- **Wool Information**
  - `wool_information.java`
  - Manage details about wool types, producers, and general info.

- **Wool Tracking**
  - `wool_tracking.java`, `arrange_vehicles.java`, `Running_Vehicles.java`, `default_vehicles.java`, `new_vehicles.java`
  - Assign and monitor vehicles; track status such as **ARRANGED**, **RUNNING**, or **DEFAULT**.

- **Wool Storage**
  - `wool_storage.java`, `Storing_place.java`
  - Manage storage locations, add/update/search inventory, and print storage details.

- **Wool Quality**
  - `wool_quality.java`
  - Handle certification and grading of wool products.

- **Wool Trading**
  - `wool_trading.java`, `sell_by_former.java`, `buyer.java`, `billing.java`, `billing_producer.java`
  - Facilitate marketplace activities between farmers and buyers, including billing.

- **Wool Training**
  - `wool_training.java`
  - Provides training materials and artisan-related resources.

- **Wool Preprocessing**
  - `wool_preprocessing.java`, `shearing.java`, `sorting.java`, `dyeing.java`
  - Modules to represent preprocessing stages before trading/storage.

- **Employee & Utility**
  - `EmployeeDetails.java`, `EmpDetails.java`
  - Manage employee-related details.
  - Utility files: `Connect.java` (DB connection), `DriverManager.java` (driver loader), `PdfPTable.java`, `Paragraph.java` (PDF utilities).

---

## 🗂 Project Structure

Wool_management/src/
├─ Images/                     # images/resources for UI
├─ Project/                    # (additional project-specific files)
├─ wool_management/            # NetBeans package (forms/resources)
├─ arrange_vehicles.java       # Vehicle arrangement screen
├─ billing.java                # Buyer billing
├─ billing_producer.java       # Producer billing
├─ buyer.java                  # Buyer details screen
├─ Connect.java                # Database connection helper
├─ customer_login.java         # Customer login
├─ Customer_Page.java          # Customer dashboard
├─ default_vehicles.java       # Vehicles marked as default
├─ DriverManager.java          # JDBC driver helper
├─ dyeing.java                 # Wool dyeing step
├─ EmpDetails.java             # Employee details (alt)
├─ EmployeeDetails.java        # Employee details screen
├─ Front1.java                 # Main front page
├─ Login.java                  # Login screen
├─ Login_Page.java             # Alternative login
├─ Main_Frame.java             # Main GUI frame
├─ Management.java             # Management dashboard
├─ new_vehicles.java           # New vehicles management
├─ Paragraph.java              # PDF helper class
├─ PdfPTable.java              # PDF table generator
├─ producer.java               # Producer information
├─ Running_Vehicles.java       # Running vehicle tracking
├─ sell_by_former.java         # Farmer selling UI
├─ shearing.java               # Wool shearing step
├─ sorting.java                # Sorting wool step
├─ Storing_place.java          # Storage place manager
├─ StudentPage.java            # (extra screen, maybe unused)
├─ wool_information.java       # Wool information module
├─ wool_preprocessing.java     # Wool preprocessing main
├─ wool_quality.java           # Wool quality module
├─ wool_storage.java           # Wool storage
├─ wool_tracking.java          # Wool tracking dashboard
├─ wool_trading.java           # Wool trading
└─ wool_training.java          # Wool training


---

## ⚙️ Setup Instructions

1. Install **JDK 8+** and **MySQL**.  
2. Create a database (`wool_db`) and set up tables for:
   - Users (login/roles)
   - Producers
   - Products
   - Shipments
   - Certificates
   - Trends
3. Open this project in **NetBeans** (forms will load in drag-and-drop GUI editor).  
4. Update DB credentials inside `Connect.java` (or related config).  
5. Run the project by setting `Login.java` or `Front1.java` as the **main class**.  

---

## ▶️ How It Works

- **Managers**: login → manage producers → certify wool → add storage → assign vehicles → track deliveries → check market trends.  
- **Customers**: sign up/login → view wool information & trends → purchase wool → track their order.  

---

## 🗃 Database (Conceptual Overview)

- **login** → stores manager and customer accounts.  
- **producer** → details of wool producers and their rates.  
- **new_product / wool_storage** → inventory of wool products.  
- **store_product** → shipment and transport records.  
- **certi / wool_quality** → wool quality grades and certificates.  
- **trend** → market trend information.  
- **billing / buyer** → transaction and billing details.  

---

## 🚀 Future Improvements

- Mobile app version for farmers and buyers.  
- Payment integration for transactions.  
- Cloud hosting for remote multi-user access.  
- Multilingual UI (regional languages).  
- AI-based wool price predictions.  

---

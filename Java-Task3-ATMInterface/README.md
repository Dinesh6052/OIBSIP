# 🏧 ATM Interface

A console-based ATM Interface developed using Java and Object-Oriented Programming principles. This project simulates basic banking operations such as user authentication, deposits, withdrawals, money transfers, and transaction history.

This project was developed as part of the **Oasis Infobyte Java Development Internship**.

---

## 📌 Objective

The objective of this project is to build a console-based ATM system where users can securely log in using their User ID and PIN and perform standard banking operations.

The application provides a menu-driven interface for performing transactions.

---

## 🚀 Features

- 🔐 User ID and PIN authentication
- 🚫 Maximum 3 login attempts
- 💰 Check account balance
- 💵 Deposit money
- 💸 Withdraw money
- 🔄 Transfer money between accounts
- 📜 Transaction history
- ⚠️ Insufficient funds validation
- ❌ Invalid input handling
- 🕒 Transaction date and time
- 🏦 Multiple account support
- 🚪 Quit option
- 🧱 Object-Oriented Programming design

---

## 🏧 ATM Operations

After successful login, the user can access the following operations:

```text
1. Transaction History
2. Withdraw
3. Deposit
4. Transfer
5. Quit
```

---

## 🔐 Login System

The user must enter:

- User ID
- PIN

The system allows a maximum of **3 incorrect login attempts**.

After three incorrect attempts, access is denied.

---

## 💸 Withdraw

The user can withdraw money from their account.

The system validates:

- Amount must be greater than zero
- Account must have sufficient balance

If the balance is insufficient, the system displays:

```text
Insufficient Funds.
```

---

## 💵 Deposit

The user can deposit money into their account.

The system validates that the deposit amount is greater than zero.

After a successful deposit:

- Account balance is updated
- Transaction is recorded

---

## 🔄 Transfer

The user can transfer money to another account.

The system validates:

- Recipient account exists
- Transfer amount is valid
- User has sufficient balance
- User cannot transfer money to their own account

After a successful transfer:

- Sender balance is updated
- Recipient balance is updated
- Transaction is recorded

---

## 📜 Transaction History

All transactions are stored during the current session using:

```java
ArrayList<Transaction>
```

Transaction history includes:

- Transaction Type
- Amount
- Description
- Date and Time

---

## 🧱 Object-Oriented Programming

The project uses the following Java classes:

### 1️⃣ Main.java

Responsible for:

- Starting the application
- Creating sample accounts
- Starting the ATM system

### 2️⃣ ATM.java

Responsible for:

- User login
- ATM menu
- Withdraw operation
- Deposit operation
- Transfer operation
- Transaction history

### 3️⃣ Account.java

Responsible for:

- User ID
- PIN
- Account holder name
- Account balance
- Deposit
- Withdraw
- Transaction history

### 4️⃣ Bank.java

Responsible for:

- Managing accounts
- Finding accounts
- User authentication

### 5️⃣ Transaction.java

Responsible for storing:

- Transaction type
- Amount
- Description
- Date and time

---

## 🛠️ Technologies Used

- Java
- Object-Oriented Programming (OOP)
- ArrayList
- Scanner
- LocalDateTime
- DateTimeFormatter
- Eclipse IDE

---

## 📂 Project Structure

```text
Java-Task3-ATMInterface
│
├── src
│   │
│   └── com
│       │
│       └── atm
│           ├── Account.java
│           ├── ATM.java
│           ├── Bank.java
│           ├── Main.java
│           └── Transaction.java
│
└── README.md
```

---

## ▶️ How to Run

### Step 1

Download or clone the project.

### Step 2

Open the project using Eclipse IDE.

### Step 3

Navigate to:

```text
src → com → atm → Main.java
```

### Step 4

Right-click on:

```text
Main.java
```

Select:

```text
Run As → Java Application
```

---

## 🧪 Sample Login

You can use the sample account created in the project.

Example:

```text
User ID: 1001
PIN: 1234
```

> Note: Use the login credentials configured in your `Main.java` file.

---

## 🖥️ Sample Output

```text
====================================
          WELCOME TO ATM
====================================

Enter User ID: 1001
Enter PIN: 1234

Login Successful!

Welcome, Dinesh Patil

====================================
            ATM MENU
====================================

1. Transaction History
2. Withdraw
3. Deposit
4. Transfer
5. Quit

Enter your choice:
```

---

## 📚 Java Concepts Used

- Object-Oriented Programming
- Classes and Objects
- Encapsulation
- Constructors
- ArrayList
- Conditional Statements
- Switch Case
- Loops
- Methods
- Scanner Class
- Date and Time API

---

## 🔮 Future Improvements

Possible future improvements include:

- Database integration using MySQL
- Password/PIN encryption
- Persistent transaction history
- Account registration
- Account balance inquiry option
- GUI using Java Swing
- Multiple user sessions

---

## 👨‍💻 Author

**Dinesh Chandrakant Patil**

Final-Year Computer Engineering Student

Aspiring Java Full Stack Developer

---

## 🏢 Internship

**Oasis Infobyte**

Java Development Internship

---

⭐ If you like this project, consider giving it a star!
# Global Digital Bank - Account Management System

A modular Java-based banking domain model demonstrating core Object-Oriented Programming (OOP) concepts, business rule validation, encapsulation, and entity lifecycle management without throwing unhandled runtime exceptions[cite: 1].

---

## Project Overview

This project implements a comprehensive bank account management system consisting of standard and enhanced banking entities, along with a full test driver suite to verify transaction rules, boundary conditions, and state transitions[cite: 1].

* **Core Account Entity (`Account.java`)**: Basic account model featuring encapsulation, standard deposit/withdrawal logic, and boolean operation flags[cite: 1].
* **Enhanced Account Entity (`AccountEnhanced.java`)**: Advanced account model adding self-correcting business rules, minimum balance constraints, account lifecycle states (Active/Inactive), and 4-digit PIN authentication[cite: 1].
* **Test Driver Suite (`TestAccount.java`)**: Verification suite executing functional tests across account creation, deposits, withdrawals, and formatted reporting[cite: 1].

---

## Key Features

* **Self-Correcting Constructor Validation**:
  * Enforces minimum age requirement of 18 (auto-adjusts values `< 18` to `18`)[cite: 1].
  * Normalizes account types to `Savings` or `Current` (defaults invalid inputs to `Savings`)[cite: 1].
  * Sets minimum starting balance: ₹500 for `Savings` and ₹1,000 for `Current`[cite: 1].
* **Transaction Safeguards**:
  * Minimum balance retention enforced during withdrawals[cite: 1].
  * Negative and zero amount prevention on deposits and withdrawals[cite: 1].
* **Account State & Security**:
  * Active/Inactive status lifecycle methods (`closeAccount()`, `reopenAccount()`)[cite: 1].
  * Inactive accounts automatically block deposits and withdrawals[cite: 1].
  * 4-digit PIN setup, verification, and transaction authorization[cite: 1].
* **Clean Separation of Concerns**: Pure entity model classes contain zero display statements; all presentation formatting is handled by driver classes[cite: 1].

---

## Project Structure


src/
├── Account.java            # Standard Account entity model
├── AccountEnhanced.java    # Enhanced entity model with validation & PIN security
├── TestAccount.java        # Test driver & output verification suite
└── README.md



---

## How to Compile and Run

### Prerequisites

* Java Development Kit (JDK 11 or higher)



### Execution

1. Compile the source files:

```bash
javac Account.java TestAccount.java AccountEnhanced.java

```

2. Run the test driver suite:

```bash
java TestAccount

```

---

## Sample Output


==================================================
               GLOBAL DIGITAL BANK                
                   ACCOUNT TEST                   
==================================================
>>> 1. Creating Account
Account created!
Account #1001 | John Doe (25 yrs) | Savings | 1000.0 | Active
>>> 2. Deposit Money
Depositing 500.0: SUCCESS
New balance: ₹1500.0
Depositing -100.0: FAILED (Invalid amount)
>>> 3. Withdraw Money
Withdrawing 200.0: SUCCESS
New balance: ₹1300.0
Withdrawing 2000.0: FAILED (Insufficient balance)
Current balance: ₹1300.0
>>> 4. Creating Another Account
Account #1002 | Jane Smith (30 yrs) | Current | 2000.0 | Active
>>> 5. All Accounts
Account #1001 | John Doe (25 yrs) | Savings | 1300.0 | Active
Account #1002 | Jane Smith (30 yrs) | Current | 2000.0 | Active
==================================================
                 TEST COMPLETED!                  
==================================================


```

```

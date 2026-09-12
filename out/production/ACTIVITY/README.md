```markdown
# Global Digital Bank - Account Management System

A modular Java-based banking domain model demonstrating core Object-Oriented Programming (OOP) concepts, inheritance hierarchies, custom exception handling, business rule validation, encapsulation, and entity lifecycle management.

---

## Project Overview

This project implements a comprehensive bank account management system consisting of standard and enhanced banking entities, specialized account subclasses, custom domain exceptions, and dedicated test suites to verify transaction rules, boundary conditions, and state transitions.

* **Core Account Entity (`Account.java`)**: Base account model featuring encapsulation, lifecycle status (Active/Inactive), 4-digit PIN authentication, and strict validation using exceptions.
* **Enhanced Account Entity (`AccountEnhanced.java`)**: Advanced account model adding self-correcting business rules, minimum balance constraints, and lifecycle flags.
* **Account Subclasses (Inheritance Hierarchy)**:
  * `SavingsAccount.java`: Implements minimum balance rules, interest rate configuration, and an `applyInterest()` mechanism.
  * `CurrentAccount.java`: Implements flexible overdraft facilities with configurable limits.
  * `FixedDepositAccount.java`: Implements fixed tenure periods and compound maturity interest calculations.
  * `SalaryAccount.java`: Implements employer tracking and account inactivity tracking.
* **Custom Exception Architecture**:
  * `AccountException.java`: Base checked domain exception.
  * `InvalidAmountException.java`: Thrown on non-positive deposits or withdrawals.
  * `InsufficientBalanceException.java`: Thrown when withdrawal exceeds available funds.
  * `MinimumBalanceViolationException.java`: Thrown when a withdrawal breaches minimum balance thresholds.
  * `InactiveAccountException.java`: Thrown when attempting transactions on closed accounts.
  * `InvalidPinException.java`: Thrown on incorrect PIN entry or missing PIN setup.
* **Test Driver Suites**:
  * `TestAccount.java`: Basic account operations and output verification.
  * `TestAccountEnhanced.java`: Verification suite for enhanced account validation.
  * `TestAccountExceptions.java`: Exception-handling suite testing boundary conditions and failure states via `try-catch` blocks.
  * `TestAccountSubclasses.java`: Verifies subclass instantiation, inheritance behavior, and domain-specific attributes.

---

## Key Features

* **Strict & Defensive Constructor Validation**:
  * Enforces minimum age requirement of 18 (throws `IllegalArgumentException` on `< 18`).
  * Validates supported account types (`SAVINGS`, `CURRENT`, `FIXED_DEPOSIT`, `SALARY`).
  * Enforces minimum opening balance requirements.
* **Inheritance & Domain Specialization**:
  * Subclasses inherit core balance, PIN, and state logic via `super(...)`.
  * Specialized calculations including compound interest for Fixed Deposits and automated interest credit for Savings.
* **Custom Exception Handling**:
  * Replaces silent boolean returns with descriptive custom checked exceptions.
  * Differentiates between insufficient balance, rule violations, and invalid input amounts.
* **Account State & Security**:
  * Active/Inactive status lifecycle methods (`closeAccount()`, `reopenAccount()`).
  * Inactive accounts automatically block deposits and withdrawals.
  * 4-digit PIN setup, verification, and transaction authorization.
* **Clean Separation of Concerns**: Pure entity model classes contain zero display statements; all presentation formatting is handled by driver classes.

---

## Project Structure

```text
.
├── Account.java                            # Core Account entity model
├── AccountEnhanced.java                    # Enhanced entity model
├── SavingsAccount.java                     # Savings subclass with interest credit
├── CurrentAccount.java                     # Current subclass with overdraft limits
├── FixedDepositAccount.java                # FD subclass with compound interest
├── SalaryAccount.java                      # Salary subclass with employer tracking
├── AccountException.java                   # Base domain exception
├── InactiveAccountException.java           # Inactive account state exception
├── InsufficientBalanceException.java       # Insufficient balance exception
├── InvalidAmountException.java             # Non-positive amount exception
├── InvalidPinException.java                # PIN mismatch or missing exception
├── MinimumBalanceViolationException.java   # Minimum balance breach exception
├── TestAccount.java                        # Basic test suite
├── TestAccountEnhanced.java                # Enhanced account test suite
├── TestAccountExceptions.java              # Exception testing suite
├── TestAccountSubclasses.java              # Subclass inheritance test suite
└── README.md

```

---

## How to Compile and Run

### Prerequisites

* Java Development Kit (JDK 11 or higher)

### Execution

1. Compile all Java source files:

```bash
javac *.java

```

2. Run any desired test driver suite:

* **Basic Account Test**:
```bash
java TestAccount

```


* **Exception Handling Test**:
```bash
java TestAccountExceptions

```


* **Account Subclasses Test**:
```bash
java TestAccountSubclasses

```



---

## Sample Outputs

### Activity 6: Account Test With Exceptions

```text
==================================================
           ACCOUNT TEST WITH EXCEPTIONS           
==================================================
>>> Test 1: Valid Account Creation
SUCCESS: Account #1001 | John Doe (25 yrs) | Savings | 1000.0 | Active | PIN: No
>>> Test 2: Invalid Age (under 18)
EXCEPTION: Customer must be at least 18 years old. Provided: 16
>>> Test 3: Invalid Account Type
EXCEPTION: Account type must be 'Savings' or 'Current'. Provided: Invalid
>>> Test 4: Minimum Balance on Creation
Creating Savings account with 300
EXCEPTION: Savings account requires minimum balance of 500.0. Provided: 300.0
>>> Test 5: Valid Deposit and Withdrawal
Account: Account #1005 | Alice Brown (30 yrs) | Current | 1000.0 | Active | PIN: No
Setting PIN 1234: SUCCESS
Depositing 500.0: SUCCESS
Balance after deposit: 1500.0
Withdrawing 200.0: SUCCESS
Balance after withdrawal: 1300.0
Account #1005 | Alice Brown (30 yrs) | Current | 1300.0 | Active | PIN: Yes
>>> Test 6: Invalid Deposit (Negative Amount)
Attempting to deposit -100.0
EXCEPTION: Deposit amount must be positive. Provided: -100.0
>>> Test 7: Insufficient Balance
Account: Account #1006 | Charlie Green (35 yrs) | Savings | 500.0 | Active | PIN: Yes
Attempting to withdraw 1000.0
EXCEPTION: Insufficient balance. Available: 500.0, Requested: 1000.0
>>> Test 8: Minimum Balance Violation
Account: Account #1007 | Diana Prince (28 yrs) | Savings | 1000.0 | Active | PIN: Yes
Attempting to withdraw 600.0
EXCEPTION: Cannot withdraw. Minimum balance of 500.0 required. Available after withdrawal: 400.0
>>> Test 9: Inactive Account Operations
Account: Account #1008 | Eve Wilson (32 yrs) | Current | 2000.0 | Active | PIN: No
Closing account: SUCCESS
Attempting to deposit 100.0 on closed account
EXCEPTION: Account is inactive. Please reopen the account or contact support.
Reopening account: SUCCESS
Depositing 100.0 after reopen: SUCCESS
Balance after deposit: 2100.0
>>> Test 10: PIN Verification
Account: Account #1009 | Frank Miller (40 yrs) | Savings | 1500.0 | Active | PIN: No
Setting PIN 1234: SUCCESS
Withdrawing 200.0 with correct PIN: SUCCESS
Balance: 1300.0
Attempting to withdraw 100.0 with incorrect PIN (9999)
EXCEPTION: Incorrect PIN
Attempting to withdraw 100.0 without PIN set
EXCEPTION: PIN not set for this account
>>> Test 11: All Accounts Summary
Account #1001 | John Doe (25 yrs) | Savings | 1000.0 | Active | PIN: No
Account #1005 | Alice Brown (30 yrs) | Current | 1300.0 | Active | PIN: Yes
Account #1006 | Charlie Green (35 yrs) | Savings | 500.0 | Active | PIN: Yes
Account #1007 | Diana Prince (28 yrs) | Savings | 1000.0 | Active | PIN: Yes
Account #1008 | Eve Wilson (32 yrs) | Current | 2100.0 | Active | PIN: No
Account #1009 | Frank Miller (40 yrs) | Savings | 1300.0 | Active | PIN: Yes
==================================================
                 TEST COMPLETED!                  
==================================================

```

### Activity 7: Account Subclasses Test

```text
=== Activity 7: Account Subclasses Test ===
Savings Account Created: Balance Rs 10000.0 | Min Balance: Rs 1000.0
Current Account Created: Overdraft Limit Rs 25000.0
Fixed Deposit Created: Tenure 12 months | Interest: 6.5%
Salary Account Created: Employer Infosys
All subclasses instantiated successfully!

```

```

```

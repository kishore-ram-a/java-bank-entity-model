```markdown
# Global Digital Bank - Account Management System

A modular Java-based banking domain model demonstrating core Object-Oriented Programming (OOP) concepts, inheritance hierarchies, custom exception handling, abstraction, and behavioral design patterns such as the Template Method Pattern[cite: 2].

---

## Project Overview

This project implements a comprehensive bank account management system built around an abstract base class that enforces common business workflows while delegating specialized debit operations to concrete account subclasses[cite: 2].

* **Abstract Base Account (`AbstractAccount.java`)**: Core abstract template class providing common properties, deposit logic, PIN management, account lifecycle state, and a finalized template method for withdrawals[cite: 2].
* **Legacy Models (`Account.java`, `AccountEnhanced.java`)**: Baseline and enhanced account models featuring encapsulation, constructor validation, and self-correcting business rules.
* **Account Subclasses (Inheritance Hierarchy)**:
  * `SavingsAccount.java`: Implements minimum balance constraints, annual interest application, and specialized debit validation[cite: 2].
  * `CurrentAccount.java`: Implements configurable overdraft facilities allowing negative balances[cite: 2].
  * `FixedDepositAccount.java`: Implements tenure-based deposit logic, compound maturity calculations, and blocks premature debits[cite: 2].
  * `SalaryAccount.java`: Implements zero-minimum-balance debit operations and tracks employer association[cite: 2].
* **Custom Exception Architecture**:
  * `AccountException.java`: Base checked domain exception[cite: 2].
  * `InvalidAmountException.java`: Thrown when transaction amounts are non-positive[cite: 2].
  * `InsufficientBalanceException.java`: Thrown when withdrawals exceed balance or permitted overdraft limits[cite: 2].
  * `MinimumBalanceViolationException.java`: Thrown when a withdrawal violates minimum balance thresholds[cite: 2].
  * `InactiveAccountException.java`: Thrown on transaction attempts against closed accounts[cite: 2].
  * `InvalidPinException.java`: Thrown on mismatched or unconfigured PIN attempts[cite: 2].

---

## Design Pattern: Template Method

The withdrawal workflow is encapsulated inside `AbstractAccount.withdraw(double amount, int pin)` as a template method to enforce a standard security and validation sequence[cite: 2]:

1. **Authentication**: Validates that the provided PIN matches the account PIN[cite: 2].
2. **Account Status Check**: Ensures the account is active[cite: 2].
3. **Amount Check**: Rejects negative or zero values[cite: 2].
4. **Hook Delegation**: Calls the protected abstract method `processDebit(double amount)`, allowing each subclass to execute its specific debit constraints without duplicating transaction safeguards[cite: 2].

---

## Project Structure

```text
.
├── AbstractAccount.java                    # Base abstract template class
├── Account.java                            # Baseline account model
├── AccountEnhanced.java                    # Self-correcting account model
├── SavingsAccount.java                     # Savings entity with min-balance debit logic
├── CurrentAccount.java                     # Current entity with overdraft debit logic
├── FixedDepositAccount.java                # Fixed Deposit entity with locked debits
├── SalaryAccount.java                      # Salary entity with employer tracking
├── AccountException.java                   # Base domain exception
├── InactiveAccountException.java           # Inactive account state exception
├── InsufficientBalanceException.java       # Insufficient balance exception
├── InvalidAmountException.java             # Non-positive amount exception
├── InvalidPinException.java                # Authentication failure exception
├── MinimumBalanceViolationException.java   # Minimum balance breach exception
├── TestAccount.java                        # Basic account driver suite
├── TestAccountEnhanced.java                # Enhanced account test suite
├── TestAccountExceptions.java              # Exception testing driver
├── TestAccountSubclasses.java              # Subclass polymorphism driver
├── TestAbstractAccount.java                # Template method verification driver
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

2. Run any of the verification suites:

* **Template Method Pattern Verification**:
```bash
java TestAbstractAccount

```


* **Polymorphism Verification**:
```bash
java TestAccountSubclasses

```


* **Exception Handling Verification**:
```bash
java TestAccountExceptions

```



---

## Sample Output

### Activity 9: Abstract Account & Template Method Pattern Test

```text
=== Activity 9: Abstract Account & Template Pattern ===
[Savings] Withdraw 2000: SUCCESS | Balance: Rs 8000.0
[Savings] Withdraw below min balance: Caught MinimumBalanceViolationException [PASS]
[Current] Overdraft debit: SUCCESS | Balance: Rs -3000.0
[FixedDeposit] Premature debit: Caught AccountException [PASS]
Template method pattern executed successfully!
```[cite: 2]

```

public class Account {
    private static final double MIN_BALANCE_SAVINGS = 500.0;
    private static final double MIN_BALANCE_CURRENT = 1000.0;
    private static final int MIN_AGE = 18;
    private static final int MIN_PIN = 1000;
    private static final int MAX_PIN = 9999;
    private Integer pin;
    // attributes
    private int accountNumber;
    private String name;
    private int age;
    private double balance;
    private String accountType;
    private String status;

    // constructor
    public Account(int accountNumber, String name, int age, double initialBalance, String accountType)
            throws IllegalArgumentException {
        if (age < MIN_AGE) {
            throw new IllegalArgumentException("Age must be at least 18");
        }
        if (!accountType.equalsIgnoreCase("Savings") && !accountType.equalsIgnoreCase("Current")) {
            throw new IllegalArgumentException("Invalid account type. Must be Savings or Current");
        }
        this.accountType = accountType.equalsIgnoreCase("Savings") ? "Savings" : "Current";
        if (initialBalance < getMinimumBalance()) {
            throw new IllegalArgumentException("Initial balance below minimum required");
        }

        this.accountNumber = accountNumber;
        this.name = name;
        this.age = age;
        this.balance = initialBalance;
        this.status = "Active";
        this.pin = null;
    }

    // deposit method
    public void deposit(double amount) throws InvalidAmountException, InactiveAccountException {
        validateActive();
        if (amount <= 0) {
            throw new InvalidAmountException("Deposit amount must be positive");
        } else {
            balance += amount;
        }
    }

    // withdraw method
    public void withdraw(double amount, int pin) throws InvalidAmountException, InsufficientBalanceException,
            MinimumBalanceViolationException, InactiveAccountException, InvalidPinException {
        validateActive();
        if (this.pin == null || !verifyPin(pin)) {
            throw new InvalidPinException("Invalid pin or unset pin");
        }
        if (amount <= 0) {
            throw new InvalidAmountException("Withdrawal amount must be greater than 0");
        }
        if (amount > this.balance) {
            throw new InsufficientBalanceException("Insufficient balance");
        }
        if ((this.balance - amount) < getMinimumBalance()) {
            throw new MinimumBalanceViolationException("Withdrawal doesn't match minimum balance requirement");
        }
        this.balance -= amount;
    }

    // get acc no
    public int getAccountNumber() {
        return accountNumber;
    }

    // get name
    public String getName() {
        return name;
    }

    // get age
    public int getAge() {
        return age;
    }

    // get balance
    public double getBalance() {
        return balance;
    }

    // get account type
    public String getAccountType() {
        return accountType;
    }

    // get status
    public String getStatus() {
        return status;
    }

    // set name
    public void setName(String name) {
        this.name = name;
    }

    // set age
    public void setAge(int age) {
        this.age = age;
    }

    // get min balance
    private double getMinimumBalance() {
        if (this.accountType.equalsIgnoreCase("current")) {
            return MIN_BALANCE_CURRENT;
        }
        return MIN_BALANCE_SAVINGS;
    }

    private void validateActive() throws InactiveAccountException {
        if (!this.status.equalsIgnoreCase("active")) {
            throw new InactiveAccountException("Account is inactive");
        }

    }

    // verify pin
    public boolean verifyPin(int pin) {
        if (this.pin != null && this.pin.intValue() == pin) {
            return true;
        }
        return false;
    }

    // close account
    public void closeAccount() throws IllegalStateException {
        if (this.status.equalsIgnoreCase("Inactive")) {
            throw new IllegalStateException("Account is already closed");

        }
        this.status = "Inactive";
    }

    // activate account
    public void reopenAccount() throws IllegalStateException {
        if (this.status.equalsIgnoreCase("Active")) {
            throw new IllegalStateException("Account is already active");

        }
        this.status = "Active";
    }

    // set pin
    public void setPin(int pin) throws IllegalArgumentException {
        if (pin < MIN_PIN || pin > MAX_PIN) {
            throw new IllegalArgumentException("PIN must be 4-digits");
        }
        this.pin = pin;
    }

    // has pin
    public boolean hasPin() {
        return this.pin != null;
    }
}

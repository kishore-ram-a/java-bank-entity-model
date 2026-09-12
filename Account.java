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
        if (!accountType.equalsIgnoreCase("SAVINGS") &&
                !accountType.equalsIgnoreCase("CURRENT") &&
                !accountType.equalsIgnoreCase("FIXED_DEPOSIT") &&
                !accountType.equalsIgnoreCase("SALARY")) {
            throw new IllegalArgumentException("Invalid account type");
        } else {
            this.accountType = accountType;
        }
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
    public void withdraw(double amount, int pin) throws AccountException {
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

    // getters and setters
    public int getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getStatus() {
        return status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

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

    public boolean verifyPin(int pin) {
        return this.pin != null && this.pin == pin;
    }

    public void closeAccount() throws IllegalStateException {
        if (this.status.equalsIgnoreCase("Inactive")) {
            throw new IllegalStateException("Account is already closed");
        }
        this.status = "Inactive";
    }

    public void reopenAccount() throws IllegalStateException {
        if (this.status.equalsIgnoreCase("Active")) {
            throw new IllegalStateException("Account is already active");
        }
        this.status = "Active";
    }

    public void setPin(int pin) throws IllegalArgumentException {
        if (pin < MIN_PIN || pin > MAX_PIN) {
            throw new IllegalArgumentException("PIN must be 4-digits");
        }
        this.pin = pin;
    }

    public boolean hasPin() {
        return this.pin != null;
    }
}
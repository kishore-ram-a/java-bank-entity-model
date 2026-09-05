public class AccountEnhanced {

    // attributes
    private int accountNumber;
    private String name;
    private int age;
    private double balance;
    private String accountType;
    private String status;
    private Integer pin;

    private double getMinimumBalance() {
        return "Current".equalsIgnoreCase(this.accountType) ? 1000.0 : 500.0;
    }

    // constructor
    public AccountEnhanced(int accountNumber, String name, int age, double initialBalance, String accountType) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.status = "Active";
        this.pin = null;
        this.age = age < 18 ? 18 : age;
        this.accountType = accountType.equalsIgnoreCase("Savings") ? "Savings"
                : accountType.equalsIgnoreCase("Current") ? "Current" : "Savings";
        this.balance = this.accountType.equalsIgnoreCase("Savings") ? initialBalance < 500 ? 500 : initialBalance
                : initialBalance < 1000 ? 1000 : initialBalance;
    }

    // deposit methods
    public boolean deposit(double amount) {
        if (!this.status.equalsIgnoreCase("active") || amount <= 0) {
            return false;
        }
        this.balance += amount;
        return true;
    }

    // withdraw method
    public boolean withdraw(double amount, int pin) {
        if (!this.status.equalsIgnoreCase("Active") || amount <= 0) {
            return false;
        }
        if (verifyPin(pin)) {
            if (this.balance - amount < getMinimumBalance()) {
                return false;
            }
            this.balance -= amount;
            return true;
        }
        return false;
    }

    // set-pin function
    public boolean setPin(int pin) {
        if (pin >= 1000 && pin <= 9999) {
            this.pin = pin;
            return true;
        }
        return false;
    }

    // pin verification
    public boolean verifyPin(int pin) {
        if (this.pin != null && this.pin.intValue() == pin) {
            return true;
        }
        return false;
    }

    // has pin
    public boolean hasPin() {
        return this.pin != null;
    }

    // close account
    public boolean closeAccount() {
        if (this.status.equalsIgnoreCase("Inactive")) {
            return false;
        }
        this.status = "Inactive";
        return true;
    }

    // reopen account
    public boolean reopenAccount() {
        if (this.status.equalsIgnoreCase("Active")) {
            return false;
        }
        this.status = "Active";
        return true;
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
        this.age = (age < 18) ? 18 : age;
    }

}

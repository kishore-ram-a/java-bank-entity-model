public class CurrentAccount extends Account {
    private double overdraftLimit = 25000.0;

    public CurrentAccount(int accountNumber, String name, int age, double initialBalance, double overdraftLimit) {
        super(accountNumber, name, age, initialBalance, "current");
        this.overdraftLimit = overdraftLimit;
    }

    // get overdraft limit
    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    // set overdraft limit
    public void setOverdraftLimit(double limit) {
        this.overdraftLimit = overdraftLimit > 0 ? limit : this.overdraftLimit;
    }
}

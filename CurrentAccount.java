public class CurrentAccount extends AbstractAccount {
    private double overdraftLimit = 25000.0;

    public CurrentAccount(int accountNumber, String name, int age, double initialBalance, double overdraftLimit) {
        super(accountNumber, name, age, initialBalance, "current");
        this.overdraftLimit = overdraftLimit;
    }

    //debit funciton
    @Override
    protected void processDebit(double amount) throws InsufficientBalanceException{
        if(amount > getBalance() + overdraftLimit){
            throw new InsufficientBalanceException("Insufficient balance");
        }
        setBalance(getBalance() - amount);
    }
    // get overdraft limit
    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    // set overdraft limit
    public void setOverdraftLimit(double limit) {
        this.overdraftLimit = limit > 0 ? limit : this.overdraftLimit;
    }
}

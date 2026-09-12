public class CurrentAccount extends Account {
    private double overdraftLimit = 25000.0;

    public CurrentAccount(int accountNumber, String name, int age, double initialBalance, double overdraftLimit) {
        super(accountNumber, name, age, initialBalance, "current");
        this.overdraftLimit = overdraftLimit;
    }

    //withdraw function
    @Override
    public void withdraw(double amount, int pin) throws InvalidAmountException, InsufficientBalanceException,
            MinimumBalanceViolationException, InactiveAccountException, InvalidPinException{
        if(!hasPin()){
            throw new InvalidPinException("Wrong pin");
        }
        else if(!verifyPin(pin)){
            throw new InvalidPinException("Invalid pin");
        }
        if(!(getStatus().equalsIgnoreCase("active"))){
            throw new InactiveAccountException("Account is inactive");
        }
        if(!(amount > 0)){
            throw new InvalidAmountException("Amount is invalid");
        }if(amount > getBalance() + overdraftLimit){
            throw new InsufficientBalanceException("Insufficient balance");
        }
        else{
            setBalance(getBalance() - amount);
        }
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

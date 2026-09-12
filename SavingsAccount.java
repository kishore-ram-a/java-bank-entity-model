public class SavingsAccount extends Account {
    private static double minBalance = 1000.0;
    private static double interestRate = 0.04;

    public SavingsAccount(int accountNumber, String name, int age, double initialBalance) {
        super(accountNumber, name, age, initialBalance, "savings");
    }

    // calc interest
    public void applyInterest() {
        double balance = this.getBalance();
        double interest = balance * interestRate;
        try {
            this.deposit(interest);
        } catch (InactiveAccountException | InvalidAmountException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Executed successfully");
        }
    }

    //withdraw function
    @Override
    public void withdraw(double amount, int pin) throws AccountException, MinimumBalanceViolationException,InvalidPinException, InsufficientBalanceException, InactiveAccountException, InvalidAmountException{
        if(this.getBalance() - amount < minBalance){
            throw new MinimumBalanceViolationException("Minimum balance requirment not met");
        }
        else{
            super.withdraw(amount, pin);
        }
    }

    // get minimum balance
    public double getMinBalance() {
        return minBalance;
    }

    // get interest rate
    public double getInterestRate() {
        return interestRate;
    }

}

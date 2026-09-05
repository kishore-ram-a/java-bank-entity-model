public class SavingsAccount extends Account {
    private static double minBalance = 1000.0;
    private static double interestRate = 0.04;

    SavingsAccount(int accountNumber, String name, int age, double initialBalance) {
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

    // get minimum balance
    public double getMinBalance() {
        return minBalance;
    }

    // get interest rate
    public double getInterestRate() {
        return interestRate;
    }

}

public class FixedDepositAccount extends Account {
    private int tenureMonths = 12;
    private double interestRate = 0.065;

    public FixedDepositAccount(int accountNumber, String name, int age, double initialBalance, int tenureMonths,
            double interestRate) {
        super(accountNumber, name, age, initialBalance, "fixed_deposit");
        this.tenureMonths = tenureMonths;
        this.interestRate = interestRate / 100.0;
    }

    // calculate maturity amount
    public double calculateMaturityAmount() {
        double balance = this.getBalance();
        double t = tenureMonths / 12.0;
        double sub = (1 + (interestRate / 100));
        double result = balance * Math.pow(sub, t);
        return result;
    }

    //wothdraw function
    @Override
    public void withdraw(double amount, int pin) throws AccountException {
        throw new AccountException("Premature withdrawal not allowed for Fixed Deposit accounts");
    }

    // get tenure months
    public int getTenureMonths() {
        return tenureMonths;
    }

    // get interest rate
    public double getInterestRate() {
        return interestRate;
    }
}

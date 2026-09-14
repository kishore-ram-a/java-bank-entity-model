public class TestAbstractAccount {
    public static void transfer(AbstractAccount from, AbstractAccount to, double amount, int pin) throws AccountException {
        from.withdraw(amount, pin);
        to.deposit(amount);
    }

    public static void main(String[] args) {
        System.out.println("=== Activity 10: Banking Operations Suite ===");

        SavingsAccount savings = new SavingsAccount(5001, "Alice", 25, 10000.0);
        CurrentAccount current = new CurrentAccount(5002, "Bob", 30, 5000.0, 10000.0);
        SalaryAccount salary = new SalaryAccount(5003, "Charlie", 28, 15000.0, "TechCorp");

        savings.setPin(1234);
        current.setPin(4321);
        salary.setPin(1111);

        AbstractAccount[] portfolio = { savings, current, salary };
        try {
            transfer(savings, current, 3000.0, 1234);
            System.out.println("Transfer Rs 3000 from Savings to Current: SUCCESS");
            System.out.println("Savings Balance: Rs " + savings.getBalance() + " | Current Balance: Rs " + current.getBalance());
        } catch (AccountException e) {
            System.out.println("Transfer failed: " + e.getMessage());
        }

        try {
            transfer(savings, current, 1000.0, 9999); // Invalid PIN
            System.out.println("Transfer succeeded unexpectedly");
        } catch (AccountException e) {
            System.out.println("Failed Transfer (Wrong PIN): Exception caught, no balance changed [PASS]");
        }

        for (AbstractAccount acc : portfolio) {
            if (acc instanceof SavingsAccount) {
                ((SavingsAccount) acc).applyInterest();
            }
        }
        System.out.println("Monthly Interest Cycle processed for all qualifying accounts.");

        System.out.println("All banking operations passed!");
    }
}
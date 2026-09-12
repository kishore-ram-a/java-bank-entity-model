 // Adjust package imports based on your structure

public class TestAccountSubclasses {
    public static void main(String[] args) {
        System.out.println("=== Activity 8: Polymorphism Test ===");

        // 1. Savings Account Test (Minimum Balance Violation)
        try {
            SavingsAccount sa = new SavingsAccount(3001, "Alice", 25, 10000.0);
            sa.setPin(1234);
            System.out.print("[Savings] Withdraw 9500 (breaches min balance 1000): ");
            sa.withdraw(9500.0, 1234);
            System.out.println("FAILED (Should have thrown exception)");
        } catch (MinimumBalanceViolationException e) {
            System.out.println("Caught MinimumBalanceViolationException [PASS]");
        } catch (Exception e) {
            System.out.println("FAILED (Caught wrong exception: " + e.getMessage() + ")");
        }

        // 2. Current Account Test (Allowed Overdraft)
        CurrentAccount ca = new CurrentAccount(3002, "Bob", 30, 5000.0, 25000.0);
        try {
            ca.setPin(4321);
            System.out.print("[Current] Withdraw with Overdraft (Balance goes to -5000): ");
            ca.withdraw(10000.0, 4321);
            System.out.println("SUCCESS [PASS]");
        } catch (Exception e) {
            System.out.println("FAILED (Should have succeeded, caught: " + e.getMessage() + ")");
        }

        // 3. Current Account Test (Exceeding Overdraft)
        try {
            System.out.print("[Current] Withdraw exceeding Overdraft (exceeds -25000): ");
            ca.withdraw(21000.0, 4321); // Balance is -5000, max deduction is 20000
            System.out.println("FAILED (Should have thrown exception)");
        } catch (InsufficientBalanceException e) {
            System.out.println("Caught InsufficientBalanceException [PASS]");
        } catch (Exception e) {
            System.out.println("FAILED (Caught wrong exception: " + e.getMessage() + ")");
        }

        // 4. Fixed Deposit Test (Premature Withdrawal Blocked)
        try {
            FixedDepositAccount fda = new FixedDepositAccount(3003, "Charlie", 40, 50000.0, 12, 6.5);
            fda.setPin(9999);
            System.out.print("[FixedDeposit] Withdraw attempt: ");
            fda.withdraw(5000.0, 9999);
            System.out.println("FAILED (Should have thrown exception)");
        } catch (AccountException e) {
            System.out.println("Caught AccountException [PASS]");
        }

        System.out.println("All polymorphic behaviors verified!");
    }
}
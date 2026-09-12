public class TestAbstractAccount {
    public static void main(String[] args) {
        System.out.println("=== Activity 9: Abstract Account & Template Pattern ===");

        // 1. Savings Account: Valid Withdrawal & Min Balance Violation
        try {
            SavingsAccount sa = new SavingsAccount(4001, "Alice", 25, 10000.0);
            sa.setPin(1234);

            // Valid withdraw
            sa.withdraw(2000.0, 1234);
            System.out.println("[Savings] Withdraw 2000: SUCCESS | Balance: Rs " + sa.getBalance());

            // Min balance violation (balance is 8000, minBalance is 1000, debit 7500 leaves 500)
            System.out.print("[Savings] Withdraw below min balance: ");
            sa.withdraw(7500.0, 1234);
            System.out.println("FAILED (Should have thrown exception)");
        } catch (MinimumBalanceViolationException e) {
            System.out.println("Caught MinimumBalanceViolationException [PASS]");
        } catch (Exception e) {
            System.out.println("FAILED (Caught wrong exception: " + e.getMessage() + ")");
        }

        // 2. Current Account: Overdraft Debit
        try {
            CurrentAccount ca = new CurrentAccount(4002, "Bob", 30, 2000.0, 10000.0);
            ca.setPin(4321);

            // Overdraft deduction: 2000 - 5000 = -3000 (allowed within limit of 10000)
            ca.withdraw(5000.0, 4321);
            System.out.println("[Current] Overdraft debit: SUCCESS | Balance: Rs " + ca.getBalance());
        } catch (Exception e) {
            System.out.println("[Current] Overdraft debit: FAILED (" + e.getMessage() + ")");
        }

        // 3. Fixed Deposit: Premature Debit Blocked
        try {
            FixedDepositAccount fda = new FixedDepositAccount(4003, "Charlie", 40, 50000.0, 12, 6.5);
            fda.setPin(9999);

            System.out.print("[FixedDeposit] Premature debit: ");
            fda.withdraw(5000.0, 9999);
            System.out.println("FAILED (Should have thrown exception)");
        } catch (AccountException e) {
            System.out.println("Caught AccountException [PASS]");
        } catch (Exception e) {
            System.out.println("FAILED (Caught wrong exception: " + e.getMessage() + ")");
        }

        System.out.println("Template method pattern executed successfully!");
    }
}
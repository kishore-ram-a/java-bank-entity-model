public class TestAccountEnhanced {
    public static void main(String[] args) {
        System.out.println("=".repeat(50));
        System.out.println("     ENHANCED ACCOUNT TEST (BOOLEAN RETURNS)      ");
        System.out.println("=".repeat(50));

        System.out.println(">>> Test 1: Valid Account Creation");
        AccountEnhanced acc1 = new AccountEnhanced(1001, "John Doe", 25, 1000.0, "Savings");
        printAccountDetails(acc1);

        System.out.println(">>> Test 2: Invalid Age (under 18)");
        System.out.println("Creating account with age 16");
        AccountEnhanced acc2 = new AccountEnhanced(1002, "Young Kid", 16, 500.0, "Savings");
        System.out.println("Age auto-corrected to: " + acc2.getAge());
        printAccountDetails(acc2);

        System.out.println(">>> Test 3: Invalid Account Type");
        System.out.println("Creating account with type \"Invalid\"");
        AccountEnhanced acc3 = new AccountEnhanced(1003, "Test User", 25, 500.0, "Invalid");
        System.out.println("Account type defaulted to: " + acc3.getAccountType());
        printAccountDetails(acc3);

        System.out.println(">>> Test 4: Minimum Balance Enforcement on Creation");
        System.out.println("Creating Savings account with 300 (below minimum)");
        AccountEnhanced acc4 = new AccountEnhanced(1004, "Bob Wilson", 25, 300.0, "Savings");
        System.out.println("Balance auto-corrected to minimum: " + acc4.getBalance());
        printAccountDetails(acc4);

        System.out.println(">>> Test 5: Withdrawal with Minimum Balance");
        AccountEnhanced acc5 = new AccountEnhanced(1005, "Alice Brown", 30, 1000.0, "Current");
        acc5.setPin(1234);
        System.out.print("Initial: ");
        printAccountDetails(acc5);

        if (acc5.withdraw(200.0, 1234)) {
            System.out.println("Withdrawing 200.0: SUCCESS");
            System.out.println("New balance: " + acc5.getBalance());
        } else {
            System.out.println("Withdrawing 200.0: FAILED");
        }
        System.out.print("After withdrawal: ");
        printAccountDetails(acc5);

        if (acc5.withdraw(900.0, 1234)) {
            System.out.println("Withdrawing 900.0 (would leave -100): SUCCESS");
            System.out.println("New balance: " + acc5.getBalance());
        } else {
            System.out.println("Withdrawing 900.0 (would leave -100): FAILED (Minimum balance violation)");
        }
        System.out.println("Current balance: " + acc5.getBalance());

        System.out.println(">>> Test 6: Account Status Management");
        AccountEnhanced acc6 = new AccountEnhanced(1006, "Charlie Green", 35, 2000.0, "Savings");
        System.out.print("Initial: ");
        printAccountDetails(acc6);

        if (acc6.closeAccount()) {
            System.out.println("Closing account: SUCCESS");
        } else {
            System.out.println("Closing account: FAILED");
        }
        System.out.print("After close: ");
        printAccountDetails(acc6);

        if (acc6.deposit(500.0)) {
            System.out.println("Depositing 500.0 to closed account: SUCCESS");
        } else {
            System.out.println("Depositing 500.0 to closed account: FAILED (Account inactive)");
        }

        if (acc6.reopenAccount()) {
            System.out.println("Reopening account: SUCCESS");
        } else {
            System.out.println("Reopening account: FAILED");
        }
        System.out.print("After reopen: ");
        printAccountDetails(acc6);

        System.out.println(">>> Test 7: PIN Protection");
        AccountEnhanced acc7 = new AccountEnhanced(1007, "Diana Prince", 28, 1500.0, "Savings");
        if (acc7.setPin(1234)) {
            System.out.println("Setting PIN 1234: SUCCESS");
        } else {
            System.out.println("Setting PIN 1234: FAILED");
        }

        if (acc7.withdraw(200.0, 1234)) {
            System.out.println("Withdrawing 200.0 with correct PIN (1234): SUCCESS");
            System.out.println("New balance: " + acc7.getBalance());
        } else {
            System.out.println("Withdrawing 200.0 with correct PIN (1234): FAILED");
        }

        if (acc7.withdraw(100.0, 9999)) {
            System.out.println("Withdrawing 100.0 with incorrect PIN (9999): SUCCESS");
        } else {
            System.out.println("Withdrawing 100.0 with incorrect PIN (9999): FAILED (Incorrect PIN)");
        }

        if (acc1.withdraw(100.0, 1234)) {
            System.out.println("Withdrawing 100.0 with PIN not set: SUCCESS");
        } else {
            System.out.println("Withdrawing 100.0 with PIN not set: FAILED (PIN not set)");
        }

        System.out.println(">>> Test 8: All Accounts Summary");
        printAccountDetails(acc1);
        printAccountDetails(acc2);
        printAccountDetails(acc3);
        printAccountDetails(acc4);
        printAccountDetails(acc5);
        printAccountDetails(acc6);
        printAccountDetails(acc7);

        System.out.println("=".repeat(50));
        System.out.println("             ENHANCED TEST COMPLETED!             ");
        System.out.println("=".repeat(50));
    }

    private static void printAccountDetails(AccountEnhanced acc) {
        String pinStatus = acc.hasPin() ? "PIN: Yes" : "PIN: No";
        System.out.println("Account #" + acc.getAccountNumber() + " | " +
                acc.getName() + " (" + acc.getAge() + " yrs) | " +
                acc.getAccountType() + " | " +
                acc.getBalance() + " | " +
                acc.getStatus() + " | " +
                pinStatus);
    }
}
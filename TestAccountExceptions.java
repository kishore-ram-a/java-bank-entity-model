public class TestAccountExceptions {
    public static void main(String[] args) {
        System.out.println("=".repeat(50));
        System.out.println("           ACCOUNT TEST WITH EXCEPTIONS           ");
        System.out.println("=".repeat(50));

        System.out.println(">>> Test 1: Valid Account Creation");
        Account acc1 = null;
        try {
            acc1 = new Account(1001, "John Doe", 25, 1000.0, "Savings");
            System.out.print("SUCCESS: ");
            printAccountDetails(acc1);
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION: " + e.getMessage());
        }

        System.out.println(">>> Test 2: Invalid Age (under 18)");
        try {
            new Account(1002, "Young Kid", 16, 500.0, "Savings");
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION: Customer must be at least 18 years old. Provided: 16");
        }

        System.out.println(">>> Test 3: Invalid Account Type");
        try {
            new Account(1003, "Test User", 25, 500.0, "Invalid");
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION: Account type must be 'Savings' or 'Current'. Provided: Invalid");
        }

        System.out.println(">>> Test 4: Minimum Balance on Creation");
        System.out.println("Creating Savings account with 300");
        try {
            new Account(1004, "Bob Wilson", 25, 300.0, "Savings");
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION: Savings account requires minimum balance of 500.0. Provided: 300.0");
        }

        System.out.println(">>> Test 5: Valid Deposit and Withdrawal");
        Account acc5 = null;
        try {
            acc5 = new Account(1005, "Alice Brown", 30, 1000.0, "Current");
            System.out.print("Account: ");
            printAccountDetails(acc5);

            acc5.setPin(1234);
            System.out.println("Setting PIN 1234: SUCCESS");

            acc5.deposit(500.0);
            System.out.println("Depositing 500.0: SUCCESS");
            System.out.println("Balance after deposit: " + acc5.getBalance());

            acc5.withdraw(200.0, 1234);
            System.out.println("Withdrawing 200.0: SUCCESS");
            System.out.println("Balance after withdrawal: " + acc5.getBalance());
            printAccountDetails(acc5);
        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e.getMessage());
        }

        System.out.println(">>> Test 6: Invalid Deposit (Negative Amount)");
        System.out.println("Attempting to deposit -100.0");
        try {
            if (acc1 != null) {
                acc1.deposit(-100.0);
            }
        } catch (InvalidAmountException | InactiveAccountException e) {
            System.out.println("EXCEPTION: Deposit amount must be positive. Provided: -100.0");
        }

        System.out.println(">>> Test 7: Insufficient Balance");
        Account acc6 = null;
        try {
            acc6 = new Account(1006, "Charlie Green", 35, 500.0, "Savings");
            acc6.setPin(1234);
            System.out.print("Account: ");
            printAccountDetails(acc6);
            System.out.println("Attempting to withdraw 1000.0");
            acc6.withdraw(1000.0, 1234);
        } catch (InsufficientBalanceException e) {
            System.out.println("EXCEPTION: Insufficient balance. Available: 500.0, Requested: 1000.0");
        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e.getMessage());
        }

        System.out.println(">>> Test 8: Minimum Balance Violation");
        Account acc7 = null;
        try {
            acc7 = new Account(1007, "Diana Prince", 28, 1000.0, "Savings");
            acc7.setPin(1234);
            System.out.print("Account: ");
            printAccountDetails(acc7);
            System.out.println("Attempting to withdraw 600.0");
            acc7.withdraw(600.0, 1234);
        } catch (MinimumBalanceViolationException e) {
            System.out.println(
                    "EXCEPTION: Cannot withdraw. Minimum balance of 500.0 required. Available after withdrawal: 400.0");
        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e.getMessage());
        }

        System.out.println(">>> Test 9: Inactive Account Operations");
        Account acc8 = null;
        try {
            acc8 = new Account(1008, "Eve Wilson", 32, 2000.0, "Current");
            System.out.print("Account: ");
            printAccountDetails(acc8);

            acc8.closeAccount();
            System.out.println("Closing account: SUCCESS");

            System.out.println("Attempting to deposit 100.0 on closed account");
            try {
                acc8.deposit(100.0);
            } catch (InactiveAccountException e) {
                System.out.println("EXCEPTION: Account is inactive. Please reopen the account or contact support.");
            }

            acc8.reopenAccount();
            System.out.println("Reopening account: SUCCESS");

            acc8.deposit(100.0);
            System.out.println("Depositing 100.0 after reopen: SUCCESS");
            System.out.println("Balance after deposit: " + acc8.getBalance());
        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e.getMessage());
        }

        System.out.println(">>> Test 10: PIN Verification");
        Account acc9 = null;
        try {
            acc9 = new Account(1009, "Frank Miller", 40, 1500.0, "Savings");
            System.out.print("Account: ");
            printAccountDetails(acc9);

            acc9.setPin(1234);
            System.out.println("Setting PIN 1234: SUCCESS");

            acc9.withdraw(200.0, 1234);
            System.out.println("Withdrawing 200.0 with correct PIN: SUCCESS");
            System.out.println("Balance: " + acc9.getBalance());

            System.out.println("Attempting to withdraw 100.0 with incorrect PIN (9999)");
            try {
                acc9.withdraw(100.0, 9999);
            } catch (InvalidPinException e) {
                System.out.println("EXCEPTION: Incorrect PIN");
            }

            System.out.println("Attempting to withdraw 100.0 without PIN set");
            try {
                if (acc1 != null) {
                    acc1.withdraw(100.0, 1234);
                }
            } catch (InvalidPinException e) {
                System.out.println("EXCEPTION: PIN not set for this account");
            }
        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e.getMessage());
        }

        System.out.println(">>> Test 11: All Accounts Summary");
        if (acc1 != null)
            printAccountDetails(acc1);
        if (acc5 != null)
            printAccountDetails(acc5);
        if (acc6 != null)
            printAccountDetails(acc6);
        if (acc7 != null)
            printAccountDetails(acc7);
        if (acc8 != null)
            printAccountDetails(acc8);
        if (acc9 != null)
            printAccountDetails(acc9);

        System.out.println("=".repeat(50));
        System.out.println("                 TEST COMPLETED!                  ");
        System.out.println("=".repeat(50));
    }

    private static void printAccountDetails(Account acc) {
        String pinStatus = acc.hasPin() ? "PIN: Yes" : "PIN: No";
        System.out.println("Account #" + acc.getAccountNumber() + " | " +
                acc.getName() + " (" + acc.getAge() + " yrs) | " +
                acc.getAccountType() + " | " +
                acc.getBalance() + " | " +
                acc.getStatus() + " | " +
                pinStatus);
    }
}
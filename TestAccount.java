public class TestAccount {
    public static void main(String[] args) {
        System.out.println("=".repeat(50));
        System.out.println("                GLOBAL DIGITAL BANK                 ");
        System.out.println("                    ACCOUNT TEST                    ");
        System.out.println("=".repeat(50));

        // 1. Creating Account
        System.out.println(">>> 1. Creating Account");
        Account acc1 = new Account(1001, "John Doe", 25, 1000.0, "Savings");
        System.out.println("Account created!");
        printAccountDetails(acc1);

        // 2. Deposit Money
        System.out.println(">>> 2. Deposit Money");
        try {
            acc1.deposit(500.0);
            System.out.println("Depositing 500.0: SUCCESS");
            System.out.println("New balance: " + acc1.getBalance());
        } catch (InvalidAmountException | InactiveAccountException e) {
            System.out.println("Depositing 500.0: FAILED (" + e.getMessage() + ")");
        }

        try {
            acc1.deposit(-100.0);
            System.out.println("Depositing -100.0: SUCCESS");
            System.out.println("New balance: " + acc1.getBalance());
        } catch (InvalidAmountException | InactiveAccountException e) {
            System.out.println("Depositing -100.0: FAILED (" + e.getMessage() + ")");
        }

        // 3. Withdraw Money
        System.out.println(">>> 3. Withdraw Money");
        acc1.setPin(1234);

        try {
            acc1.withdraw(200.0, 1234);
            System.out.println("Withdrawing 200.0: SUCCESS");
            System.out.println("New balance: " + acc1.getBalance());
        } catch (AccountException e) {
            System.out.println("Withdrawing 200.0: FAILED (" + e.getMessage() + ")");
        }

        try {
            acc1.withdraw(2000.0, 1234);
            System.out.println("Withdrawing 2000.0: SUCCESS");
            System.out.println("New balance: " + acc1.getBalance());
        } catch (AccountException e) {
            System.out.println("Withdrawing 2000.0: FAILED (" + e.getMessage() + ")");
        }

        System.out.println("Current balance: " + acc1.getBalance());

        // 4. Creating Another Account
        System.out.println(">>> 4. Creating Another Account");
        Account acc2 = new Account(1002, "Jane Smith", 30, 2000.0, "Current");
        printAccountDetails(acc2);

        // 5. All Accounts
        System.out.println(">>> 5. All Accounts");
        printAccountDetails(acc1);
        printAccountDetails(acc2);

        System.out.println("=".repeat(50));
        System.out.println("                  TEST COMPLETED!                  ");
        System.out.println("=".repeat(50));
    }

    private static void printAccountDetails(Account acc) {
        System.out.println("Account #" + acc.getAccountNumber() + " | " +
                acc.getName() + " (" + acc.getAge() + " yrs) | " +
                acc.getAccountType() + " | " +
                acc.getBalance() + " | " +
                acc.getStatus());
    }
}
public class AccountFactory {
    private AccountFactory(){}
    public static IAccount createAccount(String accountType, int accountNumber, String name, int age, double initialBalance){
        switch (accountType.toUpperCase()){
            case "SAVINGS":
                return new SavingsAccount(accountNumber, name, age, initialBalance);
            case "CURRENT":
                return new CurrentAccount(accountNumber, name, age, initialBalance, 10000.0);
            case "FIXED_DEPOSIT":
                return new FixedDepositAccount(accountNumber, name, age, initialBalance, 12, 6.5);
            case "SALARY":
                return new SalaryAccount(accountNumber, name, age, initialBalance, "Corporate");
            default:
                throw new IllegalArgumentException("Unknown account type: " + accountType);
        }
    }
}





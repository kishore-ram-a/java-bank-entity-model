public interface IAccount {
    int getAccountNumber();
    String getName();
    double getBalance();
    String getAccountType();
    String getStatus();

    void deposit(double amount) throws  AccountException;
    void withdraw(double amount, int pin)throws AccountException;
    void displayAccountInfo();
}
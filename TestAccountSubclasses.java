public class TestAccountSubclasses {
    public static void main(String[] args) {
        System.out.println("=== Activity 7: Account Subclasses Test ===");
        SavingsAccount sa = new SavingsAccount(2001, "Alice", 25, 10000.0);
        System.out.println(
                "Savings Account Created: Balance Rs " + sa.getBalance() + " | Min Balance: Rs " + sa.getMinBalance());

        CurrentAccount ca = new CurrentAccount(2002, "Bob", 30, 5000.0, 25000.0);
        System.out.println("Current Account Created: Overdraft Limit Rs " + ca.getOverdraftLimit());

        FixedDepositAccount fda = new FixedDepositAccount(2003, "Charlie", 35, 50000.0, 12, 6.5);
        System.out.println("Fixed Deposit Created: Tenure " + fda.getTenureMonths() + " months | Interest: "
                + fda.getInterestRate() + "%");

        SalaryAccount sla = new SalaryAccount(2004, "Diana", 28, 15000.0, "Infosys");
        System.out.println("Salary Account Created: Employer " + sla.getEmployerName());

        System.out.println("All subclasses instantiated successfully!");
    }
}
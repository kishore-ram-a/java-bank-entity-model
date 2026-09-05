public class SalaryAccount extends Account {
    private String employerName;
    private int inactiveMonths;

    public SalaryAccount(int accountNumber, String name, int age, double initialBalance, String employerName) {
        super(accountNumber, name, age, initialBalance, "salary");
        this.employerName = employerName;
        this.inactiveMonths = 0;
    }

    // get employer name
    public String getEmployerName() {
        return employerName;
    }

    // get inactive months
    public int getInactiveMonths() {
        return inactiveMonths;
    }

    // set inactive months
    public void setInactiveMonths(int inactiveMonths) {
        this.inactiveMonths = inactiveMonths >= 0 ? inactiveMonths : this.inactiveMonths;
    }
}
public class TestInterfaceFactory {
    public static void main(String[] args) {
        System.out.println("=== Activity 11: Interface & Factory Pattern Test ===");

        try {
            IAccount sa = AccountFactory.createAccount("SAVINGS", 6001, "Rajesh Sharma", 25, 5000.0);
            System.out.println("Factory created: " + sa.getAccountType().toUpperCase() + " account for " + sa.getName());

            IAccount ca = AccountFactory.createAccount("CURRENT", 6002, "Priya Patel", 30, 15000.0);
            System.out.println("Factory created: " + ca.getAccountType().toUpperCase() + " account for " + ca.getName());

            IAccount fda = AccountFactory.createAccount("FIXED_DEPOSIT", 6003, "Amit Kumar", 45, 50000.0);
            System.out.println("Factory created: " + fda.getAccountType().toUpperCase() + " account for " + fda.getName());

            IAccount sla = AccountFactory.createAccount("SALARY", 6004, "Sneha Verma", 28, 20000.0);
            System.out.println("Factory created: " + sla.getAccountType().toUpperCase() + " account for " + sla.getName());

            System.out.println("All accounts successfully created through AccountFactory!");
        } catch (Exception e) {
            System.out.println("Test failed with error: " + e.getMessage());
        }
    }
}
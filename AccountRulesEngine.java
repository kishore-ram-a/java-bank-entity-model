import java.util.*;
public class AccountRulesEngine {
    private static Map<String, Double> minBalance = new HashMap<>();
    private static Map<String, Double> interestRate = new HashMap<>();

    static{
        minBalance.put("New", 10000.0);
        interestRate.put("New", 2.70);
        minBalance.put("Standard", 7500.0);
        interestRate.put("Standard", 3.0);
        minBalance.put("Premium", 5000.0);
        interestRate.put("Premium", 3.5);
        minBalance.put("Privilege", 2500.0);
        interestRate.put("Privilege", 4.0);
    }

    public static double getSavingsMinBalance(int tenureYears){
        return tenureYears>= 5 ? 2500.0 : tenureYears >= 3 && tenureYears <= 4 ? 5000.0 : tenureYears >= 1 && tenureYears <= 2 ? 7500.0 : 10000.0;
    }

    public static double getSavingsInterestRate(int tenureYears) {
        return tenureYears >= 5 ? 4.0 : tenureYears >= 3 ? 3.5 : tenureYears >= 1 ? 3.0 : 2.7;
    }

    public static double getCurrentOverdraftLimit(double monthlyTurnover){
        return Math.max(monthlyTurnover * 2.5, 25000.0);
    }

    public static double getFDInterestRate(int months){
        return months <= 3 ? 4.0 : months <= 6 ? 4.75 : months <= 12 ? 5.50 : months <= 24 ? 6.5 : months <= 36 ? 6.75 : months < 60 ? 7.00 : 0.00;
    }


}



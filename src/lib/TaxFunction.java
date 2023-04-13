package lib;

public class TaxFunction {

    public static int calculateTax(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, int deductible, boolean isMarried, int numberOfChildren) {

        int tax = 0;
        int salary = 0;

        if (numberOfMonthWorking > 12) {
                System.err.println("More than 12 month working per year");
        }
        
        if (!isMarried) {
            salary += 54000000;
        } else {
            salary = 54000000 + 4500000;
        }
        
        if (numberOfChildren == 1) {
            salary += 4500000;
        } else if (numberOfChildren == 2) {
            salary += 9000000;
        } else if (numberOfChildren >= 3) {
            salary += 13500000;
        }
        
        int annualIncome = ((monthlySalary + otherMonthlyIncome) * numberOfMonthWorking) - deductible;
        int taxableIncome = annualIncome - salary;
        
        if (taxableIncome > 0) {
            tax = (int) Math.round(0.05 * taxableIncome);
        }
        
        return tax;
    }
}

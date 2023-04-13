package lib;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Employee extends Personal_Info{
    
    private Date dateJoined;
    private int monthWorkingInYear;
    private boolean isForeigner;

    private int monthlySalary;
    private int otherMonthlyIncome;
    private int annualDeductible;

    private Person spouse;
    private final List<String> childNames;
    private final List<String> childIdNumbers;

    public Employee(Personal_Info person, Person spouse, Date dateJoined, boolean isForeigner) {
        
        this.setEmployeeId(person.getEmployeeId());
        this.setFirstName(person.getFirstName());
        this.setLastName(person.getLastName());
        this.setIdNumber(person.getIdNumber());
        this.setAddress(person.getAddress());
        this.setGender(person.getGender());
        
        this.spouse = spouse;
        childNames = new LinkedList<String>();
        childIdNumbers = new LinkedList<String>();
        
        this.dateJoined = dateJoined;
        this.isForeigner = isForeigner;

    }
    
    public void addChild(String childName, String childIdNumber) {
        childNames.add(childName);
        childIdNumbers.add(childIdNumber);
    }

    public int setMonthlySalary(int grade) {	
        switch(grade) {
            case 1:
                monthlySalary = 3000000;
                break;
            case 2:
                monthlySalary = 5000000;
                break;
            case 3:
                monthlySalary = 7000000;
                break;
        }
        if (isForeigner) {
            monthlySalary *= 1.5;
        }
        return monthlySalary;
    }

    public void setAnnualDeductible(int deductible) {	
        this.annualDeductible = deductible;
    }

    public void setAdditionalIncome(int income) {	
        this.otherMonthlyIncome = income;
    }

    public int getAnnualIncomeTax() {

        LocalDate date = LocalDate.now();

        if (date.getYear() == dateJoined.getYear()) {
            monthWorkingInYear = date.getMonthValue() - dateJoined.getMonth();
        }else {
            monthWorkingInYear = 12;
        }

        return TaxFunction.calculateTax(monthlySalary, otherMonthlyIncome, monthWorkingInYear, annualDeductible, spouse.idNumber.equals(""), childIdNumbers.size());
    }
}

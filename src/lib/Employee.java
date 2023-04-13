package lib;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Employee extends Person{
    
    public enum listGender{
        male,
        female
    };

    
    private String employeeId;
    private String address;
    private listGender gender;
    
    private Date dateJoined;
    private int monthWorkingInYear;
    private boolean isForeigner;

    private int monthlySalary;
    private int otherMonthlyIncome;
    private int annualDeductible;

    private Person spouse;
    private final List<String> childNames;
    private final List<String> childIdNumbers;

    public Employee(String employeeId, String firstName, String lastName, String idNumber, String firstNameSpouse, String idNumberSpouse, String lastNameSpouse, String address, Date dateJoined, boolean isForeigner, listGender gender) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = idNumber;
        
        spouse = new Person();
        spouse.firstName = firstNameSpouse;
        spouse.lastName = lastNameSpouse;
        spouse.idNumber = idNumberSpouse;
        
        this.address = address;
        this.dateJoined = dateJoined;
        this.isForeigner = isForeigner;
        this.gender = gender;

        childNames = new LinkedList<String>();
        childIdNumbers = new LinkedList<String>();
    }

    /**
     * Fungsi untuk menentukan gaji bulanan pegawai berdasarkan grade kepegawaiannya (grade 1: 3.000.000 per bulan, grade 2: 5.000.000 per bulan, grade 3: 7.000.000 per bulan)
     * Jika pegawai adalah warga negara asing gaji bulanan diperbesar sebanyak 50%
     */

    public void setMonthlySalary(int grade) {	
        if (grade == 1) {
            monthlySalary = 3000000;
            if (isForeigner) {
                monthlySalary = (int) (3000000 * 1.5);
            }
    }else if (grade == 2) {
            monthlySalary = 5000000;
            if (isForeigner) {
                monthlySalary = (int) (3000000 * 1.5);
            }
    }else if (grade == 3) {
            monthlySalary = 7000000;
            if (isForeigner) {
                monthlySalary = (int) (3000000 * 1.5);
            }
        }
    }

    public void setAnnualDeductible(int deductible) {	
        this.annualDeductible = deductible;
    }

    public void setAdditionalIncome(int income) {	
        this.otherMonthlyIncome = income;
    }

    public void addChild(String childName, String childIdNumber) {
        childNames.add(childName);
        childIdNumbers.add(childIdNumber);
    }

    public int getAnnualIncomeTax() {

        //Menghitung berapa lama pegawai bekerja dalam setahun ini, jika pegawai sudah bekerja dari tahun sebelumnya maka otomatis dianggap 12 bulan.
        LocalDate date = LocalDate.now();

        if (date.getYear() == dateJoined.getYear()) {
            monthWorkingInYear = date.getMonthValue() - dateJoined.getMonth();
        }else {
            monthWorkingInYear = 12;
        }

        return TaxFunction.calculateTax(monthlySalary, otherMonthlyIncome, monthWorkingInYear, annualDeductible, spouse.idNumber.equals(""), childIdNumbers.size());
    }
}

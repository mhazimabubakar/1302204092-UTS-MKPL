/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib;

import java.util.List;

/**
 *
 * @author ASUS
 */
public class Personal_Info extends Person {

    public enum listGender{
        male,
        female
    };

    public String employeeId;
    public String address;
    public listGender gender;
    
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public listGender getGender() {
        return gender;
    }

    public void setGender(listGender gender) {
        this.gender = gender;
    }
    
}

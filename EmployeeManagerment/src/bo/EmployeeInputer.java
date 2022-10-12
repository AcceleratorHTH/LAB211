/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import model.Employee;
import utils.ValidationAndNormalizingTextUtils;

/**
 *
 * @author admin
 */
public class EmployeeInputer {

    private Employee x;

    public Employee getEmployee() {
        return x;
    }

    public EmployeeInputer() {
        x = new Employee();
    }

    public void inputInformation() {
        x.setFirstName(ValidationAndNormalizingTextUtils.getStringByRegex("Enter FirstName: ", "Please enter character only!", "^[a-zA-Z ]*$"));
        x.setLastName(ValidationAndNormalizingTextUtils.getStringByRegex("Enter LastName: ", "Please enter character only!", "^[a-zA-Z ]*$"));
        x.setPhone(ValidationAndNormalizingTextUtils.getPhone(10, "Enter Phone: "));
        x.setEmail(ValidationAndNormalizingTextUtils.getEmail("Enter email: "));
        x.setAddress(ValidationAndNormalizingTextUtils.getStringByRegex("Enter Address: ", "Please do not use special character", "^[a-zA-Z0-9 ]*$"));
//        x.setDateOfBirth(dateOfBirth);
        x.setSex(ValidationAndNormalizingTextUtils.getStringByRegex("Enter Sex: ", "Sex must be Male or Female", "\\bMale\\b|\\bFemale\\b"));
        x.setSalary(ValidationAndNormalizingTextUtils.getInt("Enter Salary: ", "Please enter number!", null, 0, Integer.MAX_VALUE));
        x.setAgency(ValidationAndNormalizingTextUtils.getStringByRegex("Enter Agency: ", "Please enter character only!", "^[a-zA-Z ]*$"));
    }
    
    public void setInformation(Employee e) {
        e.setFirstName(ValidationAndNormalizingTextUtils.getStringByRegex("Enter FirstName: ", "Please enter character only!", "^[a-zA-Z ]*$"));
        e.setLastName(ValidationAndNormalizingTextUtils.getStringByRegex("Enter LastName: ", "Please enter character only!", "^[a-zA-Z ]*$"));
        e.setPhone(ValidationAndNormalizingTextUtils.getPhone(10, "Enter Phone: "));
        e.setEmail(ValidationAndNormalizingTextUtils.getEmail("Enter email: "));
        e.setAddress(ValidationAndNormalizingTextUtils.getStringByRegex("Enter Address: ", "Please do not use special character", "^[a-zA-Z0-9 ]*$"));
//        x.setDateOfBirth(dateOfBirth);
        e.setSex(ValidationAndNormalizingTextUtils.getStringByRegex("Enter Sex: ", "Sex must be Male or Female", "\\bMale\\b|\\bFemale\\b"));
        e.setSalary(ValidationAndNormalizingTextUtils.getInt("Enter Salary: ", "Please enter number!", null, 0, Integer.MAX_VALUE));
        e.setAgency(ValidationAndNormalizingTextUtils.getStringByRegex("Enter Agency: ", "Please enter character only!", "^[a-zA-Z ]*$"));
    }


}

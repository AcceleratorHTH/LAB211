/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import model.Student;
import utils.ValidationAndNormalizingTextUtils;

/**
 *
 * @author admin
 */
public class StudentInputer {

    private Student x;

    public Student getStudent() {
        return x;
    }

    public StudentInputer() {
        x = new Student();
    }

    public void inputInformation() {
        x.setId(ValidationAndNormalizingTextUtils.getNonEmptyString("Enter Id: "));
        x.setName(ValidationAndNormalizingTextUtils.getStringByRegex("Enter Name: ", "Please enter character only!", "^[a-zA-Z ]*$"));
        x.setSemeter(ValidationAndNormalizingTextUtils.getStringByRegex("Enter Semeter: ", "Please do not use special character", "^[a-zA-Z0-9 ]*$"));
        x.setCourseName(ValidationAndNormalizingTextUtils.getStringByRegex("Enter CourseName: ", "There are only three courses: Java, .Net, C/C++", "(?<=^|\\s).Net(?=\\s|$)|(?<=^|\\s)Java(?=\\s|$)|(?<=^|\\s)C\\/C\\+\\+(?=\\s|$)"));
    }
    
    public void inputInformation(Student s) {
        s.setName(ValidationAndNormalizingTextUtils.getStringByRegex("Enter Name: ", "Please enter character only!", "^[a-zA-Z ]*$"));
        s.setSemeter(ValidationAndNormalizingTextUtils.getStringByRegex("Enter Semeter: ", "Please do not use special character", "^[a-zA-Z0-9 ]*$"));
        s.setCourseName(ValidationAndNormalizingTextUtils.getStringByRegex("Enter CourseName: ", "There are only three courses: Java, .Net, C/C++", "(?<=^|\\s).Net(?=\\s|$)|(?<=^|\\s)Java(?=\\s|$)|(?<=^|\\s)C\\/C\\+\\+(?=\\s|$)"));
    }

}

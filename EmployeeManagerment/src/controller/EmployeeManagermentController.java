/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bo.EmployeeInputer;
import bo.EmployeeManagerment;
import model.Node;
import model.Employee;
import utils.*;

/**
 *
 * @author admin
 */
public class EmployeeManagermentController {

    private EmployeeInputer employeeInputer;
    private EmployeeManagerment employeeManagerment;

    public EmployeeManagermentController() {
        employeeManagerment = new EmployeeManagerment();

    }

    public void addEmployee() {
        employeeInputer = new EmployeeInputer();
        employeeInputer.inputInformation();
        Employee x = employeeInputer.getEmployee();
        employeeManagerment.addLast(x);
        System.out.println("Added!\n");
    }

    public void displayEmployee() {
        employeeManagerment.display();
    }

    public void updateEmployee() throws Exception {
        int id = ValidationAndNormalizingTextUtils.getInt("Enter EmployeeId", null, null, 0, Integer.MAX_VALUE);
        Node e = employeeManagerment.searchById(id);
        if(e!= null){
            System.out.println("Found!");
            employeeInputer.setInformation(e.getInfo());
            System.out.println("Updated");
        }
        throw new Exception("Not found!");
        
    }

    public void removeEmployee() {

    }

    public void searchEmployee() {

    }

    public void sortEmployeeBySalary() {

    }

}

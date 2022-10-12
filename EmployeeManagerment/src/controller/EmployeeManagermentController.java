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
        if (employeeManagerment.check(x.getId(), x.getFirstName(), x.getLastName(), x.getDateOfBirth(), x.getSex())) {
            employeeManagerment.addLast(x);
            System.out.println("Added!");
        } else {
            System.out.println("Cannot add! Check the list later to see if some elements have been exist.\n");
        }
    }

    public void addFast() {
        employeeManagerment.addLast(new Employee("HE171493", "Trung", "Pham", "0832270603", "Detectivetrunghth@gmail.com", "Viet Nam", "27/06/2003", "Male", 10000000, "Student"));
        employeeManagerment.addLast(new Employee("HE171228", "Nhi", "Yen", "0911111111", "nhinhyhe171228@gmail.com", "Viet Nam", "09/08/2003", "Female", 1000000, "Student"));

    }

    public void updateEmployee() {
        if (employeeManagerment.isEmpty()) {
            System.err.println("List empty!");
            return;
        }
        String id = ValidationAndNormalizingTextUtils.getNonEmptyString("Enter ID: ");
        Node e = employeeManagerment.searchById(id);
        if (e == null) {
            System.out.println("Employee not found!");
        } else {
            System.out.println("Found!");
            employeeManagerment.visit(e);
            System.out.println("Enter new value to update");
            Employee x = new Employee();
            employeeInputer = new EmployeeInputer();
            employeeInputer.setInformation(x);
            while (!employeeManagerment.check(x.getId(), x.getFirstName(), x.getLastName(), x.getDateOfBirth(), x.getSex())) {
                System.out.println("Cannot update! Check the list later to see if some elements have been exist.");
                boolean choice = ValidationAndNormalizingTextUtils.pressYNtoContinue("Try again? (Y/N): ");
                if (choice) {
                    employeeInputer.setInformation(x);
                } else {
                    return;
                }
            }
            e.setInfo(x);
            System.out.println("Updated!");

        }
    }

    public void removeEmployee() {
        if (employeeManagerment.isEmpty()) {
            System.err.println("List empty!");
            return;
        }
        String id = ValidationAndNormalizingTextUtils.getNonEmptyString("Enter ID: ");
        Node e = employeeManagerment.searchById(id);
        if (e == null) {
            System.out.println("Employee not found!");
        } else {
            System.out.println("Found!");
            employeeManagerment.visit(e);
            boolean choice = ValidationAndNormalizingTextUtils.pressYNtoContinue("Do you really want to delete? (Y/N): ");
            if (!choice) {
                return;
            }
            employeeManagerment.delete(e);
            System.out.println("Deleted!");
        }
    }

    public void searchEmployee() {
        if (employeeManagerment.isEmpty()) {
            System.err.println("List empty!");
            return;
        }
        String firstName = ValidationAndNormalizingTextUtils.getStringByRegex("Enter FirstName: ", "Please enter character only!", "^[a-zA-Z ]*$");
        String lastName = ValidationAndNormalizingTextUtils.getStringByRegex("Enter LastName: ", "Please enter character only!", "^[a-zA-Z ]*$");
        Node e = employeeManagerment.searchByFirstAndLastName(firstName, lastName);
        if (e == null) {
            System.out.println("Employee not found!");
        } else {
            System.out.println("Found!");
            employeeManagerment.visit(e);
        }
    }

    public void sortEmployeeBySalary() {
        if (employeeManagerment.isEmpty()) {
            System.err.println("List empty!");
            return;
        }
        employeeManagerment.sortBySalary();
        employeeManagerment.display();

    }

}

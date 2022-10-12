/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bo.StudentInputer;
import bo.StudentManagerment;
import java.util.ArrayList;
import model.Node;
import model.Student;
import utils.*;

/**
 *
 * @author admin
 */
public class StudentManagermentController {

    private StudentInputer studentInputer;
    private StudentManagerment studentManagerment;

    public StudentManagermentController() {
        studentManagerment = new StudentManagerment();

    }

    public void addStudent() {
        for (int i = 0; i < 2; i++) {
            studentInputer = new StudentInputer();
            studentInputer.inputInformation();
            Student x = studentInputer.getStudent();
            if (studentManagerment.checkDuplicateId(x.getId())) {
                studentManagerment.addLast(x);
                System.out.println("Added!\n");
            } else {
                System.out.println("Id already existed!\n");
            }
        }
        boolean choice;
        do {
            choice = ValidationAndNormalizingTextUtils.pressYNtoContinue("Do you want to continue (Y/N)? Choose Y to continue, N to return main screen: ");
            if (choice) {
                studentInputer = new StudentInputer();
                studentInputer.inputInformation();
                Student x = studentInputer.getStudent();
                if (studentManagerment.checkDuplicateId(x.getId())) {
                    studentManagerment.addLast(x);
                    System.out.println("Added!\n");
                } else {
                    System.out.println("Id already existed!\n");
                }
            }
        } while (choice);

    }

    private void findStudent() {
        String name = ValidationAndNormalizingTextUtils.getStringByRegex("Enter Name: ", "Please enter character only!", "^[a-zA-Z ]*$");
        StudentManagerment temp = studentManagerment;
        while (true) {
            Node s = temp.searchByName(name);
            if (s == null) {
                break;
            } else {
                temp.visit(s);
                temp.delete(s);
            }
        }
    }

    private void sortStudent() {
        studentManagerment.sortByName();
        studentManagerment.display();
    }

    public void findOrSortStudent() {
        String choice = ValidationAndNormalizingTextUtils.getStringByRegex("Do you want to find (F) or sort (S) student?: ", "Please enter F or S", "\\bF\\b|\\bS\\b");
        switch (choice) {
            case "F":
                findStudent();
                break;
            case "S":
                sortStudent();
                break;

        }
    }

    public void updateOrDeleteStudent() {
        String id = ValidationAndNormalizingTextUtils.getNonEmptyString("Enter ID: ");
        Node s = studentManagerment.searchById(id);
        if (s == null) {
            System.out.println("Student not found!");
        } else {
            System.out.println("Found!");
            studentManagerment.visit(s);
            String choice = ValidationAndNormalizingTextUtils.getStringByRegex("Do you want to update (U) or delete (D) student?: ", "Please enter U or D", "\\bU\\b|\\bD\\b");
            switch (choice) {
                case ("U"):
                    studentInputer.inputInformation(s.getInfo());
                    System.out.println("Updated!");
                    break;
                case ("D"):
                    studentManagerment.delete(s);
                    System.out.println("Deleted!");
                    break;
            }
        }
    }

    public void displayWithTotalCourse() {

    }

}

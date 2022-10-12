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
        int n = ValidationAndNormalizingTextUtils.getInt("How many students you want to add? (By number): ", "Please enter integer!", "Number is too big", 0, Integer.MAX_VALUE);
        System.out.println("");
        for (int i = 0; i < n; i++) {
            studentInputer = new StudentInputer();
            studentInputer.inputInformation();
            Student x = studentInputer.getStudent();
            if (studentManagerment.check(x.getId(), x.getName(), x.getSemeter(), x.getCourseName())) {
                studentManagerment.addLast(x);
                System.out.println("Added!\n");
            } else {
                System.out.println("Cannot add! Check the list later to see if some elements have been exist.\n");
            }
        }
        boolean choice;
        do {
            choice = ValidationAndNormalizingTextUtils.pressYNtoContinue("Do you want to continue (Y/N)? Choose Y to continue, N to return main screen: ");
            if (choice) {
                studentInputer = new StudentInputer();
                studentInputer.inputInformation();
                Student x = studentInputer.getStudent();
                if (studentManagerment.check(x.getId(), x.getName(), x.getSemeter(), x.getCourseName())) {
                    studentManagerment.addLast(x);
                    System.out.println("Added!\n");
                } else {
                    System.out.println("Cannot add! Check the list later to see if some elements have been exist.\n");
                }
            }
        } while (choice);

    }

    public void findAndSortStudent() {
        String name = ValidationAndNormalizingTextUtils.getStringByRegex("Enter Name: ", "Please enter character only!", "^[a-zA-Z ]*$");
        Node p = studentManagerment.getHead();
        StudentManagerment temp = new StudentManagerment();
        while (p != null) {
            if (p.getInfo().getName().equals(name)) {
                temp.addLast(p.getInfo());
            }
            p = p.getNext();
        }
        temp.sortByName();
        temp.display();

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
                    Student x = new Student();

                    studentInputer.setInformation(x);
                    while (!studentManagerment.check(x.getId(), x.getName(), x.getSemeter(), x.getCourseName())) {
                        System.out.println("Cannot update! Check the list later to see if some elements have been exist.");
                        studentInputer.setInformation(x);
                    }
                    s.setInfo(x);
                    System.out.println("Updated!");
                    break;
                case ("D"):
                    studentManagerment.delete(s);
                    System.out.println("Deleted!");
                    break;
            }
        }
    }

}

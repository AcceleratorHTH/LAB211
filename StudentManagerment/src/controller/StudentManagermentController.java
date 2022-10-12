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
import model.Report;
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
        if (studentManagerment.isEmpty()) {
            System.err.println("List empty!");
            return;
        }
        String name = ValidationAndNormalizingTextUtils.getStringByRegex("Enter Name: ", "Please enter character only!", "^[a-zA-Z ]*$");
        Node p = studentManagerment.getHead();
        StudentManagerment temp = new StudentManagerment();
        while (p != null) {
            if (p.getInfo().getName().equals(name)) {
                temp.addLast(p.getInfo());
            }
            p = p.getNext();
        }
        if (temp.isEmpty()) {
            System.out.println("Not found any!");
        } else {
            temp.sortByName();
            temp.display();
        }
    }

    public void updateOrDeleteStudent() {
        if (studentManagerment.isEmpty()) {
            System.err.println("List empty!");
            return;
        }
        String id = ValidationAndNormalizingTextUtils.getNonEmptyString("Enter ID: ");
        String semeter = ValidationAndNormalizingTextUtils.getStringByRegex("Enter Semeter: ", "Please do not use special character", "^[a-zA-Z0-9 ]*$");
        String courseName = ValidationAndNormalizingTextUtils.getStringByRegex("Enter CourseName: ", "There are only three courses: Java, .Net, C/C++", "(?<=^|\\s).Net(?=\\s|$)|(?<=^|\\s)Java(?=\\s|$)|(?<=^|\\s)C\\/C\\+\\+(?=\\s|$)");
        Node s = studentManagerment.search(id, semeter, courseName);
        if (s == null) {
            System.out.println("Student not found!");
        } else {
            System.out.println("Found!");
            studentManagerment.visit(s);
            String choice = ValidationAndNormalizingTextUtils.getStringByRegex("Do you want to update (U) or delete (D) student?: ", "Please enter U or D", "\\bU\\b|\\bD\\b");
            switch (choice) {
                case ("U"):
                    Student x = new Student();
                    studentInputer = new StudentInputer();
                    studentInputer.setInformation(x);
                    while (!studentManagerment.check(x.getId(), x.getName(), x.getSemeter(), x.getCourseName())) {
                        System.out.println("Cannot update! Check the list later to see if some elements have been exist.");
                        boolean choic = ValidationAndNormalizingTextUtils.pressYNtoContinue("Try again? (Y/N): ");
                        if (choic) {
                            studentInputer.setInformation(x);
                        } else {
                            return;
                        }
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

    public void addFast() {

        studentManagerment.addLast(new Student("HE171493", "Pham Quoc Trung", "Summer 2022", "Java"));
        studentManagerment.addLast(new Student("HE171234", "Pham Thi Minh Thuy", "Fall 2022", "Java"));
        studentManagerment.addLast(new Student("HE175678", "Bui Tien Anh", "Spring 2022", "Java"));
        studentManagerment.addLast(new Student("HE170910", "Tran Trong Duc", "Spring 2022", ".Net"));
        studentManagerment.addLast(new Student("HE171493", "Pham Quoc Trung", "Fall 2022", "Java"));
        studentManagerment.addLast(new Student("HE171493", "Pham Quoc Trung", "Fall 2022", "C/C++"));

        studentManagerment.display();

    }

    public void report() {
        if (studentManagerment.isEmpty()) {
            System.err.println("List empty!");
            return;
        }
        ArrayList<Report> listReport = new ArrayList<>();
        for (Node p = studentManagerment.getHead(); p != null; p = p.getNext()) {
            int total = 0;
            for (Node q = studentManagerment.getHead(); q != null; q = q.getNext()) {
                if (p.getInfo().getId().equals(q.getInfo().getId())
                        && p.getInfo().getCourseName().equals(q.getInfo().getCourseName())) {
                    total++;
                }
            }
            if (ValidationAndNormalizingTextUtils.checkReportExist(listReport, p.getInfo().getName(), p.getInfo().getCourseName(), total)) {
                Report rp = new Report(p.getInfo(), total);
                listReport.add(rp);
            }
            total = 0;
        }

        for (int i = 0; i < listReport.size(); i++) {
            System.out.printf("%-20s|%-10s|%-5d\n", listReport.get(i).getStudent().getName(), listReport.get(i).getStudent().getCourseName(), listReport.get(i).getTotalCourse());
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author admin
 */
public class Employee {

    private String id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String address;
    private String dateOfBirth;
    private String sex;
    private int salary;
    private String agency;

    public Employee() {
    }

    public Employee(String id, String firstName, String lastName, String phone, String email, String address, String dateOfBirth, String sex, int salary, String agency) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.salary = salary;
        this.agency = agency;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getSex() {
        return sex;
    }

    public int getSalary() {
        return salary;
    }

    public String getAgency() {
        return agency;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    @Override
    public String toString() {
        return String.format("%-8s | %-8s | %-8s | %-11s | %-30s | %-11s | %-11s | %-7s | %-10d | %-7s ", id, firstName, lastName, phone, email, address, dateOfBirth, sex, salary, agency);
    }

}

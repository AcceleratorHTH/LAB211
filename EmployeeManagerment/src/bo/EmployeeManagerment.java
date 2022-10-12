/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import model.*;

/**
 *
 * @author admin
 */
public class EmployeeManagerment {

    private Node head;
    private Node tail;

    public EmployeeManagerment() {
        head = tail = null;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    private void clear() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void addLast(Employee x) {
        Node q = new Node(x);
        if (isEmpty()) {
            head = tail = q;
            return;
        }
        tail.setNext(q);
        tail = q;
    }

    public Node searchById(String xId) {
        Node p = head;
        while (p != null) {
            if (p.getInfo().getId().equals(xId)) {
                return (p);
            }
            p = p.getNext();
        }
        return (null);
    }
    
    public Node searchByFirstAndLastName(String xFirstName, String xLastName) {
        Node p = head;
        while (p != null) {
            if (p.getInfo().getFirstName().equals(xFirstName) && p.getInfo().getLastName().equals(xLastName)) {
                return (p);
            }
            p = p.getNext();
        }
        return (null);
    }

    public void sortBySalary() {
        Node pi, pj;
        Employee x;

        for (pi = head; pi != null; pi = pi.getNext()) {
            for (pj = pi.getNext(); pj != null; pj = pj.getNext()) {
                if (pj.getInfo().getSalary() < pi.getInfo().getSalary()) {
                    x = pi.getInfo();
                    pi.setInfo(pj.getInfo());
                    pj.setInfo(x);
                }
            }
        }
    }

    private void deleteFirst() {
        if (head == null) {
            return;
        }
        head = head.getNext();
        if (head == null) {
            tail = null;
        }
    }

    public void delete(Node q) {
        if (q == null) {
            return;
        }

        if (q == head) {
            deleteFirst();
            return;
        }

        Node f = head;
        while (f != null && f.getNext() != q) {
            f = f.getNext();
        }
        if (f == null) {
            return;
        }

        Node q1 = q.getNext();
        f.setNext(q1);

        if (f.getNext() == null) {
            tail = f;
        }
    }

    public void updateEmployee(Node p, Employee x) {
        if (p != null) {
            p.setInfo(x);
        }
    }

    public void visit(Node q) {
        if (q != null) {
            System.out.println(q.getInfo());
        }
    }

    public void display() {
        Node p = head;
        while (p != null) {
            visit(p);
            p = p.getNext();
        }
        System.out.println();
    }

    //Check Duplicate    
    private Boolean checkDuplicateId(String xId) {
        Node p = head;
        while (p != null) {
            if (p.getInfo().getId().equals(xId)) {
                return false;
            }
            p = p.getNext();
        }
        return true;
    }

    private Boolean checkDuplicateFirstName(String xFirstName) {
        Node p = head;
        while (p != null) {
            if (p.getInfo().getFirstName().equals(xFirstName)) {
                return false;
            }
            p = p.getNext();
        }
        return true;
    }

    private Boolean checkDuplicateLastName(String xLastName) {
        Node p = head;
        while (p != null) {
            if (p.getInfo().getLastName().equals(xLastName)) {
                return false;
            }
            p = p.getNext();
        }
        return true;
    }

    private Boolean checkDuplicatePhone(String xPhone) {
        Node p = head;
        while (p != null) {
            if (p.getInfo().getPhone().equals(xPhone)) {
                return false;
            }
            p = p.getNext();
        }
        return true;
    }

    private Boolean checkDuplicateEmail(String xEmail) {
        Node p = head;
        while (p != null) {
            if (p.getInfo().getEmail().equals(xEmail)) {
                return false;
            }
            p = p.getNext();
        }
        return true;
    }

    private Boolean checkDuplicateAddress(String xAddress) {
        Node p = head;
        while (p != null) {
            if (p.getInfo().getAddress().equals(xAddress)) {
                return false;
            }
            p = p.getNext();
        }
        return true;
    }

    private Boolean checkDuplicateDate(String xDate) {
        Node p = head;
        while (p != null) {
            if (p.getInfo().getDateOfBirth().equals(xDate)) {
                return false;
            }
            p = p.getNext();
        }
        return true;
    }

    private Boolean checkDuplicateSex(String xSex) {
        Node p = head;
        while (p != null) {
            if (p.getInfo().getSex().equals(xSex)) {
                return false;
            }
            p = p.getNext();
        }
        return true;
    }

    private Boolean checkDuplicateSalary(int xSalary) {
        Node p = head;
        while (p != null) {
            if (p.getInfo().getSalary() == xSalary) {
                return false;
            }
            p = p.getNext();
        }
        return true;
    }

    private Boolean checkDuplicateAgency(String xAgency) {
        Node p = head;
        while (p != null) {
            if (p.getInfo().getAgency().equals(xAgency)) {
                return false;
            }
            p = p.getNext();
        }
        return true;
    }

    /**
     * ID trùng -> FirstName, LastName k trùng -> k add -> FirstName, LastName
     * trùng -> DOB, Sex k trùng -> k add -> DOB, Sex trùng -> add ID ko trùng
     * -> tùy ý
     *
     * trùng = false k trùng = true
*
     */
    
    public Boolean check(String xId, String xFirstName, String xLastName, String xDateOfBirth, String xSex) {
        if (!checkDuplicateId(xId)) {
            if (checkDuplicateFirstName(xFirstName) && checkDuplicateLastName(xLastName) && checkDuplicateDate(xDateOfBirth) && checkDuplicateSex(xSex)) {
                return true; //ok
            } else {
                return false; // not
            }
        }
        return true;
    }

}

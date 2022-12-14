/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import java.util.ArrayList;
import model.*;

/**
 *
 * @author admin
 */
public class StudentManagerment {

    private Node head;
    private Node tail;

    public StudentManagerment() {
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

    public void addLast(Student x) {
        Node q = new Node(x);
        if (isEmpty()) {
            head = tail = q;
            return;
        }
        tail.setNext(q);
        tail = q;
    }

    public Node search(String xId, String xSemeter, String xCourseName) {
        Node p = head;
        while (p != null) {
            if (p.getInfo().getId().equals(xId) && p.getInfo().getSemeter().equals(xSemeter) && p.getInfo().getCourseName().equals(xCourseName)) {
                return (p);
            }
            p = p.getNext();
        }
        return (null);
    }

    public void sortByName() {
        Node pi, pj;
        Student x;

        for (pi = head; pi != null; pi = pi.getNext()) {
            for (pj = pi.getNext(); pj != null; pj = pj.getNext()) {
                if (pj.getInfo().getName().compareTo(pi.getInfo().getName()) < 0) {
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

    public void updateStudent(Node p, Student x) {
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

    private Boolean checkDuplicateName(String xName) {
        Node p = head;
        while (p != null) {
            if (p.getInfo().getName().equals(xName)) {
                return false;
            }
            p = p.getNext();
        }
        return true;
    }

    private Boolean checkDuplicateCourseName(String xCourseName) {
        Node p = head;
        while (p != null) {
            if (p.getInfo().getCourseName().equals(xCourseName)) {
                return false;
            }
            p = p.getNext();
        }
        return true;
    }

    private Boolean checkDuplicateSemeter(String xSemeter) {
        Node p = head;
        while (p != null) {
            if (p.getInfo().getSemeter().equals(xSemeter)) {
                return false;
            }
            p = p.getNext();
        }
        return true;
    }

    public Boolean check(String xId, String xName, String xSemeter, String xCourseName) { //true = ko dup, false = dup
        if (checkDuplicateId(xId) == false) {
            if (checkDuplicateName(xName) == true) {
                return false;
            } else {
                if (checkDuplicateSemeter(xSemeter) == false) {
                    if (checkDuplicateCourseName(xCourseName) == false) {
                        return false;
                    } else {
                        return true;
                    }
                } else {
                    return true;
                }
            }
        } else {
            return true;
        }

    }

}

/**
 * ID gi???ng - Name ko gi???ng -> ko add - Name gi???ng - Semeter gi???ng - CourseName
 * gi???ng => ko add - CourseName ko gi???ng => add - Semeter ko gi???ng - CourseName
 * ko c???n check => add ID kh??ng gi???ng - Name t??y ?? - Semeter t??y ?? - CourseName
 * t??y ??
 */

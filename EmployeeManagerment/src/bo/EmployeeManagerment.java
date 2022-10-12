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
    private int lastId;

    public EmployeeManagerment() {
        head = tail = null;
        lastId = 0;
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
        x.setId(++lastId);
        Node q = new Node(x);
        if (isEmpty()) {
            head = tail = q;
            return;
        }
        tail.setNext(q);
        tail = q;
    }

//    public Node searchByName(String xName) {
//        Node p = head;
//        while (p != null) {
//            if (p.getInfo().getName().equals(xName)) {
//                return (p);
//            }
//            p = p.getNext();
//        }
//        return (null);
//    }

    public Node searchById(int xId) {
        Node p = head;
        while (p != null) {
            if (p.getInfo().getId() == xId) {
                return (p);
            }
            p = p.getNext();
        }
        return (null);
    }

//    public void sortByName() {
//        Node pi, pj;
//        Employee x;
//
//        for (pi = head; pi != null; pi = pi.getNext()) {
//            for (pj = pi.getNext(); pj != null; pj = pj.getNext()) {
//                if (pj.getInfo().getName().compareTo(pi.getInfo().getName()) < 0) {
//                    x = pi.getInfo();
//                    pi.setInfo(pj.getInfo());
//                    pj.setInfo(x);
//                }
//            }
//        }
//    }

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

}

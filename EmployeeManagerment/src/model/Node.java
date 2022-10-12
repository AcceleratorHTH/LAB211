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
public class Node {
    
    private Employee info;
    private Node next;

    public Node(Employee x) {
        this(x, null);
    }

    public Node(Employee x, Node q) {
        this.info = x;
        this.next = q;
    }

    public Employee getInfo() {
        return info;
    }

    public void setInfo(Employee info) {
        this.info = info;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    
}

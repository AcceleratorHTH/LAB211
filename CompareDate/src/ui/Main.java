/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import utils.*;
import bo.*;
import java.util.Date;

/**
 *
 * @author admin
 */
public class Main {

    public static void main(String[] args) {
        Date dateOne = DateUtils.inputDate("Please enter the first date: ");
        Date dateTwo = DateUtils.inputDate("Please enter the second date: ");
        System.out.println("");
        CompareDate comp = new CompareDate();
        int ret = comp.compareDate(dateOne, dateTwo);
        if (ret == -1) {
            System.out.println("Date1 is before Date2");
        } else if (ret == 1) {
            System.out.println("Date1 is after Date2");
        } else {
            System.out.println("Date1 is equal Date2");
        }

    }
}

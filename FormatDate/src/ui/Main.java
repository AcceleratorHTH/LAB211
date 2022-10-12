/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import utils.*;
import bo.*;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author admin
 */
public class Main {

    public static void main(String[] args) {
        Date date = DateUtils.inputDate("Please enter date with format [dd/mm/yyyy]: ");
        DayDetermine day = new DayDetermine();
        System.out.println("Your day is " + day.determineDay(date, Locale.ENGLISH));
    }
}

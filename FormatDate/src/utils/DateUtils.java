/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class DateUtils {

    private static boolean checkContainCharacter(String input) {
        boolean isContain = false;

        for (int i = 0; i < input.length(); i++) {
            if (!(input.charAt(i) >= '/' && input.charAt(i) <= '9')) {
                isContain = true;
            }
        }
        return isContain;
    }

    public static Date inputDate(String mess) {
        Scanner sc = new Scanner(System.in);
        String input;
        Date date;
        do {
            System.out.print(mess);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            dateFormat.setLenient(false);
            input = sc.nextLine();
            if (input.isEmpty()) {
                System.err.println("Input could not be empty!!!");
                continue;
            } else if (!checkContainCharacter(input)) {
                if (!input.matches("\\d{2}[/]\\d{2}[/]\\d{4}")) {
                    System.err.println("Input is wrong format date");
                    continue;
                }
                try {
                    date = dateFormat.parse(input);
                    break;
                } catch (ParseException ex) {
                    System.err.println("Date doesn't existed!!");
                }
            } else {
                System.err.println("Contain special character. Please enter again!");
            }
        } while (true);
        return date;
    }
}

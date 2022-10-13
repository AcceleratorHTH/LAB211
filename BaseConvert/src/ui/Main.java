package ui;

import controller.BaseConvertController;
import utils.ValidationAndNormalizingTextUtils;

public class Main {

    public static void main(String[] args) {
        BaseConvertController baseConvertController = new BaseConvertController();
        String menu = "1. Binary\n"
                + "2. Decimal\n"
                + "3. Hexadecimal\n"
                + "4. Exit\n";
        do {
            System.out.println("WELCOME TO MY BASE CONVERTER");
            System.out.println(menu);
            System.out.println("Converted value: " + baseConvertController.baseConvert());
        } while (ValidationAndNormalizingTextUtils.pressYNtoContinue("Again? (Y/N): "));
    }
}

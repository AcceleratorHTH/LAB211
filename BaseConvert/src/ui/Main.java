package ui;

import bo.BaseConvert;
import bo.ValueInput;
import model.BaseType;
import utils.ValidationAndNormalizingTextUtils;

public class Main {

    public static void main(String[] args) {
        BaseConvert baseConvert = new BaseConvert();
        ValueInput valueInput = new ValueInput();
        System.out.println("WELCOME TO MY BASE CONVERTER");
        String menu = "1. Binary\n"
                + "2. Decimal\n"
                + "3. Hexadecimal\n"
                + "4. Exit\n";
        do {
            System.out.println(menu);
            String numString = "";
            BaseType originalBase = valueInput.getBaseByChoice("Enter your original base: ", null);
            BaseType convertBase = valueInput.getBaseByChoice("Enter base of converted value: ", originalBase);
            numString = valueInput.inputNumberByChoice(originalBase);
            String convertedString = baseConvert.convertNumberByChoice(numString, originalBase, convertBase);
            System.out.println("Converted value: " + convertedString);
        } while (ValidationAndNormalizingTextUtils.pressYNtoContinue("Again? (Y/N): "));
    }
}

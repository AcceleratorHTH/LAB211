package ui;

import bo.BaseConverter;
import bo.NumberInputer;
import model.BaseType;
import utils.ValidationAndNormalizingTextUtils;

public class Main {
    public static void main(String[] args) {
        BaseConverter baseConverter = new BaseConverter();
        NumberInputer numberInputer = new NumberInputer();
        String menu = "WELCOME TO BASE CONVERTER\n" +
                "1. Binary\n" +
                "2. Decimal\n" +
                "3. Hexadecimal\n" +
                "4. Exit\n";
        do {
            System.out.println(menu);
            String numString = "";
            BaseType originalBase = numberInputer.getBaseByChoice("Enter original base: ", null);
            BaseType convertBase = numberInputer.getBaseByChoice("Enter base of converted number: ", originalBase);
            numString = numberInputer.inputNumberByChoice(originalBase);
            String convertedString = baseConverter.convertNumberByChoice(numString, originalBase, convertBase);
            System.out.println("Converted number: " + convertedString);
        } while(ValidationAndNormalizingTextUtils.pressYNtoContinue("Again? (Y/N): "));
    }
}

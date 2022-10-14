/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import model.BaseType;
import utils.ValidationAndNormalizingTextUtils;

/**
 *
 * @author admin
 */

public class BaseConvert {

    private static String BIT_STRING = "0123456789ABCDEF";

    public BaseConvert() {
    }

    private String decToBase(String input, BaseType type) {
        String ret = "";
        if (input.equals("0")) {
            return "0";
        } else {
            int number = Integer.parseInt(ValidationAndNormalizingTextUtils.removeAllBlank(input));
            while (number != 0) {
                int remainder = number % type.getBaseToInt();
                ret = BIT_STRING.charAt(remainder) + ret;
                number /= type.getBaseToInt();
            }
        }
        return ret;
    }

    private String baseToDec(String input, BaseType type) {
        int ret = 0;
        String str = input.toUpperCase();
        for (int i = 0; i < input.length(); i++) {
            ret += BIT_STRING.indexOf(str.charAt(i)) * Math.pow(type.getBaseToInt(), str.length() - 1 - i);
        }
        return ret + "";
    }

    private String binToDec(String input) {
        return baseToDec(input, BaseType.Binary);
    }

    private String hexToDec(String input) {
        return baseToDec(input, BaseType.Hexadecimal);
    }

    private String decToBin(String input) {
        return decToBase(input, BaseType.Binary);
    }

    private String decToHex(String input) {
        return decToBase(input, BaseType.Hexadecimal);
    }

    private String hexToBin(String input) {
        return decToBin(hexToDec(input));
    }

    private String binToHex(String input) {
        return decToHex(binToDec(input));
    }

    public String convertNumberByChoice(String numString, BaseType inputBase, BaseType convertBase) {
        if (convertBase.equals(BaseType.Decimal)) {
            return baseToDec(numString, inputBase);
        }
        switch (inputBase) {
            case Binary:
                return binToHex(numString);
            case Decimal:
                return decToBase(numString, convertBase);
            case Hexadecimal:
                return hexToBin(numString);
            default:
                throw new AssertionError();
        }
    }

}

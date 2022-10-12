package bo;

import model.BaseType;
import utils.ValidationAndNormalizingTextUtils;

public class NumberInputer {
    public NumberInputer() {
    }

    public String inputNumberByChoice(BaseType type) {
        String regex = "";
        switch (type) {
            case Binary:
                regex = "[0-1 ]+";
                break;
            case Decimal:
                regex = "[0-9 ]+";
                break;
            case Hexadecimal:
                regex = "[0-9A-Fa-f ]+";
                break;
            default:
                System.exit(0);
        }
        String ret = ValidationAndNormalizingTextUtils.getStringByRegex("Enter your " + type + " value: ", "Please enter " + type + " value", regex).toUpperCase();
        return ret;
    }
    public BaseType getBaseByChoice(String mess, BaseType originalBase) {
        BaseType base = null;
        do {
            int choice = ValidationAndNormalizingTextUtils.getInt(mess, "Integer number only!", "Please enter number in range of [1, 4]", 1, 4);
            switch (choice) {
                case 1:
                    base = BaseType.Binary;
                    break;
                case 2:
                    base = BaseType.Decimal;
                    break;
                case 3:
                    base = BaseType.Hexadecimal;
                    break;
                case 4:
                    System.exit(0);
                    break;
            }

            if (base.equals(originalBase)) {
                System.out.println("Base cannot be the same with original one! Try again!");
            } else {
                return base;
            }
        } while (true);
    }
}

package model;

public enum BaseType {
    Binary, Decimal, Hexadecimal;
    public  int getBaseToInt(){
        switch (this) {
            case Binary:
                return 2;
            case Decimal:
                return 10;
            case Hexadecimal:
                return 16;
            default:
                throw new AssertionError();
        }
    }

}

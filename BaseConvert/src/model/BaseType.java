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
public enum BaseType {
    Binary, Decimal, Hexadecimal;

    public int getBaseToInt() {
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

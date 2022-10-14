/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author admin
 */
import bo.BaseConvert;
import bo.ValueInput;
import model.BaseType;

public class BaseConvertController {

    private BaseConvert baseConvert;
    private ValueInput valueInput;

    public BaseConvertController() {
        baseConvert = new BaseConvert();
        valueInput = new ValueInput();
    }

    public String baseConvert() {
        BaseType originalBase = valueInput.getBaseByChoice("Enter your original base: ", null);
        BaseType convertBase = valueInput.getBaseByChoice("Enter base of converted value: ", originalBase);

        String valueString = valueInput.inputNumberByChoice(originalBase);
        String convertedString = baseConvert.convertNumberByChoice(valueString, originalBase, convertBase);

        return convertedString;
    }
}

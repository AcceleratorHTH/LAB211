/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author admin
 */
public class DayDetermine {

    public DayDetermine() {
    }

    public String determineDay(Date date, Locale locale) {
        DateFormat det = new SimpleDateFormat("EEEE", locale);
        return det.format(date);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import java.util.Date;

/**
 *
 * @author admin
 */
public class CompareDate {

    public CompareDate() {
    }

    public int compareDate(Date firstDate, Date secondDate) {
        if (firstDate.before(secondDate)) {
            return -1;
        } else if (firstDate.after(secondDate)) {
            return 1;
        } else {
            return 0;
        }
    }

}

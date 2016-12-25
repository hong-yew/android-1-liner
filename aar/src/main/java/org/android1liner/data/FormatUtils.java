package org.android1liner.data;

import java.math.BigDecimal;

/**
 * Created by hongyew on 26/12/2016.
 */

public class FormatUtils {
    private FormatUtils() {}

    public static String formatCurrency(Double value) {
        if (value != null) {
            return "$" + BigDecimal.valueOf(value).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
        }
        else {
            return null;
        }
    }

    public static String formatDecimal(Double value, int decimal) {
        if (value != null) {
            return BigDecimal.valueOf(value).setScale(decimal, BigDecimal.ROUND_HALF_UP).toString();
        }
        else {
            return null;
        }
    }

}

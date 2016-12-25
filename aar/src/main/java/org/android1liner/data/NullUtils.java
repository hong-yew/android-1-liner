package org.android1liner.data;

import android.widget.EditText;

import static android.text.TextUtils.isEmpty;

/**
 * Created by hongyew on 26/12/2016.
 */

public class NullUtils {
    private NullUtils() {}

    /**
     * If the EditText is empty or null, return null. Otherwise the text.
     * @param view
     * @return
     */
    public static String stringOrNull(EditText view) {
        if (view == null) return null;
        String text = view.getText().toString();
        if (isEmpty(text)) {
            return null;
        }
        else {
            return text;
        }
    }

    /**
     * If the EditText is empty or null, returns default value. Otherwise the text.
     * @param view
     * @return
     */
    public static String stringOrDefault(EditText view, String defaultValue) {
        String value = stringOrNull(view);
        if (value == null) return defaultValue;
        return value;
    }

    public static Double doubleOrNull(EditText view) {
        return isEmpty(view.getText())? null: Double.valueOf(view.getText().toString());
    }

}

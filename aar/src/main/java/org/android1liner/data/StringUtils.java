package org.android1liner.data;

/**
 * Created by hongyew on 26/12/2016.
 */

public class StringUtils {

    public static String capitalize(final String line) {
        if (line == null) return null;
        String[] arr = line.split(" ");
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < arr.length; i++) {
            sb.append(Character.toUpperCase(arr[i].charAt(0)))
                    .append(arr[i].substring(1)).append(" ");
        }
        return sb.toString().trim();
    }

    /**
     * Add 'padding' to the start of the string.
     *
     * @param numberOfSpaces
     *            the number of spaces to add to the string.
     * @param stringToModify
     *            the string to modify
     * @param charToPadWith
     *            the character to pad with
     * @return newString The modified string
     */
    public static String padLeft(int numberOfSpaces, String stringToModify, char charToPadWith) {
        String newString = stringToModify;
        for (int i = 0; i < numberOfSpaces; i++) {
            newString = charToPadWith + newString;
        }
        return newString;
    }

    /**
     * Removes consecutive seperators from a string that has been tokenized with the seperator.
     *
     * @param stringToModify
     *            the string clean
     * @param seperator
     *            the seperator
     * @return the new string
     */
    public static String removeConsecutiveSeperators(String stringToModify, String seperator) {
        String[] items = stringToModify.trim().split(seperator);
        String newString = new String();
        for (String item : items) {
            item = item.trim();
            if (!item.isEmpty()) {
                newString = newString.concat(item).concat(seperator);
            }
        }
        return newString;
    }

    /**
     * Joins the strings using the provided seperator.
     * @param values the values to join
     * @param seperator the seperator
     * @return the strings joined with the seperator.
     */
    public static String join(String[] values, String seperator) {
        String result = "";
        for (String value : values) {
            result += result.isEmpty() ? value : "," + value;
        }
        return result;
    }
    
    /**
     * Null safe toString()
     * @param object
     * @return
     */
    public static String toString(Object object) {
        return (object == null)? null: object.toString();
    }
    
}

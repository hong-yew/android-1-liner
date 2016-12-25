package org.android1liner.data;

/**
 * Created by hongyew on 26/12/2016.
 */

public class ArrayUtils {
    private ArrayUtils() {}

    public static int arraySearch(Object[] array, Object item) {
        if (array == null || item == null) return -1;
        for (int i=0;i<array.length;i++) {
            if (item.equals(array[i])) return i;
        }
        return -1;
    }
}

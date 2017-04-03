package org.android1liner.function;

import android.support.annotation.Nullable;

import java.util.List;

/**
 * A generic callback interface to indicate when something is completed.
 * Use for returning execution control from middle layer to UI layer.
 */
public interface Completion {
    int SUCCESS = 0;
    
    /**
     * @param status  process outcome (eg. 0 == SUCCESS)
     * @param message optional message to display
     * @param objects optional objects
     */
    void onComplete(int status, @Nullable String message, @Nullable Object[] objects);
    
    class Utils {
        /**
         * Convert an arbitrary T[] to object[] of T objects.
         *
         * @param from
         * @param <T>
         * @return
         */
        public static <T> Object[] toObjectArray(T[] from) {
            Object[] o = new Object[from.length];
            for (int i = 0; i < from.length; i++) {
                o[i] = from[i];
            }
            return o;
        }
        
        /**
         * Convert an arbitrary List<T> to object[] of T objects.
         *
         * @param from
         * @param <T>
         * @return
         */
        public static <T> Object[] toObjectArray(List<T> from) {
            Object[] o = new Object[from.size()];
            for (int i = 0; i < from.size(); i++) {
                o[i] = from.get(i);
            }
            return o;
        }
    }
}

package org.android1liner.ui;

import android.content.Context;
import android.graphics.Point;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;

import org.android1liner.device.LocationUtils;

/**
 * Created by hongyew on 26/12/2016.
 */

public class MapUtils {
    private MapUtils() {}
    /**
     * Calculate the optimum GoogleMap zoom level for a given distance (in KM)
     * http://stackoverflow.com/questions/6002563/android-how-do-i-set-the-zoom-level-of-map-view-to-1-km-radius-around-my-currenandr
     * @param screenWidth
     * @param distanceInKM
     * @return
     */
    public static int calculateZoomLevel(int screenWidth, float distanceInKM) {
        double equatorLength = 40075004; // in meters
        double widthInPixels = screenWidth;
        double metersPerPixel = equatorLength / 256;
        int zoomLevel = 1;

        // Multiply distance by 2000 because x1000 in meters and x2 to measure both left/rigth sides.
        while ((metersPerPixel * widthInPixels) > (distanceInKM * 2000)) {
            metersPerPixel /= 2;
            ++zoomLevel;
        }

        // Fine tuning adjustment. For best visual presentation, having exactly matched
        // might crop the subject. We want some room around so we reduce the zoom level slightly
        // manually.
        zoomLevel = zoomLevel - 3;
        Log.d(LocationUtils.class.getSimpleName(), "calculateZoomLevel(): Distance: " + distanceInKM + ". Zoom Level: " + zoomLevel);
        return zoomLevel;
    }

    /**
     * Calculate the optimum Google Map zoom level for given distance in KM by using
     * screen width
     * @param context
     * @param distanceInKM
     * @return
     */
    public static int calculateOptimumZoomLevel(Context context, float distanceInKM) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return calculateZoomLevel(size.x, distanceInKM);
    }
}

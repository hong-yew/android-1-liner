package org.android1liner.device;

/**
 * Created by hongyew on 26/12/2016.
 */

import android.Manifest;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.support.annotation.RequiresPermission;

import java.util.List;

/**
 * Created by hongyew on 14/10/2014.
 */
public class LocationUtils {
    private LocationUtils() {}

    /**
     * Calculate distance between 2 geolocations in KM
     * @param lat1
     * @param lng1
     * @param lat2
     * @param lng2
     * @return distance in KM
     */
    public static float calculateDistance(double lat1, double lng1, double lat2, double lng2) {
        double earthRadius = 6371; //kilometers
        double dLat = Math.toRadians(lat2-lat1);
        double dLng = Math.toRadians(lng2-lng1);
        double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(dLng/2) * Math.sin(dLng/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        float dist = (float) (earthRadius * c);

        return dist;
    }


    /**
     * Get last passive location without waiting. Not accurate.
     * @param context
     * @return
     */
    @RequiresPermission(anyOf = {Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION})
    public static double[] getLastKnownLocationWithoutWait(Context context) {
        LocationManager lm = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        List<String> providers = lm.getProviders(true);

        /* Loop over the array backwards, and if you get an accurate location, then break out the loop*/
        Location l = null;
        for (int i=providers.size()-1; i>=0; i--) {
            l = lm.getLastKnownLocation(providers.get(i));
            if (l != null) break;
        }
        if (l != null) {
            return new double[] { l.getLatitude(), l.getLongitude() };
        }
        return null;
    }
}
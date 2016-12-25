package org.android1liner.ui;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.view.View;

/**
 * Activity and Fragment related utilities
 */
public class ActivityUtils {
    private ActivityUtils() {}

    public static void startActivity(Activity context, Intent i, View transitionView, String transitionName) {
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(context, transitionView, transitionName);
        ActivityCompat.startActivity(context, i, options.toBundle());
    }

    public static void startActivity(Activity context, Intent i) {
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(context);
        ActivityCompat.startActivity(context, i, options.toBundle());
    }

    public static void startActivity(Activity context, Class<? extends Activity> activityClass) {
        Intent i = new Intent(context, activityClass);
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(context);
        ActivityCompat.startActivity(context, i, options.toBundle());
    }

}

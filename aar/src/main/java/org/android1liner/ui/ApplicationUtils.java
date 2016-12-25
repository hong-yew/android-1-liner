package org.android1liner.ui;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

/**
 * Created by hongyew on 26/12/2016.
 */

public class ApplicationUtils {
    private ApplicationUtils() {}


    /**
     * Restart the app.
     * @param context
     */
    public static void restartApplication(Context context) {
        Intent i = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        PendingIntent p = PendingIntent.getActivity(context, 0, i, PendingIntent.FLAG_CANCEL_CURRENT);
        AlarmManager mgr = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        mgr.set(AlarmManager.RTC, System.currentTimeMillis() + 500, p);

        //kill the application
        System.exit(0);
    }

    /**
     * Alert and quite the activity
     * @param message
     */
    public static void alertAbort(final Activity activity, String message) {
        new AlertDialog.Builder(activity, AlertDialog.THEME_HOLO_DARK)
                .setTitle("Problem...")
                .setMessage(message)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        activity.finish();
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
}

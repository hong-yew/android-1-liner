package org.android1liner.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

/**
 * Created by hongyew on 26/12/2016.
 */

public class DialogUtils {
    private DialogUtils() {}

    public static AlertDialog yesNoDialog(Context context, String prompt, DialogInterface.OnClickListener handler) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(prompt)
                .setPositiveButton("Yes", handler)
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        return builder.show();
    }

    public static AlertDialog okCancelDialog(Context context, String prompt, DialogInterface.OnClickListener handler) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(prompt)
                .setPositiveButton("OK", handler)
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        return builder.show();
    }

    public static AlertDialog alert(Context context, String message, DialogInterface.OnClickListener handler) {
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        if (message != null) {
            alertDialog.setMessage(message);
            //alertDialog.setIcon(alertDialog.setIcon(context.getResources().getDrawable(android.R.drawable.ic_dialog_info)));
            alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK", handler);
            alertDialog.show();
            return alertDialog;
        }
        return alertDialog;
    }

}

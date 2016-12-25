package org.android1liner.ui;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by hongyew on 26/12/2016.
 */

public class ProgressUitls {
    private ProgressUitls() {}

    public static ProgressDialog showProgress(Context context) {
        return showProgress(context, null);
    }

    public static ProgressDialog showProgress(Context context, String message) {
        final ProgressDialog progressDialog = new ProgressDialog(context);
        if (message != null) progressDialog.setMessage(message);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
        return progressDialog;
    }

    public static void hideProgress(ProgressDialog progressDialog) {
        if (progressDialog != null) {
            if (progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
        }
    }
}

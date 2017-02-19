package org.android1liner.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Handler;
import android.util.Log;

/**
 * Created by hongyew on 26/12/2016.
 */

public class ProgressUitls {
    private ProgressUitls() {}

    public static ProgressDialog showProgress(Context context) {
        return showProgress(context, "Please wait...");
    }

    public static ProgressDialog showProgressWithTimeout(Context context, int millisecods, final ProgressTimeout callback) {
        final ProgressDialog progress = showProgress(context, "Please wait...");
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                ProgressUitls.hideProgress(progress);
                if (callback != null) callback.timeout();
            }
        }, millisecods);
        return progress;
    }

    public static ProgressDialog showProgress(Context context, String message) {
        final ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setMessage(message);
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
        else {
            Log.e(ProgressUitls.class.getSimpleName(), "hideProgress(): The progressDialog is null");
        }
    }

    public interface ProgressTimeout {
        void timeout();
    }
}

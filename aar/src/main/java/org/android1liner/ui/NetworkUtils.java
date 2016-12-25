package org.android1liner.ui;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetworkUtils {
    private NetworkUtils() {}

    public static boolean isNetworkAvailable(Context context) {
        boolean status=false;
        try{
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo netInfo = cm.getNetworkInfo(0);
            if (netInfo != null && netInfo.getState() == NetworkInfo.State.CONNECTED) {
                status= true;
            }else {
                netInfo = cm.getNetworkInfo(1);
                if(netInfo!=null && netInfo.getState() == NetworkInfo.State.CONNECTED)
                    status= true;
            }
        }catch(Exception e){
            Log.e(NetworkUtils.class.getSimpleName(), "isNetworkOnline(): " + e.toString());
            return false;
        }
        return status;
    }

    public boolean hasActiveConnection() {
        try {
            HttpURLConnection urlc = (HttpURLConnection)
                    (new URL("http://clients3.google.com/generate_204")
                            .openConnection());
            urlc.setRequestProperty("User-Agent", "Android");
            urlc.setRequestProperty("Connection", "close");
            urlc.setConnectTimeout(600);
            urlc.connect();
            return (urlc.getResponseCode() == 204 && urlc.getContentLength() == 0);
        } catch (IOException e) {
            Log.d(NetworkUtils.class.getSimpleName(), "hasActiveConnection(): No active connection");
            return false;
        }
    }
}
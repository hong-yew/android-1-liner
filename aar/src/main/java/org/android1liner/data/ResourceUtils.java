package org.android1liner.data;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * Created by hongyew on 26/12/2016.
 */

public class ResourceUtils {
    private ResourceUtils() {}

    public static String readAssetAsString (String filename, Context context) throws IOException {
        AssetManager manager = context.getAssets();
        InputStream file = manager.open(filename);
        byte[] data = new byte[file.available()];
        file.read(data);
        file.close();
        return new String(data);
    }

    public static Reader readAssetAsReader (String filename, Context context) throws IOException {
        AssetManager manager = context.getAssets();
        return new InputStreamReader(manager.open(filename));
    }
}

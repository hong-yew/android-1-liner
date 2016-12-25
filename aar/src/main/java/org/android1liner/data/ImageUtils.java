package org.android1liner.data;

import android.graphics.Bitmap;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by hongyew on 26/12/2016.
 */

public class ImageUtils {
    private ImageUtils() {}
    private static final int BUFFER_SIZE = 16384;

    /**
     * Converts bitmap to byte array.
     *
     * @param bitmap
     *            bitmap to convert
     *
     * @return byte array of the bitmap
     */
    public static byte[] bitmapToByteArray(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        return stream.toByteArray();
    }

    /**
     * Get Bytes from input stream.
     *
     * @param is
     *            iput stream
     * @return input steram as bytes.
     */
    public static byte[] getBytesFromIputStream(InputStream is) {

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        int nRead;
        byte[] data = new byte[BUFFER_SIZE];

        try {
            while ((nRead = is.read(data, 0, data.length)) != -1) {
                buffer.write(data, 0, nRead);
            }
            buffer.flush();
        } catch (IOException ioe) {
            Log.e(ImageUtils.class.getSimpleName(), "getBytesFromIputStream(): Error converting iput steram to byte array", ioe);
        }
        return buffer.toByteArray();
    }
}

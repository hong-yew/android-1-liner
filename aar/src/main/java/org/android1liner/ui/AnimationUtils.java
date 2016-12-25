package org.android1liner.ui;

import android.view.animation.Animation;
import android.view.animation.RotateAnimation;

/**
 * Created by hongyew on 26/12/2016.
 */

public class AnimationUtils {
    private AnimationUtils() {}
    private static final float ROTATION = 360f;
    private static final float PIVOT = 0.5f;
    private static final int ANIMATION_DURATION = 600;

    /**
     * Create a new rotating animation.
     * @return a rotation animation
     */
    public static RotateAnimation rotateAnimation() {
        RotateAnimation rotate  = new RotateAnimation(0f, ROTATION, Animation.RELATIVE_TO_SELF, PIVOT, Animation.RELATIVE_TO_SELF, PIVOT);
        rotate.setDuration(ANIMATION_DURATION);
        rotate.setRepeatMode(Animation.RESTART);
        rotate.setRepeatCount(Animation.INFINITE);
        return rotate;
    }
}



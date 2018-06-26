package com.samcai.cutilslibrary.utils;

/**
 * Created by caizhenliang on 2018/5/9.
 *
 * @version 1.0
 */
public class SlowClickTimeUtils {

    private static long mLastClickTime;

    /**
     * set limit about the frequency of click events
     *
     * @return
     */
    public static boolean isFastDoubleClick() {
        long time = System.currentTimeMillis();
        if (Math.abs(time - mLastClickTime) < 500) {
            return true;
        }
        mLastClickTime = time;
        return false;
    }
}

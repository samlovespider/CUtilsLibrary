package com.samcai.cutilslibrary.utils;

import android.content.Context;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by caizhenliang on 2018/2/27.
 *
 * @version 1.0
 */
public class InputCheckUtils {

    /**
     * @param tv array of TextView
     * @return All good return -1
     */
    public static int CheckInputEmpty(TextView... tv) {
        for (int i = 0; i < tv.length; i++) {
            if (TextUtils.isEmpty(tv[i].getText().toString())) {
                return i;
            }
        }
        return -1;
    }

    /**
     * @param et array of EditText
     * @return All good return -1
     */
    public static int CheckInputEmpty(EditText... et) {
        for (int i = 0; i < et.length; i++) {
            if (TextUtils.isEmpty(et[i].getText().toString())) {
                return i;
            }
        }
        return -1;
    }

    /**
     * @param context
     * @param emptyIndex
     * @param str
     */
    public static void ShowEmptyToast(Context context, int emptyIndex, int... str) {
        if (emptyIndex != -1) {
            ToastUtils.ShowToast(context, context.getResources().getString(str[emptyIndex]));
        }
    }

}

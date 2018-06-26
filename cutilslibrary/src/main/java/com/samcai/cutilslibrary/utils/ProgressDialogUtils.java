package com.samcai.cutilslibrary.utils;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by caizhenliang on 2018/3/15.
 *
 * @version 1.2
 */
public class ProgressDialogUtils {

    private static ProgressDialog mProgressDialog = null;
    private static Context mContext = null;

    public static void Show(Context context, String text) {

        if (mContext == null) {
            mContext = context;
        }

        if (mContext.equals(context)) {
            if (mProgressDialog == null) {
                mProgressDialog = ProgressDialog.show(context, "", text);
                mProgressDialog.setCancelable(true);
            } else {
                mProgressDialog.setMessage(text);
            }
        } else {
            mContext = context;
            mProgressDialog.cancel();
            mProgressDialog = null;
            mProgressDialog = ProgressDialog.show(context, "", text);
            mProgressDialog.setCancelable(true);
        }

        mProgressDialog.show();
    }

    public static void Show(Context context, int text) {
        String str = context.getString(text);
        Show(context, str);
    }

    public static void Dismiss() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }
}

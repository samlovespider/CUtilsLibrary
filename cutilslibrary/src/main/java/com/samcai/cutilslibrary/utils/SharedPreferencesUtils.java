package com.samcai.cutilslibrary.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.samcai.cutilslibrary.BuildConfig;


/**
 * Created by caizhenliang on 2018/3/22.
 *
 * @version 1.4
 */
public class SharedPreferencesUtils {

    /**
     * init in application
     */
    private static String TAG = BuildConfig.APPLICATION_ID;

    public static void init(String sTAG) {
        TAG = sTAG;
    }

    /*///////////////////////////////////////////////////////////////////////////
    //
    ///////////////////////////////////////////////////////////////////////////*/

    public static void save(Context context, String tag, String content) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(tag, content);
        edit.apply();
    }

    public static void save(Context context, String tag, boolean isContent) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putBoolean(tag, isContent);
        edit.apply();
    }

    public static void clear(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.clear();
        edit.apply();
    }

    public static void clear(Context context, String tag) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.remove(tag);
        edit.apply();
    }

    public static String getString(Context context, String tag) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        return sharedPreferences.getString(tag, "");
    }

    public static boolean getBoolean(Context context, String tag) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(tag, false);
    }

}

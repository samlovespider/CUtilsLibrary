package com.samcai.cutilslibrary.utils;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;

import com.samcai.cutilslibrary.BuildConfig;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

/**
 * Created by caizhenliang on 2018/2/21.
 *
 * @version 1.6
 */
public class LogUtils {

    private static final String LINE_SEPARATOR = System.getProperty("line.separator");
    /**
     * init in application
     */
    public static boolean isPro;
    public static String TAG = BuildConfig.APPLICATION_ID;
    private static String HEADER;

    public static void init(boolean sIsPro, String sTAG) {
        isPro = sIsPro;
        TAG = sTAG;
        HEADER = sTAG;
    }

    /*///////////////////////////////////////////////////////////////////////////
    //
    ///////////////////////////////////////////////////////////////////////////*/

    public static void LogSuccess(String sJsonStr, String sServiceName) {
        String head = String.format("Service: %s \nCode: %s", sServiceName, "200");
        dJson(sServiceName, sJsonStr, head);
    }

    public static void LogEmpty(int sCode, String sServiceName) {
        String head = String.format("Service: %s \nCode: %s", sServiceName, sCode + "");
        wJson(sServiceName, "Empty", head);
    }

    public static void LogError(int sCode, String sJsonStr, String sServiceName) {
        String head = String.format("Service: %s \nCode: %s", sServiceName, sCode + "");
        if (TextUtils.isEmpty(sJsonStr)) {
            w(sServiceName, "Error", head);
        } else {
            wJson(sServiceName, sJsonStr, head);
        }
    }

    public static void LogFailure(String throwableStr, String sServiceName) {
        e(sServiceName, "Failure: " + throwableStr, sServiceName);
    }

    /*///////////////////////////////////////////////////////////////////////////
    //
    ///////////////////////////////////////////////////////////////////////////*/

    public static void i(Object o) {
        i(TAG, o, HEADER);
    }

    public static void i(String tag, Object o) {
        i(tag, o, HEADER);
    }

    public static void i(String tag, Object o, String header) {
        log(Log.INFO, tag, o, header);
    }

    public static void iJson(String json) {
        iJson(TAG, json, HEADER);
    }

    public static void iJson(String tag, String json) {
        iJson(tag, json, HEADER);
    }

    public static void iJson(String tag, String json, String header) {
        logJson(Log.INFO, tag, json, header);
    }

    /*----------------------------------------------------------*/

    public static void d(Object o) {
        d(TAG, o, HEADER);
    }

    public static void d(String tag, Object o) {
        d(tag, o, HEADER);
    }

    public static void d(String tag, Object o, String header) {
        log(Log.DEBUG, tag, o, header);
    }

    public static void dJson(String json) {
        dJson(TAG, json, HEADER);
    }

    public static void dJson(String tag, String json) {
        dJson(tag, json, HEADER);
    }

    public static void dJson(String tag, String json, String header) {
        logJson(Log.DEBUG, tag, json, header);
    }

    /*----------------------------------------------------------*/

    public static void w(@Nullable Object o) {
        w(TAG, o, HEADER);
    }

    public static void w(String tag, @Nullable Object o) {
        w(tag, o, HEADER);
    }

    public static void w(String tag, Object o, String header) {
        log(Log.WARN, tag, o, header);
    }

    public static void wJson(String json) {
        wJson(TAG, json, HEADER);
    }

    public static void wJson(String tag, String json) {
        wJson(tag, json, HEADER);
    }

    public static void wJson(String tag, String json, String header) {
        logJson(Log.WARN, tag, json, header);
    }

    /*----------------------------------------------------------*/

    public static void e(Object o) {
        e(TAG, o, HEADER);
    }

    public static void e(String tag, Object o) {
        e(tag, o, HEADER);
    }

    public static void e(String tag, Object o, String header) {
        log(Log.ERROR, tag, o, header);
    }

    public static void eJson(String json) {
        eJson(TAG, json, HEADER);
    }

    public static void eJson(String tag, String json) {
        eJson(tag, json, HEADER);
    }

    public static void eJson(String tag, String json, String header) {
        logJson(Log.ERROR, tag, json, header);
    }

    /*///////////////////////////////////////////////////////////////////////////
    //
    ///////////////////////////////////////////////////////////////////////////*/

    private static void log(int priority, String tag, @Nullable Object o, String header) {

        if (isPro) {
            return;
        }

        String message = "";
        String head = "";

        printLine(priority, tag, 0);

        head = header;
        String[] lines = head.split(LINE_SEPARATOR);
        for (String line : lines) {
            Log.println(priority, tag, "║ " + line);
        }

        printLine(priority, tag, 3);

        message = toString(o);
        String[] lines1 = message.split(LINE_SEPARATOR);
        for (String line : lines1) {
            Log.println(priority, tag, "║ " + line);
        }

        printLine(priority, tag, 1);
    }

    private static void logJson(int priority, String tag, String json, String header) {

        if (isPro) {
            return;
        }

        String message = "";
        String head = "";

        printLine(priority, tag, 0);

        head = header;
        String[] lines = head.split(LINE_SEPARATOR);
        for (String line : lines) {
            Log.println(priority, tag, "║ " + line);
        }

        printLine(priority, tag, 3);

        message = getJsonFormat(json);
        String[] lines1 = message.split(LINE_SEPARATOR);
        for (String line : lines1) {
            Log.println(priority, tag, "║ " + line);
        }

        printLine(priority, tag, 1);
    }

    private static void printLine(int priority, String tag, int isTop) {
        if (isTop == 0) {
            Log.println(priority, tag, "╔═══════════════════════════════════════════════════════════════════════════════════════");
        } else if (isTop == 1) {
            Log.println(priority, tag, "╚═══════════════════════════════════════════════════════════════════════════════════════");
        } else {
            Log.println(priority, tag, "║+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }
    }

    private static String toString(Object object) {
        if (object == null) {
            return "null";
        }
        if (!object.getClass().isArray()) {
            return object.toString();
        }
        if (object instanceof boolean[]) {
            return Arrays.toString((boolean[]) object);
        }
        if (object instanceof byte[]) {
            return Arrays.toString((byte[]) object);
        }
        if (object instanceof char[]) {
            return Arrays.toString((char[]) object);
        }
        if (object instanceof short[]) {
            return Arrays.toString((short[]) object);
        }
        if (object instanceof int[]) {
            return Arrays.toString((int[]) object);
        }
        if (object instanceof long[]) {
            return Arrays.toString((long[]) object);
        }
        if (object instanceof float[]) {
            return Arrays.toString((float[]) object);
        }
        if (object instanceof double[]) {
            return Arrays.toString((double[]) object);
        }
        if (object instanceof Object[]) {
            return Arrays.deepToString((Object[]) object);
        }
        return "Couldn't find a correct type for the object";
    }

    private static String getJsonFormat(String msg) {

        String message;

        try {
            if (msg.startsWith("{")) {
                JSONObject jsonObject = new JSONObject(msg);
                message = jsonObject.toString(4);//最重要的方法，就一行，返回格式化的json字符串，其中的数字4是缩进字符数
            } else if (msg.startsWith("[")) {
                JSONArray jsonArray = new JSONArray(msg);
                message = jsonArray.toString(4);
            } else {
                message = msg;
            }
        } catch (JSONException e) {
            message = msg;
        }
        return message;
    }
}

package com.samcai.cutilslibrary.utils;

import android.app.ActivityManager;
import android.content.Context;

import java.util.List;


/**
 * Created by caizhenliang on 2018/5/8.
 *
 * @version 1.0
 */
public class AppLifecycleUtils {

    public static boolean isActive = true;

    public static boolean isForeground(Context sContext) {
        ActivityManager am = (ActivityManager) sContext.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> runningProcesses = am.getRunningAppProcesses();
        for (ActivityManager.RunningAppProcessInfo processInfo : runningProcesses) {
            if (processInfo.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
                for (String activeProcess : processInfo.pkgList) {
                    if (activeProcess.equals(sContext.getPackageName())) {
                        //If your app is the process in foreground, then it's not in running in background
                        return true;
                    }
                }
            }
        }

        return false;
    }

}

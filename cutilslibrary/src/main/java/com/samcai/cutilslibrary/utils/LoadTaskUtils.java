package com.samcai.cutilslibrary.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by caizhenliang on 2018/4/29.
 *
 * @version 1.0
 */
public class LoadTaskUtils {

    public static final String TAG = "LoadTask";
    public static final String FINISHED = "Task Finished";
    public static final String ALL_FINISHED = "All Task Finished";


    /**
     * all tasks' name
     */
    public static List<String> loadTaskNameList;
    /**
     * information about whether loading task finish or not
     */
    public static Map<String, Boolean> loadTaskMarkMap;

    /**
     * All task finished
     *
     * @return
     */
    public static boolean isAllFinished() {

        if (ArrayUtils.IsEmpty(loadTaskNameList) || ArrayUtils.IsEmpty(loadTaskMarkMap)) {
            return true;
        }

        for (String name : loadTaskNameList) {
            if (loadTaskMarkMap.containsKey(name)) {
                if (!loadTaskMarkMap.get(name)) {
                    return false;
                }
            }
        }

        loadTaskNameList.clear();
        loadTaskMarkMap.clear();

        return true;
    }

    /**
     * put new task
     *
     * @param taskName
     */
    public static void setLoadTask(String taskName) {
        if (loadTaskNameList == null) {
            loadTaskNameList = new ArrayList<>();
        }
        if (loadTaskMarkMap == null) {
            loadTaskMarkMap = new HashMap<>();
        }

        if (!loadTaskNameList.contains(taskName)) {
            loadTaskNameList.add(taskName);
        }

        loadTaskMarkMap.put(taskName, false);
    }

    /**
     * finished a task
     *
     * @param taskName
     */
    public static void setLoadTaskFinished(String taskName) {
        if (loadTaskNameList == null) {
            loadTaskNameList = new ArrayList<>();
        }
        if (loadTaskMarkMap == null) {
            loadTaskMarkMap = new HashMap<>();
        }

        if (!loadTaskNameList.contains(taskName)) {
            loadTaskNameList.add(taskName);
        }

        loadTaskMarkMap.put(taskName, true);
        LogUtils.d(LoadTaskUtils.TAG, taskName, LoadTaskUtils.FINISHED);
    }

    /**
     * clear the data
     */
    public static void clearLoadTasks() {
        if (!ArrayUtils.IsEmpty(loadTaskNameList)) {
            loadTaskNameList.clear();
        }

        if (!ArrayUtils.IsEmpty(loadTaskMarkMap)) {
            loadTaskMarkMap.clear();
        }
    }

}

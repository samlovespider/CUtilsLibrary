package com.samcai.cutilslibrary.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by caizhenliang on 2018/4/29.
 *
 * @version 1.1
 */
public class LoadRequestUtils {

    public static final String TAG = "LoadRequest";
    public static final String FINISHED = "Request Finished";
    public static final String ALL_FINISHED = "All Requests Finished";


    /**
     * all tasks' name
     */
    public static List<String> loadRequestNameList;
    /**
     * information about whether loading task finish or not
     */
    public static Map<String, Boolean> loadRequestMarkMap;

    /**
     * All task finished
     *
     * @return
     */
    public static boolean isAllFinished() {

        if (ArrayUtils.IsEmpty(loadRequestNameList) || ArrayUtils.IsEmpty(loadRequestMarkMap)) {
            return true;
        }

        for (String name : loadRequestNameList) {
            if (loadRequestMarkMap.containsKey(name)) {
                if (!loadRequestMarkMap.get(name)) {
                    return false;
                }
            }
        }

        loadRequestNameList.clear();
        loadRequestMarkMap.clear();

        return true;
    }

    /**
     * put new task
     *
     * @param taskName
     */
    public static void setRequestTask(String taskName) {
        if (loadRequestNameList == null) {
            loadRequestNameList = new ArrayList<>();
        }
        if (loadRequestMarkMap == null) {
            loadRequestMarkMap = new HashMap<>();
        }

        if (!loadRequestNameList.contains(taskName)) {
            loadRequestNameList.add(taskName);
        }

        loadRequestMarkMap.put(taskName, false);
    }

    /**
     * finished a task
     *
     * @param taskName
     */
    public static void setLoadRequestFinished(String taskName) {
        if (loadRequestNameList == null) {
            loadRequestNameList = new ArrayList<>();
        }
        if (loadRequestMarkMap == null) {
            loadRequestMarkMap = new HashMap<>();
        }

        if (!loadRequestNameList.contains(taskName)) {
            loadRequestNameList.add(taskName);
        }

        loadRequestMarkMap.put(taskName, true);
        LogUtils.d(LoadRequestUtils.TAG, taskName, LoadRequestUtils.FINISHED);
    }

    /**
     * clear the data
     */
    public static void clearLoadRequests() {
        if (!ArrayUtils.IsEmpty(loadRequestNameList)) {
            loadRequestNameList.clear();
        }

        if (!ArrayUtils.IsEmpty(loadRequestMarkMap)) {
            loadRequestMarkMap.clear();
        }
    }

}

package com.samcai.cutilslibrary.utils;

import java.util.List;
import java.util.Map;

/**
 * Created by caizhenliang on 2018/4/27.
 *
 * @version 1.2
 */
public class ArrayUtils {

    /**
     * not null and size>0
     *
     * @param list
     * @return
     */
    public static boolean IsEmpty(List list) {
        return list == null || list.size() == 0;
    }

    /**
     * not null and size>0
     *
     * @param map
     * @return
     */
    public static boolean IsEmpty(Map map) {
        return map == null || map.size() == 0;
    }


}

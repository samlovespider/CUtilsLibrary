package com.samcai.cutilslibrary.base;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.google.gson.Gson;

import java.lang.reflect.Type;


/**
 * Created by caizhenliang on 2018/3/23.
 *
 * @version 1.1
 */
public class BaseBundle {

    protected static Bundle BuildBundleFromModel(String key, @NonNull BaseBundle bundleModel) {
        String json = new Gson().toJson(bundleModel);
        Bundle bundle = new Bundle();
        bundle.putString(key, json);
        return bundle;
    }

    protected static BaseBundle BuildModelFromBundle(String key, Type typeClass, @NonNull Bundle bundle) {
        String json = bundle.getString(key, "");
        return new Gson().fromJson(json, typeClass);
    }

    protected static String BuildStringFromBundle(String key, @NonNull Bundle bundle) {
        return bundle.getString(key, "");
    }

    protected static BaseBundle BuildModelFromString(Type typeClass, @NonNull String json) {
        return new Gson().fromJson(json, typeClass);
    }
}

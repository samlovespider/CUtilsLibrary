package com.samcai.cutilslibrary.base.ui;

import android.content.Context;

/**
 * Created by caizhenliang on 2018/3/2.
 *
 * @version 1.2
 */
public abstract class BasePresenter {

    private final BaseActivity mBaseActivity;
    protected Context mContext;

    public BasePresenter(Context sContext, BaseActivity sActivity) {
        mContext = sContext;
        mBaseActivity = sActivity;
    }

}

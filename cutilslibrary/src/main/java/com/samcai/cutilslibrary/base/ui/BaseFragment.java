package com.samcai.cutilslibrary.base.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by caizhenliang on 2018/3/2.
 *
 * @version 1.3
 */
public abstract class BaseFragment extends Fragment {

    protected Context mContext;
    protected Unbinder mUnbinder;

    /*///////////////////////////////////////////////////////////////////////////
    //
    ///////////////////////////////////////////////////////////////////////////*/

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getFragmentLayoutID(), container, false);
        mUnbinder = ButterKnife.bind(getBindView(), view);

        initContent();
        initAdapter(view);
        initView();

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        int menuID = 0;
        menuID = initMenuID();
        if (menuID != 0) {
            inflater.inflate(menuID, menu);
        }
    }

/*
    有时候需要在Fragment中使用Toolbar，
    比如Activity中不同的Tab显示不同的Fragment，
    同时每个Tab的Toolbar标题、Menu均不相同，
    这时在Activity中使用同一个Toolbar就相当不方便了。
    我们可以在每个Fragment的布局中添加各自的Toolbar，
    然后在Fragment中单独控制。

    use in different fragment

    ((AppCompatActivity)getActivity()).setSupportActionBar((Toolbar) mContentView.findViewById(R.id.tb_toolbar));
*/

    /*///////////////////////////////////////////////////////////////////////////
    //
    ///////////////////////////////////////////////////////////////////////////*/

    protected abstract int getFragmentLayoutID();

    protected abstract Fragment getBindView();

    /**
     * 1,initContent<br>
     * 2,initAdapter<br>
     * 3,initView<br>
     */
    protected abstract void initContent();

    /**
     * 1,initContent<br>
     * 2,initAdapter<br>
     * 3,initView<br>
     */
    protected abstract void initView();

    /*///////////////////////////////////////////////////////////////////////////
    //
    ///////////////////////////////////////////////////////////////////////////*/

    protected int initMenuID() {
        return 0;
    }

    /**
     * for BaseRecycleFragment to use
     *
     * @param view
     */
    protected void initAdapter(@NonNull View view) {}

    /*///////////////////////////////////////////////////////////////////////////
    //
    ///////////////////////////////////////////////////////////////////////////*/

    protected abstract void presenterCallbackMessage(String sJsonStr, String sServiceName);

    protected abstract void presenterCallbackEmpty(String sJsonStr, String sServiceName);

    protected abstract void presenterCallbackError(String sJsonStr, String sServiceName);

}

package com.samcai.cutilslibrary.base.ui;

import android.support.annotation.NonNull;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.samcai.cutilslibrary.base.adapter.CommonRecycleAdapter;


/**
 * Created by caizhenliang on 2018/3/5.
 *
 * @version 1.4
 */
public abstract class BaseRecycleFragment extends BaseFragment {

    protected RecyclerView mRecyclerView;
    protected CommonRecycleAdapter mAdapter;


    protected RecyclerView.LayoutManager initLayoutManger() {
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        return manager;
    }

    @Override
    protected void initAdapter(@NonNull View view) {
        mRecyclerView = view.findViewById(initRecyclerViewID());
        mRecyclerView.setNestedScrollingEnabled(false);
        mRecyclerView.setLayoutManager(initLayoutManger());
        if (getContext() != null) {
            mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        }
        mAdapter = getAdapter();
        mRecyclerView.setAdapter(mAdapter);
    }

    /*///////////////////////////////////////////////////////////////////////////
    //
    ///////////////////////////////////////////////////////////////////////////*/

    /**
     * set RecyclerView's ID
     *
     * @return
     */
    protected abstract int initRecyclerViewID();

    /**
     * get a instance of adapter
     *
     * @return
     */
    protected abstract CommonRecycleAdapter getAdapter();


}

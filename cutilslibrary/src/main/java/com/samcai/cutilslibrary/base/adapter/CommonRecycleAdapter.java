package com.samcai.cutilslibrary.base.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by caizhenliang on 2018/3/5.
 *
 * @version 1.2
 */
public abstract class CommonRecycleAdapter<T> extends RecyclerView.Adapter<CommonViewHolder> {


    protected MultiTypeSupport<T> mMultiTypeSupport;
    protected List<T> mDataList;
    protected Context mContext;
    protected int mLayoutID;


    public CommonRecycleAdapter(Context sContext, List<T> sDataList, int sLayoutID) {
        this.mContext = sContext;
        this.mDataList = sDataList;
        this.mLayoutID = sLayoutID;
    }

    @Override
    public int getItemViewType(int position) {
        if (mMultiTypeSupport != null) {
            return mMultiTypeSupport.getLayoutId(mDataList.get(position), position);
        }
        return super.getItemViewType(position);
    }

    @NonNull
    @Override
    public CommonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (mMultiTypeSupport != null) {
            mLayoutID = viewType;
        }
        View itemView = LayoutInflater.from(mContext).inflate(mLayoutID, parent, false);
        return new CommonViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CommonViewHolder holder, int position) {
        bindData(holder, mDataList.get(position), position);
    }


    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public void clearList() {
        mDataList.clear();
        notifyDataSetChanged();
    }

    public void updateData(List<T> sDataList) {
        mDataList = new ArrayList<>(sDataList);
        notifyDataSetChanged();
    }

    public abstract void bindData(CommonViewHolder holder, T data, int position);
}

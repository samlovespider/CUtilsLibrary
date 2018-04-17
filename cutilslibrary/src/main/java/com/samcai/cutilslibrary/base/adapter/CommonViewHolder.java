package com.samcai.cutilslibrary.base.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by caizhenliang on 2018/3/5.
 *
 * @version 1.1
 */
public class CommonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

    private SparseArray<View> viewSparseArray;
    private OnItemCommonClickListener mItemCommonClickListener;


    public CommonViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
        viewSparseArray = new SparseArray<>();
    }

    public <T extends View> T getView(int viewId) {
        View view = viewSparseArray.get(viewId);
        if (view == null) {
            view = itemView.findViewById(viewId);
            viewSparseArray.put(viewId, view);
        }
        return (T) view;
    }

    public CommonViewHolder setButtonOnClickListener(int viewId, View.OnClickListener onClickListener) {
        View btn = getView(viewId);
        btn.setOnClickListener(onClickListener);
        return this;
    }

    public CommonViewHolder setText(int viewId, int text) {
        TextView tv = getView(viewId);
        tv.setText(text);
        return this;
    }

    public CommonViewHolder setText(int viewId, CharSequence text) {
        TextView tv = getView(viewId);
        tv.setText(text);
        return this;
    }

    public CommonViewHolder setTextColor(int viewId, int color) {
        TextView tv = getView(viewId);
        tv.setTextColor(color);
        return this;
    }

    public CommonViewHolder setViewVisibility(int viewId, int visibility) {
        getView(viewId).setVisibility(visibility);
        return this;
    }

    public CommonViewHolder setImageResource(int viewId, int resourceId) {
        ImageView imageView = getView(viewId);
        imageView.setImageResource(resourceId);
        return this;
    }

    public void setCommonClickListener(OnItemCommonClickListener commonClickListener) {
        this.mItemCommonClickListener = commonClickListener;
    }

    @Override
    public void onClick(View view) {
        if (mItemCommonClickListener != null) {
            mItemCommonClickListener.onItemClickListener(getAdapterPosition());
        }
    }

    @Override
    public boolean onLongClick(View view) {
        if (mItemCommonClickListener != null) {
            mItemCommonClickListener.onItemLongClickListener(getAdapterPosition());
        }
        return false;
    }

    public interface OnItemCommonClickListener {

        void onItemClickListener(int position);

        void onItemLongClickListener(int position);

    }
}

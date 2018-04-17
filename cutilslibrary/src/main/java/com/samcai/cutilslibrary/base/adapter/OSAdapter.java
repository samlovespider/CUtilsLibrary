package com.samcai.cutilslibrary.base.adapter;//package com.osmarket.osmarketagent.app.base.adapter;
//
//import android.content.Context;
//
//import com.osmarket.osmarketagent.ui.oshome.adapter.HomeProductItem;
//
//import java.util.List;
//
///**
// * Created by caizhenliang on 2018/3/5.
// *
// * @version 1.0
// */
//public class OSAdapter extends CommonRecycleAdapter<HomeProductItem> implements MultiTypeSupport<HomeProductItem> {
//
//    private CommonViewHolder.OnItemCommonClickListener mOnItemCommonClickListener;
//
//    public OSAdapter(Context sContext, List<HomeProductItem> sDataList) {
//        super(sContext, sDataList, 0);
//    }
//
//    public OSAdapter(Context sContext, List<HomeProductItem> sDataList,
//                     CommonViewHolder.OnItemCommonClickListener sOnItemCommonClickListener) {
//        super(sContext, sDataList, 0);
//        mOnItemCommonClickListener = sOnItemCommonClickListener;
//        this.mMultiTypeSupport = this;
//    }
//
//    @Override
//    public void bindData(CommonViewHolder holder, HomeProductItem data) {
//
//    }
//
//    @Override
//    public int getLayoutId(HomeProductItem item, int position) {
//        if (position == 0) {
//            return 1;
//        }
//        return 0;
//    }
//}

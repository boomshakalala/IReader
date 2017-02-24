package com.tenghen.ireader.adapter;

import com.chengx.mvp.adapter.ItemViewDelegate;
import com.chengx.mvp.adapter.RecyclerViewHolder;
import com.tenghen.ireader.R;
import com.tenghen.ireader.module.Featured;

/**
 * 作者：chengx
 * 日期：2017/2/24
 * 描述：
 */

public class FeatureRecDelegate implements ItemViewDelegate<Object> {
    @Override
    public int getItemLayoutId() {
        return R.layout.item_featured;
    }

    @Override
    public boolean isForViewType(Object o, int position) {
        return o instanceof Featured;
    }

    @Override
    public void convert(RecyclerViewHolder holder, Object o, int position) {

    }
}

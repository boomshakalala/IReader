package com.tenghen.ireader.adapter;

import android.content.ClipData;

import com.chengx.mvp.adapter.ItemViewDelegate;
import com.chengx.mvp.adapter.RecyclerViewHolder;
import com.tenghen.ireader.R;
import com.tenghen.ireader.module.Label;

/**
 * 作者：chengx
 * 日期：2017/2/24
 * 描述：
 */

public class FeaturedLeble implements ItemViewDelegate<Object> {
    @Override
    public int getItemLayoutId() {
        return R.layout.item_label;
    }

    @Override
    public boolean isForViewType(Object o, int position) {
        return o instanceof Label;
    }

    @Override
    public void convert(RecyclerViewHolder holder, Object o, int position) {

    }
}
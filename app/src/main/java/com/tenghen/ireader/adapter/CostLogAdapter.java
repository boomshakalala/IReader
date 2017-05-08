package com.tenghen.ireader.adapter;

import android.content.Context;

import com.chengx.mvp.adapter.CommonRecyclerAdapter;
import com.chengx.mvp.adapter.RecyclerViewHolder;
import com.tenghen.ireader.module.Cost;

import java.util.List;

/**
 * 作者：chengx
 * 时间：${Date}
 * 描述：
 */
public class CostLogAdapter extends CommonRecyclerAdapter<Cost> {
    public CostLogAdapter(Context context, int layoutId, List<Cost> data) {
        super(context, layoutId, data);
    }

    @Override
    public void convert(RecyclerViewHolder holder, Cost cost) {

    }
}

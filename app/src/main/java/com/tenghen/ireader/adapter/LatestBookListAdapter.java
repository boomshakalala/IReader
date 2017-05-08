package com.tenghen.ireader.adapter;

import android.content.Context;

import com.chengx.mvp.adapter.CommonRecyclerAdapter;
import com.chengx.mvp.adapter.RecyclerViewHolder;
import com.tenghen.ireader.module.LatestBook;

import java.util.List;

/**
 * 作者：chengx
 * 时间：${Date}
 * 描述：
 */
public class LatestBookListAdapter extends CommonRecyclerAdapter<LatestBook> {
    public LatestBookListAdapter(Context context, int layoutId, List<LatestBook> data) {
        super(context, layoutId, data);
    }

    @Override
    public void convert(RecyclerViewHolder holder, LatestBook latestBook) {

    }
}

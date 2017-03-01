package com.tenghen.ireader.adapter;

import com.chengx.mvp.adapter.ItemViewDelegate;
import com.chengx.mvp.adapter.RecyclerViewHolder;
import com.tenghen.ireader.R;
import com.tenghen.ireader.module.MonthlyRankBook;

/**
 * 作者：chengx
 * 日期：2017/3/1
 * 描述：
 */

public class MonthlyHotBookDelegate implements ItemViewDelegate<Object> {
    @Override
    public int getItemLayoutId() {
        return R.layout.item_monthly_rank;
    }

    @Override
    public boolean isForViewType(Object o, int position) {
        return o instanceof MonthlyRankBook;
    }

    @Override
    public void convert(RecyclerViewHolder holder, Object o, int position) {

    }
}

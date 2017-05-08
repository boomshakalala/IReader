package com.tenghen.ireader.adapter;

import com.chengx.mvp.adapter.ItemViewDelegate;
import com.chengx.mvp.adapter.RecyclerViewHolder;
import com.tenghen.ireader.R;
import com.tenghen.ireader.module.Recharge;

import java.util.Objects;

/**
 * 作者：chengx
 * 时间：${Date}
 * 描述：
 */
public class RechargeLogListDelegate implements ItemViewDelegate<Object> {
    @Override
    public int getItemLayoutId() {
        return R.layout.item_recharge_log;
    }

    @Override
    public boolean isForViewType(Object o, int position) {
        return o instanceof Recharge;
    }

    @Override
    public void convert(RecyclerViewHolder holder, Object o, int position) {

    }
}

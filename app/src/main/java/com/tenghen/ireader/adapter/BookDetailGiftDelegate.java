package com.tenghen.ireader.adapter;

import android.content.ClipData;

import com.chengx.mvp.adapter.ItemViewDelegate;
import com.chengx.mvp.adapter.RecyclerViewHolder;
import com.tenghen.ireader.R;
import com.tenghen.ireader.module.Gift;

/**
 * 作者：chengx
 * 日期：2017/3/7
 * 描述：
 */

public class BookDetailGiftDelegate implements ItemViewDelegate<Object> {
    @Override
    public int getItemLayoutId() {
        return R.layout.item_book_detail_gift;
    }

    @Override
    public boolean isForViewType(Object o, int position) {
        return o instanceof Gift;
    }

    @Override
    public void convert(RecyclerViewHolder holder, Object o, int position) {

    }
}

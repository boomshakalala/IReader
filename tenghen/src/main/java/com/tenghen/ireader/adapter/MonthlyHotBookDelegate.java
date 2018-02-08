package com.tenghen.ireader.adapter;

import com.chengx.mvp.adapter.ItemViewDelegate;
import com.chengx.mvp.adapter.RecyclerViewHolder;
import com.tenghen.ireader.R;
import com.tenghen.ireader.module.Book;

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
        if (o instanceof Book){
            Book book = (Book) o;
            return book.isRank;
        }else {
            return false;
        }
    }

    @Override
    public void convert(RecyclerViewHolder holder, Object o, int position) {
        Book book = (Book) o;
        holder.setText(R.id.rankTv,book.getView_id());
        holder.setText(R.id.bookNameTv,book.getName());
        long clickSum = Long.valueOf(book.getAll_click());
        holder.setText(R.id.clickCountTv,clickSum/10000+"万人气");
    }
}

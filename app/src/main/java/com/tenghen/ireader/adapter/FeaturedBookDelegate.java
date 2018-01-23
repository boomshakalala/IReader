package com.tenghen.ireader.adapter;

import com.chengx.mvp.adapter.ItemViewDelegate;
import com.chengx.mvp.adapter.RecyclerViewHolder;
import com.tenghen.ireader.R;
import com.tenghen.ireader.module.Book;

/**
 * 作者：chengx
 * 日期：2017/2/24
 * 描述：
 */

public class FeaturedBookDelegate implements ItemViewDelegate<Object> {
    @Override
    public int getItemLayoutId() {
        return R.layout.item_book;
    }

    @Override
    public boolean isForViewType(Object o, int position) {
        if (o instanceof  Book){
            Book book = (Book) o;
            return !book.isRec;
        }
        return false;
    }

    @Override
    public void convert(RecyclerViewHolder holder, Object o, int position) {
        Book book = (Book) o;
        holder.setText(R.id.bookNameTv,book.getName());
        holder.setImageUrl(R.id.bookIv,book.getCover());

    }
}

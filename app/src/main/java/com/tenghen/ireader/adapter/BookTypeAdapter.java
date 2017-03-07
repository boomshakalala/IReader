package com.tenghen.ireader.adapter;

import android.content.Context;

import com.chengx.mvp.adapter.CommonRecyclerAdapter;
import com.chengx.mvp.adapter.RecyclerViewHolder;
import com.tenghen.ireader.R;
import com.tenghen.ireader.module.Book;
import com.tenghen.ireader.module.CategoryBook;

import java.util.List;

/**
 * 作者：chengx
 * 日期：2017/2/28
 * 描述：
 */

public class BookTypeAdapter extends CommonRecyclerAdapter<CategoryBook> {
    public BookTypeAdapter(Context context, int layoutId, List<CategoryBook> data) {
        super(context, layoutId, data);
    }

    @Override
    public void convert(RecyclerViewHolder holder, CategoryBook book) {
        holder.setImageUrl(R.id.bookIv,book.getCover());
        holder.setText(R.id.bookNameTv,book.getName());
        holder.setText(R.id.bookDescTv,book.getDescription());
        holder.setText(R.id.wordCountTv,book.getWord_count()+"字");
        holder.setText(R.id.clickCountTv,book.getAll_click()+"人次");
        holder.setText(R.id.authorNameTv,book.getPen_name());
    }
}

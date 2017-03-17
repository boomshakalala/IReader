package com.tenghen.ireader.adapter;

import android.content.Context;
import android.view.View;

import com.chengx.mvp.adapter.ItemViewDelegate;
import com.chengx.mvp.adapter.RecyclerViewHolder;
import com.tenghen.ireader.R;
import com.tenghen.ireader.module.BookDetailHeader;
import com.tenghen.ireader.ui.activity.ReadActivity;

/**
 * 作者：chengx
 * 日期：2017/3/7
 * 描述：
 */

public class BookDetailHeaderDelegate implements ItemViewDelegate<Object> {
    private Context context;

    public BookDetailHeaderDelegate(Context context) {
        this.context = context;
    }

    @Override
    public int getItemLayoutId() {
        return R.layout.item_book_detail_header;
    }

    @Override
    public boolean isForViewType(Object o, int position) {
        return o instanceof BookDetailHeader;
    }

    @Override
    public void convert(RecyclerViewHolder holder, Object o, int position) {
        holder.setOnclickListener(R.id.readBookBtn, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ReadActivity.launch(context);
            }
        });
    }
}

package com.tenghen.ireader.adapter;

import android.content.Context;

import com.chengx.mvp.adapter.MultiItemCommonAdapter;

import java.util.List;

/**
 * 作者：chengx
 * 日期：2017/3/7
 * 描述：
 */

public class BookDetailAdapter extends MultiItemCommonAdapter<Object> {
    public BookDetailAdapter(Context context, List<Object> data,String bookId) {
        super(context, data);
        addItemViewDelegate(new BookDetailCommentDelegate(context,bookId));
        addItemViewDelegate(new BookDetailCommentLabelDelegate(context));
        addItemViewDelegate(new BookDetailGiftDelegate());
        addItemViewDelegate(new BookDetailGiftLabelDelegate());
        addItemViewDelegate(new BookDetailGiftLogDelegate());
        addItemViewDelegate(new BookDetailGiftLogLabelDelegate());
        addItemViewDelegate(new BookDetailHeaderDelegate(context));
        addItemViewDelegate(new BookDetailMoreDelegate(context));
        addItemViewDelegate(new SpaceDividerItemDelegate());
        addItemViewDelegate(new AdapterEmptyDelegate());
    }
}

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
    public BookDetailAdapter(Context context, List<Object> data) {
        super(context, data);
        addItemViewDelegate(new BookDetailCommentDelegate());
        addItemViewDelegate(new BookDetailCommentLabelDelegate());
        addItemViewDelegate(new BookDetailGiftDelegate());
        addItemViewDelegate(new BookDetailGiftLabelDelegate());
        addItemViewDelegate(new BookDetailGiftLogDelegate());
        addItemViewDelegate(new BookDetailGiftLogLabelDelegate());
        addItemViewDelegate(new BookDetailHeaderDelegate());
        addItemViewDelegate(new BookDetailMoreDelegate());
        addItemViewDelegate(new SpaceDividerItemDelegate());
    }
}
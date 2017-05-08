package com.tenghen.ireader.adapter;

import android.content.Context;

import com.chengx.mvp.adapter.CommonRecyclerAdapter;
import com.chengx.mvp.adapter.RecyclerViewHolder;
import com.tenghen.ireader.module.Comment;

import java.util.List;

/**
 * 作者：chengx
 * 时间：${Date}
 * 描述：
 */
public class MyCommentAdapter extends CommonRecyclerAdapter<Comment> {
    public MyCommentAdapter(Context context, int layoutId, List<Comment> data) {
        super(context, layoutId, data);
    }

    @Override
    public void convert(RecyclerViewHolder holder, Comment comment) {

    }
}

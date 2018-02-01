package com.tenghen.ireader.adapter;

import android.content.Context;

import com.chengx.mvp.adapter.CommonRecyclerAdapter;
import com.chengx.mvp.adapter.RecyclerViewHolder;
import com.tenghen.ireader.module.Comment;

import java.util.List;

/**
 * Created by chengx on 18-2-1.
 */

public class AllCommentAdapter extends CommonRecyclerAdapter<Comment> {
    public AllCommentAdapter(Context context, int layoutId, List<Comment> data) {
        super(context, layoutId, data);
    }

    @Override
    public void convert(RecyclerViewHolder holder, Comment comment) {

    }
}

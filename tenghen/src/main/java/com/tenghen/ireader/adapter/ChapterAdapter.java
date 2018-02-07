package com.tenghen.ireader.adapter;

import android.content.Context;
import android.view.View;

import com.chengx.mvp.adapter.CommonRecyclerAdapter;
import com.chengx.mvp.adapter.RecyclerViewHolder;
import com.tenghen.ireader.R;
import com.tenghen.ireader.module.Chapter;

import java.util.List;

/**
 * Created by Administrator on 2018/2/4/004.
 */

public class ChapterAdapter extends CommonRecyclerAdapter<Chapter> {
    public ChapterAdapter(Context context, int layoutId, List<Chapter> data) {
        super(context, layoutId, data);
    }

    @Override
    public void convert(RecyclerViewHolder holder, Chapter chapter) {
        holder.setText(R.id.chapterNameTv,chapter.getCname());
        if (chapter.getIs_fee().equals("N")){
            holder.setVisibility(R.id.vipTagView, View.VISIBLE);
        }else {
            holder.setVisibility(R.id.vipTagView, View.GONE);
        }
    }
}

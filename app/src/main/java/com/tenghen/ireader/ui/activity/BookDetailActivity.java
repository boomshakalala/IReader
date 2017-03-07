package com.tenghen.ireader.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;

import com.chengx.mvp.base.XListPresent;
import com.tenghen.ireader.R;
import com.tenghen.ireader.adapter.BookDetailAdapter;
import com.tenghen.ireader.adapter.BookDetailGiftDelegate;
import com.tenghen.ireader.adapter.FeaturedAdapter;
import com.tenghen.ireader.adapter.FeaturedBookDelegate;
import com.tenghen.ireader.base.BaseListActivity;
import com.tenghen.ireader.ui.present.BookDetailPresent;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：chengx
 * 日期：2017/3/7
 * 描述：
 */

public class BookDetailActivity extends BaseListActivity<BookDetailPresent,Object> {
    List<Object> data;

    public static void launch(Context context){
        Intent intent = new Intent(context,BookDetailActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void initToolBar() {
        toolbar.setTitle("图书详情");
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_book_detail;
    }

    @Override
    public void initData() {
        data = new ArrayList<>();
        adapter = new BookDetailAdapter(this,data);
    }

    @Override
    public void initViews() {
        super.initViews();
        GridLayoutManager layoutManager = new GridLayoutManager(this,3);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int viewType = adapter.getItemViewType(position);
                return ((BookDetailAdapter)adapter).getItemViewDelegate(viewType) instanceof BookDetailGiftDelegate ? 1 : 3;
            }
        });
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        getPresent().refresh();
    }

    @Override
    public void setListener() {

    }

    @Override
    public BookDetailPresent newPresent() {
        return new BookDetailPresent();
    }
}

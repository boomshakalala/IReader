package com.tenghen.ireader.ui.fragment;

import android.support.v7.widget.RecyclerView;

import com.chengx.mvp.utils.SizeUtils;
import com.chengx.mvp.widget.FullyGridLayoutManager;
import com.chengx.mvp.widget.taglayout.TagItemClickListener;
import com.chengx.mvp.widget.taglayout.TagLayout;
import com.tenghen.ireader.R;
import com.tenghen.ireader.adapter.FeaturedAdapter;
import com.tenghen.ireader.adapter.HotBookAdapter;
import com.tenghen.ireader.adapter.SearchTagAdapter;
import com.tenghen.ireader.base.BaseFragment;
import com.tenghen.ireader.base.BaseListFragment;
import com.tenghen.ireader.module.Book;
import com.tenghen.ireader.ui.present.FeaturedPresent;
import com.tenghen.ireader.ui.present.SearchPresent;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 作者：chengx
 * 日期：2017/2/23
 * 描述：
 */

public class SearchFragment extends BaseFragment<SearchPresent>{

    @BindView(R.id.tagLayout)
    public TagLayout tagLayout;
    @BindView(R.id.recyclerView)
    public RecyclerView recyclerView;

    private SearchTagAdapter tagAdapter;
    private HotBookAdapter bookAdapter;
    private List<String> tags;
    private List<Book> books;



    @Override
    public void initToolBar() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_search;
    }

    @Override
    public void initData() {
        tags = new ArrayList<>();
        books = new ArrayList<>();
        tagAdapter = new SearchTagAdapter(getContext(),tags,R.layout.item_search_tag);
        bookAdapter = new HotBookAdapter(getContext(),R.layout.item_hot_book,books);
    }

    @Override
    public void initViews() {
        tagLayout.setLineSpacing(SizeUtils.dp2px(getContext(),9));
        tagLayout.setTagSpacing(SizeUtils.dp2px(getContext(),16));
        recyclerView.setLayoutManager(new FullyGridLayoutManager(getContext(),4));
        recyclerView.setAdapter(bookAdapter);
        tagLayout.setAdapter(tagAdapter);
        getPresent().requestHotWords();
        getPresent().requestData();
    }

    @Override
    public void setListener() {
        tagLayout.setTagItemListener(new TagItemClickListener() {
            @Override
            public void itemClick(int position) {
                //TODO:tag点击事件

            }
        });
    }

    @Override
    public SearchPresent newPresent() {
        return new SearchPresent();
    }

    public void setHotWords(List<String> tags){
        tagAdapter.setData(tags);
    }

    public void setBooks(List<Book> books){
        bookAdapter.setData(books);
    }

}

package com.chengx.mvp.base;

import android.support.v7.widget.RecyclerView;

import com.chengx.mvp.adapter.CommonRecyclerAdapter;
import com.chengx.mvp.adapter.HeaderAndFooterCommonAdapter;
import com.chengx.mvp.adapter.MultiItemCommonAdapter;
import com.chengx.mvp.widget.XRecyclerView;

import java.util.List;

/**
 * 作者：chengx
 * 日期：2017/2/22
 * 描述：
 */

public abstract class XListActivity<T> extends XActivity implements IListView<T>{
    private XRecyclerView recyclerView;
    private RecyclerView.Adapter<RecyclerView.ViewHolder> adapter;

    @Override
    public void refresh(List<T> data) {
        if (adapter instanceof CommonRecyclerAdapter){
            ((CommonRecyclerAdapter)adapter).setData(data);
        }else if (adapter instanceof HeaderAndFooterCommonAdapter){
            ((HeaderAndFooterCommonAdapter)adapter).setData(data);
        }else if (adapter instanceof MultiItemCommonAdapter){
            ((MultiItemCommonAdapter)adapter).setData(data);
        }
    }

    @Override
    public void loadMore(List<T> data) {
        if (adapter instanceof CommonRecyclerAdapter){
            ((CommonRecyclerAdapter)adapter).loadMore(data);
        }else if (adapter instanceof HeaderAndFooterCommonAdapter){
            ((HeaderAndFooterCommonAdapter)adapter).loadMore(data);
        }else if (adapter instanceof MultiItemCommonAdapter){
            ((MultiItemCommonAdapter)adapter).loadMore(data);
        }
    }

    @Override
    public void showEmpty() {
        recyclerView.showEmpty();
    }

    @Override
    public void showError() {
        recyclerView.showError();
    }

    @Override
    public void closeLoadMore() {
        recyclerView.closeLoadMore();
    }

    @Override
    public void showProgress() {
        recyclerView.showProgress();
    }

    @Override
    public void hideProgress() {
        recyclerView.showContent();
    }



}

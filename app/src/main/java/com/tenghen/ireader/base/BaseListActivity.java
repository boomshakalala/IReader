package com.tenghen.ireader.base;

import android.support.v7.widget.RecyclerView;

import com.chengx.mvp.base.IListPresent;
import com.chengx.mvp.base.IPresent;
import com.chengx.mvp.base.XListActivity;
import com.chengx.mvp.base.XListPresent;
import com.chengx.mvp.widget.XRecyclerView;
import com.chengx.mvp.widget.pull2refresh.PullToRefreshBase;
import com.tenghen.ireader.R;

/**
 * 作者：chengx
 * 日期：2017/2/22
 * 描述：
 */

public abstract class BaseListActivity<T extends IListPresent,M> extends XListActivity<T,M> implements PullToRefreshBase.OnRefreshListener2<RecyclerView> {

    @Override
    public void initViews() {
        recyclerView = (XRecyclerView)findViewById(R.id.xRecyclerView);
        recyclerView.setRefreshListener(this);
    }

    @Override
    public void showTip(String msg) {
        showToast(msg);
    }

    @Override
    public void onPullDownToRefresh(PullToRefreshBase<RecyclerView> refreshView) {
        if (getPresent() != null && getPresent() instanceof XListPresent) {
            ((XListPresent)getPresent()).refresh();
        }
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase<RecyclerView> refreshView) {
        if (getPresent() != null && getPresent() instanceof XListPresent) {
            ((XListPresent)getPresent()).loadMore();
        }
    }


    @Override
    protected XListPresent getPresent() {
        return (XListPresent) super.getPresent();
    }
}

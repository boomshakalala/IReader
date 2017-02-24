package com.chengx.mvp.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.chengx.mvp.R;
import com.chengx.mvp.widget.pull2refresh.PullToRefreshBase;
import com.chengx.mvp.widget.pull2refresh.PullToRefreshRecyclerView;

/**
 * 作者：chengx
 * 日期：2017/2/22
 * 描述：
 */

public class XRecyclerView extends FrameLayout {
    private PullToRefreshRecyclerView recyclerView;
    private ViewGroup emptyView;
    private ViewGroup errorView;
    private ViewGroup progressView;
    private TextView tipView;
    private int emptyViewId;
    private int errorViewId;
    private int progressViewId;

    private Context context;

    public XRecyclerView(Context context) {
        this(context,null);
    }

    public XRecyclerView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public XRecyclerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        if (attrs != null){
            initAttrs(attrs);
        }
        initView();
    }

    private void initAttrs(AttributeSet attrs) {
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.XRecyclerView);
        try {
            emptyViewId = a.getResourceId(R.styleable.XRecyclerView_emptyView,0);
            errorViewId = a.getResourceId(R.styleable.XRecyclerView_errorView,0);
            progressViewId = a.getResourceId(R.styleable.XRecyclerView_progressView,0);
        } finally {
            a.recycle();
        }
    }

    private void initView(){
        View v = LayoutInflater.from(getContext()).inflate(R.layout.common_recyclerview,this);
        recyclerView = (PullToRefreshRecyclerView) v.findViewById(R.id.recyclerView);
        recyclerView.setMode(PullToRefreshBase.Mode.BOTH);
        recyclerView.getLoadingLayoutProxy(true, true).setLoadingDrawable(getResources().getDrawable(R.drawable.default_ptr_rotate));
        // 下拉刷新时的提示文本设置
        recyclerView.getLoadingLayoutProxy(true, false).setPullLabel("下拉刷新");
        recyclerView.getLoadingLayoutProxy(true, false).setRefreshingLabel("正在加载...");
        recyclerView.getLoadingLayoutProxy(true, false).setReleaseLabel("放开以刷新");
        // 上拉加载更多时的提示文本设置
        recyclerView.getLoadingLayoutProxy(false, true).setPullLabel("上拉加载");
        recyclerView.getLoadingLayoutProxy(false, true).setRefreshingLabel("正在加载...");
        recyclerView.getLoadingLayoutProxy(false, true).setReleaseLabel("放开以加载");

        if (progressViewId != 0)
            LayoutInflater.from(getContext()).inflate(progressViewId,progressView);
        progressView = (ViewGroup) v.findViewById(R.id.progressView);
        if (emptyViewId != 0)
            LayoutInflater.from(getContext()).inflate(emptyViewId,emptyView);
        emptyView = (ViewGroup) v.findViewById(R.id.emptyView);
        if (errorViewId != 0)
            LayoutInflater.from(getContext()).inflate(errorViewId,errorView);
        errorView = (ViewGroup) v.findViewById(R.id.errorView);
    }

    private void hideAll(){
        emptyView.setVisibility(GONE);
        progressView.setVisibility(GONE);
        errorView.setVisibility(GONE);
        recyclerView.setVisibility(INVISIBLE);
    }

    public void showEmpty(){
        if (emptyView.getChildCount()>0){
            hideAll();
            emptyView.setVisibility(VISIBLE);
        }else {
            showContent();
        }
    }

    public void showError(){
        if (errorView.getChildCount()>0){
            hideAll();
            errorView.setVisibility(VISIBLE);
        }else {
            showContent();
        }
    }

    public void showProgress(){
        if (progressView.getChildCount()>0){
            hideAll();
            progressView.setVisibility(VISIBLE);
        }else {
            showContent();
        }
    }

    public void showContent(){
        hideAll();
        recyclerView.setVisibility(VISIBLE);
    }

    public void setAdapter(RecyclerView.Adapter adapter){
        recyclerView.setAdapter(adapter);
    }

    public void setLayoutManager(RecyclerView.LayoutManager manager){
        recyclerView.setLayoutManager(manager);
    }

    public void closeLoadMore(){
        recyclerView.setMode(PullToRefreshBase.Mode.PULL_FROM_START);
    }

    public void setRefreshListener(PullToRefreshBase.OnRefreshListener2<RecyclerView> refreshListener) {
        recyclerView.setOnRefreshListener(refreshListener);
    }
}

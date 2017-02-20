package com.chengx.mvp.widget.refresh;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.chengx.mvp.R;
import com.chengx.mvp.widget.refresh.swipe.OnRefreshListener;
import com.chengx.mvp.widget.refresh.swipe.SwipeRefreshLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：chengx
 * 日期：2017/2/20
 * 描述：
 */

public class XRecyclerView extends FrameLayout {
    private Context context;
    protected RecyclerView recyclerView;
    protected ViewGroup progressView;
    protected ViewGroup emptyView;
    protected ViewGroup errorView;
    private int progressId;
    private int emptyId;
    private int errorId;

    protected boolean clipToPadding;
    protected int padding;
    protected int paddingTop;
    protected int paddingBottom;
    protected int paddingLeft;
    protected int paddingRight;
    protected int scrollbarStyle;
    protected int scrollbar;

    protected RecyclerView.OnScrollListener internalOnScrollListener;
    protected RecyclerView.OnScrollListener externalOnScrollListener;

    protected SwipeRefreshLayout refreshLayout;
    protected OnRefreshListener refreshListener;

    public List<RecyclerView.ItemDecoration> decorations = new ArrayList<>();
    private Object itemAnimator;

    public SwipeRefreshLayout getRefreshLayout() {
        return refreshLayout;
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }


    public XRecyclerView(Context context) {
        this(context,null);
    }

    public XRecyclerView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
        this.context = context;
        if (attrs != null){
            initAttrs(attrs);
        }
        initView();
    }

    private void initView() {
        if (isInEditMode()){
            return;
        }
        View v = LayoutInflater.from(getContext()).inflate(R.layout.common_recyclerview,this);
        refreshLayout = (SwipeRefreshLayout) v.findViewById(R.id.layout_refresh);
        refreshLayout.setEnabled(false);

        progressView = (ViewGroup) v.findViewById(R.id.loadingView);
        if (progressId != 0) LayoutInflater.from(getContext()).inflate(progressId,progressView);
        emptyView = (ViewGroup) v.findViewById(R.id.emptyView);
        if (emptyId != 0) LayoutInflater.from(getContext()).inflate(emptyId,emptyView);
        errorView = (ViewGroup) v.findViewById(R.id.errorView);
        if (errorId != 0) LayoutInflater.from(getContext()).inflate(errorId,errorView);
        initRecyclerView(v);
    }

    private void initRecyclerView(View v) {
        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);
        setItemAnimator(null);
        if (recyclerView != null){
            recyclerView.setHasFixedSize(true);
            recyclerView.setClipToPadding(clipToPadding);
            internalOnScrollListener = new RecyclerView.OnScrollListener(){
                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);
                    if (externalOnScrollListener != null)
                        externalOnScrollListener.onScrolled(recyclerView,dx,dy);
                }

                @Override
                public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                    super.onScrollStateChanged(recyclerView, newState);
                    if (externalOnScrollListener != null)
                        externalOnScrollListener.onScrollStateChanged(recyclerView,newState);
                }
            };
            recyclerView.addOnScrollListener(internalOnScrollListener);
            if (padding != -1.0f)
                recyclerView.setPadding(padding,padding,padding,padding);
            else {
                recyclerView.setPadding(paddingLeft,paddingTop,paddingRight,paddingBottom);
            }
            if (scrollbarStyle != -1)
                recyclerView.setScrollBarStyle(scrollbarStyle);
            switch (scrollbar){
                case 0:
                    setVerticalScrollBarEnabled(false);
                    break;
                case 1:
                    setHorizontalScrollBarEnabled(false);
                    break;
                case 2:
                    setVerticalScrollBarEnabled(false);
                    setHorizontalScrollBarEnabled(false);
                    break;
            }
        }
    }

    private void initAttrs(AttributeSet attrs) {
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.XRecyclerView);
        try {
            clipToPadding = a.getBoolean(R.styleable.XRecyclerView_recyclerClipToPadding,false);
            padding = (int) a.getDimension(R.styleable.XRecyclerView_recyclerPadding, -1.0f);
            paddingTop = (int) a.getDimension(R.styleable.XRecyclerView_recyclerPaddingTop, 0.0f);
            paddingBottom = (int) a.getDimension(R.styleable.XRecyclerView_recyclerPaddingBottom, 0.0f);
            paddingLeft = (int) a.getDimension(R.styleable.XRecyclerView_recyclerPaddingLeft, 0.0f);
            paddingRight = (int) a.getDimension(R.styleable.XRecyclerView_recyclerPaddingRight, 0.0f);
            scrollbarStyle = a.getInteger(R.styleable.XRecyclerView_scrollbarStyle, -1);
            scrollbar = a.getInteger(R.styleable.XRecyclerView_scrollbars, -1);

            emptyId = a.getResourceId(R.styleable.XRecyclerView_layout_empty, 0);
            progressId = a.getResourceId(R.styleable.XRecyclerView_layout_progress, 0);
            errorId = a.getResourceId(R.styleable.XRecyclerView_layout_error, R.layout.common_net_error_view);
        }finally {
            a.recycle();
        }
    }

    @Override
    public void setVerticalScrollBarEnabled(boolean verticalScrollBarEnabled) {
        recyclerView.setVerticalScrollBarEnabled(verticalScrollBarEnabled);
    }

    @Override
    public void setHorizontalScrollBarEnabled(boolean horizontalScrollBarEnabled) {
        recyclerView.setHorizontalScrollBarEnabled(horizontalScrollBarEnabled);
    }

    public void setLayoutManager(RecyclerView.LayoutManager manager) {
        recyclerView.setLayoutManager(manager);
    }

    

    public XRecyclerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    public void setItemAnimator(RecyclerView.ItemAnimator itemAnimator) {
        this.itemAnimator = itemAnimator;
    }
}

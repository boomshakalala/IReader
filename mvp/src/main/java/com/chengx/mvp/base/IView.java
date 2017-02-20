package com.chengx.mvp.base;

import android.content.Context;

/**
 * 作者：chengx
 * 日期：2017/2/9
 * 描述：
 */

public interface IView<P> {

    void showWatting();

    void closeWait();

    void showTip(String msg);

    int getLayoutId();

    void initData();

    void initViews();

    void setListener();

    boolean useEventBus();

    P newPresent();
}

package com.chengx.mvp.base;

import java.util.List;

/**
 * 作者：chengx
 * 日期：2017/2/22
 * 描述：
 */

public interface IListView<T> extends IView {
    void refresh(List<T> data);
    void loadMore(List<T> data);
    void showEmpty();
    void showError();
    void closeLoadMore();
}

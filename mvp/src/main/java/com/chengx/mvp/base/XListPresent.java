package com.chengx.mvp.base;

/**
 * 作者：chengx
 * 日期：2017/2/9
 * 描述：
 */

public abstract class XListPresent extends XPresent implements IListPresent {
    private int currentPage = 0;

    abstract void requestData();

    @Override
    public void refresh() {
        currentPage = 0;
        requestData();
    }

    @Override
    public void loadMore() {
        currentPage++;
        requestData();
    }
}

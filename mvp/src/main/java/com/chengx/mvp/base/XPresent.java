package com.chengx.mvp.base;

/**
 * 作者：chengx
 * 日期：2017/2/9
 * 描述：
 */

public class XPresent<V extends IView> implements IPresent<V> {
    private V v;

    @Override
    public void attachV(V v) {
        this.v = v;
    }

    @Override
    public void detachV() {
        v = null;
    }

    protected V getV(){
        if (v == null){
            throw new IllegalStateException("v不能为null");
        }
        return v;
    }
}

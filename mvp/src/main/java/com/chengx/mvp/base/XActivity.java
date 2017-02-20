package com.chengx.mvp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.zhy.autolayout.AutoLayoutActivity;

import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;

/**
 * 作者：chengx
 * 日期：2017/2/9
 * 描述：
 */

public abstract class XActivity<P extends IPresent> extends AutoLayoutActivity implements IView<P> {
    private P present;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getLayoutId()>0){
            setContentView(getLayoutId());
            ButterKnife.bind(this);
        }

    }

    protected P getPresent(){
        if (present == null) {
            present = newPresent();
            if (present != null) {
                present.attachV(this);
            }
        }
        return present;
    }

    @Override
    public boolean useEventBus() {
        return false;
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (useEventBus()){
            EventBus.getDefault().register(this);
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (useEventBus() && EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().unregister(this);
        }
        if (getPresent() != null){
            present.detachV();
        }
        present = null;
    }
}

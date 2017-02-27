package com.tenghen.ireader.base;

import android.app.Application;

import com.zhy.autolayout.config.AutoLayoutConifg;

/**
 * 作者：chengx
 * 日期：2017/2/22
 * 描述：
 */

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AutoLayoutConifg.getInstance().useDeviceSize();
    }
}

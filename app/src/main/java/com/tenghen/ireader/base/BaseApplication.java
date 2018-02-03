package com.tenghen.ireader.base;

import android.app.Application;

import com.chengx.mvp.base.AppConfig;
import com.chengx.mvp.utils.AppUtils;
import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;
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
        AppUtils.init(this);
        AutoLayoutConifg.getInstance().useDeviceSize();
        Config.DEBUG = true;
    }

    {
        PlatformConfig.setWeixin(AppConfig.WX_APP_ID, AppConfig.WX_APP_SECRET);
//        PlatformConfig.setQQZone(AppConfig.WX_APP_ID, AppConfig.WX_APP_SECRET);
    }

}

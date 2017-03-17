package com.tenghen.ireader.wbapi;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import com.chengx.mvp.base.AppConfig;
import com.chengx.mvp.utils.KLog;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.api.share.IWeiboShareAPI;
import com.sina.weibo.sdk.api.share.WeiboShareSDK;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.auth.sso.SsoHandler;
import com.sina.weibo.sdk.exception.WeiboException;

/**
 * 作者：chengx
 * 日期：2016/12/21
 * 描述：
 */

public class WBAPI {

    public static final String REDIRECT_URL = "http://www.sina.com";
    public static final String TAG = "WBAPI";

    public static void share(Context context){
        IWeiboShareAPI api = WeiboShareSDK.createWeiboAPI(context, AppConfig.WB_APP_ID);
        api.registerApp();


    }

    public static void login(Activity context){
        AuthInfo authInfo = new AuthInfo(context, AppConfig.WB_APP_ID,REDIRECT_URL,"");
        SsoHandler ssoHandler = new SsoHandler(context,authInfo);
        ssoHandler.authorize(new WeiboAuthListener() {
            @Override
            public void onComplete(Bundle bundle) {
                KLog.d(TAG,"onComplete");
            }

            @Override
            public void onWeiboException(WeiboException e) {

            }

            @Override
            public void onCancel() {

            }
        });
    }

}

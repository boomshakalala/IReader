package com.tenghen.ireader.wbapi;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;

import com.chengx.mvp.base.AppConfig;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.auth.sso.SsoHandler;
import com.sina.weibo.sdk.exception.WeiboException;

/**
 * 作者：chengx
 * 日期：2017/3/13
 * 描述：
 */

public class WBAuthActivity extends AppCompatActivity implements WeiboAuthListener {



    private AuthInfo authInfo;
    private Oauth2AccessToken accessToken;
    private SsoHandler ssoHandler;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        authInfo = new AuthInfo(this, AppConfig.WB_APP_ID,REDIRECT_URL,"");
//        ssoHandler = new SsoHandler(this,authInfo);
//        ssoHandler.authorize(this);

    }

    @Override
    public void onComplete(Bundle bundle) {

    }

    @Override
    public void onWeiboException(WeiboException e) {

    }

    @Override
    public void onCancel() {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (ssoHandler != null){
            ssoHandler.authorizeCallBack(resultCode,resultCode,data);
        }
    }
}

package com.tenghen.ireader.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.chengx.mvp.base.AppConfig;
import com.chengx.mvp.utils.KLog;
import com.chengx.mvp.utils.SPUtils;
import com.chengx.mvp.utils.ToastUtils;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import de.greenrobot.event.EventBus;


/**
 * 作者: chengx
 * 日期: 2016/11/4.
 * 描述:
 */
public class WXEntryActivity extends Activity implements IWXAPIEventHandler {

    private static String TAG = "WXEntryActivity";
    private IWXAPI api;
    private SPUtils sp;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
    }

    protected void initViews() {

    }

    protected void initData() {
        api = WXAPIFactory.createWXAPI(this, AppConfig.WX_APP_ID);
        api.handleIntent(this.getIntent(), this);
        sp = new SPUtils(this,AppConfig.SP_NAME);
    }


    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        api.handleIntent(intent, this);
    }




    @Override
    public void onReq(BaseReq baseReq) {
        KLog.d(TAG,"resp=========>"+baseReq);
    }

    @Override
    public void onResp(BaseResp baseResp) {
        KLog.e(TAG,baseResp.errCode);
        KLog.e(TAG,baseResp.errStr);
        KLog.e(TAG,baseResp.getType());
        KLog.e(TAG,baseResp.transaction);
        if (baseResp.errCode == BaseResp.ErrCode.ERR_OK){
            if (baseResp instanceof SendAuth.Resp){
                KLog.d(TAG,"微信登录成功返回");
                EventBus.getDefault().post(baseResp);
            }else {
                ToastUtils.showToast(this,"分享成功");
            }
            finish();
        }else if (baseResp.errCode == BaseResp.ErrCode.ERR_USER_CANCEL ||baseResp.errCode == BaseResp.ErrCode.ERR_AUTH_DENIED){
            ToastUtils.showToast(this,"玩儿呢哥？");
            finish();
        }else {
            ToastUtils.showToast(this,"操作失败");
            finish();
        }
    }

}

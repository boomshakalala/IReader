package com.tenghen.ireader.wxapi;

import android.content.Intent;

import com.chengx.mvp.base.AppConfig;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.tenghen.ireader.R;
import com.tenghen.ireader.base.BaseActivity;


/**
 * 作者: chengx
 * 日期: 2016/11/4.
 * 描述: 微信支付返回结果页
 */
public class WXPayEntryActivity extends BaseActivity implements IWXAPIEventHandler {

    private IWXAPI api;

    @Override
    public void initViews() {

    }

    @Override
    public void setListener() {

    }

    @Override
    public Object newPresent() {
        return null;
    }

    @Override
    public void initToolBar() {

    }

    @Override
    public int getLayoutId() {
        return 0;
    }

    @Override
    public void initData() {
        api = WXAPIFactory.createWXAPI(this, AppConfig.WX_APP_ID,true);
        api.handleIntent(this.getIntent(), this);
    }


    @Override
    public boolean isNeedToolbar() {
        return false;
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        api.handleIntent(intent, this);
    }

    @Override
    public void onReq(BaseReq req) {

    }

    @Override
    public void onResp(BaseResp resp) {
        log("微信支付回调>>resp>>" + resp.errCode);
        if (resp.getType() == ConstantsAPI.COMMAND_PAY_BY_WX){
            if (resp.errCode == 0){
                showToast("支付成功");
            }else {
                showToast("支付失败");
            }
            finish();
        }
    }
}

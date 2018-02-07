package com.tenghen.ireader.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.widget.EditText;
import android.widget.TextView;

import com.tenghen.ireader.R;
import com.tenghen.ireader.base.BaseActivity;
import com.tenghen.ireader.ui.present.LoginPresent;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 作者：chengx
 * 时间：${Date}
 * 描述：
 */
public class LoginActivity extends BaseActivity<LoginPresent> implements UMAuthListener {

    @BindView(R.id.loginUserNameEt)
    EditText userNameEt;
    @BindView(R.id.loginPasswordEt)
    EditText passwordEt;

    public static void launch(Activity context,int requestCode){
        Intent intent = new Intent(context,LoginActivity.class);
        context.startActivityForResult(intent,requestCode);
    }

    public static void launch(Fragment context,int requestCode){
        Intent intent = new Intent(context.getContext(),LoginActivity.class);
        context.startActivityForResult(intent, requestCode);
    }

    @Override
    public void initToolBar() {
        toolbar.setTitle("账号登录");
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initViews() {

    }

    @Override
    public void setListener() {

    }

    @Override
    public LoginPresent newPresent() {
        return new LoginPresent();
    }

    @OnClick(R.id.registerBtn)
    public void register(TextView textView){
        RegisterActivity.launch(this);
    }

    @OnClick(R.id.loginBtn)
    public void login(){
        String userName = userNameEt.getText().toString().trim();
        String password = passwordEt.getText().toString().trim();
        getPresent().login(userName,password);
    }
    @OnClick(R.id.wxLoginBtn)
    public void wxLogin(){
        UMShareAPI.get(this).getPlatformInfo(this, SHARE_MEDIA.WEIXIN, this);

    }
    @OnClick(R.id.qqLoginBtn)
    public void qqLogin(){
        UMShareAPI.get(this).getPlatformInfo(this, SHARE_MEDIA.QQ, this);

    }
    @OnClick(R.id.wbLoginBtn)
    public void wbLogin(){
        UMShareAPI.get(this).getPlatformInfo(this, SHARE_MEDIA.SINA, this);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode,resultCode,data);
    }


    @Override
    public void onStart(SHARE_MEDIA share_media) {

    }

    @Override
    public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {

        log(TAG,map);

        switch (share_media){
            case QQ:
                break;
            case WEIXIN:
                break;
            case SINA:
                break;
        }
    }

    @Override
    public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
        showToast("登录失败");
    }

    @Override
    public void onCancel(SHARE_MEDIA share_media, int i) {
        showToast("取消登录");
    }
}

package com.tenghen.ireader.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

import com.tenghen.ireader.R;
import com.tenghen.ireader.base.BaseActivity;
import com.tenghen.ireader.ui.present.LoginPresent;

import butterknife.OnClick;

/**
 * 作者：chengx
 * 时间：${Date}
 * 描述：
 */
public class LoginActivity extends BaseActivity<LoginPresent>{

    public static void launch(Context context){
        Intent intent = new Intent(context,LoginActivity.class);
        context.startActivity(intent);
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
}

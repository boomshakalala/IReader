package com.tenghen.ireader.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.widget.EditText;
import android.widget.TextView;

import com.tenghen.ireader.R;
import com.tenghen.ireader.base.BaseActivity;
import com.tenghen.ireader.ui.present.LoginPresent;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 作者：chengx
 * 时间：${Date}
 * 描述：
 */
public class LoginActivity extends BaseActivity<LoginPresent>{

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


}

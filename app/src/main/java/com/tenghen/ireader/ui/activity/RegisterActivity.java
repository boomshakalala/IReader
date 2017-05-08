package com.tenghen.ireader.ui.activity;

import android.content.Context;
import android.content.Intent;

import com.tenghen.ireader.R;
import com.tenghen.ireader.base.BaseActivity;
import com.tenghen.ireader.ui.present.RegisterPresent;

/**
 * 作者：chengx
 * 时间：${Date}
 * 描述：
 */
public class RegisterActivity extends BaseActivity<RegisterPresent> {

    public static void launch(Context context){
        Intent intent = new Intent(context,RegisterActivity.class);
        context.startActivity(intent);
    }
    @Override
    public void initToolBar() {
        toolbar.setTitle("最近阅读");
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_register;
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
    public RegisterPresent newPresent() {
        return new RegisterPresent();
    }
}

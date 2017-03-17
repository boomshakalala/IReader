package com.tenghen.ireader.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.tenghen.ireader.R;
import com.tenghen.ireader.base.BaseActivity;

import butterknife.BindView;

/**
 * 作者：chengx
 * 日期：2017/3/8
 * 描述：
 */

public class ReadActivity extends BaseActivity{
    @BindView(R.id.bookContentTv)
    public TextView bookContentTv;

    public static void launch(Context context){
        Intent intent = new Intent(context,ReadActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void initToolBar() {

    }

    @Override
    public int getLayoutId() {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        return R.layout.activity_read;
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
    public Object newPresent() {
        return null;
    }

}

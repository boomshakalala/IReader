package com.tenghen.ireader.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chengx.mvp.utils.SizeUtils;
import com.chengx.mvp.widget.auto.AutoScrollView;
import com.tenghen.ireader.R;
import com.tenghen.ireader.base.BaseActivity;

import java.util.TimerTask;

import butterknife.BindView;

/**
 * 作者：chengx
 * 日期：2017/3/8
 * 描述：
 */

public class ReadActivity extends BaseActivity{

    public  float LargeTextSize = SizeUtils.sp2px(this,24);
    public  float MidTextSize = SizeUtils.sp2px(this,18);
    public  float SmallTextSize = SizeUtils.sp2px(this,12);

    @BindView(R.id.bookContentTv)
    public TextView bookContentTv;
    @BindView(R.id.readRootView)
    public LinearLayout readRootView;
    @BindView(R.id.chapterNameTv)
    public TextView chapterNameTv;
    @BindView(R.id.bookNameTv)
    public TextView bookNameTv;
    @BindView(R.id.sv)
    public AutoScrollView sv;

    private int mode = 1;

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
        mode = sp.getInt("mode",1);
    }

    private void setMode(int mode){
        String bgColor = "#ffffff";
        switch (mode){
            case 1:
                bgColor = sp.getString("dayColor","#ffffff");
                chapterNameTv.setTextColor(Color.parseColor("#77d1da"));
                bookNameTv.setTextColor(Color.parseColor("#77d1da"));
                bookContentTv.setTextColor(getResources().getColor(R.color.black));
                break;
            case 2:
                bgColor = sp.getString("dayColor","#ffffff");
                bookContentTv.setTextColor(Color.parseColor("#636363"));
                chapterNameTv.setTextColor(Color.parseColor("#636363"));
                bookNameTv.setTextColor(Color.parseColor("#636363"));
                break;
        }
        float textSize = sp.getFloat("textSize",MidTextSize);
        readRootView.setBackgroundColor(Color.parseColor(bgColor));
        bookContentTv.setTextSize(textSize);
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

    class AutoScrollTask extends TimerTask {
        public void run(){
            Message msg=new Message();
            msg.what=1;
            handler.sendMessage(msg);
        }
    }

    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            if(msg.what==1){
                //如果没有到底端，Y偏移量增加10
                if(sv.getScrollY()<bookContentTv.getMeasuredHeight()-10){
                    sv.scrollBy(0, 10);
                }
                else {
                    //直接到底端
                    sv.scrollTo(0, bookContentTv.getMeasuredHeight());
                }
            }
            super.handleMessage(msg);
        }
    };

}

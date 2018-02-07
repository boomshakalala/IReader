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

import com.chengx.mvp.utils.AppUtils;
import com.chengx.mvp.utils.SizeUtils;
import com.chengx.mvp.widget.auto.AutoScrollView;
import com.tenghen.ireader.R;
import com.tenghen.ireader.base.BaseActivity;
import com.tenghen.ireader.widget.CommentDialog;
import com.tenghen.ireader.widget.GifDialog;
import com.tenghen.ireader.widget.SettingDialog;

import java.util.TimerTask;

import butterknife.BindView;
import butterknife.OnClick;
import de.greenrobot.event.EventBus;

/**
 * 作者：chengx
 * 日期：2017/3/8
 * 描述：
 */

public class ReadActivity extends BaseActivity{

    public  static float LargeTextSize = SizeUtils.sp2px(AppUtils.getAppContext(),12);
    public  static float MidTextSize = SizeUtils.sp2px(AppUtils.getAppContext(),9);
    public  static float SmallTextSize = SizeUtils.sp2px(AppUtils.getAppContext(),6);

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
        setMode(mode);
        EventBus.getDefault().register(this);
    }

    public void setMode(int mode){
        String bgColor = "#ffffff";
        switch (mode){
            case 1:
                bgColor = sp.getString("dayColor","#ffffff");
                chapterNameTv.setTextColor(Color.parseColor("#77d1da"));
                bookNameTv.setTextColor(Color.parseColor("#77d1da"));
                bookContentTv.setTextColor(getResources().getColor(R.color.black));
                break;
            case 2:
                bgColor = sp.getString("nightColor","#ffffff");
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

    @OnClick({R.id.giftBtn,R.id.commentBtn,R.id.settingBtn})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.giftBtn:
                new GifDialog(this).show();
                break;
            case R.id.commentBtn:
//                new CommentDialog(this,)
                break;
            case R.id.settingBtn:
                new SettingDialog(this).show();
                break;
        }
    }

    public void onEventMainThread(Integer mode){
        setMode(mode);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}

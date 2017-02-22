package com.chengx.mvp.base;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.Window;
import android.view.WindowManager;

import com.chengx.mvp.utils.ConstUtils;
import com.chengx.mvp.utils.KLog;
import com.chengx.mvp.utils.SPUtils;
import com.chengx.mvp.utils.ToastUtils;
import com.chengx.mvp.widget.loadding.CustomDialog;
import com.zhy.autolayout.AutoLayoutActivity;

import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;

/**
 * 作者：chengx
 * 日期：2017/2/9
 * 描述：
 */

public abstract class XActivity<P extends IPresent> extends AutoLayoutActivity implements IView<P> {
    public final String TAG = getClass().getSimpleName();
    private P present;
    private SPUtils sp;
    private boolean couldDoubleBackExit;
    private boolean pressedOnce;
    private boolean needToolbar;
    private boolean needFullScreen;
    private CustomDialog dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getLayoutId()>0){
            setContentView(getLayoutId());
            ButterKnife.bind(this);
            sp = new SPUtils(this,AppConfig.SP_NAME);
            if (needFullScreen){
                getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FIRST_SUB_WINDOW);
            }

        }

    }

    public CustomDialog getDialog(){
        if (dialog == null) {
            dialog = CustomDialog.instance(this);
            dialog.setCancelable(true);
        }
        return dialog;
    }

    public void showDialog(){
        getDialog().show();
    }

    public void log(Object... objects){
        KLog.d(TAG, objects);
    }

    public void logJson(String json){
        KLog.json(TAG, json);
    }

    public void dismissDialog(){
        if (dialog != null) {
            dialog.hide();
            dialog = null;
        }
    }

    protected P getPresent(){
        if (present == null) {
            present = newPresent();
            if (present != null) {
                present.attachV(this);
            }
        }
        return present;
    }

    public void showToast(String str){
        ToastUtils.showToast(this,str);
    }

    @Override
    public boolean useEventBus() {
        return false;
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (useEventBus()){
            EventBus.getDefault().register(this);
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (useEventBus() && EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().unregister(this);
        }
        if (getPresent() != null){
            present.detachV();
        }
        dismissDialog();
        present = null;
    }

    public boolean isCouldDoubleBackExit() {
        return couldDoubleBackExit;
    }

    public void setCouldDoubleBackExit(boolean couldDoubleBackExit) {
        this.couldDoubleBackExit = couldDoubleBackExit;
    }

    public boolean isNeedToolbar() {
        return needToolbar;
    }

    public void setNeedToolbar(boolean needToolbar) {
        this.needToolbar = needToolbar;
    }

    public boolean isNeedFullScreen() {
        return needFullScreen;
    }

    public void setNeedFullScreen(boolean needfullScreen) {
        this.needFullScreen = needfullScreen;
    }

    @Override
    public void onBackPressed() {
        if (!couldDoubleBackExit){
            super.onBackPressed();
        }else {
            if (pressedOnce){
                System.exit(0);
                return;
            }
            pressedOnce = true;
            showToast("再按一次退出程序");
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    pressedOnce = false;
                }
            }, ConstUtils.SEC*2);
        }
    }
}

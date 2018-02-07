package com.tenghen.ireader;

import android.content.Context;

import com.chengx.mvp.base.AppConfig;
import com.chengx.mvp.utils.AppUtils;
import com.chengx.mvp.utils.SPUtils;
import com.chengx.mvp.utils.ToastUtils;
import com.tenghen.ireader.module.User;
import com.tenghen.ireader.ui.activity.LoginActivity;

public class CommonUtils {
    public static boolean isLogin(){
        return   getUserInfo() != null;
    }

    public static User getUserInfo(){
        SPUtils sp = new SPUtils(AppUtils.getAppContext(), AppConfig.SP_NAME);
        return sp.getObject("user",null);
    }

    public static void clearUserInfo(){
        SPUtils sp = new SPUtils(AppUtils.getAppContext(),AppConfig.SP_NAME);
        sp.clear();
    }

    public static void loginAndToast(Context context){
        ToastUtils.showToast(AppUtils.getAppContext(),"请登录");
    }
}
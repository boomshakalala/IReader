package com.tenghen.ireader;

import com.chengx.mvp.base.AppConfig;
import com.chengx.mvp.utils.AppUtils;
import com.chengx.mvp.utils.SPUtils;
import com.tenghen.ireader.module.User;

public class CommonUtils {
    public static boolean isLogin(){
        return   getUserInfo() != null;
    }

    public static User getUserInfo(){
        SPUtils sp = new SPUtils(AppUtils.getAppContext(), AppConfig.SP_NAME);
        return sp.getObject("user",null);
    }
}
package com.tenghen.ireader.ui.present;

import com.chengx.mvp.base.AppConfig;
import com.chengx.mvp.net.ResponseCallback;
import com.chengx.mvp.utils.AppUtils;
import com.chengx.mvp.utils.SPUtils;
import com.tenghen.ireader.base.BasePresent;
import com.tenghen.ireader.module.User;
import com.tenghen.ireader.net.Api;
import com.tenghen.ireader.ui.activity.LoginActivity;

/**
 * 作者：chengx
 * 时间：${Date}
 * 描述：
 */
public class LoginPresent extends BasePresent<LoginActivity> {

    public void login(String userName,String password){
        getV().showProgress();
        Api.userLogin(1, userName, password, null, new ResponseCallback<User>() {
            @Override
            public void onSuccess(User data) {
                saveUserInfo(data);
                getV().dismissDialog();
                getV().finish();
            }

            @Override
            public void onFailure(int errCode, String info) {
                getV().showTip(info);
                getV().dismissDialog();
            }
        });
    }

    private void saveUserInfo(User user){
        new SPUtils(AppUtils.getAppContext(), AppConfig.SP_NAME).putObject("user",user);
    }

}

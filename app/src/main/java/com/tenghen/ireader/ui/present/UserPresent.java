package com.tenghen.ireader.ui.present;

import com.chengx.mvp.base.AppConfig;
import com.chengx.mvp.net.ResponseCallback;
import com.chengx.mvp.net.WXApiResponse;
import com.chengx.mvp.utils.KLog;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tenghen.ireader.base.BaseFragment;
import com.tenghen.ireader.base.BaseListPresent;
import com.tenghen.ireader.base.BasePresent;
import com.tenghen.ireader.module.User;
import com.tenghen.ireader.net.Api;
import com.tenghen.ireader.ui.fragment.StacksFragment;
import com.tenghen.ireader.ui.fragment.UserFragment;
import com.tenghen.ireader.wxapi.WXAPI;

import de.greenrobot.event.EventBus;

/**
 * 作者：chengx
 * 日期：2017/2/23
 * 描述：
 */

public class UserPresent extends BasePresent<UserFragment> {
    @Override
    public void attachV(UserFragment userFragment) {
        super.attachV(userFragment);
        EventBus.getDefault().register(this);
    }

    @Override
    public void detachV() {
        super.detachV();
        EventBus.getDefault().unregister(this);
    }


    public void getWalletData(){

    }

    public void getUserData(){

    }

    public void getSignData(){

    }


}

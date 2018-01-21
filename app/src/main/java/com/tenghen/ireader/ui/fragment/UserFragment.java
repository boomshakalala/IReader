package com.tenghen.ireader.ui.fragment;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chengx.mvp.net.ResponseCallback;
import com.chengx.mvp.utils.KLog;
import com.chengx.mvp.widget.CircleImageView;
import com.tenghen.ireader.R;
import com.tenghen.ireader.aliapi.Alipay;
import com.tenghen.ireader.base.BaseFragment;
import com.tenghen.ireader.base.BaseListFragment;
//import com.tenghen.ireader.qqapi.QQAPI;
import com.tenghen.ireader.module.OrderInfo;
import com.tenghen.ireader.net.Api;
import com.tenghen.ireader.ui.activity.CostLogActivity;
import com.tenghen.ireader.ui.activity.LatestReadActivity;
import com.tenghen.ireader.ui.activity.LoginActivity;
import com.tenghen.ireader.ui.activity.MyCommentActivity;
import com.tenghen.ireader.ui.activity.MyMsgActivity;
import com.tenghen.ireader.ui.activity.MyShelfActivity;
import com.tenghen.ireader.ui.activity.RechargeLogActivity;
import com.tenghen.ireader.ui.activity.TopicActivity;
import com.tenghen.ireader.ui.present.UserPresent;
import com.tenghen.ireader.wxapi.WXAPI;

import java.util.EventListener;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 作者：chengx
 * 日期：2017/2/23
 * 描述：
 */

public class UserFragment extends BaseFragment<UserPresent> {
    public static final int OPT_TO_RECHARGE = 1;
    public static final int OPT_TO_MY_SHELF = 2;
    public static final int OPT_TO_RECHARGE_LOG = 3;
    public static final int OPT_TO_COST_LOG = 4;
    public static final int OPT_TO_LETAST_READ = 5;
    public static final int OPT_TO_MY_COMMENT = 6;
    public static final int OPT_TO_MY_MSG = 7;
    public static final int OPT_TO_DOWNLOAD = 8;
    public static final int OPT_TO_RESET_PSD = 9;
    public static final int OPT_TO_SETTING = 10;

    @BindView(R.id.avatarIv)
    CircleImageView avatarIv;
    @BindView(R.id.nickNameTv)
    TextView nickNameTv;
    @BindView(R.id.userIdTv)
    TextView userIdTv;
    @BindView(R.id.phoneNumTv)
    TextView phoneNumTv;
    @Override
    public void initToolBar() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_user;
    }

    @Override
    public void initData() {
        getPresent();
    }

    @Override
    public void initViews() {
        if (isLogin())
            setUserInfo();
        else
            clearUserInfo();
    }

    @Override
    public void setListener() {

    }

    @Override
    public UserPresent newPresent() {
        return new UserPresent();
    }

    @OnClick(R.id.avatarIv)
    public void login(){
        if (isLogin()){

        }else {
            LoginActivity.launch(this,0);
        }

    }

    @OnClick(R.id.latestReadBtn)
    public void toLatestRead(){
        if (isLogin())
            LatestReadActivity.launch(getContext());
        else
            LoginActivity.launch(this,OPT_TO_LETAST_READ);
    }

    @OnClick(R.id.myShelfBtn)
    public void toMyShelf(){
        if (isLogin())
            MyShelfActivity.launch(getContext());
        else
            LoginActivity.launch(this,OPT_TO_MY_SHELF);
    }

    @OnClick(R.id.rechargeLogBtn)
    public void toRechargeLog(){
        if (isLogin())
            RechargeLogActivity.launch(getContext());
        else
            LoginActivity.launch(this,OPT_TO_RECHARGE_LOG);
    }

    @OnClick(R.id.costLogBtn)
    public void toCostLog(){
        if (isLogin())
            CostLogActivity.launch(getContext());
        else
            LoginActivity.launch(this,OPT_TO_COST_LOG);
    }

    @OnClick(R.id.myCommentBtn)
    public void toMyComment(){
        if (isLogin())
            MyCommentActivity.launch(getContext());
        else
            LoginActivity.launch(this,OPT_TO_MY_COMMENT);
    }

    @OnClick(R.id.myMsgBtn)
    public void toMyMsg(){
        if (isLogin())
            MyMsgActivity.launch(getContext());
        else
            LoginActivity.launch(this,OPT_TO_MY_MSG);
    }

    public void setUserInfo(){
//        nickNameTv.setText(getUserInfo().getNickName());
//        Glide.with(this).load(getUserInfo().getAvatar()).into(avatarIv);
        userIdTv.setVisibility(View.VISIBLE);
        phoneNumTv.setVisibility(View.VISIBLE);
        userIdTv.setText("ID:"+getUserInfo().getUserId());
//        phoneNumTv.setText(getUserInfo().getPhoneNum());
    }

    public void clearUserInfo(){
        nickNameTv.setText("注册/登录");
        avatarIv.setImageResource(R.drawable.ic_user_avatar);
        userIdTv.setVisibility(View.GONE);
        phoneNumTv.setVisibility(View.GONE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (isLogin())
            setUserInfo();
        else
            clearUserInfo();
        switch (requestCode){
            case OPT_TO_LETAST_READ:
                if (isLogin())
                    LatestReadActivity.launch(getContext());
                break;
            case OPT_TO_MY_SHELF:
                if (isLogin())
                    MyShelfActivity.launch(getContext());
                break;
            case OPT_TO_RECHARGE_LOG:
                if (isLogin())
                    RechargeLogActivity.launch(getContext());
                break;
            case OPT_TO_COST_LOG:
                if (isLogin())
                    CostLogActivity.launch(getContext());
                break;
            case OPT_TO_MY_COMMENT:
                if (isLogin())
                    MyCommentActivity.launch(getContext());
                break;
            case OPT_TO_MY_MSG:
                if (isLogin())
                    MyMsgActivity.launch(getContext());
                break;
        }

    }

    @OnClick(R.id.rechargeBtn)
    public void recharge(View view){
        Api.orderRecharge("0.01", "1", "1", new ResponseCallback<OrderInfo>() {
            @Override
            public void onSuccess(OrderInfo data) {
                KLog.d(TAG,data.getResponse());
                Alipay.getInstance().pay(getActivity(),data.getResponse());
            }

            @Override
            public void onFailure(int errCode, String info) {

            }
        });
    }
}

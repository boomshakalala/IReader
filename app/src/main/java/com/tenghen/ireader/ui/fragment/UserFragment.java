package com.tenghen.ireader.ui.fragment;

import android.widget.TextView;

import com.tenghen.ireader.R;
import com.tenghen.ireader.base.BaseFragment;
import com.tenghen.ireader.base.BaseListFragment;
//import com.tenghen.ireader.qqapi.QQAPI;
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

import butterknife.OnClick;

/**
 * 作者：chengx
 * 日期：2017/2/23
 * 描述：
 */

public class UserFragment extends BaseFragment<UserPresent> {
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
        LoginActivity.launch(getContext());
    }

    @OnClick(R.id.latestReadBtn)
    public void toLatestRead(){
        LatestReadActivity.launch(getContext());
    }

    @OnClick(R.id.myShelfBtn)
    public void toMyShelf(){
        MyShelfActivity.launch(getContext());
    }

    @OnClick(R.id.rechargeLogBtn)
    public void toRechargeLog(){
        RechargeLogActivity.launch(getContext());
    }

    @OnClick(R.id.costLogBtn)
    public void toCostLog(){
        CostLogActivity.launch(getContext());
    }

    @OnClick(R.id.myCommentBtn)
    public void toMyComment(){
        MyCommentActivity.launch(getContext());
    }

    @OnClick(R.id.myMsgBtn)
    public void toMyMsg(){
        MyMsgActivity.launch(getContext());
    }


}

package com.tenghen.ireader.ui.fragment;

import com.tenghen.ireader.R;
import com.tenghen.ireader.base.BaseFragment;
import com.tenghen.ireader.base.BaseListFragment;
import com.tenghen.ireader.qqapi.QQAPI;
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
        QQAPI.login(getActivity());
    }
}

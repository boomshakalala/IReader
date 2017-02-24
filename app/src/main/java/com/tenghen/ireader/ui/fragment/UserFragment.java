package com.tenghen.ireader.ui.fragment;

import com.tenghen.ireader.R;
import com.tenghen.ireader.base.BaseListFragment;
import com.tenghen.ireader.ui.present.FeaturedPresent;
import com.tenghen.ireader.ui.present.UserPresent;

/**
 * 作者：chengx
 * 日期：2017/2/23
 * 描述：
 */

public class UserFragment extends BaseListFragment<UserPresent,Object> {
    @Override
    public void initToolBar() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_user;
    }

    @Override
    public void initData() {

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
}

package com.tenghen.ireader.ui.fragment;

import com.tenghen.ireader.R;
import com.tenghen.ireader.base.BaseListFragment;
import com.tenghen.ireader.ui.present.FeaturedPresent;
import com.tenghen.ireader.ui.present.StacksPresent;

/**
 * 作者：chengx
 * 日期：2017/2/23
 * 描述：
 */

public class StacksFragment extends BaseListFragment<StacksPresent,Object> {
    @Override
    public void initToolBar() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_stacks;
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
    public StacksPresent newPresent() {
        return new StacksPresent();
    }
}

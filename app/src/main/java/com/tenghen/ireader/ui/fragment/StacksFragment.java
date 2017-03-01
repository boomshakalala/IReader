package com.tenghen.ireader.ui.fragment;

import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;

import com.tenghen.ireader.R;
import com.tenghen.ireader.base.BaseListFragment;
import com.tenghen.ireader.ui.activity.BookTypeActivity;
import com.tenghen.ireader.ui.activity.RankActivity;
import com.tenghen.ireader.ui.present.BookTypePresent;

import butterknife.BindView;

/**
 * 作者：chengx
 * 日期：2017/2/23
 * 描述：
 */

public class StacksFragment extends BaseListFragment implements View.OnClickListener {

    @BindView(R.id.stacksModernBtn)
    public TextView stacksModerBtn;
    @BindView(R.id.stacksAncientBtn)
    public TextView stacksAncientBtn;
    @BindView(R.id.stacksCityBtn)
    public TextView stacksCityBtn;
    @BindView(R.id.stacksFantasyBtn)
    public TextView stacksFantasyBtn;
    @BindView(R.id.stacksFantasyLoveBtn)
    public TextView stacksFantasyLoveBtn;
    @BindView(R.id.stacksSchoolBtn)
    public TextView stacksSchoolBtn;

    @BindView(R.id.clickRankBtn)
    public TextView clickRankBtn;
    @BindView(R.id.subRankBtn)
    public TextView subRankBtn;
    @BindView(R.id.collectRankBtn)
    public TextView collectRankBtn;
    @BindView(R.id.recRankBtn)
    public TextView recRankBtn;
    @BindView(R.id.newRankBtn)
    public TextView newRankBtn;
    @BindView(R.id.completeRankBtn)
    public TextView completeRankBtn;
    @BindView(R.id.updateRankBtn)
    public TextView updateRankBtn;
    @BindView(R.id.rewardRankBtn)
    public TextView rewardRankBtn;


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
        clickRankBtn.setOnClickListener(this);
        subRankBtn.setOnClickListener(this);
        collectRankBtn.setOnClickListener(this);
        recRankBtn.setOnClickListener(this);
        newRankBtn.setOnClickListener(this);
        completeRankBtn.setOnClickListener(this);
        updateRankBtn.setOnClickListener(this);
        rewardRankBtn.setOnClickListener(this);

        stacksModerBtn.setOnClickListener(this);
        stacksAncientBtn.setOnClickListener(this);
        stacksCityBtn.setOnClickListener(this);
        stacksFantasyBtn.setOnClickListener(this);
        stacksFantasyLoveBtn.setOnClickListener(this);
        stacksSchoolBtn.setOnClickListener(this);
    }

    @Override
    public Object newPresent() {
        return null;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.stacksModernBtn:
                BookTypeActivity.launch(getContext());
                break;
            case R.id.stacksAncientBtn:
                BookTypeActivity.launch(getContext());
                break;
            case R.id.stacksCityBtn:
                BookTypeActivity.launch(getContext());
                break;
            case R.id.stacksFantasyBtn:
                BookTypeActivity.launch(getContext());
                break;
            case R.id.stacksFantasyLoveBtn:
                BookTypeActivity.launch(getContext());
                break;
            case R.id.stacksSchoolBtn:
                BookTypeActivity.launch(getContext());
                break;

            case R.id.clickRankBtn:
                RankActivity.launch(getContext());
                break;
            case R.id.subRankBtn:
                RankActivity.launch(getContext());
                break;
            case R.id.collectRankBtn:
                RankActivity.launch(getContext());
                break;
            case R.id.recRankBtn:
                RankActivity.launch(getContext());
                break;
            case R.id.newRankBtn:
                RankActivity.launch(getContext());
                break;
            case R.id.completeBtn:
                RankActivity.launch(getContext());
                break;
            case R.id.updateRankBtn:
                RankActivity.launch(getContext());
                break;
            case R.id.rewardRankBtn:
                RankActivity.launch(getContext());
                break;
        }
    }
}

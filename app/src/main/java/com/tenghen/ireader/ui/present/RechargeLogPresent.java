package com.tenghen.ireader.ui.present;

import com.tenghen.ireader.adapter.ViewSupportModel;
import com.tenghen.ireader.base.BaseListPresent;
import com.tenghen.ireader.module.Recharge;
import com.tenghen.ireader.ui.activity.RechargeLogActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：chengx
 * 时间：${Date}
 * 描述：
 */
public class RechargeLogPresent extends BaseListPresent<RechargeLogActivity> {
    @Override
    protected void requestData() {
        List<Object> data = new ArrayList<>();
        data.add(new ViewSupportModel(ViewSupportModel.VIEW_TYPE_SPLIT_LINE));
        for (int i = 0; i < 10; i++) {
            data.add(new Recharge());
        }
        getV().refresh(data);
    }
}

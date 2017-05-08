package com.tenghen.ireader.ui.present;

import com.tenghen.ireader.base.BaseListPresent;
import com.tenghen.ireader.module.Cost;
import com.tenghen.ireader.ui.activity.CostLogActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：chengx
 * 时间：${Date}
 * 描述：
 */
public class CostLogPresent extends BaseListPresent<CostLogActivity> {
    @Override
    protected void requestData() {
        List<Cost> data = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            data.add(new Cost());
        }
        getV().refresh(data);
    }
}

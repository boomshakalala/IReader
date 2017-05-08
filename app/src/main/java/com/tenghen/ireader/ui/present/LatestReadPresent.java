package com.tenghen.ireader.ui.present;

import com.tenghen.ireader.base.BaseListPresent;
import com.tenghen.ireader.module.LatestBook;
import com.tenghen.ireader.net.Api;
import com.tenghen.ireader.ui.activity.LatestReadActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：chengx
 * 时间：${Date}
 * 描述：
 */
public class LatestReadPresent extends BaseListPresent<LatestReadActivity> {
    @Override
    protected void requestData() {
        List<LatestBook> data = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            data.add(new LatestBook());
        }
        getV().refresh(data);
    }
}

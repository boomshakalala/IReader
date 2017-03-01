package com.tenghen.ireader.ui.present;

import com.tenghen.ireader.base.BaseListPresent;
import com.tenghen.ireader.module.Book;
import com.tenghen.ireader.ui.activity.RankActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：chengx
 * 日期：2017/2/28
 * 描述：
 */

public class RankPresent extends BaseListPresent<RankActivity> {
    @Override
    protected void requestData() {
        List<Book> data = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            data.add(new Book());
        }
        getV().refresh(data);
    }
}

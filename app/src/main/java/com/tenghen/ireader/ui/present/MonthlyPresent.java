package com.tenghen.ireader.ui.present;

import com.tenghen.ireader.adapter.ViewSupportModel;
import com.tenghen.ireader.base.BaseListPresent;
import com.tenghen.ireader.module.Book;
import com.tenghen.ireader.module.Divider;
import com.tenghen.ireader.module.Featured;
import com.tenghen.ireader.module.Label;
import com.tenghen.ireader.module.MonthlyHead;
import com.tenghen.ireader.module.MonthlyRankBook;
import com.tenghen.ireader.ui.activity.MonthlyActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：chengx
 * 日期：2017/3/1
 * 描述：
 */

public class MonthlyPresent extends BaseListPresent<MonthlyActivity> {
    @Override
    protected void requestData() {
        List<Object> data = new ArrayList<>();
        data.add(new ViewSupportModel(ViewSupportModel.VIEW_TYPE_SPLIT_SPACE));
        data.add(new MonthlyHead());
        data.add(new ViewSupportModel(ViewSupportModel.VIEW_TYPE_SPLIT_SPACE));
        Label label1 = new Label();
        label1.setText("热门推荐");
        data.add(label1);
        for (int i = 0; i < 3; i++) {
            data.add(new Book());
        }
        data.add(new ViewSupportModel(ViewSupportModel.VIEW_TYPE_SPLIT_SPACE));
        Label label2 = new Label();
        label2.setText("新书速递");
        data.add(label2);
        for (int i = 0; i < 3; i++) {
            data.add(new Featured());
            if (i != 2){
                data.add(new ViewSupportModel(ViewSupportModel.VIEW_TYPE_SPLIT_LINE));
            }
        }
        data.add(new ViewSupportModel(ViewSupportModel.VIEW_TYPE_SPLIT_SPACE));
        Label label3 = new Label();
        label3.setText("人气排行");
        data.add(label3);
        data.add(new Featured());
        for (int i = 0; i < 4; i++) {
            data.add(new MonthlyRankBook());
        }
        getV().refresh(data);


    }
}

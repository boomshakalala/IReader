package com.tenghen.ireader.ui.present;

import com.tenghen.ireader.R;
import com.tenghen.ireader.adapter.ViewSupportModel;
import com.tenghen.ireader.base.BaseListPresent;
import com.tenghen.ireader.module.Banner;
import com.tenghen.ireader.module.Book;
import com.tenghen.ireader.module.Featured;
import com.tenghen.ireader.module.Label;
import com.tenghen.ireader.ui.fragment.FeaturedFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：chengx
 * 日期：2017/2/23
 * 描述：
 */

public class FeaturedPresent extends BaseListPresent<FeaturedFragment> {

    @Override
    protected void requestData() {
        log("RequestData");
        List<Object> data = new ArrayList<>();
        data.add(new Banner());
        data.add(new ViewSupportModel(ViewSupportModel.VIEW_TYPE_SPLIT_SPACE));
        Label label1 = new Label();
        label1.setText("主编推荐");
        data.add(label1);
        for (int i = 0; i < 2; i++) {
            data.add(new Featured());
            if (i == 0)
                data.add(new ViewSupportModel(ViewSupportModel.VIEW_TYPE_SPLIT_LINE));
        }
        data.add(new ViewSupportModel(ViewSupportModel.VIEW_TYPE_SPLIT_SPACE));
        Label label2 = new Label();
        label2.setText("口碑畅销");
        data.add(label2);
        for (int i = 0; i < 6; i++) {
            data.add(new Book());
        }
        data.add(new ViewSupportModel(ViewSupportModel.VIEW_TYPE_SPLIT_SPACE));
        Label label3 = new Label();
        label3.setText("女王PK赛");
        data.add(label3);
        for (int i = 0; i < 6; i++) {
            data.add(new Book());
        }
        data.add(new ViewSupportModel(ViewSupportModel.VIEW_TYPE_SPLIT_SPACE));
        Label label4 = new Label();
        label4.setText("江山美人令");
        data.add(label4);
        for (int i = 0; i < 6; i++) {
            data.add(new Book());
        }
        data.add(new ViewSupportModel(ViewSupportModel.VIEW_TYPE_SPLIT_SPACE));
        Label label5 = new Label();
        label5.setText("月黑风高夜");
        data.add(label5);
        for (int i = 0; i < 6; i++) {
            data.add(new Book());
        }
        getV().refresh(data);
    }
}

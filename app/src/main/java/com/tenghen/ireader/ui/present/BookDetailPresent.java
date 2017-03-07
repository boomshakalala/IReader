package com.tenghen.ireader.ui.present;

import com.tenghen.ireader.adapter.BookDetailGiftLabelDelegate;
import com.tenghen.ireader.adapter.ViewSupportModel;
import com.tenghen.ireader.base.BaseListPresent;
import com.tenghen.ireader.module.BookDetailHeader;
import com.tenghen.ireader.module.Comment;
import com.tenghen.ireader.module.Gift;
import com.tenghen.ireader.module.GiftLog;
import com.tenghen.ireader.module.Label;
import com.tenghen.ireader.ui.activity.BookDetailActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：chengx
 * 日期：2017/3/7
 * 描述：
 */

public class BookDetailPresent extends BaseListPresent<BookDetailActivity> {
    @Override
    protected void requestData() {
        List<Object> data = new ArrayList<>();
        data.add(new BookDetailHeader());
        data.add(new ViewSupportModel(ViewSupportModel.VIEW_TYPE_SPLIT_SPACE));
        Label giftLabel = new Label();
        giftLabel.setCategory(Label.BOOK_DETAIL_GIFT);
        data.add(giftLabel);
        for (int i = 0; i < 6; i++) {
            data.add(new Gift());
        }
        Label giftLogLabel = new Label();
        giftLogLabel.setCategory(Label.BOOK_DETAIL_GIFT_LOG);
        data.add(giftLogLabel);
        for (int i = 0; i < 6; i++) {
            data.add(new GiftLog());
        }
        Label giftMoreLabel = new Label();
        giftMoreLabel.setCategory(Label.BOOK_DETAIL_MORE);
        data.add(giftMoreLabel);
        data.add(new ViewSupportModel(ViewSupportModel.VIEW_TYPE_SPLIT_SPACE));
        Label commentLabel = new Label();
        commentLabel.setCategory(Label.BOOK_DETAIL_COMMENT);
        data.add(commentLabel);
        for (int i = 0; i < 2; i++) {
            data.add(new Comment());
        }
        data.add(giftMoreLabel);
        getV().refresh(data);
    }
}

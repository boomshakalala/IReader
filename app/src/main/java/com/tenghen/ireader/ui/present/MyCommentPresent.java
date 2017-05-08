package com.tenghen.ireader.ui.present;

import com.tenghen.ireader.base.BaseListPresent;
import com.tenghen.ireader.module.Comment;
import com.tenghen.ireader.ui.activity.MyCommentActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：chengx
 * 时间：${Date}
 * 描述：
 */
public class MyCommentPresent extends BaseListPresent<MyCommentActivity> {
    @Override
    protected void requestData() {
        List<Comment> data = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            data.add(new Comment());
        }
        getV().refresh(data);
    }
}

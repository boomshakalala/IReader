package com.tenghen.ireader.module;

/**
 * 作者：chengx
 * 日期：2017/2/24
 * 描述：
 */

public class Label {
    public static final int BOOK_DETAIL_COMMENT = 1;
    public static final int BOOK_DETAIL_GIFT = 2;
    public static final int BOOK_DETAIL_MORE = 3;
    public static final int BOOK_DETAIL_GIFT_LOG = 4;

    private String text;
    private int endTime;
    private boolean needTimmer;
    private int category;

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public boolean isNeedTimmer() {
        return needTimmer;
    }

    public void setNeedTimmer(boolean needTimmer) {
        this.needTimmer = needTimmer;
    }
}

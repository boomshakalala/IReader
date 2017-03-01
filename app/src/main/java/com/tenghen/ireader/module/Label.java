package com.tenghen.ireader.module;

/**
 * 作者：chengx
 * 日期：2017/2/24
 * 描述：
 */

public class Label {
    private String text;
    private int endTime;
    private boolean needTimmer;

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

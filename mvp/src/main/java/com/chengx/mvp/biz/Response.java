package com.chengx.mvp.biz;

/**
 * 作者：chengx
 * 日期：2017/2/10
 * 描述：网络数据模型（根据具体业务调整）
 */

public class Response {
    int code;
    String info;

    public boolean isSuccess(){
        return code == 1;
    }
}

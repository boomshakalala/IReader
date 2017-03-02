package com.tenghen.ireader.net;

import com.chengx.mvp.net.HttpEngine;
import com.chengx.mvp.net.RequestParam;
import com.chengx.mvp.net.ResponseCallback;
import com.google.gson.reflect.TypeToken;
import com.tenghen.ireader.module.Book;

import java.lang.reflect.Type;
import java.util.List;

/**
 * 作者：chengx
 * 日期：2017/3/2
 * 描述：
 */

public class Api {
    public static final String HOST = "http://115.29.51.167:8888";

    public static final String BOOK_ALL_VIEW_BOOKS =  "/book/allviewbooks";

    public static void getAllViewBooks(ResponseCallback<List<Book>> callback){
        Type typeOfClass = new TypeToken<List<Book>>(){}.getType();
        HttpEngine.getInstance().post(HOST + BOOK_ALL_VIEW_BOOKS,new RequestParam(),typeOfClass,callback);
    }



}

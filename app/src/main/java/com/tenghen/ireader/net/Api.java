package com.tenghen.ireader.net;

import com.chengx.mvp.net.HttpEngine;
import com.chengx.mvp.net.RequestParam;
import com.chengx.mvp.net.ResponseCallback;
import com.google.gson.reflect.TypeToken;
import com.tenghen.ireader.module.Book;

import java.lang.reflect.Type;
import java.util.List;

import okhttp3.Request;

/**
 * 作者：chengx
 * 日期：2017/3/2
 * 描述：
 */

public class Api {
    public static final String HOST = "http://115.29.51.167:8888";

    public static final String BOOK_ALL_VIEW_BOOKS =  "/book/allviewbooks";
    public static final String BOOK_RANKING_LIST =  "/book/rankinglist";

    public static void getAllViewBooks(ResponseCallback<List<Book>> callback){
        Type typeOfClass = new TypeToken<List<Book>>(){}.getType();
        HttpEngine.getInstance().post(HOST + BOOK_ALL_VIEW_BOOKS,new RequestParam(),typeOfClass,callback);
    }

    public static void getRankingList(String ranking_id,String date_id,int p, ResponseCallback<List<Book>> callback){
        RequestParam param = new RequestParam();
        param.put("ranking_id",ranking_id);
        param.put("date_id",date_id);
        param.put("p",p);
        Type typeOfClass = new TypeToken<List<Book>>(){}.getType();
        HttpEngine.getInstance().post(HOST + BOOK_RANKING_LIST,param,typeOfClass,callback);
    }


}

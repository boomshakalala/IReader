package com.tenghen.ireader.net;

import com.chengx.mvp.net.HttpEngine;
import com.chengx.mvp.net.RequestParam;
import com.chengx.mvp.net.ResponseCallback;
import com.google.gson.reflect.TypeToken;
import com.tenghen.ireader.module.Book;
import com.tenghen.ireader.module.CategoryBook;
import com.tenghen.ireader.module.RankBook;

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
    public static final String BOOK_CATEGORY_BOOKS =  "/book/categorybooks";
    public static final String BOOK_SEARCH_BOOKS =  "/book/searchbooks";
    public static final String BOOK_BOOK_KEYWORDS =  "/book/bookkeywords";

    public static void getAllViewBooks(ResponseCallback<List<Book>> callback){
        Type typeOfClass = new TypeToken<List<Book>>(){}.getType();
        HttpEngine.getInstance().post(HOST + BOOK_ALL_VIEW_BOOKS,new RequestParam(),typeOfClass,callback);
    }

    public static void getRankingList(int ranking_id,int date_id,int p, ResponseCallback<List<RankBook>> callback){
        RequestParam param = new RequestParam();
        param.put("ranking_id",String.valueOf(ranking_id));
        param.put("date_id",String.valueOf(date_id));
        param.put("p",String.valueOf(p));
        Type typeOfClass = new TypeToken<List<RankBook>>(){}.getType();
        HttpEngine.getInstance().post(HOST + BOOK_RANKING_LIST,param,typeOfClass,callback);
    }

    public static void getCategoryBooks(int category_id,int cost,int rate,int sort,int p, ResponseCallback<List<CategoryBook>> callback){
        RequestParam param = new RequestParam();
        param.put("category_id",String.valueOf(category_id));
        param.put("cost",String.valueOf(cost));
        param.put("rate",String.valueOf(rate));
        param.put("sort",String.valueOf(sort));
        param.put("p",String.valueOf(p));
        Type typeOfClass = new TypeToken<List<CategoryBook>>(){}.getType();
        HttpEngine.getInstance().post(HOST + BOOK_CATEGORY_BOOKS,param,typeOfClass,callback);
    }

    public static void getSearchBooks(String keyword,int p, ResponseCallback<List<CategoryBook>> callback){
        RequestParam param = new RequestParam();
        param.put("keyword",keyword);
        param.put("p",String.valueOf(p));
        Type typeOfClass = new TypeToken<List<CategoryBook>>(){}.getType();
        HttpEngine.getInstance().post(HOST + BOOK_SEARCH_BOOKS,param,typeOfClass,callback);
    }

    public static void getBookKeywords(int p,ResponseCallback<List<String>> callback){
        RequestParam param = new RequestParam();
        param.put("p",String.valueOf(p));
        Type typeOfClass = new TypeToken<List<String>>(){}.getType();
        HttpEngine.getInstance().post(HOST + BOOK_BOOK_KEYWORDS,param,typeOfClass,callback);
    }


}

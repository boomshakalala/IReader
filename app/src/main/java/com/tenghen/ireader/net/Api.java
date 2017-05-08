package com.tenghen.ireader.net;

import com.chengx.mvp.net.HttpEngine;
import com.chengx.mvp.net.RequestParam;
import com.chengx.mvp.net.ResponseCallback;
import com.google.gson.reflect.TypeToken;
import com.tenghen.ireader.module.Book;
import com.tenghen.ireader.module.CategoryBook;
import com.tenghen.ireader.module.RankBook;
import com.chengx.mvp.net.WXApiResponse;
import com.tenghen.ireader.module.User;


import java.lang.reflect.Type;
import java.util.List;

/**
 * 作者：chengx
 * 日期：2017/3/2
 * 描述：
 */

public class Api {
    public static final String HOST = "http://115.29.51.167:8888";
    public static final String WX_HOST = "https://api.weixin.qq.com/sns/";

    /*======= 微信接口 =======*/
    public static final String WX_ACCESS_TOKEN = "oauth2/access_token";//通过code获取access_token
    public static final String WX_USER_INFO = "userinfo";//获取用户个人信息（UnionID机制）
    /*=======================*/

    public static final String BOOK_ALL_VIEW_BOOKS =  "/book/allviewbooks";
    public static final String BOOK_RANKING_LIST =  "/book/rankinglist";
    public static final String BOOK_CATEGORY_BOOKS =  "/book/categorybooks";
    public static final String BOOK_SEARCH_BOOKS =  "/book/searchbooks";
    public static final String BOOK_BOOK_KEYWORDS =  "/book/bookkeywords";
    public static final String USER_LOGIN = "/user/login";
    public static final String USER_REGISTER = "/user/register";


    public static void wxGetAccessToken(String appId, String secret, String code,ResponseCallback<WXApiResponse> callback) {
        RequestParam params = new RequestParam();
        params.put("appid",appId);
        params.put("secret",secret);
        params.put("code",code);
        params.put("grant_type","authorization_code");
        HttpEngine.getInstance().wxGet(WX_HOST + WX_ACCESS_TOKEN, params, callback);
    }

    public static void wxGetUserInfo(String accessToken, String openId, ResponseCallback<WXApiResponse> callback) {
        RequestParam params = new RequestParam();
        params.put("access_token",accessToken);
        params.put("openid",openId);
        HttpEngine.getInstance().wxGet(WX_HOST + WX_USER_INFO, params, callback);
    }

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
        param.put("keywords",keyword);
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

    public static void userLogin(int type,String email,String password,String authId,ResponseCallback<User> callback){
        RequestParam param = new RequestParam();
        param.put("type",String.valueOf(type));
        if (type == 1){
            param.put("email",email);
            param.put("password",password);
        }else {
            param.put("auth_id",authId);
        }
        HttpEngine.getInstance().post(HOST + USER_LOGIN,param, User.class,callback);
    }

    public static void userRegister(int type,String email,String password,String authId,String name,ResponseCallback<User> callback){
        RequestParam param = new RequestParam();
        param.put("type",String.valueOf(type));
        param.put("name",name);
        if (type == 1){
            param.put("email",email);
            param.put("password",password);
        }else {
            param.put("auth_id",authId);
        }
        HttpEngine.getInstance().post(HOST + USER_REGISTER,param, User.class,callback);
    }


}

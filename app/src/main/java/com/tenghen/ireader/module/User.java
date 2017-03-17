package com.tenghen.ireader.module;

import com.google.gson.annotations.SerializedName;

/**
 * 作者：chengx
 * 日期：2017/3/15
 * 描述：
 */

public class User {
    @SerializedName("user_id")
    String userId;
    String token;

    public String getUserId() {
        return userId;
    }

    public String getToken() {
        return token;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}

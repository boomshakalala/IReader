package com.tenghen.ireader.ui.present;

import com.chengx.mvp.net.ResponseCallback;
import com.tenghen.ireader.base.BaseListPresent;
import com.tenghen.ireader.base.BasePresent;
import com.tenghen.ireader.module.Book;
import com.tenghen.ireader.net.Api;
import com.tenghen.ireader.ui.fragment.SearchFragment;
import com.tenghen.ireader.ui.fragment.StacksFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：chengx
 * 日期：2017/2/23
 * 描述：
 */

public class SearchPresent extends BasePresent<SearchFragment> {
    public void requestData(){
        Api.getAllViewBooks(new ResponseCallback<List<Book>>() {
            @Override
            public void onSuccess(List<Book> data) {
                getV().setBooks(data);
            }

            @Override
            public void onFailure(int errCode, String info) {

            }
        });
    }

    public void requestHotWords(){
        List<String> tags = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            tags.add("网游");
        }
        for (int i = 0; i < 2; i++) {
            tags.add("都市");
        }
        tags.add("三生三世十里桃花");
        for (int i = 0; i < 4; i++) {
            tags.add("网游");
        }
        for (int i = 0; i < 2; i++) {
            tags.add("都市");
        }
        tags.add("太子妃");
        getV().setHotWords(tags);
    }
}

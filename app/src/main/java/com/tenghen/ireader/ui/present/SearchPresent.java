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
    int currentPage = 1;
    public void requestData(){
        Api.getAllViewBooks(new ResponseCallback<List<Book>>() {
            @Override
            public void onSuccess(List<Book> data) {
                getV().setBooks(data);
            }

            @Override
            public void onFailure(int errCode, String info) {
                getV().showTip(info);
            }
        });
    }

    public void requestHotWords() {
        Api.getBookKeywords(currentPage, new ResponseCallback<List<String>>() {
            @Override
            public void onSuccess(List<String> data) {
                getV().setHotWords(data);
            }

            @Override
            public void onFailure(int errCode, String info) {
                getV().showTip(info);
            }
        });
        currentPage++;
    }
}

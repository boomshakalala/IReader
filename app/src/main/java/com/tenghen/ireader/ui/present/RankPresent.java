package com.tenghen.ireader.ui.present;

import com.chengx.mvp.net.ResponseCallback;
import com.tenghen.ireader.base.BaseListPresent;
import com.tenghen.ireader.module.Book;
import com.tenghen.ireader.net.Api;
import com.tenghen.ireader.ui.activity.RankActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：chengx
 * 日期：2017/2/28
 * 描述：
 */

public class RankPresent extends BaseListPresent<RankActivity> {
    private String ranking_id;
    private String date_id;

    public String getRanking_id() {
        return ranking_id;
    }

    public void setRanking_id(String ranking_id) {
        this.ranking_id = ranking_id;
    }

    public String getDate_id() {
        return date_id;
    }

    public void setDate_id(String date_id) {
        this.date_id = date_id;
    }

    @Override
    protected void requestData() {
        Api.getRankingList(ranking_id, date_id, currentPage, new ResponseCallback<List<Book>>() {
            @Override
            public void onSuccess(List<Book> data) {
                if (data == null || data.isEmpty()){
                    if (currentPage == 1){
                        getV().showEmpty();
                    }else {
                        getV().closeLoadMore();
                    }
                }
                if (currentPage == 1){
                    getV().refresh(data);
                }else {
                    getV().loadMore(data);
                }
            }

            @Override
            public void onFailure(int errCode, String info) {
                getV().showError();
            }
        });
    }
}

package com.tenghen.ireader.ui.present;

import android.app.AlertDialog;
import android.content.DialogInterface;

import com.tenghen.ireader.base.BasePresent;
import com.tenghen.ireader.module.ChapterContent;
import com.tenghen.ireader.net.Api;
import com.tenghen.ireader.net.ResponseCallback;
import com.tenghen.ireader.ui.activity.LoginActivity;
import com.tenghen.ireader.ui.activity.ReadActivity;

public class ReadPresent extends BasePresent<ReadActivity> {

    public void getChapterContent(String bookId,String chapterId){
        getV().showProgress();
        Api.chapterChapterContent(bookId, chapterId, new ResponseCallback<ChapterContent>() {
            @Override
            public void onSuccess(ChapterContent data) {
                getV().dismissDialog();
                ChapterContent.User_status user_status = data.getUser_status();
                if (user_status != null) {
                    getV().showUserState(user_status);
                }

                ChapterContent.Msg msg = data.getMsg();
                if (msg != null) {
                    getV().showMsg(msg);
                }
                ChapterContent.Text text = data.getText();
                if (text != null) {
                    getV().showTextData(text);
                }
                ChapterContent.BookInfo bookInfo = data.getBook_info();
                if (bookInfo != null) {
                    getV().showBookInfo(bookInfo);
                }
                ChapterContent.ChapterInfo chapterInfo = data.getChapter_info();
                if (chapterInfo != null) {
                    getV().showChapterInfo(chapterInfo);
                }
            }

            @Override
            public void onFailure(int errCode, String info) {
                if (errCode == 9){
                    final AlertDialog dialog = new AlertDialog.Builder(getV()).create();
                    dialog.setTitle("提示");
                    dialog.setMessage("该章节为收费章节，请先登录");
                    dialog.setButton("去登陆", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialog.dismiss();
                            LoginActivity.launch(getV(),0);
                            getV().finish();
                        }
                    });
                    dialog.setCancelable(false);
                    dialog.show();
                }
                getV().dismissDialog();
                getV().showTip(info);
            }
        });
    }
}
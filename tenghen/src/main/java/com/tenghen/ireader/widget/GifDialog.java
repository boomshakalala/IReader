package com.tenghen.ireader.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.tenghen.ireader.R;

/**
 * Created by Administrator on 2018/2/4/004.
 */

public class GifDialog extends Dialog {
    String bookId;
    public GifDialog(@NonNull Context context) {
        super(context, R.style.ActionSheetDialogStyle);
        this.bookId = bookId;
    }

    public GifDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCancelable(true);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.dialog_gift, null);
        setContentView(inflate);
        //获取当前Activity所在的窗体
        Window dialogWindow = getWindow();
        //设置Dialog从窗体底部弹出
        WindowManager m = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        Display d = m.getDefaultDisplay(); // 获取屏幕宽、高用
        WindowManager.LayoutParams p = dialogWindow.getAttributes(); // 获取对话框当前的参数值
        p.height = WindowManager.LayoutParams.WRAP_CONTENT; // 高度设置为屏幕的0.6
        p.width = (int) (d.getWidth() * 0.8f); // 宽度设置为屏幕的0.65
        dialogWindow.setAttributes(p);
        dialogWindow.setGravity( Gravity.CENTER);
    }

}

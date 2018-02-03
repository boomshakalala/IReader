package com.tenghen.ireader.ui.activity;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.tenghen.ireader.R;
import com.tenghen.ireader.base.BaseActivity;
import com.tenghen.ireader.ui.present.ModifyPresent;

import butterknife.BindView;

public class ModifyPwdActivity extends BaseActivity<ModifyPresent> implements View.OnClickListener {

    @BindView(R.id.oldPwdEt)
    EditText oldPwdEt;
    @BindView(R.id.newPwdEt)
    EditText newPwdEt;
    @BindView(R.id.confirmPwdEt)
    EditText confirmPwdEt;
    @BindView(R.id.modifyBtn)
    EditText modifyBtn;

    @Override
    public void initToolBar() {
        toolbar.setTitle("修改密码");
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_modify_pwd;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initViews() {

    }

    @Override
    public void setListener() {
        modifyBtn.setOnClickListener(this);
    }

    @Override
    public ModifyPresent newPresent() {
        return new ModifyPresent();
    }

    @Override
    public void onClick(View v) {
        String oldPwd = oldPwdEt.getText().toString().trim();
        String newPwd = newPwdEt.getText().toString().trim();
        String confirmPwd = confirmPwdEt.getText().toString().trim();
        if (TextUtils.isEmpty(oldPwd)){
            showTip("请输入旧密码");
            return;
        }
        if (TextUtils.isEmpty(newPwd)){
            showTip("请输入新密码");
            return;
        }
        if (TextUtils.isEmpty(confirmPwd)){
            showTip("请确认新密码");
            return;
        }
        if (!newPwd.equals(confirmPwd)){
            showTip("两次密码不一致");
            return;
        }
        getPresent().modifyPwd(oldPwd,newPwd);
    }
}
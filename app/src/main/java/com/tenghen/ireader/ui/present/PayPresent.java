package com.tenghen.ireader.ui.present;

import com.chengx.mvp.net.ResponseCallback;
import com.tenghen.ireader.aliapi.Alipay;
import com.tenghen.ireader.base.BasePresent;
import com.tenghen.ireader.module.OrderInfo;
import com.tenghen.ireader.net.Api;
import com.tenghen.ireader.ui.activity.RechargeMoneyActivity;
import com.tenghen.ireader.wxapi.WXAPI;

public class PayPresent extends BasePresent<RechargeMoneyActivity> {

    public void pay(int money, final String payType){
        getV().showProgress();
        Api.orderRecharge(String.valueOf(money), payType, "1", "", new ResponseCallback<OrderInfo>() {
            @Override
            public void onSuccess(OrderInfo data) {
                String orderInfo = data.getResponse();
                switch (payType){
                    case "1":
                        Alipay.getInstance().pay(getV(),orderInfo);
                        break;
                    case "2":
//                        WXAPI.pay(getV(),,);
                        break;
                }
                getV().dismissDialog();
            }

            @Override
            public void onFailure(int errCode, String info) {
                getV().dismissDialog();
                getV().showTip(info);
            }
        });
    }

}
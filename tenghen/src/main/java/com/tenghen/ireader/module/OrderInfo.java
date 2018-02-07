package com.tenghen.ireader.module;

import java.io.Serializable;

public class OrderInfo  implements Serializable {

    String response = "";

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
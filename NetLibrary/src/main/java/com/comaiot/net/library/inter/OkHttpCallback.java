package com.comaiot.net.library.inter;

import org.json.JSONObject;


public interface OkHttpCallback {
    /**
     * 响应成功
     */
    void onSuccess(JSONObject oriData);


    /**
     * 响应失败
     */
    void onFailure(Exception e);
}

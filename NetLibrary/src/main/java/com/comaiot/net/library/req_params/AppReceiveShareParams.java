package com.comaiot.net.library.req_params;

public class AppReceiveShareParams {
    private String app_uid;
    private String app_envid;
    private String token;
    private String receive_type;
    private String share_num;
    private String share_token;

    public String getApp_uid() {
        return app_uid;
    }

    public void setApp_uid(String app_uid) {
        this.app_uid = app_uid;
    }

    public String getApp_envid() {
        return app_envid;
    }

    public void setApp_envid(String app_envid) {
        this.app_envid = app_envid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getReceive_type() {
        return receive_type;
    }

    public void setReceive_type(String receive_type) {
        this.receive_type = receive_type;
    }

    public String getShare_num() {
        return share_num;
    }

    public void setShare_num(String share_num) {
        this.share_num = share_num;
    }

    public String getShare_token() {
        return share_token;
    }

    public void setShare_token(String share_token) {
        this.share_token = share_token;
    }

    @Override
    public String toString() {
        return "AppReceiveShareParams{" +
                "app_uid='" + app_uid + '\'' +
                ", app_envid='" + app_envid + '\'' +
                ", token='" + token + '\'' +
                ", receive_type='" + receive_type + '\'' +
                ", share_num='" + share_num + '\'' +
                ", share_token='" + share_token + '\'' +
                '}';
    }
}

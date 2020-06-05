package com.comaiot.net.library.req_params;

public class AppQueryAidBindParams extends BaseJsonParams{
    private String app_uid;
    private String app_envid;
    private String app_aid;
    private String token;

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

    public String getApp_aid() {
        return app_aid;
    }

    public void setApp_aid(String app_aid) {
        this.app_aid = app_aid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "AppQueryAidBindParams{" +
                "app_uid='" + app_uid + '\'' +
                ", app_envid='" + app_envid + '\'' +
                ", app_aid='" + app_aid + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}

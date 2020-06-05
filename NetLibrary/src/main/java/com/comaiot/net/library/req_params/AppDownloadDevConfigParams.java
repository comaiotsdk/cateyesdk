package com.comaiot.net.library.req_params;

public class AppDownloadDevConfigParams {
    private String app_uid;
    private String app_envid;
    private String token;
    private String app_aid;
    private String dev_uid;

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

    public String getApp_aid() {
        return app_aid;
    }

    public void setApp_aid(String app_aid) {
        this.app_aid = app_aid;
    }

    public String getDev_uid() {
        return dev_uid;
    }

    public void setDev_uid(String dev_uid) {
        this.dev_uid = dev_uid;
    }

    @Override
    public String toString() {
        return "AppDownloadDevConfigParams{" +
                "app_uid='" + app_uid + '\'' +
                ", app_envid='" + app_envid + '\'' +
                ", token='" + token + '\'' +
                ", app_aid='" + app_aid + '\'' +
                ", dev_uid='" + dev_uid + '\'' +
                '}';
    }
}

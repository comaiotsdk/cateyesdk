package com.comaiot.net.library.req_params;

public class AppUploadConfigParams {
    private String app_uid;
    private String app_envid;
    private String token;
    private String config;

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

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    @Override
    public String toString() {
        return "AppUploadConfigParams{" +
                "app_uid='" + app_uid + '\'' +
                ", app_envid='" + app_envid + '\'' +
                ", token='" + token + '\'' +
                ", config='" + config + '\'' +
                '}';
    }
}

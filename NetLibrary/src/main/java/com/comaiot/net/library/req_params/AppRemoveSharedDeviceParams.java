package com.comaiot.net.library.req_params;

public class AppRemoveSharedDeviceParams {
    private String app_uid;
    private String app_envid;
    private String token;
    private String app_aid_remove;

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

    public String getApp_aid_remove() {
        return app_aid_remove;
    }

    public void setApp_aid_remove(String app_aid_remove) {
        this.app_aid_remove = app_aid_remove;
    }

    @Override
    public String toString() {
        return "AppRemoveSharedDeviceParams{" +
                "app_uid='" + app_uid + '\'' +
                ", app_envid='" + app_envid + '\'' +
                ", token='" + token + '\'' +
                ", app_aid_remove='" + app_aid_remove + '\'' +
                '}';
    }
}

package com.comaiot.net.library.req_params;

public class EmailTokenReqParams {
    private String app_uid;
    private String email;
    private String app_envid;

    public String getApp_uid() {
        return app_uid;
    }

    public void setApp_uid(String app_uid) {
        this.app_uid = app_uid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getApp_envid() {
        return app_envid;
    }

    public void setApp_envid(String app_envid) {
        this.app_envid = app_envid;
    }

    @Override
    public String toString() {
        return "EmailTokenReqParams{" +
                "app_uid='" + app_uid + '\'' +
                ", email='" + email + '\'' +
                ", app_envid='" + app_envid + '\'' +
                '}';
    }
}

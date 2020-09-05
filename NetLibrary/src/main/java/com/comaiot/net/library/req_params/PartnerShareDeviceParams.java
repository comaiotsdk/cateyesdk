package com.comaiot.net.library.req_params;

public class PartnerShareDeviceParams {
    private String app_uid;
    private String app_envid;
    private String token;
    private String dev_uid;
    private String phone_num;
    private String nickname;
    private String jwt_token;

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

    public String getDev_uid() {
        return dev_uid;
    }

    public void setDev_uid(String dev_uid) {
        this.dev_uid = dev_uid;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getJwt_token() {
        return jwt_token;
    }

    public void setJwt_token(String jwt_token) {
        this.jwt_token = jwt_token;
    }

    @Override
    public String toString() {
        return "PartnerShareDeviceParams{" +
                "app_uid='" + app_uid + '\'' +
                ", app_envid='" + app_envid + '\'' +
                ", token='" + token + '\'' +
                ", dev_uid='" + dev_uid + '\'' +
                ", phone_num='" + phone_num + '\'' +
                ", nickname='" + nickname + '\'' +
                ", jwt_token='" + jwt_token + '\'' +
                '}';
    }
}

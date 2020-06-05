package com.comaiot.net.library.req_params;

public class AppChangePhoneParams {
    private String app_uid;
    private String app_envid;
    private String token;
    private String old_phone_num;
    private String old_verify_code;
    private String new_phone_num;
    private String new_verify_code;

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

    public String getOld_phone_num() {
        return old_phone_num;
    }

    public void setOld_phone_num(String old_phone_num) {
        this.old_phone_num = old_phone_num;
    }

    public String getOld_verify_code() {
        return old_verify_code;
    }

    public void setOld_verify_code(String old_verify_code) {
        this.old_verify_code = old_verify_code;
    }

    public String getNew_phone_num() {
        return new_phone_num;
    }

    public void setNew_phone_num(String new_phone_num) {
        this.new_phone_num = new_phone_num;
    }

    public String getNew_verify_code() {
        return new_verify_code;
    }

    public void setNew_verify_code(String new_verify_code) {
        this.new_verify_code = new_verify_code;
    }

    @Override
    public String toString() {
        return "AppChangePhoneParams{" +
                "app_uid='" + app_uid + '\'' +
                ", app_envid='" + app_envid + '\'' +
                ", token='" + token + '\'' +
                ", old_phone_num='" + old_phone_num + '\'' +
                ", old_verify_code='" + old_verify_code + '\'' +
                ", new_phone_num='" + new_phone_num + '\'' +
                ", new_verify_code='" + new_verify_code + '\'' +
                '}';
    }
}

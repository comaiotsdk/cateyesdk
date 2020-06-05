package com.comaiot.net.library.req_params;

public class AppResetPasswordByPhoneParams {
    private String app_uid;
    private String app_envid;
    private String phone_num;
    private String verify_code;
    private String password;

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

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    public String getVerify_code() {
        return verify_code;
    }

    public void setVerify_code(String verify_code) {
        this.verify_code = verify_code;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AppResetPasswordByPhoneParams{" +
                "app_uid='" + app_uid + '\'' +
                ", app_envid='" + app_envid + '\'' +
                ", phone_num='" + phone_num + '\'' +
                ", verify_code='" + verify_code + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

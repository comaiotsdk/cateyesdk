package com.comaiot.net.library.req_params;

public class AppQueryAccountParams {
    private String app_uid;
    private String app_envid;
    private String subscribe_type;
    private String email;
    private String phone_num;
    private String weixin_code;
    private String weixin_type;

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

    public String getSubscribe_type() {
        return subscribe_type;
    }

    public void setSubscribe_type(String subscribe_type) {
        this.subscribe_type = subscribe_type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWeixin_code() {
        return weixin_code;
    }

    public void setWeixin_code(String weixin_code) {
        this.weixin_code = weixin_code;
    }

    public String getWeixin_type() {
        return weixin_type;
    }

    public void setWeixin_type(String weixin_type) {
        this.weixin_type = weixin_type;
    }

    @Override
    public String toString() {
        return "AppQueryAccountParams{" +
                "app_uid='" + app_uid + '\'' +
                ", app_envid='" + app_envid + '\'' +
                ", subscribe_type='" + subscribe_type + '\'' +
                ", email='" + email + '\'' +
                ", phone_num='" + phone_num + '\'' +
                ", weixin_code='" + weixin_code + '\'' +
                ", weixin_type='" + weixin_type + '\'' +
                '}';
    }
}

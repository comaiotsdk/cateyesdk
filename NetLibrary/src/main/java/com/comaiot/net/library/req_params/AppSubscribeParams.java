package com.comaiot.net.library.req_params;

public class AppSubscribeParams {
    private String app_uid;
    private String app_envid;
    private String subscribe_type;
    private String phone_num;
    private String verify_code;
    private String password;
    private String weixin_code;
    private String push_id;
    private String type;
    private String weixin_type;
    private String version;

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

    public String getSubscribe_type() {
        return subscribe_type;
    }

    public void setSubscribe_type(String subscribe_type) {
        this.subscribe_type = subscribe_type;
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

    public String getWeixin_code() {
        return weixin_code;
    }

    public void setWeixin_code(String weixin_code) {
        this.weixin_code = weixin_code;
    }

    public void setPush_id(String push_id) {
        this.push_id = push_id;
    }

    public String getPush_id() {
        return push_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getWeixin_type() {
        return weixin_type;
    }

    public void setWeixin_type(String weixin_type) {
        this.weixin_type = weixin_type;
    }

    @Override
    public String toString() {
        return "AppSubscribeParams{" +
                "app_uid='" + app_uid + '\'' +
                ", app_envid='" + app_envid + '\'' +
                ", subscribe_type='" + subscribe_type + '\'' +
                ", phone_num='" + phone_num + '\'' +
                ", verify_code='" + verify_code + '\'' +
                ", password='" + password + '\'' +
                ", weixin_code='" + weixin_code + '\'' +
                ", push_id='" + push_id + '\'' +
                ", type='" + type + '\'' +
                ", weixin_type='" + weixin_type + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}

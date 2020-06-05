package com.comaiot.net.library.req_params;

public class CatEyeLoginParams {
    private String appak;
    private long timestamp;
    private String nonce;
    private String sign;
    private String brand;
    private String type;
    private String jwt_token;
    private String app_uid;
    private String app_envid;

    public void setAppak(String appak) {
        this.appak = appak;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setJwt_token(String jwt_token) {
        this.jwt_token = jwt_token;
    }

    public void setApp_uid(String app_uid) {
        this.app_uid = app_uid;
    }

    public void setApp_envid(String app_envid) {
        this.app_envid = app_envid;
    }
}

package com.comaiot.net.library.req_params;

public class PartnerWeixinPushConfigParams {
    private String appak;
    private long timestamp;
    private String nonce;
    private String sign;
    private String weixin_accountid;
    private String weixin_openid;
    private String weixin_unionid;
    private String push_on_off;

    public String getAppak() {
        return appak;
    }

    public void setAppak(String appak) {
        this.appak = appak;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getWeixin_accountid() {
        return weixin_accountid;
    }

    public void setWeixin_accountid(String weixin_accountid) {
        this.weixin_accountid = weixin_accountid;
    }

    public String getWeixin_openid() {
        return weixin_openid;
    }

    public void setWeixin_openid(String weixin_openid) {
        this.weixin_openid = weixin_openid;
    }

    public String getWeixin_unionid() {
        return weixin_unionid;
    }

    public void setWeixin_unionid(String weixin_unionid) {
        this.weixin_unionid = weixin_unionid;
    }

    public String getPush_on_off() {
        return push_on_off;
    }

    public void setPush_on_off(String push_on_off) {
        this.push_on_off = push_on_off;
    }

    @Override
    public String toString() {
        return "PartnerWeixinPushConfigParams{" +
                "appak='" + appak + '\'' +
                ", timestamp=" + timestamp +
                ", nonce='" + nonce + '\'' +
                ", sign='" + sign + '\'' +
                ", weixin_accountid='" + weixin_accountid + '\'' +
                ", weixin_openid='" + weixin_openid + '\'' +
                ", weixin_unionid='" + weixin_unionid + '\'' +
                ", push_on_off='" + push_on_off + '\'' +
                '}';
    }
}

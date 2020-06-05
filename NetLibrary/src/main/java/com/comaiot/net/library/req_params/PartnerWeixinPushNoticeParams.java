package com.comaiot.net.library.req_params;

public class PartnerWeixinPushNoticeParams {
    private String appak;
    private long timestamp;
    private String nonce;
    private String sign;
    private String weixin_accountid;
    private String weixin_openid_list;
    private String content;

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

    public String getWeixin_openid_list() {
        return weixin_openid_list;
    }

    public void setWeixin_openid_list(String weixin_openid_list) {
        this.weixin_openid_list = weixin_openid_list;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "PartnerWeixinPushNoticeParams{" +
                "appak='" + appak + '\'' +
                ", timestamp=" + timestamp +
                ", nonce='" + nonce + '\'' +
                ", sign='" + sign + '\'' +
                ", weixin_accountid='" + weixin_accountid + '\'' +
                ", weixin_openid_list='" + weixin_openid_list + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}

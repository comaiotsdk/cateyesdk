package com.comaiot.net.library.req_params;

public class RegParams {
    private String appak;
    private long timestamp;
    private String nonce;
    private String sign;
    private String brand;
    private String type;
    private String country_code;

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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    @Override
    public String toString() {
        return "RegParams{" +
                "appak='" + appak + '\'' +
                ", timestamp=" + timestamp +
                ", nonce='" + nonce + '\'' +
                ", sign='" + sign + '\'' +
                ", brand='" + brand + '\'' +
                ", type='" + type + '\'' +
                ", country_code='" + country_code + '\'' +
                '}';
    }
}

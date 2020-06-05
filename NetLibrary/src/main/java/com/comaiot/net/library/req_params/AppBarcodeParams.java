package com.comaiot.net.library.req_params;

public class AppBarcodeParams {
    private String app_uid;
    private String app_envid;
    private String app_aid;
    private String token;
    private String country_code;
    private int time_zone;
    private String wifi_ssid;
    private String wifi_password;

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

    public String getApp_aid() {
        return app_aid;
    }

    public void setApp_aid(String app_aid) {
        this.app_aid = app_aid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getWifi_ssid() {
        return wifi_ssid;
    }

    public void setWifi_ssid(String wifi_ssid) {
        this.wifi_ssid = wifi_ssid;
    }

    public String getWifi_password() {
        return wifi_password;
    }

    public void setWifi_password(String wifi_password) {
        this.wifi_password = wifi_password;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public int getTime_zone() {
        return time_zone;
    }

    public void setTime_zone(int time_zone) {
        this.time_zone = time_zone;
    }

    @Override
    public String toString() {
        return "AppBarcodeParams{" +
                "app_uid='" + app_uid + '\'' +
                ", app_envid='" + app_envid + '\'' +
                ", app_aid='" + app_aid + '\'' +
                ", token='" + token + '\'' +
                ", country_code='" + country_code + '\'' +
                ", time_zone=" + time_zone +
                ", wifi_ssid='" + wifi_ssid + '\'' +
                ", wifi_password='" + wifi_password + '\'' +
                '}';
    }
}

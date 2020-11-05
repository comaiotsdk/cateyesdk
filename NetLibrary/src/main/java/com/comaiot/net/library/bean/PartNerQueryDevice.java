package com.comaiot.net.library.bean;

import java.io.Serializable;

public class PartNerQueryDevice implements Serializable {
    private String app_uid;
    private String app_aid;
    private String app_envid;
    private String dev_uid;
    private String bind_date;
    private String sn;
    private String online;
    private String deviceName;
    private int rssi;
    private String wifiName;
    private int battery;

    public String getApp_uid() {
        return app_uid;
    }

    public void setApp_uid(String app_uid) {
        this.app_uid = app_uid;
    }

    public String getApp_aid() {
        return app_aid;
    }

    public void setApp_aid(String app_aid) {
        this.app_aid = app_aid;
    }

    public String getApp_envid() {
        return app_envid;
    }

    public void setApp_envid(String app_envid) {
        this.app_envid = app_envid;
    }

    public String getDev_uid() {
        return dev_uid;
    }

    public void setDev_uid(String dev_uid) {
        this.dev_uid = dev_uid;
    }

    public String getBind_date() {
        return bind_date;
    }

    public void setBind_date(String bind_date) {
        this.bind_date = bind_date;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getOnline() {
        return online;
    }

    public void setOnline(String online) {
        this.online = online;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public int getRssi() {
        return rssi;
    }

    public void setRssi(int rssi) {
        this.rssi = rssi;
    }

    public String getWifiName() {
        return wifiName;
    }

    public void setWifiName(String wifiName) {
        this.wifiName = wifiName;
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    @Override
    public String toString() {
        return "PartNerQueryDevice{" +
                "app_uid='" + app_uid + '\'' +
                ", app_aid='" + app_aid + '\'' +
                ", app_envid='" + app_envid + '\'' +
                ", dev_uid='" + dev_uid + '\'' +
                ", bind_date='" + bind_date + '\'' +
                ", sn='" + sn + '\'' +
                ", online='" + online + '\'' +
                ", deviceName='" + deviceName + '\'' +
                ", rssi=" + rssi +
                ", wifiName='" + wifiName + '\'' +
                ", battery=" + battery +
                '}';
    }
}

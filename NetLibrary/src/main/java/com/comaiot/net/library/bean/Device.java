package com.comaiot.net.library.bean;

public class Device {
    private String app_uid;
    private String app_aid;
    private String app_envid;
    private String dev_uid;
    private long bind_date;

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

    public long getBind_date() {
        return bind_date;
    }

    public void setBind_date(long bind_date) {
        this.bind_date = bind_date;
    }

    @Override
    public String toString() {
        return "Device{" +
                "app_uid='" + app_uid + '\'' +
                ", app_aid='" + app_aid + '\'' +
                ", app_envid='" + app_envid + '\'' +
                ", dev_uid='" + dev_uid + '\'' +
                ", bind_date=" + bind_date +
                '}';
    }
}

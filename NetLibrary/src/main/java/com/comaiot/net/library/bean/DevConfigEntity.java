package com.comaiot.net.library.bean;

import java.io.Serializable;

public class DevConfigEntity implements Serializable {
    private String dev_uid;
    private String expire;
    private String upload_date;
    private String config;
    private String upload_token;

    public String getDev_uid() {
        return dev_uid;
    }

    public void setDev_uid(String dev_uid) {
        this.dev_uid = dev_uid;
    }

    public String getExpire() {
        return expire;
    }

    public void setExpire(String expire) {
        this.expire = expire;
    }

    public String getUpload_date() {
        return upload_date;
    }

    public void setUpload_date(String upload_date) {
        this.upload_date = upload_date;
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    public String getUpload_token() {
        return upload_token;
    }

    public void setUpload_token(String upload_token) {
        this.upload_token = upload_token;
    }

    @Override
    public String toString() {
        return "DevConfigEntity{" +
                "dev_uid='" + dev_uid + '\'' +
                ", expire='" + expire + '\'' +
                ", upload_date='" + upload_date + '\'' +
                ", config='" + config + '\'' +
                ", upload_token='" + upload_token + '\'' +
                '}';
    }
}

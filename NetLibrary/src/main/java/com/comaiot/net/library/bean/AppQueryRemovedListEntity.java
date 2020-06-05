package com.comaiot.net.library.bean;

import java.io.Serializable;

public class AppQueryRemovedListEntity implements Serializable {
    private String dev_uid;
    private long upload_date;

    public String getDev_uid() {
        return dev_uid;
    }

    public void setDev_uid(String dev_uid) {
        this.dev_uid = dev_uid;
    }

    public long getUpload_date() {
        return upload_date;
    }

    public void setUpload_date(long upload_date) {
        this.upload_date = upload_date;
    }

    @Override
    public String toString() {
        return "AppQueryRemovedListEntity{" +
                "dev_uid='" + dev_uid + '\'' +
                ", upload_date=" + upload_date +
                '}';
    }
}

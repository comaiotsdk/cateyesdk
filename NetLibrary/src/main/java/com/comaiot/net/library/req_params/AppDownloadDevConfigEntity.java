package com.comaiot.net.library.req_params;

import com.comaiot.net.library.bean.BaseAppEntity;
import com.comaiot.net.library.bean.DevConfigEntity;
import com.comaiot.net.library.bean.DeviceSvrCacheSettings;

import java.io.Serializable;
import java.util.List;

public class AppDownloadDevConfigEntity implements Serializable {
    private int errcode;
    private String errmsg;
    private List<Content> contents;

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public List<Content> getContents() {
        return contents;
    }

    public void setContents(List<Content> contents) {
        this.contents = contents;
    }

    @Override
    public String toString() {
        return "AppDownloadDevConfigEntity{" +
                "errcode=" + errcode +
                ", errmsg='" + errmsg + '\'' +
                ", contents=" + contents +
                '}';
    }

    public static class Content implements Serializable{
        private String dev_uid;
        private long upload_date;
        private String config;
        private DeviceSvrCacheSettings settings;

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

        public String getConfig() {
            return config;
        }

        public void setConfig(String config) {
            this.config = config;
        }

        public DeviceSvrCacheSettings getSettings() {
            return settings;
        }

        public void setSettings(DeviceSvrCacheSettings settings) {
            this.settings = settings;
        }

        @Override
        public String toString() {
            return "Content{" +
                    "dev_uid='" + dev_uid + '\'' +
                    ", upload_date=" + upload_date +
                    ", config='" + config + '\'' +
                    ", settings=" + settings +
                    '}';
        }
    }
}

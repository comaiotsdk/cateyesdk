package com.comaiot.net.library.bean;

import java.io.Serializable;
import java.util.List;

public class AppQueryDeviceListEntity extends BaseAppEntity {
    private Content content;

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public static class Content implements Serializable{
        private int bindNum;
        private List<DeviceEntity> bindList;

        public int getBindNum() {
            return bindNum;
        }

        public void setBindNum(int bindNum) {
            this.bindNum = bindNum;
        }

        public List<DeviceEntity> getBindList() {
            return bindList;
        }

        public void setBindList(List<DeviceEntity> bindList) {
            this.bindList = bindList;
        }

        @Override
        public String toString() {
            return "Content{" +
                    "bindNum=" + bindNum +
                    ", bindList=" + bindList +
                    '}';
        }
    }

    public static class BindDeviceData implements Serializable {
        private String sn;
        private String app_uid;
        private String app_aid;
        private String app_envid;
        private String dev_uid;
        private String bind_date;

        public String getSn() {
            return sn;
        }

        public void setSn(String sn) {
            this.sn = sn;
        }

        /**
         * @return APPID
         */
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

        @Override
        public String toString() {
            return "BindDeviceData{" +
                    "bindSn='" + sn + '\'' +
                    ", app_uid='" + app_uid + '\'' +
                    ", app_aid='" + app_aid + '\'' +
                    ", app_envid='" + app_envid + '\'' +
                    ", dev_uid='" + dev_uid + '\'' +
                    ", bind_date='" + bind_date + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "AppQueryDeviceListEntity{" +
                "content=" + content +
                '}';
    }
}

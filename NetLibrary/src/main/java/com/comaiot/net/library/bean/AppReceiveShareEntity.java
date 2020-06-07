package com.comaiot.net.library.bean;

import java.io.Serializable;

public class AppReceiveShareEntity implements Serializable {
    private int errcode;
    private String errmsg;
    private Content content;

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

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

    @Override
    public String toString() {
        return "AppReceiveShareEntity{" +
                "errcode=" + errcode +
                ", errmsg='" + errmsg + '\'' +
                ", content=" + content +
                '}';
    }

    public static class Content implements Serializable{
        private String dev_uid;
        private String aid;

        public String getDev_uid() {
            return dev_uid;
        }

        public void setDev_uid(String dev_uid) {
            this.dev_uid = dev_uid;
        }

        public String getAid() {
            return aid;
        }

        public void setAid(String aid) {
            this.aid = aid;
        }

        @Override
        public String toString() {
            return "Content{" +
                    "dev_uid='" + dev_uid + '\'' +
                    ", aid='" + aid + '\'' +
                    '}';
        }
    }
}

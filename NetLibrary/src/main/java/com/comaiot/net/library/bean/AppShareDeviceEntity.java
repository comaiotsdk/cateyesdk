package com.comaiot.net.library.bean;

import java.io.Serializable;

public class AppShareDeviceEntity implements Serializable {
    private int errcode;
    private String errmsg;
    private Content content;

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

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "AppShareDeviceEntity{" +
                "errcode=" + errcode +
                ", errmsg='" + errmsg + '\'' +
                ", content=" + content +
                '}';
    }

    public static class Content implements Serializable {
        private String share_token;
        private String share_num;

        public String getShare_token() {
            return share_token;
        }

        public void setShare_token(String share_token) {
            this.share_token = share_token;
        }

        public String getShare_num() {
            return share_num;
        }

        public void setShare_num(String share_num) {
            this.share_num = share_num;
        }

        @Override
        public String toString() {
            return "Content{" +
                    "share_token='" + share_token + '\'' +
                    ", share_num='" + share_num + '\'' +
                    '}';
        }
    }
}

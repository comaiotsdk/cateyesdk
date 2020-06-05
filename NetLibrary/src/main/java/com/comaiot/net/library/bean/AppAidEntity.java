package com.comaiot.net.library.bean;

import java.io.Serializable;

public class AppAidEntity implements Serializable {
    private Content content;
    private int errcode;
    private String errmsg;

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
        return "AppAidEntity{" +
                "content=" + content +
                ", errcode=" + errcode +
                ", errmsg='" + errmsg + '\'' +
                '}';
    }

    public static class Content implements Serializable{
        private String aid;

        public String getAid() {
            return aid;
        }

        public void setAid(String aid) {
            this.aid = aid;
        }

        @Override
        public String toString() {
            return "Content{" +
                    "aid='" + aid + '\'' +
                    '}';
        }
    }
}

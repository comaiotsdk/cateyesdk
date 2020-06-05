package com.comaiot.net.library.bean;

import java.io.Serializable;

public class AppQueryAidBindEntity implements Serializable {
    private Content content;
    private int errcode;
    private String errmsg;

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
        return "AppQueryAidBindEntity{" +
                "content=" + content +
                ", errcode=" + errcode +
                ", errmsg='" + errmsg + '\'' +
                '}';
    }

    public static class Content implements Serializable {
        private String status;
        private String dev_uid;

        public String getDev_uid() {
            return dev_uid;
        }

        public void setDev_uid(String dev_uid) {
            this.dev_uid = dev_uid;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        @Override
        public String toString() {
            return "Content{" +
                    "status='" + status + '\'' +
                    ", dev_uid='" + dev_uid + '\'' +
                    '}';
        }
    }

    public static final String NoRecord = "NoRecord";
    public static final String RecordWithoutDevUid = "RecordWithoutDevUid";
    public static final String RecordWithDevUid = "RecordWithDevUid";
    public static final String RecordBindBefore = "RecordBindBefore";
}

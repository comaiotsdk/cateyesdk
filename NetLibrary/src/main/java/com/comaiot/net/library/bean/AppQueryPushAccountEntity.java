package com.comaiot.net.library.bean;

import java.io.Serializable;
import java.util.Map;

public class AppQueryPushAccountEntity implements Serializable {
    private int errcode;
    private String errmsg;
    private Map<String, PushInfo> content;

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

    public Map<String, PushInfo> getContent() {
        return content;
    }

    public void setContent(Map<String, PushInfo> content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "AppQueryPushAccountEntity{" +
                "errcode=" + errcode +
                ", errmsg='" + errmsg + '\'' +
                ", content=" + content +
                '}';
    }

    public static class PushInfo implements Serializable {
        private String Android;

        public String getAndroid() {
            return Android;
        }

        public void setAndroid(String android) {
            Android = android;
        }

        @Override
        public String toString() {
            return "PushInfo{" +
                    "Android='" + Android + '\'' +
                    '}';
        }
    }
}

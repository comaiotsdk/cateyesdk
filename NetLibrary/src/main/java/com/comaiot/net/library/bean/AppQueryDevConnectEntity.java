package com.comaiot.net.library.bean;

import java.io.Serializable;

public class AppQueryDevConnectEntity implements Serializable {
    private int errcode;
    private String errmsg;
    private String content;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "AppQueryDevConnectEntity{" +
                "errcode=" + errcode +
                ", errmsg='" + errmsg + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}

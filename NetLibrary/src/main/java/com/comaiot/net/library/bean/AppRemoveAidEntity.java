package com.comaiot.net.library.bean;

import java.io.Serializable;
import java.util.Arrays;

public class AppRemoveAidEntity implements Serializable {
    private Content[] content;
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

    public Content[] getContent() {
        return content;
    }

    public void setContent(Content[] content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "AppRemoveAidEntity{" +
                "content=" + Arrays.toString(content) +
                ", errcode=" + errcode +
                ", errmsg='" + errmsg + '\'' +
                '}';
    }

    public static class Content implements Serializable{

    }
}

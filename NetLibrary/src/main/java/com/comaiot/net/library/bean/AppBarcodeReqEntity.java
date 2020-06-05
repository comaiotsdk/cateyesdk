package com.comaiot.net.library.bean;

import java.io.Serializable;

public class AppBarcodeReqEntity implements Serializable {
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
        return "AppBarcodeReqEntity{" +
                "content=" + content +
                ", errcode=" + errcode +
                ", errmsg='" + errmsg + '\'' +
                '}';
    }

    public static class Content implements Serializable{
        private String scan_token;

        public String getScan_token() {
            return scan_token;
        }

        public void setScan_token(String scan_token) {
            this.scan_token = scan_token;
        }

        @Override
        public String toString() {
            return "Content{" +
                    "scan_token='" + scan_token + '\'' +
                    '}';
        }
    }
}

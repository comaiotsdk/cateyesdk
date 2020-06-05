package com.comaiot.net.library.bean;

import java.io.Serializable;

public class BindPhoneEntity extends BaseAppEntity {
    private Content content;
    /*private int errcode;

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }*/

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "BindPhoneEntity{" +
                /*"errcode=" + errcode +*/
                "content=" + content +
                '}';
    }

    public static class Content implements Serializable {
        private String app_uid;

        public String getApp_uid() {
            return app_uid;
        }

        public void setApp_uid(String app_uid) {
            this.app_uid = app_uid;
        }

        @Override
        public String toString() {
            return "Content{" +
                    "app_uid='" + app_uid + '\'' +
                    '}';
        }
    }
}

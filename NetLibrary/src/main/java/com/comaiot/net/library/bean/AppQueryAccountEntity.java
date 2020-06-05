package com.comaiot.net.library.bean;

import java.io.Serializable;

public class AppQueryAccountEntity {
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
        return "BindPhoneEntity{" +
                "errcode=" + errcode +
                "errmsg=" + errmsg +
                "content=" + content +
                '}';
    }

    public static class Content implements Serializable {
        private String app_uid;
        private String app_envid;
        private String phone_num;
        private String weixin_unionid;
        private String password;

        public String getApp_uid() {
            return app_uid;
        }

        public void setApp_uid(String app_uid) {
            this.app_uid = app_uid;
        }

        public String getApp_envid() {
            return app_envid;
        }

        public void setApp_envid(String app_envid) {
            this.app_envid = app_envid;
        }

        public String getPhone_num() {
            return phone_num;
        }

        public void setPhone_num(String phone_num) {
            this.phone_num = phone_num;
        }

        public String getWeixin_unionid() {
            return weixin_unionid;
        }

        public void setWeixin_unionid(String weixin_unionid) {
            this.weixin_unionid = weixin_unionid;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        @Override
        public String toString() {
            return "Content{" +
                    "app_uid='" + app_uid + '\'' +
                    ", app_envid='" + app_envid + '\'' +
                    ", phone_num='" + phone_num + '\'' +
                    ", weixin_unionid='" + weixin_unionid + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }
    }
}

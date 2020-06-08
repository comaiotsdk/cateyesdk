package com.comaiot.net.library.bean;

import java.io.Serializable;

public class PartnerChangePhoneEntity implements Serializable {
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
        return "PartnerChangePhoneEntity{" +
                "errcode=" + errcode +
                ", errmsg='" + errmsg + '\'' +
                ", content=" + content +
                '}';
    }

    public static class Content implements Serializable {
        private String app_uid;
        private Account account;

        public String getApp_uid() {
            return app_uid;
        }

        public void setApp_uid(String app_uid) {
            this.app_uid = app_uid;
        }

        public Account getAccount() {
            return account;
        }

        public void setAccount(Account account) {
            this.account = account;
        }

        @Override
        public String toString() {
            return "Content{" +
                    "app_uid='" + app_uid + '\'' +
                    ", account=" + account +
                    '}';
        }
    }

    public static class Account implements Serializable{
        private String app_uid;
        private String phone_num;
        private String email;
        private String weixin_nickname;
        private String weixin_avatar;
        private String brand;
        private String type;
        private String nickname;
        private String avatar;

        public String getApp_uid() {
            return app_uid;
        }

        public void setApp_uid(String app_uid) {
            this.app_uid = app_uid;
        }

        public String getPhone_num() {
            return phone_num;
        }

        public void setPhone_num(String phone_num) {
            this.phone_num = phone_num;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getWeixin_nickname() {
            return weixin_nickname;
        }

        public void setWeixin_nickname(String weixin_nickname) {
            this.weixin_nickname = weixin_nickname;
        }

        public String getWeixin_avatar() {
            return weixin_avatar;
        }

        public void setWeixin_avatar(String weixin_avatar) {
            this.weixin_avatar = weixin_avatar;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        @Override
        public String toString() {
            return "Account{" +
                    "app_uid='" + app_uid + '\'' +
                    ", phone_num='" + phone_num + '\'' +
                    ", email='" + email + '\'' +
                    ", weixin_nickname='" + weixin_nickname + '\'' +
                    ", weixin_avatar='" + weixin_avatar + '\'' +
                    ", brand='" + brand + '\'' +
                    ", type='" + type + '\'' +
                    ", nickname='" + nickname + '\'' +
                    ", avatar='" + avatar + '\'' +
                    '}';
        }
    }
}

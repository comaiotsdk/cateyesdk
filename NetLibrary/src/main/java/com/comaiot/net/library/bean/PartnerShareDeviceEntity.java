package com.comaiot.net.library.bean;

import java.io.Serializable;

public class PartnerShareDeviceEntity extends BaseAppEntity {
    private Content content;

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "PartnerShareDeviceEntity{" +
                "content=" + content +
                '}';
    }

    public static class Content implements Serializable {
        private String app_uid;
        private String app_envid;
        private String token;
        private String dev_uid;
        private String phone_num;
        private String jwt_token;
        private String aid;

        public String getAid() {
            return aid;
        }

        public void setAid(String aid) {
            this.aid = aid;
        }

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

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getDev_uid() {
            return dev_uid;
        }

        public void setDev_uid(String dev_uid) {
            this.dev_uid = dev_uid;
        }

        public String getPhone_num() {
            return phone_num;
        }

        public void setPhone_num(String phone_num) {
            this.phone_num = phone_num;
        }

        public String getJwt_token() {
            return jwt_token;
        }

        public void setJwt_token(String jwt_token) {
            this.jwt_token = jwt_token;
        }

        @Override
        public String toString() {
            return "Content{" +
                    "app_uid='" + app_uid + '\'' +
                    ", app_envid='" + app_envid + '\'' +
                    ", token='" + token + '\'' +
                    ", dev_uid='" + dev_uid + '\'' +
                    ", phone_num='" + phone_num + '\'' +
                    ", jwt_token='" + jwt_token + '\'' +
                    ", aid='" + aid + '\'' +
                    '}';
        }

    }
}

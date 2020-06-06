package com.comaiot.net.library.bean;


import androidx.annotation.NonNull;

import java.io.Serializable;

@SuppressWarnings("all")
public class AppSubscribeEntity implements Serializable {
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
        return "AppSubscribeEntity{" +
                "content=" + content +
                ", errcode=" + errcode +
                ", errmsg='" + errmsg + '\'' +
                '}';
    }

    public static class Content implements Serializable {
        private String app_uid;
        private String app_envid;
        private String token;
        private String phone_num;
        private long expire;
        private Mqtt mqtt;

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

        public Mqtt getMqtt() {
            return mqtt;
        }

        public void setMqtt(Mqtt mqtt) {
            this.mqtt = mqtt;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public long getExpire() {
            return expire;
        }

        public void setExpire(long expire) {
            this.expire = expire;
        }

        @NonNull
        @Override
        public String toString() {
            return "Content{" +
                    "app_uid='" + app_uid + '\'' +
                    ", app_envid='" + app_envid + '\'' +
                    ", token='" + token + '\'' +
                    ", phone_num='" + phone_num + '\'' +
                    ", expire=" + expire +
                    ", mqtt=" + mqtt.toString() +
                    '}';
        }
    }

    public static class Mqtt implements Serializable {
        private String ip;
        private String port;
        private String user;
        private String pass;

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        public String getPort() {
            return port;
        }

        public void setPort(String port) {
            this.port = port;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public String getPass() {
            return pass;
        }

        public void setPass(String pass) {
            this.pass = pass;
        }

        @NonNull
        @Override
        public String toString() {
            return "Mqtt{" +
                    "ip='" + ip + '\'' +
                    ", port='" + port + '\'' +
                    ", user='" + user + '\'' +
                    ", pass='" + pass + '\'' +
                    '}';
        }
    }
}

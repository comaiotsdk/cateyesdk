package com.comaiot.net.library.bean;

import java.io.Serializable;

public class DevLoginEntity extends BaseAppEntity {
    private Content content;

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "DevLoginEntity{" +
                "content=" + content +
                '}';
    }

    public static class Content implements Serializable{
        private String token;
        private Mqtt mqtt;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public Mqtt getMqtt() {
            return mqtt;
        }

        public void setMqtt(Mqtt mqtt) {
            this.mqtt = mqtt;
        }

        @Override
        public String toString() {
            return "Content{" +
                    "token='" + token + '\'' +
                    ", mqtt=" + mqtt +
                    '}';
        }
    }

    public static class Mqtt implements Serializable{
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

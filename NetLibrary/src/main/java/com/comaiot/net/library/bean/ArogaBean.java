package com.comaiot.net.library.bean;


import java.io.Serializable;
import java.util.Arrays;

public class ArogaBean<T> implements Serializable {
    private boolean success;
    private T data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ArogaBean{" +
                "success=" + success +
                ", data=" + data +
                '}';
    }

    public static class Licenses implements Serializable{
        private String cert;

        public String getCert() {
            return cert;
        }

        public void setCert(String cert) {
            this.cert = cert;
        }

        @Override
        public String toString() {
            return "Licenses{" +
                    "cert='" + cert + '\'' +
                    '}';
        }
    }

    public static class Data implements Serializable{
        private boolean channel_exist;
        private int mode;
        private long[] broadcasters;
        private int total;
        private long[] users;
        private long[] audience;
        private int audience_total;

        public boolean isChannel_exist() {
            return channel_exist;
        }

        public void setChannel_exist(boolean channel_exist) {
            this.channel_exist = channel_exist;
        }

        public int getMode() {
            return mode;
        }

        public void setMode(int mode) {
            this.mode = mode;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public long[] getUsers() {
            return users;
        }

        public void setUsers(long[] users) {
            this.users = users;
        }

        public long[] getBroadcasters() {
            return broadcasters;
        }

        public void setBroadcasters(long[] broadcasters) {
            this.broadcasters = broadcasters;
        }

        public long[] getAudience() {
            return audience;
        }

        public void setAudience(long[] audience) {
            this.audience = audience;
        }

        public int getAudience_total() {
            return audience_total;
        }

        public void setAudience_total(int audience_total) {
            this.audience_total = audience_total;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "channel_exist=" + channel_exist +
                    ", mode=" + mode +
                    ", broadcasters=" + Arrays.toString(broadcasters) +
                    ", total=" + total +
                    ", users=" + Arrays.toString(users) +
                    ", audience=" + Arrays.toString(audience) +
                    ", audience_total=" + audience_total +
                    '}';
        }
    }
}

package com.comaiot.net.library.bean;

import java.io.Serializable;
import java.util.List;

public class AppDownloadConfigEntity implements Serializable {
    private AccountInfo accountInfo;
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

    public AccountInfo getAccount() {
        return accountInfo;
    }

    public void setAccount(AccountInfo content) {
        this.accountInfo = content;
    }

    @Override
    public String toString() {
        return "AppDownloadConfigEntity{" +
                "accountInfo=" + accountInfo +
                ", errcode=" + errcode +
                ", errmsg='" + errmsg + '\'' +
                '}';
    }

    public static class AccountInfo implements Serializable{
        private int num;
        private List<DeviceInfo> deviceInfos;
        private Account account;

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public List<DeviceInfo> getDeviceInfos() {
            return deviceInfos;
        }

        public void setDeviceInfos(List<DeviceInfo> deviceInfos) {
            this.deviceInfos = deviceInfos;
        }

        public Account getAccount() {
            return account;
        }

        public void setAccount(Account account) {
            this.account = account;
        }

        @Override
        public String toString() {
            return "AccountInfo{" +
                    "num=" + num +
                    ", deviceInfos=" + deviceInfos +
                    ", account=" + account +
                    '}';
        }
    }

    public static class Account implements Serializable{
        private String phone_num;
        private String email;
        private String weixin_nickname;
        private String weixin_avatar;
        private String brand;
        private String type;
        private String nickname;
        private String avatar;

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
                    "phone_num='" + phone_num + '\'' +
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

    public static class DeviceInfo implements Serializable{
        private String deviceNumber;
        private String app_uid;
        private String app_envid;
        private String upload_date;
        private String config;
        private String upload_token;

        public String getDeviceNumber() {
            return deviceNumber;
        }

        public void setDeviceNumber(String deviceNumber) {
            this.deviceNumber = deviceNumber;
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

        public String getUpload_date() {
            return upload_date;
        }

        public void setUpload_date(String upload_date) {
            this.upload_date = upload_date;
        }

        public String getConfig() {
            return config;
        }

        public void setConfig(String config) {
            this.config = config;
        }

        public String getUpload_token() {
            return upload_token;
        }

        public void setUpload_token(String upload_token) {
            this.upload_token = upload_token;
        }

        @Override
        public String toString() {
            return "DeviceInfo{" +
                    "deviceNumber='" + deviceNumber + '\'' +
                    ", appUid='" + app_uid + '\'' +
                    ", appEnvid='" + app_envid + '\'' +
                    ", upload_date='" + upload_date + '\'' +
                    ", config='" + config + '\'' +
                    ", upload_token='" + upload_token + '\'' +
                    '}';
        }
    }
}

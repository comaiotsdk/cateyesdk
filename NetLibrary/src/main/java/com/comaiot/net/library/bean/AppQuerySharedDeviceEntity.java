package com.comaiot.net.library.bean;

import java.io.Serializable;
import java.util.List;

public class AppQuerySharedDeviceEntity implements Serializable {
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
        return "AppQuerySharedDeviceEntity{" +
                "errcode=" + errcode +
                ", errmsg='" + errmsg + '\'' +
                ", content=" + content +
                '}';
    }

    public static class Content implements Serializable{
        private int num;
        private List<ShareUser> list;

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public List<ShareUser> getList() {
            return list;
        }

        public void setList(List<ShareUser> list) {
            this.list = list;
        }

        @Override
        public String toString() {
            return "Content{" +
                    "num=" + num +
                    ", list=" + list +
                    '}';
        }
    }

    public static class ShareUser implements Serializable{
        private String shareNumber;
        private String app_aid;
        private String dev_uid;
        private String app_uid;
        private long create_date;
        private String phone_num;
        private String email;
        private String weixin_openid;
        private String weixin_unionid;
        private String weixin_nickname;
        private String weixin_sex;
        private String weixin_city;
        private String weixin_province;
        private String weixin_country;
        private String weixin_avatar;
        private long update_date;
        private String avatar;
        private String brand;
        private String type;
        private String nickname;

        public String getShareNumber() {
            return shareNumber;
        }

        public void setShareNumber(String shareNumber) {
            this.shareNumber = shareNumber;
        }

        public String getApp_aid() {
            return app_aid;
        }

        public void setApp_aid(String app_aid) {
            this.app_aid = app_aid;
        }

        public String getDev_uid() {
            return dev_uid;
        }

        public void setDev_uid(String dev_uid) {
            this.dev_uid = dev_uid;
        }

        public String getApp_uid() {
            return app_uid;
        }

        public void setApp_uid(String app_uid) {
            this.app_uid = app_uid;
        }

        public long getCreate_date() {
            return create_date;
        }

        public void setCreate_date(long create_date) {
            this.create_date = create_date;
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

        public String getWeixin_openid() {
            return weixin_openid;
        }

        public void setWeixin_openid(String weixin_openid) {
            this.weixin_openid = weixin_openid;
        }

        public String getWeixin_unionid() {
            return weixin_unionid;
        }

        public void setWeixin_unionid(String weixin_unionid) {
            this.weixin_unionid = weixin_unionid;
        }

        public String getWeixin_nickname() {
            return weixin_nickname;
        }

        public void setWeixin_nickname(String weixin_nickname) {
            this.weixin_nickname = weixin_nickname;
        }

        public String getWeixin_sex() {
            return weixin_sex;
        }

        public void setWeixin_sex(String weixin_sex) {
            this.weixin_sex = weixin_sex;
        }

        public String getWeixin_city() {
            return weixin_city;
        }

        public void setWeixin_city(String weixin_city) {
            this.weixin_city = weixin_city;
        }

        public String getWeixin_province() {
            return weixin_province;
        }

        public void setWeixin_province(String weixin_province) {
            this.weixin_province = weixin_province;
        }

        public String getWeixin_country() {
            return weixin_country;
        }

        public void setWeixin_country(String weixin_country) {
            this.weixin_country = weixin_country;
        }

        public String getWeixin_avatar() {
            return weixin_avatar;
        }

        public void setWeixin_avatar(String weixin_avatar) {
            this.weixin_avatar = weixin_avatar;
        }

        public long getUpdate_date() {
            return update_date;
        }

        public void setUpdate_date(long update_date) {
            this.update_date = update_date;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
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

        @Override
        public String toString() {
            return "ShareUser{" +
                    "shareNumber='" + shareNumber + '\'' +
                    ", app_aid='" + app_aid + '\'' +
                    ", dev_uid='" + dev_uid + '\'' +
                    ", app_uid='" + app_uid + '\'' +
                    ", create_date=" + create_date +
                    ", phone_num='" + phone_num + '\'' +
                    ", email='" + email + '\'' +
                    ", weixin_openid='" + weixin_openid + '\'' +
                    ", weixin_unionid='" + weixin_unionid + '\'' +
                    ", weixin_nickname='" + weixin_nickname + '\'' +
                    ", weixin_sex='" + weixin_sex + '\'' +
                    ", weixin_city='" + weixin_city + '\'' +
                    ", weixin_province='" + weixin_province + '\'' +
                    ", weixin_country='" + weixin_country + '\'' +
                    ", weixin_avatar='" + weixin_avatar + '\'' +
                    ", update_date=" + update_date +
                    ", avatar='" + avatar + '\'' +
                    ", brand='" + brand + '\'' +
                    ", type='" + type + '\'' +
                    ", nickname='" + nickname + '\'' +
                    '}';
        }
    }
}

package com.comaiot.net.library.bean;

import java.io.Serializable;

public class AppReceiveShareNumEntity extends BaseAppEntity {
    private Content content;

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "AppReceiveShareEntity{" +
                "content=" + content +
                '}';
    }

    public static class Content implements Serializable{
        private String dev_uid;
        private String aid;

        public String getDev_uid() {
            return dev_uid;
        }

        public void setDev_uid(String dev_uid) {
            this.dev_uid = dev_uid;
        }

        public String getAid() {
            return aid;
        }

        public void setAid(String aid) {
            this.aid = aid;
        }

        @Override
        public String toString() {
            return "Content{" +
                    "dev_uid='" + dev_uid + '\'' +
                    ", aid='" + aid + '\'' +
                    '}';
        }
    }
}

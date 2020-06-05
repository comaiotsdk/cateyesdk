package com.comaiot.net.library.bean;

import java.io.Serializable;

public class StorageEntity extends BaseAppEntity {
    private Content content;

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "StorageEntity{" +
                "content=" + content +
                '}';
    }

    public static class Content implements Serializable{
        private String base_url;
        private String store_token;
        private String file_name;
        private String bucket;

        public String getBase_url() {
            return base_url;
        }

        public void setBase_url(String base_url) {
            this.base_url = base_url;
        }

        public String getStore_token() {
            return store_token;
        }

        public void setStore_token(String store_token) {
            this.store_token = store_token;
        }

        public String getFile_name() {
            return file_name;
        }

        public void setFile_name(String file_name) {
            this.file_name = file_name;
        }

        public String getBucket() {
            return bucket;
        }

        public void setBucket(String bucket) {
            this.bucket = bucket;
        }

        @Override
        public String toString() {
            return "Content{" +
                    "base_url='" + base_url + '\'' +
                    ", store_token='" + store_token + '\'' +
                    ", file_name='" + file_name + '\'' +
                    ", bucket='" + bucket + '\'' +
                    '}';
        }
    }
}

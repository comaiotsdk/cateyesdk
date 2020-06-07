package com.comaiot.net.library.bean;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class QueryCountryCodeEntity implements Serializable {
    private int errcode;
    private String errmsg;
    private Content content;

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

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

    @Override
    public String toString() {
        return "QueryCountryCodeEntity{" +
                "errcode=" + errcode +
                ", errmsg='" + errmsg + '\'' +
                ", content=" + content +
                '}';
    }

    public static class Content implements Serializable {
        private boolean updated;
        private CountryCode country_code;

        public boolean isUpdated() {
            return updated;
        }

        public void setUpdated(boolean updated) {
            this.updated = updated;
        }

        public CountryCode getCountry_code() {
            return country_code;
        }

        public void setCountry_code(CountryCode country_code) {
            this.country_code = country_code;
        }

        @Override
        public String toString() {
            return "Content{" +
                    "updated=" + updated +
                    ", country_code=" + country_code +
                    '}';
        }
    }

    public static class CountryCode implements Serializable {
        private String version;
        private long last_update;
        private String[] server_list;
        private List<Server> serverList;

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public long getLast_update() {
            return last_update;
        }

        public void setLast_update(long last_update) {
            this.last_update = last_update;
        }

        public String[] getServer_list() {
            return server_list;
        }

        public void setServer_list(String[] server_list) {
            this.server_list = server_list;
        }

        public List<Server> getServerList() {
            return serverList;
        }

        public void setServerList(List<Server> serverList) {
            this.serverList = serverList;
        }

        @Override
        public String toString() {
            return "CountryCode{" +
                    "version='" + version + '\'' +
                    ", last_update=" + last_update +
                    ", server_list=" + Arrays.toString(server_list) +
                    ", serverList=" + serverList +
                    '}';
        }
    }

    public static class Server implements Serializable{
        private String url_path;
        private String[] country_code;

        public String getUrl_path() {
            return url_path;
        }

        public void setUrl_path(String url_path) {
            this.url_path = url_path;
        }

        public String[] getCountry_code() {
            return country_code;
        }

        public void setCountry_code(String[] country_code) {
            this.country_code = country_code;
        }

        @Override
        public String toString() {
            return "Server{" +
                    "url_path='" + url_path + '\'' +
                    ", country_code=" + Arrays.toString(country_code) +
                    '}';
        }
    }
}

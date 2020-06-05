package com.comaiot.net.library.req_params;

import com.comaiot.net.library.bean.BaseAppEntity;
import com.comaiot.net.library.bean.DevConfigEntity;

import java.io.Serializable;
import java.util.List;

public class AppDownloadDevConfigEntity extends BaseAppEntity {
    private AppDownloadDevConfigEntity.Content content;

    public AppDownloadDevConfigEntity.Content getContent() {
        return content;
    }

    public void setContent(AppDownloadDevConfigEntity.Content content) {
        this.content = content;
    }

    public static class Content implements Serializable {
        private int bindNum;
        private List<DevConfigEntity> bindList;

        public int getBindNum() {
            return bindNum;
        }

        public void setBindNum(int bindNum) {
            this.bindNum = bindNum;
        }

        public List<DevConfigEntity> getBindList() {
            return bindList;
        }

        public void setBindList(List<DevConfigEntity> bindList) {
            this.bindList = bindList;
        }

        @Override
        public String toString() {
            return "Content{" +
                    "bindNum=" + bindNum +
                    ", bindList=" + bindList +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "AppDownloadDevConfigEntity{" +
                "content=" + content +
                '}';
    }
}

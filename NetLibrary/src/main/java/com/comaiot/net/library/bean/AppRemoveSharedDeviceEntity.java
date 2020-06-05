package com.comaiot.net.library.bean;

import java.io.Serializable;
import java.util.Arrays;

public class AppRemoveSharedDeviceEntity extends BaseAppEntity {
    private Content[] content;
    private String appUid;
    private String devUid;

    public Content[] getContent() {
        return content;
    }

    public void setContent(Content[] content) {
        this.content = content;
    }

    public String getAppUid() {
        return appUid;
    }

    public void setAppUid(String appUid) {
        this.appUid = appUid;
    }

    public String getDevUid() {
        return devUid;
    }

    public void setDevUid(String devUid) {
        this.devUid = devUid;
    }

    @Override
    public String toString() {
        return "AppRemoveSharedDeviceEntity{" +
                "content=" + Arrays.toString(content) +
                ", appUid='" + appUid + '\'' +
                ", devUid='" + devUid + '\'' +
                '}';
    }

    public static class Content implements Serializable{

    }
}

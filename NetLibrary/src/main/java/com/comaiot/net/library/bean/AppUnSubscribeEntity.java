package com.comaiot.net.library.bean;

import java.io.Serializable;
import java.util.Arrays;

public class AppUnSubscribeEntity extends BaseAppEntity {
    private Content[] content;

    public Content[] getContent() {
        return content;
    }

    public void setContent(Content[] content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "AppUnSubscribeEntity{" +
                "content=" + Arrays.toString(content) +
                '}';
    }

    public static class Content implements Serializable{

    }

    @Override
    public int getErrcode() {
        return super.getErrcode();
    }

    @Override
    public String getErrmsg() {
        return super.getErrmsg();
    }
}

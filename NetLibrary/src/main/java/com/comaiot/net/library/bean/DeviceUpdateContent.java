package com.comaiot.net.library.bean;

import java.io.Serializable;
import java.util.Arrays;

public class DeviceUpdateContent implements Serializable {
    private String country;
    private String content;
    private DeviceUpdateContent[] contents;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public DeviceUpdateContent[] getContents() {
        return contents;
    }

    public void setContents(DeviceUpdateContent[] contents) {
        this.contents = contents;
    }

    @Override
    public String toString() {
        return "DeviceUpdateContent{" +
                "country='" + country + '\'' +
                ", content='" + content + '\'' +
                ", contents=" + Arrays.toString(contents) +
                '}';
    }
}

package com.comaiot.net.library.bean;

import java.io.Serializable;
import java.util.List;

public class DeviceListEntity implements Serializable {
    private int errcode;
    private String errmsg;
    private List<Device> listEntities;

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

    public List<Device> getListEntities() {
        return listEntities;
    }

    public void setListEntities(List<Device> listEntities) {
        this.listEntities = listEntities;
    }

    @Override
    public String toString() {
        return "DeviceListEntity{" +
                "errcode=" + errcode +
                ", errmsg='" + errmsg + '\'' +
                ", listEntities=" + listEntities +
                '}';
    }
}

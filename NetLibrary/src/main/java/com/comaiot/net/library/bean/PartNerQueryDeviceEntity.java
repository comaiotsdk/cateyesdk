package com.comaiot.net.library.bean;

import java.io.Serializable;
import java.util.List;

public class PartNerQueryDeviceEntity implements Serializable {
    private int errcode;
    private String errmsg;
    private List<PartNerQueryDevice> listEntities;

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

    public List<PartNerQueryDevice> getListEntities() {
        return listEntities;
    }

    public void setListEntities(List<PartNerQueryDevice> listEntities) {
        this.listEntities = listEntities;
    }

    @Override
    public String toString() {
        return "PartNerQueryDeviceEntity{" +
                "errcode=" + errcode +
                ", errmsg='" + errmsg + '\'' +
                ", listEntities=" + listEntities +
                '}';
    }
}

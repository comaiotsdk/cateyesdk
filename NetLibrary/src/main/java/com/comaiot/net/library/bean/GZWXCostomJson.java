package com.comaiot.net.library.bean;

import java.io.Serializable;

public class GZWXCostomJson extends CustomJson implements Serializable {
    private String start_time;
    private String end_time;
    private String devUid;
    private String sn;
    private String model;
    private int status_flag;

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getDevUid() {
        return devUid;
    }

    public String getSn() {
        return sn;
    }

    public String getModel() {
        return model;
    }

    public int getStatus_flag() {
        return status_flag;
    }

    public void setStatus_flag(int status_flag) {
        this.status_flag = status_flag;
    }

    @Override
    public String toString() {
        return "GZWXCostomJson{" +
                "start_time='" + start_time + '\'' +
                ", end_time='" + end_time + '\'' +
                ", devUid='" + devUid + '\'' +
                ", sn='" + sn + '\'' +
                ", model='" + model + '\'' +
                ", status_flag=" + status_flag +
                '}';
    }
}

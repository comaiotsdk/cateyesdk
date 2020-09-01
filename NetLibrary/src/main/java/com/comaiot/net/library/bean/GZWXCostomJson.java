package com.comaiot.net.library.bean;

import java.io.Serializable;

public class GZWXCostomJson extends CustomJson implements Serializable {
    private String start_time;
    private String end_time;
    private String devUid;
    private String sn;
    private String model;
    private int switch_flag;

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

    public int getSwitch_flag() {
        return switch_flag;
    }

    public void setSwitch_flag(int switch_flag) {
        this.switch_flag = switch_flag;
    }

    @Override
    public String toString() {
        return "GZWXCostomJson{" +
                "start_time='" + start_time + '\'' +
                ", end_time='" + end_time + '\'' +
                ", devUid='" + devUid + '\'' +
                ", sn='" + sn + '\'' +
                ", model='" + model + '\'' +
                ", switch_flag=" + switch_flag +
                '}';
    }
}

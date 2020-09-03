package com.comaiot.net.library.bean;

import java.io.Serializable;

public class ConfigDeviceRegisterFaceNameInfo implements Serializable {
    private String cmd;
    private String faceName;
    private int other;
    private int status;

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public String getFaceName() {
        return faceName;
    }

    public void setFaceName(String faceName) {
        this.faceName = faceName;
    }

    public int getOther() {
        return other;
    }

    public void setOther(int other) {
        this.other = other;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ConfigDeviceRegisterFaceNameInfo{" +
                "cmd='" + cmd + '\'' +
                ", faceName='" + faceName + '\'' +
                ", other=" + other +
                ", status=" + status +
                '}';
    }
}

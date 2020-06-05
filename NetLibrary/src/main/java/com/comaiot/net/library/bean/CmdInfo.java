package com.comaiot.net.library.bean;

public class CmdInfo {
    private String cmd;
    private String clientId;
    private String devUid;
    private long createTime;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public String getDevUid() {
        return devUid;
    }

    public void setDevUid(String devUid) {
        this.devUid = devUid;
    }

    @Override
    public String toString() {
        return "CmdInfo{" +
                "cmd='" + cmd + '\'' +
                ", clientId='" + clientId + '\'' +
                ", devUid='" + devUid + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}

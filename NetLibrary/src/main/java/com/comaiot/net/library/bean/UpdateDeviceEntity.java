package com.comaiot.net.library.bean;

import java.io.Serializable;

public class UpdateDeviceEntity implements Serializable {
    private int updateStatus;       // 1-有新版本 0-无新版本
    private String newFirmVersionName;  //版本号
    private String newFirmVersionDate;  //版本发布时间
    private String newFirmVersionContent;   //版本更新内容
    private String downloadUrl;
    private String cmd;
    private String clientId;
    private String devUid;
    private long createTime;

    public int getUpdateStatus() {
        return updateStatus;
    }

    public void setUpdateStatus(int updateStatus) {
        this.updateStatus = updateStatus;
    }

    public String getNewFirmVersionName() {
        return newFirmVersionName;
    }

    public void setNewFirmVersionName(String newFirmVersionName) {
        this.newFirmVersionName = newFirmVersionName;
    }

    public String getNewFirmVersionDate() {
        return newFirmVersionDate;
    }

    public void setNewFirmVersionDate(String newFirmVersionDate) {
        this.newFirmVersionDate = newFirmVersionDate;
    }

    public String getNewFirmVersionContent() {
        return newFirmVersionContent;
    }

    public void setNewFirmVersionContent(String newFirmVersionContent) {
        this.newFirmVersionContent = newFirmVersionContent;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getDevUid() {
        return devUid;
    }

    public void setDevUid(String devUid) {
        this.devUid = devUid;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "UpdateDeviceEntity{" +
                "updateStatus=" + updateStatus +
                ", newFirmVersionName='" + newFirmVersionName + '\'' +
                ", newFirmVersionDate='" + newFirmVersionDate + '\'' +
                ", newFirmVersionContent='" + newFirmVersionContent + '\'' +
                ", downloadUrl='" + downloadUrl + '\'' +
                ", cmd='" + cmd + '\'' +
                ", clientId='" + clientId + '\'' +
                ", devUid='" + devUid + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}

package com.comaiot.net.library.bean;

import java.io.Serializable;

public class UpdateVersionInfo implements Serializable {
    private int updateState;            //1-开始下载 2-正在下载 3-下载失败 4-下载成功
    private String failMsg;             //下载失败的错误信息
    private long totalSize;             //总进度
    private long downloadSize;          //下载进度
    private String devUid;
    private String cmd;
    private long createTime;

    public int getUpdateState() {
        return updateState;
    }

    public void setUpdateState(int updateState) {
        this.updateState = updateState;
    }

    public String getFailMsg() {
        return failMsg;
    }

    public void setFailMsg(String failMsg) {
        this.failMsg = failMsg;
    }

    public long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(long totalSize) {
        this.totalSize = totalSize;
    }

    public long getDownloadSize() {
        return downloadSize;
    }

    public void setDownloadSize(long downloadSize) {
        this.downloadSize = downloadSize;
    }

    public String getDevUid() {
        return devUid;
    }

    public void setDevUid(String devUid) {
        this.devUid = devUid;
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

    @Override
    public String toString() {
        return "UpdateVersionInfo{" +
                "updateState=" + updateState +
                ", failMsg='" + failMsg + '\'' +
                ", totalSize=" + totalSize +
                ", downloadSize=" + downloadSize +
                ", devUid='" + devUid + '\'' +
                ", cmd='" + cmd + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}

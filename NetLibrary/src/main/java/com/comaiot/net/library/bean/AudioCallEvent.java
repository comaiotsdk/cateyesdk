package com.comaiot.net.library.bean;


import java.io.Serializable;

public class AudioCallEvent implements Serializable {
    private String cmd;
    private String devUid;
    private long createTime;
    private String join_id;
    private int audio_uid;

    public String getJoin_id() {
        return join_id;
    }

    public void setJoin_id(String join_id) {
        this.join_id = join_id;
    }

    public int getAudio_uid() {
        return audio_uid;
    }

    public void setAudio_uid(int audio_uid) {
        this.audio_uid = audio_uid;
    }

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
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
        return "AudioCallEvent{" +
                "cmd='" + cmd + '\'' +
                ", devUid='" + devUid + '\'' +
                ", createTime=" + createTime +
                ", join_id='" + join_id + '\'' +
                ", audio_uid=" + audio_uid +
                '}';
    }
}

package com.comaiot.net.library.bean;

public class DeviceVideoReady {
    private String cmd;
    private String join_id;
    private long video_uid;

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public String getJoin_id() {
        return join_id;
    }

    public void setJoin_id(String join_id) {
        this.join_id = join_id;
    }

    public long getVideo_uid() {
        return video_uid;
    }

    public void setVideo_uid(long video_uid) {
        this.video_uid = video_uid;
    }

    @Override
    public String toString() {
        return "DeviceVideoReady{" +
                "cmd='" + cmd + '\'' +
                ", join_id='" + join_id + '\'' +
                ", video_uid=" + video_uid +
                '}';
    }
}

package com.comaiot.net.library.bean;

import java.util.List;

public class AppQueryRemovedMessageEntity {
    private int errcode;
    private String errmsg;
    private int recordsLimit;
    private long timestamp_start;
    private long timestamp_end;
    private List<AppQueryRemovedListEntity> listEntities;

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

    public int getRecordsLimit() {
        return recordsLimit;
    }

    public void setRecordsLimit(int recordsLimit) {
        this.recordsLimit = recordsLimit;
    }

    public long getTimestamp_start() {
        return timestamp_start;
    }

    public void setTimestamp_start(long timestamp_start) {
        this.timestamp_start = timestamp_start;
    }

    public long getTimestamp_end() {
        return timestamp_end;
    }

    public void setTimestamp_end(long timestamp_end) {
        this.timestamp_end = timestamp_end;
    }

    public List<AppQueryRemovedListEntity> getListEntities() {
        return listEntities;
    }

    public void setListEntities(List<AppQueryRemovedListEntity> listEntities) {
        this.listEntities = listEntities;
    }

    @Override
    public String toString() {
        return "AppQueryRemovedMessageEntity{" +
                "errcode=" + errcode +
                ", errmsg='" + errmsg + '\'' +
                ", recordsLimit=" + recordsLimit +
                ", timestamp_start=" + timestamp_start +
                ", timestamp_end=" + timestamp_end +
                ", listEntities=" + listEntities +
                '}';
    }
}

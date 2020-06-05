package com.comaiot.net.library.bean;


import java.io.Serializable;

public class DeviceEntity implements Serializable {
    private AppQueryDeviceListEntity.BindDeviceData bindDeviceData;
    private GetDeviceStatusEntity statusEntity;
    private boolean isDeviceOnline = false;

    public GetDeviceStatusEntity getStatusEntity() {
        return statusEntity;
    }

    public void setStatusEntity(GetDeviceStatusEntity statusEntity) {
        this.statusEntity = statusEntity;
    }

    public AppQueryDeviceListEntity.BindDeviceData getBindDeviceData() {
        return bindDeviceData;
    }

    public void setBindDeviceData(AppQueryDeviceListEntity.BindDeviceData bindDeviceData) {
        this.bindDeviceData = bindDeviceData;
    }

    public boolean isDeviceOnline() {
        return isDeviceOnline;
    }

    public void setDeviceOnline(boolean deviceOnline) {
        isDeviceOnline = deviceOnline;
    }

    @Override
    public String toString() {
        return "DeviceEntity{" +
                "bindDeviceData=" + bindDeviceData +
                ", statusEntity=" + statusEntity +
                ", isDeviceOnline=" + isDeviceOnline +
                '}';
    }

}

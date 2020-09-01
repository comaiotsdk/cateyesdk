package com.comaiot.net.library.bean;

import java.io.Serializable;

public class SetDeviceSettingEntity implements Serializable {
    private String cmd;
    private String clientId;
    private String deviceNickName;
    private DeviceStatusChangeEntity.Ring ring;
    private DeviceSettings.Person_Check person_check;
    private int intelligentNight;
    private int callAlarmStatus;    //1-open;2-close
    private int doorbellLight;     //1-open;2-close
    private String customJsonContent;       //custom json content

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

    public String getDeviceNickName() {
        return deviceNickName;
    }

    public void setDeviceNickName(String deviceNickName) {
        this.deviceNickName = deviceNickName;
    }

    public int getIntelligentNight() {
        return intelligentNight;
    }

    public void setIntelligentNight(int intelligentNight) {
        this.intelligentNight = intelligentNight;
    }

    public int getCallAlarmStatus() {
        return callAlarmStatus;
    }

    public void setCallAlarmStatus(int callAlarmStatus) {
        this.callAlarmStatus = callAlarmStatus;
    }

    public int getDoorbellLight() {
        return doorbellLight;
    }

    public void setDoorbellLight(int doorbellLight) {
        this.doorbellLight = doorbellLight;
    }

    public String getCustomJsonContent() {
        return customJsonContent;
    }

    public void setCustomJsonContent(String customJsonContent) {
        this.customJsonContent = customJsonContent;
    }

    @Override
    public String toString() {
        return "SetDeviceSettingEntity{" +
                "cmd='" + cmd + '\'' +
                ", clientId='" + clientId + '\'' +
                ", deviceNickName='" + deviceNickName + '\'' +
                ", ring=" + ring +
                ", person_check=" + person_check +
                ", intelligentNight=" + intelligentNight +
                ", callAlarmStatus=" + callAlarmStatus +
                ", doorbellLight=" + doorbellLight +
                ", customJsonContent='" + customJsonContent + '\'' +
                '}';
    }

    public DeviceStatusChangeEntity.Ring getRing() {
        return ring;
    }

    public void setRing(DeviceStatusChangeEntity.Ring ring) {
        this.ring = ring;
    }

    public DeviceSettings.Person_Check getPerson_check() {
        return person_check;
    }

    public void setPerson_check(DeviceSettings.Person_Check person_check) {
        this.person_check = person_check;
    }

}

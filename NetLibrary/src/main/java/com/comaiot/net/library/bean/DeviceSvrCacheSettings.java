package com.comaiot.net.library.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class DeviceSvrCacheSettings implements Serializable {
    private DeviceStatus device_status;
    private FaceData faceData;
    private GZWXCostomJson customJsonContent;

    public DeviceStatus getDevice_status() {
        return device_status;
    }

    public void setDevice_status(DeviceStatus device_status) {
        this.device_status = device_status;
    }

    public FaceData getFaceData() {
        return faceData;
    }

    public void setFaceData(FaceData faceData) {
        this.faceData = faceData;
    }

    public GZWXCostomJson getCustomJsonContent() {
        return customJsonContent;
    }

    public void setCustomJsonContent(GZWXCostomJson customJsonContent) {
        this.customJsonContent = customJsonContent;
    }

    @Override
    public String toString() {
        return "DeviceSvrCacheSettings{" +
                "device_status=" + device_status +
                ", faceData=" + faceData +
                ", customJsonContent=" + customJsonContent +
                '}';
    }

    public static class DeviceStatus implements Serializable {
        private int alarm;
        private int battery;
        private int callAlarmStatus;
        private String deviceId;
        private DeviceInfo deviceInfo;
        private String deviceNickName;
        private int doorbellLight;
        private int intelligentNight;
        private int language;
        private int mode;
        private PersonCheck person_check;
        private int ring;
        private int ring_light;
        private int sound;
        private String wifi;
        private int wifi_rssi;

        public int getAlarm() {
            return alarm;
        }

        public void setAlarm(int alarm) {
            this.alarm = alarm;
        }

        public int getBattery() {
            return battery;
        }

        public void setBattery(int battery) {
            this.battery = battery;
        }

        public int getCallAlarmStatus() {
            return callAlarmStatus;
        }

        public void setCallAlarmStatus(int callAlarmStatus) {
            this.callAlarmStatus = callAlarmStatus;
        }

        public String getDeviceId() {
            return deviceId;
        }

        public void setDeviceId(String deviceId) {
            this.deviceId = deviceId;
        }

        public DeviceInfo getDeviceInfo() {
            return deviceInfo;
        }

        public void setDeviceInfo(DeviceInfo deviceInfo) {
            this.deviceInfo = deviceInfo;
        }

        public String getDeviceNickName() {
            return deviceNickName;
        }

        public void setDeviceNickName(String deviceNickName) {
            this.deviceNickName = deviceNickName;
        }

        public int getDoorbellLight() {
            return doorbellLight;
        }

        public void setDoorbellLight(int doorbellLight) {
            this.doorbellLight = doorbellLight;
        }

        public int getIntelligentNight() {
            return intelligentNight;
        }

        public void setIntelligentNight(int intelligentNight) {
            this.intelligentNight = intelligentNight;
        }

        public int getLanguage() {
            return language;
        }

        public void setLanguage(int language) {
            this.language = language;
        }

        public int getMode() {
            return mode;
        }

        public void setMode(int mode) {
            this.mode = mode;
        }

        public PersonCheck getPerson_check() {
            return person_check;
        }

        public void setPerson_check(PersonCheck person_check) {
            this.person_check = person_check;
        }

        public int getRing() {
            return ring;
        }

        public void setRing(int ring) {
            this.ring = ring;
        }

        public int getRing_light() {
            return ring_light;
        }

        public void setRing_light(int ring_light) {
            this.ring_light = ring_light;
        }

        public int getSound() {
            return sound;
        }

        public void setSound(int sound) {
            this.sound = sound;
        }

        public String getWifi() {
            return wifi;
        }

        public void setWifi(String wifi) {
            this.wifi = wifi;
        }

        public int getWifi_rssi() {
            return wifi_rssi;
        }

        public void setWifi_rssi(int wifi_rssi) {
            this.wifi_rssi = wifi_rssi;
        }

        @Override
        public String toString() {
            return "DeviceStatus{" +
                    "alarm=" + alarm +
                    ", battery=" + battery +
                    ", callAlarmStatus=" + callAlarmStatus +
                    ", deviceId='" + deviceId + '\'' +
                    ", deviceInfo=" + deviceInfo +
                    ", deviceNickName='" + deviceNickName + '\'' +
                    ", doorbellLight=" + doorbellLight +
                    ", intelligentNight=" + intelligentNight +
                    ", language=" + language +
                    ", mode=" + mode +
                    ", person_check=" + person_check +
                    ", ring=" + ring +
                    ", ring_light=" + ring_light +
                    ", sound=" + sound +
                    ", wifi='" + wifi + '\'' +
                    ", wifi_rssi=" + wifi_rssi +
                    '}';
        }
    }

    public static class DeviceInfo implements Serializable {
        private String bleMac;
        private String firm_version;
        private String model;
        private long total_stroage;
        private long use_stroage;
        private String version;
        private String version_info;

        public String getBleMac() {
            return bleMac;
        }

        public void setBleMac(String bleMac) {
            this.bleMac = bleMac;
        }

        public String getFirm_version() {
            return firm_version;
        }

        public void setFirm_version(String firm_version) {
            this.firm_version = firm_version;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public long getTotal_stroage() {
            return total_stroage;
        }

        public void setTotal_stroage(long total_stroage) {
            this.total_stroage = total_stroage;
        }

        public long getUse_stroage() {
            return use_stroage;
        }

        public void setUse_stroage(long use_stroage) {
            this.use_stroage = use_stroage;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getVersion_info() {
            return version_info;
        }

        public void setVersion_info(String version_info) {
            this.version_info = version_info;
        }

        @Override
        public String toString() {
            return "DeviceInfo{" +
                    "bleMac='" + bleMac + '\'' +
                    ", firm_version='" + firm_version + '\'' +
                    ", model='" + model + '\'' +
                    ", total_stroage=" + total_stroage +
                    ", use_stroage=" + use_stroage +
                    ", version='" + version + '\'' +
                    ", version_info='" + version_info + '\'' +
                    '}';
        }
    }

    public static class PersonCheck implements Serializable {
        private int alarm_mode;
        private int auto_pic;
        private int notification_duration;
        private int out_door_alarm;
        private int out_door_ring;
        private int out_door_sound;
        private int ring_light;
        private int sensitive;
        @SerializedName("switch")
        private int switchTag;
        private int tack_pic_num;

        public int getAlarm_mode() {
            return alarm_mode;
        }

        public void setAlarm_mode(int alarm_mode) {
            this.alarm_mode = alarm_mode;
        }

        public int getAuto_pic() {
            return auto_pic;
        }

        public void setAuto_pic(int auto_pic) {
            this.auto_pic = auto_pic;
        }

        public int getNotification_duration() {
            return notification_duration;
        }

        public void setNotification_duration(int notification_duration) {
            this.notification_duration = notification_duration;
        }

        public int getOut_door_alarm() {
            return out_door_alarm;
        }

        public void setOut_door_alarm(int out_door_alarm) {
            this.out_door_alarm = out_door_alarm;
        }

        public int getOut_door_ring() {
            return out_door_ring;
        }

        public void setOut_door_ring(int out_door_ring) {
            this.out_door_ring = out_door_ring;
        }

        public int getOut_door_sound() {
            return out_door_sound;
        }

        public void setOut_door_sound(int out_door_sound) {
            this.out_door_sound = out_door_sound;
        }

        public int getRing_light() {
            return ring_light;
        }

        public void setRing_light(int ring_light) {
            this.ring_light = ring_light;
        }

        public int getSensitive() {
            return sensitive;
        }

        public void setSensitive(int sensitive) {
            this.sensitive = sensitive;
        }

        public int getSwitchTag() {
            return switchTag;
        }

        public void setSwitchTag(int switchTag) {
            this.switchTag = switchTag;
        }

        public int getTack_pic_num() {
            return tack_pic_num;
        }

        public void setTack_pic_num(int tack_pic_num) {
            this.tack_pic_num = tack_pic_num;
        }

        @Override
        public String toString() {
            return "PersonCheck{" +
                    "alarm_mode=" + alarm_mode +
                    ", auto_pic=" + auto_pic +
                    ", notification_duration=" + notification_duration +
                    ", out_door_alarm=" + out_door_alarm +
                    ", out_door_ring=" + out_door_ring +
                    ", out_door_sound=" + out_door_sound +
                    ", ring_light=" + ring_light +
                    ", sensitive=" + sensitive +
                    ", switchTag=" + switchTag +
                    ", tack_pic_num=" + tack_pic_num +
                    '}';
        }
    }

    public static class FaceData implements Serializable{

    }
}

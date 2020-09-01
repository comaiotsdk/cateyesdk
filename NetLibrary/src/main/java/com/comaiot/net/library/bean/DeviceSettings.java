package com.comaiot.net.library.bean;

import com.comaiot.net.library.utils.Logger;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class DeviceSettings implements Serializable {
    private String cmd;
    private String deviceId;
    private int ring;
    private int sound;
    private int ring_light;
    private Person_Check person_check;
    private int alarm;
    private int language;
    private String wifi;
    private int mode;
    private int battery;
    private int wifi_rssi;
    private Device_Info deviceInfo;
    private String deviceNickName;
    private int intelligentNight;
    private int callAlarmStatus;        //1-open;2-close
    private int doorbellLight;          //1-open;2-close
    private String customJsonContent;       //custom json content

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Device_Info getDeviceInfo() {
        return deviceInfo;
    }

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public int getRing() {
        return ring;
    }

    public void setRing(int ring) {
        this.ring = ring;
    }

    public int getSound() {
        return sound;
    }

    public void setSound(int sound) {
        this.sound = sound;
    }

    public int getRing_light() {
        return ring_light;
    }

    public void setRing_light(int ring_light) {
        this.ring_light = ring_light;
    }

    public Person_Check getPerson_check() {
        return person_check;
    }

    public void setPerson_check(Person_Check person_check) {
        this.person_check = person_check;
    }

    public int getAlarm() {
        return alarm;
    }

    public int getLanguage() {
        return language;
    }

    public String getWifi() {
        return wifi;
    }

    public int getMode() {
        return mode;
    }

    public int getBattery() {
        return battery;
    }

    public int getWifi_rssi() {
        return wifi_rssi;
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
        return "DeviceSettings{" +
                "cmd='" + cmd + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", ring=" + ring +
                ", sound=" + sound +
                ", ring_light=" + ring_light +
                ", person_check=" + person_check +
                ", alarm=" + alarm +
                ", language=" + language +
                ", wifi='" + wifi + '\'' +
                ", mode=" + mode +
                ", battery=" + battery +
                ", wifi_rssi=" + wifi_rssi +
                ", deviceInfo=" + deviceInfo +
                ", deviceNickName='" + deviceNickName + '\'' +
                ", intelligentNight=" + intelligentNight +
                ", callAlarmStatus=" + callAlarmStatus +
                ", doorbellLight=" + doorbellLight +
                ", customJsonContent='" + customJsonContent + '\'' +
                '}';
    }

    public static class Person_Check implements Serializable {
        @SerializedName("switch")
        private int switch_check;
        private int auto_pic;
        private int ring_light;
        private int notification_duration;
        private int sensitive;
        private int alarm_mode;
        private int tack_pic_num;
        private int out_door_alarm;
        private int out_door_sound;
        private int out_door_ring;

        public int getSwitch_check() {
            return switch_check;
        }

        public void setRing_light_switch(int ring_light) {
            this.ring_light = ring_light;
        }

        public int getRing_light_switch() {
            return ring_light;
        }

        public void setOutside_alarm_switch(int outside_alarm) {
            this.out_door_alarm = outside_alarm;
        }

        public int geOutside_alarm_switch() {
            return out_door_alarm;
        }

        public void setSwitch_check(int switch_check) {
            this.switch_check = switch_check;
        }

        public int getAuto_pic() {
            return auto_pic;
        }

        public void setAuto_pic(int auto_pic) {
            this.auto_pic = auto_pic;
        }

        public int getSensitive() {
            return sensitive;
        }

        public void setSensitive(int sensitive) {
            this.sensitive = sensitive;
        }

        public int getAlarm_mode() {
            return alarm_mode;
        }

        public void setAlarm_mode(int alarm_mode) {
            this.alarm_mode = alarm_mode;
        }

        public int getTack_pic_num() {
            return tack_pic_num;
        }

        public void setTack_pic_num(int tack_pic_num) {
            this.tack_pic_num = tack_pic_num;
        }

        public int get_alarm_interval_num() {
            Logger.ee("GetDeviceStatusEntity Person_Check notification_duration:" + notification_duration);
            return notification_duration;
        }

        public void setAlarm_interval_num(int alarm_interval_num) {
            Logger.ee("GetDeviceStatusEntity Person_Check alarm_interval_num:" + alarm_interval_num);
            this.notification_duration = alarm_interval_num;
        }

        public int getOut_door_alarm() {
            return out_door_alarm;
        }

        public void setOut_door_alarm(int out_door_alarm) {
            this.out_door_alarm = out_door_alarm;
        }

        public int getOut_door_sound() {
            return out_door_sound;
        }

        public void setOut_door_sound(int out_door_sound) {
            this.out_door_sound = out_door_sound;
        }

        public int getOut_door_ring() {
            return out_door_ring;
        }

        public void setOut_door_ring(int out_door_ring) {
            this.out_door_ring = out_door_ring;
        }

        @Override
        public String toString() {
            return "Person_Check{" +
                    "switch_check=" + switch_check +
                    ", auto_pic=" + auto_pic +
                    ", ring_light=" + ring_light +
                    ", notification_duration=" + notification_duration +
                    ", sensitive=" + sensitive +
                    ", alarm_mode=" + alarm_mode +
                    ", tack_pic_num=" + tack_pic_num +
                    ", out_door_alarm=" + out_door_alarm +
                    ", out_door_sound=" + out_door_sound +
                    ", out_door_ring=" + out_door_ring +
                    '}';
        }
    }

    public static class Device_Info implements Serializable {
        private String version_info;
        private String firm_version;
        private String version;
        private String bleMac;
        private String macAddress;
        private String model;
        private long total_stroage;
        private long use_stroage;
        private String new_firm_version;
        private String new_firm_download;

        public String getVersion_info() {
            return version_info;
        }

        public String getFirm_version() {
            return firm_version;
        }

        public String getModel() {
            return model;
        }

        public String getVersion() {
            return version;
        }

        public String getBleMac() {
            return bleMac;
        }

        public long getTotal_stroage() {
            return total_stroage;
        }

        public long getUse_stroage() {
            return use_stroage;
        }

        public String getNew_firm_version() {
            return new_firm_version;
        }

        public String getNew_firm_download() {
            return new_firm_download;
        }

        public String getMacAddress() {
            return macAddress;
        }

        @Override
        public String toString() {
            return "Device_Info{" +
                    "version_info='" + version_info + '\'' +
                    ", firm_version='" + firm_version + '\'' +
                    ", version='" + version + '\'' +
                    ", bleMac='" + bleMac + '\'' +
                    ", macAddress='" + macAddress + '\'' +
                    ", model='" + model + '\'' +
                    ", total_stroage=" + total_stroage +
                    ", use_stroage=" + use_stroage +
                    ", new_firm_version='" + new_firm_version + '\'' +
                    ", new_firm_download='" + new_firm_download + '\'' +
                    '}';
        }
    }
}

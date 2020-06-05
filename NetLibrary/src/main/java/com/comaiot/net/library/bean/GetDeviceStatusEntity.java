package com.comaiot.net.library.bean;

import com.comaiot.net.library.utils.Logger;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


/**
 * "{
 * ""cmd"": ""get_device_status"",
 * ""deviceId"": 54321,                     //deviceId
 * ""ring"": 0,                             //铃声          0/1/2/3    分别代表内置的四种铃声模式（传统，鸟叫，音乐，人声）
 * ""sound"": 1,                            //音量          0/1/2      低/中/高
 * ""deviceNickName"":""悟空 Touch Pro"",
 * ""ring_light"": 1,                       //门铃灯        0/1        关/开
 * ""person_check"": {
 * ""switch"": 1,                       //人体检测开关   0/1        关/开
 * ""auto_pic"": ""15秒"",                //自动抓拍时间
 * ""sensitive"": 1,                    //灵敏度         0/1       低/高
 * ""alarm_mode"": 1,                   //报警模式       0/1          拍照/录像
 * ""tack_pic_num"": 3,                 //连拍张数       3/5/7        3张/5张/7张
 * ""out_door_alarm"": 1,               //门外声音报警   0/1          关/开
 * ""out_door_sound"": 1,               //报警音量       0/1/2        高/中/低
 * ""out_door_ring"": 0,                //门外铃声       0/1/2/3      分别代表四种铃声模式（人声，狗叫，雷达，自定义）
 * ""out_door_duration"": ""10秒""        //门外停留时间
 * },
 * ""alarm"": 1,                            //拆机报警开关   0/1        关/开
 * ""language"": 1,                         //语言           0/1        英文/中文
 * ""wifi"": ""comaiot_2.4g"",                //wifi名称
 * ""mode"": 1,                             //模式           0/1        省电模式/普通模式
 * ""battery"": 97,                         //电量
 * ""wifi_rssi"": -66,                      //wifi信号
 * ""deviceInfo"": {
 * ""version_info"": ""1.0.0.0"",         //版本信息
 * ""firm_version"": ""1.0.0.1"",         //固件信息
 * ""version"": ""1.0.0.0"",              //硬件版本号
 * ""total_stroage"": 63723855872,      //设备总容量
 * ""use_stroage"": 21188509696,        //已用容量
 * ""new_firm_version"": ""1.0.0.2"",     //新固件版本，没有则为空
 * ""new_firm_download"": ""http://www.baidu.com""  //最新固件下载地址，没有则为空
 * }
 * }"
 */
public class GetDeviceStatusEntity implements Serializable {
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
    private int callAlarmStatus;
    private int doorbellLight;          //1-open;2-close

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Device_Info getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(Device_Info deviceInfo) {
        this.deviceInfo = deviceInfo;
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

    public void setAlarm(int alarm) {
        this.alarm = alarm;
    }

    public int getLanguage() {
        return language;
    }

    public void setLanguage(int language) {
        this.language = language;
    }

    public String getWifi() {
        return wifi;
    }

    public void setWifi(String wifi) {
        this.wifi = wifi;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    public int getWifi_rssi() {
        return wifi_rssi;
    }

    public void setWifi_rssi(int wifi_rssi) {
        this.wifi_rssi = wifi_rssi;
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

    @Override
    public String toString() {
        return "GetDeviceStatusEntity{" +
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
        private String out_door_duration;

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

        public String getOut_door_duration() {
            return out_door_duration;
        }

        public void setOut_door_duration(String out_door_duration) {
            this.out_door_duration = out_door_duration;
        }

        @Override
        public String toString() {
            return "Person_Check{" +
                    "switch_check=" + switch_check +
                    ", auto_pic='" + auto_pic + '\'' +
                    ", sensitive=" + sensitive +
                    ", alarm_mode=" + alarm_mode +
                    ", tack_pic_num=" + tack_pic_num +
                    ", out_door_alarm=" + out_door_alarm +
                    ", out_door_sound=" + out_door_sound +
                    ", out_door_ring=" + out_door_ring +
                    ", out_door_duration='" + out_door_duration + '\'' +
                    ", alarm_interval_num='" + notification_duration + '\'' +
                    ", ring_light='" + ring_light + '\'' +
                    ", outside_alarm='" + out_door_alarm + '\'' +
                    '}';
        }
    }

    public static class Device_Info implements Serializable {
        private String version_info;
        private String firm_version;
        private String version;
        private long total_stroage;
        private long use_stroage;
        private String new_firm_version;
        private String new_firm_download;
        private String model;

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getVersion_info() {
            return version_info;
        }

        public void setVersion_info(String version_info) {
            this.version_info = version_info;
        }

        public String getFirm_version() {
            return firm_version;
        }

        public void setFirm_version(String firm_version) {
            this.firm_version = firm_version;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
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

        public String getNew_firm_version() {
            return new_firm_version;
        }

        public void setNew_firm_version(String new_firm_version) {
            this.new_firm_version = new_firm_version;
        }

        public String getNew_firm_download() {
            return new_firm_download;
        }

        public void setNew_firm_download(String new_firm_download) {
            this.new_firm_download = new_firm_download;
        }

        @Override
        public String toString() {
            return "Device_Info{" +
                    "version_info='" + version_info + '\'' +
                    ", firm_version='" + firm_version + '\'' +
                    ", version='" + version + '\'' +
                    ", total_stroage=" + total_stroage +
                    ", use_stroage=" + use_stroage +
                    ", new_firm_version='" + new_firm_version + '\'' +
                    ", new_firm_download='" + new_firm_download + '\'' +
                    ", model='" + model + '\'' +
                    '}';
        }
    }
}

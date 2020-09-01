package com.comaiot.net.library.bean;


import java.io.Serializable;

/**
 * "{
 * ""cmd"": ""device_status_changed"",         //以下字段上报通知，检查为空(NULL)，如果为空(NULL)视为未发生变化，不为空(NULL)视为发生改变
 * ""wifi"": {
 * ""ssid"": ""comaiot_2.4g"",             //wifi名称
 * ""wifi_rssi"": -63                    //wifi信号强度
 * },
 * ""ring"": {
 * ""index"": 1                        //铃声         0/1/2/3  分别代表内置的四种铃声模式（传统，鸟叫，音乐，人声）
 * },
 * ""battery"": {
 * ""device_battery"": 85,               //设备电量
 * ""battery_low"":true,                 //低电量报警   true/false
 * ""device"":1                          //预留字段 区分判断后期加入进来外设（烟感水感等等...）
 * },
 * ""device_status"":{
 * ""deviceId"": 54321,                     //deviceId
 * ""ring"": 0,                             //铃声          0/1/2/3    分别代表内置的四种铃声模式（传统，鸟叫，音乐，人声）
 * ""sound"": 1,                            //音量          0/1/2      低/中/高
 * ""ring_light"": 1,                       //门铃灯        0/1        关/开
 * ""person_check"": {
 * ""switch"": 1,                       //人体检测开关   0/1        关/开
 * ""auto_pic"": ""15秒"",                //自动抓拍时间
 * ""sensitive"": 1,                    //灵敏度         0/1          低/高
 * ""alarm_mode"": 1,                   //报警模式       0/1          拍照/录像
 * ""tack_pic_num"": 3,                 //连拍张数       3/5/7        3张/5张/7张
 * ""out_door_alarm"": 1,               //门外声音报警   0/1          关/开
 * ""out_door_sound"": 1,               //报警音量       0/1/2        高/中/低
 * ""out_door_ring"": 0,                //门外铃声       0/1/2/3      分别代表四种铃声模式（人声，狗叫，雷达，自定义）
 * ""notification_duration"":60         //报警间隔时间
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
 * }
 * }"
 */
public class DeviceStatusChangeEntity implements Serializable {
    private String cmd;
    private DeviceSettings device_status;
    private GZWXCostomJson customJsonContent;

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public DeviceSettings getDevice_status() {
        return device_status;
    }

    public void setDevice_status(DeviceSettings device_status) {
        this.device_status = device_status;
    }

    public GZWXCostomJson getCustomJsonContent() {
        return customJsonContent;
    }

    public void setCustomJsonContent(GZWXCostomJson customJsonContent) {
        this.customJsonContent = customJsonContent;
    }

    @Override
    public String toString() {
        return "DeviceStatusChangeEntity{" +
                "cmd='" + cmd + '\'' +
                ", device_status=" + device_status +
                ", customJsonContent=" + customJsonContent +
                '}';
    }

    public static class Wifi implements Serializable {
        private String ssid;
        private int wifi_rssi;

        public String getSsid() {
            return ssid;
        }

        public void setSsid(String ssid) {
            this.ssid = ssid;
        }

        public int getWifi_rssi() {
            return wifi_rssi;
        }

        public void setWifi_rssi(int wifi_rssi) {
            this.wifi_rssi = wifi_rssi;
        }

        @Override
        public String toString() {
            return "Wifi{" +
                    "ssid='" + ssid + '\'' +
                    ", wifi_rssi=" + wifi_rssi +
                    '}';
        }
    }

    public static class Ring implements Serializable {
        private int index;
        private int ringVolume;

        public Ring() {
        }

        public int getIndex() {
            return this.index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public int getSound() {
            return this.ringVolume;
        }

        public void setSound(int ringVolume) {
            this.ringVolume = ringVolume;
        }

        public String toString() {
            return "Ring{index=" + this.index + ", ringVolume=" + this.ringVolume + '}';
        }
    }

    public static class Battery implements Serializable {
        private int device_battery;
        private boolean battery_low;
        private int device;
        private String deviceId;

        public String getDeviceId() {
            return deviceId;
        }

        public void setDeviceId(String deviceId) {
            this.deviceId = deviceId;
        }

        public int getDevice_battery() {
            return device_battery;
        }

        public void setDevice_battery(int device_battery) {
            this.device_battery = device_battery;
        }

        public boolean isBattery_low() {
            return battery_low;
        }

        public void setBattery_low(boolean battery_low) {
            this.battery_low = battery_low;
        }

        public int getDevice() {
            return device;
        }

        public void setDevice(int device) {
            this.device = device;
        }

        @Override
        public String toString() {
            return "Battery{" +
                    "device_battery=" + device_battery +
                    ", battery_low=" + battery_low +
                    ", device=" + device +
                    ", deviceId='" + deviceId + '\'' +
                    '}';
        }
    }
}

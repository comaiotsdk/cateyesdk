package com.comaiot.net.library.core;

import android.util.Log;

public class MqttUtils {
    public static final int QOS = 2;

    public static final String GET_DEVICE_STATUS = "get_device_status";
    public static final String QUERY_ONLINE = "queryOnline";
    public static final String DEVICE_STATUS_CHANGED = "device_status_changed";
    public static final String DEVICE_ONLINE = "online";
    public static final String DEVICE_OFFLINE = "offline";
    public static final String DEVICE_ALARM = "alarm";
    public static final String DEVICE_ALARM_STOP = "alarm_stop";
    public static final String DEVICE_RESET = "reset";
    public static final String SET_DEVICE_SETTING = "set_device_setting";
    public static final String DEVICE_UPDATE = "device_update";
    public static final String DEVICE_UPDATE_STATUS = "device_update_status";
    public static final String CONTROL_DEVICE = "control_device";
    public static final String CONTROL_REPLY = "control_reply";
    public static final String OPEN_VIDEO = "open_video";

    public static final String getAppSubTopic(String deviceId) {
        String deviceSubTopic = "dev/notice/{" + deviceId + "}";
        Log.e("comaiot_sdk", "getAppSubTopic:" + deviceSubTopic);
        return deviceSubTopic;
    }

    public static final String getAppSubAppTopic(String deviceId, String clientId) {
        String deviceSubTopic = "app/{" + deviceId + "}/{" + clientId + "}";
        Log.e("comaiot_sdk", "getAppSubTopic:" + deviceSubTopic);
        return deviceSubTopic;
    }

    public static final String getAdminSubTopic(String deviceId) {
        Log.e("comaiot_sdk", "deviceId:" + deviceId);
        return "admin/dev/{" + deviceId + "}";
    }

    public static final String getAppPubAllTopic(String deviceId) {
        String devicePubAllTopic = "dev/{" + deviceId + "}";
        Log.e("comaiot_sdk", "deviceId:" + deviceId);
        return devicePubAllTopic;
    }

    public static final String getDevicePubAppTopic(String deviceId, String appId) {
        Log.e("comaiot_sdk", "deviceId:" + deviceId + "appId:" + appId);
        return "app/{" + deviceId + "}/{" + appId + "}";
    }
}

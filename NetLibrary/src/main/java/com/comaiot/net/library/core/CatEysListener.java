package com.comaiot.net.library.core;

import com.comaiot.net.library.bean.AudioCallEvent;
import com.comaiot.net.library.bean.DeviceAlarmEvent;
import com.comaiot.net.library.bean.DeviceOnlineEvent;
import com.comaiot.net.library.bean.DeviceRemoveEvent;
import com.comaiot.net.library.bean.DeviceRestartEvent;
import com.comaiot.net.library.bean.DeviceSettings;
import com.comaiot.net.library.bean.DeviceVideoCloseEvent;
import com.comaiot.net.library.bean.DeviceWorkModeChangeEvent;

public interface CatEysListener {
    void onHttpRequestFailed(String method, String message);

    void onMessageSocketConnectSuccess();

    void onMessageSocketConnectFailed();

    void onGetDeviceSettings(String devUid, DeviceSettings deviceSettings);

    void onDeviceVideoReady(String joidId, long videoId);

    void onDeviceAlarm(String devUid, DeviceAlarmEvent deviceAlarmEvent);

    void onDeviceRemoved(String devUid, DeviceRemoveEvent deviceRemoveEvent);

    void onDeviceVideoClose(String devUid, DeviceVideoCloseEvent closeEvent);

    void onDeviceCallAudioEvent(String devUid, AudioCallEvent audioCallEvent);

    void onDeviceOnline(String devUid, DeviceOnlineEvent onlineEvent);

    void onDeviceWorkModeChanged(String devUid, DeviceWorkModeChangeEvent workModeChangeEvent);

    void onDeviceRestartEvent(String devUid, DeviceRestartEvent deviceRestartEvent);

    void onMessageSocketLost(Throwable e);
}

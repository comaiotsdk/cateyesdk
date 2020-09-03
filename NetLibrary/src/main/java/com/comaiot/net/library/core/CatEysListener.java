package com.comaiot.net.library.core;

import com.comaiot.net.library.bean.AppControlDevice;
import com.comaiot.net.library.bean.AudioCallEvent;
import com.comaiot.net.library.bean.ConfigDeviceRegisterFaceNameInfo;
import com.comaiot.net.library.bean.CustomBase64JsonContent;
import com.comaiot.net.library.bean.DevRegisterFaceInfo;
import com.comaiot.net.library.bean.DeviceAlarmEvent;
import com.comaiot.net.library.bean.DeviceOnlineEvent;
import com.comaiot.net.library.bean.DeviceRemoveEvent;
import com.comaiot.net.library.bean.DeviceRestartEvent;
import com.comaiot.net.library.bean.DeviceSettings;
import com.comaiot.net.library.bean.DeviceVideoCloseEvent;
import com.comaiot.net.library.bean.DeviceWorkModeChangeEvent;
import com.comaiot.net.library.bean.UpdateDeviceEntity;
import com.comaiot.net.library.bean.UpdateVersionInfo;

public interface CatEysListener {
    /**
     * SDK中HTTP请求错误回调
     *
     * @param method  方法名
     * @param message 错误信息
     */
    void onHttpRequestFailed(String method, String message);

    /**
     * SDK连接消息通道成功
     */
    void onMessageSocketConnectSuccess();

    /**
     * SDK连接消息通道失败
     */
    void onMessageSocketConnectFailed();

    /**
     * 代表devUid这个设备的设置属性发生了改变
     *
     * @param devUid         设备devUid
     * @param deviceSettings 设备属性
     */
    void onGetDeviceSettings(String devUid, DeviceSettings deviceSettings);

    /**
     * 猫眼端已加入音视频通道joidId，猫眼在音视频通道中的id是videoId
     *
     * @param joidId  音视频通道id
     * @param videoId 猫眼端在音视频通道中的id
     */
    void onDeviceVideoReady(String joidId, long videoId);

    /**
     * 猫眼端发生PIR/RING
     *
     * @param devUid           设备devUid
     * @param deviceAlarmEvent 设备提醒事件
     */
    void onDeviceAlarm(String devUid, DeviceAlarmEvent deviceAlarmEvent);

    /**
     * 猫眼被解绑，此回调可能会不准确，不建议使用
     *
     * @param devUid            设备devUid
     * @param deviceRemoveEvent 设备被移除事件
     */
    void onDeviceRemoved(String devUid, DeviceRemoveEvent deviceRemoveEvent);

    /**
     * 猫眼段主动关闭远程查看
     *
     * @param devUid     设备devUid
     * @param closeEvent 设备端关闭远程查看事件
     */
    void onDeviceVideoClose(String devUid, DeviceVideoCloseEvent closeEvent);

    /**
     * 此方法需要定制客户，猫眼端主动呼叫SDK
     *
     * @param devUid         设备devUid
     * @param audioCallEvent 设备主动呼叫语音通话事件
     */
    void onDeviceCallAudioEvent(String devUid, AudioCallEvent audioCallEvent);

    /**
     * 猫眼端上线回调
     *
     * @param devUid      设备devUid
     * @param onlineEvent 设备上线通知
     */
    void onDeviceOnline(String devUid, DeviceOnlineEvent onlineEvent);

    /**
     * 猫眼端工作模式改变
     *
     * @param devUid              设备devUid
     * @param workModeChangeEvent 设备工作模式改变事件
     */
    void onDeviceWorkModeChanged(String devUid, DeviceWorkModeChangeEvent workModeChangeEvent);

    /**
     * 猫眼端远程重启
     *
     * @param devUid             设备devUid
     * @param deviceRestartEvent 设备远程重启事件
     */
    void onDeviceRestartEvent(String devUid, DeviceRestartEvent deviceRestartEvent);

    /**
     * 猫眼端消息通道掉线通知
     *
     * @param e 异常信息
     */
    void onMessageSocketLost(Throwable e);

    /**
     * 猫眼端升级检查
     *
     * @param devUid 设备devUid
     */
    void onDeviceUpdateCheckInfo(String devUid, UpdateDeviceEntity entity);

    /**
     * 猫眼端升级下载中
     *
     * @param devUid 设备devUid
     */
    void onDeviceUpdateInfo(String devUid, UpdateVersionInfo info);

    /**
     * 猫眼端自定义消息到达
     *
     * @param devUid  设备devUid
     * @param content base64后的自定义json字符串 规则：Base64.NO_WRAP
     */
    void onDeviceCustomMessageArrived(String devUid, CustomBase64JsonContent content);


    /**
     * 猫眼端进入录入人脸模式回调
     *
     * @param devUid        设备devUid
     * @param controlDevice
     */
    void onDeviceJoinRegisterFaceCallback(String devUid, AppControlDevice controlDevice);

    /**
     * 猫眼端录入人脸信息回调
     *
     * @param devUid              设备devUid
     * @param devRegisterFaceInfo
     */
    void onDeviceRegisterFaceProgress(String devUid, DevRegisterFaceInfo devRegisterFaceInfo);

    /**
     * 猫眼端录入人脸数据属性回调信息
     *
     * @param devUid               设备devUid
     * @param registerFaceNameInfo
     */
    void onConfigDeviceRegisterFaceInfoCallback(String devUid, ConfigDeviceRegisterFaceNameInfo registerFaceNameInfo);
}

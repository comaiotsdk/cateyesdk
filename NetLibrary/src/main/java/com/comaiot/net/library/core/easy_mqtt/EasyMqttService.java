package com.comaiot.net.library.core.easy_mqtt;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.comaiot.net.library.bean.CmdInfo;
import com.comaiot.net.library.bean.DeviceStatusChangeEntity;
import com.comaiot.net.library.bean.SetDeviceSettingEntity;
import com.comaiot.net.library.core.CatEyeSDKInterface;
import com.comaiot.net.library.bean.AudioCallEvent;
import com.comaiot.net.library.bean.DeviceAlarmEvent;
import com.comaiot.net.library.bean.DeviceOnlineEvent;
import com.comaiot.net.library.bean.DeviceRemoveEvent;
import com.comaiot.net.library.bean.DeviceRestartEvent;
import com.comaiot.net.library.bean.DeviceSettings;
import com.comaiot.net.library.bean.DeviceVideoCloseEvent;
import com.comaiot.net.library.bean.DeviceVideoReady;
import com.comaiot.net.library.bean.DeviceWorkModeChangeEvent;
import com.comaiot.net.library.core.MqttManagerInter;
import com.comaiot.net.library.inter.GsonUtils;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.util.Map;


/**
 * Mqtt服务
 *
 * @author zhangshun
 */
@SuppressWarnings("all")
public class EasyMqttService {
    private final String TAG = "EasyMqttService";
    private boolean canDoConnect = true;

    private MqttAndroidClient client;
    private MqttConnectOptions conOpt;

    private Context context;
    private String serverUrl = "";
    private String willMessageTopic = "";
    private String userName = "admin";
    private String passWord = "password";
    private String clientId = "";
    private int timeOut = 10;
    private int willMessageQos = 2;
    private int keepAliveInterval = 20;
    private boolean retained = false;
    private boolean cleanSession = false;
    private boolean autoReconnect = true;

    /**
     * builder设计模式
     *
     * @param builder
     */
    private EasyMqttService(Builder builder) {
        this.context = builder.context;
        this.serverUrl = builder.serverUrl;
        this.willMessageTopic = builder.willMessageTopic;
        this.willMessageQos = builder.willMessageQos;
        this.userName = builder.userName;
        this.passWord = builder.passWord;
        this.clientId = builder.clientId;
        this.timeOut = builder.timeOut;
        this.keepAliveInterval = builder.keepAliveInterval;
        this.retained = builder.retained;
        this.cleanSession = builder.cleanSession;
        this.autoReconnect = builder.autoReconnect;

        init();
    }

    /**
     * Builder 构造类
     */
    public static final class Builder {

        private Context context;
        private String serverUrl;
        private String userName = "admin";
        private String passWord = "password";
        private String clientId;
        private String willMessageTopic;
        private int timeOut = 10;
        private int willMessageQos = 10;
        private int keepAliveInterval = 20;
        private boolean retained = false;
        private boolean cleanSession = false;
        private boolean autoReconnect = false;

        public Builder serverUrl(String serverUrl) {
            this.serverUrl = serverUrl;
            return this;
        }

        public Builder userName(String userName) {
            this.userName = userName;
            return this;
        }

        public Builder passWord(String passWord) {
            this.passWord = passWord;
            return this;
        }

        public Builder clientId(String clientId) {
            this.clientId = clientId;
            return this;
        }

        public Builder timeOut(int timeOut) {
            this.timeOut = timeOut;
            return this;
        }

        public Builder keepAliveInterval(int keepAliveInterval) {
            this.keepAliveInterval = keepAliveInterval;
            return this;
        }

        public Builder retained(boolean retained) {
            this.retained = retained;
            return this;
        }

        public Builder autoReconnect(boolean autoReconnect) {
            this.autoReconnect = autoReconnect;
            return this;
        }

        public Builder cleanSession(boolean cleanSession) {
            this.cleanSession = cleanSession;
            return this;
        }

        public Builder setWill(String json, String willMessageTopic, int qos) {
            this.willMessageTopic = willMessageTopic;
            this.willMessageQos = qos;
            return this;
        }

        public EasyMqttService bulid(Context context) {
            this.context = context;
            return new EasyMqttService(this);
        }
    }

    /**
     * 发布消息
     *
     * @param msg
     * @param topic
     * @param qos
     * @param retained
     */
    public void publish(String msg, String topic, int qos, boolean retained) {
        try {
            client.publish(topic, msg.getBytes(), qos, retained);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取mqtt客户端
     *
     * @return
     */
    public MqttAndroidClient getMqttClient() {
        return client;
    }


    private void init() {
        // 服务器地址（协议+地址+端口号）
        client = new MqttAndroidClient(context, serverUrl, clientId);
        // 设置MQTT监听并且接受消息
        client.setCallback(mqttCallback);

        conOpt = new MqttConnectOptions();
        // 清除缓存
        conOpt.setCleanSession(cleanSession);
        // 设置超时时间，单位：秒
        conOpt.setConnectionTimeout(timeOut);
        // 心跳包发送间隔，单位：秒
        conOpt.setKeepAliveInterval(keepAliveInterval);
        // 用户名
        conOpt.setUserName(userName);
        // 密码
        conOpt.setPassword(passWord.toCharArray());
        conOpt.setAutomaticReconnect(autoReconnect);
    }

    /**
     * 关闭客户端
     */
    public void close() {
        try {
            client.unregisterResources();
            client.close();
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
    }

    /**
     * 连接MQTT服务器
     */
    public void connect() {
        if (canDoConnect && !client.isConnected()) {
            try {
                client.connect(conOpt, null, iMqttActionListener);
            } catch (Exception e) {
                Log.e("CatEye_SDK", "connect exception: " + e.toString());
            }
        }
    }

    /**
     * 订阅主题
     *
     * @param topics 主题
     * @param qos    策略
     */
    public void subscribe(String[] topics, int[] qos) {
        try {
            // 订阅topic话题
            Log.i(TAG, "execute subscribe -- qos = " + qos.toString());
            client.subscribe(topics, qos);
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
    }

    /**
     * 订阅主题
     *
     * @param topic 主题
     * @param qos   策略
     */
    public boolean subscribe(String topic, int qos) {
        boolean ret = false;
        try {
            // 订阅topic话题
            Log.i(TAG, "execute subscribe -- topic = " + topic + "qos = " + qos);
            client.subscribe(topic, qos);
            ret = true;
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }

        return ret;
    }

    /**
     * 订阅主题
     *
     * @param topic 主题
     * @param qos   策略
     */
    public void subscribe(String topic, int qos, Object userContext, IMqttActionListener listener) {
        try {
            // 订阅topic话题
            Log.i(TAG, "execute subscribe -- topic = " + topic + "qos = " + qos);
            client.subscribe(topic, qos, userContext, listener);
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
    }

    /**
     * 订阅主题
     *
     * @param topics 主题
     * @param qos    策略
     */
    public void subscribe(String[] topics, int[] qos, Object userContext, IMqttActionListener listener) {
        try {
            // 订阅topic话题
            client.subscribe(topics, qos, userContext, listener);
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
    }

    /**
     * 解除订阅
     *
     * @param topic 主题
     */
    public void unsubscribe(String topic) {
        try {
            // 订阅topic话题
            Log.i(TAG, "execute unsubscribe -- topic = " + topic);
            client.unsubscribe(topic);
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
    }

    /**
     * 解除订阅
     *
     * @param topics 主题
     */
    public void unsubscribe(String[] topics) {
        try {
            // 订阅topic话题
            client.unsubscribe(topics);
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
    }

    /**
     * 解除订阅
     */
    public void unsubscribe(String[] topics, Object userContext, IMqttActionListener listener) {
        try {
            // 订阅topic话题
            client.unsubscribe(topics, userContext, listener);
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
    }

    /**
     * 解除订阅
     */
    public void unsubscribe(String topic, Object userContext, IMqttActionListener listener) {
        try {
            // 订阅topic话题
            client.unsubscribe(topic, userContext, listener);
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
    }

    /**
     * 断开连接
     */
    public void disconnect() {
        try {
            client.disconnect();
            client.unregisterResources();
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
    }

    /**
     * 判断连接是否断开
     */
    public boolean isConnected() {
        try {
            return client.isConnected();
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
        return false;
    }

    /**
     * MQTT是否连接成功
     */
    private IMqttActionListener iMqttActionListener = new IMqttActionListener() {

        @Override
        public void onSuccess(IMqttToken arg0) {
            Log.i(TAG, "mqtt connect success ");
            if (MqttManagerInter.getInstance(CatEyeSDKInterface.get().getContext()).getCallback() != null) {
                MqttManagerInter.getInstance(CatEyeSDKInterface.get().getContext()).getCallback().onMessageSocketConnectSuccess();
            }
        }

        @Override
        public void onFailure(IMqttToken arg0, Throwable arg1) {
            Log.i(TAG, "mqtt connect failed ");
            if (MqttManagerInter.getInstance(CatEyeSDKInterface.get().getContext()).getCallback() != null) {
                MqttManagerInter.getInstance(CatEyeSDKInterface.get().getContext()).getCallback().onMessageSocketConnectFailed();
            }
        }
    };

    // MQTT监听并且接受消息
    private MqttCallback mqttCallback = new MqttCallback() {

        @Override
        public void messageArrived(String topic, MqttMessage message) throws Exception {
            if (null == topic || null == message) return;

            byte[] payload = message.getPayload();
            if (null == payload) return;

            String msgContent = new String(payload);
            if (msgContent.isEmpty()) return;

            String detailLog = topic + ";qos:" + message.getQos() + ";retained:" + message.isRetained();
            Log.i(TAG, detailLog);
            Log.i(TAG, "messageArrived:" + msgContent);

            CmdInfo cmdInfo = GsonUtils.fromJson(msgContent, CmdInfo.class);
            String devUid = cmdInfo.getDevUid();

            if (devUid == null || devUid.isEmpty()) {
                if (topic.contains("{") && topic.contains("}")) {
                    int indexStart = topic.indexOf("{");
                    int indexEnd = topic.indexOf("}");
                    devUid = topic.substring(indexStart + 1, indexEnd);
                }
            }

            if (cmdInfo.getCmd().equals("get_device_status") || cmdInfo.getCmd().equals("set_device_setting") || cmdInfo.getCmd().equals("device_status_changed")) {
                if (cmdInfo.getCmd().equals("device_status_changed")) {
                    DeviceStatusChangeEntity deviceStatusChangeEntity = GsonUtils.fromJson(msgContent, DeviceStatusChangeEntity.class);
                    DeviceSettings deviceSettings = deviceStatusChangeEntity.getDevice_status();
                    if (null != CatEyeSDKInterface.get().getCacheMap()) {
                        Map<String, DeviceSettings> cacheMap = CatEyeSDKInterface.get().getCacheMap();
                        DeviceSettings settings = cacheMap.get(devUid);
                        if (null != settings) {
                            cacheMap.remove(devUid);
                            cacheMap.put(devUid, deviceSettings);
                        } else {
                            cacheMap.put(devUid, deviceSettings);
                        }
                    }

                    if (MqttManagerInter.getInstance(CatEyeSDKInterface.get().getContext()).getCallback() != null) {
                        MqttManagerInter.getInstance(CatEyeSDKInterface.get().getContext()).getCallback().onGetDeviceSettings(devUid, deviceSettings);
                    }
                    return;
                } else if (cmdInfo.getCmd().equals("set_device_setting")) {
                    SetDeviceSettingEntity setDeviceSettingEntity = GsonUtils.fromJson(msgContent, SetDeviceSettingEntity.class);
                    if (null != CatEyeSDKInterface.get().getCacheMap()) {
                        Map<String, DeviceSettings> cacheMap = CatEyeSDKInterface.get().getCacheMap();
                        DeviceSettings settings = cacheMap.get(devUid);
                        if (settings == null) return;
                        settings.setDeviceNickName(setDeviceSettingEntity.getDeviceNickName());
                        settings.setRing(setDeviceSettingEntity.getRing().getIndex());
                        settings.setSound(setDeviceSettingEntity.getRing().getSound());
                        settings.setDoorbellLight(setDeviceSettingEntity.getDoorbellLight());
                        settings.setIntelligentNight(setDeviceSettingEntity.getIntelligentNight());
                        settings.setRing_light(setDeviceSettingEntity.getPerson_check().getRing_light_switch());
                        settings.setPerson_check(setDeviceSettingEntity.getPerson_check());

                        if (MqttManagerInter.getInstance(CatEyeSDKInterface.get().getContext()).getCallback() != null) {
                            MqttManagerInter.getInstance(CatEyeSDKInterface.get().getContext()).getCallback().onGetDeviceSettings(devUid, settings);
                        }
                    }

                    return;
                }

                DeviceSettings deviceSettings = GsonUtils.fromJson(msgContent, DeviceSettings.class);
                if (null != CatEyeSDKInterface.get().getCacheMap()) {
                    Map<String, DeviceSettings> cacheMap = CatEyeSDKInterface.get().getCacheMap();
                    DeviceSettings settings = cacheMap.get(devUid);
                    if (null != settings) {
                        cacheMap.remove(devUid);
                        cacheMap.put(devUid, deviceSettings);
                    } else {
                        cacheMap.put(devUid, deviceSettings);
                    }
                }

                if (MqttManagerInter.getInstance(CatEyeSDKInterface.get().getContext()).getCallback() != null) {
                    MqttManagerInter.getInstance(CatEyeSDKInterface.get().getContext()).getCallback().onGetDeviceSettings(devUid, deviceSettings);
                }
            } else if (cmdInfo.getCmd().equals("open_video")) {
                DeviceVideoReady videoReady = GsonUtils.fromJson(msgContent, DeviceVideoReady.class);
                long videoUid = videoReady.getVideo_uid();
                String joinId = videoReady.getJoin_id();
                if (videoUid == 0) return;
                if (joinId == null) {
                    joinId = devUid;
                }

                if (MqttManagerInter.getInstance(CatEyeSDKInterface.get().getContext()).getCallback() != null) {
                    MqttManagerInter.getInstance(CatEyeSDKInterface.get().getContext()).getCallback().onDeviceVideoReady(joinId, videoUid);
                }
            } else if (cmdInfo.getCmd().equals("alarm")) {
                DeviceAlarmEvent deviceAlarmEvent = GsonUtils.fromJson(msgContent, DeviceAlarmEvent.class);

                if (MqttManagerInter.getInstance(CatEyeSDKInterface.get().getContext()).getCallback() != null) {
                    MqttManagerInter.getInstance(CatEyeSDKInterface.get().getContext()).getCallback().onDeviceAlarm(devUid, deviceAlarmEvent);
                }
            } else if (cmdInfo.getCmd().equals("remove_account")) {
                DeviceRemoveEvent removeEvent = GsonUtils.fromJson(msgContent, DeviceRemoveEvent.class);

                if (null != MqttManagerInter.getInstance(CatEyeSDKInterface.get().getContext()).getCallback()) {
                    MqttManagerInter.getInstance(CatEyeSDKInterface.get().getContext()).getCallback().onDeviceRemoved(devUid, removeEvent);
                }
            } else if (cmdInfo.getCmd().equals("close_socket")) {
                DeviceVideoCloseEvent videoCloseEvent = GsonUtils.fromJson(msgContent, DeviceVideoCloseEvent.class);

                if (null != MqttManagerInter.getInstance(CatEyeSDKInterface.get().getContext()).getCallback()) {
                    MqttManagerInter.getInstance(CatEyeSDKInterface.get().getContext()).getCallback().onDeviceVideoClose(devUid, videoCloseEvent);
                }
            } else if (cmdInfo.getCmd().equals("audio_call")) {
                AudioCallEvent audioCallEvent = GsonUtils.fromJson(msgContent, AudioCallEvent.class);

                if (null != MqttManagerInter.getInstance(CatEyeSDKInterface.get().getContext()).getCallback()) {
                    MqttManagerInter.getInstance(CatEyeSDKInterface.get().getContext()).getCallback().onDeviceCallAudioEvent(devUid, audioCallEvent);
                }
            } else if (cmdInfo.getCmd().equals("queryOnline") || cmdInfo.getCmd().equals("online")) {
                DeviceOnlineEvent onlineEvent = GsonUtils.fromJson(msgContent, DeviceOnlineEvent.class);

                if (null != MqttManagerInter.getInstance(CatEyeSDKInterface.get().getContext()).getCallback()) {
                    MqttManagerInter.getInstance(CatEyeSDKInterface.get().getContext()).getCallback().onDeviceOnline(devUid, onlineEvent);
                }
            } else if (cmdInfo.getCmd().equals("set_device_work_mode")) {
                DeviceWorkModeChangeEvent workModeChangeEvent = GsonUtils.fromJson(msgContent, DeviceWorkModeChangeEvent.class);

                if (null != MqttManagerInter.getInstance(CatEyeSDKInterface.get().getContext()).getCallback()) {
                    MqttManagerInter.getInstance(CatEyeSDKInterface.get().getContext()).getCallback().onDeviceWorkModeChanged(devUid, workModeChangeEvent);
                }
            } else if (cmdInfo.getCmd().equals("reset")) {
                DeviceRestartEvent deviceRestartEvent = GsonUtils.fromJson(msgContent, DeviceRestartEvent.class);

                if (null != MqttManagerInter.getInstance(CatEyeSDKInterface.get().getContext()).getCallback()) {
                    MqttManagerInter.getInstance(CatEyeSDKInterface.get().getContext()).getCallback().onDeviceRestartEvent(devUid, deviceRestartEvent);
                }
            }
        }

        @Override
        public void deliveryComplete(IMqttDeliveryToken arg0) {

            Log.i(TAG, "deliveryComplete");
        }

        @Override
        public void connectionLost(Throwable arg0) {
            if (MqttManagerInter.getInstance(CatEyeSDKInterface.get().getContext()).getCallback() != null) {
                MqttManagerInter.getInstance(CatEyeSDKInterface.get().getContext()).getCallback().onMessageSocketLost(arg0);
            }
            Log.i(TAG, "connectionLost");
            // 失去连接，重连
        }
    };

    /**
     * 判断网络是否连接
     */
    private boolean isConnectIsNomarl() {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = connectivityManager.getActiveNetworkInfo();
        if (info != null && info.isAvailable()) {
            String name = info.getTypeName();
            Log.i(TAG, "MQTT current network name：" + name);
            return true;
        } else {
            Log.i(TAG, "MQTT no network");
            return false;
        }
    }
}
package com.comaiot.net.library.core;

import android.content.Context;

import com.comaiot.net.library.core.easy_mqtt.EasyMqttService;
import com.comaiot.net.library.utils.Logger;

import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttToken;

@SuppressWarnings("all")
public class MqttManagerInter {
    private volatile static MqttManagerInter mqttManager = null;
    private Context mContext;
    private EasyMqttService mEasyMqttService;

    public static final int KEEP_ALIVE = 100;

    private String mServerUrl;
    private String mClientId;
    private String mUserName;
    private String mPassword;
    private CatEysListener mCallback;

    private MqttManagerInter(Context context) {
        this.mContext = context;
    }

    /**
     * 获取一个MqttManagerInter单例
     *
     * @param context
     * @return 返回一个MqttManagerInter的实例对象
     */
    public static MqttManagerInter getInstance(Context context) {
        if (mqttManager == null) {
            synchronized (MqttManagerInter.class) {
                if (mqttManager == null) {
                    mqttManager = new MqttManagerInter(context);
                }
            }
        }
        return mqttManager;
    }

    /**
     * 连接服务器
     */
    public void connect(String ipAddress, String clientId, String port, String userName, String password) {
        mServerUrl = "tcp://" + ipAddress + ":" + port;
        mClientId = clientId;
        mUserName = userName;
        mPassword = password;

        resetConnection();
        createConnection();
        mEasyMqttService.connect();
    }

    /**
     * 订阅消息
     *
     * @param topic 订阅消息的主题
     */
    public boolean subscribeMsg(String topic, int qos) {
        if (null == mEasyMqttService) return false;
        return mEasyMqttService.subscribe(topic, qos);
    }

    /**
     * 订阅消息
     *
     * @param topic 订阅消息的主题
     */
    public void subscribeMsg(String[] topics, int[] qoss) {
        if (null == mEasyMqttService) return;
        mEasyMqttService.subscribe(topics, qoss);
    }

    /**
     * 订阅消息
     *
     * @param topic 订阅消息的主题
     */
    public void subscribeMsgWithCallback(String[] topics, int[] qoss, IMqttActionListener listener) {
        if (null == mEasyMqttService) return;
        mEasyMqttService.subscribe(topics, qoss, null, listener);
    }

    /**
     * 取消订阅消息
     *
     * @param topic 取消订阅消息的主题
     */
    public void unSubscribeMsg(String topic) {
        if (null == mEasyMqttService) return;
        mEasyMqttService.unsubscribe(topic);
    }

    /**
     * 取消订阅消息
     *
     * @param topic 取消订阅消息的主题
     */
    public void unSubscribeMsgWithCallback(String[] topics, IMqttActionListener listener) {
        if (null == mEasyMqttService) return;
        mEasyMqttService.unsubscribe(topics, null, listener);
    }

    /**
     * 发布消息
     *
     * @param topic      发布消息主题
     * @param msg        消息体
     * @param isRetained 是否为保留消息
     */
    public void publish(String topic, String msg, boolean isRetained, int qos) {
        if (null == mEasyMqttService) return;
        mEasyMqttService.publish(msg, topic, qos, isRetained);
    }

    private void resetConnection() {
        if (null != mEasyMqttService) {
            mEasyMqttService.disconnect();

            Logger.ii(">>>>>>>> MQTT resetConnection <<<<<<<<");
        }
    }

    private void createConnection() {
        mEasyMqttService = new EasyMqttService.Builder()
                //设置自动重连
                .autoReconnect(false)
                //设置不清除回话session 可收到服务器之前发出的推送消息
                .cleanSession(true)
                //心跳
                .keepAliveInterval(KEEP_ALIVE)
                //client_id
                .clientId(mClientId)
                //userName
                .userName(mUserName)
                //password
                .passWord(mPassword)
                //serverUrl
                .serverUrl(mServerUrl)
                //构建出EasyMqttService 建议用application的context
                .bulid(mContext.getApplicationContext());

        Logger.ii(">>>>>>>> MQTT createConnection <<<<<<<<");
        Logger.ii(">>>>>>>> UserName=" + mUserName + " <<<<<<<<");
        Logger.ii(">>>>>>>> Password=" + mPassword + " <<<<<<<<");
        Logger.ii(">>>>>>>> ClientId=" + mClientId + " <<<<<<<<");
        Logger.ii(">>>>>>>> ServerUrl=" + mServerUrl + " <<<<<<<<");
    }

    public boolean isConnected() {
        if (null == mEasyMqttService) return false;
        return mEasyMqttService.isConnected();
    }

    public void disconnect() {
        if (null == mEasyMqttService) return;
        Logger.ee("try Mqtt disconnect");
        mEasyMqttService.disconnect();
    }

    public CatEysListener getCallback() {
        return mCallback;
    }

    public void setCallBack(CatEysListener listener) {
        this.mCallback = listener;
    }

    public String getClientId() {
        return mClientId;
    }

    public boolean reconnect() {
        resetConnection();
        createConnection();
        if (null == mEasyMqttService) return false;
        mEasyMqttService.connect();

        return true;
    }
}

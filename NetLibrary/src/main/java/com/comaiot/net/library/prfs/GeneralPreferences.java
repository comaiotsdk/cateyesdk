package com.comaiot.net.library.prfs;

import android.content.Context;
import android.content.SharedPreferences;



public class GeneralPreferences {

    private static final String SP_NAME = "general_app_sp";
    private static final String APP_UID = "phone_app_uid";
    private static final String APP_ENVID = "phone_app_envid";
    private static final String APP_TOKEN = "phone_app_token";

    private static final String MQTT_HOST = "mqtt_host";
    private static final String MQTT_PORT = "mqtt_port";
    private static final String MQTT_USER = "mqtt_user";
    private static final String MQTT_PWD = "mqtt_password";
    //------------------------------------end------------------------------------//
    private Context mContext;
    private SharedPreferences mSp;

    private static GeneralPreferences mInstance;

    private GeneralPreferences(Context context) {
        this.mContext = context;
        mSp = mContext.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
    }

    private GeneralPreferences(Context context, String deviceId) {
        this.mContext = context;
        mSp = mContext.getSharedPreferences(deviceId, Context.MODE_PRIVATE);
    }

    public static GeneralPreferences get(Context context, String deviceId) {
        if (null == mInstance) {
            synchronized (Object.class) {
                if (null == mInstance) {
                    mInstance = new GeneralPreferences(context, deviceId);
                }
            }
        } else {
            mInstance = new GeneralPreferences(context, deviceId);
        }
        return mInstance;
    }

    public static GeneralPreferences get(Context context) {
        if (null == mInstance) {
            synchronized (Object.class) {
                if (null == mInstance) {
                    mInstance = new GeneralPreferences(context);
                }
            }
        } else {
            mInstance = new GeneralPreferences(context);
        }
        return mInstance;
    }

    public static void init(Context context) {
        if (null == mInstance) {
            synchronized (GeneralPreferences.class) {
                if (null == mInstance) {
                    mInstance = new GeneralPreferences(context);
                }
            }
        }
    }

    public boolean saveAppUid(String uid) {
        SharedPreferences.Editor editor = mSp.edit();
        return editor.putString(APP_UID, uid).commit();
    }

    public String getAppUid() {
        return mSp.getString(APP_UID, null);
    }

    public boolean saveAppEnvid(String envid) {
        SharedPreferences.Editor editor = mSp.edit();
        return editor.putString(APP_ENVID, envid).commit();
    }

    public String getAppEnvid() {
        return mSp.getString(APP_ENVID, null);
    }

    public boolean saveAppToken(String token) {
        SharedPreferences.Editor editor = mSp.edit();
        return editor.putString(APP_TOKEN, token).commit();
    }

    public String getAppToken() {
        return mSp.getString(APP_TOKEN, null);
    }

    public boolean saveMqttHost(String mqttHost) {
        SharedPreferences.Editor editor = mSp.edit();
        return editor.putString(MQTT_HOST, mqttHost).commit();
    }

    public String getMqttHost() {
        return mSp.getString(MQTT_HOST, null);
    }

    public boolean saveMqttPort(String mqttPort) {
        SharedPreferences.Editor editor = mSp.edit();
        return editor.putString(MQTT_PORT, mqttPort).commit();
    }

    public String getMqttPort() {
        return mSp.getString(MQTT_PORT, null);
    }

    public boolean saveMqttUser(String mqttUser) {
        SharedPreferences.Editor editor = mSp.edit();
        return editor.putString(MQTT_USER, mqttUser).commit();
    }

    public String getMqttUser() {
        return mSp.getString(MQTT_USER, null);
    }

    public boolean saveMqttPassword(String mqttPassword) {
        SharedPreferences.Editor editor = mSp.edit();
        return editor.putString(MQTT_PWD, mqttPassword).commit();
    }

    public String getMqttPassword() {
        return mSp.getString(MQTT_PWD, null);
    }
}

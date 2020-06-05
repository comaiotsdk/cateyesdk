package com.comaiot.net.library.prfs;

import android.content.Context;
import android.content.SharedPreferences;

import com.comaiot.net.library.Model.DESUtils;

public class GeneralPreferencesTemp {

    private static final String SP_NAME = "general_pref_config";

    private Context mContext;
    private static GeneralPreferencesTemp mInstance;
    private SharedPreferences mSp;

    /**
     * 构造函数
     *
     * @param context
     */
    private GeneralPreferencesTemp(Context context) {
        this.mContext = context;
        mSp = mContext.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
    }

    /**
     * 初始化一个实例对象
     *
     * @param context
     */
    public static void init(Context context) {
        if (null == mInstance) {
            synchronized (GeneralPreferencesTemp.class) {
                if (null == mInstance) {
                    mInstance = new GeneralPreferencesTemp(context);
                }
            }
        }
    }

    /**
     * 获取GeneralPreferences实例对象
     *
     * @return 返回一个GeneralPreferences的实例对象
     */
    public static GeneralPreferencesTemp get() {
        return mInstance;
    }

    private static final String PHONE_NUM = "general_phone_num";
    private static final String APP_UID = "general_phone_app_uid";
    private static final String APP_ENVID = "general_phone_app_envid";
    private static final String APP_TOKEN = "general_phone_app_token";
    private static final String BIND_AID = "general_phone_app_bind_aid";
    private static final String SHARE_AID = "general_phone_app_share_aid";
    private static final String DEVICE_HOST = "device_host";
    private static final String DEVICE_PORT = "device_port";
    private static final String DEVICE_USER = "device_user";
    private static final String DEVICE_PASS = "device_pass";

    /**
     * 获取app_uid
     *
     * @return 返回app_uid
     */
    public String getAppUid() {
        String string = mSp.getString(APP_UID, null);
        return DESUtils.decryptString(string);
    }

    /**
     * 存储app_uid
     *
     * @param uid
     * @return 成功true， 失败false
     */
    public boolean saveAppUid(String uid) {
        SharedPreferences.Editor editor = mSp.edit();
        return editor.putString(APP_UID, uid).commit();
    }

    /**
     * 获取app_envid
     *
     * @return 返回app_envid
     */
    public String getAppEnvid() {
        String string = mSp.getString(APP_ENVID, null);
        return DESUtils.decryptString(string);
    }

    /**
     * 存储app_envid
     *
     * @param envid
     * @return 成功true， 失败false
     */
    public boolean saveAppEnvid(String envid) {
        SharedPreferences.Editor editor = mSp.edit();
        return editor.putString(APP_ENVID, envid).commit();
    }

    /**
     * 存储token
     *
     * @param token
     * @return 成功true， 失败false
     */
    public boolean saveToken(String token) {
        SharedPreferences.Editor editor = mSp.edit();
        return editor.putString(APP_TOKEN, token).commit();
    }

    /**
     * 获取token
     *
     * @return 返回token
     */
    public String getToken() {
        String string = mSp.getString(APP_TOKEN, null);
        return DESUtils.decryptString(string);
    }

    /**
     * 存储手机号
     *
     * @param phoneNum
     * @return 成功true， 失败false
     */
    public boolean savePhoneNum(String phoneNum) {
        SharedPreferences.Editor editor = mSp.edit();
        return editor.putString(PHONE_NUM, phoneNum).commit();
    }

    /**
     * 获取手机号
     *
     * @return 返回 手机号
     */
    public String getPhoneNum() {
        String string = mSp.getString(PHONE_NUM, null);
        return DESUtils.decryptString(string);
    }

    /**
     *  获取AppSk
     *
     * @return 固定值
     */
    public String getAppSk() {
        return "pchdUvmpU8TLR+071/niw6wfiSyjr2IUhqbIG1SsOd3LaBbpErvfNw";
    }

    /**
     *  获取AppAk
     *
     * @return 固定值
     */
    public String getAppAk() {
        return "dxvf8BbWocrMeEPQLy4HUquv+MpuqNyoRicUoH/QomLLaBbpErvfNw";
    }

    /**
     * 存储app_aid
     *
     * @param aid
     * @return 成功true， 失败false
     */
    public boolean saveBindAppAid(String aid) {
        aid = DESUtils.encryptString(aid);
        SharedPreferences.Editor editor = mSp.edit();
        return editor.putString(BIND_AID, aid).commit();
    }

    /**
     * 获取app_aid
     *
     * @return 返回app_aid
     */
    public String getBindAppAid() {
        String string = mSp.getString(BIND_AID, null);
        return DESUtils.decryptString(string);
    }

    /**
     * 存储连接mqtt的host
     *
     * @param host
     * @return 成功true， 失败false
     */
    public boolean saveMqttHost(String host) {
        host = DESUtils.encryptString(host);
        SharedPreferences.Editor editor = mSp.edit();
        return editor.putString(DEVICE_HOST, host).commit();
    }

    /**
     * 获取连接mqtt的host
     *
     * @return 返回连接mqtt的host
     */
    public String getHost() {
        String string = mSp.getString(DEVICE_HOST, null);
        return DESUtils.decryptString(string);
    }

    /**
     * 存储连接mqtt的port
     *
     * @param port
     * @return 成功true， 失败false
     */
    public boolean saveMqttPort(String port) {
        port = DESUtils.encryptString(port);
        SharedPreferences.Editor editor = mSp.edit();
        return editor.putString(DEVICE_PORT, port).commit();
    }

    /**
     * 获取连接mqtt的port
     *
     * @return 返回连接mqtt的port
     */
    public String getPort() {
        String string = mSp.getString(DEVICE_PORT, null);
        return DESUtils.decryptString(string);
    }

    /**
     * 存储连接mqtt的 user_name
     *
     * @param user
     * @return 成功true， 失败false
     */
    public boolean saveMqttUser(String user) {
        user = DESUtils.encryptString(user);
        SharedPreferences.Editor editor = mSp.edit();
        return editor.putString(DEVICE_USER, user).commit();
    }

    /**
     * 获取连接mqtt的user_name
     *
     * @return 返回连接mqtt的user_name
     */
    public String getUser() {
        String string = mSp.getString(DEVICE_USER, null);
        return DESUtils.decryptString(string);
    }

    /**
     * 存储连接mqtt的 password
     *
     * @param pass
     * @return 成功true， 失败false
     */
    public boolean saveMqttPass(String pass) {
        pass = DESUtils.encryptString(pass);
        SharedPreferences.Editor editor = mSp.edit();
        return editor.putString(DEVICE_PASS, pass).commit();
    }

    /**
     * 获取连接mqtt的password
     *
     * @return 返回连接mqtt的password
     */
    public String getPass() {
        String string = mSp.getString(DEVICE_PASS, null);
        return DESUtils.decryptString(string);
    }
}

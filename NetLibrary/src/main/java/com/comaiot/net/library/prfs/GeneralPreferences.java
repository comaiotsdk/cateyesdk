package com.comaiot.net.library.prfs;

import android.content.Context;
import android.content.SharedPreferences;

import com.comaiot.net.library.Model.DESUtils;
import com.comaiot.net.library.bean.DeviceStatusChangeEntity;
import com.comaiot.net.library.bean.GetDeviceStatusEntity;
import com.comaiot.net.library.bean.SetDeviceSettingEntity;


public class GeneralPreferences {

    private static final String SP_NAME = "general_app_sp";
    private static final String LOGIN_STATUS = "login_status";
    private static final String PHONE_NUMBER = "phone_number";
    private static final String PHONE_PWD = "phone_pwd";
    private static final String WX_BIND_PHONE = "wx_bind_phone";
    private static final String APP_UID = "phone_app_uid";
    private static final String APP_ENVID = "phone_app_envid";
    private static final String APP_TOKEN = "phone_app_token";
    private static final String BIND_AID = "phone_app_bind_aid";
    private static final String PUSHID = "push_id";
    private static final String TYPE = "type";

    private static final String MQTT_HOST = "mqtt_host";
    private static final String MQTT_PORT = "mqtt_port";
    private static final String MQTT_USER = "mqtt_user";
    private static final String MQTT_PWD = "mqtt_password";
    private static final String NICKNAME = "nickname";
    private static final String DEFAULTDEVICEUID = "default_device_uid";
    private static final String USERHEAD = "user_head";
    private static final String SHARE_USER_NICK = "share_user_nick";
    private static final String XIN_GE_TOKEN = "xin_ge_token";

    //---------------------------------device sp---------------------------------//
    private static final String DEVICE_NICK_NAME = "device_nick_name";  //设备昵称
    private static final String DEVICE_RING_INDEX = "device_ring_index";//门铃音
    private static final String DEVICE_RING_SOUND = "device_ring_sound";//门铃音量
    private static final String DEVICE_INTELLIGENTNIGHT = "device_intelligentNight";//红外夜视
    private static final String DEVICE_PERSON_CHECK = "device_person_check";//人体检测开关
    private static final String DEVICE_CHECK_TIME = "device_check_time";    //侦测触发时间
    private static final String DEVICE_CHECK_LING_MIN = "device_check_ling_min";//灵敏度
    private static final String DEVICE_ALARM_MODE = "device_alarm_mode";        //报警模式
    private static final String DEVICE_TACK_NUMBER = "device_tack_number";  //连拍张数
    private static final String DEVICE_ALARM_INDEX = "device_alarm_index";  //报警铃声
    private static final String DEVICE_ALARM_SOUND = "device_alarm_sound";  //报警音量
    private static final String DEVICE_ALARM_INTERVAL_NUMBER = "notification_duration";  //报警时间间隔
    private static final String DEVICE_RING_LIGHT = "ring_light";  //门铃灯
    private static final String DEVICE_OUTSIDE_ALARM = "out_door_alarm";  //门外声音警告
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

    public boolean saveLoginStatus(int loginStatus) {
        SharedPreferences.Editor editor = mSp.edit();
        return editor.putInt(LOGIN_STATUS, loginStatus).commit();
    }

    public int getLoginStatus() {
        return mSp.getInt(LOGIN_STATUS, 0);             //0未登录 1已登陆
    }

    public String getYdAppSk() {
        return "pchdUvmpU8TLR+071/niw6wfiSyjr2IUhqbIG1SsOd3LaBbpErvfNw==";
    }

    public String getYdAppAk() {
        return "dxvf8BbWocrMeEPQLy4HUquv+MpuqNyoRicUoH/QomLLaBbpErvfNw==";
    }

    public String getGvsAppSk(){
        return "onR5/VcyKBGW2WYy8sovU1Usk2idiEdYdCzTaUgB0OTLaBbpErvfNw==";
    }

    public String getGvsAppAk() {
        return "xLinuMGfvpKMHFKHHlHjahgsdMNxezl7SMstyn/qSaDLaBbpErvfNw==";
    }

    public String getFangHuiAppSk(){
        return "4+OlKsoYs0GQKGWMirqTmP98LV82r041WCecdBCiqQHLaBbpErvfNw==";
    }

    public String getFangHuiAppAk() {
        return "BtzszU+v160bycjXZIVG+XKtvcxQVwxOoPwOEPTqQDXLaBbpErvfNw==";
    }

    public String getZhouYaYunAppSk(){
        return "MQoZa8XWZctduZU0PThDFckuxWn/sS6F04xNI5Eh3UHLaBbpErvfNw==";
    }

    public String getZhouYaYunAppAk() {
        return "RslFbGMeKuyV21Si2pDtmQw6iZyenEiW6peWQWbBlXDLaBbpErvfNw==";
    }

    public String getKunShangAppSk(){
        return "E/9nTMLxOlj+Ej346dvfoj+owQdT9nrJYFooGXCe8JvLaBbpErvfNw==";
    }

    public String getKunShangAppAk() {
        return "SQEcmRvZaVS3B+5FDRzEsmXRroA7VyrXreWvg0j+ZNnLaBbpErvfNw==";
    }

    public String getDeShiManAppSk(){
        return "uXGCG1X4IoyjvgFB5bOqLXgrIzgmtx38VGJg5FBpp4bLaBbpErvfNw==";
    }

    public String getDeShiManAppAk() {
        return "HknQGRc6D8McXVeLiHbgYxi96Iign3y2Q2KDlzCXdlrLaBbpErvfNw==";
    }

    public String getManYaAppSk(){
        return "iOkVaO6ZC618zFlWIIai0EqTl2qftAUBF8IeYjtLqnfLaBbpErvfNw==";
    }

    public String getManYaAppAk() {
        return "+ICXheXwD0k+U7qZtjpyL/gMGlZlEIS//9AAWTigYq/LaBbpErvfNw==";
    }

    public String getAiTeAppSk(){
        return "uxK0+cO6AnGU/5z8w8eEGJzqTGgVy+kp5Yz91EbjfijLaBbpErvfNw==";
    }

    public String getAiTeAppAk() {
        return "cHUSk7DvsneWnH3nPizZZLup9z3iFqID0r6tDk83mpnLaBbpErvfNw==";
    }

    public String getPhilipsAppSk(){
        return "o/Q4MCDVdEv1LwL2OCEuq8Gg1+yfyAcuMymQB71kr7LLaBbpErvfNw==";
    }

    public String getPhilipsAppAk() {
        return "scU89dR5/vyDwrnluMwZ6X1ZkPtNLVF0M9JBBxg2YTHLaBbpErvfNw==";
    }

    public String getHonYanAppSk(){
        return "2DhiKZDsnC2Iic2KNjuLDKIeVcRXKsRKxLNmdMCWHhnLaBbpErvfNw==";
    }

    public String getHonYanAppAk() {
        return "xrLxfZ3dg5VNLtyACKvP8m0iteUjS6cD6OkAH37ilIHLaBbpErvfNw==";
    }

    public String getHuNeAppSk(){
        return "xMzehvcJv6PXyOA2CM3fzl5p3zMBo6AxM9HoGubCkabLaBbpErvfNw==";
    }

    public String getHuNeAppAk() {
        return "jJIN4xCS5sYw+JB9oRQXaAbEX0ieFVBqITM3O+crs2nLaBbpErvfNw==";
    }

    public String getRuoChanAppSk(){
        return "ivz22r3A3Mwd8cOMHr9k5t+Zq/MxhZCFrqJhuYypxfPLaBbpErvfNw==";
    }

    public String getRuoChanAppAk() {
        return "SNJvYVTIZViq4wgYqA+Mm9TZ3CK8GNMryoxq7MrCEVjLaBbpErvfNw==";
    }

    public String getIWRAppAk(){
        return "kkKJYm2RIzT885rFyQKB8OoVBB/t/KS+dmePd9Yd55nLaBbpErvfNw==";
    }

    public String getIWRAppSk() {
        return "QnZOeqprlnUhu4m92HxkO3+YcQp71D4kvTxK/SR8h0jLaBbpErvfNw==";
    }

    public String getRUDOLPHAppAk(){
        return "F+PLzdn4LvuB53L/9sPA8P+6WrevlL4quWht4MtJJ/PLaBbpErvfNw==";
    }

    public String getRUDOLPHAppSk() {
        return "4asj0u7QipCKNmo77pMSsy87tJ4WLjrsKiYX92pUanXLaBbpErvfNw==";
    }

    public String getDAYINAppAk(){
        return "4T6QddoLza46O/CW4OFCYwGTxulJxcjDOzui2slJ9b7LaBbpErvfNw==";
    }

    public String getDAYINAppSk() {
        return "NMFfi1ZkRIJ/lYwDtDqnMOwKRPb5brZzgX+7ObQwFOnLaBbpErvfNw==";
    }

    public String getLEIXUNKEWEIAppAk(){
        return "duD8zBn7FGdjn0KMfRdt6phIjB8poeSK2fviH4FL1LvLaBbpErvfNw==";
    }

    public String getLEIXUNKEWEIAppSk() {
        return "SUhWaeOVT0P+13RINfgVOv0vqDrqHTw4lTj7YaBoxvjLaBbpErvfNw==";
    }

    public String getIFLYTEKAppAk(){
        return "4FC12f0ZzviU6DtDIgmopubx3nqH8wFrvdsk73WW8kLLaBbpErvfNw==";
    }

    public String getIFLYTEKAppSk() {
        return "evf/mT9pdBITBFblNFv/hTsVqz2JLQFASVvq3bQTRKfLaBbpErvfNw==";
    }

    public String getJIANSHIAppAk(){
        return "HswKfPrFBneq0Eulm91nSiyy6BH50yyd4XMQdXIDHkbLaBbpErvfNw==";
    }

    public String getJIANSHIAppSk() {
        return "lN07A0PR5+tdB8vlFfIff7+xDkl1hCP1nL3nI7uwaS/LaBbpErvfNw==";
    }

    public boolean savePhoneNumber(String phoneNumber) {
        SharedPreferences.Editor editor = mSp.edit();
        return editor.putString(PHONE_NUMBER, phoneNumber).commit();
    }

    public String getPhoneNumber() {
        return mSp.getString(PHONE_NUMBER, null);
    }

    public boolean savePhonePwd(String phonePwd) {
        SharedPreferences.Editor editor = mSp.edit();
        return editor.putString(PHONE_PWD, phonePwd).commit();
    }

    public String getPhonePwd() {
        return mSp.getString(PHONE_PWD, null);
    }

    public boolean getWxBindPhone() {
        return mSp.getBoolean(WX_BIND_PHONE, true);
    }

    public boolean setWxBindPhone(boolean wx_bind_phone) {
        SharedPreferences.Editor editor = mSp.edit();
        return editor.putBoolean(WX_BIND_PHONE, wx_bind_phone).commit();
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

    public boolean saveBindAppAid(String aid) {
        aid = DESUtils.encryptString(aid);
        SharedPreferences.Editor editor = mSp.edit();
        return editor.putString(BIND_AID, aid).commit();
    }

    public String getBindAppAid() {
        String string = mSp.getString(BIND_AID, null);
        return DESUtils.decryptString(string);
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

    public boolean saveNickname(String nickname) {
        SharedPreferences.Editor editor = mSp.edit();
        return editor.putString(NICKNAME, nickname).commit();
    }

    public String getNickname() {
        return mSp.getString(NICKNAME, "");
    }

    public boolean saveDefaultDeviceUid(String uid) {
        SharedPreferences.Editor editor = mSp.edit();
        return editor.putString(DEFAULTDEVICEUID, uid).commit();
    }

    public String getDefaultDeviceUid() {
        return mSp.getString(DEFAULTDEVICEUID, "");
    }

    //--------------------------------device info start---------------------------//
    public boolean saveDeviceNick(String dev_uid, String nickname) {
        SharedPreferences.Editor editor = mSp.edit();
        return editor.putString(DEVICE_NICK_NAME + dev_uid, nickname).commit();
    }

    public String getDeviceNickName(String dev_uid) {
        return mSp.getString(DEVICE_NICK_NAME + dev_uid, null);
    }

    public boolean saveDeviceRing(int ringIndex) {
        SharedPreferences.Editor editor = mSp.edit();
        return editor.putInt(DEVICE_RING_INDEX, ringIndex).commit();
    }

    public int getDeviceRing() {
        return mSp.getInt(DEVICE_RING_INDEX, 0);
    }

    public boolean saveDeviceCheckStatus(int personCheck) {
        SharedPreferences.Editor editor = mSp.edit();
        return editor.putInt(DEVICE_PERSON_CHECK, personCheck).commit();
    }

    public int getDeviceCheckStatus() {
        return mSp.getInt(DEVICE_PERSON_CHECK, 1);
    }

    public boolean saveDeviceRingLightStatus(int ringLight) {
        SharedPreferences.Editor editor = mSp.edit();
        return editor.putInt(DEVICE_RING_LIGHT, ringLight).commit();
    }

    public int getDeviceRingLightStatus() {
        return mSp.getInt(DEVICE_RING_LIGHT, 1);
    }

    public boolean saveDeviceOutsideAlarmStatus(int outsideAlarm) {
        SharedPreferences.Editor editor = mSp.edit();
        return editor.putInt(DEVICE_OUTSIDE_ALARM, outsideAlarm).commit();
    }

    public int getDeviceOutsideAlarmStatus() {
        return mSp.getInt(DEVICE_OUTSIDE_ALARM, 1);
    }

    public boolean saveDeviceCheckTime(int checkTime) {
        SharedPreferences.Editor editor = mSp.edit();
        return editor.putInt(DEVICE_CHECK_TIME, checkTime).commit();
    }

    public int getDeviceCheckTime() {
        return mSp.getInt(DEVICE_CHECK_TIME, 5);
    }

    public boolean saveDeviceLingMin(int ling_min) {
        SharedPreferences.Editor editor = mSp.edit();
        return editor.putInt(DEVICE_CHECK_LING_MIN, ling_min).commit();
    }

    public int getDeviceLingMin() {
        return mSp.getInt(DEVICE_CHECK_LING_MIN, 1);
    }

    public boolean saveAlarmMode(int alarmMode) {
        SharedPreferences.Editor editor = mSp.edit();
        return editor.putInt(DEVICE_ALARM_MODE, alarmMode).commit();
    }

    public int getAlarmMode() {
        return mSp.getInt(DEVICE_ALARM_MODE, 0);
    }

    public boolean saveDeviceTackNum(int tackNumber) {
        SharedPreferences.Editor editor = mSp.edit();
        return editor.putInt(DEVICE_TACK_NUMBER, tackNumber).commit();
    }

    public int getDeviceTackNum() {
        return mSp.getInt(DEVICE_TACK_NUMBER, 3);
    }

    public boolean saveDeviceAlarmIntervalNum(int alarmInterval) {
        SharedPreferences.Editor editor = mSp.edit();
        return editor.putInt(DEVICE_ALARM_INTERVAL_NUMBER, alarmInterval).commit();
    }

    public int getDeviceAlarmIntervalNum() {
        return mSp.getInt(DEVICE_ALARM_INTERVAL_NUMBER, 60);
    }

    public boolean saveDeviceAlarmIndex(int alarmIndex) {
        SharedPreferences.Editor editor = mSp.edit();
        return editor.putInt(DEVICE_ALARM_INDEX, alarmIndex).commit();
    }

    public int getDeviceAlarmIndex() {
        return mSp.getInt(DEVICE_ALARM_INDEX, 2);
    }

    public boolean saveDeviceAlarmSound(int alarmSound) {
        SharedPreferences.Editor editor = mSp.edit();
        return editor.putInt(DEVICE_ALARM_SOUND, alarmSound).commit();
    }

    public int getDeviceAlarmSound() {
        return mSp.getInt(DEVICE_ALARM_SOUND, 0);
    }

    public void saveDeviceInfo(Context context, GetDeviceStatusEntity entity) {
        String deviceId = entity.getDeviceId();
        GeneralPreferences preferences = GeneralPreferences.get(context);
        preferences.saveDeviceNick(DEVICE_NICK_NAME + entity.getDeviceId(), entity.getDeviceNickName());
        preferences.saveDeviceRingLightStatus(entity.getRing_light());
        preferences = GeneralPreferences.get(context, entity.getDeviceId());
        preferences.saveDeviceRing(entity.getRing());
        preferences.saveDeviceSound(entity.getSound());
        preferences.saveDeviceIntelligentNight(entity.getIntelligentNight());
        GetDeviceStatusEntity.Person_Check personCheck = entity.getPerson_check();
        preferences.saveDeviceCheckStatus(personCheck.getSwitch_check());
        preferences.saveDeviceCheckTime(personCheck.getAuto_pic());
        preferences.saveDeviceLingMin(personCheck.getSensitive());
        preferences.saveAlarmMode(personCheck.getAlarm_mode());
        preferences.saveDeviceTackNum(personCheck.getTack_pic_num());
        preferences.saveDeviceAlarmIndex(personCheck.getOut_door_ring());
        preferences.saveDeviceAlarmSound(personCheck.getOut_door_sound());
        preferences.saveDeviceAlarmIntervalNum(personCheck.get_alarm_interval_num());
        //Logger.ee("SPreferences saveDeviceInfo personCheck.get_alarm_interval_num():" + personCheck.get_alarm_interval_num());
        //Logger.ee("SPreferences saveDeviceInfo getDeviceAlarmIntervalNum():" + preferences.getDeviceAlarmIntervalNum());
        preferences.saveDeviceRingLightStatus(personCheck.getRing_light_switch());
        //Logger.ii("personCheck.geOutside_alarm_switch():" + personCheck.geOutside_alarm_switch());
        //Logger.ii("preferences.getDeviceOutsideAlarmStatus() before:" + preferences.getDeviceOutsideAlarmStatus());
        preferences.saveDeviceOutsideAlarmStatus(personCheck.geOutside_alarm_switch());
        //Logger.ii("preferences.getDeviceOutsideAlarmStatus() after:" + preferences.getDeviceOutsideAlarmStatus());
    }

    public boolean saveUserHead(String userHead) {
        SharedPreferences.Editor editor = mSp.edit();
        return editor.putString(USERHEAD, userHead).commit();
    }

    public String getUserHead() {
        return mSp.getString(USERHEAD, null);
    }

    public String getShareUserNick() {
        return mSp.getString(SHARE_USER_NICK, null);
    }

    public boolean saveShareUserNick(String shareUserNick) {
        SharedPreferences.Editor editor = mSp.edit();
        return editor.putString(SHARE_USER_NICK, shareUserNick).commit();
    }

    public boolean savePushId(String pushId) {
        SharedPreferences.Editor editor = mSp.edit();
        return editor.putString(PUSHID, pushId).commit();
    }

    public String getPushId() {
        return mSp.getString(PUSHID, null);
    }

    public boolean saveType(String type) {
        SharedPreferences.Editor editor = mSp.edit();
        return editor.putString(TYPE, type).commit();
    }

    public String getType() {
        return mSp.getString(TYPE, null);
    }

    public boolean saveXinGeToken(String xingeToken) {
        SharedPreferences.Editor editor = mSp.edit();
        return editor.putString(XIN_GE_TOKEN, xingeToken).commit();
    }

    public String getXinGeToken() {
        return mSp.getString(XIN_GE_TOKEN, null);
    }
    //-----------------------------------device info end--------------------------//

    public boolean saveDeviceSound(int ringSound) {
        SharedPreferences.Editor editor = mSp.edit();
        return editor.putInt(DEVICE_RING_SOUND, ringSound).commit();
    }

    public int getDeviceSound() {
        return mSp.getInt(DEVICE_RING_SOUND, 0);
    }

    public boolean saveDeviceIntelligentNight(int intelligentNight) {
        SharedPreferences.Editor editor = mSp.edit();
        return editor.putInt(DEVICE_INTELLIGENTNIGHT, intelligentNight).commit();
    }

    public int getDeviceIntelligentNight() {
        return mSp.getInt(DEVICE_INTELLIGENTNIGHT, 0);
    }
}

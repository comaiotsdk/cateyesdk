package com.comaiot.net.library.prfs;

import android.content.Context;
import android.content.SharedPreferences;

import com.comaiot.net.library.Model.DESUtils;


/**
 * 存取数据的SharePreferences
 */
public class CatEyePreferences {

    private static final String SP_NAME = "cat_eye_pref_config";

    private Context mContext;
    private static CatEyePreferences mInstance;
    private SharedPreferences mSp;

    /**
     * 构造函数
     *
     * @param context
     */
    private CatEyePreferences(Context context) {
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
            synchronized (CatEyePreferences.class) {
                if (null == mInstance) {
                    mInstance = new CatEyePreferences(context);
                }
            }
        }
    }

    /**
     * 获取CatEyePreferences实例对象
     *
     * @return 返回一个CatEyePreferences的实例对象
     */
    public static CatEyePreferences get() {
        return mInstance;
    }

    private static final String APP_UID = "cat_eye_phone_app_uid";
    private static final String APP_ENVID = "cat_eye_phone_app_envid";
    private static final String APP_TOKEN = "cat_eye_phone_app_token";
    private static final String BIND_AID = "cat_eye_phone_app_bind_aid";
    private static final String SHARE_AID = "cat_eye_phone_app_share_aid";
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

    public String getYdAppSk() {
        return "pchdUvmpU8TLR+071/niw6wfiSyjr2IUhqbIG1SsOd3LaBbpErvfNw==";
    }

    public String getYdAppAk() {
        return "dxvf8BbWocrMeEPQLy4HUquv+MpuqNyoRicUoH/QomLLaBbpErvfNw==";
    }

    public String getGvsAppSk() {
        return "onR5/VcyKBGW2WYy8sovU1Usk2idiEdYdCzTaUgB0OTLaBbpErvfNw==";
    }

    public String getGvsAppAk() {
        return "xLinuMGfvpKMHFKHHlHjahgsdMNxezl7SMstyn/qSaDLaBbpErvfNw==";
    }

    public String getFangHuiAppSk() {
        return "4+OlKsoYs0GQKGWMirqTmP98LV82r041WCecdBCiqQHLaBbpErvfNw==";
    }

    public String getFangHuiAppAk() {
        return "BtzszU+v160bycjXZIVG+XKtvcxQVwxOoPwOEPTqQDXLaBbpErvfNw==";
    }

    public String getZhouYaYunAppSk() {
        return "MQoZa8XWZctduZU0PThDFckuxWn/sS6F04xNI5Eh3UHLaBbpErvfNw==";
    }

    public String getZhouYaYunAppAk() {
        return "RslFbGMeKuyV21Si2pDtmQw6iZyenEiW6peWQWbBlXDLaBbpErvfNw==";
    }

    public String getKunShangAppSk() {
        return "E/9nTMLxOlj+Ej346dvfoj+owQdT9nrJYFooGXCe8JvLaBbpErvfNw==";
    }

    public String getKunShangAppAk() {
        return "SQEcmRvZaVS3B+5FDRzEsmXRroA7VyrXreWvg0j+ZNnLaBbpErvfNw==";
    }

    public String getDeShiManAppSk() {
        return "uXGCG1X4IoyjvgFB5bOqLXgrIzgmtx38VGJg5FBpp4bLaBbpErvfNw==";
    }

    public String getDeShiManAppAk() {
        return "HknQGRc6D8McXVeLiHbgYxi96Iign3y2Q2KDlzCXdlrLaBbpErvfNw==";
    }

    public String getManYaAppSk() {
        return "iOkVaO6ZC618zFlWIIai0EqTl2qftAUBF8IeYjtLqnfLaBbpErvfNw==";
    }

    public String getManYaAppAk() {
        return "+ICXheXwD0k+U7qZtjpyL/gMGlZlEIS//9AAWTigYq/LaBbpErvfNw==";
    }

    public String getAiTeAppSk() {
        return "uxK0+cO6AnGU/5z8w8eEGJzqTGgVy+kp5Yz91EbjfijLaBbpErvfNw==";
    }

    public String getAiTeAppAk() {
        return "cHUSk7DvsneWnH3nPizZZLup9z3iFqID0r6tDk83mpnLaBbpErvfNw==";
    }

    public String getPhilipsAppSk() {
        return "o/Q4MCDVdEv1LwL2OCEuq8Gg1+yfyAcuMymQB71kr7LLaBbpErvfNw==";
    }

    public String getPhilipsAppAk() {
        return "scU89dR5/vyDwrnluMwZ6X1ZkPtNLVF0M9JBBxg2YTHLaBbpErvfNw==";
    }

    public String getHonYanAppSk() {
        return "2DhiKZDsnC2Iic2KNjuLDKIeVcRXKsRKxLNmdMCWHhnLaBbpErvfNw==";
    }

    public String getHonYanAppAk() {
        return "xrLxfZ3dg5VNLtyACKvP8m0iteUjS6cD6OkAH37ilIHLaBbpErvfNw==";
    }

    public String getHuNeAppSk() {
        return "xMzehvcJv6PXyOA2CM3fzl5p3zMBo6AxM9HoGubCkabLaBbpErvfNw==";
    }

    public String getHuNeAppAk() {
        return "jJIN4xCS5sYw+JB9oRQXaAbEX0ieFVBqITM3O+crs2nLaBbpErvfNw==";
    }

    public String getRuoChanAppSk() {
        return "ivz22r3A3Mwd8cOMHr9k5t+Zq/MxhZCFrqJhuYypxfPLaBbpErvfNw==";
    }

    public String getRuoChanAppAk() {
        return "SNJvYVTIZViq4wgYqA+Mm9TZ3CK8GNMryoxq7MrCEVjLaBbpErvfNw==";
    }

    public String getIWRAppAk() {
        return "kkKJYm2RIzT885rFyQKB8OoVBB/t/KS+dmePd9Yd55nLaBbpErvfNw==";
    }

    public String getIWRAppSk() {
        return "QnZOeqprlnUhu4m92HxkO3+YcQp71D4kvTxK/SR8h0jLaBbpErvfNw==";
    }

    public String getRUDOLPHAppAk() {
        return "F+PLzdn4LvuB53L/9sPA8P+6WrevlL4quWht4MtJJ/PLaBbpErvfNw==";
    }

    public String getRUDOLPHAppSk() {
        return "4asj0u7QipCKNmo77pMSsy87tJ4WLjrsKiYX92pUanXLaBbpErvfNw==";
    }

    public String getDAYINAppAk() {
        return "4T6QddoLza46O/CW4OFCYwGTxulJxcjDOzui2slJ9b7LaBbpErvfNw==";
    }

    public String getDAYINAppSk() {
        return "NMFfi1ZkRIJ/lYwDtDqnMOwKRPb5brZzgX+7ObQwFOnLaBbpErvfNw==";
    }

    public String getLEIXUNKEWEIAppAk() {
        return "duD8zBn7FGdjn0KMfRdt6phIjB8poeSK2fviH4FL1LvLaBbpErvfNw==";
    }

    public String getLEIXUNKEWEIAppSk() {
        return "SUhWaeOVT0P+13RINfgVOv0vqDrqHTw4lTj7YaBoxvjLaBbpErvfNw==";
    }

    public String getIFLYTEKAppAk() {
        return "4FC12f0ZzviU6DtDIgmopubx3nqH8wFrvdsk73WW8kLLaBbpErvfNw==";
    }

    public String getIFLYTEKAppSk() {
        return "evf/mT9pdBITBFblNFv/hTsVqz2JLQFASVvq3bQTRKfLaBbpErvfNw==";
    }

    public String getJIANSHIAppAk() {
        return "HswKfPrFBneq0Eulm91nSiyy6BH50yyd4XMQdXIDHkbLaBbpErvfNw==";
    }

    public String getJIANSHIAppSk() {
        return "lN07A0PR5+tdB8vlFfIff7+xDkl1hCP1nL3nI7uwaS/LaBbpErvfNw==";
    }

    //TODO
    public String getComaiotAppAk() {
        return "lN07A0PR5+tdB8vlFfIff7+xDkl1hCP1nL3nI7uwaS/LaBbpErvfNw==";
    }

    //TODO
    public String getComaiotAppSk() {
        return "lN07A0PR5+tdB8vlFfIff7+xDkl1hCP1nL3nI7uwaS/LaBbpErvfNw==";
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

    public boolean setRegisterDeviceStatus(boolean registerStatus) {
        SharedPreferences.Editor editor = mSp.edit();
        return editor.putBoolean("register_status", registerStatus).commit();
    }

    public boolean getRegisterStatus() {
        return mSp.getBoolean("register_status", false);
    }
}

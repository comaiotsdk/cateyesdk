package com.comaiot.net.library.core;

import android.content.Context;
import android.os.Build;
import android.util.Base64;

import com.comaiot.net.library.Model.DESUtils;
import com.comaiot.net.library.bean.AppControlDevice;
import com.comaiot.net.library.bean.AppReceiveShareEntity;
import com.comaiot.net.library.bean.AppSubscribeEntity;
import com.comaiot.net.library.bean.CmdInfo;
import com.comaiot.net.library.bean.DeviceStatusChangeEntity;
import com.comaiot.net.library.bean.DeviceSvrCacheSettings;
import com.comaiot.net.library.bean.GetDeviceStatusEntity;
import com.comaiot.net.library.bean.SetDeviceSettingEntity;
import com.comaiot.net.library.controller.AppUtils;
import com.comaiot.net.library.controller.CatEyeController;
import com.comaiot.net.library.controller.view.AppBarcodeReqView;
import com.comaiot.net.library.controller.view.AppChangePasswordReqView;
import com.comaiot.net.library.controller.view.AppEmailSubScribeReqView;
import com.comaiot.net.library.controller.view.AppQueryAccountReqView;
import com.comaiot.net.library.controller.view.AppQueryAidBindRquView;
import com.comaiot.net.library.controller.view.AppQueryPushAccountReqView;
import com.comaiot.net.library.controller.view.AppQuerySharedDeviceReqView;
import com.comaiot.net.library.controller.view.AppReceiveShareReqView;
import com.comaiot.net.library.controller.view.AppRefreshTokenView;
import com.comaiot.net.library.controller.view.AppRemoveMessageReqView;
import com.comaiot.net.library.controller.view.AppShareDeviceReqView;
import com.comaiot.net.library.controller.view.AppSubscribeReqView;
import com.comaiot.net.library.controller.view.AppUnSubscribeReqView;
import com.comaiot.net.library.controller.view.BindPhoneView;
import com.comaiot.net.library.controller.CatEyeView;
import com.comaiot.net.library.controller.view.EmailTokenReqView;
import com.comaiot.net.library.controller.view.PartnerChangePhoneReqView;
import com.comaiot.net.library.controller.view.PartnerShareDeviceReqView;
import com.comaiot.net.library.controller.view.PartnerWeixinPushConfigReqView;
import com.comaiot.net.library.controller.view.PartnerWeixinPushNoticeReqView;
import com.comaiot.net.library.controller.view.SmsTokenReqView;
import com.comaiot.net.library.inter.BaseUrl;
import com.comaiot.net.library.inter.GsonUtils;
import com.comaiot.net.library.inter.OkHttpCallback;
import com.comaiot.net.library.inter.OkHttpUtils;
import com.comaiot.net.library.inter.RetrofitUtil;
import com.comaiot.net.library.bean.AppQueryRemovedListEntity;
import com.comaiot.net.library.bean.AppQueryRemovedMessageEntity;
import com.comaiot.net.library.bean.Device;
import com.comaiot.net.library.bean.DeviceEventEntity;
import com.comaiot.net.library.bean.DeviceEventListEntity;
import com.comaiot.net.library.bean.DeviceListEntity;
import com.comaiot.net.library.bean.DeviceOnlineEvent;
import com.comaiot.net.library.bean.DeviceRestartEvent;
import com.comaiot.net.library.bean.DeviceSettings;
import com.comaiot.net.library.bean.DeviceWorkModeChangeEvent;
import com.comaiot.net.library.bean.PartNerQueryDevice;
import com.comaiot.net.library.bean.PartNerQueryDeviceEntity;
import com.comaiot.net.library.bean.QueryCountryCodeEntity;
import com.comaiot.net.library.inter.StringUtils;
import com.comaiot.net.library.prfs.CatEyePreferences;
import com.comaiot.net.library.prfs.GeneralPreferences;
import com.comaiot.net.library.req_params.AppDownloadDevConfigEntity;
import com.comaiot.net.library.req_params.AppDownloadDevConfigParams;
import com.comaiot.net.library.req_params.AppDownloadFileParams;
import com.comaiot.net.library.controller.view.AppAidReqView;
import com.comaiot.net.library.controller.view.AppBindEmailReqView;
import com.comaiot.net.library.controller.view.AppBindWeixinReqView;
import com.comaiot.net.library.controller.view.AppChangeAccountInfoReqView;
import com.comaiot.net.library.controller.view.AppChangePhoneReqView;
import com.comaiot.net.library.controller.view.AppDownloadConfigReqView;
import com.comaiot.net.library.controller.view.AppDownloadDevConfigReqView;
import com.comaiot.net.library.controller.view.AppDownloadFileReqView;
import com.comaiot.net.library.controller.view.AppQueryDevConnectReqView;
import com.comaiot.net.library.controller.view.AppQueryDeviceListReqView;
import com.comaiot.net.library.controller.view.AppQueryRemovedMessagesReqView;
import com.comaiot.net.library.controller.view.AppRemoveAccountReqView;
import com.comaiot.net.library.controller.view.AppRemoveAidReqView;
import com.comaiot.net.library.controller.view.AppRemoveSharedDeviceReqView;
import com.comaiot.net.library.controller.view.AppResetPasswordByEmailReqView;
import com.comaiot.net.library.controller.view.AppResetPasswordByPhoneReqView;
import com.comaiot.net.library.controller.view.AppUploadConfigReqView;
import com.comaiot.net.library.controller.view.PartNerQueryDeviceListReqView;
import com.comaiot.net.library.controller.view.QueryCountryCodeReqView;
import com.comaiot.net.library.req_params.AppReceiveShareParams;
import com.comaiot.net.library.req_params.AppRemoveAccountParams;
import com.comaiot.net.library.req_params.CatEyeLoginParams;
import com.comaiot.net.library.utils.Logger;

import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


@SuppressWarnings("all")
public class CatEyeSDKInterface implements CatEyeView {

    public static final boolean COMAIOT = false;

    private static CatEyeSDKInterface mInstance;
    private final MqttManagerInter mqttManager;
    private CatEyeController<CatEyeView> catEyeController;
    private Context mContext;
    private final String mCountryCode;
    private final String ak;
    private final String sk;
    private CatEysListener catEysListener;

    private Map<String, DeviceSettings> mDeviceSettingsMap;

    private CatEyeSDKInterface(Context context, String countryCode, String ak, String sk) throws NoAttachViewException, NoInternetException {
        if (null == context) {
            throw new RuntimeException("The Context is not support NULL");
        }
        if (ak == null || sk == null || ak.isEmpty() || sk.isEmpty()) {
            throw new RuntimeException("The AK/SK is empty.Not support Empty.Please contact COMAIOT get the AK/SK");
        }
        this.mContext = context.getApplicationContext();
        this.mCountryCode = countryCode;
        this.ak = ak;
        this.sk = sk;

        GeneralPreferences.init(context);
        CatEyePreferences.init(context);
        RetrofitUtil.getInstance(mContext, ak, sk);
        catEyeController = new CatEyeController<>();
        catEyeController.attachView(this);

        String appUid = CatEyePreferences.get().getAppUid();
        String appEnvid = CatEyePreferences.get().getAppEnvid();

        mDeviceSettingsMap = new HashMap<>();

        if (null == appUid || null == appEnvid) {
            CatEyePreferences.get().setRegisterDeviceStatus(false);
            registerMobilePhone(mContext, countryCode);
        } else {
            CatEyePreferences.get().setRegisterDeviceStatus(true);
        }
        mqttManager = MqttManagerInter.getInstance(mContext);
    }

    private void registerMobilePhone(Context context, String countryCode) throws NoAttachViewException, NoInternetException {
        catEyeController.AppReg(context, countryCode);
    }

    /**
     * 初始化SDK
     *
     * @param context     程序上下文
     * @param countryCode 城市代码，比如[中国-86] 传值就传86就可以
     * @param ak          客户公钥      -由COMAIOT提供
     * @param sk          客户私钥      -由COMAIOT提供
     * @return CatEyeSDKInterface实例    此类是单例模式
     * @throws NoAttachViewException
     * @throws NoInternetException
     */
    public static CatEyeSDKInterface init(Context context, String countryCode, String ak, String sk) throws NoAttachViewException, NoInternetException {
        if (null == mInstance) {
            synchronized (CatEyeSDKInterface.class) {
                if (null == mInstance) {
                    mInstance = new CatEyeSDKInterface(context, countryCode, ak, sk);
                }
            }
        }

        return mInstance;
    }

    /**
     * @return CatEyeSDKInterface实例    此类是单例模式
     */
    public static CatEyeSDKInterface get() {
        if (null == mInstance) {
            throw new NullPointerException("The CatEyeSDKInterface is not init");
        }
        return mInstance;
    }

    public Context getContext() {
        return get().mContext;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onRequestSuccess() {

    }

    @Override
    public void onRequestError(String errorMsg, String methodName) {
        String errorMessage = "request method: [" + methodName + "] failed,errorMessage: " + errorMsg;
        Logger.ee(errorMessage);
        if (null != catEysListener) {
            catEysListener.onHttpRequestFailed(methodName, errorMessage);
        }
    }

    /**
     * @param catEysListener SDK所有事件监听回调
     */
    public void setCatEyeMessageListener(CatEysListener catEysListener) {
        this.catEysListener = catEysListener;
        mqttManager.setCallBack(catEysListener);
    }

    /**
     * 通过绑定手机号，注册app_uid
     *
     * @param phoneNumber 手机号码
     * @param verifyCode  短信验证码，默认6位， 限长6位
     * @param password    密文密码，Md5加密，限长32位
     * @param nickname    昵称, 限制长度为2-10位
     * @param email       邮件地址
     */
    public void bindPhoneNumber(String phoneNumber, String verifyCode, String password, String nickname, String email, BindPhoneView reqView) throws NoAttachViewException, NoInternetException {
        if (!COMAIOT) return;
        catEyeController.bindPhoneNumber(phoneNumber, verifyCode, password, nickname, email, reqView);
    }

    /**
     * APP查询账号信息
     *
     * @param type        [ password, phone, weixin, email ]  登录方式：密码或短信验证码或微信
     * @param email       邮件地址, 限长100位
     * @param phoneNumber 手机号码
     * @param weChatCode  应用发起微信认证请求后，返回的微信临时代号, 只能用一次
     * @see LoginType
     */
    public void queryAccount(String type, String email, String phoneNumber, String weChatCode, AppQueryAccountReqView reqView) throws NoAttachViewException, NoInternetException {
        if (!COMAIOT) return;
        catEyeController.AppQueryAccountReq(type, email, phoneNumber, weChatCode, reqView);
    }

    /**
     * 此方法不可与 [loginForPassword,loginForVerifyCode,loginForWeChat] 方法一起使用
     *
     * @param jwt     Json web token(是为了在网络应用环境间传递声明而执行的一种基于JSON的开放标准)
     * @param reqView 请求回调
     * @throws NoAttachViewException
     * @throws NoInternetException
     * @see AppSubscribeReqView
     */
    public void loginForJwt(String jwt, AppSubscribeReqView reqView) throws NoAttachViewException, NoInternetException, NotRegisterDeviceException {
        if (!CatEyePreferences.get().getRegisterStatus()) {
            throw new NotRegisterDeviceException();
        }
        String postUrl = "/api/v2/PartnerSubscribeReq";

        long timestamp = System.currentTimeMillis() / 1000;
        String nonce = StringUtils.get_bit_string(6);
        String sign = StringUtils.sign(sk, timestamp, nonce);
        CatEyeLoginParams params = new CatEyeLoginParams();
        params.setAppak(ak);
        params.setTimestamp(timestamp);
        params.setNonce(nonce);
        params.setSign(sign);
        params.setBrand(Build.BRAND);
        params.setType("Android");
        params.setJwt_token(jwt);
        params.setApp_uid(CatEyePreferences.get().getAppUid());
        params.setApp_envid(CatEyePreferences.get().getAppEnvid());
        String json = GsonUtils.toJson(params);

        Logger.dd("[loginForJwt] json: " + json);

        OkHttpUtils.getInstance(mContext).post(json, postUrl, new OkHttpCallback() {
            @Override
            public void onSuccess(JSONObject oriData) {
                try {
                    int errcode = oriData.getInt("errcode");
                    String errmsg = oriData.getString("errmsg");
                    if (errcode != 0 && null != catEysListener && null != reqView) {
                        catEysListener.onHttpRequestFailed("loginForJwt", "The Server is return " + errcode + " , errMsg is " + errmsg);
                        reqView.onRequestError("" + errcode, "loginForJwt");
                        return;
                    }

                    AppSubscribeEntity entity = new AppSubscribeEntity();
                    entity.setErrcode(errcode);
                    entity.setErrmsg(errmsg);

                    try {
                        JSONObject jsonObject = oriData.getJSONObject("content");
                        AppSubscribeEntity.Content content = new AppSubscribeEntity.Content();
                        content.setApp_envid(jsonObject.getString("app_envid"));
                        content.setApp_uid(jsonObject.getString("app_uid"));
                        content.setToken(jsonObject.getString("token"));
                        content.setExpire(jsonObject.getLong("expire"));

                        JSONObject mqttJsonObj = jsonObject.getJSONObject("mqtt");
                        AppSubscribeEntity.Mqtt mqtt = new AppSubscribeEntity.Mqtt();
                        mqtt.setIp(mqttJsonObj.getString("ip"));
                        mqtt.setPass(mqttJsonObj.getString("pass"));
                        mqtt.setPort(mqttJsonObj.getString("port"));
                        mqtt.setUser(mqttJsonObj.getString("user"));
                        content.setMqtt(mqtt);

                        entity.setContent(content);

                        if (null != reqView) {

                            String app_uid = entity.getContent().getApp_uid();
                            String app_envid = entity.getContent().getApp_envid();
                            String token = entity.getContent().getToken();
                            CatEyePreferences.get().saveAppUid(DESUtils.encryptString(app_uid));
                            CatEyePreferences.get().saveAppEnvid(DESUtils.encryptString(app_envid));
                            CatEyePreferences.get().saveToken(DESUtils.encryptString(token));

                            String clientId = app_uid + "-" + app_envid;
                            String host = entity.getContent().getMqtt().getIp();
                            String port = entity.getContent().getMqtt().getPort();
                            String user = entity.getContent().getMqtt().getUser();
                            String pwd = entity.getContent().getMqtt().getPass();

                            CatEyePreferences.get().saveMqttHost(host);
                            CatEyePreferences.get().saveMqttPort(port);
                            CatEyePreferences.get().saveMqttUser(user);
                            CatEyePreferences.get().saveMqttPass(pwd);

                            MqttManagerInter.getInstance(CatEyeSDKInterface.get().getContext()).connect(host, clientId, port, user, pwd);

                            reqView.onSubscribeSuccess(entity.getContent().getExpire());
                        }
                    } catch (Exception e) {
                        entity.setContent(new AppSubscribeEntity.Content());
                        if (null != reqView) {
                            reqView.onRequestError("" + entity.getErrcode(), "loginForJwt");
                        }
                        return;
                    }
                } catch (JSONException e) {
                    if (null != catEysListener) {
                        catEysListener.onHttpRequestFailed("loginForJwt", e.toString());
                    }
                }
            }

            @Override
            public void onFailure(Exception e) {
                if (null != catEysListener) {
                    catEysListener.onHttpRequestFailed("loginForJwt", e.toString());
                }
            }
        });
    }

    /**
     * 密码登录 此方法不可与 loginForJwt 方法一起使用[中国地区使用]
     *
     * @param phoneNumber 手机号
     * @param password    密文密码，Md5加密，限长32位
     * @param pushId      程序Push消息代号 , 限制长度为8-80位，可不传
     * @param reqView     请求回调
     * @throws NoAttachViewException
     * @throws NoInternetException
     * @see AppSubscribeReqView
     */
    public void loginForPassword(String phoneNumber, String password, String pushId, AppSubscribeReqView reqView) throws NoAttachViewException, NoInternetException {
        if (!COMAIOT) return;
        catEyeController.login(phoneNumber, password, pushId, LoginType.PASSWORD, null, null, null, reqView);
    }

    /**
     * 此方法不可与 loginForJwt 方法一起使用[中国地区使用]
     *
     * @param phoneNumber 手机号
     * @param verifyCode  短信验证码，默认6位， 限长6位
     * @param pushId      程序Push消息代号 , 限制长度为8-80位，可不传
     * @param reqView     请求回调
     * @throws NoAttachViewException
     * @throws NoInternetException
     * @see AppSubscribeReqView
     */
    public void loginForVerifyCode(String phoneNumber, String verifyCode, String pushId, AppSubscribeReqView reqView) throws NoAttachViewException, NoInternetException {
        if (!COMAIOT) return;
        catEyeController.login(phoneNumber, null, pushId, LoginType.PHONE, verifyCode, null, null, reqView);
    }

    /**
     * 此方法不可与 loginForJwt 方法一起使用[中国地区使用]
     *
     * @param phoneNumber 手机号
     * @param weChatCode  应用发起微信认证请求后，返回的微信临时代号, 只能用一次
     * @param pushId      程序Push消息代号 , 限制长度为8-80位，可不传
     * @param reqView     请求回调
     * @throws NoAttachViewException
     * @throws NoInternetException
     * @see AppSubscribeReqView
     */
    public void loginForWeChat(String phoneNumber, String weChatCode, String pushId, AppSubscribeReqView reqView) throws NoAttachViewException, NoInternetException {
        if (!COMAIOT) return;
        catEyeController.login(phoneNumber, null, pushId, LoginType.WECHAT, null, weChatCode, "APP", reqView);
    }

    /**
     * 此方法不可与 [loginForPassword,loginForVerifyCode,loginForWeChat,loginForJwt] 方法一起使用[非中国地区使用]
     *
     * @param email    邮箱
     * @param password 密文密码，Md5加密，限长32位
     * @param pushId   程序Push消息代号 , 限制长度为8-80位，可不传
     * @param reqView  请求回调
     * @throws NoAttachViewException
     * @throws NoInternetException
     * @see AppEmailSubScribeReqView
     */
    public void loginForEmail(String email, String password, String pushId, AppEmailSubScribeReqView reqView) throws NoAttachViewException, NoInternetException {
        if (!COMAIOT) return;
        catEyeController.loginEmail(email, password, pushId, reqView);
    }

    /**
     * 退出登录
     *
     * @param reqView 请求回调
     * @throws NoAttachViewException
     * @throws NoInternetException
     * @see AppUnSubscribeReqView
     */
    public void logOut(AppUnSubscribeReqView reqView) throws NoAttachViewException, NoInternetException {
        if (!COMAIOT) return;
        catEyeController.AppUnSubscribeReq(reqView);
    }

    /**
     * APP更新Token
     *
     * @param reqView 请求回调
     * @throws NoAttachViewException
     * @throws NoInternetException
     * @see AppRefreshTokenView
     */
    public void refreshToken(AppRefreshTokenView reqView) throws NoAttachViewException, NoInternetException {
        catEyeController.refreshToken(reqView);
    }

    /**
     * 修改APP账号密码
     *
     * @param oldPassword 密文密码，Md5加密，限长32位    老密码
     * @param newPassword 密文密码，Md5加密，限长32位    新密码
     * @param reqView     请求回调
     * @throws NoAttachViewException
     * @throws NoInternetException
     * @see AppChangePasswordReqView
     */
    public void changePassword(String oldPassword, String newPassword, AppChangePasswordReqView reqView) {
        if (!COMAIOT) return;
        catEyeController.AppChangePasswordReq(oldPassword, newPassword, reqView);
    }

    /**
     * 通过手机验证码重设APP密码
     *
     * @param phoneNumber 手机号码
     * @param verifyCode  短信验证码，默认6位， 限长6位
     * @param password    密文密码，Md5加密，限长32位 重设密码
     * @param reqView     请求回调
     * @throws NoAttachViewException
     * @throws NoInternetException
     * @see AppResetPasswordByPhoneReqView
     */
    public void resetPasswordByPhone(String phoneNumber, String verifyCode, String password, AppResetPasswordByPhoneReqView reqView) throws NoAttachViewException, NoInternetException {
        if (!COMAIOT) return;
        catEyeController.AppResetPasswordByPhoneReq(phoneNumber, verifyCode, password, reqView);
    }

    /**
     * 通过邮件验证码重设APP密码
     *
     * @param email      邮件地址
     * @param verifyCode 短信验证码，默认6位， 限长6位
     * @param password   密文密码，Md5加密，限长32位 重设密码
     * @param reqView    请求回调
     * @throws NoAttachViewException
     * @throws NoInternetException
     * @see AppResetPasswordByEmailReqView
     */
    public void resetPasswordByEmail(String email, String verifyCode, String password, AppResetPasswordByEmailReqView reqView) throws NoAttachViewException, NoInternetException {
        if (!COMAIOT) return;
        catEyeController.AppResetPasswordByEmailReq(email, verifyCode, password, reqView);
    }

    /**
     * 修改APP账号信息, 如email, nickName, pushId
     *
     * @param email    邮件地址, 限长100位
     * @param avatar   头像链接地址, URLEncode, 限长1000字节
     * @param pushId   程序Push消息代号 , 限制长度为8-80位，可不传
     * @param nickName 昵称, 限长20位
     * @param reqView  请求回调
     * @throws NoAttachViewException
     * @throws NoInternetException
     * @see AppChangeAccountInfoReqView
     */
    public void changeAccountInfo(String email, String avatar, String pushId, String nickName, AppChangeAccountInfoReqView reqView) throws NoAttachViewException, NoInternetException {
        if (!COMAIOT) return;
        catEyeController.AppChangeAccountInfoReq(email, avatar, pushId, nickName, reqView);
    }

    /**
     * 修改APP账号手机号码
     *
     * @param oldPhoneNumber 旧手机号码
     * @param oldVerifyCode  旧短信验证码，默认6位， 限长6位
     * @param newPhoneNumber 新手机号码
     * @param newVerifyCode  新短信验证码，默认6位， 限长6位
     * @param reqView        请求回调
     * @throws NoAttachViewException
     * @throws NoInternetException
     * @see AppChangePhoneReqView
     */
    public void changePhoneNumber(String oldPhoneNumber, String oldVerifyCode, String newPhoneNumber, String newVerifyCode, AppChangePhoneReqView reqView) throws NoAttachViewException, NoInternetException {
        if (!COMAIOT) return;
        catEyeController.AppChangePhoneReq(oldPhoneNumber, oldVerifyCode, newPhoneNumber, newVerifyCode, reqView);
    }

    /**
     * 绑定微信号
     *
     * @param phoneNumber 手机号码
     * @param verifyCode  短信验证码，默认6位， 限长6位
     * @param weChatCode  应用发起微信认证请求后，返回的微信临时代号, 只能用一次
     * @param reqView     请求回调
     * @throws NoAttachViewException
     * @throws NoInternetException
     * @see AppBindWeixinReqView
     */
    public void bindWeChat(String phoneNumber, String verifyCode, String weChatCode, AppBindWeixinReqView reqView) throws NoAttachViewException, NoInternetException {
        if (!COMAIOT) return;
        catEyeController.AppBindWeixinReq(phoneNumber, verifyCode, weChatCode, reqView);
    }

    /**
     * 通过绑定邮箱，注册app_uid
     *
     * @param email       邮件地址
     * @param verifyCode  短信验证码，默认6位， 限长6位
     * @param password    密文密码，Md5加密，限长32位
     * @param phoneNumber 手机号码,国外可以不输
     * @param nickName    昵称, 限制长度为2-10位
     * @param reqView     请求回调
     * @throws NoAttachViewException
     * @throws NoInternetException
     * @see AppBindEmailReqView
     */
    public void bindEmail(String email, String verifyCode, String password, String phoneNumber, String nickName, AppBindEmailReqView reqView) throws NoAttachViewException, NoInternetException {
        if (!COMAIOT) return;
        catEyeController.bindEmail(email, verifyCode, password, phoneNumber, nickName, reqView);
    }

    /**
     * 彻底删除APP账号
     *
     * @param reqView 请求回调
     * @throws NoAttachViewException
     * @throws NoInternetException
     * @see AppRemoveAccountReqView
     */
    public void removeAccount(AppRemoveAccountReqView reqView) throws NoAttachViewException, NoInternetException {
        if (!COMAIOT) return;
        catEyeController.removeAccount(reqView);
    }

    /**
     * 发送请求，APP申请AID
     *
     * @param reqView 请求回调
     * @throws NoAttachViewException
     * @throws NoInternetException
     * @see AppAidReqView
     */
    public void getAid(AppAidReqView reqView) throws NoAttachViewException, NoInternetException {
        catEyeController.AppAidReq(reqView);
    }

    /**
     * APP上传配置文件
     *
     * @param config  配置文件字串，urlencode 处理：=最长2048位字串
     * @param reqView 请求回调
     * @throws NoAttachViewException
     * @throws NoInternetException
     * @see AppUploadConfigReqView
     */
    public void uploadCustomConfig(String config, AppUploadConfigReqView reqView) throws NoAttachViewException, NoInternetException {
        if (!COMAIOT) return;
        catEyeController.uploadConfig(config, reqView);
    }

    /**
     * APP下载配置文件
     *
     * @param reqView 请求回调
     * @throws NoAttachViewException
     * @throws NoInternetException
     * @see AppDownloadConfigReqView
     */
    public void getCustomConfig(AppDownloadConfigReqView reqView) throws NoAttachViewException, NoInternetException {
        if (!COMAIOT) return;
        catEyeController.getConfig(reqView);
    }

    /**
     * APP用户发送删除设备请求，申请方是主控APP，删除所有针对此设备的映射关系；如果非设备主控APP，删除自身的app-dev映射
     *
     * @param aid     APP Access ID，APP绑定在不同设备下的标识ID：=8位字串
     * @param reqView 请求回调
     * @throws NoAttachViewException
     * @throws NoInternetException
     * @see AppRemoveAidReqView
     */
    public void deleteDevice(String aid, AppRemoveAidReqView reqView) throws NoAttachViewException, NoInternetException {
        catEyeController.AppRemoveAidReq(aid, reqView);
    }

    /**
     * APP用户发送删除设备共享用户请求，删除对此设备的共享关系（主控账号取消分享）
     *
     * @param removeAid APP Access ID，APP绑定在不同设备下的标识ID：=8位字串
     * @param reqView   请求回调
     * @throws NoAttachViewException
     * @throws NoInternetException
     * @see AppRemoveSharedDeviceReqView
     */
    public void removeSharedAccount(String removeAid, AppRemoveSharedDeviceReqView reqView) throws NoAttachViewException, NoInternetException {
        catEyeController.AppRemoveSharedDeviceReq(removeAid, reqView);
    }

    /**
     * APP下载设备的配置信息
     *
     * @param aid     APP Access ID，APP绑定在不同设备下的标识ID：=8位字串
     * @param devUid  设备标识 := 12位字串-8位字串
     * @param reqView 请求回调
     * @throws NoAttachViewException
     * @throws NoInternetException
     * @see AppDownloadDevConfigReqView
     */
    public void getDeviceConfig(String aid, String devUid, AppDownloadDevConfigReqView reqView) throws NoAttachViewException, NoInternetException {
        String postUrl = "/api/v2/AppDownloadDevConfigReq";

        AppDownloadDevConfigParams params = new AppDownloadDevConfigParams();
        params.setApp_uid(CatEyePreferences.get().getAppUid());
        params.setApp_envid(CatEyePreferences.get().getAppEnvid());
        params.setToken(CatEyePreferences.get().getToken());
        params.setApp_aid(aid);
        params.setDev_uid(devUid);
        String json = GsonUtils.toJson(params);

        Logger.dd("[getDeviceConfig] json: " + json);

        OkHttpUtils.getInstance(mContext).post(json, postUrl, new OkHttpCallback() {
            @Override
            public void onSuccess(JSONObject oriData) {
                try {
                    int errcode = oriData.getInt("errcode");
                    String errmsg = oriData.getString("errmsg");
                    if (errcode != 0 && null != catEysListener && null != reqView) {
                        catEysListener.onHttpRequestFailed("getDeviceConfig", "The Server is return " + errcode + " , errMsg is " + errmsg);
                        reqView.onRequestError("" + errcode, "getDeviceEventList");
                        return;
                    }

                    AppDownloadDevConfigEntity entity = new AppDownloadDevConfigEntity();
                    entity.setErrcode(errcode);
                    entity.setErrmsg(errmsg);

                    try {
                        JSONObject jsonObject = oriData.getJSONObject("content");

                        int num = jsonObject.getInt("num");
                        if (num > 0) {
                            JSONObject list = jsonObject.getJSONObject("list");

                            List<AppDownloadDevConfigEntity.Content> contents = new ArrayList<>();

                            Iterator<String> keys = list.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                JSONObject listJSONObject = list.getJSONObject(next);
                                AppDownloadDevConfigEntity.Content content = GsonUtils.fromJson(listJSONObject.toString(), AppDownloadDevConfigEntity.Content.class);
                                content.setSettings(GsonUtils.fromJson(new String(Base64.decode(content.getConfig(), Base64.NO_WRAP)), DeviceSvrCacheSettings.class));
                                contents.add(content);
                            }

                            entity.setContents(contents);
                        } else {
                            entity.setContents(new ArrayList<>());
                        }
                        if (null != reqView) {
                            reqView.onGetDeviceConfigSuccess(entity);
                        }
                    } catch (Exception e) {
                        entity.setContents(new ArrayList<>());
                        if (null != reqView) {
                            reqView.onGetDeviceConfigSuccess(entity);
                        }
                        return;
                    }
                } catch (JSONException e) {
                    if (null != catEysListener) {
                        catEysListener.onHttpRequestFailed("getDeviceConfig", e.toString());
                    }
                }
            }

            @Override
            public void onFailure(Exception e) {
                if (null != catEysListener) {
                    catEysListener.onHttpRequestFailed("getDeviceEventList", e.toString());
                }
            }
        });
    }

    /**
     * 查询设备端在线状态
     *
     * @param aid     APP Access ID，APP绑定在不同设备下的标识ID：=8位字串
     * @param devUid  设备标识 := 12位字串-8位字串
     * @param reqView 请求回调
     * @throws NoAttachViewException
     * @throws NoInternetException
     * @see AppQueryDevConnectReqView
     */
    public void queryDeviceConnect(String aid, String devUid, AppQueryDevConnectReqView reqView) throws NoAttachViewException, NoInternetException {
        catEyeController.queryDeviceConnectStatus(aid, devUid, reqView);
    }

    /**
     * APP 获取报警图片或视频等文件列表
     *
     * @param aid     APP Access ID，APP绑定在不同设备下的标识ID：=8位字串
     * @param devUid  设备标识 := 12位字串-8位字串
     * @param reqView 请求回调
     * @see AppDownloadFileReqView
     */
    public void getDeviceEventList(String aid, String devUid, long bindDate, AppDownloadFileReqView reqView) throws NoInternetException {
        if (!AppUtils.isHaveInternet(CatEyeSDKInterface.get().getContext())) {
            throw new NoInternetException();
        }

        String postUrl = "/api/v2/AppDownloadFileReq";

        AppDownloadFileParams params = new AppDownloadFileParams();
        params.setApp_uid(CatEyePreferences.get().getAppUid());
        params.setApp_envid(CatEyePreferences.get().getAppEnvid());
        params.setToken(CatEyePreferences.get().getToken());
        params.setApp_aid(aid);
        params.setTimestamp(bindDate);
        params.setDev_uid(devUid);
        String json = GsonUtils.toJson(params);

        Logger.dd("[getDeviceEventList] json: " + json);

        OkHttpUtils.getInstance(mContext).post(json, postUrl, new OkHttpCallback() {
            @Override
            public void onSuccess(JSONObject oriData) {
                try {
                    int errcode = oriData.getInt("errcode");
                    String errmsg = oriData.getString("errmsg");
                    if (errcode != 0 && null != catEysListener && null != reqView) {
                        catEysListener.onHttpRequestFailed("getDeviceEventList", "The Server is return " + errcode + " , errMsg is " + errmsg);
                        reqView.onRequestError("" + errcode, "getDeviceEventList");
                        return;
                    }
                    JSONObject jsonObject = oriData.getJSONObject("content");

                    int num = jsonObject.getInt("num");
                    int recordsLimit = jsonObject.getInt("RecordsLimit");
                    long timestamp_start = jsonObject.getLong("timestamp_start");
                    long timestamp_end = jsonObject.getLong("timestamp_end");

                    DeviceEventEntity eventEntity = new DeviceEventEntity();
                    eventEntity.setErrcode(errcode);
                    eventEntity.setErrmsg(errmsg);
                    eventEntity.setRecordsLimit(recordsLimit);
                    eventEntity.setTimestamp_start(timestamp_start);
                    eventEntity.setTimestamp_end(timestamp_end);
                    List<DeviceEventListEntity> listEntities = new ArrayList<>();

                    if (num > 0) {
                        JSONObject object = jsonObject.getJSONObject("list");
                        Iterator<String> keys = object.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            JSONObject objectJSONObject = object.getJSONObject(next);
                            DeviceEventListEntity entity = GsonUtils.fromJson(objectJSONObject.toString(), DeviceEventListEntity.class);
                            entity.setMsg_id(next);
                            listEntities.add(entity);
                        }
                    }

                    eventEntity.setListEntities(listEntities);
                    if (null != reqView) {
                        reqView.onGetEventList(eventEntity);
                    }
                } catch (JSONException e) {
                    if (null != catEysListener) {
                        catEysListener.onHttpRequestFailed("getDeviceEventList", e.toString());
                    }
                }
            }

            @Override
            public void onFailure(Exception e) {
                if (null != catEysListener) {
                    catEysListener.onHttpRequestFailed("getDeviceEventList", e.toString());
                }
            }
        });
    }

    /**
     * APP 获取账号下所有设备的图片或视频等文件列表,返回条数,起止时间等信息
     *
     * @param reqView 请求回调
     * @see AppDownloadFileReqView
     */
    public void getMultiDeviceEventList(AppDownloadFileReqView reqView) throws NoInternetException {
        if (!AppUtils.isHaveInternet(CatEyeSDKInterface.get().getContext())) {
            throw new NoInternetException();
        }

        String postUrl = "/api/v2/AppMultiDownloadFileReq";

        AppDownloadFileParams params = new AppDownloadFileParams();
        params.setApp_uid(CatEyePreferences.get().getAppUid());
        params.setApp_envid(CatEyePreferences.get().getAppEnvid());
        params.setToken(CatEyePreferences.get().getToken());
        params.setTimestamp(System.currentTimeMillis() / 1000);
        String json = GsonUtils.toJson(params);

        OkHttpUtils.getInstance(mContext).post(json, postUrl, new OkHttpCallback() {
            @Override
            public void onSuccess(JSONObject oriData) {
                try {
                    int errcode = oriData.getInt("errcode");
                    String errmsg = oriData.getString("errmsg");
                    if (errcode != 0 && null != catEysListener && null != reqView) {
                        catEysListener.onHttpRequestFailed("getMultiDeviceEventList", "The Server is return " + errcode + " , errMsg is " + errmsg);
                        reqView.onRequestError(errcode + "", "getDeviceEventList");
                        return;
                    }
                    JSONObject jsonObject = oriData.getJSONObject("content");
                    int recordsLimit = oriData.getInt("RecordsLimit");
                    long timestamp_start = oriData.getLong("timestamp_start");
                    long timestamp_end = oriData.getLong("timestamp_end");
                    int num = jsonObject.getInt("num");
                    JSONObject listObject = jsonObject.getJSONObject("list");
                    Iterator<String> keys = listObject.keys();

                    DeviceEventEntity eventEntity = new DeviceEventEntity();
                    eventEntity.setErrcode(errcode);
                    eventEntity.setErrmsg(errmsg);
                    eventEntity.setRecordsLimit(recordsLimit);
                    eventEntity.setTimestamp_start(timestamp_start);
                    eventEntity.setTimestamp_end(timestamp_end);
                    List<DeviceEventListEntity> listEntities = new ArrayList<>();

                    while (keys.hasNext()) {
                        String key = keys.next();
                        JSONObject beanObject = listObject.getJSONObject(key);
                        DeviceEventListEntity entity = GsonUtils.fromJson(beanObject.toString(), DeviceEventListEntity.class);
                        listEntities.add(entity);
                    }
                    eventEntity.setListEntities(listEntities);
                    if (null != reqView) {
                        reqView.onGetEventList(eventEntity);
                    }
                } catch (JSONException e) {
                    if (null != catEysListener) {
                        catEysListener.onHttpRequestFailed("getMultiDeviceEventList", e.toString());
                    }
                }
            }

            @Override
            public void onFailure(Exception e) {
                if (null != catEysListener) {
                    catEysListener.onHttpRequestFailed("getMultiDeviceEventList", e.toString());
                }
            }
        });
    }

    /**
     * 删除指定的图片消息
     *
     * @param aid     APP Access ID，APP绑定在不同设备下的标识ID：=8位字串
     * @param msgId   消息号
     * @param devUid  设备标识 := 12位字串-8位字串
     * @param reqView 请求回调
     * @see AppRemoveMessageReqView
     */
    public void deleteEvent(String aid, String msgId, String devUid, AppRemoveMessageReqView reqView) throws NoAttachViewException, NoInternetException {
        catEyeController.AppRemoveMessageReq(aid, msgId, devUid, reqView);
    }

    /**
     * APP 删除的图片消息列表
     *
     * @param reqView 请求回调
     * @see AppQueryRemovedMessagesReqView
     */
    public void getDeletedEventList(AppQueryRemovedMessagesReqView reqView) throws NoInternetException {
        if (!COMAIOT) return;
        if (!AppUtils.isHaveInternet(CatEyeSDKInterface.get().getContext())) {
            throw new NoInternetException();
        }
        String postUrl = "/api/v2/AppQueryRemovedMessagesReq";

        AppDownloadFileParams params = new AppDownloadFileParams();
        params.setApp_uid(CatEyePreferences.get().getAppUid());
        params.setApp_envid(CatEyePreferences.get().getAppEnvid());
        params.setToken(CatEyePreferences.get().getToken());
        String json = GsonUtils.toJson(params);

        OkHttpUtils.getInstance(mContext).post(json, postUrl, new OkHttpCallback() {
            @Override
            public void onSuccess(JSONObject oriData) {
                try {
                    int errcode = oriData.getInt("errcode");
                    String errmsg = oriData.getString("errmsg");
                    if (errcode != 0 && null != catEysListener && null != reqView) {
                        catEysListener.onHttpRequestFailed("getDeletedEventList", "The Server is return " + errcode + " , errMsg is " + errmsg);
                        reqView.onRequestError(+errcode + "", "getDeviceEventList");
                        return;
                    }
                    JSONObject jsonObject = oriData.getJSONObject("content");
                    int recordsLimit = oriData.getInt("RecordsLimit");
                    long timestamp_start = oriData.getLong("timestamp_start");
                    long timestamp_end = oriData.getLong("timestamp_end");
                    int num = jsonObject.getInt("num");
                    JSONObject listObject = jsonObject.getJSONObject("list");
                    Iterator<String> keys = listObject.keys();

                    AppQueryRemovedMessageEntity eventEntity = new AppQueryRemovedMessageEntity();
                    eventEntity.setErrcode(errcode);
                    eventEntity.setErrmsg(errmsg);
                    eventEntity.setRecordsLimit(recordsLimit);
                    eventEntity.setTimestamp_start(timestamp_start);
                    eventEntity.setTimestamp_end(timestamp_end);
                    List<AppQueryRemovedListEntity> listEntities = new ArrayList<>();

                    while (keys.hasNext()) {
                        String key = keys.next();
                        JSONObject beanObject = listObject.getJSONObject(key);
                        AppQueryRemovedListEntity entity = GsonUtils.fromJson(beanObject.toString(), AppQueryRemovedListEntity.class);
                        listEntities.add(entity);
                    }
                    eventEntity.setListEntities(listEntities);
                    if (null != reqView) {
                        reqView.onGetDeletedEventList(eventEntity);
                    }
                } catch (JSONException e) {
                    if (null != catEysListener) {
                        catEysListener.onHttpRequestFailed("getDeletedEventList", e.toString());
                    }
                }
            }

            @Override
            public void onFailure(Exception e) {
                if (null != catEysListener) {
                    catEysListener.onHttpRequestFailed("getDeletedEventList", e.toString());
                }
            }
        });
    }

    /**
     * APP申请设备绑定用二维码
     *
     * @param aid           APP Access ID，APP绑定在不同设备下的标识ID：=8位字串
     * @param countryCode   国家代码，如中国为86，美国为1
     * @param timeZone      时区，默认为中国，东八区： 8
     * @param ssid          WiFi网络的SSID，: = 字符串，限长度64位
     * @param ssid_password WiFi网络的密码，: = 字符串，限长度128位
     * @param reqView       请求回调
     * @throws NoAttachViewException
     * @throws NoInternetException
     * @see AppBarcodeReqView
     */
    public void createQrCode(String aid, String countryCode, int timeZone, String ssid, String ssid_password, AppBarcodeReqView reqView) throws NoAttachViewException, NoInternetException {
        catEyeController.AppBarcodeReq(aid, countryCode, timeZone, ssid, ssid_password, reqView);
    }

    /**
     * APP轮询查询AID是否绑定
     *
     * @param aid     APP Access ID，APP绑定在不同设备下的标识ID：=8位字串
     * @param reqView 请求回调
     * @throws NoAttachViewException
     * @throws NoInternetException
     * @see AppQueryAidBindRquView
     */
    public void queryBindStatus(String aid, AppQueryAidBindRquView reqView) throws NoAttachViewException, NoInternetException {
        catEyeController.AppQueryAidBindReq(aid, reqView);
    }

    /**
     * 主控Master APP发送生成分享设备二维码的请求，服务器返回分享二维码（带参数的Base64 URL）和8位分享数字字串
     *
     * @param aid     APP Access ID，APP绑定在不同设备下的标识ID：=8位字串
     * @param devUid  设备标识 := 12位字串-8位字串
     * @param reqView 请求回调
     * @throws NoAttachViewException
     * @throws NoInternetException
     * @see AppShareDeviceReqView
     */
    public void createShareDeviceQr(String aid, String devUid, AppShareDeviceReqView reqView) throws NoAttachViewException, NoInternetException {
        catEyeController.AppShareDeviceReq(aid, devUid, reqView);
    }

    /**
     * 从属Slave APP通过扫描主控分享的参数二维码或输入分享码的方式加入设备查看组
     *
     * @param shareNum   分享设备二维码时生成的数字分享码：=8位数字字串
     * @param shareToken 分享设备二维码时生成的Base64加密URL字串（带参数Share_token)：=限长2048位字串
     * @param reqView    请求回调
     * @throws NoAttachViewException
     * @throws NoInternetException
     * @see errorCode 300-AppID认证出错: AppID不存在, 或Token错误, 或Sign错误;
     * 1000-请求格式错误, 常见有: Json格式错误, 无参数, 参数类型,参数长度, 参数存在非法字符等;
     * 1100-数据库执行时出错, 请重新申请;
     * 1301-Share Token 不存在;
     * 1303-Share Token 过期;
     * 1501-同一个app_uid只能绑定一个 dev_uid.
     * @see AppReceiveShareReqView
     */
    public void joinScanShareDeviceQr(String shareNum, String shareToken, AppReceiveShareReqView reqView) throws NoAttachViewException, NoInternetException {
        if (!AppUtils.isHaveInternet(CatEyeSDKInterface.get().getContext())) {
            throw new NoInternetException();
        }
        String postUrl = "/api/v2/AppReceiveShareReq";

        if (shareNum == null && shareToken == null) {
            throw new RuntimeException("At least one way to share; shareNum or shareToken,but can't all empty.");
        }
        AppReceiveShareParams params = new AppReceiveShareParams();
        params.setApp_uid(CatEyePreferences.get().getAppUid());
        params.setApp_envid(CatEyePreferences.get().getAppEnvid());
        params.setToken(CatEyePreferences.get().getToken());

        if (shareNum == null && shareToken != null) {
            params.setReceive_type("barcode");
            params.setShare_token(shareToken);
        } else if (shareToken == null && shareNum != null) {
            params.setReceive_type("num");
            params.setShare_num(shareNum);
        } else if (shareNum != null && shareToken != null) {
            throw new RuntimeException("There can't be two kinds of sharing at the same time. set the shareNum or shareToken to NULL.");
        }

        String json = GsonUtils.toJson(params);

        OkHttpUtils.getInstance(mContext).post(json, postUrl, new OkHttpCallback() {
            @Override
            public void onSuccess(JSONObject oriData) {
                try {
                    int errcode = oriData.getInt("errcode");
                    String errmsg = oriData.getString("errmsg");
                    if (errcode != 0 && null != catEysListener && null != reqView) {
                        catEysListener.onHttpRequestFailed("joinScanShareDeviceQr", "The Server is return " + errcode + " , errMsg is " + errmsg);
                        reqView.onRequestError(errcode + "", "getDeviceEventList");
                        return;
                    }
                    AppReceiveShareEntity entity = new AppReceiveShareEntity();
                    entity.setErrmsg(errmsg);
                    entity.setErrcode(errcode);

                    try {
                        JSONObject jsonObject = oriData.getJSONObject("content");
                        AppReceiveShareEntity.Content content = new AppReceiveShareEntity.Content();

                        content.setDev_uid(jsonObject.getString("dev_uid"));
                        content.setAid(jsonObject.getString("aid"));
                        entity.setContent(content);

                        if (null != reqView && errcode == 0) {
                            reqView.onAppReceiveShareReqSuccess(entity);
                        }
                    } catch (Exception e) {
                        entity.setContent(new AppReceiveShareEntity.Content());
                        if (null != reqView && errcode == 0) {
                            reqView.onAppReceiveShareReqSuccess(entity);
                        } else {
                            reqView.onRequestError(errcode + "", "joinScanShareDeviceQr");
                        }
                    }
                } catch (JSONException e) {
                    if (null != catEysListener) {
                        catEysListener.onHttpRequestFailed("joinScanShareDeviceQr", e.toString());
                    }
                }
            }

            @Override
            public void onFailure(Exception e) {
                if (null != catEysListener) {
                    catEysListener.onHttpRequestFailed("getDeletedEventList", e.toString());
                }
            }
        });
    }

    /**
     * 查看绑定的设备列表 app_aid <=> dev_uid
     *
     * @param reqView 请求回调
     * @see AppQueryDeviceListReqView
     */
    public void queryDeviceList(AppQueryDeviceListReqView reqView) throws NoInternetException {
        if (!AppUtils.isHaveInternet(CatEyeSDKInterface.get().getContext())) {
            throw new NoInternetException();
        }

        String postUrl = "/api/v2/AppQueryDeviceListReq";

        AppDownloadFileParams params = new AppDownloadFileParams();
        params.setApp_uid(CatEyePreferences.get().getAppUid());
        params.setApp_envid(CatEyePreferences.get().getAppEnvid());
        params.setToken(CatEyePreferences.get().getToken());
        String json = GsonUtils.toJson(params);

        OkHttpUtils.getInstance(mContext).post(json, postUrl, new OkHttpCallback() {
            @Override
            public void onSuccess(JSONObject oriData) {
                try {
                    int errcode = oriData.getInt("errcode");
                    String errmsg = oriData.getString("errmsg");
                    if (errcode != 0 && null != catEysListener && null != reqView) {
                        catEysListener.onHttpRequestFailed("queryDeviceList", "The Server is return " + errcode + " , errMsg is " + errmsg);
                        reqView.onRequestError("" + errcode, "getDeviceEventList");
                        return;
                    }
                    JSONObject jsonObject = oriData.getJSONObject("content");
                    int recordsLimit = oriData.getInt("RecordsLimit");
                    long timestamp_start = oriData.getLong("timestamp_start");
                    long timestamp_end = oriData.getLong("timestamp_end");
                    int num = jsonObject.getInt("num");
                    JSONObject listObject = jsonObject.getJSONObject("list");
                    Iterator<String> keys = listObject.keys();

                    DeviceListEntity eventEntity = new DeviceListEntity();
                    eventEntity.setErrcode(errcode);
                    eventEntity.setErrmsg(errmsg);

                    List<Device> listEntities = new ArrayList<>();

                    while (keys.hasNext()) {
                        String key = keys.next();
                        JSONObject beanObject = listObject.getJSONObject(key);
                        Device device = GsonUtils.fromJson(beanObject.toString(), Device.class);
                        listEntities.add(device);
                    }
                    eventEntity.setListEntities(listEntities);
                    if (null != reqView) {
                        reqView.onGetDeviceList(eventEntity);
                    }
                } catch (JSONException e) {
                    if (null != catEysListener) {
                        catEysListener.onHttpRequestFailed("queryDeviceList", e.toString());
                    }
                }
            }

            @Override
            public void onFailure(Exception e) {
                if (null != catEysListener) {
                    catEysListener.onHttpRequestFailed("queryDeviceList", e.toString());
                }
            }
        });
    }

    /**
     * 查询分享的用户列表
     *
     * @param aid     APP Access ID，APP绑定在不同设备下的标识ID：=8位字串
     * @param reqView 请求回调
     * @throws NoAttachViewException
     * @throws NoInternetException
     * @see AppQuerySharedDeviceReqView
     */
    public void getShareDevice(String aid, AppQuerySharedDeviceReqView reqView) throws NoAttachViewException, NoInternetException {
        catEyeController.getShareDevice(aid, reqView);
    }

    /**
     * 启用或关闭微信推送
     *
     * @param weChatAccountid 微信服务号账号
     * @param weChatOpenid    微信用户Openid
     * @param weChatUnionid   微信用户Unionid
     * @param pushOnOff       1-On; !1-Off
     * @param reqView         请求回调
     * @throws NoAttachViewException
     * @throws NoInternetException
     * @see PartnerWeixinPushConfigReqView
     */
    public void setWeChatPush(String weChatAccountid, String weChatOpenid, String weChatUnionid, int pushOnOff, PartnerWeixinPushConfigReqView reqView) throws NoAttachViewException, NoInternetException {
        if (!COMAIOT) return;
        catEyeController.setWeChatPush(weChatAccountid, weChatOpenid, weChatUnionid, pushOnOff, reqView);
    }

    /**
     * 通知发送微信模板消息
     *
     * @param weixinAccountid  微信服务号账号
     * @param weChatOpenidList 微信用户Openid列表, 无空格，以逗号隔离
     * @param content          通知内容
     * @param reqView          请求回调
     * @throws NoAttachViewException
     * @throws NoInternetException
     * @see PartnerWeixinPushNoticeReqView
     */
    public void notificationWeChat(String weChatAccountid, String weChatOpenidList, String content, PartnerWeixinPushNoticeReqView reqView) throws NoAttachViewException, NoInternetException {
        if (!COMAIOT) return;
        catEyeController.notificationWeChat(weChatAccountid, weChatOpenidList, content, reqView);
    }

    /**
     * 将当前设备分享给手机号码所对应的账号。上传对方账号的phone_num, 当前账号的jwt_token, 分享设备
     *
     * @param devUid      设备标识 := 12位字串-8位字串
     * @param phoneNumber 分享手机号码
     * @param jwt         JWT Token字符串，长度1024位字串
     * @param reqView     请求回调
     * @throws NoAttachViewException
     * @throws NoInternetException
     * @see PartnerShareDeviceReqView
     */
    public void partNerShareDevice(String devUid, String phoneNumber, String jwt, PartnerShareDeviceReqView reqView) throws NoAttachViewException, NoInternetException {
        catEyeController.PartnerShareDeviceReq(devUid, phoneNumber, jwt, reqView);
    }

    /**
     * 变更当前账号下的手机号码。上传新的phone_num, 当前账号的jwt_token, 变更到新的手机号码
     *
     * @param newPhoneNumber 新的手机号码
     * @param jwt            JWT Token字符串，长度1024位字串
     * @param reqView        请求回调
     * @throws NoAttachViewException
     * @throws NoInternetException
     * @see PartnerChangePhoneReqView
     */
    public void partNerChangePhoneNumber(String newPhoneNumber, String jwt, PartnerChangePhoneReqView reqView) throws NoAttachViewException, NoInternetException {
        catEyeController.PartnerChangePhoneReq(newPhoneNumber, jwt, reqView);
    }

    /**
     * 查询当前账号下的设备列表
     *
     * @param reqView 请求回调
     * @throws NoInternetException
     * @see PartNerQueryDeviceListReqView
     */
    public void partNerGetDeviceList(PartNerQueryDeviceListReqView reqView) throws NoInternetException {
        if (!AppUtils.isHaveInternet(CatEyeSDKInterface.get().getContext())) {
            throw new NoInternetException();
        }

        String postUrl = "/api/v2/PartnerQueryDeviceListReq";

        AppRemoveAccountParams params = new AppRemoveAccountParams();
        params.setApp_uid(CatEyePreferences.get().getAppUid());
        params.setApp_envid(CatEyePreferences.get().getAppEnvid());
        params.setToken(CatEyePreferences.get().getToken());
        String json = GsonUtils.toJson(params);

        OkHttpUtils.getInstance(mContext).post(json, postUrl, new OkHttpCallback() {
            @Override
            public void onSuccess(JSONObject oriData) {
                try {
                    int errcode = oriData.getInt("errcode");
                    String errmsg = oriData.getString("errmsg");
                    if (errcode != 0 && null != catEysListener && null != reqView) {
                        catEysListener.onHttpRequestFailed("partNerGetDeviceList", "The Server is return " + errcode + " , errMsg is " + errmsg);
                        reqView.onRequestError("" + errcode, "getDeviceEventList");
                        return;
                    }
                    JSONObject jsonObject = oriData.getJSONObject("content");

                    int num = jsonObject.getInt("num");

                    PartNerQueryDeviceEntity eventEntity = new PartNerQueryDeviceEntity();
                    eventEntity.setErrcode(errcode);
                    eventEntity.setErrmsg(errmsg);
                    List<PartNerQueryDevice> listEntities = new ArrayList<>();

                    if (num > 0) {
                        JSONObject listObject = jsonObject.getJSONObject("list");
                        Iterator<String> keys = listObject.keys();


                        while (keys.hasNext()) {
                            String key = keys.next();
                            JSONObject beanObject = listObject.getJSONObject(key);
                            PartNerQueryDevice partNerQueryDevice = GsonUtils.fromJson(beanObject.toString(), PartNerQueryDevice.class);
                            listEntities.add(partNerQueryDevice);
                        }
                    }
                    eventEntity.setListEntities(listEntities);

                    if (null != reqView) {
                        reqView.onGetPartnerDeviceList(eventEntity);
                    }
                } catch (JSONException e) {
                    if (null != catEysListener) {
                        catEysListener.onHttpRequestFailed("partNerGetDeviceList", e.toString());
                    }
                }
            }

            @Override
            public void onFailure(Exception e) {
                if (null != catEysListener) {
                    catEysListener.onHttpRequestFailed("partNerGetDeviceList", e.toString());
                }
            }
        });
    }

    /**
     * 发送短信息给指定用户
     *
     * @param phoneNumber 手机号码
     * @param signName    短信签名:= 12位字串  example: 云控慧联
     * @param reqView     请求回调
     * @throws NoAttachViewException
     * @throws NoInternetException
     * @see SmsTokenReqView
     */
    public void sendSms(String phoneNumber, String signName, SmsTokenReqView reqView) throws NoAttachViewException, NoInternetException {
        if (!COMAIOT) return;
        catEyeController.smsToPhone(phoneNumber, signName, reqView);
    }

    /**
     * 发验证码到指定邮箱
     *
     * @param email   邮件地址
     * @param reqView 请求回调
     * @throws NoAttachViewException
     * @throws NoInternetException
     * @see EmailTokenReqView
     */
    public void sendEmail(String email, EmailTokenReqView reqView) throws NoAttachViewException, NoInternetException {
        if (!COMAIOT) return;
        catEyeController.sendEmail(email, reqView);
    }

    /**
     * 获取国家代码及服务器列表
     *
     * @param reqView 请求回调
     * @throws NoInternetException
     * @see QueryCountryCodeReqView
     */
    public void getCountryCodeList(QueryCountryCodeReqView reqView) throws NoInternetException {
        if (!AppUtils.isHaveInternet(CatEyeSDKInterface.get().getContext())) {
            throw new NoInternetException();
        }

        String postUrl = "/api/v2/QueryCountryCodeReq";

        String json = "{\"timestamp\":" + System.currentTimeMillis() / 1000 + "}";

        OkHttpUtils.getInstance(mContext).post(json, postUrl, new OkHttpCallback() {
            @Override
            public void onSuccess(JSONObject oriData) {
                try {
                    int errcode = oriData.getInt("errcode");
                    String errmsg = oriData.getString("errmsg");
                    if (errcode != 0 && null != catEysListener && null != reqView) {
                        catEysListener.onHttpRequestFailed("getCountryCodeList", "The Server is return " + errcode + " , errMsg is " + errmsg);
                        reqView.onRequestError("" + errcode, "getDeviceEventList");
                        return;
                    }
                    JSONObject jsonObject = oriData.getJSONObject("content");

                    QueryCountryCodeEntity.Content content = new QueryCountryCodeEntity.Content();

                    boolean updated = jsonObject.getBoolean("updated");
                    content.setUpdated(updated);
                    JSONObject countryCodeObject = jsonObject.getJSONObject("country_code");

                    QueryCountryCodeEntity.CountryCode countryCode = new QueryCountryCodeEntity.CountryCode();

                    String version = countryCodeObject.getString("version");
                    countryCode.setVersion(version);
                    long lastUpdate = countryCodeObject.getLong("last_update");
                    countryCode.setLast_update(lastUpdate);
                    JSONArray serverList = countryCodeObject.getJSONArray("server_list");
                    if (null != serverList) {
                        String[] strings = new String[serverList.length()];
                        List<QueryCountryCodeEntity.Server> servers = new ArrayList<>();
                        for (int i = 0; i < serverList.length(); i++) {
                            String svr = serverList.get(i).toString();
                            strings[i] = svr;

                            QueryCountryCodeEntity.Server server = new QueryCountryCodeEntity.Server();
                            JSONObject svrJsonObject = countryCodeObject.getJSONObject(svr);
                            String urlPath = svrJsonObject.getString("url_path");
                            server.setUrl_path(urlPath);
                            JSONArray countryCodeObjectJSONArray = countryCodeObject.getJSONArray("country_code");

                            if (null != countryCodeObjectJSONArray) {
                                String[] counryCodeArray = new String[countryCodeObjectJSONArray.length()];

                                for (int j = 0; j < countryCodeObjectJSONArray.length(); j++) {
                                    counryCodeArray[j] = countryCodeObjectJSONArray.get(j).toString();
                                }
                                server.setCountry_code(counryCodeArray);
                            }

                            servers.add(server);
                        }

                        countryCode.setServer_list(strings);
                        countryCode.setServerList(servers);
                    }
                    content.setCountry_code(countryCode);


                    QueryCountryCodeEntity eventEntity = new QueryCountryCodeEntity();
                    eventEntity.setErrcode(errcode);
                    eventEntity.setErrmsg(errmsg);
                    eventEntity.setContent(content);

                    if (null != reqView) {
                        reqView.onQueryCountryCode(eventEntity);
                    }
                } catch (JSONException e) {
                    if (null != catEysListener) {
                        catEysListener.onHttpRequestFailed("getCountryCodeList", e.toString());
                    }
                }
            }

            @Override
            public void onFailure(Exception e) {
                if (null != catEysListener) {
                    catEysListener.onHttpRequestFailed("getCountryCodeList", e.toString());
                }
            }
        });
    }

    /**
     * APP查询Push账号信息
     *
     * @param reqView 请求回调
     * @throws NoAttachViewException
     * @throws NoInternetException
     * @see AppQueryPushAccountReqView
     */
    public void queryPushAccount(AppQueryPushAccountReqView reqView) throws NoAttachViewException, NoInternetException {
        catEyeController.AppQueryPushAccountReq(reqView);
    }

    /**
     * 远程查看音视频
     *
     * @param devUid 设备的devUid
     */
    public void openDeviceVideo(String devUid) {
        String topic = MqttUtils.getAppPubAllTopic(devUid);
        CmdInfo cmdInfo = new CmdInfo();
        cmdInfo.setCmd("open_video");
        cmdInfo.setDevUid(devUid);
        cmdInfo.setCreateTime(System.currentTimeMillis());
        String json = GsonUtils.toJson(cmdInfo);
        mqttManager.publish(topic, json, false, 2);
    }

    public void reportAudio(String devUid) {
        String topic = MqttUtils.getAppPubAllTopic(devUid);
        AppControlDevice controlDevice = new AppControlDevice();
        controlDevice.setControl_type(4);
        controlDevice.setCmd("control_device");
        String json = GsonUtils.toJson(controlDevice);
        mqttManager.publish(topic, json, false, 2);
    }

    /**
     * 重启设备
     *
     * @param devUid 设备的devUid
     */
    public void restartDevice(String devUid) {
        String topic = MqttUtils.getAppPubAllTopic(devUid);
        DeviceRestartEvent restartEvent = new DeviceRestartEvent();
        restartEvent.setCmd("reset");
        restartEvent.setCreateTime(System.currentTimeMillis());
        String json = GsonUtils.toJson(restartEvent);
        mqttManager.publish(topic, json, false, 2);
    }

    /**
     * 获取设备属性
     *
     * @param devUid 设备的devUid
     */
    public void getDeviceSettings(String devUid) {
        String topic = MqttUtils.getAppPubAllTopic(devUid);
        DeviceSettings deviceSettings = new DeviceSettings();
        deviceSettings.setCmd("get_device_status");
        String json = GsonUtils.toJson(deviceSettings);
        mqttManager.publish(topic, json, false, 2);
    }

    /**
     * 检查设备版本更新
     *
     * @param devUid 设备的devUid
     */
    public void checkDeviceVersion(String devUid) {
        String topic = MqttUtils.getAppPubAllTopic(devUid);
        DeviceSettings deviceSettings = new DeviceSettings();
        deviceSettings.setCmd("UpdateDevice");
        String json = GsonUtils.toJson(deviceSettings);
        mqttManager.publish(topic, json, false, 2);
    }

    /**
     * 确认设备版本更新
     *
     * @param devUid 设备的devUid
     */
    public void confirmDeviceUpdate(String devUid) {
        String topic = MqttUtils.getAppPubAllTopic(devUid);
        DeviceSettings deviceSettings = new DeviceSettings();
        deviceSettings.setCmd("ConfirmUpdateDevice");
        String json = GsonUtils.toJson(deviceSettings);
        mqttManager.publish(topic, json, false, 2);
    }

    /**
     * 设置设备属性
     *
     * @param devUid         设备的devUid
     * @param deviceSettings 设备属性的类
     * @see DeviceSettings
     */
    public void settingDevice(String devUid, DeviceSettings deviceSettings) {

        SetDeviceSettingEntity entity = new SetDeviceSettingEntity();
        entity.setCmd("set_device_setting");

        DeviceStatusChangeEntity.Ring ring = new DeviceStatusChangeEntity.Ring();
        ring.setIndex(deviceSettings.getRing());
        ring.setSound(deviceSettings.getSound());
        entity.setRing(ring);

        DeviceSettings.Person_Check personCheck = new DeviceSettings.Person_Check();
        personCheck.setAlarm_interval_num(deviceSettings.getPerson_check().get_alarm_interval_num());
        personCheck.setAlarm_mode(deviceSettings.getPerson_check().getAlarm_mode());
        personCheck.setAuto_pic(deviceSettings.getPerson_check().getAuto_pic());
        personCheck.setOut_door_alarm(deviceSettings.getPerson_check().getOut_door_alarm());
        personCheck.setOut_door_ring(deviceSettings.getPerson_check().getOut_door_ring());
        personCheck.setOut_door_sound(deviceSettings.getPerson_check().getOut_door_sound());
        personCheck.setOutside_alarm_switch(deviceSettings.getPerson_check().geOutside_alarm_switch());
        personCheck.setRing_light_switch(deviceSettings.getPerson_check().getRing_light_switch());
        personCheck.setSensitive(deviceSettings.getPerson_check().getSensitive());
        personCheck.setSwitch_check(deviceSettings.getPerson_check().getSwitch_check());
        personCheck.setTack_pic_num(deviceSettings.getPerson_check().getTack_pic_num());
        entity.setPerson_check(personCheck);

        entity.setCallAlarmStatus(deviceSettings.getCallAlarmStatus());
        entity.setDeviceNickName(deviceSettings.getDeviceNickName());
        entity.setIntelligentNight(deviceSettings.getIntelligentNight());

        entity.setCustomJsonContent(deviceSettings.getCustomJsonContent());

        String topic = MqttUtils.getAppPubAllTopic(devUid);
        String json = GsonUtils.toJson(entity);

        Logger.dd("[settingDevice] jsonStr: " + json);

        mqttManager.publish(topic, json, false, 2);
    }

    /**
     * 查询设备的在线状态 两次请求时间间隔必须>=150
     *
     * @param devUid 设备的devUid
     */
    public void queryDeviceOnline(String devUid) {
        String topic = MqttUtils.getAppPubAllTopic(devUid);
        DeviceOnlineEvent deviceSettings = new DeviceOnlineEvent();
        deviceSettings.setCmd("queryOnline");
        String json = GsonUtils.toJson(deviceSettings);
        mqttManager.publish(topic, json, false, 2);
    }

    /**
     * 切换设备的工作模式    [0-2]
     *
     * @param devUid
     * @param work_Mode 0省电模式 1标准模式 2智能省电模式 晚10点-早7点休眠
     */
    public void switchDeviceWorkMode(String devUid, int work_Mode) {
        String topic = MqttUtils.getAppPubAllTopic(devUid);
        if (work_Mode < 0 || work_Mode > 2) return;
        DeviceWorkModeChangeEvent event = new DeviceWorkModeChangeEvent();
        event.setCmd("set_device_work_mode");
        event.setWorkMode(work_Mode);
        String json = GsonUtils.toJson(event);
        mqttManager.publish(topic, json, false, 2);
    }

    /**
     * 掉线重连消息通道
     */
    public void reconnectSocket() {
        if (null != mqttManager) {
            mqttManager.reconnect();
        }
    }

    /**
     * 订阅已绑定设备的事件消息通道
     *
     * @param devUids  已绑定设备的devUid数组
     * @param listener 订阅结果回调
     */
    public void subscribe(String[] devUids, IMqttActionListener listener) {
        if (null == devUids || devUids.length == 0) {
            Logger.dd("[subscribe] but devUids is empty.");
            return;
        }
        String[] topics = new String[devUids.length];
        int[] qoss = new int[devUids.length];
        for (int i = 0; i < devUids.length; i++) {
            topics[i] = MqttUtils.getAppSubTopic(devUids[i]);
            qoss[i] = 2;
        }

        Logger.dd("topics: " + Arrays.toString(topics));
        Logger.dd("qoss: " + Arrays.toString(qoss));

        if (null != mqttManager) {
            mqttManager.unSubscribeMsgWithCallback(topics, new IMqttActionListener() {
                @Override
                public void onSuccess(IMqttToken asyncActionToken) {
                    Logger.dd("unSubscribe topics success");
                    mqttManager.subscribeMsgWithCallback(topics, qoss, listener);
                }

                @Override
                public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                    Logger.dd("unSubscribe topics failure");
                    mqttManager.subscribeMsgWithCallback(topics, qoss, listener);
                }
            });
        }
    }

    public Map<String, DeviceSettings> getCacheMap() {
        return mDeviceSettingsMap;
    }

    /**
     * @return SDK的消息通道是否连接
     */
    public boolean isSDKConnected() {
        boolean ret = false;        //默认不在线
        if (null != mqttManager) {
            ret = mqttManager.isConnected();
        }

        return ret;
    }
}

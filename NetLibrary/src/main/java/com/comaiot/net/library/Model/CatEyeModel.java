package com.comaiot.net.library.Model;

import android.content.Context;
import android.util.Log;

import com.comaiot.net.library.bean.ArogaBean;
import com.comaiot.net.library.core.CatEyeSDKInterface;
import com.comaiot.net.library.core.MqttManagerInter;
import com.comaiot.net.library.inter.CallBack;
import com.comaiot.net.library.inter.RetrofitUtil;
import com.comaiot.net.library.bean.AppAidEntity;
import com.comaiot.net.library.bean.AppBarcodeReqEntity;
import com.comaiot.net.library.bean.AppBindEmailEntity;
import com.comaiot.net.library.bean.AppBindWeixinEntity;
import com.comaiot.net.library.bean.AppChangeAccountInfoEntity;
import com.comaiot.net.library.bean.AppChangePasswordEntity;
import com.comaiot.net.library.bean.AppChangePhoneEntity;
import com.comaiot.net.library.bean.AppDownloadConfigEntity;
import com.comaiot.net.library.bean.AppQueryAccountEntity;
import com.comaiot.net.library.bean.AppQueryAidBindEntity;
import com.comaiot.net.library.bean.AppQueryDevConnectEntity;
import com.comaiot.net.library.bean.AppQueryPushAccountEntity;
import com.comaiot.net.library.bean.AppQuerySharedDeviceEntity;
import com.comaiot.net.library.bean.AppReceiveShareEntity;
import com.comaiot.net.library.bean.AppRefreshTokenEntity;
import com.comaiot.net.library.bean.AppRemoveAccountEntity;
import com.comaiot.net.library.bean.AppRemoveAidEntity;
import com.comaiot.net.library.bean.AppRemoveMessageEntity;
import com.comaiot.net.library.bean.AppRemoveSharedDeviceEntity;
import com.comaiot.net.library.bean.AppResetPasswordByEmailEntity;
import com.comaiot.net.library.bean.AppResetPasswordByPhoneEntity;
import com.comaiot.net.library.bean.AppShareDeviceEntity;
import com.comaiot.net.library.bean.AppSubscribeEntity;
import com.comaiot.net.library.bean.AppUnSubscribeEntity;
import com.comaiot.net.library.bean.AppUploadConfigEntity;
import com.comaiot.net.library.bean.BindPhoneEntity;
import com.comaiot.net.library.bean.EmailTokenEntity;
import com.comaiot.net.library.bean.PartnerChangePhoneEntity;
import com.comaiot.net.library.bean.PartnerShareDeviceEntity;
import com.comaiot.net.library.bean.PartnerWeixinPushConfigEntity;
import com.comaiot.net.library.bean.PartnerWeixinPushNoticeEntity;
import com.comaiot.net.library.bean.RegEntity;
import com.comaiot.net.library.bean.SmsEntity;
import com.comaiot.net.library.bean.StorageEntity;
import com.comaiot.net.library.prfs.GeneralPreferences;
import com.comaiot.net.library.prfs.CatEyePreferences;
import com.comaiot.net.library.req_params.AppDownloadDevConfigEntity;
import com.comaiot.net.library.utils.Logger;

import rx.Subscriber;

public class CatEyeModel {

    public static void AppReg(String countryCode) {
        //上传密钥
        Subscriber<RegEntity> mEntitySubscriber = new Subscriber<RegEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                Logger.ee("[AppReg] start ");
            }

            @Override
            public void onCompleted() {
                Logger.ee("[AppReg] completed ");
            }

            @Override
            public void onError(Throwable e) {
                Logger.ee("[AppReg] failed " + e.toString());
            }

            @Override
            public void onNext(RegEntity baseEntity) {
                Logger.ee("[AppReg] Next " + baseEntity);
                if (baseEntity.getErrcode() != 0) {
                    Logger.ee("[AppReg] failed errCode: " + baseEntity.getErrcode());
                } else {
                    String app_envid = baseEntity.getContent().getApp_envid();
                    String app_uid = baseEntity.getContent().getApp_uid();
                    app_uid = DESUtils.encryptString(app_uid);
                    app_envid = DESUtils.encryptString(app_envid);
                    CatEyePreferences.get().saveAppEnvid(app_envid);
                    CatEyePreferences.get().saveAppUid(app_uid);

                    CatEyePreferences.get().setRegisterDeviceStatus(true);
                }
            }
        };
        RetrofitUtil.getInstance().AppReg(countryCode, mEntitySubscriber);
    }

    public static void bindPhone(String phone_num, String verify_code, String password, String nickname, String email, CallBack<BindPhoneEntity> callBack) {
        if (!CatEyeSDKInterface.COMAIOT) return;
        //绑定手机号
        Subscriber<BindPhoneEntity> mEntitySubscriber = new Subscriber<BindPhoneEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(BindPhoneEntity baseEntity) {
                if (baseEntity.getErrcode() != 0) {
                    callBack.onError(baseEntity.getErrcode() + "");
                    callBack.onComplete();
                } else {
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().bindPhone(mEntitySubscriber, phone_num, verify_code, password, nickname, email);
    }

    public static void AppQueryAccountReq(String type, String email, String phoneNumber, String weChatCode, CallBack<AppQueryAccountEntity> callBack) {
        if (!CatEyeSDKInterface.COMAIOT) return;
        Subscriber<AppQueryAccountEntity> mEntitySubscriber = new Subscriber<AppQueryAccountEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(AppQueryAccountEntity baseEntity) {
                if (baseEntity.getErrcode() != 0) {
                    Logger.ee("AppQueryAccountReq baseEntity.getErrcode(): \n" + baseEntity.getErrcode());
                    callBack.onError(baseEntity.getErrcode() + "");
                    callBack.onComplete();
                } else {
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().AppQueryAccountReq(mEntitySubscriber, type, email, phoneNumber, weChatCode);
    }

    public static void login(String phoneNumber, String password, String pushId, String subscribeType, String verify_code, String weixin_code, String weixin_type, CallBack<AppSubscribeEntity> callBack) {
        if (!CatEyeSDKInterface.COMAIOT) return;
        Subscriber<AppSubscribeEntity> mEntitySubscriber = new Subscriber<AppSubscribeEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                String eMessage = e.getMessage();
                callBack.onError(eMessage);
                callBack.onComplete();
                Logger.ee("[login" + subscribeType + "] failed" + eMessage);
            }

            @Override
            public void onNext(AppSubscribeEntity baseEntity) {
                Logger.dd("[login" + subscribeType + "] success" + baseEntity.toString());
                if (baseEntity.getErrcode() != 0) {
                    callBack.onError(baseEntity.getErrcode() + "");
                    callBack.onComplete();
                } else {
                    String app_uid = baseEntity.getContent().getApp_uid();
                    String app_envid = baseEntity.getContent().getApp_envid();
                    String token = baseEntity.getContent().getToken();
                    CatEyePreferences.get().saveAppUid(DESUtils.encryptString(app_uid));
                    CatEyePreferences.get().saveAppEnvid(DESUtils.encryptString(app_envid));
                    CatEyePreferences.get().saveToken(DESUtils.encryptString(token));

                    String clientId = app_uid + "-" + app_envid;
                    String host = baseEntity.getContent().getMqtt().getIp();
                    String port = baseEntity.getContent().getMqtt().getPort();
                    String user = baseEntity.getContent().getMqtt().getUser();
                    String pwd = baseEntity.getContent().getMqtt().getPass();

                    CatEyePreferences.get().saveMqttHost(host);
                    CatEyePreferences.get().saveMqttPort(port);
                    CatEyePreferences.get().saveMqttUser(user);
                    CatEyePreferences.get().saveMqttPass(pwd);

                    MqttManagerInter.getInstance(CatEyeSDKInterface.get().getContext()).connect(host, clientId, port, user, pwd);
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().login(mEntitySubscriber, phoneNumber, password, pushId, subscribeType, verify_code, weixin_code, weixin_type);
    }

    public static void loginEmail(String email, String password, String pushId, CallBack<AppSubscribeEntity> callBack) {
        if (!CatEyeSDKInterface.COMAIOT) return;
        Subscriber<AppSubscribeEntity> mEntitySubscriber = new Subscriber<AppSubscribeEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                String eMessage = e.getMessage();
                callBack.onError(eMessage);
                callBack.onComplete();
                Logger.ee("[loginEmail]" + " failed" + eMessage);
            }

            @Override
            public void onNext(AppSubscribeEntity baseEntity) {
                Logger.dd("[loginEmail] success" + baseEntity.toString());
                if (baseEntity.getErrcode() != 0) {
                    callBack.onError(baseEntity.getErrcode() + "");
                    callBack.onComplete();
                } else {
                    String app_uid = baseEntity.getContent().getApp_uid();
                    String app_envid = baseEntity.getContent().getApp_envid();
                    String token = baseEntity.getContent().getToken();
                    CatEyePreferences.get().saveAppUid(DESUtils.encryptString(app_uid));
                    CatEyePreferences.get().saveAppEnvid(DESUtils.encryptString(app_envid));
                    CatEyePreferences.get().saveToken(DESUtils.encryptString(token));

                    String clientId = app_uid + "-" + app_envid;
                    String host = baseEntity.getContent().getMqtt().getIp();
                    String port = baseEntity.getContent().getMqtt().getPort();
                    String user = baseEntity.getContent().getMqtt().getUser();
                    String pwd = baseEntity.getContent().getMqtt().getPass();

                    CatEyePreferences.get().saveMqttHost(host);
                    CatEyePreferences.get().saveMqttPort(port);
                    CatEyePreferences.get().saveMqttUser(user);
                    CatEyePreferences.get().saveMqttPass(pwd);

                    MqttManagerInter.getInstance(CatEyeSDKInterface.get().getContext()).connect(host, clientId, port, user, pwd);
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().loginEmail(mEntitySubscriber, email, password, pushId);
    }

    public static void AppUnSubscribeReq(CallBack<AppUnSubscribeEntity> callBack) {
        if (!CatEyeSDKInterface.COMAIOT) return;
        Subscriber<AppUnSubscribeEntity> mEntitySubscriber = new Subscriber<AppUnSubscribeEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(AppUnSubscribeEntity baseEntity) {
                if (baseEntity.getErrcode() != 0) {
                    callBack.onError(baseEntity.getErrcode() + "");
                    callBack.onComplete();
                } else {
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().AppUnSubscribeReq(mEntitySubscriber);
    }

    public static void refreshToken(CallBack<AppRefreshTokenEntity> callBack) {
        Subscriber<AppRefreshTokenEntity> mEntitySubscriber = new Subscriber<AppRefreshTokenEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(AppRefreshTokenEntity baseEntity) {
                if (baseEntity.getErrcode() != 0) {
                    callBack.onError(baseEntity.getErrcode() + "");
                    callBack.onComplete();
                } else {
                    String app_uid = baseEntity.getContent().getApp_uid();
                    String app_envid = baseEntity.getContent().getApp_envid();
                    String token = baseEntity.getContent().getToken();
                    CatEyePreferences.get().saveAppUid(DESUtils.encryptString(app_uid));
                    CatEyePreferences.get().saveAppEnvid(DESUtils.encryptString(app_envid));
                    CatEyePreferences.get().saveToken(DESUtils.encryptString(token));

                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().refreshToken(mEntitySubscriber);
    }

    public static void AppChangePasswordReq(String old_password, String new_password, CallBack<AppChangePasswordEntity> callBack) {
        if (!CatEyeSDKInterface.COMAIOT) return;
        Subscriber<AppChangePasswordEntity> mEntitySubscriber = new Subscriber<AppChangePasswordEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(AppChangePasswordEntity baseEntity) {
                if (baseEntity.getErrcode() != 0) {
                    callBack.onError(baseEntity.getErrcode() + "");
                    callBack.onComplete();
                } else {
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().AppChangePasswordReq(mEntitySubscriber, old_password, new_password);
    }

    public static void AppResetPasswordByPhoneReq(String phone_num, String verify_code, String password, CallBack<AppResetPasswordByPhoneEntity> callBack) {
        if (!CatEyeSDKInterface.COMAIOT) return;
        Subscriber<AppResetPasswordByPhoneEntity> mEntitySubscriber = new Subscriber<AppResetPasswordByPhoneEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(AppResetPasswordByPhoneEntity baseEntity) {
                if (baseEntity.getErrcode() != 0) {
                    callBack.onError(baseEntity.getErrcode() + "");
                    callBack.onComplete();
                } else {
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().AppResetPasswordByPhoneReq(mEntitySubscriber, phone_num, verify_code, password);
    }

    public static void AppResetPasswordByEmailReq(String phone_num, String verify_code, String password, CallBack<AppResetPasswordByEmailEntity> callBack) {
        if (!CatEyeSDKInterface.COMAIOT) return;
        Subscriber<AppResetPasswordByEmailEntity> mEntitySubscriber = new Subscriber<AppResetPasswordByEmailEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(AppResetPasswordByEmailEntity baseEntity) {
                if (baseEntity.getErrcode() != 0) {
                    callBack.onError(baseEntity.getErrcode() + "");
                    callBack.onComplete();
                } else {
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().AppResetPasswordByEmailReq(mEntitySubscriber, phone_num, verify_code, password);
    }

    public static void AppChangeAccountInfoReq(String email, String avatar, String push_id, String nickname, CallBack<AppChangeAccountInfoEntity> callBack) {
        if (!CatEyeSDKInterface.COMAIOT) return;
        Subscriber<AppChangeAccountInfoEntity> mEntitySubscriber = new Subscriber<AppChangeAccountInfoEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(AppChangeAccountInfoEntity baseEntity) {
                if (baseEntity.getErrcode() != 0) {
                    callBack.onError(baseEntity.getErrcode() + "");
                    callBack.onComplete();
                } else {
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().AppChangeAccountInfoReq(mEntitySubscriber, email, avatar, push_id, nickname);
    }

    public static void AppChangePhoneReq(String old_phone_num, String old_verify_code, String new_phone_num, String new_verify_code, CallBack<AppChangePhoneEntity> callBack) {
        if (!CatEyeSDKInterface.COMAIOT) return;
        Subscriber<AppChangePhoneEntity> mEntitySubscriber = new Subscriber<AppChangePhoneEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(AppChangePhoneEntity baseEntity) {
                if (baseEntity.getErrcode() != 0) {
                    callBack.onError(baseEntity.getErrcode() + "");
                    callBack.onComplete();
                } else {
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().AppChangePhoneReq(mEntitySubscriber, old_phone_num, old_verify_code, new_phone_num, new_verify_code);
    }

    public static void AppBindWeixinReq(String phoneNumber, String verifyCode, String weixin_code, CallBack<AppBindWeixinEntity> callBack) {
        if (!CatEyeSDKInterface.COMAIOT) return;
        Subscriber<AppBindWeixinEntity> mEntitySubscriber = new Subscriber<AppBindWeixinEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(AppBindWeixinEntity baseEntity) {
                if (baseEntity.getErrcode() != 0) {
                    callBack.onError(baseEntity.getErrcode() + "");
                    callBack.onComplete();
                } else {
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().AppBindWeixinReq(mEntitySubscriber, phoneNumber, verifyCode, weixin_code);
    }

    public static void bindEmail(String email, String verifyCode, String password, String phoneNumber, String nickName, CallBack<AppBindEmailEntity> callBack) {
        if (!CatEyeSDKInterface.COMAIOT) return;
        Subscriber<AppBindEmailEntity> mEntitySubscriber = new Subscriber<AppBindEmailEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(AppBindEmailEntity baseEntity) {
                if (baseEntity.getErrcode() != 0) {
                    callBack.onError(baseEntity.getErrcode() + "");
                    callBack.onComplete();
                } else {
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().bindEmail(mEntitySubscriber, email, verifyCode, password, phoneNumber, nickName);
    }

    public static void removeAccount(CallBack<AppRemoveAccountEntity> callBack) {
        if (!CatEyeSDKInterface.COMAIOT) return;
        Subscriber<AppRemoveAccountEntity> mEntitySubscriber = new Subscriber<AppRemoveAccountEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(AppRemoveAccountEntity baseEntity) {
                if (baseEntity.getErrcode() != 0) {
                    callBack.onError(baseEntity.getErrcode() + "");
                    callBack.onComplete();
                } else {
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().removeAccount(mEntitySubscriber);
    }

    // -------------------------------------------------------------------------------------------------------------//

    public static void AppAidReq(CallBack<AppAidEntity> callBack) {
        Subscriber<AppAidEntity> mEntitySubscriber = new Subscriber<AppAidEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(AppAidEntity baseEntity) {
                if (baseEntity.getErrcode() != 0) {
                    callBack.onError(baseEntity.getErrcode() + "");
                    callBack.onComplete();
                } else {
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().AppAidReq(mEntitySubscriber);
    }

    public static void uploadConfig(String config, CallBack<AppUploadConfigEntity> callBack) {
        if (!CatEyeSDKInterface.COMAIOT) return;
        Subscriber<AppUploadConfigEntity> mEntitySubscriber = new Subscriber<AppUploadConfigEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(AppUploadConfigEntity baseEntity) {
                if (baseEntity.getErrcode() != 0) {
                    callBack.onError(baseEntity.getErrcode() + "");
                    callBack.onComplete();
                } else {
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().uploadConfig(mEntitySubscriber, config);
    }

    public static void getConfig(CallBack<AppDownloadConfigEntity> callBack) {
        if (!CatEyeSDKInterface.COMAIOT) return;
        Subscriber<AppDownloadConfigEntity> mEntitySubscriber = new Subscriber<AppDownloadConfigEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(AppDownloadConfigEntity baseEntity) {
                if (baseEntity.getErrcode() != 0) {
                    callBack.onError(baseEntity.getErrcode() + "");
                    callBack.onComplete();
                } else {
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().getConfig(mEntitySubscriber);
    }

    public static void AppRemoveAidReq(String appAid, CallBack<AppRemoveAidEntity> callBack) {
        Subscriber<AppRemoveAidEntity> mEntitySubscriber = new Subscriber<AppRemoveAidEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(AppRemoveAidEntity baseEntity) {
                if (baseEntity.getErrcode() != 0) {
                    callBack.onError(baseEntity.getErrcode() + "");
                    callBack.onComplete();
                } else {
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().AppRemoveAidReq(mEntitySubscriber, appAid);
    }

    public static void AppRemoveSharedDeviceReq(String appAid, CallBack<AppRemoveSharedDeviceEntity> callBack) {
        Subscriber<AppRemoveSharedDeviceEntity> mEntitySubscriber = new Subscriber<AppRemoveSharedDeviceEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(AppRemoveSharedDeviceEntity baseEntity) {
                if (baseEntity.getErrcode() != 0) {
                    callBack.onError(baseEntity.getErrcode() + "");
                    callBack.onComplete();
                } else {
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().AppRemoveSharedDeviceReq(mEntitySubscriber, appAid);
    }

    public static void queryDeviceConnectStatus(String aid, String devUid, CallBack<AppQueryDevConnectEntity> callBack) {
        Subscriber<AppQueryDevConnectEntity> mEntitySubscriber = new Subscriber<AppQueryDevConnectEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(AppQueryDevConnectEntity baseEntity) {
                if (baseEntity.getErrcode() != 0) {
                    callBack.onError(baseEntity.getErrcode() + "");
                    callBack.onComplete();
                } else {
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().queryDeviceConnectStatus(mEntitySubscriber, aid, devUid);
    }

    public static void AppRemoveMessageReq(String aid, String msgId, String devUid, CallBack<AppRemoveMessageEntity> callBack) {
        Subscriber<AppRemoveMessageEntity> mEntitySubscriber = new Subscriber<AppRemoveMessageEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(AppRemoveMessageEntity baseEntity) {
                if (baseEntity.getErrcode() != 0) {
                    callBack.onError(baseEntity.getErrcode() + "");
                    callBack.onComplete();
                } else {
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().AppRemoveMessageReq(mEntitySubscriber, aid, msgId, devUid);
    }

    public static void AppBarcodeReq(String aid, String countryCode, int timeZone, String ssid, String password, CallBack<AppBarcodeReqEntity> callBack) {
        Subscriber<AppBarcodeReqEntity> mEntitySubscriber = new Subscriber<AppBarcodeReqEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(AppBarcodeReqEntity baseEntity) {
                if (baseEntity.getErrcode() != 0) {
                    callBack.onError(baseEntity.getErrcode() + "");
                    callBack.onComplete();
                } else {
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().AppBarcodeReq(mEntitySubscriber, aid, countryCode, timeZone, ssid, password);
    }

    public static void AppQueryAidBindReq(String app_aid, CallBack<AppQueryAidBindEntity> callBack) {
        Subscriber<AppQueryAidBindEntity> mEntitySubscriber = new Subscriber<AppQueryAidBindEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(AppQueryAidBindEntity baseEntity) {
                if (baseEntity.getErrcode() != 0) {
                    callBack.onError(baseEntity.getErrcode() + "");
                    callBack.onComplete();
                } else {
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().AppQueryAidBindReq(mEntitySubscriber, app_aid);
    }

    public static void AppShareDeviceReq(String appAid, String devUid, CallBack<AppShareDeviceEntity> callBack) {
        Subscriber<AppShareDeviceEntity> mEntitySubscriber = new Subscriber<AppShareDeviceEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(AppShareDeviceEntity baseEntity) {
                if (baseEntity.getErrcode() != 0) {
                    callBack.onError(baseEntity.getErrcode() + "");
                    callBack.onComplete();
                } else {
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().AppShareDeviceReq(mEntitySubscriber, appAid, devUid);
    }

    public static void AppQuerySharedDeviceReq(String aid, CallBack<AppQuerySharedDeviceEntity> callBack) {
        Subscriber<AppQuerySharedDeviceEntity> mEntitySubscriber = new Subscriber<AppQuerySharedDeviceEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(AppQuerySharedDeviceEntity baseEntity) {
                if (baseEntity.getErrcode() != 0) {
                    callBack.onError(baseEntity.getErrcode() + "");
                    callBack.onComplete();
                } else {
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().AppQuerySharedDeviceReq(mEntitySubscriber, aid);
    }

    // -------------------------------------------------------------------------------------------------------------//

    public static void loginServer(String jwt_token, CallBack<AppSubscribeEntity> callBack) {
        Subscriber<AppSubscribeEntity> mEntitySubscriber = new Subscriber<AppSubscribeEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                String eMessage = e.getMessage();
                callBack.onError(eMessage);
                callBack.onComplete();
                Logger.ee("[loginServer] failed" + eMessage);
            }

            @Override
            public void onNext(AppSubscribeEntity baseEntity) {
                Logger.dd("[loginServer] success" + baseEntity.toString());
                if (baseEntity.getErrcode() != 0) {
                    callBack.onError(baseEntity.getErrcode() + "");
                    callBack.onComplete();
                } else {
                    String app_uid = baseEntity.getContent().getApp_uid();
                    String app_envid = baseEntity.getContent().getApp_envid();
                    String token = baseEntity.getContent().getToken();
                    CatEyePreferences.get().saveAppUid(DESUtils.encryptString(app_uid));
                    CatEyePreferences.get().saveAppEnvid(DESUtils.encryptString(app_envid));
                    CatEyePreferences.get().saveToken(DESUtils.encryptString(token));

                    String clientId = app_uid + "-" + app_envid;
                    String host = baseEntity.getContent().getMqtt().getIp();
                    String port = baseEntity.getContent().getMqtt().getPort();
                    String user = baseEntity.getContent().getMqtt().getUser();
                    String pwd = baseEntity.getContent().getMqtt().getPass();

                    CatEyePreferences.get().saveMqttHost(host);
                    CatEyePreferences.get().saveMqttPort(port);
                    CatEyePreferences.get().saveMqttUser(user);
                    CatEyePreferences.get().saveMqttPass(pwd);

                    MqttManagerInter.getInstance(CatEyeSDKInterface.get().getContext()).connect(host, clientId, port, user, pwd);
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().loginServer(mEntitySubscriber, jwt_token);
    }

    public static void setWeChatPush(String weixin_accountid, String weixin_openid, String weixin_unionid, int push_on_off, CallBack<PartnerWeixinPushConfigEntity> callBack) {
        if (!CatEyeSDKInterface.COMAIOT) return;
        Subscriber<PartnerWeixinPushConfigEntity> mEntitySubscriber = new Subscriber<PartnerWeixinPushConfigEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                String eMessage = e.getMessage();
                callBack.onError(eMessage);
                callBack.onComplete();
                Logger.ee("[setWeChatPush] failed" + eMessage);
            }

            @Override
            public void onNext(PartnerWeixinPushConfigEntity baseEntity) {
                Logger.dd("[setWeChatPush] success" + baseEntity.toString());
                if (baseEntity.getErrcode() != 0) {
                    callBack.onError(baseEntity.getErrcode() + "");
                    callBack.onComplete();
                } else {
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().setWeChatPush(mEntitySubscriber, weixin_accountid, weixin_openid, weixin_unionid, push_on_off);
    }

    public static void notificationWeChat(String weChatAccountid, String weChatOpenidList, String content, CallBack<PartnerWeixinPushNoticeEntity> callBack) {
        if (!CatEyeSDKInterface.COMAIOT) return;
        Subscriber<PartnerWeixinPushNoticeEntity> mEntitySubscriber = new Subscriber<PartnerWeixinPushNoticeEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                String eMessage = e.getMessage();
                callBack.onError(eMessage);
                callBack.onComplete();
                Logger.ee("[notificationWeChat] failed" + eMessage);
            }

            @Override
            public void onNext(PartnerWeixinPushNoticeEntity baseEntity) {
                Logger.dd("[notificationWeChat] success" + baseEntity.toString());
                if (baseEntity.getErrcode() != 0) {
                    callBack.onError(baseEntity.getErrcode() + "");
                    callBack.onComplete();
                } else {
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().notificationWeChat(mEntitySubscriber, weChatAccountid, weChatOpenidList, content);
    }

    public static void getStorageToken(String device_id, String device_token, String file_name, CallBack<StorageEntity> callBack) {
        //获取七牛云存储token
        Subscriber<StorageEntity> mEntitySubscriber = new Subscriber<StorageEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(StorageEntity baseEntity) {
                if (baseEntity.getErrcode() != 0) {
                    if (null != baseEntity.getErrmsg())
                        callBack.onError(baseEntity.getErrmsg());
                    callBack.onComplete();
                } else {
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().getStorageToken(mEntitySubscriber, device_id, device_token, file_name);
    }

    public static void queryAgoraSocketUserNumber(String channelName, CallBack<ArogaBean<ArogaBean.Data>> callBack) {
        //query user number
        Subscriber<ArogaBean<ArogaBean.Data>> mEntitySubscriber = new Subscriber<ArogaBean<ArogaBean.Data>>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                Logger.ii("queryAgoraSocketUserNumber " + e.toString());
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(ArogaBean<ArogaBean.Data> arogaBean) {
                if (arogaBean.isSuccess()) {
                    callBack.onSuccess(arogaBean);
                } else {
                    callBack.onError("null");
                    callBack.onComplete();
                }
            }
        };
        RetrofitUtil.getInstance().queryAgoraSocketUserNumber(mEntitySubscriber, channelName);
    }

    public static void agoraLicenses(String custom, String credential, CallBack<ArogaBean.Licenses> callBack) {
        //query user number
        Subscriber<ArogaBean.Licenses> mEntitySubscriber = new Subscriber<ArogaBean.Licenses>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                Logger.ii("agoraLicenses " + e.toString());
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(ArogaBean.Licenses licensesArogaBean) {
                if (null != licensesArogaBean) {
                    callBack.onSuccess(licensesArogaBean);
                } else {
                    callBack.onError("null");
                    callBack.onComplete();
                }
            }
        };
        RetrofitUtil.getInstance().agoraLicenses(mEntitySubscriber, custom, credential);
    }

    public static void HeaderImageTokenReq(String appUid, String token, String file_name, CallBack<StorageEntity> callBack) {
        //获取七牛云存储token
        Subscriber<StorageEntity> mEntitySubscriber = new Subscriber<StorageEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(StorageEntity baseEntity) {
                if (baseEntity.getErrcode() != 0) {
                    callBack.onError(baseEntity.getErrmsg());
                    callBack.onComplete();
                } else {
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().HeaderImageTokenReq(mEntitySubscriber, appUid, token, file_name);
    }

    public static void smsToPhone(String phone_num, String signName, CallBack<SmsEntity> callBack) {
        if (!CatEyeSDKInterface.COMAIOT) return;
        //发送验证码
        Subscriber<SmsEntity> mEntitySubscriber = new Subscriber<SmsEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(SmsEntity baseEntity) {
                if (baseEntity.getErrcode() != 0) {
                    callBack.onError(baseEntity.getErrcode() + "");
                    callBack.onComplete();
                } else {
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().smsToPhone(mEntitySubscriber, phone_num, signName);
    }

    public static void LoginByPassword(String appUid, String appEnvid, String subscribe_type, String phoneNumber, String password, String push_id, String type, CallBack<AppSubscribeEntity> callBack) {
        Subscriber<AppSubscribeEntity> mEntitySubscriber = new Subscriber<AppSubscribeEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(AppSubscribeEntity baseEntity) {
                if (baseEntity.getErrcode() != 0) {
                    callBack.onError(baseEntity.getErrcode() + "");
                    callBack.onComplete();
                } else {
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().LoginByPassword(mEntitySubscriber, appUid, appEnvid, subscribe_type, phoneNumber, password, push_id, type);
    }

    public static void LoginByPhone(Context context, String appUid, String appEnvid, String subscribe_type, String phoneNumber, String password, String push_id, String type, CallBack<AppSubscribeEntity> callBack) {
        Subscriber<AppSubscribeEntity> mEntitySubscriber = new Subscriber<AppSubscribeEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(AppSubscribeEntity baseEntity) {
                if (baseEntity.getErrcode() != 0) {
                    callBack.onError(baseEntity.getErrcode() + "");
                    callBack.onComplete();
                } else {
                    Log.e("comaiot", "save comaiot info");
                    String app_uid = baseEntity.getContent().getApp_uid();
                    String app_envid = baseEntity.getContent().getApp_envid();
                    String token = baseEntity.getContent().getToken();
                    GeneralPreferences.get(context).saveAppUid(app_uid);
                    GeneralPreferences.get(context).saveAppEnvid(app_envid);
                    GeneralPreferences.get(context).saveAppToken(token);

                    String clientId = app_uid + "-" + app_envid;
                    String host = baseEntity.getContent().getMqtt().getIp();
                    String port = baseEntity.getContent().getMqtt().getPort();
                    String user = baseEntity.getContent().getMqtt().getUser();
                    String pwd = baseEntity.getContent().getMqtt().getPass();

                    GeneralPreferences.get(context).saveMqttHost(host);
                    GeneralPreferences.get(context).saveMqttPort(port);
                    GeneralPreferences.get(context).saveMqttUser(user);
                    GeneralPreferences.get(context).saveMqttPassword(pwd);

                    MqttManagerInter.getInstance(context).connect(host, clientId, port, user, pwd);
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().LoginByPhone(mEntitySubscriber, appUid, appEnvid, subscribe_type, phoneNumber, password, push_id, type);
    }

    public static void LoginByPhone(String appUid, String appEnvid, String subscribe_type, String phoneNumber, String password, String push_id, String type, CallBack<AppSubscribeEntity> callBack) {
        Subscriber<AppSubscribeEntity> mEntitySubscriber = new Subscriber<AppSubscribeEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(AppSubscribeEntity baseEntity) {
                if (baseEntity.getErrcode() != 0) {
                    callBack.onError(baseEntity.getErrcode() + "");
                    callBack.onComplete();
                } else {
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().LoginByPhone(mEntitySubscriber, appUid, appEnvid, subscribe_type, phoneNumber, password, push_id, type);
    }

    public static void PartnerShareDeviceReq(String devUid, String phone_num, String jwt, CallBack<PartnerShareDeviceEntity> callBack) {
        Subscriber<PartnerShareDeviceEntity> mEntitySubscriber = new Subscriber<PartnerShareDeviceEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(PartnerShareDeviceEntity baseEntity) {
                if (baseEntity.getErrcode() != 0) {
                    callBack.onError(baseEntity.getErrcode() + "");
                    callBack.onComplete();
                } else {
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().PartnerShareDeviceReq(mEntitySubscriber, devUid, phone_num, jwt);
    }

    public static void PartnerChangePhoneReq(String phoneNumber, String jwt, CallBack<PartnerChangePhoneEntity> callBack) {
        Subscriber<PartnerChangePhoneEntity> mEntitySubscriber = new Subscriber<PartnerChangePhoneEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(PartnerChangePhoneEntity baseEntity) {
                if (baseEntity.getErrcode() != 0) {
                    callBack.onError(baseEntity.getErrcode() + "");
                    callBack.onComplete();
                } else {
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().PartnerChangePhoneReq(mEntitySubscriber, phoneNumber, jwt);
    }

    public static void sendEmail(String email, CallBack<EmailTokenEntity> callBack) {
        if (!CatEyeSDKInterface.COMAIOT) return;
        Subscriber<EmailTokenEntity> mEntitySubscriber = new Subscriber<EmailTokenEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(EmailTokenEntity baseEntity) {
                if (baseEntity.getErrcode() != 0) {
                    callBack.onError(baseEntity.getErrcode() + "");
                    callBack.onComplete();
                } else {
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().sendEmail(mEntitySubscriber, email);
    }

    public static void AppQueryPushAccountReq(CallBack<AppQueryPushAccountEntity> callBack) {
        Subscriber<AppQueryPushAccountEntity> mEntitySubscriber = new Subscriber<AppQueryPushAccountEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(AppQueryPushAccountEntity baseEntity) {
                if (baseEntity.getErrcode() != 0) {
                    callBack.onError(baseEntity.getErrcode() + "");
                    callBack.onComplete();
                } else {
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().AppQueryPushAccountReq(mEntitySubscriber);
    }
}

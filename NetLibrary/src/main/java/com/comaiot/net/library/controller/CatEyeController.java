package com.comaiot.net.library.controller;

import android.content.Context;
import android.util.Log;

import com.comaiot.net.library.bean.ArogaBean;
import com.comaiot.net.library.core.CatEyeSDKInterface;
import com.comaiot.net.library.core.NoAttachViewException;
import com.comaiot.net.library.core.NoInternetException;
import com.comaiot.net.library.Model.CatEyeModel;
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
import com.comaiot.net.library.bean.SmsEntity;
import com.comaiot.net.library.bean.StorageEntity;
import com.comaiot.net.library.inter.CallBack;
import com.comaiot.net.library.req_params.AppDownloadDevConfigEntity;
import com.comaiot.net.library.controller.view.AgoraLicensesView;
import com.comaiot.net.library.controller.view.AppAidReqView;
import com.comaiot.net.library.controller.view.AppBarcodeReqView;
import com.comaiot.net.library.controller.view.AppBindEmailReqView;
import com.comaiot.net.library.controller.view.AppBindWeixinReqView;
import com.comaiot.net.library.controller.view.AppChangeAccountInfoReqView;
import com.comaiot.net.library.controller.view.AppChangePasswordReqView;
import com.comaiot.net.library.controller.view.AppChangePhoneReqView;
import com.comaiot.net.library.controller.view.AppDownloadConfigReqView;
import com.comaiot.net.library.controller.view.AppDownloadDevConfigReqView;
import com.comaiot.net.library.controller.view.AppEmailSubScribeReqView;
import com.comaiot.net.library.controller.view.AppQueryAccountReqView;
import com.comaiot.net.library.controller.view.AppQueryAidBindRquView;
import com.comaiot.net.library.controller.view.AppQueryDevConnectReqView;
import com.comaiot.net.library.controller.view.AppQueryPushAccountReqView;
import com.comaiot.net.library.controller.view.AppQuerySharedDeviceReqView;
import com.comaiot.net.library.controller.view.AppReceiveShareReqView;
import com.comaiot.net.library.controller.view.AppRefreshTokenView;
import com.comaiot.net.library.controller.view.AppRemoveAccountReqView;
import com.comaiot.net.library.controller.view.AppRemoveAidReqView;
import com.comaiot.net.library.controller.view.AppRemoveMessageReqView;
import com.comaiot.net.library.controller.view.AppRemoveSharedDeviceReqView;
import com.comaiot.net.library.controller.view.AppResetPasswordByEmailReqView;
import com.comaiot.net.library.controller.view.AppResetPasswordByPhoneReqView;
import com.comaiot.net.library.controller.view.AppShareDeviceReqView;
import com.comaiot.net.library.controller.view.AppSubscribeReqView;
import com.comaiot.net.library.controller.view.AppUnSubscribeReqView;
import com.comaiot.net.library.controller.view.AppUploadConfigReqView;
import com.comaiot.net.library.controller.view.BindPhoneView;
import com.comaiot.net.library.controller.view.EmailTokenReqView;
import com.comaiot.net.library.controller.view.GetStorageView;
import com.comaiot.net.library.controller.view.PartnerChangePhoneReqView;
import com.comaiot.net.library.controller.view.PartnerShareDeviceReqView;
import com.comaiot.net.library.controller.view.PartnerWeixinPushConfigReqView;
import com.comaiot.net.library.controller.view.PartnerWeixinPushNoticeReqView;
import com.comaiot.net.library.controller.view.QueryArogaUserView;
import com.comaiot.net.library.controller.view.SmsTokenReqView;


public class CatEyeController<V extends CatEyeView> {

    // 持有 MVP 中 View 的引用
    private V iMvpView;


    public CatEyeController() {
    }

    public void attachView(V view) {
        this.iMvpView = view;
    }

    public void detachView() {
        this.iMvpView = null;
    }

    public boolean isViewAttached() {
        return iMvpView != null;
    }

    public V getView() {
        return iMvpView;
    }

    public void login(String phoneNumber, String password, String pushId, String subscribe_type, String verify_code, String weixin_code, String weixin_type, AppSubscribeReqView reqView) throws NoInternetException, NoAttachViewException {
        if (!AppUtils.isHaveInternet(CatEyeSDKInterface.get().getContext())) {
            throw new NoInternetException();
        }
        if (!isViewAttached()) {
            throw new NoAttachViewException();
        }
        if (!CatEyeSDKInterface.COMAIOT) return;
        CatEyeModel.login(phoneNumber, password, pushId, subscribe_type, verify_code, weixin_code, weixin_type, new CallBack<AppSubscribeEntity>() {
            @Override
            public void onStart() {
                if (isViewAttached() && null != reqView)
                    reqView.showLoading();
            }

            @Override
            public void onComplete() {
                if (isViewAttached() && null != reqView)
                    reqView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                if (isViewAttached() && null != reqView)
                    reqView.onRequestError(msg, "login" + subscribe_type);
            }

            @Override
            public void onSuccess(AppSubscribeEntity data) {
                if (isViewAttached() && null != reqView)
                    reqView.onSubscribeSuccess(data.getContent().getExpire());
            }
        });
    }

    public void loginEmail(String email, String password, String pushId, AppEmailSubScribeReqView reqView) throws NoInternetException, NoAttachViewException {
        if (!AppUtils.isHaveInternet(CatEyeSDKInterface.get().getContext())) {
            throw new NoInternetException();
        }
        if (!isViewAttached()) {
            throw new NoAttachViewException();
        }
        if (!CatEyeSDKInterface.COMAIOT) return;
        CatEyeModel.loginEmail(email, password, pushId, new CallBack<AppSubscribeEntity>() {
            @Override
            public void onStart() {
                if (isViewAttached() && null != reqView)
                    reqView.showLoading();
            }

            @Override
            public void onComplete() {
                if (isViewAttached() && null != reqView)
                    reqView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                if (isViewAttached() && null != reqView)
                    reqView.onRequestError(msg, "loginEmail");
            }

            @Override
            public void onSuccess(AppSubscribeEntity data) {
                if (isViewAttached() && null != reqView)
                    reqView.onLoginEmailSuccess(data);
            }
        });
    }

    public void AppUnSubscribeReq(AppUnSubscribeReqView ReqView) throws NoInternetException, NoAttachViewException {
        if (!AppUtils.isHaveInternet(CatEyeSDKInterface.get().getContext())) {
            throw new NoInternetException();
        }
        if (!isViewAttached()) {
            throw new NoAttachViewException();
        }
        if (!CatEyeSDKInterface.COMAIOT) return;
        CatEyeModel.AppUnSubscribeReq(new CallBack<AppUnSubscribeEntity>() {
            @Override
            public void onStart() {
                if (isViewAttached() && null != ReqView)
                    ReqView.showLoading();
            }

            @Override
            public void onComplete() {
                if (isViewAttached() && null != ReqView)
                    ReqView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                if (isViewAttached() && null != ReqView)
                    ReqView.onRequestError(msg, "logOut");
            }

            @Override
            public void onSuccess(AppUnSubscribeEntity data) {
                if (isViewAttached() && null != ReqView) {
                    ReqView.onUnSubscribeSuccess(data);
                }
            }
        });
    }

    public void refreshToken(AppRefreshTokenView reqView) throws NoInternetException, NoAttachViewException {
        if (!AppUtils.isHaveInternet(CatEyeSDKInterface.get().getContext())) {
            throw new NoInternetException();
        }
        if (!isViewAttached()) {
            throw new NoAttachViewException();
        }

        CatEyeModel.refreshToken(new CallBack<AppRefreshTokenEntity>() {
            @Override
            public void onStart() {
                if (isViewAttached() && null != reqView)
                    reqView.showLoading();
            }

            @Override
            public void onComplete() {
                if (isViewAttached() && null != reqView)
                    reqView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                if (isViewAttached() && null != reqView)
                    reqView.onRequestError(msg, "refreshToken");
            }

            @Override
            public void onSuccess(AppRefreshTokenEntity data) {
                if (isViewAttached() && null != reqView) {
                    reqView.onRefreshTokenSuccess(data.getContent().getExpire());
                }
            }
        });
    }

    public void AppChangePasswordReq(String old_password, String new_password, AppChangePasswordReqView ReqView) {
        if (!isViewAttached()) {
            return;
        }
        if (!CatEyeSDKInterface.COMAIOT) return;
        CatEyeModel.AppChangePasswordReq(old_password, new_password, new CallBack<AppChangePasswordEntity>() {
            @Override
            public void onStart() {
                if (isViewAttached() && null != ReqView)
                    ReqView.showLoading();
            }

            @Override
            public void onComplete() {
                if (isViewAttached() && null != ReqView)
                    ReqView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                if (isViewAttached() && null != ReqView)
                    ReqView.onRequestError(msg, "changePassword");
            }

            @Override
            public void onSuccess(AppChangePasswordEntity data) {
                if (isViewAttached() && null != ReqView) {
                    ReqView.onAppChangePasswordReqSuccess(data);
                }
            }
        });
    }

    public void AppResetPasswordByPhoneReq(String phoneNumber, String verifyCode, String password, AppResetPasswordByPhoneReqView ReqView) throws NoInternetException, NoAttachViewException {
        if (!AppUtils.isHaveInternet(CatEyeSDKInterface.get().getContext())) {
            throw new NoInternetException();
        }
        if (!isViewAttached()) {
            throw new NoAttachViewException();
        }
        if (!CatEyeSDKInterface.COMAIOT) return;
        CatEyeModel.AppResetPasswordByPhoneReq(phoneNumber, verifyCode, password, new CallBack<AppResetPasswordByPhoneEntity>() {
            @Override
            public void onStart() {
                if (isViewAttached() && null != ReqView)
                    ReqView.showLoading();
            }

            @Override
            public void onComplete() {
                if (isViewAttached() && null != ReqView)
                    ReqView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                if (isViewAttached() && null != ReqView)
                    ReqView.onRequestError(msg, "resetPasswordByPhone");
            }

            @Override
            public void onSuccess(AppResetPasswordByPhoneEntity data) {
                if (isViewAttached() && null != ReqView)
                    ReqView.onAppResetPasswordByPhoneReqSuccess(data);
            }
        });
    }

    public void AppResetPasswordByEmailReq(String phoneNumber, String verifyCode, String password, AppResetPasswordByEmailReqView ReqView) throws NoInternetException, NoAttachViewException {
        if (!AppUtils.isHaveInternet(CatEyeSDKInterface.get().getContext())) {
            throw new NoInternetException();
        }
        if (!isViewAttached()) {
            throw new NoAttachViewException();
        }
        if (!CatEyeSDKInterface.COMAIOT) return;
        CatEyeModel.AppResetPasswordByEmailReq(phoneNumber, verifyCode, password, new CallBack<AppResetPasswordByEmailEntity>() {
            @Override
            public void onStart() {
                if (isViewAttached() && null != ReqView)
                    ReqView.showLoading();
            }

            @Override
            public void onComplete() {
                if (isViewAttached() && null != ReqView)
                    ReqView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                if (isViewAttached() && null != ReqView)
                    ReqView.onRequestError(msg, "resetPasswordByEmail");
            }

            @Override
            public void onSuccess(AppResetPasswordByEmailEntity data) {
                if (isViewAttached() && null != ReqView)
                    ReqView.onResetPasswordByEmailSuccess(data);
            }
        });
    }

    public void AppChangeAccountInfoReq(String email, String avatar, String push_id, String nickname, AppChangeAccountInfoReqView ReqView) throws NoInternetException, NoAttachViewException {
        if (!AppUtils.isHaveInternet(CatEyeSDKInterface.get().getContext())) {
            throw new NoInternetException();
        }
        if (!isViewAttached()) {
            throw new NoAttachViewException();
        }
        if (!CatEyeSDKInterface.COMAIOT) return;
        CatEyeModel.AppChangeAccountInfoReq(email, avatar, push_id, nickname, new CallBack<AppChangeAccountInfoEntity>() {
            @Override
            public void onStart() {
                if (isViewAttached() && null != ReqView)
                    ReqView.showLoading();
            }

            @Override
            public void onComplete() {
                if (isViewAttached() && null != ReqView)
                    ReqView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                if (isViewAttached() && null != ReqView)
                    ReqView.onRequestError(msg, "changeAccountInfo");
            }

            @Override
            public void onSuccess(AppChangeAccountInfoEntity data) {
                if (isViewAttached() && null != ReqView) {
                    ReqView.onAppChangeAccountInfoReqSuccess(data);
                }
            }
        });
    }

    public void AppChangePhoneReq(String old_phone_num, String old_verify_code, String new_phone_num, String new_verify_code, AppChangePhoneReqView reqView) throws NoInternetException, NoAttachViewException {
        if (!AppUtils.isHaveInternet(CatEyeSDKInterface.get().getContext())) {
            throw new NoInternetException();
        }
        if (!isViewAttached()) {
            throw new NoAttachViewException();
        }
        if (!CatEyeSDKInterface.COMAIOT) return;
        CatEyeModel.AppChangePhoneReq(old_phone_num, old_verify_code, new_phone_num, new_verify_code, new CallBack<AppChangePhoneEntity>() {
            @Override
            public void onStart() {
                if (isViewAttached() && null != reqView)
                    reqView.showLoading();
            }

            @Override
            public void onComplete() {
                if (isViewAttached() && null != reqView)
                    reqView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                if (isViewAttached() && null != reqView)
                    reqView.onRequestError(msg, "changePhoneNumber");
            }

            @Override
            public void onSuccess(AppChangePhoneEntity data) {
                if (isViewAttached() && null != reqView) {
                    reqView.onAppChangePhoneReqSuccess(data);
                }
            }
        });
    }

    public void AppBindWeixinReq(String phoneNumber, String verifyCode, String weixin_code, AppBindWeixinReqView ReqView) throws NoInternetException, NoAttachViewException {
        if (!AppUtils.isHaveInternet(CatEyeSDKInterface.get().getContext())) {
            throw new NoInternetException();
        }
        if (!isViewAttached()) {
            throw new NoAttachViewException();
        }
        if (!CatEyeSDKInterface.COMAIOT) return;
        CatEyeModel.AppBindWeixinReq(phoneNumber, verifyCode, weixin_code, new CallBack<AppBindWeixinEntity>() {
            @Override
            public void onStart() {
                if (isViewAttached() && null != ReqView)
                    ReqView.showLoading();
            }

            @Override
            public void onComplete() {
                if (isViewAttached() && null != ReqView)
                    ReqView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                if (isViewAttached() && null != ReqView)
                    ReqView.onRequestError(msg, "bindWeChat");
            }

            @Override
            public void onSuccess(AppBindWeixinEntity data) {
                if (isViewAttached() && null != ReqView)
                    ReqView.onAppBindWeixinReqSucc(data);
            }
        });
    }

    public void bindEmail(String email, String verifyCode, String password, String phoneNumber, String nickName, AppBindEmailReqView reqView) throws NoInternetException, NoAttachViewException {
        if (!AppUtils.isHaveInternet(CatEyeSDKInterface.get().getContext())) {
            throw new NoInternetException();
        }
        if (!isViewAttached()) {
            throw new NoAttachViewException();
        }
        if (!CatEyeSDKInterface.COMAIOT) return;
        CatEyeModel.bindEmail(email, verifyCode, password, phoneNumber, nickName, new CallBack<AppBindEmailEntity>() {
            @Override
            public void onStart() {
                if (isViewAttached() && null != reqView)
                    reqView.showLoading();
            }

            @Override
            public void onComplete() {
                if (isViewAttached() && null != reqView)
                    reqView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                if (isViewAttached() && null != reqView)
                    reqView.onRequestError(msg, "bindEmail");
            }

            @Override
            public void onSuccess(AppBindEmailEntity data) {
                if (isViewAttached() && null != reqView)
                    reqView.onBindEmailSuccess(data);
            }
        });
    }

    public void removeAccount(AppRemoveAccountReqView reqView) throws NoInternetException, NoAttachViewException {
        if (!AppUtils.isHaveInternet(CatEyeSDKInterface.get().getContext())) {
            throw new NoInternetException();
        }
        if (!isViewAttached()) {
            throw new NoAttachViewException();
        }
        if (!CatEyeSDKInterface.COMAIOT) return;
        CatEyeModel.removeAccount(new CallBack<AppRemoveAccountEntity>() {
            @Override
            public void onStart() {
                if (isViewAttached() && null != reqView)
                    reqView.showLoading();
            }

            @Override
            public void onComplete() {
                if (isViewAttached() && null != reqView)
                    reqView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                if (isViewAttached() && null != reqView)
                    reqView.onRequestError(msg, "removeAccount");
            }

            @Override
            public void onSuccess(AppRemoveAccountEntity data) {
                if (isViewAttached() && null != reqView) {
                    reqView.onRemoveAccountSuccess(data);
                }
            }
        });
    }

    //-------------------------------------------------------------------------------------------------------------//

    public void AppAidReq(AppAidReqView reqView) throws NoInternetException, NoAttachViewException {
        if (!AppUtils.isHaveInternet(CatEyeSDKInterface.get().getContext())) {
            throw new NoInternetException();
        }
        if (!isViewAttached()) {
            throw new NoAttachViewException();
        }
        CatEyeModel.AppAidReq(new CallBack<AppAidEntity>() {
            @Override
            public void onStart() {
                if (isViewAttached() && null != reqView)
                    reqView.showLoading();
            }

            @Override
            public void onComplete() {
                if (isViewAttached() && null != reqView)
                    reqView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                if (isViewAttached() && null != reqView)
                    reqView.onRequestError(msg, "getAid");
            }

            @Override
            public void onSuccess(AppAidEntity data) {
                if (isViewAttached() && null != reqView)
                    reqView.onAppAidReqSuccess(data);
            }
        });
    }

    public void uploadConfig(String config, AppUploadConfigReqView reqView) throws NoInternetException, NoAttachViewException {
        if (!AppUtils.isHaveInternet(CatEyeSDKInterface.get().getContext())) {
            throw new NoInternetException();
        }
        if (!isViewAttached()) {
            throw new NoAttachViewException();
        }
        if (!CatEyeSDKInterface.COMAIOT) return;
        CatEyeModel.uploadConfig(config, new CallBack<AppUploadConfigEntity>() {
            @Override
            public void onStart() {
                if (isViewAttached() && null != reqView)
                    reqView.showLoading();
            }

            @Override
            public void onComplete() {
                if (isViewAttached() && null != reqView)
                    reqView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                if (isViewAttached() && null != reqView)
                    reqView.onRequestError(msg, "uploadConfig");
            }

            @Override
            public void onSuccess(AppUploadConfigEntity data) {
                if (isViewAttached() && null != reqView) {
                    reqView.onUploadCustomConfigSuccess(data);
                }
            }
        });
    }

    public void getConfig(AppDownloadConfigReqView reqView) throws NoAttachViewException, NoInternetException {
        if (!AppUtils.isHaveInternet(CatEyeSDKInterface.get().getContext())) {
            throw new NoInternetException();
        }
        if (!isViewAttached()) {
            throw new NoAttachViewException();
        }
        if (!CatEyeSDKInterface.COMAIOT) return;
        CatEyeModel.getConfig(new CallBack<AppDownloadConfigEntity>() {
            @Override
            public void onStart() {
                if (isViewAttached() && null != reqView)
                    reqView.showLoading();
            }

            @Override
            public void onComplete() {
                if (isViewAttached() && null != reqView)
                    reqView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                if (isViewAttached() && null != reqView)
                    reqView.onRequestError(msg, "getConfig");
            }

            @Override
            public void onSuccess(AppDownloadConfigEntity data) {
                if (isViewAttached() && null != reqView) {
                    reqView.onGetCustomConfigSuccess(data);
                }
            }
        });
    }

    public void AppRemoveAidReq(String appAid, AppRemoveAidReqView ReqView) throws NoAttachViewException, NoInternetException {
        if (!AppUtils.isHaveInternet(CatEyeSDKInterface.get().getContext())) {
            throw new NoInternetException();
        }
        if (!isViewAttached()) {
            throw new NoAttachViewException();
        }
        CatEyeModel.AppRemoveAidReq(appAid, new CallBack<AppRemoveAidEntity>() {
            @Override
            public void onStart() {
                if (isViewAttached() && null != ReqView)
                    ReqView.showLoading();
            }

            @Override
            public void onComplete() {
                if (isViewAttached() && null != ReqView)
                    ReqView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                if (isViewAttached() && null != ReqView)
                    ReqView.onRequestError(msg, "deleteDevice");
            }

            @Override
            public void onSuccess(AppRemoveAidEntity data) {
                if (isViewAttached() && null != ReqView)
                    ReqView.onAppRemoveAidReqSuccess(data);
            }
        });
    }

    public void AppRemoveSharedDeviceReq(String appAid, AppRemoveSharedDeviceReqView ReqView) throws NoInternetException, NoAttachViewException {
        if (!AppUtils.isHaveInternet(CatEyeSDKInterface.get().getContext())) {
            throw new NoInternetException();
        }
        if (!isViewAttached()) {
            throw new NoAttachViewException();
        }

        CatEyeModel.AppRemoveSharedDeviceReq(appAid, new CallBack<AppRemoveSharedDeviceEntity>() {
            @Override
            public void onStart() {
                if (isViewAttached() && null != ReqView)
                    ReqView.showLoading();
            }

            @Override
            public void onComplete() {
                if (isViewAttached() && null != ReqView)
                    ReqView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                if (isViewAttached() && null != ReqView)
                    ReqView.onRequestError(msg, "removeSharedAccount");
            }

            @Override
            public void onSuccess(AppRemoveSharedDeviceEntity data) {
                if (isViewAttached() && null != ReqView) {
                    ReqView.onAppRemoveSharedDeviceSuccess(data);
                }
            }
        });
    }

    public void queryDeviceConnectStatus(String aid, String devUid, AppQueryDevConnectReqView reqView) throws NoInternetException, NoAttachViewException {
        if (!AppUtils.isHaveInternet(CatEyeSDKInterface.get().getContext())) {
            throw new NoInternetException();
        }
        if (!isViewAttached()) {
            throw new NoAttachViewException();
        }

        CatEyeModel.queryDeviceConnectStatus(aid, devUid, new CallBack<AppQueryDevConnectEntity>() {
            @Override
            public void onStart() {
                if (isViewAttached() && null != reqView)
                    reqView.showLoading();
            }

            @Override
            public void onComplete() {
                if (isViewAttached() && null != reqView)
                    reqView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                if (isViewAttached() && null != reqView)
                    reqView.onRequestError(msg, "queryDeviceConnectStatus");
            }

            @Override
            public void onSuccess(AppQueryDevConnectEntity data) {
                if (isViewAttached() && null != reqView) {
                    reqView.onQueryDeviceConnectStatus(data);
                }
            }
        });
    }

    public void AppRemoveMessageReq(String aid, String msgId, String devUid, AppRemoveMessageReqView reqView) throws NoInternetException, NoAttachViewException {
        if (!AppUtils.isHaveInternet(CatEyeSDKInterface.get().getContext())) {
            throw new NoInternetException();
        }
        if (!isViewAttached()) {
            throw new NoAttachViewException();
        }
        CatEyeModel.AppRemoveMessageReq(aid, msgId, devUid, new CallBack<AppRemoveMessageEntity>() {
            @Override
            public void onStart() {
                if (isViewAttached() && null != reqView)
                    reqView.showLoading();
            }

            @Override
            public void onComplete() {
                if (isViewAttached() && null != reqView)
                    reqView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                if (isViewAttached() && null != reqView)
                    reqView.onRequestError(msg, "deleteEvent");
            }

            @Override
            public void onSuccess(AppRemoveMessageEntity data) {
                if (isViewAttached() && null != reqView) {
                    reqView.onRemoveEventSuccess(data);
                }
            }
        });
    }

    public void AppBarcodeReq(String aid, String countryCode, int timeZone, String ssid, String password, AppBarcodeReqView reqView) throws NoInternetException, NoAttachViewException {
        if (!AppUtils.isHaveInternet(CatEyeSDKInterface.get().getContext())) {
            throw new NoInternetException();
        }
        if (!isViewAttached()) {
            throw new NoAttachViewException();
        }

        CatEyeModel.AppBarcodeReq(aid, countryCode, timeZone, ssid, password, new CallBack<AppBarcodeReqEntity>() {
            @Override
            public void onStart() {
                if (isViewAttached() && null != reqView)
                    reqView.showLoading();
            }

            @Override
            public void onComplete() {
                if (isViewAttached() && null != reqView)
                    reqView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                if (isViewAttached() && null != reqView)
                    reqView.onRequestError(msg, "createQrCode");
            }

            @Override
            public void onSuccess(AppBarcodeReqEntity data) {
                if (isViewAttached() && null != reqView)
                    reqView.onAppBarcodeReqSuccess(data);
            }
        });
    }

    public void AppQueryAidBindReq(String app_aid, AppQueryAidBindRquView reqView) throws NoInternetException, NoAttachViewException {
        if (!AppUtils.isHaveInternet(CatEyeSDKInterface.get().getContext())) {
            throw new NoInternetException();
        }
        if (!isViewAttached()) {
            throw new NoAttachViewException();
        }

        CatEyeModel.AppQueryAidBindReq(app_aid, new CallBack<AppQueryAidBindEntity>() {
            @Override
            public void onStart() {
                if (isViewAttached() && null != reqView)
                    reqView.showLoading();
            }

            @Override
            public void onComplete() {
                if (isViewAttached() && null != reqView)
                    reqView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                if (isViewAttached() && null != reqView)
                    reqView.onRequestError(msg, "queryBindStatus");
            }

            @Override
            public void onSuccess(AppQueryAidBindEntity data) {
                if (isViewAttached() && null != reqView)
                    reqView.onAppQueryAidBindReqSuccess(data);
            }
        });
    }

    public void AppShareDeviceReq(String appAid, String devUid, AppShareDeviceReqView reqView) throws NoInternetException, NoAttachViewException {
        if (!AppUtils.isHaveInternet(CatEyeSDKInterface.get().getContext())) {
            throw new NoInternetException();
        }
        if (!isViewAttached()) {
            throw new NoAttachViewException();
        }

        CatEyeModel.AppShareDeviceReq(appAid, devUid, new CallBack<AppShareDeviceEntity>() {
            @Override
            public void onStart() {
                if (isViewAttached() && null != reqView)
                    reqView.showLoading();
            }

            @Override
            public void onComplete() {
                if (isViewAttached() && null != reqView)
                    reqView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                if (isViewAttached() && null != reqView)
                    reqView.onRequestError(msg, "createShareDeviceQr");
            }

            @Override
            public void onSuccess(AppShareDeviceEntity data) {
                if (isViewAttached() && null != reqView)
                    reqView.onAppShareDeviceReqSuccess(data);
            }
        });
    }

    public void getShareDevice(String aid, AppQuerySharedDeviceReqView reqView) throws NoAttachViewException, NoInternetException {
        if (!AppUtils.isHaveInternet(CatEyeSDKInterface.get().getContext())) {
            throw new NoInternetException();
        }
        if (!isViewAttached()) {
            throw new NoAttachViewException();
        }

        CatEyeModel.AppQuerySharedDeviceReq(aid, new CallBack<AppQuerySharedDeviceEntity>() {
            @Override
            public void onStart() {
                if (isViewAttached() && null != reqView)
                    reqView.showLoading();
            }

            @Override
            public void onComplete() {
                if (isViewAttached() && null != reqView)
                    reqView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                if (isViewAttached() && null != reqView)
                    reqView.onRequestError(msg, "getShareDevice");
            }

            @Override
            public void onSuccess(AppQuerySharedDeviceEntity data) {
                if (isViewAttached() && null != reqView) {
                    reqView.onGetSharedDevice(data);
                }
            }
        });
    }

    //-------------------------------------------------------------------------------------------------------------//
    public void setWeChatPush(String weChatAccountid, String weChatOpenid, String weChatUnionid, int pushOnOff, final PartnerWeixinPushConfigReqView reqView) throws NoInternetException, NoAttachViewException {
        if (!AppUtils.isHaveInternet(CatEyeSDKInterface.get().getContext())) {
            throw new NoInternetException();
        }
        if (!isViewAttached()) {
            throw new NoAttachViewException();
        }
        if (!CatEyeSDKInterface.COMAIOT) return;
        CatEyeModel.setWeChatPush(weChatAccountid, weChatOpenid, weChatUnionid, pushOnOff, new CallBack<PartnerWeixinPushConfigEntity>() {
            @Override
            public void onStart() {
                if (isViewAttached())
                    reqView.showLoading();
            }

            @Override
            public void onComplete() {
                if (isViewAttached())
                    reqView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                if (isViewAttached())
                    reqView.onRequestError(msg, "setWeChatPush");
            }

            @Override
            public void onSuccess(PartnerWeixinPushConfigEntity data) {
                if (isViewAttached())
                    reqView.onSetWeChatPushSwitchComplete(data);
            }
        });
    }

    public void notificationWeChat(String weChatAccountid, String weChatOpenidList, String content, PartnerWeixinPushNoticeReqView reqView) throws NoInternetException, NoAttachViewException {
        if (!AppUtils.isHaveInternet(CatEyeSDKInterface.get().getContext())) {
            throw new NoInternetException();
        }
        if (!isViewAttached()) {
            throw new NoAttachViewException();
        }
        if (!CatEyeSDKInterface.COMAIOT) return;
        CatEyeModel.notificationWeChat(weChatAccountid, weChatOpenidList, content, new CallBack<PartnerWeixinPushNoticeEntity>() {
            @Override
            public void onStart() {
                if (isViewAttached())
                    reqView.showLoading();
            }

            @Override
            public void onComplete() {
                if (isViewAttached())
                    reqView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                if (isViewAttached())
                    reqView.onRequestError(msg, "notificationWeChat");
            }

            @Override
            public void onSuccess(PartnerWeixinPushNoticeEntity data) {
                if (isViewAttached())
                    reqView.onNoticeWeChatComplete(data);
            }
        });
    }

    public void getStorageToken(String device_id, String device_token, String file_name, String msg_type, String file_type, String from_where, String filePath, int msgType) throws NoInternetException, NoAttachViewException {
        if (!AppUtils.isHaveInternet(CatEyeSDKInterface.get().getContext())) {
            throw new NoInternetException();
        }
        if (!isViewAttached()) {
            throw new NoAttachViewException();
        }
        CatEyeModel.getStorageToken(device_id, device_token, file_name, new CallBack<StorageEntity>() {
            @Override
            public void onStart() {
                if (isViewAttached())
                    iMvpView.showLoading();
            }

            @Override
            public void onComplete() {
                if (isViewAttached())
                    iMvpView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                if (isViewAttached())
                    iMvpView.onRequestError(msg, "getStorageToken");
            }

            @Override
            public void onSuccess(StorageEntity data) {
                if (isViewAttached())
                    ((GetStorageView) iMvpView).onGetStorageToken(data, file_name, msg_type, file_type, from_where, filePath, msgType, -1);
            }
        });
    }

    public void queryAgoraSocketUserNumber(String channelName) throws NoInternetException, NoAttachViewException {
        if (!AppUtils.isHaveInternet(CatEyeSDKInterface.get().getContext())) {
            throw new NoInternetException();
        }
        if (!isViewAttached()) {
            throw new NoAttachViewException();
        }
        CatEyeModel.queryAgoraSocketUserNumber(channelName, new CallBack<ArogaBean<ArogaBean.Data>>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onComplete() {

            }

            @Override
            public void onError(String msg) {
                if (isViewAttached())
                    iMvpView.onRequestError(msg, "queryAgoraSocketUserNumber");
            }

            @Override
            public void onSuccess(ArogaBean<ArogaBean.Data> data) {
                if (isViewAttached())
                    ((QueryArogaUserView) iMvpView).onQueryArogaUserNumberSucc(data);
            }
        });
    }

    public void agoraLicenses(String custom, String credential) throws NoInternetException, NoAttachViewException {
        if (!AppUtils.isHaveInternet(CatEyeSDKInterface.get().getContext())) {
            throw new NoInternetException();
        }
        if (!isViewAttached()) {
            throw new NoAttachViewException();
        }
        CatEyeModel.agoraLicenses(custom, credential, new CallBack<ArogaBean.Licenses>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onComplete() {

            }

            @Override
            public void onError(String msg) {
                if (isViewAttached())
                    iMvpView.onRequestError(msg, "agoraLicenses");
            }

            @Override
            public void onSuccess(ArogaBean.Licenses data) {
                if (isViewAttached())
                    ((AgoraLicensesView) iMvpView).onAgoraLicensesGetSuccess(data);
            }
        });
    }

    public void getStorageToken(String device_id, String device_token, String file_name, String msg_type, String file_type, String from_where, String filePath, int msgType, long createMsgTime) throws NoInternetException, NoAttachViewException {
        if (!AppUtils.isHaveInternet(CatEyeSDKInterface.get().getContext())) {
            throw new NoInternetException();
        }
        if (!isViewAttached()) {
            throw new NoAttachViewException();
        }
        CatEyeModel.getStorageToken(device_id, device_token, file_name, new CallBack<StorageEntity>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onComplete() {

            }

            @Override
            public void onError(String msg) {
                if (isViewAttached())
                    iMvpView.onRequestError(msg, "getStorageToken");
            }

            @Override
            public void onSuccess(StorageEntity data) {
                if (isViewAttached())
                    ((GetStorageView) iMvpView).onGetStorageToken(data, file_name, msg_type, file_type, from_where, filePath, msgType, createMsgTime);
            }
        });
    }

    public void HeaderImageTokenReq(String appUid, String token, String file_name, String filePath) throws NoInternetException, NoAttachViewException {
        if (!AppUtils.isHaveInternet(CatEyeSDKInterface.get().getContext())) {
            throw new NoInternetException();
        }
        if (!isViewAttached()) {
            throw new NoAttachViewException();
        }
        CatEyeModel.HeaderImageTokenReq(appUid, token, file_name, new CallBack<StorageEntity>() {
            @Override
            public void onStart() {
                if (isViewAttached())
                    iMvpView.showLoading();
            }

            @Override
            public void onComplete() {
                if (isViewAttached())
                    iMvpView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                if (isViewAttached())
                    iMvpView.onRequestError(msg, "HeaderImageTokenReq");
            }

            @Override
            public void onSuccess(StorageEntity data) {
                Log.e("Comaiot_App: ", "CatEyeController HeaderImageTokenReq onSuccess data: " + data + " filePath: " + filePath);
                if (isViewAttached())
                    ((GetStorageView) iMvpView).onGetStorageToken(data, filePath);
            }
        });
    }

    public void HeaderImageTokenReq(String appUid, String token, String file_name, String filePath, GetStorageView ReqView) throws NoInternetException, NoAttachViewException {
        if (!AppUtils.isHaveInternet(CatEyeSDKInterface.get().getContext())) {
            throw new NoInternetException();
        }
        if (!isViewAttached()) {
            throw new NoAttachViewException();
        }
        CatEyeModel.HeaderImageTokenReq(appUid, token, file_name, new CallBack<StorageEntity>() {
            @Override
            public void onStart() {
                if (isViewAttached())
                    ReqView.showLoading();
            }

            @Override
            public void onComplete() {
                if (isViewAttached())
                    ReqView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                if (isViewAttached())
                    ReqView.onRequestError(msg, "HeaderImageTokenReq");
            }

            @Override
            public void onSuccess(StorageEntity data) {
                Log.e("Comaiot_App: ", "CatEyeController HeaderImageTokenReq onSuccess data: " + data + " filePath: " + filePath);
                if (isViewAttached())
                    ReqView.onGetStorageToken(data, filePath);
            }
        });
    }

    public void smsToPhone(String phone_num, String signName, SmsTokenReqView reqView) throws NoInternetException, NoAttachViewException {
        if (!AppUtils.isHaveInternet(CatEyeSDKInterface.get().getContext())) {
            throw new NoInternetException();
        }
        if (!isViewAttached()) {
            throw new NoAttachViewException();
        }
        if (!CatEyeSDKInterface.COMAIOT) return;
        CatEyeModel.smsToPhone(phone_num, signName, new CallBack<SmsEntity>() {
            @Override
            public void onStart() {
                if (isViewAttached())
                    reqView.showLoading();
            }

            @Override
            public void onComplete() {
                if (isViewAttached())
                    reqView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                if (isViewAttached())
                    reqView.onRequestError(msg, "sendSms");
            }

            @Override
            public void onSuccess(SmsEntity data) {
                if (isViewAttached())
                    reqView.onGetSmsToken(data);
            }
        });
    }

    public void AppReg(Context context, String countryCode) throws NoInternetException, NoAttachViewException {
        if (!AppUtils.isHaveInternet(context)) {
            throw new NoInternetException();
        }
        if (!isViewAttached()) {
            throw new NoAttachViewException();
        }
        CatEyeModel.AppReg(countryCode);
    }

    public void AppQueryAccountReq(String type, String email, String phoneNumber, String weChatCode, AppQueryAccountReqView ReqView) throws NoInternetException, NoAttachViewException {
        if (!AppUtils.isHaveInternet(CatEyeSDKInterface.get().getContext())) {
            throw new NoInternetException();
        }
        if (!isViewAttached()) {
            throw new NoAttachViewException();
        }
        if (!CatEyeSDKInterface.COMAIOT) return;
        CatEyeModel.AppQueryAccountReq(type, email, phoneNumber, weChatCode, new CallBack<AppQueryAccountEntity>() {
            @Override
            public void onStart() {
                if (isViewAttached())
                    ReqView.showLoading();
            }

            @Override
            public void onComplete() {
                if (isViewAttached())
                    ReqView.hideLoading();
            }

            @Override
            public void onError(String errcode) {
                if (isViewAttached())
                    ReqView.onRequestError(errcode, "AppQueryAccountReq");
            }

            @Override
            public void onSuccess(AppQueryAccountEntity data) {
                if (isViewAttached())
                    ReqView.onAppQueryAccountReqSuccess(data);
            }
        });
    }

    public void bindPhoneNumber(String phone_num, String verify_code, String password, String nickname, String email, BindPhoneView reqView) throws NoInternetException, NoAttachViewException {
        if (!AppUtils.isHaveInternet(CatEyeSDKInterface.get().getContext())) {
            throw new NoInternetException();
        }
        if (!isViewAttached()) {
            throw new NoAttachViewException();
        }
        if (!CatEyeSDKInterface.COMAIOT) return;
        CatEyeModel.bindPhone(phone_num, verify_code, password, nickname, email, new CallBack<BindPhoneEntity>() {
            @Override
            public void onStart() {
                if (isViewAttached())
                    reqView.showLoading();
            }

            @Override
            public void onComplete() {
                if (isViewAttached())
                    reqView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                if (isViewAttached())
                    reqView.onRequestError(msg, "bindPhoneNumber");
            }

            @Override
            public void onSuccess(BindPhoneEntity data) {
                if (isViewAttached())
                    reqView.onBindPhoneResponse(data);
            }
        });
    }

    public void LoginByPassword(String appUid, String appEnvid, String subscribe_type, String phoneNumber, String password, String push_id, String type) {
        if (!isViewAttached()) {
            return;
        }
        Log.e("LoginByPassword", "CatEyeController LoginByPassword push_id:" + push_id);
        CatEyeModel.LoginByPassword(appUid, appEnvid, subscribe_type, phoneNumber, password, push_id, type, new CallBack<AppSubscribeEntity>() {
            @Override
            public void onStart() {
                if (isViewAttached())
                    iMvpView.showLoading();
            }

            @Override
            public void onComplete() {
                if (isViewAttached())
                    iMvpView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                Log.e("LoginByPassword", "CatEyeController LoginByPassword onError:" + msg);
                if (isViewAttached())
                    iMvpView.onRequestError(msg, "LoginByPassword");
            }

            @Override
            public void onSuccess(AppSubscribeEntity data) {
                Log.e("LoginByPassword", "CatEyeController LoginByPassword onSuccess:" + data.toString());
                if (isViewAttached())
                    ((AppSubscribeReqView) iMvpView).onSubscribeSuccess(data.getContent().getExpire());
            }
        });
    }

    public void LoginByPhone(String appUid, String appEnvid, String subscribe_type, String phoneNumber, String password, String push_id, String type) {
        if (!isViewAttached()) {
            return;
        }
        CatEyeModel.LoginByPhone(appUid, appEnvid, subscribe_type, phoneNumber, password, push_id, type, new CallBack<AppSubscribeEntity>() {
            @Override
            public void onStart() {
                if (isViewAttached())
                    iMvpView.showLoading();
            }

            @Override
            public void onComplete() {
                if (isViewAttached())
                    iMvpView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                if (isViewAttached())
                    iMvpView.onRequestError(msg, "LoginByPhone");
            }

            @Override
            public void onSuccess(AppSubscribeEntity data) {
                if (isViewAttached())
                    ((AppSubscribeReqView) iMvpView).onSubscribeSuccess(data.getContent().getExpire());
            }
        });
    }

    public void LoginByPhone(Context context, String appUid, String appEnvid, String subscribe_type, String phoneNumber, String password, String push_id, String type, AppSubscribeReqView ReqView) {
        if (!isViewAttached()) {
            return;
        }
        CatEyeModel.LoginByPhone(context, appUid, appEnvid, subscribe_type, phoneNumber, password, push_id, type, new CallBack<AppSubscribeEntity>() {
            @Override
            public void onStart() {
                if (isViewAttached())
                    ReqView.showLoading();
            }

            @Override
            public void onComplete() {
                if (isViewAttached())
                    ReqView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                if (isViewAttached())
                    ReqView.onRequestError(msg, "LoginByPhone");
            }

            @Override
            public void onSuccess(AppSubscribeEntity data) {
                if (isViewAttached())
                    ReqView.onSubscribeSuccess(data.getContent().getExpire());
            }
        });
    }

    public void PartnerShareDeviceReq(String devUid, String phone_num, String jwt, PartnerShareDeviceReqView reqView) throws NoInternetException, NoAttachViewException {
        if (!AppUtils.isHaveInternet(CatEyeSDKInterface.get().getContext())) {
            throw new NoInternetException();
        }
        if (!isViewAttached()) {
            throw new NoAttachViewException();
        }

        CatEyeModel.PartnerShareDeviceReq(devUid, phone_num, jwt, new CallBack<PartnerShareDeviceEntity>() {
            @Override
            public void onStart() {
                if (isViewAttached())
                    reqView.showLoading();
            }

            @Override
            public void onComplete() {
                if (isViewAttached())
                    reqView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                if (isViewAttached())
                    reqView.onRequestError(msg, "partNerShareDevice");
            }

            @Override
            public void onSuccess(PartnerShareDeviceEntity data) {
                if (isViewAttached())
                    reqView.onPartnerShareDeviceReqSuccess(data);
            }
        });
    }

    public void PartnerChangePhoneReq(String phoneNumber, String jwt, PartnerChangePhoneReqView reqView) throws NoInternetException, NoAttachViewException {
        if (!AppUtils.isHaveInternet(CatEyeSDKInterface.get().getContext())) {
            throw new NoInternetException();
        }
        if (!isViewAttached()) {
            throw new NoAttachViewException();
        }

        CatEyeModel.PartnerChangePhoneReq(phoneNumber, jwt, new CallBack<PartnerChangePhoneEntity>() {
            @Override
            public void onStart() {
                if (isViewAttached())
                    reqView.showLoading();
            }

            @Override
            public void onComplete() {
                if (isViewAttached())
                    reqView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                if (isViewAttached())
                    reqView.onRequestError(msg, "partNerChangePhoneNumber");
            }

            @Override
            public void onSuccess(PartnerChangePhoneEntity data) {
                if (isViewAttached())
                    reqView.onChangePhoneNumberSuccess(data);
            }
        });
    }

    public void sendEmail(String email, EmailTokenReqView reqView) throws NoInternetException, NoAttachViewException {
        if (!AppUtils.isHaveInternet(CatEyeSDKInterface.get().getContext())) {
            throw new NoInternetException();
        }
        if (!isViewAttached()) {
            throw new NoAttachViewException();
        }
        if (!CatEyeSDKInterface.COMAIOT) return;
        CatEyeModel.sendEmail(email, new CallBack<EmailTokenEntity>() {
            @Override
            public void onStart() {
                if (isViewAttached())
                    reqView.showLoading();
            }

            @Override
            public void onComplete() {
                if (isViewAttached())
                    reqView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                if (isViewAttached())
                    reqView.onRequestError(msg, "sendEmail");
            }

            @Override
            public void onSuccess(EmailTokenEntity data) {
                if (isViewAttached())
                    reqView.onEmailToken(data);
            }
        });
    }

    public void AppQueryPushAccountReq(AppQueryPushAccountReqView reqView) throws NoInternetException, NoAttachViewException {
        if (!AppUtils.isHaveInternet(CatEyeSDKInterface.get().getContext())) {
            throw new NoInternetException();
        }
        if (!isViewAttached()) {
            throw new NoAttachViewException();
        }

        CatEyeModel.AppQueryPushAccountReq(new CallBack<AppQueryPushAccountEntity>() {
            @Override
            public void onStart() {
                if (isViewAttached())
                    reqView.showLoading();
            }

            @Override
            public void onComplete() {
                if (isViewAttached())
                    reqView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                if (isViewAttached())
                    reqView.onRequestError(msg, "queryPushAccount");
            }

            @Override
            public void onSuccess(AppQueryPushAccountEntity data) {
                if (isViewAttached())
                    reqView.onQueryPushAccount(data);
            }
        });
    }
}

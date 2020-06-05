package com.comaiot.net.library.inter;

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
import com.comaiot.net.library.req_params.AppDownloadDevConfigEntity;

import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

public interface CatEyeService {

    /* ---------------------------------- AppAccount App 账号相关接口, 如登录, 注册, 退出等 ----------------------------------*/
    @POST("api/v2/AppRegReq")
    Observable<RegEntity> AppReg(@Body RequestBody body);

    @POST("api/v2/AppBindphoneReq")
    Observable<BindPhoneEntity> bindPhone(@Body RequestBody body);

    @POST("api/v2/AppQueryAccountReq")
    Observable<AppQueryAccountEntity> AppQueryAccountReq(@Body RequestBody body);

    @POST("api/v2/AppSubscribeReq")
    Observable<AppSubscribeEntity> AppSubscribeReq(@Body RequestBody body);

    @POST("api/v2/AppEmailSubscribeReq")
    Observable<AppSubscribeEntity> AppEmailSubscribeReq(@Body RequestBody body);

    @POST("api/v2/AppUnsubscribeReq")
    Observable<AppUnSubscribeEntity> AppUnSubscribeReq(@Body RequestBody body);

    @POST("api/v2/AppRefreshTokenReq")
    Observable<AppRefreshTokenEntity> AppRefreshTokenReq(@Body RequestBody body);

    @POST("api/v2/AppChangePasswordReq")
    Observable<AppChangePasswordEntity> AppChangePasswordReq(@Body RequestBody body);

    @POST("api/v2/AppResetPasswordByPhoneReq")
    Observable<AppResetPasswordByPhoneEntity> AppResetPasswordByPhoneReq(@Body RequestBody body);

    @POST("api/v2/AppResetPasswordByEmailReq")
    Observable<AppResetPasswordByEmailEntity> AppResetPasswordByEmailReq(@Body RequestBody body);

    @POST("api/v2/AppChangeAccountInfoReq")
    Observable<AppChangeAccountInfoEntity> AppChangeAccountInfoReq(@Body RequestBody body);

    @POST("api/v2/AppChangePhoneReq")
    Observable<AppChangePhoneEntity> AppChangePhoneReq(@Body RequestBody body);

    @POST("api/v2/AppBindWeixinReq")
    Observable<AppBindWeixinEntity> AppBindWeixinReq(@Body RequestBody body);

    @POST("api/v2/AppBindEmailReq")
    Observable<AppBindEmailEntity> AppBindEmailReq(@Body RequestBody body);

    @POST("api/v2/AppRemoveAccountReq")
    Observable<AppRemoveAccountEntity> AppRemoveAccountReq(@Body RequestBody body);

    /* ---------------------------------- AppFunctions App 各项功能列表 -------------------------------------*/

    @POST("api/v2/AppAidReq")
    Observable<AppAidEntity> AppAidReq(@Body RequestBody body);

    @POST("api/v2/AppUploadConfigReq")
    Observable<AppUploadConfigEntity> AppUploadConfigReq(@Body RequestBody body);

    @POST("api/v2/AppDownloadConfigReq")
    Observable<AppDownloadConfigEntity> AppDownloadConfigReq(@Body RequestBody body);

    @POST("api/v2/AppRemoveAidReq")
    Observable<AppRemoveAidEntity> AppRemoveAidReq(@Body RequestBody body);

    @POST("api/v2/AppRemoveSharedDeviceReq")
    Observable<AppRemoveSharedDeviceEntity> AppRemoveSharedDeviceReq(@Body RequestBody body);

    @POST("api/v2/AppDownloadDevConfigReq")
    Observable<AppDownloadDevConfigEntity> getDeviceConfig(@Body RequestBody body);

    @POST("api/v2/AppQueryDevConnectReq")
    Observable<AppQueryDevConnectEntity> AppQueryDevConnectReq(@Body RequestBody body);

    @POST("api/v2/AppRemoveMessageReq")
    Observable<AppRemoveMessageEntity> AppRemoveMessageReq(@Body RequestBody body);

    @POST("api/v2/AppBarcodeReq")
    Observable<AppBarcodeReqEntity> AppBarcodeReq(@Body RequestBody body);

    @POST("api/v2/AppQueryAidBindReq")
    Observable<AppQueryAidBindEntity> AppQueryAidBindReq(@Body RequestBody body);

    @POST("api/v2/AppShareDeviceReq")
    Observable<AppShareDeviceEntity> AppShareDeviceReq(@Body RequestBody body);

    @POST("api/v2/AppReceiveShareReq")
    Observable<AppReceiveShareEntity> AppReceiveShareReq(@Body RequestBody body);

    @POST("api/v2/AppQuerySharedDeviceReq")
    Observable<AppQuerySharedDeviceEntity> AppQuerySharedDeviceReq(@Body RequestBody body);

    /* -------------------------- PartnerFunctions 提供给第三方如优点科技的调用接口 -----------------------------*/
    @POST("api/v2/PartnerSubscribeReq")
    Observable<AppSubscribeEntity> loginServer(@Body RequestBody body);

    @POST("api/v2/PartnerWeixinPushConfigReq")
    Observable<PartnerWeixinPushConfigEntity> setWeChatPush(@Body RequestBody body);

    @POST("api/v2/PartnerWeixinPushNoticeReq")
    Observable<PartnerWeixinPushNoticeEntity> notificationWeChat(@Body RequestBody body);

    @POST("api/v2/StoreTokenReq")
    Observable<StorageEntity> getStorageToken(@Body RequestBody body);

    @POST("api/v2/HeaderImageTokenReq")
    Observable<StorageEntity> HeaderImageTokenReq(@Body RequestBody body);

    @POST("api/v2/SmsTokenReq")
    Observable<SmsEntity> smsToPhone(@Body RequestBody body);

    @POST("api/v2/AppSubscribeReq")
    Observable<AppSubscribeEntity> LoginByPassword(@Body RequestBody body);

    @POST("api/v2/PartnerShareDeviceReq")
    Observable<PartnerShareDeviceEntity> PartnerShareDeviceReq(@Body RequestBody var1);

    @POST("api/v2/PartnerChangePhoneReq")
    Observable<PartnerChangePhoneEntity> PartnerChangePhoneReq(@Body RequestBody var1);

    @POST("api/v2/EmailTokenReq")
    Observable<EmailTokenEntity> EmailTokenReq(@Body RequestBody var1);

    @POST("api/v2/AppQueryPushAccountReq")
    Observable<AppQueryPushAccountEntity> AppQueryPushAccountReq(@Body RequestBody var1);
}

package com.comaiot.net.library.inter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.util.Base64;

import com.comaiot.net.library.Model.DESUtils;
import com.comaiot.net.library.bean.ArogaBean;
import com.comaiot.net.library.core.CatEyeSDKInterface;
import com.comaiot.net.library.utils.Logger;
import com.comaiot.net.library.req_params.ArogaLicensesParams;
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
import com.comaiot.net.library.prfs.CatEyePreferences;
import com.comaiot.net.library.req_params.AppBarcodeParams;
import com.comaiot.net.library.req_params.AppBindEmailParams;
import com.comaiot.net.library.req_params.AppBindWeixinParams;
import com.comaiot.net.library.req_params.AppChangeAccountInfoParams;
import com.comaiot.net.library.req_params.AppChangePasswordParams;
import com.comaiot.net.library.req_params.AppChangePhoneParams;
import com.comaiot.net.library.req_params.AppDownloadConfigParams;
import com.comaiot.net.library.req_params.AppDownloadDevConfigEntity;
import com.comaiot.net.library.req_params.AppDownloadDevConfigParams;
import com.comaiot.net.library.req_params.AppEmailSubscribeReqParams;
import com.comaiot.net.library.req_params.AppQueryAccountParams;
import com.comaiot.net.library.req_params.AppQueryAidBindParams;
import com.comaiot.net.library.req_params.AppQueryPushAccountParams;
import com.comaiot.net.library.req_params.AppReceiveShareParams;
import com.comaiot.net.library.req_params.AppRemoveAccountParams;
import com.comaiot.net.library.req_params.AppRemoveAidParams;
import com.comaiot.net.library.req_params.AppRemoveMessageReqParams;
import com.comaiot.net.library.req_params.AppRemoveSharedDeviceParams;
import com.comaiot.net.library.req_params.AppResetPasswordByPhoneParams;
import com.comaiot.net.library.req_params.AppShareDeviceParams;
import com.comaiot.net.library.req_params.AppSubscribeParams;
import com.comaiot.net.library.req_params.AppUnSubscribeParams;
import com.comaiot.net.library.req_params.AppUploadConfigParams;
import com.comaiot.net.library.req_params.BindPhoneParams;
import com.comaiot.net.library.req_params.EmailTokenReqParams;
import com.comaiot.net.library.req_params.PartnerShareDeviceParams;
import com.comaiot.net.library.req_params.PartnerWeixinPushConfigParams;
import com.comaiot.net.library.req_params.PartnerWeixinPushNoticeParams;
import com.comaiot.net.library.req_params.RegParams;
import com.comaiot.net.library.req_params.SmsParams;
import com.comaiot.net.library.req_params.StorageParams;
import com.comaiot.net.library.req_params.CatEyeLoginParams;
import com.comaiot.net.library.util.ConfigProperties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static com.comaiot.net.library.Model.DESUtils.AITE;
import static com.comaiot.net.library.Model.DESUtils.DAYIN;
import static com.comaiot.net.library.Model.DESUtils.DESHIMAN;
import static com.comaiot.net.library.Model.DESUtils.FANGHUI;
import static com.comaiot.net.library.Model.DESUtils.GVS;
import static com.comaiot.net.library.Model.DESUtils.HONYAR;
import static com.comaiot.net.library.Model.DESUtils.HUNE;
import static com.comaiot.net.library.Model.DESUtils.IFLYTEK;
import static com.comaiot.net.library.Model.DESUtils.IWR;
import static com.comaiot.net.library.Model.DESUtils.JIANSHI;
import static com.comaiot.net.library.Model.DESUtils.KUNSHANG;
import static com.comaiot.net.library.Model.DESUtils.LEIXUNKEWEI;
import static com.comaiot.net.library.Model.DESUtils.MANYA;
import static com.comaiot.net.library.Model.DESUtils.PHILIPS;
import static com.comaiot.net.library.Model.DESUtils.RUDOLPH;
import static com.comaiot.net.library.Model.DESUtils.RUOCHAN;
import static com.comaiot.net.library.Model.DESUtils.YD;
import static com.comaiot.net.library.Model.DESUtils.ZHOUYAYUN;


@SuppressWarnings("all")
public class RetrofitUtil {

    private static final String AGORA_BASE_URL = "http://api.agora.io/dev/v1/";
    private static final String AGORA_LICENSES_URL = "https://api.agora.io/dev/v2/";

    private static final int DEFAULT_TIMEOUT = 15;
    private static Context mContext;


    private Retrofit mCatEyeRetrofit;
    private Retrofit mAgoraRetrofit;
    private Retrofit mAgoraLicensesRetrofit;

    private CatEyeService mCatEyeService;
    private AgoraService mAgoraService;
    private AgoraService mAgoraLicensesService;

    private static RetrofitUtil mInstance;
    private final String ak;
    private final String sk;

    public static void getInstance(Context context, String ak, String sk) {
        mContext = context;
        String urlPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/CatEyeSDK/BaseUrl/url.txt";
        File file = new File(urlPath);
        if (!file.exists()) {
            try {
                File configDir = new File(file.getParent());
                if (!configDir.exists()) {
                    configDir.mkdirs();
                }
                file.createNewFile();
            } catch (IOException e) {
                Logger.ee("Can not create BaseUrl file " + e.toString());
            }
        } else {
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(urlPath);
                byte[] buffer = new byte[256];
                fis.read(buffer);
                String configUrl = new String(buffer, "utf-8").trim();
                if (configUrl.isEmpty() || configUrl.length() > 50 || configUrl.length() < 10 || !configUrl.contains("http")) {
                    fis.close();
                } else {
                    BaseUrl.setBaseUrl(configUrl);
                }
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    if (null != fis)
                        fis.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        Logger.init(mContext);

        if (null == mInstance) {
            synchronized (Object.class) {
                if (null == mInstance) {
                    mInstance = new RetrofitUtil(ak, sk);
                }
            }
        }
    }

    protected static String getBaseUrl() {
        return BaseUrl.getBaseUrl();
    }

    /**
     * 单例模式
     *
     * @return
     */
    public static RetrofitUtil getInstance() {
        return mInstance;
    }

    private RetrofitUtil(String ak, String sk) {
        this.ak = ak;
        this.sk = sk;
        //手动创建一个OkHttpClient并设置超时时间
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .sslSocketFactory(createSSLSocketFactory())
                .hostnameVerifier(new TrustAllHostnameVerifier())
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request()
                                .newBuilder()
                                .addHeader("Content-Type", "application/json")
                                .build();
                        Response proceed = chain.proceed(request);
                        return proceed;
                    }
                });
        builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        builder.readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        builder.writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);

        //-------------------------------CatEyeSDK-----------------------------//
        mCatEyeRetrofit = new Retrofit.Builder()
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(BaseUrl.getBaseUrl())
                .build();

        //------------------------------agora-------------------------------//
        String credentials = "7f6225d84839403a98ee1c0ed662c011:d8f227018cd44ca781772a5c011de4b0";
        final String basic = "Basic " + Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);
        OkHttpClient.Builder arogaBuilder = new OkHttpClient.Builder()
                .sslSocketFactory(createSSLSocketFactory())
                .hostnameVerifier(new TrustAllHostnameVerifier())
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request()
                                .newBuilder()
                                .addHeader("Content-Type", "application/json")
                                .addHeader("Authorization", basic)
                                .build();
                        return chain.proceed(request);
                    }
                });

        mAgoraRetrofit = new Retrofit.Builder()
                .client(arogaBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(AGORA_BASE_URL)
                .build();

        mAgoraLicensesRetrofit = new Retrofit.Builder()
                .client(arogaBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(AGORA_LICENSES_URL)
                .build();

        mCatEyeService = mCatEyeRetrofit.create(CatEyeService.class);
        mAgoraService = mAgoraRetrofit.create(AgoraService.class);
        mAgoraLicensesService = mAgoraLicensesRetrofit.create(AgoraService.class);
    }

    /**
     * 默认信任所有的证书
     * TODO 最好加上证书认证，主流App都有自己的证书
     *
     * @return
     */
    @SuppressLint("TrulyRandom")
    private static SSLSocketFactory createSSLSocketFactory() {

        SSLSocketFactory sSLSocketFactory = null;

        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, new TrustManager[]{new TrustAllManager()},
                    new SecureRandom());
            sSLSocketFactory = sc.getSocketFactory();
        } catch (Exception e) {
        }

        return sSLSocketFactory;
    }

    private static class TrustAllManager implements X509TrustManager {
        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType)
                throws CertificateException {
        }

        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType)

                throws CertificateException {
        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    private static class TrustAllHostnameVerifier implements HostnameVerifier {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }

    public void AppReg(String countryCode, Subscriber<RegEntity> subscriber) {
        long timestamp = System.currentTimeMillis() / 1000;
        String nonce = StringUtils.get_bit_string(6);
        String sign = StringUtils.sign(sk, timestamp, nonce);

        RegParams params = new RegParams();
        params.setAppak(ak);
        params.setTimestamp(timestamp);
        params.setNonce(nonce);
        params.setSign(sign);
        params.setBrand(Build.BRAND);
        params.setType("Android");
        params.setCountry_code(countryCode);
        String json = GsonUtils.toJson(params);
        Logger.dd("AppReg Json : \n" + json);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

        mCatEyeService.AppReg(requestBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void bindPhone(Subscriber<BindPhoneEntity> subscriber, String phone_num, String verify_code, String password, String nickname, String email) {
        if (!CatEyeSDKInterface.COMAIOT) return;
        BindPhoneParams params = new BindPhoneParams();
        params.setApp_uid(CatEyePreferences.get().getAppUid());
        params.setApp_envid(CatEyePreferences.get().getAppEnvid());
        params.setPhone_num(phone_num);
        params.setVerify_code(verify_code);
        params.setPassword(password);
        params.setEmail(email);
        params.setNickname(nickname);
        String json = GsonUtils.toJson(params);
        Logger.ee("bindPhoneNumber Json : \n" + json);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

        mCatEyeService.bindPhone(requestBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void AppQueryAccountReq(Subscriber<AppQueryAccountEntity> subscriber, String type, String email, String phoneNumber, String weChatCode) {
        if (!CatEyeSDKInterface.COMAIOT) return;
        AppQueryAccountParams params = new AppQueryAccountParams();
        params.setApp_uid(CatEyePreferences.get().getAppUid());
        params.setApp_envid(CatEyePreferences.get().getAppEnvid());
        params.setSubscribe_type(type);
        params.setEmail(email);
        params.setPhone_num(phoneNumber);
        params.setWeixin_code(weChatCode);
        params.setWeixin_type("APP");
        String json = GsonUtils.toJson(params);
        Logger.ee("AppQueryAccountReq Json : \n" + json);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

        mCatEyeService.AppQueryAccountReq(requestBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void login(Subscriber<AppSubscribeEntity> subscriber, String phoneNumber, String password, String pushId, String subscribeType, String verify_code, String weixin_code, String weixin_type) {
        if (!CatEyeSDKInterface.COMAIOT) return;
        long timestamp = System.currentTimeMillis() / 1000;
        String nonce = StringUtils.get_bit_string(6);
        String sign = StringUtils.sign(sk, timestamp, nonce);
        AppSubscribeParams params = new AppSubscribeParams();
        params.setApp_uid(CatEyePreferences.get().getAppUid());
        params.setApp_envid(CatEyePreferences.get().getAppEnvid());
        params.setSubscribe_type(subscribeType);
        params.setPhone_num(phoneNumber);
        params.setVerify_code(verify_code);
        params.setPassword(password);
        params.setWeixin_code(weixin_code);
        params.setWeixin_type(weixin_type);
        params.setPush_id(pushId);
        params.setType("Android");

        params.setVersion(ConfigProperties.getVersion());

        String json = GsonUtils.toJson(params);
        Logger.dd("login" + subscribeType + "Json : \n" + json);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

        mCatEyeService.AppSubscribeReq(requestBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void loginEmail(Subscriber<AppSubscribeEntity> subscriber, String email, String password, String pushId) {
        if (!CatEyeSDKInterface.COMAIOT) return;
        long timestamp = System.currentTimeMillis() / 1000;
        String nonce = StringUtils.get_bit_string(6);
        String sign = StringUtils.sign(sk, timestamp, nonce);
        AppEmailSubscribeReqParams params = new AppEmailSubscribeReqParams();
        params.setApp_uid(CatEyePreferences.get().getAppUid());
        params.setApp_envid(CatEyePreferences.get().getAppEnvid());
        params.setEmail(email);
        params.setPassword(password);
        params.setSub_type("password");
        params.setPush_id(pushId);
        params.setType("Android");

        params.setVersion(ConfigProperties.getVersion());

        String json = GsonUtils.toJson(params);
        Logger.dd("loginEmail Json : \n" + json);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

        mCatEyeService.AppEmailSubscribeReq(requestBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void AppUnSubscribeReq(Subscriber<AppUnSubscribeEntity> subscriber) {
        if (!CatEyeSDKInterface.COMAIOT) return;
        AppUnSubscribeParams params = new AppUnSubscribeParams();
        params.setApp_uid(CatEyePreferences.get().getAppUid());
        params.setApp_envid(CatEyePreferences.get().getAppEnvid());
        params.setToken(CatEyePreferences.get().getToken());

        String json = GsonUtils.toJson(params);
        Logger.ee("AppUnSubscribeReq Json : \n" + json);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

        mCatEyeService.AppUnSubscribeReq(requestBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void refreshToken(Subscriber<AppRefreshTokenEntity> subscriber) {
        AppUnSubscribeParams params = new AppUnSubscribeParams();
        params.setApp_uid(CatEyePreferences.get().getAppUid());
        params.setApp_envid(CatEyePreferences.get().getAppEnvid());
        params.setToken(CatEyePreferences.get().getToken());

        String json = GsonUtils.toJson(params);
        Logger.ee("refreshToken Json : \n" + json);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

        mCatEyeService.AppRefreshTokenReq(requestBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void AppChangePasswordReq(Subscriber<AppChangePasswordEntity> subscriber, String old_password, String new_password) {
        if (!CatEyeSDKInterface.COMAIOT) return;
        AppChangePasswordParams params = new AppChangePasswordParams();
        params.setApp_uid(CatEyePreferences.get().getAppUid());
        params.setApp_envid(CatEyePreferences.get().getAppEnvid());
        params.setToken(CatEyePreferences.get().getToken());
        params.setOld_password(old_password);
        params.setNew_password(new_password);
        String json = GsonUtils.toJson(params);
        Logger.ee("AppChangePasswordReq Json : \n" + json);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

        mCatEyeService.AppChangePasswordReq(requestBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void AppResetPasswordByPhoneReq(Subscriber<AppResetPasswordByPhoneEntity> subscriber, String phoneNumber, String verifyCode, String password) {
        if (!CatEyeSDKInterface.COMAIOT) return;
        AppResetPasswordByPhoneParams params = new AppResetPasswordByPhoneParams();
        params.setApp_uid(CatEyePreferences.get().getAppUid());
        params.setApp_envid(CatEyePreferences.get().getAppEnvid());
        params.setPhone_num(phoneNumber);
        params.setVerify_code(verifyCode);
        params.setPassword(password);

        String json = GsonUtils.toJson(params);
        Logger.ee("AppResetPasswordByPhoneReq Json : \n" + json);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

        mCatEyeService.AppResetPasswordByPhoneReq(requestBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void AppResetPasswordByEmailReq(Subscriber<AppResetPasswordByEmailEntity> subscriber, String phoneNumber, String verifyCode, String password) {
        if (!CatEyeSDKInterface.COMAIOT) return;
        AppResetPasswordByPhoneParams params = new AppResetPasswordByPhoneParams();
        params.setApp_uid(CatEyePreferences.get().getAppUid());
        params.setApp_envid(CatEyePreferences.get().getAppEnvid());
        params.setPhone_num(phoneNumber);
        params.setVerify_code(verifyCode);
        params.setPassword(password);

        String json = GsonUtils.toJson(params);
        Logger.ee("AppResetPasswordByEmailReq Json : \n" + json);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

        mCatEyeService.AppResetPasswordByEmailReq(requestBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void AppChangeAccountInfoReq(Subscriber<AppChangeAccountInfoEntity> subscriber, String email, String avatar, String push_id, String nickname) {
        if (!CatEyeSDKInterface.COMAIOT) return;
        AppChangeAccountInfoParams params = new AppChangeAccountInfoParams();
        params.setApp_uid(CatEyePreferences.get().getAppUid());
        params.setApp_envid(CatEyePreferences.get().getAppEnvid());
        params.setToken(CatEyePreferences.get().getToken());
        params.setEmail(email);
        params.setAvatar(avatar);
        params.setNickname(nickname);
        params.setPushId(push_id);
        params.setType("Android");
        String json = GsonUtils.toJson(params);
        Logger.ee("AppChangeAccountInfoReq Json : \n" + json);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

        mCatEyeService.AppChangeAccountInfoReq(requestBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void AppChangePhoneReq(Subscriber<AppChangePhoneEntity> subscriber, String old_phone_num, String old_verify_code, String new_phone_num, String new_verify_code) {
        if (!CatEyeSDKInterface.COMAIOT) return;
        AppChangePhoneParams params = new AppChangePhoneParams();
        params.setApp_uid(CatEyePreferences.get().getAppUid());
        params.setApp_envid(CatEyePreferences.get().getAppEnvid());
        params.setToken(CatEyePreferences.get().getToken());
        params.setOld_phone_num(old_phone_num);
        params.setOld_verify_code(old_verify_code);
        params.setNew_phone_num(new_phone_num);
        params.setNew_verify_code(new_verify_code);
        String json = GsonUtils.toJson(params);
        Logger.ee("AppChangePhoneReq Json : \n" + json);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

        mCatEyeService.AppChangePhoneReq(requestBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void AppBindWeixinReq(Subscriber<AppBindWeixinEntity> subscriber, String phoneNumber, String verifyCode, String weixin_code) {
        if (!CatEyeSDKInterface.COMAIOT) return;
        AppBindWeixinParams params = new AppBindWeixinParams();
        params.setApp_uid(CatEyePreferences.get().getAppUid());
        params.setApp_envid(CatEyePreferences.get().getAppEnvid());
        params.setPhone_num(phoneNumber);
        params.setVerify_code(verifyCode);
        params.setWeixin_code(weixin_code);
        String json = GsonUtils.toJson(params);
        Logger.ee("AppBindWeixinReq Json : \n" + json);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

        mCatEyeService.AppBindWeixinReq(requestBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void bindEmail(Subscriber<AppBindEmailEntity> subscriber, String email, String verifyCode, String password, String phoneNumber, String nickName) {
        if (!CatEyeSDKInterface.COMAIOT) return;
        AppBindEmailParams params = new AppBindEmailParams();
        params.setApp_uid(CatEyePreferences.get().getAppUid());
        params.setApp_envid(CatEyePreferences.get().getAppEnvid());
        params.setEmail(email);
        params.setVerify_code(verifyCode);
        params.setPassword(password);
        params.setPhone_num(phoneNumber);
        params.setNickname(nickName);
        String json = GsonUtils.toJson(params);
        Logger.dd("bindEmail Json : \n" + json);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

        mCatEyeService.AppBindEmailReq(requestBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void removeAccount(Subscriber<AppRemoveAccountEntity> subscriber) {
        if (!CatEyeSDKInterface.COMAIOT) return;
        AppRemoveAccountParams params = new AppRemoveAccountParams();
        params.setApp_uid(CatEyePreferences.get().getAppUid());
        params.setApp_envid(CatEyePreferences.get().getAppEnvid());
        params.setToken(CatEyePreferences.get().getToken());

        String json = GsonUtils.toJson(params);
        Logger.ee("removeAccount Json : \n" + json);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

        mCatEyeService.AppRemoveAccountReq(requestBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    // ------------------------------------------------------------------------------------------------------------//

    public void AppAidReq(Subscriber<AppAidEntity> subscriber) {
        AppUnSubscribeParams params = new AppUnSubscribeParams();
        params.setApp_uid(CatEyePreferences.get().getAppUid());
        params.setApp_envid(CatEyePreferences.get().getAppEnvid());
        params.setToken(CatEyePreferences.get().getToken());
        String json = GsonUtils.toJson(params);
        Logger.dd("AppAidReq Json : \n" + json);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

        mCatEyeService.AppAidReq(requestBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void uploadConfig(Subscriber<AppUploadConfigEntity> subscriber, String config) {
        if (!CatEyeSDKInterface.COMAIOT) return;
        AppUploadConfigParams params = new AppUploadConfigParams();
        params.setApp_uid(CatEyePreferences.get().getAppUid());
        params.setApp_envid(CatEyePreferences.get().getAppEnvid());
        params.setToken(CatEyePreferences.get().getToken());
        params.setConfig(config);

        String json = GsonUtils.toJson(params);
        Logger.ee("uploadConfig Json : \n" + json);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

        mCatEyeService.AppUploadConfigReq(requestBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void getConfig(Subscriber<AppDownloadConfigEntity> subscriber) {
        if (!CatEyeSDKInterface.COMAIOT) return;
        AppDownloadConfigParams params = new AppDownloadConfigParams();
        params.setApp_uid(CatEyePreferences.get().getAppUid());
        params.setApp_envid(CatEyePreferences.get().getAppEnvid());
        params.setToken(CatEyePreferences.get().getToken());

        String json = GsonUtils.toJson(params);
        Logger.ee("getConfig Json : \n" + json);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

        mCatEyeService.AppDownloadConfigReq(requestBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void AppRemoveAidReq(Subscriber<AppRemoveAidEntity> subscriber, String appAid) {
        AppRemoveAidParams params = new AppRemoveAidParams();
        params.setApp_uid(CatEyePreferences.get().getAppUid());
        params.setApp_envid(CatEyePreferences.get().getAppEnvid());
        params.setApp_aid(appAid);
        params.setToken(CatEyePreferences.get().getToken());
        String json = GsonUtils.toJson(params);
        Logger.ee("AppRemoveAidReq Json : \n" + json);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

        mCatEyeService.AppRemoveAidReq(requestBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void AppRemoveSharedDeviceReq(Subscriber<AppRemoveSharedDeviceEntity> subscriber, String appAid) {
        AppRemoveSharedDeviceParams params = new AppRemoveSharedDeviceParams();
        params.setApp_uid(CatEyePreferences.get().getAppUid());
        params.setApp_envid(CatEyePreferences.get().getAppEnvid());
        params.setApp_aid_remove(appAid);
        params.setToken(CatEyePreferences.get().getToken());
        String json = GsonUtils.toJson(params);
        Logger.ee("AppRemoveSharedDeviceReq Json : \n" + json);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

        mCatEyeService.AppRemoveSharedDeviceReq(requestBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void queryDeviceConnectStatus(Subscriber<AppQueryDevConnectEntity> subscriber, String aid, String devUid) {
        AppDownloadDevConfigParams params = new AppDownloadDevConfigParams();
        params.setApp_uid(CatEyePreferences.get().getAppUid());
        params.setApp_envid(CatEyePreferences.get().getAppEnvid());
        params.setToken(CatEyePreferences.get().getToken());
        params.setApp_aid(aid);
        params.setDev_uid(devUid);

        String json = GsonUtils.toJson(params);
        Logger.ee("queryDeviceConnectStatus Json : \n" + json);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

        mCatEyeService.AppQueryDevConnectReq(requestBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void AppRemoveMessageReq(Subscriber<AppRemoveMessageEntity> subscriber, String aid, String msgId, String devUid) {
        AppRemoveMessageReqParams params = new AppRemoveMessageReqParams();
        params.setApp_uid(CatEyePreferences.get().getAppUid());
        params.setApp_envid(CatEyePreferences.get().getAppEnvid());
        params.setToken(CatEyePreferences.get().getToken());
        params.setApp_aid(aid);
        params.setMsg_id(msgId);
        params.setDev_uid(devUid);

        String json = GsonUtils.toJson(params);
        Logger.ee("AppRemoveMessageReq Json : \n" + json);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

        mCatEyeService.AppRemoveMessageReq(requestBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void AppBarcodeReq(Subscriber<AppBarcodeReqEntity> subscriber, String aid, String countryCode, int timeZone, String ssid, String password) {
        AppBarcodeParams params = new AppBarcodeParams();
        params.setApp_uid(CatEyePreferences.get().getAppUid());
        params.setApp_envid(CatEyePreferences.get().getAppEnvid());
        params.setToken(CatEyePreferences.get().getToken());
        params.setApp_aid(aid);
        params.setCountry_code(countryCode);
        params.setTime_zone(timeZone);
        params.setWifi_ssid(ssid);
        params.setWifi_password(password);
        String json = GsonUtils.toJson(params);
        Logger.ee("AppBarcodeReq Json : \n" + json);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

        mCatEyeService.AppBarcodeReq(requestBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void AppQueryAidBindReq(Subscriber<AppQueryAidBindEntity> subscriber, String app_aid) {
        AppQueryAidBindParams params = new AppQueryAidBindParams();
        params.setApp_uid(CatEyePreferences.get().getAppUid());
        params.setApp_envid(CatEyePreferences.get().getAppEnvid());
        params.setApp_aid(app_aid);
        params.setToken(CatEyePreferences.get().getToken());
        String json = GsonUtils.toJson(params);
        Logger.dd("AppQueryAidBindReq Json : \n" + json);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

        mCatEyeService.AppQueryAidBindReq(requestBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void AppShareDeviceReq(Subscriber<AppShareDeviceEntity> subscriber, String appAid, String devUid) {
        if (!CatEyeSDKInterface.COMAIOT) return;
        AppShareDeviceParams params = new AppShareDeviceParams();
        params.setApp_uid(CatEyePreferences.get().getAppUid());
        params.setApp_envid(CatEyePreferences.get().getAppEnvid());
        params.setApp_aid(appAid);
        params.setToken(CatEyePreferences.get().getToken());
        params.setDev_uid(devUid);
        String json = GsonUtils.toJson(params);
        Logger.ee("AppShareDeviceReq Json : \n" + json);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

        mCatEyeService.AppShareDeviceReq(requestBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void AppQuerySharedDeviceReq(Subscriber<AppQuerySharedDeviceEntity> subscriber, String aid) {
        AppRemoveMessageReqParams params = new AppRemoveMessageReqParams();
        params.setApp_uid(CatEyePreferences.get().getAppUid());
        params.setApp_envid(CatEyePreferences.get().getAppEnvid());
        params.setToken(CatEyePreferences.get().getToken());
        params.setApp_aid(aid);

        String json = GsonUtils.toJson(params);
        Logger.ee("AppQuerySharedDeviceReq Json : \n" + json);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

        mCatEyeService.AppQuerySharedDeviceReq(requestBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    // ------------------------------------------------------------------------------------------------------------//

    public void setWeChatPush(Subscriber<PartnerWeixinPushConfigEntity> subscriber, String weixin_accountid, String weixin_openid, String weixin_unionid, int push_on_off) {
        if (!CatEyeSDKInterface.COMAIOT) return;
        long timestamp = System.currentTimeMillis() / 1000;
        String nonce = StringUtils.get_bit_string(6);
        String sign = StringUtils.sign(sk, timestamp, nonce);

        PartnerWeixinPushConfigParams params = new PartnerWeixinPushConfigParams();
        params.setAppak(ak);
        params.setTimestamp(System.currentTimeMillis() / 1000);
        params.setNonce(nonce);
        params.setSign(sign);
        params.setWeixin_accountid(weixin_accountid);
        params.setWeixin_openid(weixin_openid);
        params.setWeixin_unionid(weixin_unionid);
        params.setPush_on_off(push_on_off == 1 ? "On" : "Off");

        String json = GsonUtils.toJson(params);
        Logger.ee("setWeChatPush Json : \n" + json);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

        mCatEyeService.setWeChatPush(requestBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void notificationWeChat(Subscriber<PartnerWeixinPushNoticeEntity> subscriber, String weChatAccountid, String weChatOpenidList, String content) {
        if (!CatEyeSDKInterface.COMAIOT) return;
        long timestamp = System.currentTimeMillis() / 1000;
        String nonce = StringUtils.get_bit_string(6);
        String sign = StringUtils.sign(sk, timestamp, nonce);

        PartnerWeixinPushNoticeParams params = new PartnerWeixinPushNoticeParams();
        params.setAppak(ak);
        params.setTimestamp(System.currentTimeMillis() / 1000);
        params.setNonce(nonce);
        params.setSign(sign);
        params.setWeixin_accountid(weChatAccountid);
        params.setWeixin_openid_list(weChatOpenidList);
        params.setContent(content);

        String json = GsonUtils.toJson(params);
        Logger.ee("notificationWeChat Json : \n" + json);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

        mCatEyeService.notificationWeChat(requestBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void queryAgoraSocketUserNumber(Subscriber<ArogaBean<ArogaBean.Data>> subscriber, String channelName) {
        String appId = null;

        appId = ConfigProperties.getVideoEngineAppId();

        mAgoraService.queryAgoraSocketUserNumber(appId, channelName)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void agoraLicenses(Subscriber<ArogaBean.Licenses> subscriber, String custom, String credential) {
        String appId = null;

        appId = ConfigProperties.getVideoEngineAppId();

        ArogaLicensesParams params = new ArogaLicensesParams();
        params.setCredential(credential);
        params.setCustom(custom);
        String json = GsonUtils.toJson(params);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);
        mAgoraLicensesService.agoraLicenses(appId, requestBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void getStorageToken(Subscriber<StorageEntity> subscriber, String device_id, String device_token, String file_name) {
        StorageParams params = new StorageParams();
        params.setDevice_id(device_id);
        params.setDevice_token(device_token);
        params.setFile_name(file_name);
        String json = GsonUtils.toJson(params);
        Logger.ee("getStorageToken Json : \n" + json);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

        mCatEyeService.getStorageToken(requestBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void HeaderImageTokenReq(Subscriber<StorageEntity> subscriber, String appUid, String token, String file_name) {
        StorageParams params = new StorageParams();
        params.setDevice_id(appUid);
        params.setDevice_token(token);
        params.setFile_name(file_name);
        String json = GsonUtils.toJson(params);
        Logger.ee("getStorageToken Json : \n" + json);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

        mCatEyeService.HeaderImageTokenReq(requestBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void smsToPhone(Subscriber<SmsEntity> subscriber, String phone_num, String signName) {
        if (!CatEyeSDKInterface.COMAIOT) return;
        SmsParams params = new SmsParams();
        params.setApp_uid(CatEyePreferences.get().getAppUid());
        params.setPhone_num(phone_num);
        params.setApp_envid(CatEyePreferences.get().getAppEnvid());
        params.setSignName(signName);
        String json = GsonUtils.toJson(params);
        Logger.ee("smsToPhone Json : \n" + json);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

        mCatEyeService.smsToPhone(requestBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void LoginByPassword(Subscriber<AppSubscribeEntity> subscriber, String appUid, String appEnvid, String subscribe_type, String phoneNumber, String password, String push_id, String type) {
        AppSubscribeParams params = new AppSubscribeParams();
        params.setApp_uid(appUid);
        params.setApp_envid(appEnvid);
        params.setSubscribe_type(subscribe_type);
        params.setPhone_num(phoneNumber);
        params.setPassword(password);
        params.setPush_id(push_id);
        params.setType(type);
        String json = GsonUtils.toJson(params);
        Logger.ee("LoginByPassword Json : \n" + json);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

        mCatEyeService.LoginByPassword(requestBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void LoginByPhone(Subscriber<AppSubscribeEntity> subscriber, String appUid, String appEnvid, String subscribe_type, String phoneNumber, String password, String push_id, String type) {
        AppSubscribeParams params = new AppSubscribeParams();
        params.setApp_uid(appUid);
        params.setApp_envid(appEnvid);
        params.setSubscribe_type(subscribe_type);
        params.setPhone_num(phoneNumber);
        params.setVerify_code(password);
        params.setPush_id(push_id);
        params.setType(type);
        String json = GsonUtils.toJson(params);
        Logger.ee("LoginByPhone Json : \n" + json);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

        mCatEyeService.LoginByPassword(requestBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void PartnerShareDeviceReq(Subscriber<PartnerShareDeviceEntity> subscriber, String dev_uid, String phone_num, String jwt_token, String nickName) {
        PartnerShareDeviceParams params = new PartnerShareDeviceParams();
        params.setApp_uid(CatEyePreferences.get().getAppUid());
        params.setApp_envid(CatEyePreferences.get().getAppEnvid());
        params.setToken(CatEyePreferences.get().getToken());
        params.setDev_uid(dev_uid);
        params.setPhone_num(phone_num);
        params.setNickname(nickName);
        params.setJwt_token(jwt_token);
        String json = GsonUtils.toJson(params);
        Logger.ee("PartnerShareDeviceReq Json : \n" + json);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);
        mCatEyeService.PartnerShareDeviceReq(requestBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void PartnerChangePhoneReq(Subscriber<PartnerChangePhoneEntity> subscriber, String phoneNumber, String jwt) {
        PartnerShareDeviceParams params = new PartnerShareDeviceParams();
        params.setApp_uid(CatEyePreferences.get().getAppUid());
        params.setApp_envid(CatEyePreferences.get().getAppEnvid());
        params.setToken(CatEyePreferences.get().getToken());
        params.setPhone_num(phoneNumber);
        params.setJwt_token(jwt);
        String json = GsonUtils.toJson(params);
        Logger.ee("PartnerChangePhoneReq Json : \n" + json);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);
        mCatEyeService.PartnerChangePhoneReq(requestBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void sendEmail(Subscriber<EmailTokenEntity> subscriber, String email) {
        if (!CatEyeSDKInterface.COMAIOT) return;
        EmailTokenReqParams params = new EmailTokenReqParams();
        params.setApp_uid(CatEyePreferences.get().getAppUid());
        params.setApp_envid(CatEyePreferences.get().getAppEnvid());
        params.setEmail(email);
        String json = GsonUtils.toJson(params);
        Logger.ee("sendEmail Json : \n" + json);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);
        mCatEyeService.EmailTokenReq(requestBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void AppQueryPushAccountReq(Subscriber<AppQueryPushAccountEntity> subscriber) {
        long timestamp = System.currentTimeMillis() / 1000;
        String nonce = StringUtils.get_bit_string(6);
        String sign = StringUtils.sign(sk, timestamp, nonce);

        AppQueryPushAccountParams params = new AppQueryPushAccountParams();
        params.setAppak(ak);
        params.setTimestamp(System.currentTimeMillis() / 1000);
        params.setNonce(nonce);
        params.setSign(sign);
        params.setBrand(Build.BRAND);
        params.setType("Android");

        String json = GsonUtils.toJson(params);
        Logger.ee("AppQueryPushAccountReq Json : \n" + json);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);
        mCatEyeService.AppQueryPushAccountReq(requestBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
}

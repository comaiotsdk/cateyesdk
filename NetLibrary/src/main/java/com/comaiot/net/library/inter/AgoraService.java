package com.comaiot.net.library.inter;


import com.comaiot.net.library.bean.ArogaBean;

import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;

public interface AgoraService {

    @GET("channel/user/{appid}/{cname}")
    Observable<ArogaBean<ArogaBean.Data>> queryAgoraSocketUserNumber(@Path("appid") String appid, @Path("cname") String cname);

    @POST("apps/{appid}/licenses")
    Observable<ArogaBean.Licenses> agoraLicenses(@Path("appid") String appid, @Body RequestBody body);
}

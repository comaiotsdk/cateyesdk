package com.comaiot.net.library.controller.view;

import com.comaiot.net.library.controller.CatEyeView;
import com.comaiot.net.library.req_params.AppDownloadDevConfigEntity;

public interface AppDownloadDevConfigReqView extends CatEyeView {
    void onGetDeviceConfigSuccess(AppDownloadDevConfigEntity entity);
}

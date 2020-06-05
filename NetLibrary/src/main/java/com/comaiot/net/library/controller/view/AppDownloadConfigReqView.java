package com.comaiot.net.library.controller.view;

import com.comaiot.net.library.bean.AppDownloadConfigEntity;
import com.comaiot.net.library.controller.CatEyeView;

public interface AppDownloadConfigReqView extends CatEyeView {
    void onGetCustomConfigSuccess(AppDownloadConfigEntity entity);
}

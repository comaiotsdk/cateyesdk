package com.comaiot.net.library.controller.view;

import com.comaiot.net.library.bean.AppUploadConfigEntity;
import com.comaiot.net.library.controller.CatEyeView;

public interface AppUploadConfigReqView extends CatEyeView {
    void onUploadCustomConfigSuccess(AppUploadConfigEntity entity);
}

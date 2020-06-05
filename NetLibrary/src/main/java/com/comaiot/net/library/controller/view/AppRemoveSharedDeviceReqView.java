package com.comaiot.net.library.controller.view;

import com.comaiot.net.library.bean.AppRemoveSharedDeviceEntity;
import com.comaiot.net.library.controller.CatEyeView;

public interface AppRemoveSharedDeviceReqView extends CatEyeView {
    void onAppRemoveSharedDeviceSuccess(AppRemoveSharedDeviceEntity baseAppEntity);
}

package com.comaiot.net.library.controller.view;

import com.comaiot.net.library.bean.AppShareDeviceEntity;
import com.comaiot.net.library.controller.CatEyeView;

public interface AppShareDeviceReqView extends CatEyeView {
    void onAppShareDeviceReqSuccess(AppShareDeviceEntity baseAppEntity);
}

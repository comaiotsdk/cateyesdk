package com.comaiot.net.library.controller.view;

import com.comaiot.net.library.bean.AppQuerySharedDeviceEntity;
import com.comaiot.net.library.controller.CatEyeView;

public interface AppQuerySharedDeviceReqView extends CatEyeView {
    void onGetSharedDevice(AppQuerySharedDeviceEntity entity);
}

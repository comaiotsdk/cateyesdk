package com.comaiot.net.library.controller.view;

import com.comaiot.net.library.bean.DeviceListEntity;
import com.comaiot.net.library.controller.CatEyeView;

public interface AppQueryDeviceListReqView extends CatEyeView {
    void onGetDeviceList(DeviceListEntity entity);
}

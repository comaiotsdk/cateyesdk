package com.comaiot.net.library.controller.view;

import com.comaiot.net.library.bean.AppQueryDevConnectEntity;
import com.comaiot.net.library.controller.CatEyeView;

public interface AppQueryDevConnectReqView extends CatEyeView {
    void onQueryDeviceConnectStatus(AppQueryDevConnectEntity entity);
}

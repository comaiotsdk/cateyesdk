package com.comaiot.net.library.controller.view;

import com.comaiot.net.library.bean.DeviceEventEntity;
import com.comaiot.net.library.controller.CatEyeView;

public interface AppDownloadFileReqView extends CatEyeView {
    void onGetEventList(DeviceEventEntity listEntities);
}

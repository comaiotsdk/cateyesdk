package com.comaiot.net.library.controller.view;

import com.comaiot.net.library.bean.AppUnSubscribeEntity;
import com.comaiot.net.library.controller.CatEyeView;

public interface AppUnSubscribeReqView extends CatEyeView {
    void onUnSubscribeSuccess(AppUnSubscribeEntity baseAppEntity);
}

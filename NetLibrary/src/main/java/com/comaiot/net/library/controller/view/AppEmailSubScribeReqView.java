package com.comaiot.net.library.controller.view;

import com.comaiot.net.library.bean.AppSubscribeEntity;
import com.comaiot.net.library.controller.CatEyeView;

public interface AppEmailSubScribeReqView extends CatEyeView {
    void onLoginEmailSuccess(AppSubscribeEntity baseAppEntity);
}

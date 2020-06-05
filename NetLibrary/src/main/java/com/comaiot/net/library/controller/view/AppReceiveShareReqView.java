package com.comaiot.net.library.controller.view;

import com.comaiot.net.library.bean.AppReceiveShareEntity;
import com.comaiot.net.library.controller.CatEyeView;

public interface AppReceiveShareReqView extends CatEyeView {
    void onAppReceiveShareReqSuccess(AppReceiveShareEntity baseAppEntity);
}

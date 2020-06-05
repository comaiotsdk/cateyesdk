package com.comaiot.net.library.controller.view;

import com.comaiot.net.library.bean.AppQueryAccountEntity;
import com.comaiot.net.library.controller.CatEyeView;

public interface AppQueryAccountReqView extends CatEyeView {
    void onAppQueryAccountReqSuccess(AppQueryAccountEntity baseAppEntity);
}
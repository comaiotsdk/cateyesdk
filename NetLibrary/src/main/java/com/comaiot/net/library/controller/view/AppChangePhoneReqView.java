package com.comaiot.net.library.controller.view;

import com.comaiot.net.library.bean.AppChangePhoneEntity;
import com.comaiot.net.library.controller.CatEyeView;

public interface AppChangePhoneReqView extends CatEyeView {
    void onAppChangePhoneReqSuccess(AppChangePhoneEntity baseAppEntity);
}

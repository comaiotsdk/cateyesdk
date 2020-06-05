package com.comaiot.net.library.controller.view;

import com.comaiot.net.library.bean.AppResetPasswordByPhoneEntity;
import com.comaiot.net.library.controller.CatEyeView;

public interface AppResetPasswordByPhoneReqView extends CatEyeView {
    void onAppResetPasswordByPhoneReqSuccess(AppResetPasswordByPhoneEntity baseAppEntity);
}

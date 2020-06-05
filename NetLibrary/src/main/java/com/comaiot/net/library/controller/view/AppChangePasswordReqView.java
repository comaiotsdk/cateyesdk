package com.comaiot.net.library.controller.view;

import com.comaiot.net.library.bean.AppChangePasswordEntity;
import com.comaiot.net.library.controller.CatEyeView;

public interface AppChangePasswordReqView extends CatEyeView {
    void onAppChangePasswordReqSuccess(AppChangePasswordEntity baseAppEntity);
}

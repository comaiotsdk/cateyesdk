package com.comaiot.net.library.controller.view;

import com.comaiot.net.library.bean.AppResetPasswordByEmailEntity;
import com.comaiot.net.library.controller.CatEyeView;

public interface AppResetPasswordByEmailReqView extends CatEyeView {
    void onResetPasswordByEmailSuccess(AppResetPasswordByEmailEntity entity);
}

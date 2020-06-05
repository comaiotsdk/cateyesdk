package com.comaiot.net.library.controller.view;

import com.comaiot.net.library.bean.AppBindEmailEntity;
import com.comaiot.net.library.controller.CatEyeView;

public interface AppBindEmailReqView extends CatEyeView {
    void onBindEmailSuccess(AppBindEmailEntity emailEntity);
}

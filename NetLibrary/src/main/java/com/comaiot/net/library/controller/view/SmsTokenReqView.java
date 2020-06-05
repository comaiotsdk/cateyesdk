package com.comaiot.net.library.controller.view;

import com.comaiot.net.library.bean.SmsEntity;
import com.comaiot.net.library.controller.CatEyeView;

public interface SmsTokenReqView extends CatEyeView {
    void onGetSmsToken(SmsEntity entity);
}

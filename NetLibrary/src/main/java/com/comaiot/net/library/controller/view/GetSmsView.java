package com.comaiot.net.library.controller.view;

import com.comaiot.net.library.bean.BaseAppEntity;
import com.comaiot.net.library.controller.CatEyeView;

public interface GetSmsView extends CatEyeView {
    void onSendSmsSuccess(BaseAppEntity entity);
}

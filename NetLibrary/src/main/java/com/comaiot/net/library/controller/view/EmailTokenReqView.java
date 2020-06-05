package com.comaiot.net.library.controller.view;

import com.comaiot.net.library.bean.EmailTokenEntity;
import com.comaiot.net.library.controller.CatEyeView;

public interface EmailTokenReqView extends CatEyeView {
    void onEmailToken(EmailTokenEntity entity);
}

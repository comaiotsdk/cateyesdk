package com.comaiot.net.library.controller.view;

import com.comaiot.net.library.bean.AppRefreshTokenEntity;
import com.comaiot.net.library.controller.CatEyeView;

public interface AppRefreshTokenView extends CatEyeView {
    void onRefreshTokenSuccess(AppRefreshTokenEntity baseAppEntity);
}

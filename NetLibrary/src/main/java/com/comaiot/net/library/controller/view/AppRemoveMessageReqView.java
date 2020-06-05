package com.comaiot.net.library.controller.view;

import com.comaiot.net.library.bean.AppRemoveMessageEntity;
import com.comaiot.net.library.controller.CatEyeView;

public interface AppRemoveMessageReqView extends CatEyeView {
    void onRemoveEventSuccess(AppRemoveMessageEntity entity);
}

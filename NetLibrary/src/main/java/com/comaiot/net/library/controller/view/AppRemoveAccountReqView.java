package com.comaiot.net.library.controller.view;

import com.comaiot.net.library.bean.AppRemoveAccountEntity;
import com.comaiot.net.library.controller.CatEyeView;

public interface AppRemoveAccountReqView extends CatEyeView {
    void onRemoveAccountSuccess(AppRemoveAccountEntity entity);
}

package com.comaiot.net.library.controller.view;

import com.comaiot.net.library.bean.AppQueryPushAccountEntity;
import com.comaiot.net.library.controller.CatEyeView;

public interface AppQueryPushAccountReqView extends CatEyeView {
    void onQueryPushAccount(AppQueryPushAccountEntity entity);
}

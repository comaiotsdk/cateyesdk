package com.comaiot.net.library.controller.view;

import com.comaiot.net.library.bean.AppRemoveAidEntity;
import com.comaiot.net.library.controller.CatEyeView;

public interface AppRemoveAidReqView extends CatEyeView {
    void onAppRemoveAidReqSuccess(AppRemoveAidEntity baseAppEntity);
}

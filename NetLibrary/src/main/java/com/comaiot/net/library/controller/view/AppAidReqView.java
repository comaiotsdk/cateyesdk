package com.comaiot.net.library.controller.view;

import com.comaiot.net.library.bean.AppAidEntity;
import com.comaiot.net.library.controller.CatEyeView;

public interface AppAidReqView extends CatEyeView {
    void onAppAidReqSuccess(AppAidEntity baseAppEntity);
}

package com.comaiot.net.library.controller.view;

import com.comaiot.net.library.bean.AppChangeAccountInfoEntity;
import com.comaiot.net.library.controller.CatEyeView;

public interface AppChangeAccountInfoReqView extends CatEyeView {
    void onAppChangeAccountInfoReqSuccess(AppChangeAccountInfoEntity baseAppEntity);
}

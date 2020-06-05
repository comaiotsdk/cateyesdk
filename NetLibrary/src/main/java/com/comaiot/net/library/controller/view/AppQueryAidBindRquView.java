package com.comaiot.net.library.controller.view;

import com.comaiot.net.library.bean.AppQueryAidBindEntity;
import com.comaiot.net.library.controller.CatEyeView;

public interface AppQueryAidBindRquView extends CatEyeView {
    void onAppQueryAidBindReqSuccess(AppQueryAidBindEntity baseAppEntity);
}

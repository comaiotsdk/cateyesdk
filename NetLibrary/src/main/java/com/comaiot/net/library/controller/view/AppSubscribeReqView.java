package com.comaiot.net.library.controller.view;

import com.comaiot.net.library.controller.CatEyeView;

public interface AppSubscribeReqView extends CatEyeView {
    void onSubscribeSuccess(long expire);
}

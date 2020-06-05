package com.comaiot.net.library.controller.view;

import com.comaiot.net.library.bean.AppBindWeixinEntity;
import com.comaiot.net.library.controller.CatEyeView;

public interface AppBindWeixinReqView extends CatEyeView {
    void onAppBindWeixinReqSucc(AppBindWeixinEntity baseAppEntity);
}

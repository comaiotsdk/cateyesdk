package com.comaiot.net.library.controller.view;

import com.comaiot.net.library.bean.PartnerWeixinPushConfigEntity;
import com.comaiot.net.library.controller.CatEyeView;

public interface PartnerWeixinPushConfigReqView extends CatEyeView {
    void onSetWeChatPushSwitchComplete(PartnerWeixinPushConfigEntity entity);
}

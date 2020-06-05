package com.comaiot.net.library.controller.view;

import com.comaiot.net.library.bean.PartnerWeixinPushNoticeEntity;
import com.comaiot.net.library.controller.CatEyeView;

public interface PartnerWeixinPushNoticeReqView extends CatEyeView {
    void onNoticeWeChatComplete(PartnerWeixinPushNoticeEntity entity);
}

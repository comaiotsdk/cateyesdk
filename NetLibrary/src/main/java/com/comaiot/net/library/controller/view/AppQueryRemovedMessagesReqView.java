package com.comaiot.net.library.controller.view;

import com.comaiot.net.library.bean.AppQueryRemovedMessageEntity;
import com.comaiot.net.library.controller.CatEyeView;

public interface AppQueryRemovedMessagesReqView extends CatEyeView {
    void onGetDeletedEventList(AppQueryRemovedMessageEntity entity);
}

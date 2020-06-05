package com.comaiot.net.library.controller.view;

import com.comaiot.net.library.bean.BaseAppEntity;
import com.comaiot.net.library.controller.CatEyeView;

public interface GetStorageView extends CatEyeView {

    void onGetStorageToken(BaseAppEntity data, String fileName, String msgType, String fileType, String fromWhere, String filePath, int msg_Type, long createMsgTime);

    void onGetStorageToken(BaseAppEntity data, String filePath);
}

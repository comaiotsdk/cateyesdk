package com.comaiot.net.library.controller.view;

import com.comaiot.net.library.bean.PartnerShareDeviceEntity;
import com.comaiot.net.library.controller.CatEyeView;

public interface PartnerShareDeviceReqView extends CatEyeView {
    void onPartnerShareDeviceReqSuccess(PartnerShareDeviceEntity baseAppEntity);
}

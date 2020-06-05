package com.comaiot.net.library.controller.view;

import com.comaiot.net.library.bean.PartnerChangePhoneEntity;
import com.comaiot.net.library.controller.CatEyeView;

public interface PartnerChangePhoneReqView extends CatEyeView {
    void onChangePhoneNumberSuccess(PartnerChangePhoneEntity entity);
}

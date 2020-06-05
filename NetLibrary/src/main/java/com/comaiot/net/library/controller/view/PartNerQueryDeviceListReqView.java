package com.comaiot.net.library.controller.view;

import com.comaiot.net.library.bean.PartNerQueryDeviceEntity;
import com.comaiot.net.library.controller.CatEyeView;

public interface PartNerQueryDeviceListReqView extends CatEyeView {
    void onGetPartnerDeviceList(PartNerQueryDeviceEntity entity);
}

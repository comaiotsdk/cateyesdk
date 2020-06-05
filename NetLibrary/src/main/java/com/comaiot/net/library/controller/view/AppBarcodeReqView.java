package com.comaiot.net.library.controller.view;

import com.comaiot.net.library.bean.AppBarcodeReqEntity;
import com.comaiot.net.library.controller.CatEyeView;

public interface AppBarcodeReqView extends CatEyeView {
    void onAppBarcodeReqSuccess(AppBarcodeReqEntity baseAppEntity);
}

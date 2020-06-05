package com.comaiot.net.library.controller.view;


import com.comaiot.net.library.bean.ArogaBean;
import com.comaiot.net.library.controller.CatEyeView;

public interface AgoraLicensesView extends CatEyeView {
    void onAgoraLicensesGetSuccess(ArogaBean.Licenses licenses);
}

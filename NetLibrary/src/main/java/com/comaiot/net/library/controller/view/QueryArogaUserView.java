package com.comaiot.net.library.controller.view;


import com.comaiot.net.library.bean.ArogaBean;
import com.comaiot.net.library.controller.CatEyeView;

public interface QueryArogaUserView extends CatEyeView {
    void onQueryArogaUserNumberSucc(ArogaBean<ArogaBean.Data> bean);
}

package com.comaiot.net.library.controller.view;

import com.comaiot.net.library.bean.QueryCountryCodeEntity;
import com.comaiot.net.library.controller.CatEyeView;

public interface QueryCountryCodeReqView extends CatEyeView {
    void onQueryCountryCode(QueryCountryCodeEntity entity);
}

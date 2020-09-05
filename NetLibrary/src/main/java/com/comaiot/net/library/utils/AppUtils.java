package com.comaiot.net.library.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

import static android.content.Context.TELEPHONY_SERVICE;

@SuppressWarnings("all")
public class AppUtils {
    public static boolean isHaveInternet(Context context) {
        ConnectivityManager mConnectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        TelephonyManager mTelephony =
                (TelephonyManager) context.getSystemService(TELEPHONY_SERVICE);   // 检查网络连接，如果无网络可用，就不需要进行连网操作等  
        NetworkInfo info = mConnectivity.getActiveNetworkInfo();
        if (info == null || !mConnectivity.getBackgroundDataSetting()) {
            return false;
        }    //判断网络连接类型，只有在3G或wifi里进行一些数据更新。  
        int netType = info.getType();
        int netSubtype = info.getSubtype();
        if (netType == ConnectivityManager.TYPE_WIFI) {
            return info.isConnected();
        } else if (netType == ConnectivityManager.TYPE_MOBILE && netSubtype == TelephonyManager.NETWORK_TYPE_UMTS && !mTelephony.isNetworkRoaming()) {
            return info.isConnected();
        } else {
            return false;
        }
    }

    public static boolean checkAccountMaster(String app_aid, String dev_uid) {
        String substring = dev_uid.substring(dev_uid.indexOf("-") + 1, dev_uid.length());
        return isAccountMaster(app_aid, substring);
    }

    private static boolean isAccountMaster(String s1, String s2) {
        boolean ret = false;
        if (s1 == null || s2 == null) return ret;
        return s1.equals(s2);
    }
}

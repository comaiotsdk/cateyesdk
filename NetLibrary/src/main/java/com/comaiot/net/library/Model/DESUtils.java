package com.comaiot.net.library.Model;

import android.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class DESUtils {

    // 释放jar包时 修改ID对应客户
    public static final int ID = 1;

    public static final int COMAIOT = 1;
    public static final int YD = 2;
    public static final int GVS = 3;
    public static final int FANGHUI = 4;
    public static final int ZHOUYAYUN = 5;
    public static final int KUNSHANG = 6;
    public static final int DESHIMAN = 7;
    public static final int MANYA = 8;
    public static final int AITE = 9;
    public static final int PHILIPS = 10;
    public static final int HONYAR = 11;
    public static final int HUNE = 12;
    public static final int RUOCHAN = 13;
    public static final int IWR = 14;
    public static final int RUDOLPH = 15;
    public static final int DAYIN = 16;
    public static final int LEIXUNKEWEI = 17;
    public static final int IFLYTEK = 18;
    public static final int JIANSHI = 19;

    private static final String PASSWORD_ENC_SECRET = "Comaiot-Yd";
    private static final String PASSWORD_ENA_SECRET = "1234qwER";

    //加密
    public static String encryptString(String encryptText) {
        try {
            DESKeySpec keySpec = new DESKeySpec(PASSWORD_ENA_SECRET.getBytes("UTF-8"));
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey key = keyFactory.generateSecret(keySpec);

            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            String encrypedPwd = Base64.encodeToString(cipher.doFinal(encryptText.getBytes("UTF-8")), Base64.DEFAULT);
            return encrypedPwd;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encryptText;
    }

    //解密
    public static String decryptString(String encryptText) {
        try {
            DESKeySpec keySpec = new DESKeySpec(PASSWORD_ENA_SECRET.getBytes("UTF-8"));
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey key = keyFactory.generateSecret(keySpec);

            byte[] encryptedWithoutB64 = Base64.decode(encryptText, Base64.DEFAULT);
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] plainTextPwdBytes = cipher.doFinal(encryptedWithoutB64);
            return new String(plainTextPwdBytes);
        } catch (Exception e) {
        }
        return encryptText;
    }

    public static String decryptBaseUrl(String encryptText) {
        try {
            DESKeySpec keySpec = new DESKeySpec(PASSWORD_ENC_SECRET.getBytes("UTF-8"));
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey key = keyFactory.generateSecret(keySpec);

            byte[] encryptedWithoutB64 = Base64.decode(encryptText, Base64.DEFAULT);
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] plainTextPwdBytes = cipher.doFinal(encryptedWithoutB64);
            return new String(plainTextPwdBytes);
        } catch (Exception e) {
        }
        return encryptText;
    }
}

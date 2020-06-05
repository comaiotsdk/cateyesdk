package com.comaiot.net.library.controller;

public interface CatEyeView {
    void showLoading();

    void hideLoading();

    void onRequestSuccess();

    void onRequestError(String errorMsg, String methodName);
}

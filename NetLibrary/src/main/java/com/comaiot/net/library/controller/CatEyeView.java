package com.comaiot.net.library.controller;

public interface CatEyeView {
    /**
     * 展示请求网络
     */
    void showLoading();

    /**
     * 隐藏请求网络UI
     */
    void hideLoading();

    /**
     * 请求成功
     */
    void onRequestSuccess();

    /**
     * 请求失败
     *
     * @param errorMsg   异常信息
     * @param methodName 方法名
     */
    void onRequestError(String errorMsg, String methodName);
}

package com.comaiot.net.library.req_params;

public class StorageParams {
    private String device_id;
    private String device_token;
    private String file_name;

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public String getDevice_token() {
        return device_token;
    }

    public void setDevice_token(String device_token) {
        this.device_token = device_token;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    @Override
    public String toString() {
        return "StorageParams{" +
                "device_id='" + device_id + '\'' +
                ", device_token='" + device_token + '\'' +
                ", file_name='" + file_name + '\'' +
                '}';
    }
}

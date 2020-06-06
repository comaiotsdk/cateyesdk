package com.comaiot.net.library.util;


@SuppressWarnings("all")
public class ConfigProperties {

    private static final String video_engine_id = "1dd34fa8e0f74327ba89927ceaf47691";
    private static final String SDK_Version = "V1.0.6";

    public static final String getVideoEngineAppId() {
        return video_engine_id;
    }

    public static final String getVersion() {
        return SDK_Version;
    }
}

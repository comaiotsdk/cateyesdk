package com.comaiot.net.library.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@SuppressWarnings("all")
public class ConfigProperties {
    private static final int client_id = 6;
    private static final String video_engine_id = "1dd34fa8e0f74327ba89927ceaf47691";
    private static final String SDK_Version = "V1.0.6";

    public static String getVideoEngineAppId() {
        return video_engine_id;
    }

    public static int getClientId() {
        return client_id;
    }

    public static String getVersion() {
        return SDK_Version;
    }
}

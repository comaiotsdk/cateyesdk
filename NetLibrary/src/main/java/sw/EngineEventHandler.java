package sw;

import android.content.Context;


import com.comaiot.net.library.utils.Logger;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

import io.agora.rtc.IRtcEngineEventHandler;

public class EngineEventHandler {

    private final Context mContext;
    private final EngineConfig mEngineConfig;

    private final ConcurrentHashMap<AGEventHandler, Integer> mEventHandlerList = new ConcurrentHashMap<>();

    public EngineEventHandler(Context context, EngineConfig engineConfig) {
        this.mContext = context;
        this.mEngineConfig = engineConfig;
    }

    public void addEventHandler(AGEventHandler handler) {
        this.mEventHandlerList.put(handler, 0);
    }

    public void removeEventHandler(AGEventHandler handler) {
        this.mEventHandlerList.remove(handler);
    }

    protected final IRtcEngineEventHandler mRtcEventHandler = new IRtcEngineEventHandler() {

        @Override
        public void onFirstRemoteVideoDecoded(int uid, int width, int height, int elapsed) {
            Logger.dd("onFirstRemoteVideoDecoded " + (uid & 0xFFFFFFFFL) + " width = " + width
                    + " height = " + height + " elapsed = " + elapsed);

            Iterator<AGEventHandler> iterator = mEventHandlerList.keySet().iterator();
            while (iterator.hasNext()) {
                AGEventHandler eventHandler = iterator.next();
                eventHandler.onFirstRemoteVideoDecoded(uid, width, height, elapsed);
            }
        }

        @Override
        public void onFirstRemoteVideoFrame(int uid, int width, int height, int elapsed) {
            Iterator<AGEventHandler> iterator = mEventHandlerList.keySet().iterator();
            while (iterator.hasNext()) {
                AGEventHandler eventHandler = iterator.next();
                eventHandler.onFirstRemoteVideoFrame(uid, width, height, elapsed);
            }
        }

        @Override
        public void onFirstRemoteAudioFrame(int uid, int elapsed) {
            Logger.dd("onFirstRemoteAudioFrame uid = " + uid + " elapsed = " + elapsed);
        }

        @Override
        public void onFirstLocalVideoFrame(int width, int height, int elapsed) {
            Logger.dd("onFirstLocalVideoFrame width = " + width + " height = " + height
                    + " elapsed = " + elapsed);
        }

        @Override
        public void onUserJoined(int uid, int elapsed) {
            Logger.dd("onUserJoined uid = " + (uid & 0xFFFFFFFFL) + " elapsed = " + elapsed);

            Iterator<AGEventHandler> it = mEventHandlerList.keySet().iterator();
            while (it.hasNext()) {
                AGEventHandler handler = it.next();
                handler.onUserJoined(uid, elapsed);
            }
        }

        @Override
        public void onUserOffline(int uid, int reason) {
            Logger.dd("onUserOffline uid = " + (uid & 0xFFFFFFFFL) + " reason = " + reason);

            Iterator<AGEventHandler> it = mEventHandlerList.keySet().iterator();
            while (it.hasNext()) {
                AGEventHandler handler = it.next();
                handler.onUserOffline(uid, reason);
            }
        }

        @Override
        public void onJoinChannelSuccess(String channel, int uid, int elapsed) {
            Logger.dd("onJoinChannelSuccess channel = " + channel + " uid = "
                    + (uid & 0xFFFFFFFFL) + " elapsed = " + elapsed);

            Iterator<AGEventHandler> it = mEventHandlerList.keySet().iterator();
            while (it.hasNext()) {
                AGEventHandler handler = it.next();
                handler.onJoinChannelSuccess(channel, uid, elapsed);
            }
        }

        @Override
        public void onRejoinChannelSuccess(String channel, int uid, int elapsed) {
            Logger.dd("onRejoinChannelSuccess channel = " + channel + " uid = "
                    + uid + " elapsed = " + elapsed);
        }

        @Override
        public void onWarning(int warn) {
            super.onWarning(warn);
            Logger.ee("onWarning warn = " + warn);
        }

        @Override
        public void onError(int err) {
            super.onError(err);
            Logger.ee("onError err = " + err);
        }

        @Override
        public void onCameraReady() {
            super.onCameraReady();
        }

        @Override
        public void onVideoStopped() {
            super.onVideoStopped();
        }

        @Override
        public void onLeaveChannel(RtcStats stats) {
            super.onLeaveChannel(stats);
        }
    };
}

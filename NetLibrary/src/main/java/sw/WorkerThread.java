package sw;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.SurfaceView;


import com.comaiot.net.library.utils.Logger;

import java.io.File;

import io.agora.rtc.Constants;
import io.agora.rtc.RtcEngine;
import io.agora.rtc.video.VideoCanvas;

public class WorkerThread extends Thread {

    private static final int ACTION_WORKER_THREAD_QUIT = 0X1010; // quit this thread

    private static final int ACTION_WORKER_JOIN_CHANNEL = 0X2010;

    private static final int ACTION_WORKER_LEAVE_CHANNEL = 0X2011;

    private static final int ACTION_WORKER_CONFIG_ENGINE = 0X2012;

    private static final int ACTION_WORKER_PREVIEW = 0X2014;

    private final Context mContext;
    private final EngineConfig mEngineConfig;
    private final EngineEventHandler mEngineEventHandler;

    private boolean mReady = false;
    private WorkerThreadHandler mWorkerHandler;

    private RtcEngine mRtcEngine;
    private String engine_app_id;

    public WorkerThread(Context context, String engine_app_id) {
        this.mContext = context;
        this.engine_app_id = engine_app_id;
        this.mEngineConfig = new EngineConfig();
        mEngineConfig.mUid = 0;
        this.mEngineEventHandler = new EngineEventHandler(mContext, mEngineConfig);
    }

    public void waitForReady() {
        while (!mReady) {
            try {
                sleep(20);
            } catch (Exception exc) {
                exc.printStackTrace();
            }
            Logger.dd("wait for WorkerThread");
        }
    }

    @Override
    public void run() {
        Logger.dd("WorkerThread start to run()");

        Looper.prepare();
        mWorkerHandler = new WorkerThreadHandler(this);
        ensureRtcEngineReadyLock();
        mReady = true;
        Looper.loop();
    }

    private void ensureRtcEngineReadyLock() {
        if (null == mRtcEngine) {
            try {
                mRtcEngine = RtcEngine.create(mContext, engine_app_id, mEngineEventHandler.mRtcEventHandler);
            } catch (Exception e) {
                Logger.ee("rtc sdk init error " + e.toString());
            }

            int i = mRtcEngine.setChannelProfile(Constants.CHANNEL_PROFILE_LIVE_BROADCASTING);
            Logger.ii("setChannelProfile " + (i < 0 ? "failed" : "success"));
            int enable = mRtcEngine.enableVideo();
            int enableAudio = mRtcEngine.enableAudio();
            Logger.ii("enableVideo " + (enable < 0 ? "failed" : "success"));
            String logFilePath = Environment.getExternalStorageDirectory() + "/Comaiot" + "/log/";
            File file = new File(logFilePath);
            if (!file.exists())
                file.mkdirs();
            mRtcEngine.setLogFile(logFilePath + "/agora-rtc.log");
            mRtcEngine.enableDualStreamMode(true);
        }
    }

    public RtcEngine getRtcEngine() {
        return mRtcEngine;
    }

    public final EngineConfig getEngineConfig() {
        return mEngineConfig;
    }

    public EngineEventHandler eventHandler() {
        return mEngineEventHandler;
    }

    public void exit() {
        if (Thread.currentThread() != this) {
            Logger.dd("exit() - exit app thread asynchronously");
            mWorkerHandler.sendEmptyMessage(ACTION_WORKER_THREAD_QUIT);
            return;
        }

        mReady = false;

        Logger.dd("exit() > start");

        // exit thread looper
        Looper.myLooper().quit();

        mWorkerHandler.release();

        Logger.dd("exit() > end");
    }

    public final void joinChannel(final String channel, int uid) {
        if (Thread.currentThread() != this) {
            Logger.ww("joinChannel() - worker thread asynchronously " + channel + " " + uid);
            Message envelop = new Message();
            envelop.what = ACTION_WORKER_JOIN_CHANNEL;
            envelop.obj = new String[]{channel};
            envelop.arg1 = uid;
            mWorkerHandler.sendMessage(envelop);
            return;
        }

        ensureRtcEngineReadyLock();
        mRtcEngine.joinChannel(null, channel, "Comaiot_App", uid);

        mEngineConfig.mChannel = channel;

        Logger.dd("joinChannel " + channel + " " + uid);
    }

    public final void leaveChannel(String channel) {
        if (Thread.currentThread() != this) {
            Logger.ww("leaveChannel() - worker thread asynchronously " + channel);
            Message envelop = new Message();
            envelop.what = ACTION_WORKER_LEAVE_CHANNEL;
            envelop.obj = channel;
            mWorkerHandler.sendMessage(envelop);
            return;
        }

        if (mRtcEngine != null) {
            mRtcEngine.leaveChannel();
        }

        int clientRole = mEngineConfig.mClientRole;
        mEngineConfig.reset();
        Logger.dd("leaveChannel " + channel + " " + clientRole);
    }

    public final void configEngine(int cRole, int vProfile) {
        if (Thread.currentThread() != this) {
            Logger.ww("configEngine() - worker thread asynchronously " + cRole + " " + vProfile);
            Message envelop = new Message();
            envelop.what = ACTION_WORKER_CONFIG_ENGINE;
            envelop.obj = new Object[]{cRole, vProfile};
            mWorkerHandler.sendMessage(envelop);
            return;
        }

        ensureRtcEngineReadyLock();
        mEngineConfig.mClientRole = cRole;
        mEngineConfig.mVideoProfile = vProfile;

        mRtcEngine.setVideoProfile(mEngineConfig.mVideoProfile, true);

        mRtcEngine.setClientRole(cRole);

        Logger.dd("configEngine " + cRole + " " + mEngineConfig.mVideoProfile);
    }

    public final void preview(boolean start, SurfaceView view, int uid) {
        if (Thread.currentThread() != this) {
            Logger.ww("preview() - worker thread asynchronously " + start + " " + view + " " + (uid & 0XFFFFFFFFL));
            Message envelop = new Message();
            envelop.what = ACTION_WORKER_PREVIEW;
            envelop.obj = new Object[]{start, view, uid};
            mWorkerHandler.sendMessage(envelop);
            return;
        }

        ensureRtcEngineReadyLock();
        if (start) {
            mRtcEngine.setupRemoteVideo(new VideoCanvas(view, VideoCanvas.RENDER_MODE_FIT, uid));
            mRtcEngine.startPreview();
        } else {
            mRtcEngine.stopPreview();
        }
    }

    private class WorkerThreadHandler extends Handler {

        private WorkerThread mWorkerThread;

        WorkerThreadHandler(WorkerThread workerThread) {
            this.mWorkerThread = workerThread;
        }

        void release() {
            mWorkerThread = null;
        }

        @Override
        public void handleMessage(Message msg) {
            if (null == this.mWorkerThread) {
                Logger.dd("WorkerThread is already released " + msg.what);
                return;
            }

            switch (msg.what) {
                case ACTION_WORKER_THREAD_QUIT:
                    mWorkerThread.exit();
                    break;
                case ACTION_WORKER_JOIN_CHANNEL:
                    String[] data = (String[]) msg.obj;
                    mWorkerThread.joinChannel(data[0], msg.arg1);
                    break;
                case ACTION_WORKER_LEAVE_CHANNEL:
                    String channel = (String) msg.obj;
                    mWorkerThread.leaveChannel(channel);
                    break;
                case ACTION_WORKER_CONFIG_ENGINE:
                    Object[] configData = (Object[]) msg.obj;
                    mWorkerThread.configEngine((int) configData[0], (int) configData[1]);
                    break;
                case ACTION_WORKER_PREVIEW:
                    Object[] previewData = (Object[]) msg.obj;
                    mWorkerThread.preview((boolean) previewData[0], (SurfaceView) previewData[1], (int) previewData[2]);
                    break;
                default:
                    break;
            }
        }
    }
}

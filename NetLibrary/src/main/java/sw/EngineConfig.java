package sw;

public class EngineConfig {

    public int mClientRole;                //进入频道身份 （主播或者观众）

    public int mVideoProfile;              //视频设置

    public int mUid;                       //唯一uid 自己处理

    public String mChannel;                //频道名称

    public void reset() {
        mChannel = null;
    }

    EngineConfig() {
    }
}

package com.lhj.projectdemo.util;

import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;

import com.iflytek.cloud.ErrorCode;
import com.iflytek.cloud.InitListener;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechSynthesizer;
import com.iflytek.cloud.SynthesizerListener;
import com.iflytek.cloud.util.ResourceUtil;
import com.lhj.projectdemo.MyApplication;

/**
 * 项目：国民健康平台
 *
 * @Creator:liuhuajian
 * @创建日期： 2019/5/21 15:21
 * @版本0.2
 * @类说明：
 */
public class SpeechCompoundManager {
    private static SpeechCompoundManager speechManager;

    // 引擎类型
    private String mEngineType = SpeechConstant.TYPE_CLOUD;
    private SynthesizerListener synthesizerListenerskillId;
    private SynthesizerListener synthesizerListener;
    //        private String mEngineType = SpeechConstant.TYPE_LOCAL;
    // 语音合成对象
    private SpeechSynthesizer mTts;
    public static String[] chooseVoiceCloudNames = {"小雪", "萌萌-中立", "小燕"};
//    private String[] chooseVoiceCloud = {"x2_xiaoxue", "x_mengmengneutral", "xiaoyan"};
    private String[] chooseVoiceCloud = {"x2_xiaoqian", "x_mengmengneutral", "xiaoyan"};

    // 默认云端发音人
//    public static String voicerCloud = "x_xiaofang";
//    public static String voicerCloud = "x_xiaomeng";
//    public static String voicerCloud = "x_xiaofeng";
//    public static String voicerCloud = "x_xiaomeng";
//    public static String voicerCloud = "x_xiaoyan";
//    public static String voicerCloud = "x_yifeng";
    public static String voicerCloud = "xiaoyan";
//    public static String voicerCloud = "x_mengmengneutral";
    //特色发音人
//    public static String voicerCloud = "x_mengmengneutral";

    //    public static String voicerCloud = "x_xiaoai_novel";
//    public static String voicerCloud = "x_chongchong";
//    public static String voicerCloud = "x_xiaoling";
//    public static String voicerCloud = "x_qianqian";
//    public static String voicerCloud = "x_xiaoxue";
//    public static String voicerCloud = "x_xiaoshi_cts";
    // 默认本地发音人
    public static String voicerLocal = "xiaoyan";
//        public static String voicerLocal = "x_xiaomeng";

    private SpeechCompoundManager(Context context) {
        mTts = SpeechSynthesizer.createSynthesizer(MyApplication.Companion.getMContext(), mTtsInitListener);
        String spStringData = "";
        if (TextUtils.isEmpty(spStringData)) {
            voicerCloud = chooseVoiceCloud[0];
        } else {
            voicerCloud = chooseVoiceCloud[Integer.parseInt(spStringData)];
        }
    }

    public static SpeechCompoundManager getInstance() {
        if (speechManager == null)
            speechManager = new SpeechCompoundManager(MyApplication.Companion.getMContext());
        return speechManager;
    }

    public static void clearSpeechParams() {
        speechManager = null;
    }

    /**
     * 参数设置
     */
    private void setParam() {
        //x86 模拟器不初始化
        if ("x86".equals(Build.SUPPORTED_ABIS[0])) return;
        if (mTts == null) return;
        // 清空参数
        mTts.setParameter(SpeechConstant.PARAMS, null);
        //设置合成
        if (mEngineType.equals(SpeechConstant.TYPE_CLOUD)) {
            //设置使用云端引擎
            mTts.setParameter(SpeechConstant.ENGINE_TYPE, SpeechConstant.TYPE_CLOUD);
            //设置发音人
            mTts.setParameter(SpeechConstant.VOICE_NAME, voicerCloud);
        } else {
            //设置使用本地引擎
            mTts.setParameter(SpeechConstant.ENGINE_TYPE, SpeechConstant.TYPE_LOCAL);
            //设置发音人资源路径
            mTts.setParameter(ResourceUtil.TTS_RES_PATH, getResourcePath(MyApplication.Companion.getMContext()));
            //设置发音人
            mTts.setParameter(SpeechConstant.VOICE_NAME, voicerLocal);
        }
        mTts.setParameter(SpeechConstant.TTS_DATA_NOTIFY, "1");//支持实时音频流抛出，仅在synthesizeToUri条件下支持
        //设置合成语速
        mTts.setParameter(SpeechConstant.SPEED, "50");
        //设置合成音调
        mTts.setParameter(SpeechConstant.PITCH, "50");
        //设置合成音量
        mTts.setParameter(SpeechConstant.VOLUME, "50");
        //设置播放器音频流类型
        mTts.setParameter(SpeechConstant.STREAM_TYPE, "3");

        // 设置播放合成音频打断音乐播放，默认为true
        mTts.setParameter(SpeechConstant.KEY_REQUEST_FOCUS, "true");

        // 设置音频保存路径，保存音频格式支持pcm、wav，设置路径为sd卡请注意WRITE_EXTERNAL_STORAGE权限
        mTts.setParameter(SpeechConstant.AUDIO_FORMAT, "wav");
        mTts.setParameter(SpeechConstant.TTS_AUDIO_PATH, Environment.getExternalStorageDirectory() + "/msc/tts.wav");
    }

    //获取发音人资源路径
    private String getResourcePath(Context context) {
        StringBuffer tempBuffer = new StringBuffer();
        //合成通用资源
        tempBuffer.append(ResourceUtil.generateResourcePath(context, ResourceUtil.RESOURCE_TYPE.assets, "tts/common.jet"));
        tempBuffer.append(";");
        //发音人资源
        tempBuffer.append(ResourceUtil.generateResourcePath(context, ResourceUtil.RESOURCE_TYPE.assets, "tts/" + voicerLocal + ".jet"));
        return tempBuffer.toString();
    }


    private InitListener mTtsInitListener = new InitListener() {
        @Override
        public void onInit(int code) {
            MyLogger.i("InitListener init() code = " + code);
            if (code == ErrorCode.SUCCESS) {
                // 初始化成功，之后可以调用startSpeaking方法
                // 注：有的开发者在onCreate方法中创建完合成对象之后马上就调用startSpeaking进行合成，
                // 正确的做法是将onCreate中的startSpeaking调用移至这里
                setParam();
            } else {
                MyLogger.e("初始化失败,错误码：" + code);
            }
        }
    };

    /**
     * 进行语音播报
     * @param content
     */
    public void startSpeaking(String content) {
        clearListener();
        if (getCurrentMusicVolume() == 0) {
//            ToastUtil.getInstance().showToast(content);
        }
        if (mTts != null) {
            mTts.startSpeaking(content, mTtsListener);
        }
    }

    /**
     * 进行语音播报 正常播报结束或者被打断，都走SynthesizerListener回调
     * @param content
     * @param listener
     */
    public void startSpeaking(String content, SynthesizerListener listener) {
        if (getCurrentMusicVolume() == 0) {
//            ToastUtil.getInstance().showToast(content);
        }
        synthesizerListenerskillId = listener;
        if (mTts != null && !TextUtils.isEmpty(content)) {
            mTts.startSpeaking(content, mTtsListener);
        }
    }

    public int getCurrentMusicVolume() {
        AudioManager mAudioManager = (AudioManager) MyApplication.Companion.getMContext().getSystemService(Context.AUDIO_SERVICE);
        return mAudioManager != null ? mAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC) : -1;
    }

    /**
     * 进行语音播报 正常播报结束走SynthesizerListener回调，如果被打断则结束
     * @param content
     * @param listener
     */
    public void startSpeakingAbandonWhenInterrupt(String content, SynthesizerListener listener){
        if (getCurrentMusicVolume() == 0) {
//            ToastUtil.getInstance().showToast(content);
        }
        synthesizerListener = listener;
        if (mTts != null && !TextUtils.isEmpty(content)) {
            mTts.startSpeaking(content, listener);
        }
    }

    public void clearListener(){
        if (synthesizerListenerskillId !=null) {
            synthesizerListenerskillId = null;
        }
        if (synthesizerListener !=null){
            synthesizerListener = null;
        }
    }

    public void stopSpeaking() {
        MyLogger.e("finish---stopSpeaking---");
        if (mTts != null && mTts.isSpeaking()) {
            mTts.stopSpeaking();
            if (mTtsListener != null) {
                mTtsListener.onSpeakPaused();
            }
            if (synthesizerListenerskillId != null) {
                synthesizerListenerskillId.onCompleted(null);
                clearListener();
            }
        }
    }
    public void pauseSpeaking() {
        MyLogger.e("finish---pauseSpeaking---");
        if (mTts != null && mTts.isSpeaking()) {
            mTts.stopSpeaking();
            if (mTtsListener != null) {
                mTtsListener.onSpeakPaused();
            }
            if (synthesizerListenerskillId != null) {
                synthesizerListenerskillId.onSpeakPaused();
                clearListener();
            }
        }
    }

    /**
     * 合成回调监听。
     */
    private SynthesizerListener mTtsListener = new SynthesizerListener() {

        @Override
        public void onSpeakBegin() {
            MyLogger.i("开始播放");
//            LauncherManager.Companion.getInstance().sendStopSpeak(MyApplication.Companion.getMContext());
        }

        @Override
        public void onSpeakPaused() {
            MyLogger.i("暂停播放");
        }

        @Override
        public void onSpeakResumed() {
            MyLogger.i("继续播放");
        }

        @Override
        public void onBufferProgress(int percent, int beginPos, int endPos,
                                     String info) {
            // 合成进度`
        }

        @Override
        public void onSpeakProgress(int percent, int beginPos, int endPos) {
            // 播放进度
        }

        @Override
        public void onCompleted(SpeechError error) {
            //需要清除引用，否则会导致上一次语音的引用继续走onComplete
            MyLogger.e("onCompleted");
            if (synthesizerListenerskillId != null) {
                synthesizerListenerskillId.onCompleted(error);
                clearListener();
            }
            if (synthesizerListener!=null){
                synthesizerListener.onCompleted(error);
                clearListener();
            }
//            clearListener();
//            if (error == null) {
//                MyLogger.i("播放完成");
//            } else if (error != null) {
//                MyLogger.i(error.getPlainDescription(true));
//            }
        }

        @Override
        public void onEvent(int eventType, int arg1, int arg2, Bundle obj) {
            MyLogger.e("onEvent-->eventType"+eventType+"--arg1-->"+arg1+"--arg2-->"+arg2);
            // 以下代码用于获取与云端的会话id，当业务出错时将会话id提供给技术支持人员，可用于查询会话日志，定位出错原因
            // 若使用本地能力，会话id为null
            //	if (SpeechEvent.EVENT_SESSION_ID == eventType) {
            //		String sid = obj.getString(SpeechEvent.KEY_EVENT_SESSION_ID);
            //		Log.d(TAG, "session id =" + sid);
            //	}

            //实时音频流输出参考
			/*if (SpeechEvent.EVENT_TTS_BUFFER == eventType) {
				byte[] buf = obj.getByteArray(SpeechEvent.KEY_EVENT_TTS_BUFFER);
				Log.e("MscSpeechLog", "buf is =" + buf);
			}*/
        }
    };

    public void pause() {
        if (null != mTts) {
            mTts.stopSpeaking();
            // 退出时释放连接
            mTts.destroy();
            mTts = null;
            speechManager = null;
        }
    }
}

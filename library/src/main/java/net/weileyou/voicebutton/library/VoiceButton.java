package net.weileyou.voicebutton.library;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.IOException;

/**
 * CopyRight 2012-2017 weileyou Tech.Co.Ltd.ALL Rights Reserved
 * 描述:  播放声音的控件
 * 创建人:姚常亮
 * 创建时间 2017/1/24 0024 16:36.
 */

public class VoiceButton extends LinearLayout implements  MediaPlayer.OnPreparedListener, View.OnClickListener, MediaPlayer.OnCompletionListener {
    /**
     * the image of VoiceButton`s width
     */
    private  int ImageVocieWidth;
    /**
     * the image of VoiceButton`s height
     */
    private  int ImageVocieHeight;

    private int mTextViewMargin;

    private int mImageViewMargin;

    MediaPlayer mPlayer;

    TextView textTime;

    String voicePath;

    ImageView voiceImage;

    AnimationDrawable animationDrawable;


    public VoiceButton(Context context){
        this(context, null,0);
    }


    public VoiceButton(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public VoiceButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initData(context);
        initView(context);
    }

    private void initData(Context context) {
        ImageVocieWidth=VoiceButtonUtil.dp2px(context,30);
        ImageVocieHeight=VoiceButtonUtil.dp2px(context,22);
        mTextViewMargin=VoiceButtonUtil.dp2px(context,12);
        mImageViewMargin=VoiceButtonUtil.dp2px(context,6);
    }

    private void initView(Context context) {
        mPlayer=new MediaPlayer();

        setOrientation(LinearLayout.HORIZONTAL);
        setGravity(Gravity.CENTER_VERTICAL);
        //设置背景颜色
        setBackgroundColor(Color.parseColor("#F3F4F8"));

        voiceImage=new ImageView(context);
        voiceImage.setImageResource(R.drawable.icon_voice03);
        LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(
                ImageVocieWidth, ImageVocieHeight
                );
        params.topMargin=mImageViewMargin;
        params.bottomMargin=mImageViewMargin;
        voiceImage.setLayoutParams(params);

        addView(voiceImage);



         textTime=new TextView(context);
        LinearLayout.LayoutParams textviewParams=new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        textviewParams.rightMargin=mTextViewMargin;
        textviewParams.leftMargin=mTextViewMargin;
        textTime.setLayoutParams(textviewParams);
        addView(textTime);

        setOnClickListener(this);

    }
    //设置播放语音的路径
    public void setPlayPath(String path){
        voicePath=path;
        mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mPlayer.setOnPreparedListener(this);
        mPlayer.setOnCompletionListener(this);
        mPlayer.reset();
        try {
            mPlayer.setDataSource(path);
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("test","media setDataSource出现异常:"+e.toString());
        }
        try {
            mPlayer.prepare();//prepare之后自动播放
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("test","media prepare出现异常:"+e.toString());
        }
    }


    @Override
    public void onPrepared(MediaPlayer player) {
        setVoiceLengthText(player);
    }

    public void setVoiceLengthText(MediaPlayer player){
        long dur=player.getDuration();
        textTime.setText(formatTime(dur));
    }

    /*
     * 毫秒转化时分秒毫秒
     */
    public  String formatTime(Long ms) {
        if(ms>(59*1000)){
            int miao=(int) (ms/1000);
            int minutes=miao/60;
            int second=miao-60*minutes;
            return minutes+"'"+second+"\"";
        }else{
            return ms/1000+"\"";
        }
    }

    @Override
    public void onClick(View view) {
        if(TextUtils.isEmpty(voicePath)){
            Log.e("test","未设置声音路径");
            return;
        }
        if(mPlayer.isPlaying()){
            mPlayer.pause();
            voiceImage.setImageResource(R.drawable.voicebutton_animlist_idle);
            animationDrawable = (AnimationDrawable) voiceImage.getDrawable();
            animationDrawable.start();
        }else{
            mPlayer.start();
            voiceImage.setImageResource(R.drawable.voicebutton_animlist);
            animationDrawable = (AnimationDrawable) voiceImage.getDrawable();
            animationDrawable.start();
        }
    }


    @Override
    public void onCompletion(MediaPlayer player) {
        Log.e("test","onCompletion");
        voiceImage.setImageResource(R.drawable.voicebutton_animlist_idle);
        animationDrawable = (AnimationDrawable) voiceImage.getDrawable();
        animationDrawable.start();
    }
}

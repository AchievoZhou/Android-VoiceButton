package net.weileyou.voicebutton.library;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * CopyRight 2012-2017 weileyou Tech.Co.Ltd.ALL Rights Reserved
 * 描述:  声音的波浪的图标
 * 创建人:姚常亮
 * 创建时间 2017/1/24 0024 17:23.
 */

public class VoiceWave extends View {
    /**
     * 画笔
     */
    Paint mPaint;

    int paintColor;

    /**
     * 第一个圆弧的半径
     */
    int radius1=16;

    /**
     * 第二个圆弧的半径
     */
    int radius2=0;

    /**
     * 第三个圆弧的半径
     */
    int radius3=0;
    /**
     * 圆弧的增量
     */
    int radius_increment=20;

    /**
     * 圆弧的宽度
     */
    int wave_width=6;



    public VoiceWave(Context context) {
        this(context,null,0);
    }

    public VoiceWave(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public VoiceWave(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        radius2=radius1+radius_increment;
        radius3=radius1+2*radius_increment;
        //画笔颜色,默认蓝色
        paintColor=Color.parseColor("#1296DB");

        mPaint=new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setAntiAlias(true);//抗锯齿
        mPaint.setStrokeCap(Paint.Cap.ROUND);//让画笔的笔尖变成圆形
        mPaint.setStrokeWidth(wave_width);
        mPaint.setColor(paintColor);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int center=getWidth()/2;
        RectF rectf1=new RectF(center-radius1,center-radius1,center+radius1,center+radius1);
        canvas.drawArc(rectf1,315,90,false,mPaint);

        RectF rectf2=new RectF(center-radius2,center-radius2,center+radius2,center+radius2);
        canvas.drawArc(rectf2,325,70,false,mPaint);

        RectF rectf3=new RectF(center-radius3,center-radius3,center+radius3,center+radius3);
        canvas.drawArc(rectf3,325,70,false,mPaint);


    }
}

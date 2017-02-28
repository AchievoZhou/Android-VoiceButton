package net.weileyou.voicebutton.library;

import android.content.Context;
import android.util.TypedValue;

/**
 * CopyRight 2012-2017 weileyou Tech.Co.Ltd.ALL Rights Reserved
 * 描述:  工具类
 * 创建人:姚常亮
 * 创建时间 2017/1/24 0024 16:57.
 */

public class VoiceButtonUtil {

    public VoiceButtonUtil() {

    }
    public static int dp2px(Context context, float dpValue) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpValue, context.getResources().getDisplayMetrics());
    }

    public static int sp2px(Context context, float spValue) {
        return (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_SP, spValue, context.getResources().getDisplayMetrics());
    }
}

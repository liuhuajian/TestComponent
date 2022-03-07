package com.lhj.libbase.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * copyright (C),2021-2022, 国民集团健康科技有限公司
 *
 * @ProjectName:
 * @Description:
 * @Author: liuhuajian
 * @CreateDate： 2022/1/10 15:22
 * @Version: 0.1
 */
public class MyTextView extends View {

    private Paint normalPaint;
    private Paint hightLightPaint;
    private String content = "报告正在生成中，预计需要 5 分钟，请稍等...";
    private Rect mBound;

    public MyTextView(Context context) {
        this(context,null);
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        normalPaint = new Paint();
        hightLightPaint = new Paint();
        normalPaint.setTextSize(28);
        normalPaint.setColor(Color.parseColor("#434b61"));

        hightLightPaint.setTextSize(48);
        hightLightPaint.setColor(Color.parseColor("#FF3B30"));
        mBound = new Rect();
        normalPaint.getTextBounds(content, 0,content.length(), mBound);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText(content,getWidth() / 2 - mBound.width() / 2, getHeight() / 2 + mBound.height() / 2, normalPaint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}

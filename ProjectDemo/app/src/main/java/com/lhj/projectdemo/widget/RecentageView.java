package com.lhj.projectdemo.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * 项目：国民健康平台
 *
 * @Creator:liuhuajian
 * @创建日期： 2021/1/13 20:18
 * @版本0.2
 * @类说明：
 */
public class RecentageView extends View {
    private Paint paint;
    private Rect rect;
    public RecentageView(Context context) {
        this(context,null);
    }

    public RecentageView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public RecentageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint= new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2);
        rect = new Rect(0,0,400,400);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i=0;i<50;i++){
            // 保存画布
            canvas.save();
            float fraction = (float) i / 50;
            // 将画布以正方形中心进行缩放
            canvas.scale(fraction, fraction, 200, 200);
            canvas.drawRect(rect, paint);
            // 画布回滚
            canvas.restore();
        }
    }
}

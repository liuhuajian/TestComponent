package com.lhj.projectdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;

/**
 * 项目：国民健康平台
 *
 * @Creator:liuhuajian
 * @创建日期： 2020/11/5 19:02
 * @版本0.2
 * @类说明：
 */
public class StableViewGroup extends ViewGroup {
    public StableViewGroup(Context context) {
        super(context);
    }

    public StableViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public StableViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {

    }
}

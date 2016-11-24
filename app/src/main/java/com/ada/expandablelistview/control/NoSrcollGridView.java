package com.ada.expandablelistview.control;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by Ada on 2016/11/16.
 */


public class NoSrcollGridView extends GridView {
    public NoSrcollGridView(Context context) {
        super(context);

    }
    public NoSrcollGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}

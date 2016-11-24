package com.ada.expandablelistview.util;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;

/**
 * Created by Ada on 2016/11/4.
 */

public class SelectorUtils {
    /**
     * 代码生成选择器
     * @param context 当前上下文
     * @param idNormal 默认图片id
     * @param idPressed 触摸时图片id
     * @param idFocused 获得焦点时图片id
     * @param idUnable 没有选中时图片id
     * @return
     */
    public static StateListDrawable newSelector(Context context, int idNormal, int idPressed, int idFocused,int idUnable) {
        StateListDrawable bg = new StateListDrawable();
        Drawable normal = idNormal == -1 ? null : context.getResources().getDrawable(idNormal);
        Drawable pressed = idPressed == -1 ? null : context.getResources().getDrawable(idPressed);
        Drawable focused = idFocused == -1 ? null : context.getResources().getDrawable(idFocused);
        Drawable unable = idUnable == -1 ? null : context.getResources().getDrawable(idUnable);
        // View.PRESSED_ENABLED_STATE_SET
        bg.addState(new int[] { android.R.attr.state_pressed, android.R.attr.state_enabled }, pressed);
        // View.ENABLED_FOCUSED_STATE_SET
        bg.addState(new int[] { android.R.attr.state_enabled, android.R.attr.state_focused }, focused);
        // View.ENABLED_STATE_SET
        bg.addState(new int[] { android.R.attr.state_enabled }, normal);
        // View.FOCUSED_STATE_SET
        bg.addState(new int[] { android.R.attr.state_focused }, focused);
        // View.WINDOW_FOCUSED_STATE_SET
        bg.addState(new int[] { android.R.attr.state_window_focused }, unable);
        // View.EMPTY_STATE_SET
        bg.addState(new int[] {}, normal);
        return bg;
    }


    /**
     * 控件选择器
     *
     * @param context 当前上下文
     * @param idNormal 默认图片id
     * @param idPressed 按压时图片id
     * @return
     */
    public static StateListDrawable setSelector(Context context,int idNormal,int idPressed){
        StateListDrawable bg=new StateListDrawable();
        Drawable normal = idNormal == -1 ? null : context.getResources().getDrawable(idNormal);
        Drawable pressed = idPressed == -1 ? null : context.getResources().getDrawable(idPressed);
        bg.addState(new int[] { android.R.attr.state_pressed, android.R.attr.state_enabled }, pressed);
        bg.addState(new int[] { android.R.attr.state_enabled }, normal);
        bg.addState(new int[] {}, normal);
        return bg;
    }

    public static StateListDrawable getStateListDrawable(Context context){
        StateListDrawable drawable = new StateListDrawable();
        GradientDrawable shape = new GradientDrawable();
        shape.setStroke(1,Color.BLUE);
        //Non focused states
//        drawable.addState(new int[]{-android.R.attr.state_focused, -android.R.attr.state_selected, -android.R.attr.state_pressed},
//                shape);
//        drawable.addState(new int[]{-android.R.attr.state_focused, android.R.attr.state_selected, -android.R.attr.state_pressed},
//                getResources().getDrawable(R.drawable.contact_sel));
        //Focused states
//        drawable.addState(new int[]{android.R.attr.state_focused,-android.R.attr.state_selected, -android.R.attr.state_pressed},
//                getResources().getDrawable(R.drawable.contact_sel));
//        drawable.addState(new int[]{android.R.attr.state_focused,android.R.attr.state_selected, -android.R.attr.state_pressed},
//                getResources().getDrawable(R.drawable.contact_sel));
        //Pressed
        drawable.addState(new int[]{android.R.attr.state_checked},
                shape);
        shape = new GradientDrawable();
        shape.setColor(Color.BLUE);
        shape.setStroke(1,Color.RED);
        drawable.addState(new int[]{-android.R.attr.state_checked},
                shape);

        return drawable ;
    }

    /**
     * 设置未选中后的背景
     */
    public static GradientDrawable getNotSelectedBgShape( Integer color){
        GradientDrawable shape = new GradientDrawable();
        //未选中
        shape = new GradientDrawable();
        shape.setColor(null);
        shape.setStroke(1,color);
        return shape ;
    }
}

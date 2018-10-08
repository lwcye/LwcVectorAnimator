package com.cqmc.lwcvectoranimator.utils;

import android.widget.ImageView;

/**
 * <p>describe</p><br>
 *
 * @author - lwc
 * @date - 2018/10/8
 * @note -
 * -------------------------------------------------------------------------------------------------
 * @modified -
 * @date -
 * @note -
 */
public class ViewUtil {
    private static final ViewUtil OUR_INSTANCE = new ViewUtil();

    private ViewUtil() {
    }

    public static ViewUtil getInstance() {
        return OUR_INSTANCE;
    }

    /**
     * 设置 ImageView 被选择的图片
     *
     * @param imageView 图片控件
     * @param isCheck 是否被选择
     */
    public static void setImageCheckBg(ImageView imageView, boolean isCheck) {
        int[] stateSet = {android.R.attr.state_checked * (isCheck ? 1 : -1)};
        imageView.setImageState(stateSet, true);
    }
}

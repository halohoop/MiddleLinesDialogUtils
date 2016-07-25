package com.halohoop.middlelinesdialogutils.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Pooholah on 2016/7/15.
 */
public class MiddleLinesDialog extends Dialog implements
        android.view.View.OnClickListener {
    private LinearLayout mLinearLayout;
    private static final int DEFAULT_MARGIN_LEFT_AND_RIGHT = 100;
    private static final int DEFAULT_ITEM_PADDING_TOP_AND_DOWN = 30;
    private static final int DEFAULT_CROSS_MARGIN_LEFT_AND_RIGHT = 10;
    private static final float DEFAULT_DIALOG_BG_ALPHA = 1.00f;
    private static final float DEFAULT_CROSS_COLOR_ALPHA = 1.00f;
    private static final float DEFAULT_TEXT_COLOR_ALPHA = 1.00f;
    //english:black hex except "#alpha" part,chinese:黑色十六进制颜色代码,除了前面的两位#alpha值
    private static final String DEFAULT_DIALOG_BG_COLOR_HEX = "ffffff";//except #alpha part
    private static final String DEFAULT_CROSS_COLOR_HEX = "8e8e8e";//except #alpha part
    private static final String DEFAULT_TEXT_COLOR_HEX = "000000";//except #alpha part
    private static final int DEFAULT_RADOIS = 8;
    private int mMarginLeftAndRight = DEFAULT_MARGIN_LEFT_AND_RIGHT;
    private int mCrossMarginLeftAndRight = DEFAULT_CROSS_MARGIN_LEFT_AND_RIGHT;
    private int mItemPaddingTopAndDown = DEFAULT_ITEM_PADDING_TOP_AND_DOWN;
    private float mDialogBgAlpha = DEFAULT_DIALOG_BG_ALPHA;
    private String mDialogBgColorHex = DEFAULT_DIALOG_BG_COLOR_HEX;
    private float mCrossColorAlpha = DEFAULT_CROSS_COLOR_ALPHA;
    private String mCrossColorHex = DEFAULT_CROSS_COLOR_HEX;
    private float mTextColorAlpha = DEFAULT_TEXT_COLOR_ALPHA;
    private String mTextColorHex = DEFAULT_TEXT_COLOR_HEX;
    private int mTopLeftAndRightRadius = DEFAULT_RADOIS;
    private int mBottomLeftAndRightRadius = DEFAULT_RADOIS;
    private static final String DEFAULT_MIDDLE_LINES_DIAGLOG_PRESS_COLOR = "#338e8e8e";
    private String mMiddleLinesDiaglogPressColorStr = DEFAULT_MIDDLE_LINES_DIAGLOG_PRESS_COLOR;
    private int mItemGravity = Gravity.CENTER;
    private int mPaddingLeftOrRight = 10;
    private Context mContext;
    private Point mScreenSize;
    private List<String> tvTextList = new ArrayList<>();
    private int mResIdDialogBelongTo;

    /**
     * 这个构造函数的文字参数,由外界传入,采用的是不定参数的形式,其实就是一个数组,
     * 使用默认的圆角和margin
     *
     * @param context
     * @param itemClickListener
     * @param texts
     */
    public MiddleLinesDialog(int resIdDialogBelongTo, Context context, ItemClickListener itemClickListener,
                             String... texts) {
        this(resIdDialogBelongTo, context,
                DEFAULT_MARGIN_LEFT_AND_RIGHT, DEFAULT_ITEM_PADDING_TOP_AND_DOWN,
                DEFAULT_RADOIS, DEFAULT_RADOIS,
                itemClickListener,
                null, texts);
    }

    public MiddleLinesDialog(int resIdDialogBelongTo, Context context,
                             int marginLeftAndRight,
                             ItemClickListener itemClickListener,
                             String... texts) {
        this(resIdDialogBelongTo, context,
                marginLeftAndRight, DEFAULT_ITEM_PADDING_TOP_AND_DOWN,
                DEFAULT_RADOIS, DEFAULT_RADOIS,
                itemClickListener,
                null, texts);
    }

    public MiddleLinesDialog(int resIdDialogBelongTo, Context context,
                             int marginLeftAndRight, int itemPaddingTopAndDown,
                             ItemClickListener itemClickListener,
                             String... texts) {
        this(resIdDialogBelongTo, context,
                marginLeftAndRight, itemPaddingTopAndDown,
                DEFAULT_RADOIS, DEFAULT_RADOIS,
                itemClickListener,
                null, texts);
    }

    public MiddleLinesDialog(int resIdDialogBelongTo, Context context,
                             int marginLeftAndRight, int itemPaddingTopAndDown, int radius,
                             ItemClickListener itemClickListener,
                             String... texts) {
        this(resIdDialogBelongTo, context,
                marginLeftAndRight, itemPaddingTopAndDown,
                radius, radius,
                itemClickListener,
                null, texts);
    }

    public MiddleLinesDialog(int resIdDialogBelongTo, Context context, int marginLeftAndRight, int itemPaddingTopAndDown,
                             int topLeftAndRightRadius, int bottomLeftAndRightRadius,
                             ItemClickListener itemClickListener,
                             OnCancelListener cancelListener, String... texts) {
        this(resIdDialogBelongTo, context, marginLeftAndRight, itemPaddingTopAndDown,
                topLeftAndRightRadius, bottomLeftAndRightRadius,
                DEFAULT_CROSS_MARGIN_LEFT_AND_RIGHT,
                itemClickListener,
                cancelListener, texts);
    }

    public MiddleLinesDialog(int resIdDialogBelongTo, Context context, int marginLeftAndRight, int itemPaddingTopAndDown,
                             int topLeftAndRightRadius, int bottomLeftAndRightRadius,
                             int crossMarginLeftAndRight,
                             ItemClickListener itemClickListener,
                             OnCancelListener cancelListener, String... texts) {
        this(resIdDialogBelongTo, context, marginLeftAndRight, itemPaddingTopAndDown,
                topLeftAndRightRadius, bottomLeftAndRightRadius,
                crossMarginLeftAndRight,
                DEFAULT_DIALOG_BG_ALPHA, DEFAULT_DIALOG_BG_COLOR_HEX,
                itemClickListener,
                cancelListener, texts);
    }

    /**
     * @param context
     * @param marginLeftAndRight
     * @param itemPaddingTopAndDown
     * @param topLeftAndRightRadius
     * @param bottomLeftAndRightRadius
     * @param crossMarginLeftAndRight
     * @param dialogBgAlpha            dialog bg alpha eg.0.70f
     * @param dialogBgColorHex         dialog bgcolor hex,对话框背景颜色,eg.ff0000
     * @param itemClickListener
     * @param cancelListener
     * @param texts
     */
    public MiddleLinesDialog(int resIdDialogBelongTo, Context context, int marginLeftAndRight, int itemPaddingTopAndDown,
                             int topLeftAndRightRadius, int bottomLeftAndRightRadius,
                             int crossMarginLeftAndRight,
                             float dialogBgAlpha, String dialogBgColorHex,
                             ItemClickListener itemClickListener,
                             OnCancelListener cancelListener, String... texts) {
        this(resIdDialogBelongTo, context, marginLeftAndRight, itemPaddingTopAndDown,
                topLeftAndRightRadius, bottomLeftAndRightRadius,
                crossMarginLeftAndRight,
                dialogBgAlpha, dialogBgColorHex,
                DEFAULT_CROSS_COLOR_ALPHA, DEFAULT_CROSS_COLOR_HEX,
                itemClickListener,
                cancelListener, texts);
    }

    /**
     * @param context
     * @param marginLeftAndRight
     * @param itemPaddingTopAndDown
     * @param topLeftAndRightRadius
     * @param bottomLeftAndRightRadius
     * @param crossMarginLeftAndRight
     * @param dialogBgAlpha            dialog bg alpha eg.0.70f
     * @param dialogBgColorHex         dialog bgcolor hex,对话框背景颜色,eg.ff0000
     * @param crossColorAlpha          cross color alpha eg.0.70f
     * @param crossColorHex            cross color hex,分割线背景颜色,eg.8e8e8e
     * @param itemClickListener
     * @param cancelListener
     * @param texts
     */
    public MiddleLinesDialog(int resIdDialogBelongTo, Context context, int marginLeftAndRight, int itemPaddingTopAndDown,
                             int topLeftAndRightRadius, int bottomLeftAndRightRadius,
                             int crossMarginLeftAndRight,
                             float dialogBgAlpha, String dialogBgColorHex,
                             float crossColorAlpha, String crossColorHex,
                             ItemClickListener itemClickListener,
                             OnCancelListener cancelListener, String... texts) {
        this(resIdDialogBelongTo, context, marginLeftAndRight, itemPaddingTopAndDown,
                topLeftAndRightRadius, bottomLeftAndRightRadius,
                crossMarginLeftAndRight,
                dialogBgAlpha, dialogBgColorHex,
                crossColorAlpha, crossColorHex,
                DEFAULT_TEXT_COLOR_ALPHA, DEFAULT_TEXT_COLOR_HEX,
                itemClickListener,
                cancelListener, texts);
    }

    /**
     *
     * @param context
     * @param marginLeftAndRight
     * @param itemPaddingTopAndDown
     * @param topLeftAndRightRadius
     * @param bottomLeftAndRightRadius
     * @param crossMarginLeftAndRight
     * @param dialogBgAlpha
     * @param dialogBgColorHex
     * @param crossColorAlpha
     * @param crossColorHex
     * @param textColorAlpha
     * @param textColorHex
     * @param itemClickListener
     * @param cancelListener
     * @param texts
     */
    public MiddleLinesDialog(int resIdDialogBelongTo, Context context, int marginLeftAndRight, int itemPaddingTopAndDown,
                             int topLeftAndRightRadius, int bottomLeftAndRightRadius,
                             int crossMarginLeftAndRight,
                             float dialogBgAlpha, String dialogBgColorHex,
                             float crossColorAlpha, String crossColorHex,
                             float textColorAlpha, String textColorHex,
                             ItemClickListener itemClickListener,
                             OnCancelListener cancelListener, String... texts) {
        this(resIdDialogBelongTo, context, marginLeftAndRight, itemPaddingTopAndDown,
                topLeftAndRightRadius, bottomLeftAndRightRadius,
                crossMarginLeftAndRight,
                dialogBgAlpha, dialogBgColorHex,
                crossColorAlpha, crossColorHex,
                textColorAlpha, textColorHex,
                Gravity.CENTER, 0,
                itemClickListener,
                cancelListener, texts);
    }

    /**
     * 越多参数的构造函数能够实现越多的自定义
     *
     * @param context
     * @param marginLeftAndRight       这个参数指定了对话框相对于父布局的marginLeft 和 marginRight
     * @param itemPaddingTopAndDown    这个参数指定了对话框每一行TextView的paddingTop和paddingBottom
     * @param topLeftAndRightRadius    这个参数指定了对话框上左和上右的圆角值
     * @param bottomLeftAndRightRadius 这个参数指定了对话框下左和下右的圆角值
     * @param crossMarginLeftAndRight  这个参数指定了对话框每一行TextView之间的分割线的marginLeft 和 marginRight
     * @param dialogBgAlpha            这个参数指定了对话框背景颜色的透明度
     * @param dialogBgColorHex         这个参数指定了对话框背景颜色的十六进制代码
     * @param crossColorAlpha          这个参数指定了对话框分割线的颜色的透明度
     * @param crossColorHex            这个参数指定了对话框分割线的颜色的十六进制代码
     * @param textColorAlpha           这个参数指定了对话框每行文字的颜色的透明度
     * @param textColorHex             这个参数指定了对话框每行文字的颜色的十六进制代码
     * @param itemGravity              这个参数指定了对话框每行TextView的Gravity,传入LEFT,RIGHT或者CENTER
     * @param paddingLeftOrRight       这个参数和上个参数配对使用,当时CENTER的时候无效,
     *                                 当是LEFT的时候就是paddingLeft,当是RIGHT的时候就是paddingRight
     * @param itemClickListener        点击的其中一行TextView监听器接口
     * @param cancelListener           取消对话框的监听器接口
     * @param texts                    自定义的文字,不定参数,需要什么通过:"xxxx1","xxxx2","xxxx3","xxxxN"...往后加
     *                                 而且这个参数必须要在最后,因为是不定参数;
     */
    public MiddleLinesDialog(int resIdDialogBelongTo, Context context, int marginLeftAndRight, int itemPaddingTopAndDown,
                             int topLeftAndRightRadius, int bottomLeftAndRightRadius,
                             int crossMarginLeftAndRight,
                             float dialogBgAlpha, String dialogBgColorHex,
                             float crossColorAlpha, String crossColorHex,
                             float textColorAlpha, String textColorHex,
                             int itemGravity, int paddingLeftOrRight,
                             ItemClickListener itemClickListener,
                             OnCancelListener cancelListener, String... texts) {
        super(context, true, cancelListener);
        this.mResIdDialogBelongTo = resIdDialogBelongTo;
        this.mContext = context;
        mScreenSize = getScreenSize(context);
        this.mMarginLeftAndRight = marginLeftAndRight;
        this.mCrossMarginLeftAndRight = crossMarginLeftAndRight;
        this.mItemPaddingTopAndDown = itemPaddingTopAndDown;
        this.mTopLeftAndRightRadius = topLeftAndRightRadius;
        this.mBottomLeftAndRightRadius = bottomLeftAndRightRadius;
        if (dialogBgAlpha > 1.0f || dialogBgAlpha < 0.0f) {
            throw new IllegalArgumentException("please pass a right dialogBgAlpha " +
                    "float value between 0.00 - 1.00");
        }
        this.mDialogBgAlpha = dialogBgAlpha;
        if (TextUtils.isEmpty(dialogBgColorHex)) {
            throw new IllegalArgumentException("please pass a right ColorHex");
        } else {
            if (dialogBgColorHex.length() != 6 ||
                    dialogBgColorHex.startsWith("#")) {
                throw new IllegalArgumentException("please pass a right ColorHex without #alpha");
            }
        }
        this.mDialogBgColorHex = dialogBgColorHex;

        if (crossColorAlpha > 1.0f || crossColorAlpha < 0.0f) {
            throw new IllegalArgumentException("please pass a right crossColorAlpha " +
                    "float value between 0.00 - 1.00");
        }
        this.mCrossColorAlpha = crossColorAlpha;
        if (TextUtils.isEmpty(crossColorHex)) {
            throw new IllegalArgumentException("please pass a right ColorHex");
        } else {
            if (crossColorHex.length() != 6 ||
                    crossColorHex.startsWith("#")) {
                throw new IllegalArgumentException("please pass a right ColorHex without #alpha");
            }
        }
        this.mCrossColorHex = crossColorHex;

        if (textColorAlpha > 1.0f || textColorAlpha < 0.0f) {
            throw new IllegalArgumentException("please pass a right crossColorAlpha " +
                    "float value between 0.00 - 1.00");
        }
        this.mTextColorAlpha = textColorAlpha;
        if (itemGravity != Gravity.CENTER && itemGravity != Gravity.LEFT && itemGravity != Gravity.RIGHT) {
            throw new IllegalArgumentException("please pass a Gravity between " +
                    "Gravity.CENTER,Gravity.LEFT and Gravity.RIGHT");
        }
        this.mItemGravity = itemGravity;
        this.mPaddingLeftOrRight = dip2px(context, paddingLeftOrRight);
        if (TextUtils.isEmpty(crossColorHex)) {
            throw new IllegalArgumentException("please pass a right ColorHex");
        } else {
            if (textColorHex.length() != 6 ||
                    textColorHex.startsWith("#")) {
                throw new IllegalArgumentException("please pass a right ColorHex without #alpha");
            }
        }
        this.mTextColorHex = textColorHex;

        if (texts == null || texts.length == 0) {
            throw new IllegalArgumentException("please pass a not null texts");
        }
        List<String> strings = Arrays.asList(texts);
        tvTextList.addAll(strings);
        this.itemClickListener = itemClickListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //低版本界面兼容,去掉背景,黑框
//        getWindow().setBackgroundDrawable(new BitmapDrawable());
        //或者↓都可以
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        init();
        setContentView(mLinearLayout);
    }

    private void init() {
        //横线
        //布局
        //处理对话框背景透明度,
        String dialogBgAlphaHex = Integer.toHexString(Math.round(255/*不透明*/ * mDialogBgAlpha));
        if (dialogBgAlphaHex.length() == 1) {
            dialogBgAlphaHex = "0" + dialogBgAlphaHex;
        }
        //处理对话框背景色
        int bgColor = getColorByHexStr("#" + dialogBgAlphaHex + mDialogBgColorHex);
        int topLeftAndRightRadius = dip2px(getContext(), mTopLeftAndRightRadius);
        int bottomLeftAndRightRadius = dip2px(getContext(), mBottomLeftAndRightRadius);
        mLinearLayout = new LinearLayout(getContext());
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(
                mScreenSize.x - mMarginLeftAndRight - mMarginLeftAndRight,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        mLinearLayout.setLayoutParams(layoutParams);
        mLinearLayout.setOrientation(LinearLayout.VERTICAL);
        //根据背景色,圆角值,得到一个相应的圆角背景
        StateListDrawable roundCornorRect = createRoundCornorRectStateListDrawable(
                topLeftAndRightRadius, bottomLeftAndRightRadius, bgColor);
        //拿到圆角背景设置对话框的背景
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            mLinearLayout.setBackground(roundCornorRect);
        } else {
            mLinearLayout.setBackgroundDrawable(roundCornorRect);
        }
        //根据传入的tvTextList,创建出对应的TextView
        for (int i = 0; i < tvTextList.size(); i++) {
            String text = tvTextList.get(i);
            TextView textView = createTextView(text, i, tvTextList.size(), mItemGravity);
            final int position = i;
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickListener.onClick(position);
                    dismiss();
                }
            });
            mLinearLayout.addView(textView);
            if (i < tvTextList.size() - 1) {//非最后一个
                mLinearLayout.addView(createCrossLine());
            }
        }
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     *
     * @param context
     * @param dpValue
     * @return
     */
    public static int dip2px(Context context, float dpValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 汉字
     */
    public static final int CHINESE = 0x000001;

    /**
     * 数字或字符
     */
    public static final int NUMBER_OR_CHARACTER = 0x000002;

    /**
     * sp转成px
     *
     * @param spValue
     * @param type
     * @return
     */
    public static float sp2px(Context context, float spValue, int type) {
        final float scale = context.getResources().getDisplayMetrics().density;
        switch (type) {
            case CHINESE:
                return spValue * scale;
            case NUMBER_OR_CHARACTER:
                return spValue * scale * 10.0f / 18.0f;
            default:
                return spValue * scale;
        }
    }

    private StateListDrawable createRoundCornorRectStateListDrawable(int topLeftAndRightRadius,
                                                                     int bottomLeftAndRightRadius,
                                                                     int bgColor) {
        ShapeDrawable pressedDrawable = getShapeDrawable(topLeftAndRightRadius, bottomLeftAndRightRadius, bgColor);
        //创建状态管理器
        StateListDrawable drawable = new StateListDrawable();
        //添加到状态管理里面
        drawable.addState(new int[]{}, pressedDrawable);
        return drawable;
    }

    @NonNull
    private ShapeDrawable getShapeDrawable(int topLeftAndRightRadius, int bottomLeftAndRightRadius, int bgColor) {
        float outRectr[] = new float[]{
                topLeftAndRightRadius, topLeftAndRightRadius,
                topLeftAndRightRadius, topLeftAndRightRadius,
                bottomLeftAndRightRadius, bottomLeftAndRightRadius,
                bottomLeftAndRightRadius, bottomLeftAndRightRadius};
        /**
         * 注意StateListDrawable的构造方法我们这里使用的
         * 是第一参数它是一个float的数组保存的是圆角的半径，它是按照top-left顺时针保存的八个值
         */
        //创建圆弧形状
        RoundRectShape rectShape = new RoundRectShape(outRectr, null, null);
        //创建drawable
        ShapeDrawable pressedDrawable = new ShapeDrawable(rectShape);
        //设置背景的颜色
        pressedDrawable.getPaint().setColor(bgColor);
        return pressedDrawable;
    }

    private TextView createTextView(String text, int index, int size, int gravity) {
        TextView textView = new TextView(mContext);
        textView.setBackgroundColor(mContext.getResources().getColor(android.R.color.white));
        textView.setGravity(gravity);
        String textColorAlphaHex = Integer.toHexString(Math.round(255/*不透明*/ * mTextColorAlpha));
        if (textColorAlphaHex.length() == 1) {
            textColorAlphaHex = "0" + textColorAlphaHex;
        }
        int textColor = getColorByHexStr("#" + textColorAlphaHex + mTextColorHex);

        textView.setTextColor(textColor);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                mScreenSize.x - mMarginLeftAndRight - mMarginLeftAndRight,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        textView.setLayoutParams(layoutParams);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            textView.setBackground(newSelector(
                    android.R.color.transparent,
                    getColorByHexStr(mMiddleLinesDiaglogPressColorStr),
                    android.R.color.transparent,
                    android.R.color.transparent,
                    index, size));
        } else {
            textView.setBackgroundDrawable(newSelector(
                    android.R.color.transparent,
                    getColorByHexStr(mMiddleLinesDiaglogPressColorStr),
                    android.R.color.transparent,
                    android.R.color.transparent,
                    index, size));
        }
        if (Gravity.LEFT == gravity) {
            textView.setPadding(mPaddingLeftOrRight, mItemPaddingTopAndDown, 0, mItemPaddingTopAndDown);
        } else if (Gravity.RIGHT == gravity) {
            textView.setPadding(0, mItemPaddingTopAndDown, mPaddingLeftOrRight, mItemPaddingTopAndDown);
        } else {
            textView.setPadding(0, mItemPaddingTopAndDown, 0, mItemPaddingTopAndDown);
        }
        textView.setText(text);
        return textView;
    }

    private int getColorByHexStr(String colorHex) {
        return android.graphics.Color.parseColor(colorHex);
    }

    private View createCrossLine() {
        String crossColorAlphaHex = Integer.toHexString(Math.round(255/*不透明*/ * mCrossColorAlpha));
        if (crossColorAlphaHex.length() == 1) {
            crossColorAlphaHex = "0" + crossColorAlphaHex;
        }
        int crossColor = getColorByHexStr("#" + crossColorAlphaHex + mCrossColorHex);
        View view = new View(mContext);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 1);
        layoutParams.setMargins(mCrossMarginLeftAndRight, 0, mCrossMarginLeftAndRight, 0);
        view.setBackgroundColor(crossColor);
        view.setLayoutParams(layoutParams);
        return view;
    }

    @Override
    public void onClick(View v) {

    }

    /**
     * 不想要效果就传入-1
     *
     * @param idColorNormal
     * @param idColorPressed
     * @param idColorFocused
     * @param idColorUnable
     * @return
     */
    public StateListDrawable newSelector(int idColorNormal, int idColorPressed,
                                         int idColorFocused, int idColorUnable,
                                         int index, int size) {
        Drawable normal = null;
        Drawable pressed = null;
        Drawable focused = null;
        Drawable unable = null;
        int topLeftAndRightRadius = dip2px(getContext(), mTopLeftAndRightRadius);
        int bottomLeftAndRightRadius = dip2px(getContext(), mBottomLeftAndRightRadius);
        if (index == 0) {//第一个需要上左 上右的角落需要圆角
            normal = createDrawable(topLeftAndRightRadius, 0, idColorNormal);
            pressed = createDrawable(topLeftAndRightRadius, 0, idColorPressed);
            focused = createDrawable(topLeftAndRightRadius, 0, idColorFocused);
            unable = createDrawable(topLeftAndRightRadius, 0, idColorUnable);
        } else if (index == size - 1) {//最后一个需要下左 下右的角落需要圆角
            normal = createDrawable(0, bottomLeftAndRightRadius, idColorNormal);
            pressed = createDrawable(0, bottomLeftAndRightRadius, idColorPressed);
            focused = createDrawable(0, bottomLeftAndRightRadius, idColorFocused);
            unable = createDrawable(0, bottomLeftAndRightRadius, idColorUnable);
        } else {
            normal = createDrawable(0, 0, idColorNormal);
            pressed = createDrawable(0, 0, idColorPressed);
            focused = createDrawable(0, 0, idColorFocused);
            unable = createDrawable(0, 0, idColorUnable);
        }
        return newSelector(normal, pressed, focused, unable);
    }

    /**
     * @param normal
     * @param pressed
     * @param focused
     * @param unable
     * @return
     */
    public static StateListDrawable newSelector(Drawable normal, Drawable pressed,
                                                Drawable focused, Drawable unable) {
        StateListDrawable bg = new StateListDrawable();
        // View.PRESSED_ENABLED_STATE_SET
        bg.addState(new int[]{android.R.attr.state_pressed, android.R.attr.state_enabled}, pressed);
        // View.ENABLED_FOCUSED_STATE_SET
        bg.addState(new int[]{android.R.attr.state_enabled, android.R.attr.state_focused}, focused);
        // View.ENABLED_STATE_SET
        bg.addState(new int[]{android.R.attr.state_enabled}, normal);
        // View.FOCUSED_STATE_SET
        bg.addState(new int[]{android.R.attr.state_focused}, focused);
        // View.WINDOW_FOCUSED_STATE_SET
        bg.addState(new int[]{android.R.attr.state_window_focused}, unable);
        // View.EMPTY_STATE_SET
        bg.addState(new int[]{}, normal);
        return bg;
    }

    private Drawable createDrawable(int topLeftAndRightRadius, int bottomLeftAndRightRadius,
                                    int bgColor) {
        ShapeDrawable shapeDrawable = getShapeDrawable(topLeftAndRightRadius, bottomLeftAndRightRadius, bgColor);
        return shapeDrawable;
    }

    public static Point getScreenSize(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point out = new Point();
        //Build.VERSION_CODES.HONEYCOMB_MR2 → 13
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            display.getSize(out);
        } else {
            int width = display.getWidth();
            int height = display.getHeight();
            out.set(width, height);
        }
        return out;
    }

    private ItemClickListener itemClickListener;

    private MiddleLinesDialog(Context context) {
        super(context);
        this.mContext = context;
    }

    private MiddleLinesDialog(Context context, int themeResId) {
        super(context, themeResId);
        this.mContext = context;
    }

    private MiddleLinesDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        this.mContext = context;
    }
}

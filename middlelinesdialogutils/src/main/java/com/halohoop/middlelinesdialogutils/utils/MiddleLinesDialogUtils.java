package com.halohoop.middlelinesdialogutils.utils;

import android.content.Context;
import android.content.DialogInterface;

import com.halohoop.middlelinesdialogutils.dialogs.ItemClickListener;
import com.halohoop.middlelinesdialogutils.dialogs.MiddleLinesDialog;

/**
 * Created by Pooholah on 2016/7/15.
 */
public class MiddleLinesDialogUtils {

    public static void show(int resIdDialogBelongTo, Context context, ItemClickListener itemClickListener,
                            String... texts) {
        new MiddleLinesDialog(resIdDialogBelongTo, context, itemClickListener, texts).show();
    }

    public static void show(int resIdDialogBelongTo, Context context, int marginLeftAndRight,
                            ItemClickListener itemClickListener,
                            String... texts) {
        new MiddleLinesDialog(resIdDialogBelongTo, context, marginLeftAndRight, itemClickListener, texts).show();
    }

    public static void show(int resIdDialogBelongTo, Context context, int marginLeftAndRight, int itemPaddingTopAndDown,
                            ItemClickListener itemClickListener,
                            String... texts) {
        new MiddleLinesDialog(resIdDialogBelongTo, context, marginLeftAndRight, itemPaddingTopAndDown, itemClickListener,
                texts).show();
    }

    public static void show(int resIdDialogBelongTo, Context context, int marginLeftAndRight, int itemPaddingTopAndDown,
                            int radius, ItemClickListener itemClickListener,
                            String... texts) {
        new MiddleLinesDialog(resIdDialogBelongTo, context, marginLeftAndRight, itemPaddingTopAndDown, radius,
                itemClickListener, texts).show();
    }

    public static void show(int resIdDialogBelongTo, Context context, int marginLeftAndRight, int itemPaddingTopAndDown,
                            int topLeftAndRightRadius, int bottomLeftAndRightRadius,
                            ItemClickListener itemClickListener,
                            String... texts) {
        new MiddleLinesDialog(resIdDialogBelongTo, context, marginLeftAndRight, itemPaddingTopAndDown,
                topLeftAndRightRadius, bottomLeftAndRightRadius, itemClickListener,
                null, texts).show();
    }

    public static void show(int resIdDialogBelongTo, Context context, int marginLeftAndRight, int itemPaddingTopAndDown,
                            int topLeftAndRightRadius, int bottomLeftAndRightRadius,
                            ItemClickListener itemClickListener,
                            DialogInterface.OnCancelListener cancelListener,
                            String... texts) {
        new MiddleLinesDialog(resIdDialogBelongTo, context, marginLeftAndRight, itemPaddingTopAndDown,
                topLeftAndRightRadius, bottomLeftAndRightRadius, itemClickListener,
                cancelListener, texts).show();
    }

    public static void show(int resIdDialogBelongTo, Context context, int marginLeftAndRight, int itemPaddingTopAndDown,
                            int topLeftAndRightRadius, int bottomLeftAndRightRadius,
                            int crossMarginLeftAndRight,
                            ItemClickListener itemClickListener,
                            DialogInterface.OnCancelListener cancelListener,
                            String... texts) {
        new MiddleLinesDialog(resIdDialogBelongTo, context, marginLeftAndRight, itemPaddingTopAndDown,
                topLeftAndRightRadius, bottomLeftAndRightRadius,
                crossMarginLeftAndRight,
                itemClickListener,
                cancelListener, texts).show();
    }

    public static void show(int resIdDialogBelongTo, Context context, int marginLeftAndRight, int itemPaddingTopAndDown,
                            int topLeftAndRightRadius, int bottomLeftAndRightRadius,
                            int crossMarginLeftAndRight,
                            float dialogBgAlpha, String dialogBgColorHex,
                            ItemClickListener itemClickListener,
                            DialogInterface.OnCancelListener cancelListener,
                            String... texts) {
        new MiddleLinesDialog(resIdDialogBelongTo, context, marginLeftAndRight, itemPaddingTopAndDown,
                topLeftAndRightRadius, bottomLeftAndRightRadius,
                crossMarginLeftAndRight,
                dialogBgAlpha, dialogBgColorHex,
                itemClickListener,
                cancelListener, texts).show();
    }

    public static void show(int resIdDialogBelongTo, Context context, int marginLeftAndRight, int itemPaddingTopAndDown,
                            int topLeftAndRightRadius, int bottomLeftAndRightRadius,
                            int crossMarginLeftAndRight,
                            float dialogBgAlpha, String dialogBgColorHex,
                            float crossColorAlpha, String crossColorHex,
                            ItemClickListener itemClickListener,
                            DialogInterface.OnCancelListener cancelListener,
                            String... texts) {
        new MiddleLinesDialog(resIdDialogBelongTo, context, marginLeftAndRight, itemPaddingTopAndDown,
                topLeftAndRightRadius, bottomLeftAndRightRadius,
                crossMarginLeftAndRight,
                dialogBgAlpha, dialogBgColorHex,
                crossColorAlpha, crossColorHex,
                itemClickListener,
                cancelListener, texts).show();
    }

    public static void show(int resIdDialogBelongTo, Context context, int marginLeftAndRight, int itemPaddingTopAndDown,
                            int topLeftAndRightRadius, int bottomLeftAndRightRadius,
                            int crossMarginLeftAndRight,
                            float dialogBgAlpha, String dialogBgColorHex,
                            float crossColorAlpha, String crossColorHex,
                            float textColorAlpha, String textColorHex,
                            ItemClickListener itemClickListener,
                            DialogInterface.OnCancelListener cancelListener,
                            String... texts) {
        new MiddleLinesDialog(resIdDialogBelongTo, context, marginLeftAndRight, itemPaddingTopAndDown,
                topLeftAndRightRadius, bottomLeftAndRightRadius,
                crossMarginLeftAndRight,
                dialogBgAlpha, dialogBgColorHex,
                crossColorAlpha, crossColorHex,
                textColorAlpha, textColorHex,
                itemClickListener,
                cancelListener, texts).show();
    }

    public static void show(int resIdDialogBelongTo, Context context, int marginLeftAndRight, int itemPaddingTopAndDown,
                            int topLeftAndRightRadius, int bottomLeftAndRightRadius,
                            int crossMarginLeftAndRight,
                            float dialogBgAlpha, String dialogBgColorHex,
                            float crossColorAlpha, String crossColorHex,
                            float textColorAlpha, String textColorHex,
                            int itemGravity,int padding,
                            ItemClickListener itemClickListener,
                            DialogInterface.OnCancelListener cancelListener,
                            String... texts) {
        new MiddleLinesDialog(resIdDialogBelongTo, context, marginLeftAndRight, itemPaddingTopAndDown,
                topLeftAndRightRadius, bottomLeftAndRightRadius,
                crossMarginLeftAndRight,
                dialogBgAlpha, dialogBgColorHex,
                crossColorAlpha, crossColorHex,
                textColorAlpha, textColorHex,
                itemGravity,padding,
                itemClickListener,
                cancelListener, texts).show();
    }


}

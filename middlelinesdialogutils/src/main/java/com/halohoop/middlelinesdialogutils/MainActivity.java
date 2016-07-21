package com.halohoop.middlelinesdialogutils;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;

import com.halohoop.middlelinesdialogutils.dialogs.ItemClickListener;
import com.halohoop.middlelinesdialogutils.utils.MiddleLinesDialogUtils;

public class MainActivity extends AppCompatActivity implements ItemClickListener,
        View.OnClickListener, DialogInterface.OnCancelListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.tv).setOnClickListener(this);
    }

    @Override
    public void onClick(int position) {
        Log.i("Halohoop", position + "根据position来区分点击了哪一个");
    }

    @Override
    public void onClick(View v) {
        //使用示例,一行代码一句对话框,示例示例示例示例示例,参数越多,越多自定义
//        MiddleLinesDialogUtils.show(this, this, "上传封面");
//        MiddleLinesDialogUtils.show(this, this, "上传封面", "转发", "拍照", "录像", "需要再往后加");
//        MiddleLinesDialogUtils.show(this, 10, this, "上传封面", "转发", "拍照", "录像", "需要再往后加");
//        MiddleLinesDialogUtils.show(this, 10, 30, this, "上传封面", "转发", "拍照", "录像", "需要再往后加");
//        MiddleLinesDialogUtils.show(this, 10, 10, 20, this, "上传封面", "转发", "拍照", "录像", "需要再往后加");
//        MiddleLinesDialogUtils.show(this, 100, 20, 4, 4, this, "上传封面", "转发", "拍照", "录像", "需要再往后加");
//        MiddleLinesDialogUtils.show(this, 100, 20, 4, 4, this, this, "上传封面", "转发", "拍照", "录像", "需要再往后加");
//        MiddleLinesDialogUtils.show(this, 100, 20, 4, 4, 100, this, this, "上传封面", "转发", "拍照", "录像", "需要再往后加");
//        MiddleLinesDialogUtils.show(this, 100, 20, 30, 30, 10, 0.50f, "ff00ff", this, this, "上传封面", "转发", "拍照", "录像", "需要再往后加");
//        MiddleLinesDialogUtils.show(this, 100, 20, 30, 10, 10, 0.50f, "ff0000", 0.30f, "00ff00", this, this, "上传封面", "转发", "拍照", "录像", "需要再往后加");
//        MiddleLinesDialogUtils.show(this,
//                100/*对话框距离左右的margin*/,
//                20/*每行textview 的paddingTop和paddingBottom*/,
//                30/*对话框上左和上右的圆角值*/,
//                10/*对话框下左和下右的圆角值*/,
//                10/*每个item之间的分割线的左右margin值*/,
//                0.50f, "ff0000",//对话框背景的透明度和颜色十六进制代码
//                0.30f, "00ff00", //每个item之间的分割线透明度和颜色十六进制代码
//                0.20f, "0000ff",//每行textview的透明度和颜色十六进制代码
//                this,//点击监听回调
//                this,//对话框取消监听回调
//                //以下为设置每一行的文字
//                "上传封面", "转发", "拍照", "录像", "需要再往后加...");
        MiddleLinesDialogUtils.show(this,
                100/*对话框距离左右的margin*/,
                20/*每行textview 的paddingTop和paddingBottom*/,
                30/*对话框上左和上右的圆角值*/,
                10/*对话框下左和下右的圆角值*/,
                0/*每个item之间的分割线的左右margin值*/,
                0.30f, "42B0FF",//对话框背景的透明度和颜色十六进制代码
                0.50f, "0000ff", //每个item之间的分割线透明度和颜色十六进制代码
                1.0f, "000000",//每行textview的透明度和颜色十六进制代码
                Gravity.LEFT,50,//每行textview的gravity 如果是left就是paddingLeft,如果是Right,就是paddingRight
                this,//点击监听回调
                this,//对话框取消监听回调
                //以下为设置每一行的文字
                "上传封面", "转发", "拍照", "录像", "需要再往后加...");
    }

    @Override
    public void onCancel(DialogInterface dialog) {
        Log.i("Halohoop", "取消对话框了 cancel");
    }
}

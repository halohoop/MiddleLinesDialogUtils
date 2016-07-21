## MiddleLinesDialogUtils

# Use just one line code to get a Custum Dialog in Android!

# This is a module of Android Studio Project;

# Feel free and help yourself!

![Markdown](http://i4.piimg.com/8359/d7b105b029635df4.jpg)
![Markdown](http://i4.piimg.com/8359/7dac0b579ba21ef5.jpg)
![Markdown](http://i4.piimg.com/8359/bfff4e23bdf9648c.jpg)
![Markdown](http://i4.piimg.com/8359/7ae09a6fc7a7781f.jpg)
![Markdown](http://i4.piimg.com/8359/8b819b19131d2b2d.jpg)
![Markdown](http://i4.piimg.com/8359/5bfc4381d23f0d35.jpg)

<pre><code>
        //使用示例,一行代码一句对话框,示例示例示例示例示例,参数越多,越多自定义
        MiddleLinesDialogUtils.show(this, this, "上传封面");
        MiddleLinesDialogUtils.show(this, this, "上传封面", "转发", "拍照", "录像", "需要再往后加");
        MiddleLinesDialogUtils.show(this, 10, this, "上传封面", "转发", "拍照", "录像", "需要再往后加");
        MiddleLinesDialogUtils.show(this, 10, 30, this, "上传封面", "转发", "拍照", "录像", "需要再往后加");
        MiddleLinesDialogUtils.show(this, 10, 10, 20, this, "上传封面", "转发", "拍照", "录像", "需要再往后加");
        MiddleLinesDialogUtils.show(this, 100, 20, 4, 4, this, "上传封面", "转发", "拍照", "录像", "需要再往后加");
        MiddleLinesDialogUtils.show(this, 100, 20, 4, 4, this, this, "上传封面", "转发", "拍照", "录像", "需要再往后加");
        MiddleLinesDialogUtils.show(this, 100, 20, 4, 4, 100, this, this, "上传封面", "转发", "拍照", "录像", "需要再往后加");
        MiddleLinesDialogUtils.show(this, 100, 20, 30, 30, 10, 0.50f, "ff00ff", this, this, "上传封面", "转发", "拍照", "录像", "需要再往后加");
        MiddleLinesDialogUtils.show(this, 100, 20, 30, 10, 10, 0.50f, "ff0000", 0.30f, "00ff00", this, this, "上传封面", "转发", "拍照", "录像", "需要再往后加");
        MiddleLinesDialogUtils.show(this,
                100/*对话框距离左右的margin*/,
                20/*每行textview 的paddingTop和paddingBottom*/,
                30/*对话框上左和上右的圆角值*/,
                10/*对话框下左和下右的圆角值*/,
                10/*每个item之间的分割线的左右margin值*/,
                0.50f, "ff0000",//对话框背景的透明度和颜色十六进制代码
                0.30f, "00ff00", //每个item之间的分割线透明度和颜色十六进制代码
                0.20f, "0000ff",//每行textview的透明度和颜色十六进制代码
                this,//点击监听回调
                this,//对话框取消监听回调
                //以下为设置每一行的文字
                "上传封面", "转发", "拍照", "录像", "需要再往后加...");
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
</code></pre>
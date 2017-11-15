package com.demo.floatingball;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import floatwindow.xishuang.float_lib.FloatActionController;
import floatwindow.xishuang.float_lib.permission.FloatPermissionManager;

public class MainActivity extends AppCompatActivity {

    WindowManager.LayoutParams params;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boolean isPermission = FloatPermissionManager.getInstance().applyFloatWindow(this);
        //有对应权限或者系统版本小于7.0
        if (isPermission || Build.VERSION.SDK_INT < 24) {
            //开启悬浮窗
            FloatActionController.getInstance().startMonkServer(this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //关闭悬浮窗
        FloatActionController.getInstance().stopMonkServer(this);
    }
}

package com.nzy.zkyt.kudipad.ui;

import android.Manifest;
import android.content.Intent;

import com.nzy.zkyt.kudipad.R;
import com.nzy.zkyt.kudipad.model.Setting;
import com.nzy.zkyt.kudipad.ui.base.BaseActivity;
import com.nzy.zkyt.kudipad.ui.base.BasePresenter;

import java.util.Timer;
import java.util.TimerTask;

import kr.co.namee.permissiongen.PermissionGen;

public class SplashActivity extends BaseActivity {
    @Override
    protected void initView() {
    }

    @Override
    protected String getBarTitle() {
        return null;
    }

    @Override
    public void initData() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                if (Setting.isExist()) {
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    jumpToActivity(intent);
                    finish();
                } else {
                    Intent intent = new Intent(SplashActivity.this, SettingActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    jumpToActivity(SettingActivity.class);
                    finish();
                }
            }
        }, 3000);

    }

    @Override
    public void init() {
        PermissionGen.with(this)
                .addRequestCode(100)
                .permissions(
                        //电话通讯录
                        Manifest.permission.GET_ACCOUNTS,
                        Manifest.permission.READ_PHONE_STATE,
                        //位置
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        //相机、麦克风
                        Manifest.permission.RECORD_AUDIO,
                        Manifest.permission.WAKE_LOCK,
                        Manifest.permission.CAMERA,
                        //存储空间
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_SETTINGS
                ).request();
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_splash;
    }
}

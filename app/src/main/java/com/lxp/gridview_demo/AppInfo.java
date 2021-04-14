package com.lxp.gridview_demo;

import android.content.Intent;
import android.graphics.drawable.Drawable;

public class AppInfo {

//    图标，Drawable类型
    private Drawable mAppIcon;
//    App名称，String类型
    private String mAppTitle;
//    App的启动项
    private Intent mAppIntent;

    private boolean mIsSystemApp;

    @Override
    public String toString() {
        return "AppInfo{" +
                "mAppIcon=" + mAppIcon +
                ", mAppTitle='" + mAppTitle + '\'' +
                ", mAppIntent=" + mAppIntent +
                ", mIsSystemApp=" + mIsSystemApp +
                '}';
    }

    public AppInfo(Drawable appIcon, String appTitle, boolean isSystemApp, Intent appIntent) {
        this.mAppIcon = appIcon;
        this.mAppTitle = appTitle;
        this.mIsSystemApp = isSystemApp;
        this.mAppIntent = appIntent;
    }

    public Drawable getAppIcon() {
        return mAppIcon;
    }

    public void setAppIcon(Drawable appIcon) {
        this.mAppIcon = appIcon;
    }

    public String getAppTitle() {
        return mAppTitle;
    }

    public void setAppTitle(String appTitle) {
        this.mAppTitle = appTitle;
    }

    public void setIsSystemApp(boolean isSystemApp) {
        this.mIsSystemApp = isSystemApp;
    }

    public boolean isSystemApp() {
        return mIsSystemApp;
    }

    public Intent getAppIntent() {
        return mAppIntent;
    }

    public void setAppIntent(Intent appIntent) {
        this.mAppIntent = appIntent;
    }
}

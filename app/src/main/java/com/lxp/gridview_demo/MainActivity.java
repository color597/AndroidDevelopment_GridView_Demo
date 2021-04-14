package com.lxp.gridview_demo;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private GridView mGridView;
    private boolean mIsSysApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        List<AppInfo> appInfoList = new ArrayList<>();

        PackageManager packageManager = getPackageManager();

        Intent intent = new Intent();
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        intent.setAction(Intent.ACTION_MAIN);
        List<ResolveInfo> resolveInfos = packageManager.queryIntentActivities(intent, 0);
        ApplicationInfo applicationInfo;
        for (ResolveInfo resolveInfo : resolveInfos) {
            applicationInfo = resolveInfo.activityInfo.applicationInfo;
            this.mIsSysApp = (applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) == 1;
            Drawable appIcon = resolveInfo.loadIcon(packageManager);
            String appTitle = (String) resolveInfo.loadLabel(packageManager);
            appInfoList.add(new AppInfo(appIcon, appTitle, this.mIsSysApp, new Intent().setClassName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name)));
        }

        this.mGridView = findViewById(R.id.grid_view);
        this.mGridView.setNumColumns(4);
        this.mGridView.setAdapter(new AppAdapter(this, R.layout.grid_item_view, appInfoList));
        //设置单击事件
        this.mGridView.setOnItemClickListener((parent, view, position, id) -> {
            AppInfo appInfo = appInfoList.get(position);
            startActivity(appInfo.getAppIntent());
        });
        //设置长按事件
        this.mGridView.setOnItemLongClickListener((parent, view, position, id) -> {
            AppInfo appInfo = appInfoList.get(position);
            String tip = appInfo.isSystemApp() ? "这是系统应用" : "这是用户应用";
            Toast.makeText(MainActivity.this, tip, Toast.LENGTH_SHORT).show();
            return false;
        });
    }

}
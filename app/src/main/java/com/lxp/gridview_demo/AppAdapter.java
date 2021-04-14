package com.lxp.gridview_demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class AppAdapter extends ArrayAdapter<AppInfo> {

    private int mLayoutResId;

    public AppAdapter(@NonNull Context context, int resource, @NonNull List<AppInfo> appInfoList) {
        super(context, resource, appInfoList);
        this.mLayoutResId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view;
        AppInfo appInfo = getItem(position);

        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(this.mLayoutResId, parent, false);
        } else {
            view = convertView;
        }

        ImageView appIconView = view.findViewById(R.id.app_icon);
        TextView appTitleView = view.findViewById(R.id.app_title);

        appIconView.setImageDrawable(appInfo.getAppIcon());
        appTitleView.setText(appInfo.getAppTitle());

        return view;
    }

}

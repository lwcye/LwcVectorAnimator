package com.cqmc.lwcvectoranimator.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.cqmc.lwcvectoranimator.R;
import com.cqmc.lwcvectoranimator.adapter.RUAdapter;
import com.cqmc.lwcvectoranimator.adapter.RUViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        mRvMain = (RecyclerView) findViewById(R.id.rv_main);
        mRvMain.setLayoutManager(new LinearLayoutManager(this));
        List<ResolveInfo> resolveInfos = new ArrayList<>();
        PackageManager packageManager = getPackageManager();
        resolveInfos = packageManager.queryIntentActivities(new Intent("com.lwc.vector"), PackageManager.COMPONENT_ENABLED_STATE_DEFAULT);
        mRvMain.setAdapter(new RUAdapter<ResolveInfo>(this, resolveInfos, android.support.v7.appcompat.R.layout.select_dialog_item_material) {
            @Override
            protected void onInflateData(RUViewHolder holder, final ResolveInfo data, int position) {
                int resourceId = getApplicationContext().getResources().getIdentifier("text1", "id", "android");
                holder.setText(resourceId, data.activityInfo.loadLabel(getPackageManager()));
                holder.setOnClickListener(resourceId, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent().setComponent(new ComponentName(getApplicationContext(), data.activityInfo.name)));
                    }
                });
            }
        });
    }
}

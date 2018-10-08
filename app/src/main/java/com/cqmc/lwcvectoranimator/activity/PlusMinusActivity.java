package com.cqmc.lwcvectoranimator.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.cqmc.lwcvectoranimator.R;
import com.cqmc.lwcvectoranimator.utils.ViewUtil;

public class PlusMinusActivity extends AppCompatActivity {
    boolean isCheck = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plus_minus);
        ImageView iv = (ImageView) findViewById(R.id.iv_plus_minus);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isCheck = !isCheck;
                ViewUtil.setImageCheckBg(((ImageView) v), isCheck);
            }
        });
    }
}

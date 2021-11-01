package com.ict.listviewprj1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class SubActivity extends Activity {
    ImageView ivFlag;
    TextView tvFlag;
    Button returnBtn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        ivFlag = (ImageView) findViewById(R.id.ivFlag);
        tvFlag = (TextView) findViewById(R.id.tvFlag);
        returnBtn = (Button) findViewById(R.id.returnBtn);

        int[] flagNums = {R.drawable.flag0, R.drawable.flag1, R.drawable.flag2, R.drawable.flag3, R.drawable.flag4, R.drawable.flag5, R.drawable.flag6, R.drawable.flag7, R.drawable.flag8, R.drawable.flag9, R.drawable.flag10, R.drawable.flag11, R.drawable.flag12, R.drawable.flag13, R.drawable.flag14};

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        int idx = intent.getIntExtra("idx", 0);

        ivFlag.setImageResource(flagNums[idx]);
        tvFlag.setText(name + "입니다.");

        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

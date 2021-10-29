package com.ict.loginprj;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class SuccessActivity extends Activity {

    Button logoutBtn;
    TextView idTv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginf_success);

        logoutBtn = (Button) findViewById(R.id.logoutBtn);
        idTv = (TextView) findViewById(R.id.idTv);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        idTv.setText(id + "님 환영합니다.");
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

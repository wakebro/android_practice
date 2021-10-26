package com.ict.widgetprj8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    Button prev, next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        // 뷰 플리퍼는 final로 선언해야 제대로 돌아가기 때문에
        // onCreate 안쪽에 선언
        // 다른 부품들은 일반적으로 선언 위치가 따로 정해져 있지 않다.
        final ViewFlipper vf1;
        vf1 = (ViewFlipper) findViewById(R.id.vf1);
        prev = (Button) findViewById(R.id.prevBtn);
        next = (Button) findViewById(R.id.nextBtn);

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vf1.showPrevious();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vf1.showNext();
            }
        });
    }
}
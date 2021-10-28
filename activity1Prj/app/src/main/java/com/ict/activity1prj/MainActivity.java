package com.ict.activity1prj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        next = (Button) findViewById(R.id.next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 정보 전달은 Intent 객체를 활용
                // 1번 파라미터로 getApplicationContext, 2번 파라미터로 이동할 페이지 클래스
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);

                // intent에 기입된 목적지로 이동
                // MainActivity 이외의 다른 요소를 추가할 때는
                // AndroidManifest.xml에 관련 정보를 등록해야 한다.
                startActivity(intent);
            }
        });
    }
}
package com.ict.HelloAndroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.button1);

        // button1 클릭시 이벤트 연결
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // 실제로 일어나는 이벤트는 onClick 메서드 내부에서 진행
                Toast.makeText(getApplicationContext(), "버튼을 눌렀습니다.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
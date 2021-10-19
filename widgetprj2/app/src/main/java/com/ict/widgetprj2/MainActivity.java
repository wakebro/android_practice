package com.ict.widgetprj2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // 창부품 선언
    TextView tv1;
    Button btn1;
    Boolean bl;
    Integer num;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 선언된 창부품 연결
        tv1 = (TextView) findViewById(R.id.textView1);
        btn1 = (Button) findViewById(R.id.btn1);
        bl = true;
        num = 1;

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                if(bl) {
                    tv1.setTextSize(50);
                    tv1.setTextColor(Color.BLUE);
                    tv1.setTypeface(Typeface.SERIF);
                    tv1.setText("DAMOYO조_형기상");
                    bl = false;
                    // 콘솔 디버깅1
                    System.out.println(bl);
                    // 콘솔 디버깅2_선호!!
                    Log.i("태그명", "로깅내용");
                    // 토스트 디버깅
                    Toast.makeText(getApplicationContext(), "토스트로 디버깅 가능", Toast.LENGTH_LONG).show();
                    
                } else {
                    tv1.setText("형기상");
                    tv1.setTextColor(Color.BLACK);
                    tv1.setTextSize(30);
                    bl = true;
                    System.out.println(bl);
                }
                */
                switch (num){
                    case 1:
                        tv1.setTextSize(50);
                        tv1.setTextColor(Color.BLUE);
                        tv1.setTypeface(Typeface.SERIF);
                        tv1.setText("DAMOYO조_형기상");
                        num += 1;
                        // 콘솔 디버깅2_선호!!
                        Log.i("태그명", "blue");
                        break;
                    case 2:
                        tv1.setTextSize(50);
                        tv1.setTextColor(Color.RED);
                        tv1.setTypeface(Typeface.SERIF);
                        tv1.setText("DAMOYO조_형기상");
                        num += 1;
                        // 콘솔 디버깅2_선호!!
                        Log.i("태그명", "red");
                        break;
                    case 3:
                        tv1.setTextSize(50);
                        tv1.setTextColor(Color.YELLOW);
                        tv1.setTypeface(Typeface.SERIF);
                        tv1.setText("DAMOYO조_형기상");
                        num = 1;
                        // 콘솔 디버깅2_선호!!
                        Log.i("태그명", "yellow");
                        break;
                }
            }
        });
    }
}
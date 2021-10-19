package com.ict.widgetprj;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    
    // 창부품 TextView 3개 선언
    TextView tv1, tv2, tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TextView 연결
        tv1 = (TextView) findViewById(R.id.textView1);
        tv2 = (TextView) findViewById(R.id.textView2);
        tv3 = (TextView) findViewById(R.id.textView3);

        // TextView1의 문장 변경
        tv1.setText("안녕하세요? TextView 1번입니다.");
        tv1.setTextColor(Color.MAGENTA);

        // TextView2의 글씨 크기를 크게 설정
        // 글꼴은 Serif, 스타일은 italic
        tv2.setTextSize(50);
        tv2.setTypeface(Typeface.SERIF, Typeface.ITALIC);

        // TextView3의 문장을 100글자 이상으로 설정
        // singleLine
        tv3.setText("가나다라마바사아자차카타파하가나다라마바사아자차카타파하가나다라마바사아자차카타파하가나다라마바사아자차카타파하가나다라마바사아자차카타파하가나다라마바사아자차카타파하가나다라마바사아자차카타파하가나다라마바사아자차카타파하가나다라마바사아자차카타파하가나다라마바사아자차카타파하");
        tv3.setSingleLine();

    }
}
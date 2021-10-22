package com.ict.tablecalculatorprj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // 창부품 선언

    // 버튼이 10개 이므로 10개 빈 버튼 생성
    Button[] numBtns = new Button[10];
    // 숫자버튼은 인덱스번호 = 실제 버튼에 적힌 번호값이므로
    // 배열로 저장
    Integer[] numBtnIDs = {R.id.num0, R.id.num1, R.id.num2, R.id.num3, R.id.num4, R.id.num5, R.id.num6, R.id.num7, R.id.num8, R.id.num9};

    EditText et1, et2;
    TextView result;
    Button key_plu, key_min, key_mul, key_div;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 10개 버튼이 0~9까지 숫자로 배정되어있으므로 반복문으로 배정
        for(int i=0; i < 10; i++){
            numBtns[i] = findViewById(numBtnIDs[i]);
        }
        // 연결하기
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        result = (TextView) findViewById(R.id.result);
        key_plu = (Button) findViewById(R.id.key_plu);
        key_min = (Button) findViewById(R.id.key_min);
        key_mul = (Button) findViewById(R.id.key_mul);
        key_div = (Button) findViewById(R.id.key_div);


    }
}
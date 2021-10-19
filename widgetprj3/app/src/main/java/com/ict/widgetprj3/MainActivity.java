package com.ict.widgetprj3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // 창부품 선언
    EditText et;
    Button btn;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 창부품 연결
        et = (EditText) findViewById(R.id.et1);
        btn = (Button) findViewById(R.id.btn);
        tv = (TextView) findViewById(R.id.textView1);

        //버튼에 온클릭 연결
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("click", "클림감지원");

                // EditText 내부 부품 값 가져오기
                String result = et.getText().toString();
                et.setText("");

                tv.setText(result);
                // 얻어온 값을 로그로 출력력
                Log.i("result", result);
                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
            }
        });

   }
}
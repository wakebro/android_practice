package com.ict.interactactivityprj;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
public class SubActivity extends Activity {

    Button returnBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        returnBtn = (Button) findViewById(R.id.returnBtn);

        // startActivityForResult는 defaultValue(값이 안들어오면 대신 받을 값)을 설정해주어야 한다
        Intent intent = getIntent();
        int num1 = intent.getIntExtra("num1", 0);
        int num2 = intent.getIntExtra("num2", 0);

        // main에서 보낸 두 숫자 합을 sub에서 처리
        int resultNum = num1 + num2;

        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 인텐트 종료시 돌려보낼 값은, 목적지가 mainActivity인 인텐트를 다시 만들어 보낸다
                Intent returnIntent = new Intent(getApplicationContext(), MainActivity.class);
                returnIntent.putExtra("resultNum", resultNum);
                // 입력된 값은 setResult로 보내고, RESULT_OK는 상수 -1이다
                // setResult에 담긴 인텐트는 뒤로가기 시 main쪽에 연결된다.
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });


    }
}

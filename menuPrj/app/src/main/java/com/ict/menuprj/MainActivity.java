package com.ict.menuprj;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    // 창부품 선언
    // 리니어 레이아웃 1개, 버튼 1개
    LinearLayout outLayout;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 창부품 연결
        outLayout = (LinearLayout) findViewById(R.id.outLayout);
        btn1 = (Button) findViewById(R.id.btn1);

        setTitle("화면 상단 이름 바꾸기");
    }

    // 외부 xml파일 추가 등록
    // 커서를 onCreate 바깥에 둔 다음 상단의 code -> Override Methods를 선택하고,
    // onCreateOptionsMenu를 선택
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        // 메뉴 추가를 위해 inflater를 활용
        MenuInflater mInflater = getMenuInflater();
        // 기존 레이아웃에 메뉴 삽입
        // .inflate(리소스 폴더 내 xml파일 지정, menu);
        mInflater.inflate(R.menu.menu1, menu);
        return true;
    }

    // 옵션 요소가 선택되었을 때 실행할 코드 추가
    // code -> Override Methods를 선택
    // onOptionsItemSelected()를 자동완성 시킨 후 item.getItemId()를 디버깅
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        // Log.d("debug",item.getItemId()+"");
        if(item.getItemId() == R.id.backRed) outLayout.setBackgroundColor(Color.RED);
        if(item.getItemId() == R.id.backGreen) outLayout.setBackgroundColor(Color.GREEN);
        if(item.getItemId() == R.id.backYellow) outLayout.setBackgroundColor(Color.YELLOW);
        if(item.getItemId() == R.id.backBlue) outLayout.setBackgroundColor(Color.BLUE);
        if(item.getItemId() == R.id.rotate) {
            // Log.d("각도", btn1.getRotation()+"");
            float dgree = Float.parseFloat(btn1.getRotation()+"");
            btn1.setRotation(dgree + 45);
        }
        if(item.getItemId() == R.id.upSize) {
            btn1.setScaleX(2);
            btn1.setScaleY(2);
        }

        return super.onOptionsItemSelected(item);
    }
}
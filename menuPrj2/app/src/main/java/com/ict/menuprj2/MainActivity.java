package com.ict.menuprj2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0,1,0,"배경을 빨강으로 바꾸기");
        menu.add(0,2,0,"배경을 파랑으로 바꾸기");
        menu.add(0,3,0,"배경을 노랑으로 바꾸기");
        menu.add(0,4,0,"배경을 초록으로 바꾸기");
        // 서브 메뉴 추가
        SubMenu sMenu = menu.addSubMenu("서브 메뉴명");
        sMenu.add(0,5,0,"버튼 45도 회전");
        sMenu.add(0,6,0,"버튼 2배");
        sMenu.add(0,7,0,"버튼 초기화");

        return true;
    }

    // 옵션 요소가 선택되었을 때 실행할 코드 추가
    // code -> Override Methods를 선택
    // onOptionsItemSelected()를 자동완성 시킨 후 item.getItemId()를 디버깅
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        Log.d("debug",item.getItemId()+"");
        if(item.getItemId() == 1) outLayout.setBackgroundColor(Color.RED);
        else if(item.getItemId() == 2) outLayout.setBackgroundColor(Color.BLUE);
        else if(item.getItemId() == 3) outLayout.setBackgroundColor(Color.YELLOW);
        else if(item.getItemId() == 4) outLayout.setBackgroundColor(Color.GREEN);
        else if(item.getItemId() == 5) {
            float rotation = Float.parseFloat(btn1.getRotation() + "");
            btn1.setRotation(rotation + 45);
        }
        else if(item.getItemId() == 6) {
            float scaleX = Float.parseFloat(btn1.getScaleX() + "");
            float scaleY = Float.parseFloat(btn1.getScaleY() + "");
            btn1.setScaleX(scaleX * 2);
            btn1.setScaleY(scaleY * 2);
        }
        else if(item.getItemId() == 7) {
            btn1.setRotation(0);
            btn1.setScaleX(1);
            btn1.setScaleY(1);
        }


        return super.onOptionsItemSelected(item);
    }
}
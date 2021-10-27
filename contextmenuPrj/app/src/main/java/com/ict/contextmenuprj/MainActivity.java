package com.ict.contextmenuprj;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout bgl;
    Button backBtn, changeBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bgl = (LinearLayout) findViewById(R.id.bgl);
        backBtn = (Button) findViewById(R.id.backBtn);
        changeBtn = (Button) findViewById(R.id.changeBtn);
        // rotation, size를 클릭했을 때 컨텍스트 메뉴가 뜨도록 연결
        registerForContextMenu(backBtn);
        registerForContextMenu(changeBtn);

    }

    // 각각 버튼을 클릭했을 때 menu1, menu2가 조건에 맞게 표출되도록 설정
    // onCreateContextMenu를 Override를 통해 구현
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        // 메뉴 생성을 위해 Inflater 생성
        MenuInflater mInflater = getMenuInflater();
        // v는 위에 추가한 registerForContextMenu에 등록된 요소이다.
        // 롱클릭이므로 길게 눌러야 나온다.
        Log.d("tag", v+"");
        if (v == backBtn) {
            // backBtn에는 menu1.xml을 연결
            mInflater.inflate(R.menu.menu1, menu);
        }
        if (v == changeBtn) {
            mInflater.inflate(R.menu.menu2, menu);
        }


        super.onCreateContextMenu(menu, v, menuInfo);
    }

    // menu1, menu2 내부의 옵션을 클릭했을 때, 실행할 내용들은
    // onContextItemSelected를 Override를 통해 구현
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        Log.d("item",item.getItemId()+"");
        if(item.getItemId() == R.id.backRed) bgl.setBackgroundColor(Color.RED);
        else if(item.getItemId() == R.id.backGray) bgl.setBackgroundColor(Color.GRAY);
        else if(item.getItemId() == R.id.backGreen) bgl.setBackgroundColor(Color.GREEN);
        else if(item.getItemId() == R.id.backYellow) bgl.setBackgroundColor(Color.YELLOW);
        else if(item.getItemId() == R.id.rotationBtn) {
            float rotation = changeBtn.getRotation();
            backBtn.setRotation(rotation + 45);
            changeBtn.setRotation(rotation + 45);
        }
        else if(item.getItemId() == R.id.sizeUpBtn) {
            float size = changeBtn.getScaleX();
            backBtn.setScaleX(size * 2);
            backBtn.setScaleY(size * 2);
            changeBtn.setScaleX(size * 2);
            changeBtn.setScaleY(size * 2);
        }else if(item.getItemId() == R.id.reset) {
            backBtn.setRotation(0);
            backBtn.setScaleX(1);
            backBtn.setScaleY(1);
            changeBtn.setRotation(0);
            changeBtn.setScaleX(1);
            changeBtn.setScaleY(1);
        }
        return super.onContextItemSelected(item);
    }
}
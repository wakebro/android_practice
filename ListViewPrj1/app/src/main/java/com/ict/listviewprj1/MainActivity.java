package com.ict.listviewprj1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView lv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv1 = (ListView) findViewById(R.id.lv1);

        // 리스트뷰에 적용할 목록
        final String[] trips = {"중국", "일본", "미국", "호주", "러시아", "태국", "불가리아", "이탈리아", "스웨덴", "스위스", "프랑스", "대만", "체코", "우크라이나", "볼리비아"};

        // 리스트뷰는 AdapterView를 상속해 만들어졌음
        // 생성시 .xml화면(this를 주면 자동으로 setContentView에서 설정한 파일로 잡힌다).
        // 스타일, 그리고 출력자료를 파라미터로 순서대로 넣는다.
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, trips);

        // lv1에 adapter내용을 적용
        lv1.setAdapter(adapter);

        // 위임식 클릭 이벤트 처리
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                /*Log.d("parent확인", parent + "");
                Log.d("view확인", view + "");
                Log.d("position확인", position + "");
                Log.d("id확인", id + "");*/
                // 인덱스 번호를 이용해 클릭하면 Toast형태로 클릭한 도시명이 뜨도록 설정
                Toast.makeText(getApplicationContext(), trips[position] + "", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), SubActivity.class);
                intent.putExtra("idx", position);
                intent.putExtra("name", trips[position]);
                startActivity(intent);
            }
        });
    }
}
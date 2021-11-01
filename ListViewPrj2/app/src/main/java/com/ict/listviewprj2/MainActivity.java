package com.ict.listviewprj2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText et1;
    Button btn1;
    ListView lv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.et1);
        btn1 = (Button) findViewById(R.id.btn1);
        lv1 = (ListView) findViewById(R.id.lv1);

        // 리스트 생성
        // 리스트로 올 수 있는 것은 배열([]), ArrayList 등이다.
        // 가변적으로 변동을 주기 위해서는 ArrayList가 온다.
        final ArrayList<String> strArray = new ArrayList<>();

        // 위의 목록을 토대로 자료가 들어갈 Adapter 생성
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, strArray);
        lv1.setAdapter(adapter);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // btn 클릭 시, et1에 있던 요소를 ArrayList에 .add()로 넣는다
                strArray.add(et1.getText() + "");
                et1.setText("");
                // 어댑터에 추가된 리스트로 갱신 반영
                adapter.notifyDataSetChanged();
            }
        });

        // 삭제는 추가된 요소를 길게 클릭하면(Long click) 삭제되도록 처리
        lv1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                // 위쪽 파라미터들을 토대로 trips.remove()를 이용해
                // 길게 클락한 요소가 삭제
                /*Log.d("parent", parent+"");
                Log.d("view", view+"");
                Log.d("position", position+"");
                Log.d("id", id+"");*/
                strArray.remove(position);
                adapter.notifyDataSetChanged();
                // false로 두면 된다.
                return false;
            }
        });
    }
}
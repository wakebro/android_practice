package com.ict.dialogprj;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.btn1);

        //선택지 없는 안내창
        /*
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 다이어그램 생성
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("제목을 적으세요");
                dlg.setMessage("띄울 메세지를 적으세요");
                dlg.setIcon(R.drawable.ic_launcher_foreground);
                // 확인 버튼 추가
//                dlg.setPositiveButton("확인", null);
                // 확인버튼 눌렀을 때 이벤트까지 거는 경우 두번째 파라미터에 new D까지 적고
                // 자동완성하면 온클릭 이벤트를 추가로 걸 수 있다.
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "확인함", Toast.LENGTH_SHORT).show();
                    }
                });
                // 취소 버튼
//                dlg.setNegativeButton("취소", null);
                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "취소됨",Toast.LENGTH_SHORT).show();
                    }
                });
                // 모든 세팅이 끝나면 화면 출력
                dlg.show();
            }
        });
        */

        // 선택지 있는 안내창
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 선택지는 리스트로 관리
                final String[] animalArray = new String[]{"고양이", "강아지", "토끼"};
                // 대화상자 생성
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                // 설정
                dlg.setTitle("");
                dlg.setIcon(R.drawable.ic_launcher_foreground);
                // 선택지는 위의 animalArray를 반복문으로 반복해서 넣어준다
                /* setItems는 단순 선택지이기 때문에 선택해야할 것처럼 안보인다.
                dlg.setItems(animalArray, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // 눌린 것은 int which로 감지
                        Toast.makeText(MainActivity.this, animalArray[which]+"", Toast.LENGTH_SHORT).show();
                    }
                });
                 */

                // 라디오 버튼으로 선택
                /*
                dlg.setSingleChoiceItems(animalArray, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, animalArray[which]+"", Toast.LENGTH_SHORT);
                    }
                });
                dlg.setPositiveButton("닫기", null);
                dlg.show();
                */

                // 체크박스 형식은 선택됨/안됨 여부를 true/false로 처리
                final boolean[] checkArray = {true, true, false};
                dlg.setMultiChoiceItems(animalArray, checkArray, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        if (isChecked) {
                            Toast.makeText(MainActivity.this, animalArray[which] + " 체크", Toast.LENGTH_SHORT).show();
                        } else
                            Toast.makeText(MainActivity.this, animalArray[which] + " 체크헤제", Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.setPositiveButton("닫기", null);
                dlg.show();
            }
        });
    }
}
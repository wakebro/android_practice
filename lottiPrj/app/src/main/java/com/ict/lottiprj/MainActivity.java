package com.ict.lottiprj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView view, view2;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view = (TextView) findViewById(R.id.view);
        view2 = (TextView) findViewById(R.id.view2);
        btn = (Button) findViewById(R.id.btn);

        // 버튼 눌렀을 경우 이벤트 설정
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 로또번호 6개를 담아둘 ArrayList 생성
                List<Integer> lotto = new ArrayList<>();
                int num = 0;
                // Lotto 내부 자료가 6개가 되기 전까지 무한반복
                while(lotto.size() != 6){
                    // Math.random()의 결과값은 0보다 크고 1보다 작으므로
                    // 0.9999999... * 45 결과는 45보다 작다
                    // 정수 변환시 무조건 0~44 범위를 가지므로 +1을 하여
                    // 범위를 1 ~ 45로 교체
                    num = (int) (Math.random() * 45) + 1;

                    // 기존 당첨번호에 중복되는지 여부를 확인하여 없는 번호만
                    // lotto 안에 추가한다.
                    if(!lotto.contains(num)){
                        lotto.add(num);
                    }
                }
                // 보너스 번호 담아둘 자료형 생성
                boolean bl = true;
                int num2 = 0;
                // 위 Lotto에 포함되지 않을 번호 구할 때까지 무한반복
                while(bl){
                    num2 = (int) (Math.random() * 45) + 1;
                    if(!lotto.contains((num2))){
                        bl = false;
                    }
                }
                Collections.sort(lotto);
                view.setText("로또 6개 번호\n"+ lotto );
                view2.setText("보너스 번호 : " + num2);

            }
        });
    }
}
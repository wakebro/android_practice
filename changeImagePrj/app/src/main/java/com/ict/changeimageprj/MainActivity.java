package com.ict.changeimageprj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView view1, view2;
    CheckBox cb1;
    RadioGroup rg;
    RadioButton rb1, rb2;
    Button btn;
    ImageView iv1, iv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view1 = (TextView) findViewById(R.id.view1);
        view2 = (TextView) findViewById(R.id.view2);
        cb1 = (CheckBox) findViewById(R.id.cb1);
        rg = (RadioGroup) findViewById(R.id.rg);
        rb1 = (RadioButton) findViewById(R.id.rb1);
        rb2 = (RadioButton) findViewById(R.id.rb2);
        btn = (Button) findViewById(R.id.btn);
        iv1 = (ImageView) findViewById(R.id.iv1);
        iv2 = (ImageView) findViewById(R.id.iv2);

        // 체크박스 클릭을 감지하도록 하려면 setOnCheckedChangeListener를 사용하고
        // 내부에는 new C가지 적어 자동완성을 시키면 된다
        cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                Log.d("클릭됨", "클릭중");
                // true, false여부 체크
//                Log.d("버튼", btn.toString());
//                Log.d("체크박스", isChecked+"");

                // 체크박스가 true면 어플이 보이게, false면 안보이게 하기위해 if문 분기
                if(isChecked){
                    // ImageView를 제외한 창부품을 보이도록 전환
                    // setVisibility를 사용
                    view2.setVisibility(View.VISIBLE);
                    rg.setVisibility(View.VISIBLE);
                    btn.setVisibility(View.VISIBLE);

                }else{
                    // 창부품을 안보이도록 전환
                    view2.setVisibility(View.INVISIBLE);
                    rg.setVisibility(View.INVISIBLE);
                    btn.setVisibility(View.INVISIBLE);
                    iv1.setVisibility(View.INVISIBLE);
                    iv2.setVisibility(View.INVISIBLE);
                    iv1.setSelected(false);
                    iv2.setSelected(false);
                }
            }
        });

        // 어떤 동물의 사진을 보여줄지는, 위의 어플 요소와는 별개로
        // RadioButton에 뭐가 선택되었는지만을 판단하여야 하기 때문에 따로 지정
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 무엇을 찍었는지 확인
                // RadioGroup 내부의 RadioButton을 감지할 때는
                // RadioGroup변수.getCheckedRadioButtonId()를 사용하여
                // 선택한 버튼의 ID값을 가져온다.
                int checked = rg.getCheckedRadioButtonId();
                Log.d("선택 버튼", checked+"");

                if(checked == 2131231049){
                    Log.i("안내", "고양이 선택");
                    iv1.setVisibility(View.VISIBLE);
                    iv2.setVisibility(View.INVISIBLE);
                }else if(checked == 2131231050){
                    Log.i("안내", "강아지 선택");
                    iv2.setVisibility(View.VISIBLE);
                    iv1.setVisibility(View.INVISIBLE);
                }
            }
        });
    }
}
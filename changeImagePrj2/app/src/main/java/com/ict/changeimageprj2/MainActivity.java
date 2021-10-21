package com.ict.changeimageprj2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Switch sw;
    TextView tv;
    RadioGroup rg;
    RadioButton cat, dog1, dog2;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sw = (Switch) findViewById(R.id.sw);
        tv = (TextView) findViewById(R.id.view2);
        rg = (RadioGroup) findViewById(R.id.rg);
        cat = (RadioButton) findViewById(R.id.rb1);
        dog1 = (RadioButton) findViewById(R.id.rb2);
        dog2 = (RadioButton) findViewById(R.id.rb3);
        iv = (ImageView) findViewById(R.id.iv);

        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.i("status", isChecked+"");
                if(isChecked){
                    tv.setVisibility(View.VISIBLE);
                    rg.setVisibility(View.VISIBLE);
                    iv.setVisibility(View.VISIBLE);
                }else{
                    tv.setVisibility(View.INVISIBLE);
                    rg.setVisibility(View.INVISIBLE);
                    iv.setVisibility(View.INVISIBLE);
                    rg.clearCheck();
                    iv.setImageResource(0);
                }
            }
        });
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.i("choose",checkedId+"");
                int id = checkedId;
                if(id == 2131231046){
                    iv.setImageResource(R.drawable.file1);
                }else if(id == 2131231047){
                    iv.setImageResource(R.drawable.file2);
                }else if (id == 2131231048){
                    iv.setImageResource(R.drawable.file3);
                }
            }
        });
    }
}
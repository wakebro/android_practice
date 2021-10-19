package com.ict.widgetprj2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv1;
    Button btn1;
    Boolean bl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = (TextView) findViewById(R.id.textView1);
        btn1 = (Button) findViewById(R.id.btn1);
        bl = false;
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bl == false) {
                    tv1.setTextSize(50);
                    tv1.setTextColor(Color.BLUE);
                    tv1.setTypeface(Typeface.SERIF);
                    tv1.setText("DAMOYO조_형기상");
                    bl = true;
                    System.out.println(bl);
                } else if(bl == true){
                    tv1.setText("형기상");
                    tv1.setTextColor(Color.BLACK);
                    tv1.setTextSize(30);
                    bl = false;
                    System.out.println(bl);
                }
            }
        });
    }
}
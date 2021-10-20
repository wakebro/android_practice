package com.ict.calculatorprj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    EditText et, et2;
    Button btn_Plus, btn_Minus, btn_Multi, btn_Div, btn_Eq;
    int num, num2, result;
    String str_num, str_num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.tv);
        et = (EditText) findViewById(R.id.et);
        et2 = (EditText) findViewById(R.id.et2);
        btn_Plus = (Button) findViewById(R.id.btn_Plus);
        btn_Minus = (Button) findViewById(R.id.btn_Minus);
        btn_Multi = (Button) findViewById(R.id.btn_Multi);
        btn_Div = (Button) findViewById(R.id.btn_Div);


        result = 0;
        tv.setText(result+"");

        btn_Plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str_num = et.getText().toString();
                num = Integer.parseInt(str_num);
                str_num2 = et2.getText().toString();
                num2 = Integer.parseInt(str_num2);
                result = num + num2;
                et.setText("");
                et2.setText("");
                tv.setText(result+"");
            }
        });
        btn_Minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str_num = et.getText().toString();
                num = Integer.parseInt(str_num);
                str_num2 = et2.getText().toString();
                num2 = Integer.parseInt(str_num2);
                result = num - num2;
                et.setText("");
                et2.setText("");
                tv.setText(result+"");
            }
        });
        btn_Multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str_num = et.getText().toString();
                num = Integer.parseInt(str_num);
                str_num2 = et2.getText().toString();
                num2 = Integer.parseInt(str_num2);
                result = num * num2;
                et.setText("");
                et2.setText("");
                tv.setText(result+"");
            }
        });
        btn_Div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str_num = et.getText().toString();
                num = Integer.parseInt(str_num);
                str_num2 = et2.getText().toString();
                num2 = Integer.parseInt(str_num2);
                result = num / num2;
                et.setText("");
                et2.setText("");
                tv.setText(result+"");
            }
        });




    }
}
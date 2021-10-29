package com.ict.loginprj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText idEt, pwEt;
    Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idEt = (EditText) findViewById(R.id.idEt);
        pwEt = (EditText) findViewById(R.id.pwEt);
        loginBtn = (Button) findViewById(R.id.loginBtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = idEt.getText().toString();
                String pw = pwEt.getText().toString();

                List<String> idArray = new ArrayList<String>();
                idArray.add("android");
                idArray.add("java");
                idArray.add("Spring");

                Intent intent = null;
                if(idArray.contains(id) && pw.equals("android")){
                    intent = new Intent(getApplicationContext(), SuccessActivity.class);
                    intent.putExtra("id", id);
                    startActivity(intent);
                } else {
                    intent = new Intent(getApplicationContext(), FailActivity.class);
                    startActivity(intent);
                }

            }
        });
    }
}
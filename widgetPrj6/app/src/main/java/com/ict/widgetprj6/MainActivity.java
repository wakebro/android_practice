package com.ict.widgetprj6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {
    Button start, stop, reset;
    Chronometer cm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        start = (Button) findViewById(R.id.cm_start);
        stop = (Button) findViewById(R.id.cm_stop);
        reset = (Button) findViewById(R.id.cm_reset);
        cm = (Chronometer) findViewById(R.id.cm);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cm.start();
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cm.stop();
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cm.stop();
                cm.setBase(SystemClock.elapsedRealtime());
            }
        });


    }
}
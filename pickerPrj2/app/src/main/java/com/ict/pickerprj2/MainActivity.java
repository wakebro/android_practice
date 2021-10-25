package com.ict.pickerprj2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    DatePicker dPicker;
    TimePicker tPicker;
    Button checkinBtn, checkoutBtn;
    TextView checkin, checkout;
    int thisyear, month, day, hour, minute, second;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dPicker = (DatePicker) findViewById(R.id.dPicker);
        tPicker = (TimePicker) findViewById(R.id.tPicker);
        checkinBtn = (Button) findViewById(R.id.checkinBtn);
        checkoutBtn = (Button) findViewById(R.id.checkoutBtn);
        checkin = (TextView) findViewById(R.id.checkin);
        checkout = (TextView) findViewById(R.id.checkout);



        checkinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thisyear = dPicker.getYear();
                month = dPicker.getMonth() + 1;
                day = dPicker.getDayOfMonth();
                hour = tPicker.getHour() + 9;
                minute = tPicker.getMinute();
                checkin.setText(thisyear + "년" + month + "월" + day + "일 " + hour + "시" + minute + "분");

                checkinBtn.setVisibility(View.INVISIBLE);
                checkoutBtn.setVisibility(View.VISIBLE);
            }
        });
        checkoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thisyear = dPicker.getYear();
                month = dPicker.getMonth() + 1;
                day = dPicker.getDayOfMonth();
                hour = tPicker.getHour() + 9;
                minute = tPicker.getMinute();
                checkout.setText(thisyear + "년" + month + "월" + day + "일 " + hour + "시" + minute + "분");

                checkoutBtn.setVisibility(View.INVISIBLE);
                checkinBtn.setVisibility(View.VISIBLE);
            }
        });
    }
}
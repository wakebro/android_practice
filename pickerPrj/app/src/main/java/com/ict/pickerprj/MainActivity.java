package com.ict.pickerprj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    DatePicker dPicker;
    Button checkinBtn, checkoutBtn;
    TextView checkin, checkout;

    // 전역변수에 날짜 관련 정보 저장
    Integer yearInt, month, day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dPicker = (DatePicker) findViewById(R.id.dPicker);
        checkinBtn = (Button) findViewById(R.id.checkinBtn);
        checkoutBtn = (Button) findViewById(R.id.checkoutBtn);
        checkin = (TextView) findViewById(R.id.checkin);
        checkout = (TextView) findViewById(R.id.checkout);

        // 창부품이 연결되면, 먼저 1차적으로 날짜 정보를 가져온다.
        yearInt = dPicker.getYear();
        month = dPicker.getMonth() + 1;
        day = dPicker.getDayOfMonth();

        // 날짜 처리는 DatePicker에 날짜가 변할 때마다 변수에 담는 것으로 처리
        // 창이 열리자마자 갖오게 할 때는 dPicker.getYear(), .getMonthOfYear()등을 활용
        dPicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                //Log.d("Date", year+"년"+(monthOfYear+1)+"월"+dayOfMonth+"일");
                yearInt = year;
                month = monthOfYear + 1;
                day = dayOfMonth;
            }
        });

        checkinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkin.setText(yearInt + "/" + month + "/" + day);
            }
        });

        checkoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkout.setText(yearInt + "/" + month + "/" + day);
            }
        });

    }
}
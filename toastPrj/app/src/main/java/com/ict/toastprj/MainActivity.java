package com.ict.toastprj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button toastBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toastBtn = (Button) findViewById(R.id.toastBtn);

        // onClick 연결
        toastBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 토스트 옵션을 걸려면 바로 화면에 .show()를 사용하지 않는다
                Toast toast = Toast.makeText(getApplicationContext(), "토스트 옵션걸기", Toast.LENGTH_SHORT);
                Display display = ((WindowManager) getSystemService(WINDOW_SERVICE)).getDefaultDisplay();

                // 나온 좌표값
                int xOffset = (int) (Math.random() * display.getWidth());
                int yOffset = (int) (Math.random() * display.getHeight());

                // 위에서 랜덤하게 얻어온 좌표값을 토스트에 적용
                toast.setGravity(Gravity.TOP | Gravity.LEFT, xOffset, yOffset);
                // toast에 옵션을 모두 입력한 뒤 .show()로 화면 출력
                toast.show();
            }
        });
    }
}
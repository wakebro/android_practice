package com.ict.widgetprj10;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

// ActionBar

// androidx.fragment.app.Fragment를 상속
public class CustomTabFragment extends androidx.fragment.app.Fragment{
    // 탭 이름을 감지해 어떤 탭을 보여주어야 하는지 확인을 위한 변수
    String tabName;
    
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        
        // 탭 이름 감지 관련 코드 세팅
        Bundle data = getArguments();
        tabName = data.getString("tabName");
        
    }
    
    // 화면이 변경될 때마다 처리할 로직 작성
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);

        LinearLayout baseLayout = new LinearLayout(super.getActivity());
        baseLayout.setOrientation(LinearLayout.VERTICAL);
        baseLayout.setLayoutParams(params);

        ImageView img = new ImageView(super.getActivity());
        if(tabName == "한식") {
            baseLayout.setBackgroundColor(Color.RED);
            img.setImageResource(R.drawable.file1);
        }
        if(tabName == "중식"){
            baseLayout.setBackgroundColor(Color.BLUE);
            img.setImageResource(R.drawable.file2);
        }
        if(tabName == "일식") {
            baseLayout.setBackgroundColor(Color.YELLOW);
            img.setImageResource(R.drawable.file3);
        }
        baseLayout.addView(img);
        /*
        // 만약 그림을 넣고 싶다면
        // 위젯 생성
        ImageView img = new ImageView(super.getActivity());
        // 위젯에 필요한 경로 등을 지정해준 다음
        img.setImageResource(R.drawable.ic_launcher_background);
        // baseLayout의 내부 위젯으로 .addView()를 통해 등록한다.
        baseLayout.addView(img);
        위 음식쪽에서 응용
        */
        return baseLayout;
    }
}

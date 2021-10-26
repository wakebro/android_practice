package com.ict.widgetprj10;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

        if(tabName == "한식") baseLayout.setBackgroundColor(Color.RED);
        if(tabName == "중식") baseLayout.setBackgroundColor(Color.BLUE);
        if(tabName == "일식") baseLayout.setBackgroundColor(Color.YELLOW);

        return baseLayout;
    }
}

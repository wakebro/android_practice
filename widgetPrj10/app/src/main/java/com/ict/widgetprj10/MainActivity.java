package com.ict.widgetprj10;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

// ActionBar

// 액션바는 JAVA 코드로만 구현하기 때문에 activity_main.xml파일이 필요 없다.
// MainActivity에서는 탭만 구현하고
// CustomTabFragment 클래스를 만들어 거기서 탭별 화면을 구현한다.
// MainActivity는 AppCompatActivity를 상속과 ActionBar를 구현한다.
public class MainActivity extends AppCompatActivity implements ActionBar.TabListener {

    // 탭 갯수만큼 변수 선언(3개)
    ActionBar.Tab tabKorean, tabChinese, tabJapanese;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // activity_main을 사용 안하므로 삭제
        ActionBar bar = getSupportActionBar();
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        tabKorean = bar.newTab();
        tabKorean.setText("한식");
        tabKorean.setTabListener(this);
        bar.addTab(tabKorean);

        tabChinese = bar.newTab();
        tabChinese.setText("중식");
        tabChinese.setTabListener(this);
        bar.addTab(tabChinese);

        tabJapanese = bar.newTab();
        tabJapanese.setText("일식");
        tabJapanese.setTabListener(this);
        bar.addTab(tabJapanese);

    }

    // 탭이 선택될 때 마다 바뀌는 내용을 처리해야 하므로
    // onTabSelected를 재정의
    // CustomFragment 3개를 선언
    CustomTabFragment customFrags[] = new CustomTabFragment[3];

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        // 아까 만든 커스텀 프래그먼트를 먼저 선언
        CustomTabFragment cFrag = null;

        // 탭 선택이 된 적이 없다면, 새로 탭을 생성
        if(customFrags[tab.getPosition()] == null){
            cFrag = new CustomTabFragment();
            Bundle data = new Bundle();
            data.putString("tabName", tab.getText().toString());
            cFrag.setArguments(data);
            customFrags[tab.getPosition()] = cFrag;
        } else {
            // 선택 된 적이 있다면 선택된 탭으로 교체
            cFrag = customFrags[tab.getPosition()];
        }
        // 화면 교체
        ft.replace(android.R.id.content, cFrag);

    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}
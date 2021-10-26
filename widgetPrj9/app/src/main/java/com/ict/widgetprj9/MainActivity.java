package com.ict.widgetprj9;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;

// 안적어도 작동하지만 탭호스트는 업데이트가 중지된 위젯이라
// 경고가 콘솔에 뜰 수 있어서 아래 어노테이션으로 방지
@SuppressWarnings("deprecation")
// 탭호스트 페이지는 상속도 TabActivitiy를 받는다.
public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 탭호스트 변수에 XML에서 생성한 탭호스트를 가져온다
        // xml파일에 설정한 TabHost의 id가 tabhost인 경우
        // 알아서 가져와짐
        TabHost tabHost = getTabHost();

        // 위쪽 탭 메뉴에 들어갈 메뉴명을 적어준다.
        // newTabSpec에는 탭의 호출명칭, setIndicator에는 화면에 보여줄 명칭을 적는다.
        TabHost.TabSpec tsk = tabHost.newTabSpec("t1").setIndicator("한식");
        // 1번탭은 한식
        tsk.setContent(R.id.t1);
        // 탭호스트에 위에서 추가한 메뉴바 하나를 추가
        tabHost.addTab(tsk);

        TabHost.TabSpec tsk2 = tabHost.newTabSpec("t2").setIndicator("중식");
        tsk.setContent(R.id.t2);
        tabHost.addTab(tsk2);

        TabHost.TabSpec tsk3 = tabHost.newTabSpec("t3").setIndicator("일식");
        tsk.setContent(R.id.t3);
        tabHost.addTab(tsk3);
    }
}
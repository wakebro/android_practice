package com.ict.movieprj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ict.movieprj.retrofit.MovieAdapter;
import com.ict.movieprj.retrofit.RetrofitClient;
import com.ict.movieprj.retrofit.RetrofitInterface;
import com.ict.movieprj.vo.BoxOfficeResult;
import com.ict.movieprj.vo.DailyBoxOffice;
import com.ict.movieprj.vo.Example;


import javax.xml.transform.Result;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    // 비동기 요청을 담당하는 Retrofit 관련 변수를 선언
    private RetrofitClient retrofitClient;
    private RetrofitInterface retrofitInterface;

    // 비동기 요청 이벤트를 발동시킬 버튼 선언
//    Button asyncBtn;
    // 리사이클러뷰 부품 선언
    RecyclerView recyclerView;
    // 리사이클러 어댑터 부품 선언
    RecyclerView.Adapter mAdapter;

    // 상수로 본인 key값을 저장
    final String KEY = "a363ad9009c67c7fa54b6387aec5fa39";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        asyncBtn = (Button) findViewById(R.id.asyncBtn);


        // 레트로핏 요소 연결
        retrofitClient = RetrofitClient.getInstance();
        retrofitInterface = RetrofitClient.getRetrofitInterface();

// 버튼 클릭시 비동기 요청
/*        // 버튼 클릭시 비동기 요청 넣기
        asyncBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retrofitInterface.getBoxOffice(KEY, "20110101")
                // 요청에 따른 성공/실패 시나리오별 코드 작성
                .enqueue(new Callback<Example>() {
                    @Override
                    public void onResponse(Call<Example> call, Response<Example> response) {
                        Example result = response.body();

                        for (DailyBoxOffice r: result.getBoxOfficeResult().getDailyBoxOfficeList()) {
                            Log.d("title", r.getMovieNm());
                        }
                    }

                    @Override
                    public void onFailure(Call<Example> call, Throwable t) {
                        Log.d("fail_check", "fail");
                    }
                });

            }
        });*/

        // 리사이클러뷰 요소를 먼저 연결
        recyclerView = (RecyclerView) findViewById(R.id.recycleView);
        // 리사이클러뷰는 레이아웃 설정을 자바쪽에서 받아야 표현된다.
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        // 화면이 켜졌을 때 비동기 요청으로 데이터를 받아오고,
        // 받아온 데이터를 리사이클러뷰 내부에 세팅하도록 처리
        retrofitInterface.getBoxOffice(KEY, "20211010").enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                // 비동기 요청 성공 시 처리할 내용
                // 비동기 데이터 저장
                Example result = response.body();
                // result 내부의 영화정보를 얻어서 MovieAdapter 생성자에 전달
                mAdapter = new MovieAdapter(result.getBoxOfficeResult().getDailyBoxOfficeList());
                // 리사이클러뷰에 MovieAdapter를 전단해서 카드뷰 양식으로 반복하도록 처리
                recyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                // 비동기 요청 실패 시 처리할 내용
                Log.d("요청실패", "요청에 실패했습니다.");
            }
        });
    }
}
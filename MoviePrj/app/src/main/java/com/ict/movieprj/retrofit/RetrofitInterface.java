package com.ict.movieprj.retrofit;

import com.ict.movieprj.vo.DailyBoxOffice;
import com.ict.movieprj.vo.Example;

import java.util.List;

import javax.xml.transform.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

// 레트로핏 인터페이스에는 비동기 호출에 대해
// 가변파라미터, 고정주소, 호출형식 등을 정의
public interface RetrofitInterface {

    // 영진위 API 서버는 조회권한만 가지고 있으므로
    // @GET("고정주소") 형식으로 메서드 위에 붙여준다.
    @GET("http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?")
    // 요청에 대한 응답은 Call<Result>를 리턴해주는 Getter를 이용한다.
    // 가변파라미터(현 사이트에서는 key, targetDt)는 @Query("파라미터명") 자료 변수형으로 설정한다.
    Call<Example> getBoxOffice(@Query("key")String key, @Query("targetDt")String targetDt);
}

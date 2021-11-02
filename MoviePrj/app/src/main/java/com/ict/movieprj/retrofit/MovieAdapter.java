package com.ict.movieprj.retrofit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ict.movieprj.R;
import com.ict.movieprj.vo.DailyBoxOffice;

import java.util.List;

// 리사이클러뷰의 어댑터 관련 내용을 정의하는 클래스
// RecyclerView 클래스 내부의 Adapter를 상송하여 만듦
public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    // 반복해서 뷰로 깔아줄 요소를 선언
    List<DailyBoxOffice> items;

    // 생성자에 뷰로 깔아줄 요소를 입력해야만 실행되도록 파라미터 처리
    public MovieAdapter(List<DailyBoxOffice> items){
        this.items = items;
    }

    // Override Method를 활용해 onCreateViewHolder를 선언
    // 이 메서드는 layout폴더 내에 있는 리사이클러 뷰의 본체로 활용될
    // 현 프로젝터의 card.xml을 불러온다.
    @NonNull
    @Override
    public MovieAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card, parent, false);

        return new ViewHolder(itemView);
    }

    // 위에서 불러온 card.xml 내부의 카드 한 장 한 장에 DailyBoxOffice에 해당하는
    // 영화 정보를 하나하나 붙여줘야 한다.
    // onBindViewHolder를 오버라이드 한다.
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // holder에 각각 하나하나의 영화 정보를 바인딩
        DailyBoxOffice item = items.get(position);
        holder.setItem(item);
    }

    // 출력할 영화 개수 체크
    public int getItemCount(){
        return items.size();
    }

    // 클래스의 내부에 ViewHolder 클래스 선언을 하는데 card.xml 내부 TextView 3개에 대한 설정을 할 수 있도록 처리
    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvRank, tvTitle, tvMDate;

        // 생성자에서 card.xml 내부 부품들 연결하기
        public ViewHolder(View itemView){
            super(itemView);
            tvRank = itemView.findViewById(R.id.tvRank);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvMDate = itemView.findViewById(R.id.tvMDate);
        }
        // 연결된 아이템 요소들 텍스트 세팅하기
        public void setItem(DailyBoxOffice item){
            tvRank.setText(item.getRank() + "위");
            tvTitle.setText("영화 제목 : " + item.getMovieNm());
            tvMDate.setText("개봉일 : " + item.getOpenDt());
        }
    }
}
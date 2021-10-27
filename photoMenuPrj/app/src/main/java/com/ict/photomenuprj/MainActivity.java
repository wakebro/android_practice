package com.ict.photomenuprj;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = (ImageView) findViewById(R.id.img);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0,1,0,"사진1");
        menu.add(0,2,0,"사진2");
        menu.add(0,3,0,"사진3");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == 1) img.setImageResource(R.drawable.file1);
        else if(item.getItemId() == 2) img.setImageResource(R.drawable.file2);
        else if(item.getItemId() == 3) img.setImageResource(R.drawable.file3);
        return super.onOptionsItemSelected(item);
    }
}
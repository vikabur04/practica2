package com.example.practica;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import ru.tinkoff.scrollingpagerindicator.ScrollingPagerIndicator;

public class OnBoardActivity extends AppCompatActivity {
    ViewPager OnBoarListElement;

    TextView next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_board);

        OnBoarListElement = findViewById(R.id.viewPager);
        next = findViewById(R.id.btnSkip);
        ScrollingPagerIndicator indicator = findViewById(R.id.indicator);

        onBoardOneFragment fragment1 = new onBoardOneFragment().newInstance(R.drawable.fragmentimage1);
        onBoardTwoFragment fragment2 = new onBoardTwoFragment().newInstance(R.drawable.fragmentimage2);
        onBoardThreeFragment fragment3 = new onBoardThreeFragment().newInstance(R.drawable.fragmentimage3);

        List<Fragment> onBoardList = new ArrayList<>();
        onBoardList.add(fragment1);
        onBoardList.add(fragment2);
        onBoardList.add(fragment3);


        onBoardAdapter adapter = new onBoardAdapter(getSupportFragmentManager(), onBoardList);
        OnBoarListElement.setAdapter(adapter);
        indicator.attachToPager(OnBoarListElement);
        OnBoarListElement.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (OnBoarListElement.getCurrentItem() == 2) {
                    next.setText("Завершить");
                } else {
                    next.setText("Пропустить");
                }
            }

            @Override
            public void onPageSelected(int position) {
                if (position == 2) {
                    next.setText("Завершить");
                } else {
                    next.setText("Пропустить");
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if (OnBoarListElement.getCurrentItem() == 2) {
                    next.setText("Завершить");
                } else {
                    next.setText("Пропустить");
                }
            }
        });
        next.setOnClickListener(v -> {
            nextBtn(OnBoarListElement.getCurrentItem());
        });

    }
    public void nextBtn(int position){
        if (position==2){
            Intent launc=new Intent(OnBoardActivity.this, LauncherActivity.class);
            startActivity(launc);
            finish();
        }
        OnBoarListElement.beginFakeDrag();
        OnBoarListElement.fakeDragBy(-800f);
        OnBoarListElement.endFakeDrag();
    }
}



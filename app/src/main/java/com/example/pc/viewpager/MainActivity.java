package com.example.pc.viewpager;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView page_1,page_2,page_3;
    private ViewPager vpPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        PAdapter pAdapter = new PAdapter(getSupportFragmentManager());
        vpPager.setAdapter(pAdapter);

        vpPager.setCurrentItem(1);
        page_2.setTextColor(Color.RED);

        vpPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                switch (vpPager.getCurrentItem()){
                    case 0:
                        page_1.setTextColor(Color.RED);
                        page_2.setTextColor(Color.WHITE);
                        page_3.setTextColor(Color.WHITE);
                        break;
                    case 1:
                        page_2.setTextColor(Color.RED);
                        page_1.setTextColor(Color.WHITE);
                        page_3.setTextColor(Color.WHITE);
                        break;
                    case 2:
                        page_3.setTextColor(Color.RED);
                        page_1.setTextColor(Color.WHITE);
                        page_2.setTextColor(Color.WHITE);
                        break;
                }
            }
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

    }

    public void PageSelected(View view) {
        switch (view.getId()) {
            case R.id.page_1:
                vpPager.setCurrentItem(0);
                break;
            case R.id.page_2:
                vpPager.setCurrentItem(1);
                break;
            case R.id.page_3:
                vpPager.setCurrentItem(2);
                break;
        }
    }

    private void initView() {
        vpPager = findViewById(R.id.view_pager);
        page_1 = findViewById(R.id.page_1);
        page_2 = findViewById(R.id.page_2);
        page_3 = findViewById(R.id.page_3);
    }
}

package com.hly.fragment.viewpager;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.hly.fragment.R;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerActivity extends AppCompatActivity implements View.OnClickListener {
    private List<Fragment> list;
    private ViewPager myViewPager;
    private FraPagerAdapter adapter;

    private TextView hp_text;
    private TextView film_text;
    private TextView me_text;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpager_activity_layout);
        initView();
    }


    private void initView() {
        hp_text = findViewById(R.id.hp_text);
        hp_text.setOnClickListener(this);
        film_text = findViewById(R.id.film_text);
        film_text.setOnClickListener(this);

        me_text = findViewById(R.id.me_text);
        me_text.setOnClickListener(this);

        myViewPager = findViewById(R.id.myViewPager);
        //绑定点击事件
        myViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        hp_text.setTextColor(Color.RED);
                        film_text.setTextColor(Color.BLACK);
                        me_text.setTextColor(Color.BLACK);
                        break;
                    case 1:
                        hp_text.setTextColor(Color.BLACK);
                        film_text.setTextColor(Color.RED);
                        me_text.setTextColor(Color.BLACK);
                        break;
                    case 2:
                        me_text.setTextColor(Color.RED);
                        film_text.setTextColor(Color.BLACK);
                        film_text.setTextColor(Color.BLACK);


                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        // 把Fragment添加到List集合里面
        list = new ArrayList<>();
        list.add(new HpFragment());
        list.add(new FilmFragment());
        list.add(new MeFragment());
        adapter = new FraPagerAdapter(getSupportFragmentManager(),
                FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, list);
        myViewPager.setAdapter(adapter);
        myViewPager.setCurrentItem(0);  // 初始化显示第一个页面


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.hp_text:
                myViewPager.setCurrentItem(0);
                break;
            case R.id.film_text:
                myViewPager.setCurrentItem(1);
                break;
            case R.id.me_text:
                myViewPager.setCurrentItem(2);
        }
    }
}

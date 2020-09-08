package com.hly.fragment;

import com.hly.fragment.viewpager.FilmFragment;
import com.hly.fragment.viewpager.HpFragment;
import com.hly.fragment.viewpager.MeFragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class ObjectActivity extends AppCompatActivity implements View.OnClickListener{

    private HpFragment hpFragment;
    private FilmFragment filmFragment;
    private MeFragment meFragment;
    private TextView hpText;
    private TextView filmText;
    private TextView meText;
    // 注意fragment 的生命周期变化 重新走了
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_activity_layout);
        hpText = findViewById(R.id.hp_text);
        hpText.setOnClickListener(this);
        filmText = findViewById(R.id.film_text);
        filmText.setOnClickListener(this);
        meText = findViewById(R.id.me_text);
        meText.setOnClickListener(this);
        initTab(0);

    }

    private void initTab(int i) {
        //开启事务，fragment的控制是由事务来实现的
        androidx.fragment.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        hideFragments(transaction);
        clearSelection();
        switch (i) {
            case 0:
                hpText.setTextColor(Color.RED);
                if (hpFragment == null) {
                    hpFragment = new HpFragment();
                    transaction.add(R.id.content, hpFragment);
                } else {
                    transaction.attach(hpFragment);
                }
                break;
            case 1:
                filmText.setTextColor(Color.RED);
                if (filmFragment == null) {
                    filmFragment = new FilmFragment();
                    transaction.add(R.id.content, filmFragment);
                } else {
                    transaction.attach(filmFragment);
                }
                break;
            case 2:
                meText.setTextColor(Color.RED);
                if (meFragment == null) {
                    meFragment = new MeFragment();
                    transaction.add(R.id.content, meFragment);
                } else {
                    transaction.attach(meFragment);
                }
                break;
        }
        transaction.commitAllowingStateLoss();

    }

    private void clearSelection() {
        hpText.setTextColor(Color.BLACK);
        filmText.setTextColor(Color.BLACK);
        meText.setTextColor(Color.BLACK);
    }

    private void hideFragments(FragmentTransaction transaction) {
        if (filmFragment != null) {
            transaction.detach(filmFragment);
        }
        if (hpFragment != null) {
            transaction.detach(hpFragment);
        }

        if (meFragment != null) {
            transaction.detach(meFragment);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.hp_text:
                initTab(0);
                break;
            case R.id.film_text:
                initTab(1);
                break;
            case R.id.me_text:
                initTab(2);
                break;

        }
    }

}

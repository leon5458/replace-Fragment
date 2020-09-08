package com.hly.fragment;

import java.util.List;

import com.hly.fragment.viewpager.BaseFragment;
import com.hly.fragment.viewpager.FilmFragment;
import com.hly.fragment.viewpager.HpFragment;
import com.hly.fragment.viewpager.MeFragment;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class OtherActivity extends AppCompatActivity implements View.OnClickListener {
    private HpFragment hpFragment;
    private FilmFragment filmFragment;
    private MeFragment meFragment;
    private TextView hpText;
    private TextView filmText;
    private TextView meText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_activity_layout);

        hpText = findViewById(R.id.hp_text);
        hpText.setOnClickListener(this);
        filmText = findViewById(R.id.film_text);
        filmText.setOnClickListener(this);
        meText = findViewById(R.id.me_text);
        meText.setOnClickListener(this);
        addFragment();
        // 指定默认显示第一个界面，可修改
        onClick(hpText);

    }

    private void addFragment() {
        //开启事务，fragment的控制是由事务来实现的
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if (hpFragment == null) {
            hpFragment = new HpFragment();
            transaction.add(R.id.content, hpFragment);
        }

        if (filmFragment == null) {
            filmFragment = new FilmFragment();
            transaction.add(R.id.content, filmFragment);
        }

        if (meFragment == null) {
            meFragment = new MeFragment();
            transaction.add(R.id.content, meFragment);
        }
        transaction.commitNow();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.hp_text:
                clearSelection();
                hpText.setTextColor(Color.RED);
                showFragment(hpFragment);
                break;
            case R.id.film_text:
                clearSelection();
                filmText.setTextColor(Color.RED);
                showFragment(filmFragment);
                break;
            case R.id.me_text:
                clearSelection();
                meText.setTextColor(Color.RED);
                showFragment(meFragment);
                break;
        }
    }

    private void showFragment(BaseFragment baseFragment) {
        hideAllFragment();
        if (baseFragment != null && baseFragment.isAdded()) {
            getSupportFragmentManager().beginTransaction().show(baseFragment).commitNow();
        }
    }

    protected void hideAllFragment() {
        List<Fragment> allFragment = getSupportFragmentManager().getFragments();
        if (allFragment.size() > 0) {
            for (Fragment fragment : allFragment) {
                if (fragment.isAdded()) {
                    getSupportFragmentManager().beginTransaction().hide(fragment).commitNow();
                }
            }
        }
    }

    private void clearSelection() {
        hpText.setTextColor(Color.BLACK);
        filmText.setTextColor(Color.BLACK);
        meText.setTextColor(Color.BLACK);
    }
}

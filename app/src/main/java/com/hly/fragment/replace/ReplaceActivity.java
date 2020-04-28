package com.hly.fragment.replace;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.hly.fragment.R;
import com.hly.fragment.viewpager.FilmFragment;
import com.hly.fragment.viewpager.HpFragment;

public class ReplaceActivity extends AppCompatActivity implements View.OnClickListener {
    private HpFragment hpFragment;
    private FilmFragment filmFragment;
    private TextView hpText;
    private TextView filmText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.replace_activity_layout);
        hpText = findViewById(R.id.hp_text);
        hpText.setOnClickListener(this);
        filmText = findViewById(R.id.film_text);
        filmText.setOnClickListener(this);
        initTab(0);
    }

    private void initTab(int i) {
        //开启事务，fragment的控制是由事务来实现的
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        clearSelection();
        switch (i) {
            case 0:
                hpText.setTextColor(Color.RED);
                if (hpFragment == null) {
                    hpFragment = new HpFragment();
                }
                transaction.replace(R.id.content, hpFragment);

                break;
            case 1:
                filmText.setTextColor(Color.RED);
                if (filmFragment == null) {
                    filmFragment = new FilmFragment();
                }
                transaction.replace(R.id.content, filmFragment);
                break;
        }
        transaction.commitAllowingStateLoss();

    }

    private void clearSelection() {
        hpText.setTextColor(Color.BLACK);
        filmText.setTextColor(Color.BLACK);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.hp_text:
                initTab(0);
                hpText.setTextColor(Color.RED);
                filmText.setTextColor(Color.BLACK);
                break;
            case R.id.film_text:
                initTab(1);
                hpText.setTextColor(Color.BLACK);
                filmText.setTextColor(Color.RED);
                break;

        }
    }
}

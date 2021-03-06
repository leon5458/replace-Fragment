package com.hly.fragment.showandhide;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.hly.fragment.R;
import com.hly.fragment.viewpager.FilmFragment;
import com.hly.fragment.viewpager.HpFragment;
import com.hly.fragment.viewpager.MeFragment;

public class ShowActvity extends AppCompatActivity implements View.OnClickListener,
        MeFragment.testDataCallback {
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
        initTab(0);

    }

    private void initTab(int i) {
        //开启事务，fragment的控制是由事务来实现的
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        hideFragments(transaction);
        clearSelection();
        switch (i) {
            case 0:
                hpText.setTextColor(Color.RED);
                if (hpFragment == null) {
                    hpFragment = new HpFragment();
                    hpFragment.setonIntentDataCallback(intentDataCallback);
                    transaction.add(R.id.content, hpFragment);
                } else {
                    transaction.show(hpFragment);
                }
                break;
            case 1:
                filmText.setTextColor(Color.RED);
                if (filmFragment == null) {
                    filmFragment = new FilmFragment();
                    transaction.add(R.id.content, filmFragment);
                } else {
                    transaction.show(filmFragment);
                }
                break;
            case 2:
                meText.setTextColor(Color.RED);
                if (meFragment == null) {
                    meFragment = new MeFragment();
                    transaction.add(R.id.content, meFragment);
                } else {
                    transaction.show(meFragment);
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
            transaction.hide(filmFragment);
        }
        if (hpFragment != null) {
            transaction.hide(hpFragment);
        }

        if (meFragment != null) {
            transaction.hide(meFragment);
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

    private onIntentDataCallback intentDataCallback = new onIntentDataCallback() {
        @Override
        public void onIntentData() {
            Log.e("********", "要传递的数据");
            Toast.makeText(ShowActvity.this, "这个Toast代表一个方法吧", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public void testData() {
        Log.e("********", "要传递的数据");
        Toast.makeText(ShowActvity.this, "这个Toast代表一个方法吧", Toast.LENGTH_SHORT).show();
    }

    public interface onIntentDataCallback {
        void onIntentData();
    }
}

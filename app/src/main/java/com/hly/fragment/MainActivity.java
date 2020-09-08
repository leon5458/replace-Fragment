package com.hly.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.hly.fragment.replace.ReplaceActivity;
import com.hly.fragment.showandhide.ShowActvity;
import com.hly.fragment.viewpager.ViewPagerActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //                SharedPreferences mPreferences =
                //                        PreferenceManager.getDefaultSharedPreferences
                //                        (MainActivity.this);
                //                SharedPreferences.Editor editor = mPreferences.edit();
                //                editor.putBoolean("Main", true);
                //                editor.apply();
                //
                //                SharedPreferences mPreferences1 =
                //                        PreferenceManager.getDefaultSharedPreferences
                //                        (MainActivity.this);
                //                Boolean misStopButtonClick = mPreferences1.getBoolean("Main",
                //                false);
                //
                //                if (misStopButtonClick){
                //                    Toast.makeText(MainActivity.this, "1111111111", Toast
                //                    .LENGTH_SHORT).show();
                //                }
                //                Log.e("----------hly", String.valueOf(misStopButtonClick));

                startActivity(new Intent(MainActivity.this, ViewPagerActivity
                        .class));
            }
        });

        findViewById(R.id.show).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ShowActvity.class));
            }
        });

        findViewById(R.id.replace).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ReplaceActivity.class));
            }
        });

        findViewById(R.id.other).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, OtherActivity.class));
            }
        });

        findViewById(R.id.otherOne).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ObjectActivity.class));
            }
        });

        findViewById(R.id.otherTwo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SingleActivity.class));
            }
        });

    }

}

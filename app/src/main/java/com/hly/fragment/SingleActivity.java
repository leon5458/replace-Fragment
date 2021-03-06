package com.hly.fragment;

import com.hly.fragment.viewpager.SingleFragment;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class SingleActivity extends AppCompatActivity {

    private SingleFragment singleFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_activity_layout);

        if (singleFragment == null) {
            singleFragment = new SingleFragment();
        }

        // 获取fragmentmanger
        FragmentManager fragmentManager = getSupportFragmentManager();

        // 开启事务
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // 替换成fragment
        fragmentTransaction.replace(R.id.frame, singleFragment);

        // 提交
        fragmentTransaction.commitNow();

        // 直接使用链表的形式
        //        getSupportFragmentManager().beginTransaction().add(R.id.frame, singleFragment)
        //        .commitNow();



    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (singleFragment != null) {
            singleFragment.onDestroy();
        }
    }
}

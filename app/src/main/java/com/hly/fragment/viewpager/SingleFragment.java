package com.hly.fragment.viewpager;

import com.hly.fragment.MainActivity;
import com.hly.fragment.R;
import com.hly.fragment.SingleActivity;

import android.os.Bundle;

public class SingleFragment extends BaseFragment {
    @Override
    protected int setLayoutResourceID() {
        return R.layout.single_fragment_layout;
    }

    public static SingleFragment newInstance(SingleActivity activity) {
        SingleFragment fragment = new SingleFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected void setUpView() {

    }
}

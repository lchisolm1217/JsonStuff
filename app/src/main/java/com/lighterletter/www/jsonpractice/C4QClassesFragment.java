package com.lighterletter.www.jsonpractice;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by john on 12/9/17.
 */

public class C4QClassesFragment extends Fragment {

    private static final String TAG = C4QClassesFragment.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.c4q_class_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String jsonString = getArguments().getString("jsonString");
        Log.d(TAG, "onViewCreated: " + jsonString);
    }
}

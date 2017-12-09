package com.lighterletter.www.jsonpractice;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lighterletter.www.jsonpractice.model.Fellow;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Fragment to display Fellows
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
        String jsonString = getArguments().getString(Constants.JSON_BUNDLE_KEY);
        Log.d(TAG, "onViewCreated: " + jsonString);

        List<Fellow> fellowList = JsonHelper.getFellowsFromJSON(jsonString);

        Log.d(TAG, "onViewCreated: fellows: " + fellowList.size());
        RecyclerView c4qRv = (RecyclerView) view.findViewById(R.id.c4q_class_rv);
        c4qRv.setLayoutManager(new LinearLayoutManager(view.getContext()));
        c4qRv.setAdapter(new FellowAdapter(fellowList));
    }

}

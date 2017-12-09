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
        String jsonString = getArguments().getString(Constants.JSON_BUNDLE_KEY);
        Log.d(TAG, "onViewCreated: " + jsonString);

        List<Fellow> fellowList = getFellowsFromJSON(jsonString);

        Log.d(TAG, "onViewCreated: fellows: " + fellowList.size());
        RecyclerView c4qRv = (RecyclerView) view.findViewById(R.id.c4q_class_rv);
        c4qRv.setLayoutManager(new LinearLayoutManager(view.getContext()));
        c4qRv.setAdapter(new FellowAdapter(fellowList));


    }

    private List<Fellow> getFellowsFromJSON(String jsonString) {
        List<Fellow> fellowList = new ArrayList<>();
        try {

            JSONObject jsonObject = new JSONObject(jsonString);
            JSONArray list = jsonObject.getJSONArray("fellows");

            for (int i = 0; i < list.length(); i++) {
                Fellow fellow = new Fellow();

                JSONObject obj = (JSONObject) list.get(i);

                fellow.setName(obj.getString("name"));
                fellow.setCohort(obj.getString("cohort"));
                fellowList.add(fellow);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return fellowList;
    }
}

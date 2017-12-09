package com.lighterletter.www.jsonpractice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * This is a documment
 */

public class MainActivity extends AppCompatActivity {

    private String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.create_json_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String classJson = buildClassJson();

                C4QClassesFragment fragment = new C4QClassesFragment();
                Bundle jsonBundle = new Bundle();
                jsonBundle.putString(Constants.JSON_BUNDLE_KEY, classJson);
                fragment.setArguments(jsonBundle);

                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, fragment)
                        .commit();
            }
        });
    }

    private String buildClassJson() {
        JSONObject c4q = new JSONObject();
        try {
            c4q.put("fellows",
                    new JSONArray()
                            .put(new JSONObject()
                                    .put("name", "mike")
                                    .put("cohort", "android")
                            )
                            .put(new JSONObject()
                                    .put("name", "lisa")
                                    .put("cohort", "android")
                            )
                            .put(new JSONObject()
                                    .put("name", "shawn")
                                    .put("cohort", "ios")
                            )
                            .put(new JSONObject()
                                    .put("name", "stacy")
                                    .put("cohort", "ios")
                            )
                            .put(new JSONObject()
                                    .put("name", "luke")
                                    .put("cohort", "web")
                            )
                            .put(new JSONObject()
                                    .put("name", "ana")
                                    .put("cohort", "web")
                            )
            );

        } catch (JSONException e) {
            e.printStackTrace();
        }

        Log.d(TAG, "onClick: " + c4q.toString());
        return c4q.toString();
    }
}

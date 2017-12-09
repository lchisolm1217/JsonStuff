package com.lighterletter.www.jsonpractice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private String TAG = MainActivity.class.getSimpleName();
    private String builtJson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.create_json_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buildClassJson();
            }
        });
    }

    private void buildClassJson() {
        JSONObject c4q = new JSONObject();
        try {

            c4q.put("android_class",
                    new JSONArray()
                            .put(new JSONObject().put("name", "mike"))
                            .put(new JSONObject().put("name", "lisa"))
            );

            c4q.put(
                    "ios_class",
                    new JSONArray()
                            .put(new JSONObject().put("name", "shawn"))
                            .put(new JSONObject().put("name", "stacy"))
            );

            c4q.put(
                    "web_class",
                    new JSONArray()
                            .put(new JSONObject().put("name", "luke"))
                            .put(new JSONObject().put("name", "ana"))
            );

            ((TextView) findViewById(R.id.text_view)).setText(c4q.toString());

            Log.d(TAG, "onClick: " + c4q.toString());

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}

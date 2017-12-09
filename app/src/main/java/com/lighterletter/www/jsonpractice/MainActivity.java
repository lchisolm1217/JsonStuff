package com.lighterletter.www.jsonpractice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


/**
 * Main class takes us to fragment.
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
                String classJson = JsonHelper.getSampleJSON();

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


}

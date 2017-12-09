package com.lighterletter.www.jsonpractice;

import android.util.Log;

import com.lighterletter.www.jsonpractice.model.Fellow;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Helper class that helps with creating and parsing JsonObjects
 */

class JsonHelper {
    private final static String TAG = JsonHelper.class.getSimpleName();

    /**
     * a sample of what we build can be found in the assets folder under: fellow_sample.json
     *
     * @return data in JSON format
     */
    static String getSampleJSON() {
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


    /**
     * Method parses JSON string to return a list of Fellow objects
     *
     * @param jsonString json input
     * @return a list of fellow objects
     */
    static List<Fellow> getFellowsFromJSON(String jsonString) {
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

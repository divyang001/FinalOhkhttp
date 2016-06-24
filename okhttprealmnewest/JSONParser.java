package com.example.hunter.okhttp;

import android.support.annotation.NonNull;
import android.util.Log;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by hunter on 4/6/16.
 */


    public class JSONParser {
        /********
         * URLS
         *******/
        private static final String MAIN_URL = "http://dev.fittect.com/api/centers/";
        /**
         * TAGs Defined Here...
         */
        public static final String TAG = "TAG";
        /**
         * Key to Send
         */
        private static final String KEY_USER_ID = "user_id";
        /**
         * Response
         */
        private static Response response;
        /**
         * Get Table Booking Charge
         *
         * @return JSON Object
         */
        public static JSONObject getDataFromWeb() {
            try {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url(MAIN_URL)
                        .build();
                response = client.newCall(request).execute();
                return new JSONObject(response.body().string());
            } catch (@NonNull IOException | JSONException e) {
                Log.e(TAG, "" + e.getLocalizedMessage());
            }
            return null;
        }
    }


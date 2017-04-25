package org.fossasia.fossasiaorgaandroidapp.Api;

import android.app.DownloadManager;
import android.app.VoiceInteractor;
import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rishabhkhanna on 25/04/17.
 */

public class ApiCall {

    public static final String TAG = "ApiCall";

    public static void callApi(Context context, String url){

        RequestQueue  queue = Volley.newRequestQueue(context);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d(TAG, "onResponse: " + response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("Accept", "application/json");
                params.put("Authorization" ,"JWT eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpYXQiOjE0OTMxNTE0NTMsImlkZW50aXR5IjozNDksImV4cCI6MTQ5MzIzNzg1MywibmJmIjoxNDkzMTUxNDUzfQ.qOao-2SwX3_BKGeHB0uC9L-MPpE7HhECZ-54D72pk3w");
                return params;
            }
        };

        queue.add(stringRequest);

    }
}

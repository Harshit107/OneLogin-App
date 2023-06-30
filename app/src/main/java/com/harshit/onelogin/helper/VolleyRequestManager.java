package com.harshit.onelogin.helper;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class VolleyRequestManager {
    private static VolleyRequestManager instance;
    private RequestQueue requestQueue;

    private VolleyRequestManager() {
        // Private constructor to prevent instantiation outside the class
    }

    public static synchronized VolleyRequestManager getInstance(Context context) {
        if (instance == null) {
            instance = new VolleyRequestManager();
            instance.requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return instance;
    }

    public void makeJsonRequest(String url, JSONObject jsonBody, final VolleyCallback callback) {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, jsonBody,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        callback.onSuccess(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        callback.onError(error);
                    }
                });

        requestQueue.add(jsonObjectRequest);
    }

    public interface VolleyCallback {
        void onSuccess(JSONObject response);
        void onError(VolleyError error);
    }
}

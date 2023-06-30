package com.harshit.onelogin.helper;

import android.content.Context;
import android.content.SharedPreferences;

public class LocalStorageManager {
    private static final String PREF_NAME = "TokenStorage";

    public static void setStringValue(Context context,String key, String value) {
        SharedPreferences preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static String getStringValue(Context context,String key) {
        SharedPreferences preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return preferences.getString(key, null);
    }
}

package com.tys.cachepreference;

import android.app.Activity;
import android.content.SharedPreferences;
import androidx.preference.PreferenceManager;

public class MyCachePref {
    public static void savePrefsString(String key, String value, Activity activity){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(activity);
        SharedPreferences.Editor edit = sp.edit();
        edit.putString(key, value);
        edit.apply();
    }
    public static String loadPrefsString(String key, Activity activity){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(activity);
        //String returnVar = sp.getString(key, null);
        return sp.getString(key, null);
    }

    public static void removePrefs(String key, Activity activity) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(activity).edit();
        editor.remove(key);
        editor.apply();
    }

    public static void removeAllPrefs(Activity activity) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(activity);
        SharedPreferences.Editor editor = prefs.edit();
        editor.clear();
        editor.apply();
    }
}

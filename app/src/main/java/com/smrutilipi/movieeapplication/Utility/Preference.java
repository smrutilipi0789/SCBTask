package com.smrutilipi.movieeapplication.Utility;


import android.app.Activity;
import android.content.*;

public class Preference {
     SharedPreferences sharedPreferences;

    public Preference(Activity activity) {
        sharedPreferences = activity.getPreferences(activity.MODE_PRIVATE);
    }

    public void setPreferences(String search){
        sharedPreferences.edit().putString("search",search).apply();
    }

    public String getPreferences(){
        return sharedPreferences.getString("search","superman");
    }
}

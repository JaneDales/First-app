package com.example.firstapp.helpers;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesHelper {

    private static SharedPreferences preferences;

    private SharedPreferencesHelper(){}

    public static SharedPreferences getInstance(Activity activity) {
        if (preferences == null)
            preferences = activity.getSharedPreferences("ppp", Context.MODE_PRIVATE);
        return preferences;
    }

}

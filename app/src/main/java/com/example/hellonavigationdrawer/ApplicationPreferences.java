package com.example.hellonavigationdrawer;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class ApplicationPreferences {

    static final String KEY = "LOGIN";


    private  static SharedPreferences mSharedPref;

    private ApplicationPreferences() {}

    public static void init(Context context) {
        if(mSharedPref == null) {
            mSharedPref = context.getSharedPreferences(KEY, Activity.MODE_PRIVATE);
        }
    }

    public static void saveLogin(LoginModel value) {

        SharedPreferences.Editor prefsEditor = mSharedPref.edit();
        Gson gson = new Gson();
        String json = gson.toJson(value);
        prefsEditor.putString(KEY, json);
        prefsEditor.apply();
    }

    public static LoginModel readLogin(String defValue) {

        Gson gson = new Gson();
        String json = mSharedPref.getString(KEY, null);
        Type type = new TypeToken<LoginModel>(){}.getType();
        return gson.fromJson(json, type);

    }
}

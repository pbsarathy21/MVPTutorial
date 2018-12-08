package com.example.bobby.mvptutorial.Utilities;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class MySharedPref
{

    private static SharedPreferences sharedPreferences;
    public static final String NAME = "NAME";
    public static final String AGE = "AGE";
    public static final String IS_SELECT = "IS_SELECT";

    public MySharedPref() { }

    public static void init(Context context)
    {
        if (sharedPreferences == null)
            sharedPreferences = context.getSharedPreferences(context.getPackageName(), Activity.MODE_PRIVATE);
    }

    public static String read(String key, String defValue)
    {
        return sharedPreferences.getString(key, defValue);
    }

    public static void write(String key, String value)
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static boolean read(String key, boolean defValue)
    {
        return sharedPreferences.getBoolean(key, defValue);
    }

    public static void write(String key, boolean value)
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public static Integer read(String key, int defValue)
    {
        return sharedPreferences.getInt(key, defValue);
    }

    public static void write(String key, int value)
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }
}

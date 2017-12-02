package mchehab.com.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by muhammadchehab on 12/2/17.
 */

public class SharedPreferencesHelper {

    private static final String SHARED_PREFERENCES_NAME = "name";

    private static SharedPreferences getSharedPreferences(Context context){
        return context.getSharedPreferences("name", Context.MODE_PRIVATE);
    }

    public static void putBoolean(Context context, String key, boolean value){
        getSharedPreferences(context).edit().putBoolean(key, value).apply();
    }

    public static void putString(Context context, String key, String value){
        getSharedPreferences(context).edit().putString(key, value).apply();
    }

    public static void putInt(Context context, String key, int value){
        getSharedPreferences(context).edit().putInt(key, value).apply();
    }

    public static String getString(Context context, String key, String defaultValue){
        return getSharedPreferences(context).getString(key, defaultValue);
    }

    public static int getInt(Context context, String key, int defaultValue){
        return getSharedPreferences(context).getInt(key, defaultValue);
    }

    public static boolean getBoolean(Context context, String key, boolean defaultValue){
        return getSharedPreferences(context).getBoolean(key, defaultValue);
    }
}
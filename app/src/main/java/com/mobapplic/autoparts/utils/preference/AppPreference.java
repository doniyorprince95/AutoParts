package com.mobapplic.autoparts.utils.preference;


import android.content.Context;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.text.TextUtils;

public class AppPreference {

    private static final String KEY_TOKEN = "key_token";
    public static final String KEY_USER = "key_user";
    public static final String KEY_PASS = "key_pass";

    private static void saveStringPref(Context context, String key, String value) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString(key, value).apply();
    }

    private static String loadStringPref(Context context, String key, @Nullable String defaultValue) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(key, defaultValue);
    }

    public static void setToken(Context context, String token) {
        saveStringPref(context, KEY_TOKEN, token);
    }

    public static String getKeyToken(Context context) {
        return loadStringPref(context, KEY_TOKEN, null);
    }

    public static boolean isAuthorized(Context context) {
        return !TextUtils.isEmpty(getKeyToken(context));
    }

    public static void setKeyUser(Context context, String userName) {
        saveStringPref(context, KEY_USER, userName);
    }

    public static String getKeyUser(Context context) {
        return loadStringPref(context, KEY_USER, null);
    }

    public static void setKeyPass(Context context, String password) {
        saveStringPref(context, KEY_PASS, password);
    }

    public static String getKeyPass(Context context) {
        return loadStringPref(context, KEY_PASS, null);
    }
}

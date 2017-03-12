package com.mobapplic.autoparts.utils.preference;


import android.content.Context;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.mobapplic.autoparts.App;
import com.mobapplic.autoparts.model.entity.user.User;

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

    public static void setUserInfo(User u) {
        setKeyUser(App.getContext(), u.getUserName());
        setKeyPass(App.getContext(), u.getPassword());
    }

    private static void removePref(Context context, String key) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().remove(key).apply();
    }

    public static void removeAppData() {
        removePref(App.getContext(), KEY_USER);
        removePref(App.getContext(), KEY_PASS);
    }
}

package ru.suleymanovtat.secondtask;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesHelper {

    private static final String SHARED_PREF_NAME = "SHARED_PREF_NAME";
    private static final String RADIO_BUTTON_INDEX_KEY = "RADIO_BUTTON_INDEX_KEY";
    private SharedPreferences mSharedPreferences;

    public SharedPreferencesHelper(Context context) {
        mSharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
    }

    public int getRadioButtonIndex() {
        return mSharedPreferences.getInt(RADIO_BUTTON_INDEX_KEY, 0);
    }

    public void saveRadioButtonIndex(int searchEngine) {
        mSharedPreferences.edit().putInt(RADIO_BUTTON_INDEX_KEY, searchEngine).apply();
    }
}

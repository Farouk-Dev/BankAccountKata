package com.example.faroukjabberi.bankaccountkata.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.example.faroukjabberi.bankaccountkata.R;

/**
 * The type Shared preference manager.
 */
public class SharedPreferenceManager {

  private static SharedPreferenceManager instance;
  private SharedPreferences mSettings;
  private SharedPreferences.Editor mEditor;



  private SharedPreferenceManager(Context mContext, String prefFileName) {
    mSettings = mContext.getSharedPreferences(prefFileName, Context.MODE_PRIVATE);
    mEditor = mSettings.edit();
  }

  /**
   * Gets instance.
   *
   * @param mContext the m context
   * @return the instance
   */
  public static SharedPreferenceManager getInstance(Context mContext) {

    if (instance == null) instance = new SharedPreferenceManager(mContext, mContext.getString(R.string.app_name));
    return instance;
  }

  /***
   * Set a value for the key
   *
   * @param key   the key
   * @param value the value
   */
  public void setValue(String key, int value) {
    mEditor.putInt(key, value);
    mEditor.commit();
  }

  /**
   * Gets int value.
   *
   * @param key the key
   * @param defaultValue the default value
   * @return the int value
   */
  public int getIntValue(String key, int defaultValue) {
    return mSettings.getInt(key, defaultValue);
  }




}

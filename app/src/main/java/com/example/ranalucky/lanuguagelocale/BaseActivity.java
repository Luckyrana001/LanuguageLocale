package com.example.ranalucky.lanuguagelocale;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;


import java.util.Locale;

/**
 * Created by Rana lucky on 8/14/2016.
 */
public class BaseActivity extends AppCompatActivity {
    public static final String  MY_PREFS_NAME = "langPrefrence";

    private Locale mCurrentLocale;

    /*@Override
    protected void onStart() {
        super.onStart();

        mCurrentLocale = getResources().getConfiguration().locale;
        setLocale();

    }*/

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        // refresh your views here
        super.onConfigurationChanged(newConfig);
        setLocale();

    }

    public void setLocale() {

        final Resources resources = getResources();
        final Configuration configuration = resources.getConfiguration();
        final Locale locale = getLocale(this);
        if (!configuration.locale.equals(locale)) {
            configuration.setLocale(locale);
            resources.updateConfiguration(configuration, null);
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Locale locale = getLocale(this);

        if (!locale.equals(mCurrentLocale)) {

            mCurrentLocale = locale;
            recreate();
        }
    }

    public Locale getLocale(Context context) {


        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        String lang = prefs.getString("language", "English");

        switch (lang) {
            case "English":
                lang = "en";
                break;
            case "Arabic":
                lang = "ar";
                break;
        }
        return new Locale(lang);
    }
    protected String getLang()
    {
        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        String lang = prefs.getString("language", "English");
        return lang;
    }
}

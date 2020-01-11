package com.example.weatherforecast.activities;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.weatherforecast.R;


@SuppressLint("Registered")
public class BaseActivity extends AppCompatActivity {
    protected int theme;
    protected boolean darkTheme;
    protected boolean blackTheme;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        setTheme(theme = com.example.weatherforecast.utils.UI.getTheme(prefs.getString("theme", "fresh")));
        darkTheme = theme == R.style.AppTheme_NoActionBar_Dark ||
                theme == R.style.AppTheme_NoActionBar_Classic_Dark;
        blackTheme = theme == R.style.AppTheme_NoActionBar_Black ||
                theme == R.style.AppTheme_NoActionBar_Classic_Black;

        com.example.weatherforecast.utils.UI.setNavigationBarMode(BaseActivity.this, darkTheme, blackTheme);
    }
}

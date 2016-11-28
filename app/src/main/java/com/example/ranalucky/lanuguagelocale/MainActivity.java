package com.example.ranalucky.lanuguagelocale;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends BaseActivity {
    Button arabicBtn, englishButton;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textView = (TextView) findViewById(R.id.textView);
        textView.setText(getResources().getString(R.string.sample_string));

        arabicBtn = (Button) findViewById(R.id.arabicBtn);
        arabicBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                updateAppLanguage("Arabic");
                /*
                refresh / reload the activity content to see changes
              */
                recreate();

            }

        });


        englishButton = (Button) findViewById(R.id.englishButton);
        englishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                updateAppLanguage("English");

/*
                refresh / reload the activity content to see changes
*/
                recreate();

            }
        });


        setLocale();
    }

    private void updateAppLanguage(String lang) {
        SharedPreferences.Editor editor = getSharedPreferences(BaseActivity.MY_PREFS_NAME, MODE_PRIVATE).edit();
        editor.putString("language", lang);
        editor.commit();
    }
}

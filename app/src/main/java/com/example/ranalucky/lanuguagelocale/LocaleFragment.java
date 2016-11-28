package com.example.ranalucky.lanuguagelocale;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Rana lucky on 11/28/2016.
 */

public class LocaleFragment  extends Fragment {
    Button arabicBtn, englishButton;
    TextView textView;

        public static LocaleFragment ecHomeFragment;

        public LocaleFragment() {
            // Required empty public constructor
        }


        private View rootView;


        public static LocaleFragment newInstance() {
            LocaleFragment fragment = new LocaleFragment();
            return fragment;
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            if (getArguments() != null) {
            }
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            // Inflate the layout for this fragment
            ecHomeFragment = this;
            if (rootView == null) {

                rootView = inflater.inflate(R.layout.locale_fragment, container, false);
                textView = (TextView)rootView. findViewById(R.id.textView);
                textView.setText(getResources().getString(R.string.sample_string));

                arabicBtn = (Button)rootView. findViewById(R.id.arabicBtn);
                arabicBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        updateAppLanguage("Arabic");

               // refresh / reload the activity content to see changes
                        recreateActivity();

                    }

                });


                englishButton = (Button)rootView. findViewById(R.id.englishButton);
                englishButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        updateAppLanguage("English");

               // refresh / reload the activity content to see changes
                        recreateActivity();
                    }
                });



            }










            /*back button clicked*/
           // View v = inflater.inflate(R.layout.xyz, container, false);
             //Back pressed Logic for fragment
            rootView.setFocusableInTouchMode(true);
            rootView.requestFocus();
            rootView.setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    if (event.getAction() == KeyEvent.ACTION_DOWN) {
                        if (keyCode == KeyEvent.KEYCODE_BACK) {
                            getActivity().finish();

                            return true;
                        }
                    }
                    return false;
                }
            });
            return rootView;
        }

    private void recreateActivity() {

        Intent intent = new Intent(getActivity(),MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }


    private void updateAppLanguage(String lang) {
        SharedPreferences.Editor editor = getActivity().getSharedPreferences(BaseActivity.MY_PREFS_NAME, getActivity().MODE_PRIVATE).edit();
        editor.putString("language", lang);
        editor.commit();
        }
}

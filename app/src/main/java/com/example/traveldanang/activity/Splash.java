package com.example.traveldanang.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.example.traveldanang.R;

public class Splash extends AppCompatActivity {
        /** Duration of wait **/
        private final int SPLASH_DISPLAY_LENGTH = 2000;
        RelativeLayout hinhnen;
        ProgressBar pgsBar;

        @Override
        public void onCreate(Bundle icicle) {
            super.onCreate(icicle);
            setContentView(R.layout.activity_splash2);
            hinhnen = (RelativeLayout)findViewById(R.id.hinhnen);
            hinhnen.setBackgroundResource(R.drawable.hinhnen);

            ProgressBar pgsBar = (ProgressBar)findViewById(R.id.pBar);
            new Handler().postDelayed(new Runnable(){
                @Override
                public void run() {
                    Intent mainIntent = new Intent(Splash.this, MainActivity.class);
                    Splash.this.startActivity(mainIntent);
                    finish();
                }
            }, SPLASH_DISPLAY_LENGTH);
    }
}

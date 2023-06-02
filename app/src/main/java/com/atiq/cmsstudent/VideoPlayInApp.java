package com.atiq.cmsstudent;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebView;

public class VideoPlayInApp extends AppCompatActivity {
    WebView PlayVideoInApp;
    public  static String videoSongLink = "";
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player_in_app);

        PlayVideoInApp = findViewById(R.id.PlayVideoInApp);

        PlayVideoInApp.getSettings().setJavaScriptEnabled(true);
        PlayVideoInApp.loadUrl(videoSongLink);

    }
}
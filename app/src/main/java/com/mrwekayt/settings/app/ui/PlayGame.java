package com.mrwekayt.settings.app.ui;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.mrwekayt.settings.app.R;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class PlayGame extends AppCompatActivity {
    WebView webView;
    private boolean NativeadLoaded;

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_game);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(!NativeadLoaded){
                }
            }
        }, 3000);



        webView = findViewById(R.id.webView);
        webView.getSettings().setAllowContentAccess(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().supportZoom();
        webView.getSettings().setAllowFileAccess(true);
        webView.getSettings().setJavaScriptEnabled(true);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("game");

            loadGame(value);

        }

    }
    private void loadGame(String gameName){

        try {
            AssetManager assetManager = this.getAssets();
            InputStream stream = assetManager.open(gameName+".html");
            BufferedReader r = new BufferedReader(new InputStreamReader(stream));
            StringBuilder total = new StringBuilder();
            String line;
            while ((line = r.readLine()) != null) {
                total.append(line).append("\n");
            }
            webView.loadDataWithBaseURL(null, total.toString(), "text/html", "UTF-8", null);
        } catch (Exception xxx) {

        }


    }

}

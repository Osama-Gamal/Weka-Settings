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

import com.google.android.ads.nativetemplates.NativeTemplateStyle;
import com.google.android.ads.nativetemplates.TemplateView;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdOptions;
import com.mrwekayt.settings.app.R;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class PlayGame extends AppCompatActivity {
    WebView webView;
    AdView adView,adView2;
    private boolean NativeadLoaded;

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_game);



        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });



        AdLoader adLoader = new AdLoader.Builder(this, "ca-app-pub-9982104187674434/3742656505")
                .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                    private ColorDrawable background;
                    @Override
                    public void onNativeAdLoaded(NativeAd nativeAd) {
                        NativeTemplateStyle styles = new
                                NativeTemplateStyle.Builder().withMainBackgroundColor(background).build();
                        TemplateView template = findViewById(R.id.my_template);
                        template.setVisibility(View.VISIBLE);
                        template.setStyles(styles);
                        template.setNativeAd(nativeAd);
                        NativeadLoaded = true;
                    }
                })
                .build();

        adLoader.loadAd(new AdRequest.Builder().build());

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(!NativeadLoaded){
                }
            }
        }, 3000);


        adView = findViewById(R.id.adView);
        AdRequest request = new AdRequest.Builder().build();
        adView.loadAd(request);

        adView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
            }
            @Override
            public void onAdFailedToLoad(LoadAdError adError) {
            }
            @Override
            public void onAdOpened() {
            }
            @Override
            public void onAdClicked() {
            }
            @Override
            public void onAdClosed() {
            }
        });

        webView = findViewById(R.id.webView);
        webView.getSettings().setAllowContentAccess(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().supportZoom();
        webView.getSettings().setAllowFileAccess(true);
        webView.getSettings().setJavaScriptEnabled(true);



/*
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setSupportMultipleWindows(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.setHorizontalScrollBarEnabled(false);
        webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        webView.getSettings().setAllowFileAccessFromFileURLs(true);
        webView.getSettings().setAllowUniversalAccessFromFileURLs(true);
*/

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

package com.mrwekayt.settings.app.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.ads.nativetemplates.NativeTemplateStyle;
import com.google.android.ads.nativetemplates.TemplateView;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.mrwekayt.settings.app.DpiActivity;
import com.mrwekayt.settings.app.MobileSpecActivity;
import com.mrwekayt.settings.app.R;
import com.mrwekayt.settings.app.SensetiveActivity;

public class HaveDpiActivity extends AppCompatActivity {

    CardView dpiMobile,sensetiveSetting,pointerBtn;
    AdView adView;
    private InterstitialAd mInterstitialAd;
    private RewardedAd mRewardedAd;
    AdRequest adRequest;
    private boolean NativeadLoaded;

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.have_dpi);


        sensetiveSetting = findViewById(R.id.sensetiveBtn);
        dpiMobile = findViewById(R.id.dpiMobile);
        pointerBtn = findViewById(R.id.pointerBtn);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("dpi");
            if(value.equals("no")){
                pointerBtn.setVisibility(View.VISIBLE);
                dpiMobile.setVisibility(View.GONE);
            }else{
                pointerBtn.setVisibility(View.GONE);
                dpiMobile.setVisibility(View.VISIBLE);
            }

        }



        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        adView = (AdView)findViewById(R.id.adView);
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

        adRequest = new AdRequest.Builder().build();
        InterstitialAd.load(this, "ca-app-pub-9982104187674434/7242249592", adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        mInterstitialAd = interstitialAd;
                        Log.i("TAG", "onAdLoaded");
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        Log.i("TAG", loadAdError.getMessage());
                        mInterstitialAd = null;
                    }
                });

        AdLoader adLoader = new AdLoader.Builder(HaveDpiActivity.this, "ca-app-pub-9982104187674434/3742656505")
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




        pointerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HaveDpiActivity.this, PointerActivity.class);
                startActivity(intent);

                /*if (mInterstitialAd != null) {
                    mInterstitialAd.show(HaveDpiActivity.this);
                } else {
                    Log.d("TAG", "The interstitial ad wasn't ready yet.");
                }*/

            }
        });



        dpiMobile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(HaveDpiActivity.this,DpiActivity.class);
                startActivity(intent);

                /*if (mInterstitialAd != null) {
                    mInterstitialAd.show(HaveDpiActivity.this);
                } else {
                    Log.d("TAG", "The interstitial ad wasn't ready yet.");
                }*/
                /*
                final AlertDialog dialog2 = new AlertDialog.Builder(HaveDpiActivity.this).create();
                LayoutInflater inflater = getLayoutInflater();
                View convertView = (View) inflater.inflate(R.layout.loading_dialog, null);
                dialog2.setView(convertView);
                dialog2.setCancelable(false);
                dialog2.show();

                handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dialog2.cancel();



                    }
                }, 3000);*/

            }

        });

        sensetiveSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HaveDpiActivity.this, SensetiveActivity.class);
                startActivity(intent);

                /*if (mInterstitialAd != null) {
                    mInterstitialAd.show(HaveDpiActivity.this);
                } else {
                    Log.d("TAG", "The interstitial ad wasn't ready yet.");
                }*/

               /* final AlertDialog dialog2 = new AlertDialog.Builder(HaveDpiActivity.this).create();
                LayoutInflater inflater = getLayoutInflater();
                View convertView = (View) inflater.inflate(R.layout.loading_dialog, null);
                dialog2.setView(convertView);
                dialog2.setCancelable(false);
                dialog2.show();

                handler=new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dialog2.cancel();


                    }
                },3000);*/

            }
        });





        }

    /*@Override
    public void onBackPressed() {
        startAppAd.showAd();
        super.onBackPressed();
    }*/
}

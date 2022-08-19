package com.mrwekayt.settings.app.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.mrwekayt.settings.app.DpiActivity;
import com.mrwekayt.settings.app.MainActivity;
import com.mrwekayt.settings.app.MobileSpecActivity;
import com.mrwekayt.settings.app.R;


import java.io.File;

public class hudSettings extends AppCompatActivity {
    private int a = 0;
    Button twoFingers,threeFingers,fourFingers,fiveFingersBtn,fireBtn;


    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hud_activity);

        getSupportActionBar().setTitle("Custom Hud Settings");


        twoFingers = findViewById(R.id.twoFingersBtn);
        threeFingers = findViewById(R.id.threeFingersBtn);
        fourFingers = findViewById(R.id.fourFingersBtn);
        fiveFingersBtn = findViewById(R.id.fiveFingersBtn);

        fireBtn = findViewById(R.id.fireBtn);








        a = 0;

        twoFingers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(hudSettings.this, FingersActivity.class);
                intent.putExtra("finger","two");
                startActivity(intent);

                /*if (mInterstitialAd != null) {
                    mInterstitialAd.show(hudSettings.this);
                } else {
                    Log.d("TAG", "The interstitial ad wasn't ready yet.");
                }*/

            }
        });
        threeFingers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(hudSettings.this, FingersActivity.class);
                intent.putExtra("finger","three");
                startActivity(intent);

               /* if (mInterstitialAd != null) {
                    mInterstitialAd.show(hudSettings.this);
                } else {
                    Log.d("TAG", "The interstitial ad wasn't ready yet.");
                }*/

            }
        });
        fourFingers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(hudSettings.this, FingersActivity.class);
                intent.putExtra("finger","four");
                startActivity(intent);

               /* if (mInterstitialAd != null) {
                    mInterstitialAd.show(hudSettings.this);
                } else {
                    Log.d("TAG", "The interstitial ad wasn't ready yet.");
                }*/

            }
        });

        fiveFingersBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(hudSettings.this, FingersActivity.class);
                intent.putExtra("finger","five");
                startActivity(intent);
            }
        });

        fireBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(hudSettings.this, FireBtnActivity.class);
                startActivity(intent);


            }
        });








    }

    @Override
    protected void onResume() {
        super.onResume();



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.star:
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.youtube.com/c/MrWekaYt"));
                intent.setPackage("com.google.android.youtube");
                startActivity(intent);

            case R.id.share:

                ApplicationInfo app = getApplicationContext().getApplicationInfo();
                String filePath = app.sourceDir;
                Intent intentShare = new Intent(Intent.ACTION_SEND);
                intentShare.setType("*/*");
                intentShare.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new File(filePath)));
                startActivity(Intent.createChooser(intentShare, "Share app via"));

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}

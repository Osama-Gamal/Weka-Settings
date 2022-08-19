package com.mrwekayt.settings.app.ui;


import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

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
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.mrwekayt.settings.app.MainActivity;
import com.mrwekayt.settings.app.MobileSpecActivity;
import com.mrwekayt.settings.app.R;
import com.mrwekayt.settings.app.SliderAdapterExample;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ComputerEmulators extends AppCompatActivity {
    private int a = 0;
    private CardView pcBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.computer_emulators);

        getSupportActionBar().setTitle("Computer Settings");

        pcBtn = findViewById(R.id.pcBtn);

        a = 0;



        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });





       /* Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(!NativeadLoaded){
                    startAppMrec.setVisibility(View.VISIBLE);
                }
            }
        }, 3000);*/








        pcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ComputerEmulators.this, ComputerSettings.class);
                startActivity(intent);



            }
        });



      /*  StartApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //StartAppAd startAppAd = new StartAppAd(getApplicationContext());
                //startAppAd.showAd();


                /*BottomSheetDialog dialog = new BottomSheetDialog(MainOptions.this);
                LayoutInflater inflater = getLayoutInflater();
                View convertView = (View) inflater.inflate(R.layout.instruction_dialog, null);

                dialog.setContentView(convertView, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 1050));
                dialog.setCancelable(false);

                ProgressBar progressBar = convertView.findViewById(R.id.progressBar2);
                Handler handler = new Handler();

                MobileAds.initialize(getApplicationContext(), new OnInitializationCompleteListener() {
                    @Override
                    public void onInitializationComplete(InitializationStatus initializationStatus) {
                    }
                });

                AdLoader adLoader = new AdLoader.Builder(MainOptions.this, "ca-app-pub-9982104187674434/3742656505")
                        .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                            private ColorDrawable background;
                            @Override
                            public void onNativeAdLoaded(NativeAd nativeAd) {
                                NativeTemplateStyle styles = new
                                        NativeTemplateStyle.Builder().withMainBackgroundColor(background).build();
                                TemplateView template = convertView.findViewById(R.id.my_template);
                                template.setStyles(styles);
                                template.setNativeAd(nativeAd);
                            }
                        })
                        .build();
                adLoader.loadAd(new AdRequest.Builder().build());

                dialog.show();*/

               /* a = progressBar.getProgress();
                new Thread(new Runnable() {
                    public void run() {
                        while (a < 200) {
                            a += 1;
                            handler.post(new Runnable() {
                                public void run() {
                                    progressBar.setProgress(a);
                                    if (a == 200) {
                                        Intent intent = new Intent(MainOptions.this, MainActivity.class);
                                        startActivity(intent);
                                        dialog.dismiss();
                                        /*if (mInterstitialAd != null) {
                                            mInterstitialAd.show(MainOptions.this);
                                        } else {
                                            Log.d("TAG", "The interstitial ad wasn't ready yet.");
                                        }*/

                           /*             progressBar.setProgress(0);
                                    }
                                }
                            });
                            try {
                                Thread.sleep(50);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();
            }
        });*/





    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

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
                final String appPackageName = getPackageName();
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
                } catch (android.content.ActivityNotFoundException anfe) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
                }
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

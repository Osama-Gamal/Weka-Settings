package com.mrwekayt.settings.app.ui;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
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
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.ads.nativead.NativeAd;
import com.mrwekayt.settings.app.MobileSpecActivity;
import com.mrwekayt.settings.app.R;

import java.io.File;

public class FingersActivity extends AppCompatActivity {

    ImageView img1,img2,img3,img4,img5,img6;

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fingers_activity);

        getSupportActionBar().setTitle("Fingers Settings");


        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);
        img4 = findViewById(R.id.img4);
        img5 = findViewById(R.id.img5);
        img6 = findViewById(R.id.img6);

        img5.setVisibility(View.GONE);
        img6.setVisibility(View.GONE);


        TemplateView template1 = findViewById(R.id.my_template1);
        TemplateView template2 = findViewById(R.id.my_template2);
        TemplateView template3 = findViewById(R.id.my_template3);
        TemplateView template4 = findViewById(R.id.my_template4);
        TemplateView template5 = findViewById(R.id.my_template5);
        TemplateView template6 = findViewById(R.id.my_template6);



        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });





        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("finger");

            if(value.equals("two")){
                img1.setImageResource(R.drawable.two_fingers_plus);

                img2.setImageResource(R.drawable.two_fingers1);

                img3.setImageResource(R.drawable.two_fingers2);

                img4.setImageResource(R.drawable.two_fingers3);

                img5.setImageResource(R.drawable.two_fingers4);
                img5.setVisibility(View.VISIBLE);

                img6.setImageResource(R.drawable.two_fingers5);
                img6.setVisibility(View.VISIBLE);


            }else{
                if(value.equals("three")){
                    img1.setImageResource(R.drawable.three_fingers_plus);

                    img2.setImageResource(R.drawable.three_finger1);

                    img3.setImageResource(R.drawable.three_finger2);

                    img4.setImageResource(R.drawable.three_finger3);
                    img4.setVisibility(View.VISIBLE);

                    img5.setImageResource(R.drawable.three_finger4);
                    img5.setVisibility(View.VISIBLE);

                }else {
                    if (value.equals("four")) {
                        img1.setImageResource(R.drawable.fingers_four1);

                        img2.setImageResource(R.drawable.fingers_four2);
                        img2.setVisibility(View.VISIBLE);

                        img3.setVisibility(View.GONE);
                        img4.setVisibility(View.GONE);
                        img5.setVisibility(View.GONE);

                    }
                    else {
                        if (value.equals("five")) {
                            img1.setImageResource(R.drawable.five_finger1);
                            img2.setVisibility(View.GONE);
                            img3.setVisibility(View.GONE);
                            img4.setVisibility(View.GONE);
                            img5.setVisibility(View.GONE);

                        }
                    }
                }
            }

            if(value.equals("bluestacks")){
                getSupportActionBar().setTitle("Fingers Settings");
                img1.setImageResource(R.drawable.bluestacks_sett1);

                img2.setImageResource(R.drawable.bluestacks_sett2);

                img3.setImageResource(R.drawable.bluestacks_sett3);

                img4.setImageResource(R.drawable.bluestacks_sett4);

                img5.setImageResource(R.drawable.bluestacks_sett5);
                img5.setVisibility(View.VISIBLE);

                img6.setImageResource(R.drawable.bluestacks_sett6);
                img6.setVisibility(View.VISIBLE);

            }

        }




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

package com.mrwekayt.settings.app.ui;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import com.mrwekayt.settings.app.MainActivity;
import com.mrwekayt.settings.app.MobileSpecActivity;
import com.mrwekayt.settings.app.R;
import com.mrwekayt.settings.app.SliderAdapterExample;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainOptions extends AppCompatActivity {
    Button StartApp;
    private int a = 0;
    private CardView mobileBtn,pcBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);

        getSupportActionBar().setTitle("HeadShot Settings");


        StartApp = findViewById(R.id.StartApp);

        mobileBtn = findViewById(R.id.mobileBtn);
        pcBtn = findViewById(R.id.pcBtn);

        a = 0;





        mobileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), MobileSpecActivity.class);
                startActivity(intent);

                /*if (mInterstitialAd != null) {
                    mInterstitialAd.show(MainOptions.this);
                } else {
                    Log.d("TAG", "The interstitial ad wasn't ready yet.");
                    startAppAd.showAd();
                }*/

            }
        });

        pcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ComputerEmulators.class);
                startActivity(intent);
            }
        });

        StartApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //StartAppAd startAppAd = new StartAppAd(getApplicationContext());
                //startAppAd.showAd();
                Intent intent = new Intent(MainOptions.this, MainActivity.class);
                startActivity(intent);

            }
        });


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

    @Override
    protected void onResume() {
        super.onResume();

    }
}

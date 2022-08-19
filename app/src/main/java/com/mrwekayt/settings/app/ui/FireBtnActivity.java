package com.mrwekayt.settings.app.ui;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
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
import com.mrwekayt.settings.app.R;

import java.io.File;

public class FireBtnActivity extends AppCompatActivity {

    TextView button_text;
    AdView adView;
    Button acceptBtn;

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fire_size);

        button_text = findViewById(R.id.button_text);
        acceptBtn = findViewById(R.id.acceptBtn);

        getSupportActionBar().setTitle("Fire Button");



        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });




        /*Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(!NativeadLoaded){
                    startAppMrec.setVisibility(View.VISIBLE);
                }
            }
        }, 3000);*/

        acceptBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Point point = new Point();
        getWindowManager().getDefaultDisplay().getRealSize(point);
        DisplayMetrics dm = getResources().getDisplayMetrics();
        double x = Math.pow(point.x/ dm.xdpi, 2);
        double y = Math.pow(point.y / dm.ydpi, 2);
        double screenInches = Math.sqrt(x + y);

        //Toast.makeText(this,""+screenInches,Toast.LENGTH_LONG).show();

        if(screenInches<=5){
            button_text.setText("42");
        }else{
            if(screenInches>5 && screenInches<=6){
                button_text.setText("49");
            }else{
                if(screenInches>6 && screenInches<=7){
                    button_text.setText("52");
                }
                else{
                    if(screenInches>7 && screenInches<=8){
                        button_text.setText("59");
                    }
                    else{
                        if(screenInches>=8){
                            button_text.setText("63");
                        }
                    }
                }
            }
        }
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("device");
            if(value.equals("PC")){
                button_text.setText("10");
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

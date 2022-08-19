package com.mrwekayt.settings.app;

import android.app.ActivityManager;
import android.content.Context;
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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
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
import com.mrwekayt.settings.app.R;

import java.io.File;

public class GraphicSettings extends AppCompatActivity {

    Button Acceptbtn;
    RadioButton smoothBtn,standardBtn,ultraBtn,lowBtn,highBtn;
    ImageView imageView;
    public float Ram;

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.graphic_dialog);

        getSupportActionBar().setTitle("Graphic Settings");



        smoothBtn = findViewById(R.id.smoothBtn);
        standardBtn = findViewById(R.id.standardBtn);
        ultraBtn = findViewById(R.id.ultraBtn);
        lowBtn = findViewById(R.id.lowBtn);
        highBtn = findViewById(R.id.highBtn);

        imageView = findViewById(R.id.imageView);

        Acceptbtn = (Button)findViewById(R.id.acceptBtn);


        ActivityManager actManager = (ActivityManager) getApplicationContext().getSystemService(Context.ACTIVITY_SERVICE);
        ActivityManager.MemoryInfo memInfo = new ActivityManager.MemoryInfo();
        assert actManager != null;
        actManager.getMemoryInfo(memInfo);
        float totalMemory = Float.parseFloat(Float.toString(memInfo.totalMem).substring(0, 2));;

        //Toast.makeText(getApplicationContext(), ""+totalMemory, Toast.LENGTH_SHORT).show();


        if(totalMemory<=1.5) {
            smoothBtn.setChecked(true);
            lowBtn.setChecked(true);
            imageView.setImageResource(R.drawable.one_half_ram);
        }
        else{
            if(totalMemory>1.5 && totalMemory<=2) {
                standardBtn.setChecked(true);
                highBtn.setChecked(true);
                imageView.setImageResource(R.drawable.two_ram);
            }else{
                    if(totalMemory>2 && totalMemory<=3) {
                        standardBtn.setChecked(true);
                        highBtn.setChecked(true);
                        imageView.setImageResource(R.drawable.three_ram);
                    }else {
                        if (totalMemory > 3 && totalMemory<=4) {
                            ultraBtn.setChecked(true);
                            highBtn.setChecked(true);
                            imageView.setImageResource(R.drawable.four_ram);
                        }
                        else {
                            if (totalMemory > 4 && totalMemory<=5) {
                                ultraBtn.setChecked(true);
                                highBtn.setChecked(true);
                                imageView.setImageResource(R.drawable.five_ram);
                            }
                            else {
                                if (totalMemory > 5 && totalMemory<=6) {
                                    ultraBtn.setChecked(true);
                                    highBtn.setChecked(true);
                                    imageView.setImageResource(R.drawable.six_ram);
                                }
                                else {
                                    if (totalMemory > 6) {
                                        ultraBtn.setChecked(true);
                                        highBtn.setChecked(true);
                                        imageView.setImageResource(R.drawable.abive_sixram);
                                    }
                                }
                            }
                        }
                    }
            }
        }

        Acceptbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        /*if (mInterstitialAd != null) {
            mInterstitialAd.show(GraphicSettings.this);
        } else {
            Log.d("TAG", "The interstitial ad wasn't ready yet.");
        }*/

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

    private String floatForm(double d) {
        return String.format(java.util.Locale.US, "%.2f", d);
    }

    private String bytesToHuman(long size) {
        long Kb = 1024;
        long Mb = Kb * 1024;
        long Gb = Mb * 1024;
        long Tb = Gb * 1024;
        long Pb = Tb * 1024;
        long Eb = Pb * 1024;

        if (size < Kb) return floatForm(size) + " byte";
        if (size >= Kb && size < Mb) return floatForm((double) size / Kb) + " KB";Ram = size / Mb;
        if (size >= Mb && size < Gb) return floatForm((double) size / Mb) + " MB";Ram = size / Mb;
        if (size >= Gb && size < Tb) return floatForm((double) size / Gb) + " GB";Ram = size / Mb;
        if (size >= Tb && size < Pb) return floatForm((double) size / Tb) + " TB";Ram = size / Mb;
        if (size >= Pb && size < Eb) return floatForm((double) size / Pb) + " Pb";Ram = size / Mb;
        if (size >= Eb) return floatForm((double) size / Eb) + " Eb";

        return "0";
    }


}

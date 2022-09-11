package com.mrwekayt.settings.app.ui;


import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import com.mrwekayt.settings.app.R;
import java.io.File;

public class MoreAppsActivity extends AppCompatActivity implements View.OnClickListener {

    CardView touchSpeedBtn,sensetiveToolBtn,dpiToolBtn,customHudBtn,fixLagBtn,LeaksAppBtn;

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.more_apps);




        touchSpeedBtn = findViewById(R.id.touchSpeedBtn);
        touchSpeedBtn.setOnClickListener(this);
        sensetiveToolBtn = findViewById(R.id.sensetiveToolBtn);
        sensetiveToolBtn.setOnClickListener(this);
        dpiToolBtn = findViewById(R.id.dpiToolBtn);
        dpiToolBtn.setOnClickListener(this);
        customHudBtn = findViewById(R.id.customHudBtn);
        customHudBtn.setOnClickListener(this);
        fixLagBtn = findViewById(R.id.fixLagBtn);
        fixLagBtn.setOnClickListener(this);
        LeaksAppBtn = findViewById(R.id.LeaksAppBtn);
        LeaksAppBtn.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.touchSpeedBtn:
                openAppProfile("com.mrwekaytapp.touchspeed");
                break;
            case R.id.sensetiveToolBtn:
                openAppProfile("com.mrwekayt.sensitivitytool.app");
                break;
            case R.id.dpiToolBtn:
                openAppProfile("com.mrwekayt.dpitool.app");
                break;
            case R.id.customHudBtn:
                openAppProfile("com.mrwekayt.customhud.app");
                break;
            case R.id.fixLagBtn:
                openAppProfile("com.mrwekayt.fixlag.app");
                break;
            case R.id.LeaksAppBtn:
                openAppProfile("com.mrwekaytapp.leaks");
                break;
            default:
                break;
        }

    }

    public void openAppProfile(String appPackage){
        final String appPackageName = appPackage;
        try {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
        } catch (android.content.ActivityNotFoundException anfe) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
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

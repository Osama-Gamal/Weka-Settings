package com.mrwekayt.settings.app;

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
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.mrwekayt.settings.app.R;
import com.mrwekayt.settings.app.ui.HaveDpiActivity;

import java.io.File;

public class SensetiveActivity extends AppCompatActivity {

    TextView generalTxt,redDotTxt,scope2XTxt,scope4XTxt,awmTxt,freeLookTxt;
    ProgressBar generalProgress,redDotProgress,scope2XProgress,scope4XProgress,awmProgress,freeLookProgress;

    private ImageView imageView;


    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sensetive_dialog);







        generalTxt = findViewById(R.id.GeneralTxt);
        redDotTxt = findViewById(R.id.redDotTxt);
        scope2XTxt = findViewById(R.id.scope2XTxt);
        scope4XTxt = findViewById(R.id.scope4xTxt);
        awmTxt = findViewById(R.id.awmTxt);
        freeLookTxt = findViewById(R.id.freeLookTxt);

        imageView= findViewById(R.id.imageView);

       /* generalProgress = findViewById(R.id.GeneralProgress);
        redDotProgress = findViewById(R.id.redDotProgress);
        scope2XProgress = findViewById(R.id.scope2XProgress);
        scope4XProgress = findViewById(R.id.scope4xProgress);
        awmProgress = findViewById(R.id.awmProgress);
        freeLookProgress = findViewById(R.id.freeLookProgress);*/

/*
        generalTxt.setText(MobileSpecActivity.newSettings.getGeneral()+"");
        generalProgress.setProgress(MobileSpecActivity.newSettings.getGeneral());
        redDotTxt.setText(MobileSpecActivity.newSettings.getRedDot()+"");
        redDotProgress.setProgress(MobileSpecActivity.newSettings.getRedDot());
        scope2XTxt.setText(MobileSpecActivity.newSettings.getScope2x()+"");
        scope2XProgress.setProgress(MobileSpecActivity.newSettings.getScope2x());
        scope4XTxt.setText(MobileSpecActivity.newSettings.getScope4x()+"");
        scope4XProgress.setProgress(MobileSpecActivity.newSettings.getScope4x());
        awmTxt.setText(MobileSpecActivity.newSettings.getAWMScope()+"");
        awmProgress.setProgress(MobileSpecActivity.newSettings.getAWMScope());
        freeLookTxt.setText(MobileSpecActivity.newSettings.getFreeLook()+"");
        freeLookProgress.setProgress(MobileSpecActivity.newSettings.getFreeLook());*/

        String[] BrandCases = {"samsung","acer","alcatel","tecno","htc","lg","nokia","lenovo","sony","infinix","honor"
                ,"realme","oppo","poco","huawei","asus","xiaomi","giga","zte","hp","fifo","motorola","oneplus"};

        int i;
        for(i = 0; i < BrandCases.length; i++)
            if(MobileSpecActivity.newSettings.getMobileBrand().contains(BrandCases[i])) break;

        switch(i) {
            case 0:
                imageView.setImageResource(R.drawable.samsung);
                break;
            case 1:
                imageView.setImageResource(R.drawable.acer);
                break;
            case 2:
                imageView.setImageResource(R.drawable.alcatel);
                break;
            case 3:
                imageView.setImageResource(R.drawable.tecno);
                break;
            case 4:
                imageView.setImageResource(R.drawable.htc);
                break;
            case 5:
                imageView.setImageResource(R.drawable.lg);
                break;
            case 6:
                imageView.setImageResource(R.drawable.nokia);
                break;
            case 7:
                imageView.setImageResource(R.drawable.lenouvo);
                break;
            case 8:
                imageView.setImageResource(R.drawable.sony);
                break;
            case 9:
                imageView.setImageResource(R.drawable.infiinix);
                break;
            case 10:
                imageView.setImageResource(R.drawable.honor);
                break;
            case 11:
                imageView.setImageResource(R.drawable.relame);
                break;
            case 12:
                imageView.setImageResource(R.drawable.oppo);
                break;
            case 13:
                imageView.setImageResource(R.drawable.poco);
                break;
            case 14:
                imageView.setImageResource(R.drawable.haywaye);
                break;
            case 15:
                imageView.setImageResource(R.drawable.asus);
                break;
            case 16:
                imageView.setImageResource(R.drawable.xhoimai);
                break;
            case 17:
                imageView.setImageResource(R.drawable.giga);
                break;
            case 18:
                imageView.setImageResource(R.drawable.zte);
                break;
            case 19:
                imageView.setImageResource(R.drawable.hp);
                break;
            case 20:
                imageView.setImageResource(R.drawable.fifo);
                break;
            case 21:
                imageView.setImageResource(R.drawable.motorila);
                break;
            case 22:
                imageView.setImageResource(R.drawable.oneplus);
                break;
            default:
                imageView.setImageResource(R.drawable.else_brand);
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

    /*@Override
    protected void onDestroy() {
        super.onDestroy();

        startAppAd.showAd();

    }*/

}

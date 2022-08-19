package com.mrwekayt.settings.app.ui.home;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.google.android.ads.nativetemplates.NativeTemplateStyle;
import com.google.android.ads.nativetemplates.TemplateView;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.snackbar.Snackbar;
import com.mrwekayt.settings.app.DpiActivity;
import com.mrwekayt.settings.app.GraphicSettings;
import com.mrwekayt.settings.app.MainActivity;
import com.mrwekayt.settings.app.SplashScreen;
import com.mrwekayt.settings.app.ui.DiamondsActivity;
import com.mrwekayt.settings.app.ui.FingersActivity;
import com.mrwekayt.settings.app.ui.GamesActivity;
import com.mrwekayt.settings.app.ui.MainOptions;
import com.mrwekayt.settings.app.ui.MoreAppsActivity;

import com.mrwekayt.settings.app.MobileSpecActivity;
import com.mrwekayt.settings.app.R;
import com.mrwekayt.settings.app.ui.hudSettings;


public class HomeFragment extends Fragment {

    CardView helpCenterBtn,moreAppsBtn,headShotBtn,hudBtn,graphicBtn,ffCharacterBtn,youtubeBtn;

    AdView adView;
    CardView forMobile;

    private AlertDialog dialog2;
    Handler handler;




    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.main_options, container, false);




        MobileAds.initialize(getActivity(), new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });













        helpCenterBtn = view.findViewById(R.id.helpCenterBtn);
        moreAppsBtn = view.findViewById(R.id.moreAppsBtn);
        headShotBtn = view.findViewById(R.id.headShotBtn);
        hudBtn = view.findViewById(R.id.hudBtn);
        graphicBtn = view.findViewById(R.id.graphicBtn);
        ffCharacterBtn = view.findViewById(R.id.ffCharacterBtn);
        youtubeBtn = view.findViewById(R.id.youtubeBtn);





        helpCenterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Comming Soon",Toast.LENGTH_LONG).show();

            }
        });

        ffCharacterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Comming Soon",Toast.LENGTH_LONG).show();

            }
        });
        moreAppsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MoreAppsActivity.class);
                startActivity(intent);

            }
        });

        headShotBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MainOptions.class);
                startActivity(intent);



            }
        });

        hudBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), hudSettings.class);
                startActivity(intent);


            }
        });

        graphicBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent=new Intent(getContext(),GraphicSettings.class);
                startActivity(intent);


/*
                dialog2 = new AlertDialog.Builder(getContext()).create();
                LayoutInflater inflater = getLayoutInflater();
                View convertView = (View) inflater.inflate(R.layout.loading_dialog, null);
                dialog2.setView(convertView);
                dialog2.setCancelable(false);
                TextView dialogText = convertView.findViewById(R.id.dialog_text);
                dialogText.setText("Settings are loading please wait");
                dialog2.show();

                handler=new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {



                    }
                },3000);*/

            }
        });

        youtubeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.youtube.com/c/MrWekaYt"));
                intent.setPackage("com.google.android.youtube");
                startActivity(intent);
            }
        });


        return view;
    }


    @Override
    public void onResume() {
        super.onResume();

    }
}
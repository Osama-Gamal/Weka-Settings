package com.mrwekayt.settings.app;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.ads.nativetemplates.NativeTemplateStyle;
import com.google.android.ads.nativetemplates.TemplateView;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
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
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.mrwekayt.settings.app.ui.FireBtnActivity;
import com.mrwekayt.settings.app.ui.HaveDpiActivity;
import com.mrwekayt.settings.app.ui.HeadshotChoose;
import com.mrwekayt.settings.app.ui.PointerActivity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MobileSpecActivity extends AppCompatActivity {

    private String MobileModel;
    private String MobileBrand;
    private String MobileAndroid;
    private String MobileAPI;
    private String MobileHardware;
    private String MobileID;
    private String MobileDPI;
    private String MobileResolution;
    private String MobileRam;
    int rewardAmount = 0;

    TextView BrandTxt,ModelTxt,AndroidTxt,HardwareTxt,IdTxt,DpiTxt,ResolutionTxt,RamTxt;
    Button dpiMobile,sensetiveSetting,PointerBtn,moreSettings,headShotBtn,fireBtn;
    public List<MobileModel> MobileModels = new ArrayList<>();
    public MobileModel mobileModel;
    public static MobileModel newSettings;
    public static long Ram;
    Handler handler;
    private AlertDialog dialog2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main_home);

        getSupportActionBar().setTitle("Mobile Settings");


       /* mRewardedAd.show(this, new OnUserEarnedRewardListener() {
            @Override
            public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                // Handle the reward.
                Log.d("TAG", "The user earned the reward.");
                rewardAmount = 2;
                Toast.makeText(MobileSpecActivity.this,"Done",Toast.LENGTH_LONG).show();

            }
        });*/


        MobileModels = new ArrayList<>();
        fireBtn = findViewById(R.id.fireBtn);
        BrandTxt = findViewById(R.id.mobileBrand);
        ModelTxt = findViewById(R.id.mobileModel);
        AndroidTxt = findViewById(R.id.mobileAndroid);
        HardwareTxt = findViewById(R.id.mobileHardware);
        IdTxt = findViewById(R.id.mobileId);
        DpiTxt = findViewById(R.id.mobileDpi);
        ResolutionTxt = findViewById(R.id.mobileResolution);
        RamTxt = findViewById(R.id.mobileRam);

        dpiMobile = findViewById(R.id.dpiMobile);
        sensetiveSetting = findViewById(R.id.sensetiveBtn);
        PointerBtn = findViewById(R.id.PointerBtn);
        moreSettings = findViewById(R.id.moreSettings);

        headShotBtn = findViewById(R.id.headShotBtn);


        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager wm = (WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE); // the results will be higher than using the activity context object or the getWindowManager() shortcut
        wm.getDefaultDisplay().getMetrics(displayMetrics);
        int screenWidth = displayMetrics.widthPixels;
        int screenHeight = displayMetrics.heightPixels;


        final Runtime runtime = Runtime.getRuntime();
        final long usedMemInMB = (runtime.totalMemory() - runtime.freeMemory()) / 1048576L;
        final long maxHeapSizeInMB = runtime.maxMemory() / 1048576L;
        final long availHeapSizeInMB = maxHeapSizeInMB - usedMemInMB;

        ActivityManager actManager = (ActivityManager) getApplicationContext().getSystemService(Context.ACTIVITY_SERVICE);
        ActivityManager.MemoryInfo memInfo = new ActivityManager.MemoryInfo();
        assert actManager != null;
        actManager.getMemoryInfo(memInfo);
        long totalMemory = memInfo.totalMem;

        MobileModel = Build.MODEL;
        MobileBrand = Build.BRAND;
        MobileAndroid = Build.VERSION.RELEASE;
        MobileHardware = Build.HARDWARE;
        MobileID = Build.ID;
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        MobileDPI = (metrics.density * 160f) + "";
        MobileResolution = screenHeight + " x " + screenWidth;
        MobileRam = bytesToHuman(totalMemory) + "";


        ModelTxt.setText(MobileModel);
        BrandTxt.setText(MobileBrand);
        AndroidTxt.setText(MobileAndroid);
        HardwareTxt.setText(MobileHardware);
        IdTxt.setText(MobileID);
        DpiTxt.setText(MobileDPI);
        ResolutionTxt.setText(MobileResolution);
        RamTxt.setText(MobileRam);


        mobileModel = new MobileModel();
        mobileModel.setMobileModel("Xiaomi Redmi");
        mobileModel.setMobileBrand("Xiaomi");
        mobileModel.setMobileDpi("412");
        mobileModel.setMobileRam("none");
        mobileModel.setGeneral(100);
        mobileModel.setRedDot(95);
        mobileModel.setScope2x(95);
        mobileModel.setScope4x(98);
        mobileModel.setAWMScope(40);
        mobileModel.setFreeLook(31);
        MobileModels.add(mobileModel);

        mobileModel = new MobileModel();
        mobileModel.setMobileModel("Xiaomi Redmi");
        mobileModel.setMobileBrand("Xiaomi");
        mobileModel.setMobileDpi("412");
        mobileModel.setMobileRam("none");
        mobileModel.setGeneral(100);
        mobileModel.setRedDot(95);
        mobileModel.setScope2x(95);
        mobileModel.setScope4x(98);
        mobileModel.setAWMScope(40);
        mobileModel.setFreeLook(31);
        MobileModels.add(mobileModel);

        mobileModel = new MobileModel();
        mobileModel.setMobileModel("Xiaomi Poco");
        mobileModel.setMobileBrand("Xiaomi");
        mobileModel.setMobileDpi("587");
        mobileModel.setMobileRam("none");
        mobileModel.setGeneral(100);
        mobileModel.setRedDot(81);
        mobileModel.setScope2x(84);
        mobileModel.setScope4x(87);
        mobileModel.setAWMScope(40);
        mobileModel.setFreeLook(30);
        MobileModels.add(mobileModel);

        mobileModel = new MobileModel();
        mobileModel.setMobileModel("Xiaomi Redmi Note");
        mobileModel.setMobileBrand("Xiaomi");
        mobileModel.setMobileDpi("452");
        mobileModel.setMobileRam("none");
        mobileModel.setGeneral(94);
        mobileModel.setRedDot(100);
        mobileModel.setScope2x(100);
        mobileModel.setScope4x(100);
        mobileModel.setAWMScope(100);
        mobileModel.setFreeLook(39);
        MobileModels.add(mobileModel);

        mobileModel = new MobileModel();
        mobileModel.setMobileModel("Xiaomi Mi");
        mobileModel.setMobileBrand("Xiaomi");
        mobileModel.setMobileDpi("497");
        mobileModel.setMobileRam("none");
        mobileModel.setGeneral(96);
        mobileModel.setRedDot(100);
        mobileModel.setScope2x(100);
        mobileModel.setScope4x(88);
        mobileModel.setAWMScope(50);
        mobileModel.setFreeLook(40);
        MobileModels.add(mobileModel);

        mobileModel = new MobileModel();
        mobileModel.setMobileModel("HTC");
        mobileModel.setMobileBrand("HTC");
        mobileModel.setMobileDpi("461");//
        mobileModel.setMobileRam("none");
        mobileModel.setGeneral(78);
        mobileModel.setRedDot(74);
        mobileModel.setScope2x(93);
        mobileModel.setScope4x(85);
        mobileModel.setAWMScope(40);
        mobileModel.setFreeLook(50);
        MobileModels.add(mobileModel);

        mobileModel = new MobileModel();
        mobileModel.setMobileModel("Sony");
        mobileModel.setMobileBrand("Sony");
        mobileModel.setMobileDpi("461");//
        mobileModel.setMobileRam("none");
        mobileModel.setGeneral(94);
        mobileModel.setRedDot(89);
        mobileModel.setScope2x(88);
        mobileModel.setScope4x(93);
        mobileModel.setAWMScope(40);
        mobileModel.setFreeLook(50);
        MobileModels.add(mobileModel);

        mobileModel = new MobileModel();
        mobileModel.setMobileModel("Tecno");
        mobileModel.setMobileBrand("Tecno");
        mobileModel.setMobileDpi("461");//
        mobileModel.setMobileRam("none");
        mobileModel.setGeneral(94);
        mobileModel.setRedDot(96);
        mobileModel.setScope2x(87);
        mobileModel.setScope4x(100);
        mobileModel.setAWMScope(40);
        mobileModel.setFreeLook(50);
        MobileModels.add(mobileModel);

        mobileModel = new MobileModel();
        mobileModel.setMobileModel("Lenovo");
        mobileModel.setMobileBrand("Lenovo");
        mobileModel.setMobileDpi("461");//
        mobileModel.setMobileRam("none");
        mobileModel.setGeneral(100);
        mobileModel.setRedDot(100);
        mobileModel.setScope2x(100);
        mobileModel.setScope4x(100);
        mobileModel.setAWMScope(40);
        mobileModel.setFreeLook(50);
        MobileModels.add(mobileModel);

        mobileModel = new MobileModel();
        mobileModel.setMobileModel("Relme");
        mobileModel.setMobileBrand("Relme");
        mobileModel.setMobileDpi("497");
        mobileModel.setMobileRam("none");
        mobileModel.setGeneral(100);
        mobileModel.setRedDot(100);
        mobileModel.setScope2x(100);
        mobileModel.setScope4x(100);
        mobileModel.setAWMScope(50);
        mobileModel.setFreeLook(40);
        MobileModels.add(mobileModel);

        mobileModel = new MobileModel();
        mobileModel.setMobileModel("Nokia");
        mobileModel.setMobileBrand("Nokia");
        mobileModel.setMobileDpi("493");
        mobileModel.setMobileRam("none");
        mobileModel.setGeneral(100);
        mobileModel.setRedDot(100);
        mobileModel.setScope2x(100);
        mobileModel.setScope4x(100);
        mobileModel.setAWMScope(50);
        mobileModel.setFreeLook(40);
        MobileModels.add(mobileModel);


        mobileModel = new MobileModel();
        mobileModel.setMobileModel("infinix");
        mobileModel.setMobileBrand("infinix");
        mobileModel.setMobileDpi("461");
        mobileModel.setMobileRam("none");
        mobileModel.setGeneral(97);
        mobileModel.setRedDot(90);
        mobileModel.setScope2x(95);
        mobileModel.setScope4x(100);
        mobileModel.setAWMScope(50);
        mobileModel.setFreeLook(40);
        MobileModels.add(mobileModel);

        /*mobileModel = new MobileModel();
        mobileModel.setMobileModel("iphone");
        mobileModel.setMobileBrand("iphone");
        mobileModel.setMobileDpi("119");
        mobileModel.setMobileRam("none");
        mobileModel.setGeneral(97);
        mobileModel.setRedDot(90);
        mobileModel.setScope2x(95);
        mobileModel.setScope4x(100);
        mobileModel.setAWMScope(50);
        mobileModel.setFreeLook(40);
        MobileModels.add(mobileModel);*/

        mobileModel = new MobileModel();
        mobileModel.setMobileModel("Oppo Reno");
        mobileModel.setMobileBrand("Oppo");
        mobileModel.setMobileDpi("493");
        mobileModel.setMobileRam("none");
        mobileModel.setGeneral(97);
        mobileModel.setRedDot(87);
        mobileModel.setScope2x(76);
        mobileModel.setScope4x(88);
        mobileModel.setAWMScope(40);
        mobileModel.setFreeLook(50);
        MobileModels.add(mobileModel);

        mobileModel = new MobileModel();
        mobileModel.setMobileModel("Oppo A");
        mobileModel.setMobileBrand("Oppo");
        mobileModel.setMobileDpi("452");
        mobileModel.setMobileRam("none");
        mobileModel.setGeneral(98);
        mobileModel.setRedDot(99);
        mobileModel.setScope2x(93);
        mobileModel.setScope4x(100);
        mobileModel.setAWMScope(40);
        mobileModel.setFreeLook(50);
        MobileModels.add(mobileModel);

        mobileModel = new MobileModel();
        mobileModel.setMobileModel("Oppo F");
        mobileModel.setMobileBrand("Oppo");
        mobileModel.setMobileDpi("473");
        mobileModel.setMobileRam("none");
        mobileModel.setGeneral(92);
        mobileModel.setRedDot(93);
        mobileModel.setScope2x(89);
        mobileModel.setScope4x(100);
        mobileModel.setAWMScope(40);
        mobileModel.setFreeLook(50);
        MobileModels.add(mobileModel);

        mobileModel = new MobileModel();
        mobileModel.setMobileModel("Samsung Galaxy Note");
        mobileModel.setMobileBrand("Samsung");
        mobileModel.setMobileDpi("497");
        mobileModel.setMobileRam("none");
        mobileModel.setGeneral(95);
        mobileModel.setRedDot(91);
        mobileModel.setScope2x(100);
        mobileModel.setScope4x(100);
        mobileModel.setAWMScope(40);
        mobileModel.setFreeLook(50);
        MobileModels.add(mobileModel);

        mobileModel = new MobileModel();
        mobileModel.setMobileModel("Samsung Galaxy A");
        mobileModel.setMobileBrand("Samsung");
        mobileModel.setMobileDpi("461");
        mobileModel.setMobileRam("none");
        mobileModel.setGeneral(96);
        mobileModel.setRedDot(86);
        mobileModel.setScope2x(84);
        mobileModel.setScope4x(82);
        mobileModel.setAWMScope(40);
        mobileModel.setFreeLook(50);
        MobileModels.add(mobileModel);

        mobileModel = new MobileModel();
        mobileModel.setMobileModel("Samsung Galaxy S");
        mobileModel.setMobileBrand("Samsung");
        mobileModel.setMobileDpi("497");
        mobileModel.setMobileRam("none");
        mobileModel.setGeneral(99);
        mobileModel.setRedDot(93);
        mobileModel.setScope2x(95);
        mobileModel.setScope4x(78);
        mobileModel.setAWMScope(40);
        mobileModel.setFreeLook(50);
        MobileModels.add(mobileModel);

        mobileModel = new MobileModel();
        mobileModel.setMobileModel("Samsung Galaxy M");
        mobileModel.setMobileBrand("Samsung");
        mobileModel.setMobileDpi("412");
        mobileModel.setMobileRam("none");
        mobileModel.setGeneral(100);
        mobileModel.setRedDot(81);
        mobileModel.setScope2x(76);
        mobileModel.setScope4x(88);
        mobileModel.setAWMScope(40);
        mobileModel.setFreeLook(50);
        MobileModels.add(mobileModel);

        mobileModel = new MobileModel();
        mobileModel.setMobileModel("Samsung Grand");
        mobileModel.setMobileBrand("Samsung");
        mobileModel.setMobileDpi("412");
        mobileModel.setMobileRam("none");
        mobileModel.setGeneral(100);
        mobileModel.setRedDot(100);
        mobileModel.setScope2x(100);
        mobileModel.setScope4x(100);
        mobileModel.setAWMScope(40);
        mobileModel.setFreeLook(50);
        MobileModels.add(mobileModel);

        mobileModel = new MobileModel();
        mobileModel.setMobileModel("Huawei Nova");
        mobileModel.setMobileBrand("Huawei");
        mobileModel.setMobileDpi("497");
        mobileModel.setMobileRam("none");
        mobileModel.setGeneral(95);
        mobileModel.setRedDot(81);
        mobileModel.setScope2x(100);
        mobileModel.setScope4x(100);
        mobileModel.setAWMScope(40);
        mobileModel.setFreeLook(50);
        MobileModels.add(mobileModel);

        mobileModel = new MobileModel();
        mobileModel.setMobileModel("Huawei P");
        mobileModel.setMobileBrand("Huawei");
        mobileModel.setMobileDpi("412");
        mobileModel.setMobileRam("none");
        mobileModel.setGeneral(100);
        mobileModel.setRedDot(81);
        mobileModel.setScope2x(76);
        mobileModel.setScope4x(88);
        mobileModel.setAWMScope(40);
        mobileModel.setFreeLook(50);
        MobileModels.add(mobileModel);

        mobileModel = new MobileModel();
        mobileModel.setMobileModel("Huawei Y");
        mobileModel.setMobileBrand("Huawei");
        mobileModel.setMobileDpi("497");
        mobileModel.setMobileRam("none");
        mobileModel.setGeneral(99);
        mobileModel.setRedDot(100);
        mobileModel.setScope2x(100);
        mobileModel.setScope4x(100);
        mobileModel.setAWMScope(40);
        mobileModel.setFreeLook(50);
        MobileModels.add(mobileModel);


        findUsingEnhancedForLoop(MobileModels);


        moreSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String appPackageName = "com.mrwekaytapp.touchspeed";
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
                } catch (android.content.ActivityNotFoundException anfe) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
                }

            }
        });


        PointerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getApplicationContext(), PointerActivity.class);
                startActivity(intent);



            }
        });



        fireBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MobileSpecActivity.this, FireBtnActivity.class);
                startActivity(intent);



            }
        });


        dpiMobile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MobileSpecActivity.this,DpiActivity.class);
                startActivity(intent);


            }
        });



        sensetiveSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent intent=new Intent(getApplicationContext(),SensetiveActivity.class);
                startActivity(intent);


           /*     final AlertDialog dialog2 = new AlertDialog.Builder(MobileSpecActivity.this).create();
                LayoutInflater inflater = getLayoutInflater();
                View convertView = (View) inflater.inflate(R.layout.loading_dialog, null);
                dialog2.setView(convertView);
                dialog2.setCancelable(false);
                dialog2.show();

                handler=new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent=new Intent(MobileSpecActivity.this,SensetiveActivity.class);
                        startActivity(intent);
                        dialog2.cancel();

                        if (mInterstitialAd != null) {
                            mInterstitialAd.show(MobileSpecActivity.this);
                        } else {
                            Log.d("TAG", "The interstitial ad wasn't ready yet.");
                        }

                    }
                },3000);
*/





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

    public void GetTelegram(String idTelegram) {
        try {
            Intent telegram = new Intent(Intent.ACTION_VIEW, Uri.parse(idTelegram));
            telegram.setPackage("org.telegram.messenger");
            startActivity(telegram);
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Telegram app is not installed", Toast.LENGTH_LONG).show();
        }
    }

    /*
    String sentence = "Check this answer and you can find the keyword with this code";
String search  = "keyword";

if ( sentence.toLowerCase().indexOf(search.toLowerCase()) != -1 ) {

   System.out.println("I found the keyword");

} else {

   System.out.println("not found");

}
     */
    public MobileModel findUsingEnhancedForLoop(
            List<MobileModel> customers) {

        for (MobileModel customer : customers) {
            if (customer.getMobileModel().toLowerCase().contains(MobileModel.toLowerCase()) || customer.getMobileModel().toLowerCase().contains(MobileBrand.toLowerCase())) {
                //Toast.makeText(getApplicationContext(), ""+customer.getMobileBrand(), Toast.LENGTH_LONG).show();
                newSettings = new MobileModel();
                newSettings = customer;
                //DpiTxt.setText("wow");

                return customer;
            }else{
                newSettings = new MobileModel();
                newSettings.setMobileModel("Huawei Y");
                newSettings.setMobileBrand("Huawei");
                newSettings.setMobileDpi("451");
                newSettings.setMobileRam("none");
                newSettings.setGeneral(100);
                newSettings.setRedDot(93);
                newSettings.setScope2x(83);
                newSettings.setScope4x(87);
                newSettings.setAWMScope(40);
                newSettings.setFreeLook(50);

            }

        }
        return null;
    }


    @android.annotation.TargetApi(17) public boolean isDevMode() {
        if(Integer.valueOf(android.os.Build.VERSION.SDK) == 16) {
            return android.provider.Settings.Secure.getInt(getApplicationContext().getContentResolver(),
                    android.provider.Settings.Secure.DEVELOPMENT_SETTINGS_ENABLED , 0) != 0;
        } else if (Integer.valueOf(android.os.Build.VERSION.SDK) >= 17) {
            return android.provider.Settings.Secure.getInt(getApplicationContext().getContentResolver(),
                    android.provider.Settings.Global.DEVELOPMENT_SETTINGS_ENABLED , 0) != 0;
        } else return false;
    }

    @Override
    protected void onResume() {
        super.onResume();


    }


    /*@Override
    public void onBackPressed() {
        startAppAd.showAd();
        super.onBackPressed();
    }*/
}
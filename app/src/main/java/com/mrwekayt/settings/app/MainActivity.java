package com.mrwekayt.settings.app;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;
import com.google.android.material.navigation.NavigationView;
import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.mrwekayt.settings.app.databinding.ActivityMainBinding;
import com.mrwekayt.settings.app.ui.MoreAppsActivity;


import java.io.File;


public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    //private StartAppAd startAppAd = new StartAppAd(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);



        //binding = DataBindingUtil.setContentView (this, R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });




    DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id=menuItem.getItemId();
                //it's possible to do more actions on several items, if there is a large amount of items I prefer switch(){case} instead of if()
                if (id==R.id.nav_home){

                }
                else{

                }
                switch (id){
                    case R.id.nav_home:

                        break;
                    /*case R.id.Telegram:
                            GetTelegram("https://t.me/MrWekaYt0");
                        break;*/
                    case R.id.Youtube:
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("https://www.youtube.com/c/MrWekaYt"));
                        intent.setPackage("com.google.android.youtube");
                        startActivity(intent);
                        break;
                    case R.id.Instagram:
                        Uri uri = Uri.parse("https://www.instagram.com/mrwekayt/");
                        Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

                        likeIng.setPackage("com.instagram.android");

                        try {
                            startActivity(likeIng);
                        } catch (ActivityNotFoundException e) {
                            startActivity(new Intent(Intent.ACTION_VIEW,
                                    Uri.parse("https://www.instagram.com/mrwekayt/")));
                        }

                        break;
                    case R.id.TikTok:
                        Uri Tikuri = Uri.parse("https://vm.tiktok.com/ZMdTH6VJN/");
                        Intent TiklikeIng = new Intent(Intent.ACTION_VIEW, Tikuri);

                        TiklikeIng.setPackage("com.zhiliaoapp.musically");

                        try {
                            startActivity(TiklikeIng);
                        } catch (ActivityNotFoundException e) {
                            startActivity(new Intent(Intent.ACTION_VIEW,
                                    Uri.parse("https://vm.tiktok.com/ZMdTH6VJN/")));
                        }

                        break;
                    case R.id.Share:
                        ApplicationInfo app = getApplicationContext().getApplicationInfo();
                        String filePath = app.sourceDir;

                        Intent intentShare = new Intent(Intent.ACTION_SEND);

                        // MIME of .apk is "application/vnd.android.package-archive".
                        // but Bluetooth does not accept this. Let's use "*/*" instead.
                        intentShare.setType("*/*");


                        // Append file and send Intent
                        intentShare.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new File(filePath)));
                        startActivity(Intent.createChooser(intentShare, "Share app via"));
                        break;

                    case R.id.Email:

                        Intent i = new Intent(Intent.ACTION_SEND);
                        //i.setClassName("com.google.android.gm", "com.google.android.gm.ConversationListActivity");
                        i.setType("message/rfc822");
                        //i.setData(Uri.parse("mailto:"));
                        i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"businesswekaytff@gmail.com"});
                        i.putExtra(Intent.EXTRA_SUBJECT, "Weka Settings App");
                        //i.putExtra(Intent.EXTRA_TEXT   , "عندي مشكلة في التطبيق وهي : ");
                        try {
                            startActivity(Intent.createChooser(i, "Send mail..."));
                        } catch (android.content.ActivityNotFoundException ex) {
                            Toast.makeText(MainActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                        }

                        break;
                   /* case R.id.About:


                        Intent l = new Intent(getApplicationContext(),AboutActivity.class);
                        startActivity(l);
                        /*final AlertDialog dialog3 = new AlertDialog.Builder(MainActivity.this).create();
                        LayoutInflater inflater = getLayoutInflater();
                        View convertView = (View) inflater.inflate(R.layout.develpoer_dialog, null);
                        dialog3.setView(convertView);
                        dialog3.setCancelable(false);
                        dialog3.show();

                        TextView telegramTxt = convertView.findViewById(R.id.telegramTxt);
                        Button Acceptbtn = convertView.findViewById(R.id.acceptBtn);

                        Acceptbtn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog3.cancel();
                            }
                        });

                        telegramTxt.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                GetTelegram(telegramTxt.getText().toString());
                            }
                        });


                        break;*/
                    case R.id.Rate:
                        final String appPackageNameRate = getPackageName();
                        try {
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageNameRate)));
                        } catch (android.content.ActivityNotFoundException anfe) {
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageNameRate)));
                        }
                        break;
                    case R.id.moreSettings:
                        Intent k = new Intent(getApplicationContext(), MoreAppsActivity.class);
                        startActivity(k);
                        break;
                    case R.id.helpCenter:
                        Toast.makeText(MainActivity.this, "Comming Soon", Toast.LENGTH_SHORT).show();
                        break;
                }


                //This is for maintaining the behavior of the Navigation view
                NavigationUI.onNavDestinationSelected(menuItem,navController);
                //This is for closing the drawer after acting on it
                drawer.closeDrawer(GravityCompat.START);
                return true;
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

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
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


}
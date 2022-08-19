package com.mrwekayt.settings.app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.mrwekayt.settings.app.R;

public class AboutActivity extends AppCompatActivity {
    TextView telegramTxt;
    Button Acceptbtn;

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.develpoer_dialog);


        telegramTxt = findViewById(R.id.telegramTxt);
        Acceptbtn = findViewById(R.id.acceptBtn);

        Acceptbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        telegramTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetTelegram(telegramTxt.getText().toString());
            }
        });


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

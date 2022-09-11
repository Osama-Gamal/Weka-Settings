package com.mrwekayt.settings.app.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import com.mrwekayt.settings.app.DpiActivity;
import com.mrwekayt.settings.app.R;
import com.mrwekayt.settings.app.SensetiveActivity;
public class HaveDpiActivity extends AppCompatActivity {
    CardView dpiMobile,sensetiveSetting,pointerBtn;

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.have_dpi);


        sensetiveSetting = findViewById(R.id.sensetiveBtn);
        dpiMobile = findViewById(R.id.dpiMobile);
        pointerBtn = findViewById(R.id.pointerBtn);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("dpi");
            if(value.equals("no")){
                pointerBtn.setVisibility(View.VISIBLE);
                dpiMobile.setVisibility(View.GONE);
            }else{
                pointerBtn.setVisibility(View.GONE);
                dpiMobile.setVisibility(View.VISIBLE);
            }

        }

        pointerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HaveDpiActivity.this, PointerActivity.class);
                startActivity(intent);

            }
        });

        dpiMobile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(HaveDpiActivity.this,DpiActivity.class);
                startActivity(intent);

            }

        });

        sensetiveSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HaveDpiActivity.this, SensetiveActivity.class);
                startActivity(intent);


            }
        });





        }


}

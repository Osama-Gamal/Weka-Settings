package com.mrwekayt.settings.app.ui;


import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import com.mrwekayt.settings.app.GraphicSettings;
import com.mrwekayt.settings.app.MobileSpecActivity;
import com.mrwekayt.settings.app.R;

public class GamesActivity extends AppCompatActivity {

    CardView xoGameBtn,memoryGameBtn,fillGameBtn,memoryGame2Btn;

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.games_activity);




        xoGameBtn = findViewById(R.id.xoGameBtn);
        memoryGameBtn = findViewById(R.id.memoryGameBtn);
        fillGameBtn = findViewById(R.id.fillGameBtn);
        memoryGame2Btn = findViewById(R.id.memoryGame2Btn);







        xoGameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(GamesActivity.this, PlayGame.class);
                intent.putExtra("game","xogame");
                startActivity(intent);


            }
        });
        memoryGameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(GamesActivity.this, PlayGame.class);
                intent.putExtra("game","memorygame");
                startActivity(intent);

            }
        });
        fillGameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(GamesActivity.this, PlayGame.class);
                intent.putExtra("game","fillgame");
                startActivity(intent);

            }
        });
        memoryGame2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(GamesActivity.this, PlayGame.class);
                intent.putExtra("game","memory2game");
                startActivity(intent);

            }
        });



    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}

package com.mrwekayt.settings.app.ui.home;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import com.mrwekayt.settings.app.GraphicSettings;
import com.mrwekayt.settings.app.ui.MainOptions;
import com.mrwekayt.settings.app.ui.MoreAppsActivity;
import com.mrwekayt.settings.app.R;
import com.mrwekayt.settings.app.ui.hudSettings;


public class HomeFragment extends Fragment {

    CardView helpCenterBtn,moreAppsBtn,headShotBtn,hudBtn,graphicBtn,ffCharacterBtn,youtubeBtn;

    CardView forMobile;
    private AlertDialog dialog2;
    Handler handler;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.main_options, container, false);


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
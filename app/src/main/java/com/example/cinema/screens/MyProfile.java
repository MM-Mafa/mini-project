package com.example.cinema.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cinema.MainActivity;
import com.example.cinema.R;
import com.example.cinema.views.CustomMenu;

public class MyProfile extends AppCompatActivity {
    TextView textView;
    ImageView rightIcon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);
        rightIcon = findViewById(R.id.right_icon1);
        rightIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomMenu customMenu = new CustomMenu();
                customMenu.showMenu(v,getApplicationContext());
            }
        });

        textView = findViewById(R.id.signout);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent(MyProfile.this, MainActivity.class));
                finish();
            }
        });
    }
}
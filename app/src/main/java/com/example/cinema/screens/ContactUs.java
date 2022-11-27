package com.example.cinema.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.cinema.R;
import com.example.cinema.views.CustomMenu;

public class ContactUs extends AppCompatActivity {
    ImageView rightIcon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        rightIcon = findViewById(R.id.right_icon1);
        rightIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomMenu customMenu = new CustomMenu();
                customMenu.showMenu(v,getApplicationContext());
            }
        });
    }
}
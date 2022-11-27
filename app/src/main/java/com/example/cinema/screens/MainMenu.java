package com.example.cinema.screens;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.Layout;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cinema.R;
import com.example.cinema.databinding.ActivityMainMenuBinding;
import com.example.cinema.views.GridAdapter;

public class MainMenu extends AppCompatActivity {
    @NonNull ActivityMainMenuBinding binding;
    GridView gridView;
    ImageView leftIcon,rightIcon;
    TextView appName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        leftIcon = findViewById(R.id.left_icon);
        rightIcon = findViewById(R.id.right_icon1);
        appName = findViewById(R.id.app_name);

        leftIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainMenu.this, "it works",Toast.LENGTH_SHORT).show();
            }
        });
        rightIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMenu(v);
            }
        });
        onConfigurationChanged(getResources().getConfiguration());
        String [] movieNames = {"adventures","endless","superman","doctor strange","one love","luca","halloween","bigfoot family","maze runner"};
        int [] imageId= {R.drawable.m1,R.drawable.m2,R.drawable.m3,R.drawable.m4,R.drawable.m5,R.drawable.m6,R.drawable.m7,R.drawable.m8,R.drawable.m9};
        GridAdapter gridAdapter = new GridAdapter(MainMenu.this,movieNames,imageId);
        binding.gridView.setAdapter(gridAdapter);

        gridView = findViewById(R.id.gridView);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String movieName  = movieNames[position];
                int moviePicId= imageId[position];
                startActivity( new Intent(MainMenu.this, BookAnItem.class).putExtra("movieName",movieName).putExtra("moviePicId",moviePicId));
            }
        });
    }
    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        gridView = findViewById(R.id.gridView);
        gridView.setNumColumns(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE ? 3:2);
        super.onConfigurationChanged(newConfig);
    }

    public  void showMenu (View view) {

        PopupMenu popupMenu = new PopupMenu( MainMenu.this, view);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.profile:
                        startActivity( new Intent(MainMenu.this, MyProfile.class));
                        return true;
                    case R.id.help:
                        startActivity( new Intent(MainMenu.this, Help.class));
                        return true;
                    case R.id.contact_us:
                        startActivity( new Intent(MainMenu.this, ContactUs.class));
                        return true;
                    case R.id.bookings:
                        startActivity( new Intent(MainMenu.this, MyBookings.class));
                        return true;
                    default:
                        return false;
                }

            }
        });
        popupMenu.show();
    }

}
package com.example.cinema.screens;

import static com.example.cinema.screens.BookAnItem.getNumberOfTickets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cinema.R;
import com.example.cinema.views.CustomMenu;

public class SammaryInfo extends AppCompatActivity {
    TextView textView;
    Button done;
    ImageView imageView,rightIcon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sammary_info);
        textView = findViewById(R.id.booking_details);
        done = findViewById(R.id.done);
        imageView = findViewById(R.id.imageView);
        rightIcon = findViewById(R.id.right_icon1);
        rightIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomMenu customMenu = new CustomMenu();
                customMenu.showMenu(v,getApplicationContext());
            }
        });

        Intent intent = getIntent();
        if(intent.getExtras() !=null) {
            String bookingDetails = intent.getStringExtra("bookingDetails");
            int imageId = intent.getIntExtra("imageId",0);

            textView.setText(bookingDetails);
            imageView.setImageResource(imageId);
        }
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(SammaryInfo.this,MyBookings.class).putExtra("Boolean",1));
                finish();
            }
        });
    }
}
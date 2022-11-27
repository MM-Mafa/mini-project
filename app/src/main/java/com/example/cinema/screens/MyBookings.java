package com.example.cinema.screens;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.cinema.R;
import com.example.cinema.databinding.ActivityMainMenuBinding;
import com.example.cinema.databinding.ActivityMyBookingsBinding;
import com.example.cinema.views.CustomMenu;
import com.example.cinema.views.GridAdapter;
import com.example.cinema.views.GridAdapterBooked;

public class MyBookings extends AppCompatActivity {
    GridView gridViewBooked;
    CardView cardView;
    @NonNull
    ActivityMyBookingsBinding binding;
    private  static String [] movieNamesBooked;
    private static String chosenDate;
    private static  boolean itemBooked=false;
    ImageView rightIcon;
    private static int [] slot1Tickets,slot2Tickets,slot3Tickets;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMyBookingsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        gridViewBooked = findViewById(R.id.gridView_booked);
        cardView = findViewById(R.id.card_booked);
        rightIcon = findViewById(R.id.right_icon1);
        rightIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomMenu customMenu = new CustomMenu();
                customMenu.showMenu(v,getApplicationContext());
            }
        });
        if(itemBooked) {
            if (getIntent() != null) {
                if (getIntent().getIntExtra("Boolean", 0) == 1) {
                    startActivity(new Intent(MyBookings.this, MainMenu.class));
                }
            }
            showSuccessfullyBooked(MyBookings.this, movieNamesBooked, chosenDate, slot1Tickets, slot2Tickets, slot3Tickets);
            deleteOnclick();
        }
    }
    public  boolean showSuccessfullyBooked(Context context, String [] movieNames, String date, int [] numberOfTicketsSlot1, int [] numberOfTicketsSlot2,int [] numberOfTicketsSlot3) {

        GridAdapterBooked gridAdapterBooked = new GridAdapterBooked(context,movieNames, date, numberOfTicketsSlot1,numberOfTicketsSlot2,numberOfTicketsSlot3);
        binding.gridViewBooked.setAdapter(gridAdapterBooked);

        return true;
    }
    private  void deleteOnclick() {


        if(gridViewBooked !=null) {
            gridViewBooked.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(MyBookings.this);
                    alertDialog.setMessage("cancel booking?").setCancelable(false)
                            .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    itemBooked = false;
                                    finish();
                                    startActivity(getIntent());
                                    Toast.makeText(MyBookings.this,"successfully removed", Toast.LENGTH_SHORT).show();
                                }
                            })
                            .setNegativeButton("no", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            });
                    AlertDialog alert = alertDialog.create();
                    alert.setTitle("Booking cancellation");
                    alert.show();
                }
            });
        }
    }
    public  static void setItemBooked( boolean newItemBooked){
        MyBookings.itemBooked = newItemBooked;
    }
    public static void setMovieNamesBooked(String [] movieNamesBooked) {
        MyBookings.movieNamesBooked = movieNamesBooked;
    }

    public static void setChosenDate(String chosenDate) {
        MyBookings.chosenDate = chosenDate;
    }

    public static void setSlot1Tickets(int[] slot1Tickets) {
        MyBookings.slot1Tickets = slot1Tickets;
    }

    public static void setSlot2Tickets(int[] slot2Tickets) {
        MyBookings.slot2Tickets = slot2Tickets;
    }

    public static void setSlot3Tickets(int[] slot3Tickets) {
        MyBookings.slot3Tickets = slot3Tickets;
    }

}
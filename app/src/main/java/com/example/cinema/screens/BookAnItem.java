package com.example.cinema.screens;

import static com.example.cinema.screens.MyBookings.setChosenDate;
import static com.example.cinema.screens.MyBookings.setItemBooked;
import static com.example.cinema.screens.MyBookings.setMovieNamesBooked;
import static com.example.cinema.screens.MyBookings.setSlot1Tickets;
import static com.example.cinema.screens.MyBookings.setSlot2Tickets;
import static com.example.cinema.screens.MyBookings.setSlot3Tickets;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import com.example.cinema.R;
import com.example.cinema.views.CustomMenu;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

public class BookAnItem extends AppCompatActivity {
    ImageView movie,calender,addTicket, removeTicket,rightIcon;
    TextView movie_name, date, showTicketsNumber,ticketsLeft;
    Spinner spinner;
    String chosenSlot="14:H00";
    String movieName;
    Button book;
    int moviePicId;

    // index 0 for slot 2 pm, index 1 for slot 5pm  and index 2 for slot 8pm
     private static int [] numberOfTickets={0,0,0};
    private  static int [] availableTickets={50,50,50};
    private static String [] timeSlots= {"14:H00","17:H00","20:H00"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_an_item);
        Intent intent = getIntent();
        calender = findViewById(R.id.image_calender);
        date = findViewById(R.id.date);
        addTicket = findViewById(R.id.addTicket);
        removeTicket = findViewById(R.id.removeTicket);

        movie = findViewById(R.id.image_movie);
        movie_name = findViewById(R.id.movie_name);
        spinner = findViewById(R.id.spinner);
        showTicketsNumber = findViewById(R.id.number_of_tickets);
        ticketsLeft = findViewById(R.id.ticketsLeft);


        rightIcon = findViewById(R.id.right_icon1);
        rightIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomMenu customMenu = new CustomMenu();
                customMenu.showMenu(v,getApplicationContext());
            }
        });

        if(intent.getExtras() !=null) {
            movieName = intent.getStringExtra("movieName");
            moviePicId = intent.getIntExtra("moviePicId",0);
            movie.setImageResource(moviePicId);
            movie_name.setText(movieName);

        }

        // handling popup message dialog
        book = findViewById(R.id.book);
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder( BookAnItem.this);
                alertDialog.setMessage("confirm payment?").setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String bookingDetails = "movie name: "+movieName;
                                if(numberOfTickets[0]>0) {
                                    bookingDetails +="\nnumber of tickets booked  2pm slot: " + numberOfTickets[0];
                                }
                                if(numberOfTickets[1]>0) {
                                    bookingDetails +="\nnumber of tickets booked  5pm slot: " + numberOfTickets[1];
                                }
                                if(numberOfTickets[2]>0) {
                                    bookingDetails +="\nnumber of tickets booked  8pm slot: " + numberOfTickets[2];
                                }

                                bookingDetails+="\ntotal tickets booked: "+(numberOfTickets[1]+numberOfTickets[0]+numberOfTickets[2])+
                                        "\namount due R: "+(70*(numberOfTickets[1]+numberOfTickets[0]+numberOfTickets[2]))+
                                        "\nbooked for date : "+date.getText().toString();
                                setItemBooked(true);
                                setMovieNamesBooked(new String[]{movieName});
                                setChosenDate(date.getText().toString());
                                setSlot1Tickets( new int[]{numberOfTickets[0]});
                                setSlot2Tickets( new int[]{numberOfTickets[1]});
                                setSlot3Tickets( new int[]{numberOfTickets[2]});
                                startActivity(new Intent(BookAnItem.this, SammaryInfo.class).putExtra("bookingDetails", bookingDetails).putExtra("imageId",moviePicId));

                                finish();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert = alertDialog.create();
                alert.setTitle("Tickets Payment");
                alert.show();
            }
        });

        // handling calender
        MaterialDatePicker materialDatePicker =  MaterialDatePicker.Builder.datePicker().setTitleText("select date").setSelection(MaterialDatePicker.todayInUtcMilliseconds()).build();
        calender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                materialDatePicker.show(getSupportFragmentManager(),"Tag_Picker");
                materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
                    @Override
                    public void onPositiveButtonClick(Object selection) {
                        date.setText(materialDatePicker.getHeaderText());
                    }
                });
            }
        });

        // handling spinner
        ArrayAdapter  <String> adapter = new ArrayAdapter<String>(BookAnItem.this, android.R.layout.simple_spinner_item,timeSlots);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

       spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               chosenSlot = parent.getItemAtPosition(position).toString();
               showTicketNumber(chosenSlot);

           }

           @Override
           public void onNothingSelected(AdapterView<?> parent) {
               return;
           }
       });

       addTicket.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               updateNumberOfTickets( true);
           }
       });
       removeTicket.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               updateNumberOfTickets( false);
           }
       });
    }
    public static int[] getNumberOfTickets() {
        return numberOfTickets;
    }

    public  static int[] getAvailableTickets() {
        return availableTickets;
    }

    public static String[] getTimeSlots() {
        return timeSlots;
    }


    public static void setNumberOfTickets(int[] numberOfTickets) {
        BookAnItem.numberOfTickets = numberOfTickets;
    }

    public static void setAvailableTickets(int[] availableTickets) {
        BookAnItem.availableTickets = availableTickets;
    }

    public static void setTimeSlots(String[] timeSlots) {
        BookAnItem.timeSlots = timeSlots;
    }

    public void updateNumberOfTickets( boolean add) {

        if(add){
            switch (chosenSlot){

                case "14:H00":
                    if(availableTickets[0]>0) {
                        numberOfTickets[0] += 1;
                        availableTickets[0] -= 1;
                        showTicketNumber(chosenSlot);
                    }
                    return;
                case "17:H00":
                    if(availableTickets[1]>0) {
                        numberOfTickets[1] += 1;
                        availableTickets[1] -= 1;
                        showTicketNumber(chosenSlot);
                    }
                    return;
                case "20:H00":
                    if(availableTickets[2]>0) {
                        numberOfTickets[2] += 1;
                        availableTickets[2] -= 1;
                        showTicketNumber(chosenSlot);
                    }
                    return;
                default:
                    return;
            }

        }
        switch (chosenSlot){

            case "14:H00":
                if(numberOfTickets[0] >0) {
                    numberOfTickets[0] -= 1;
                    availableTickets[0] += 1;
                    showTicketNumber(chosenSlot);
                }
                return;
            case "17:H00":
                if(numberOfTickets[1] >0) {
                    numberOfTickets[1] -= 1;
                    availableTickets[1] += 1;
                    showTicketNumber(chosenSlot);
                }
                return;
            case "20:H00":
                if(numberOfTickets[2] >0) {
                    numberOfTickets[2] -= 1;
                    availableTickets[2] += 1;
                    showTicketNumber(chosenSlot);
                }
                return;
            default:
                return;
        }

    }

    public  void showTicketNumber(String chosenSlot){
        String ticketNo = "tickets : ";
        String availableTicket = "tickets left : ";
        switch ( chosenSlot) {

            case "14:H00":
                ticketNo+=numberOfTickets[0];
                showTicketsNumber.setText(ticketNo);
                availableTicket+=availableTickets[0];
                ticketsLeft.setText(availableTicket);
                return;

            case "17:H00":
                ticketNo+=numberOfTickets[1];
                availableTicket+=availableTickets[1];
                showTicketsNumber.setText(ticketNo);
                ticketsLeft.setText(availableTicket);
                return;

            case "20:H00":
                ticketNo+=numberOfTickets[2];
                availableTicket+=availableTickets[2];
                showTicketsNumber.setText(ticketNo);
                ticketsLeft.setText(availableTicket);
                return;
            default:
                return;
        }
    }

}
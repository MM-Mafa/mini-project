package com.example.cinema.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cinema.R;
import com.example.cinema.views.CustomMenu;

public class Help extends AppCompatActivity {
    TextView faq;
    ImageView rightIcon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        faq = findViewById(R.id.faq_textView);
        rightIcon = findViewById(R.id.right_icon1);
        rightIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomMenu customMenu = new CustomMenu();
                customMenu.showMenu(v,getApplicationContext());
            }
        });
        String text = "I lost my cinema tickets, which I purchased at the box office. Can I get duplicates?\n" +
                "\n" +
                "Unfortunately lost physical tickets cannot be replaced. If you have not picked up tickets that you purchased online, you can retrieve them at the box office or ticket kiosk.\n" +
                "\n" +
                "Can I exchange my tickets for another movie or screening time?\n" +
                "\n" +
                "The  Cinemas box office may accommodate your request, depending on availability.\n" +
                "\n" +
                "\n" +
                "Can I have someone else pick up my cinema tickets?\n" +
                "\n" +
                "The attendee must provide the full credit card number or the order confirmation email at the box office to retrieve your tickets.\n" +
                "\n" +
                "\n" +
                "Will there be a standby line for sold-out screenings?\n" +
                "\n" +
                "For specialty screenings, available seats will be sold to the standby line on a first-come, first-served basis just before the start of the show. We do not offer a cancelation line for first run films\n" +
                "\n" +
                "\n" +
                "Are rush tickets available?\n" +
                "\n" +
                "Student rush movie tickets are only available for purchase in person at the box office.\n" +
                "\n" +
                "\n" +
                "Does the time posted for the start of the movie include coming attractions?\n" +
                "\n" +
                "Coming attractions start before the posted time and the film begins five minutes after the posted time.\n" +
                "\n" +
                "\n" +
                "How do I contact the lost and found for Cinema?\n" +
                "\n" +
                "Items lost in the cinemas will be held same day at the cinema entrance. After that you may inquire with the Peter Jay Sharp stage door at 718.636.4150 . Wallets, phones, and credit cards will be held by cinema management, who will contact patrons directly.";
        faq.setText(text);

    }
}
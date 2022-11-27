package com.example.cinema.views;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

import com.example.cinema.R;
import com.example.cinema.screens.ContactUs;
import com.example.cinema.screens.Help;
import com.example.cinema.screens.MyBookings;
import com.example.cinema.screens.MyProfile;

public class CustomMenu {
    public  void showMenu (View view, Context context) {

        PopupMenu popupMenu = new PopupMenu( context, view);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.profile:
                        context.startActivity( new Intent(context, MyProfile.class));
                        return true;
                    case R.id.help:
                        context.startActivity( new Intent(context, Help.class));
                        return true;
                    case R.id.contact_us:
                        context.startActivity( new Intent(context, ContactUs.class));
                        return true;
                    case R.id.bookings:
                        context.startActivity( new Intent(context, MyBookings.class));
                        return true;
                    default:
                        return false;
                }

            }
        });
        popupMenu.show();
    }
}


package com.example.cinema.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.cinema.R;

public class GridAdapterBooked extends BaseAdapter {
    Context context;
    String [] movieNames;
    String date;
    int  [] numberOfTicketsSlot1;
    int []  numberOfTicketsSlot2;
    int [] numberOfTicketsSlot3;

    LayoutInflater inflater;

    public GridAdapterBooked(Context context, String [] movieNames, String date, int [] numberOfTicketsSlot1, int []numberOfTicketsSlot2, int [] numberOfTicketsSlot3) {
        this.context = context;
        this.movieNames = movieNames;
        this.date = date;
        this.numberOfTicketsSlot1 = numberOfTicketsSlot1;
        this.numberOfTicketsSlot2 = numberOfTicketsSlot2;
        this.numberOfTicketsSlot3 = numberOfTicketsSlot3;
    }


    @Override
    public int getCount() {
        return movieNames.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(inflater == null) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(convertView == null) {
            convertView = inflater.inflate(R.layout.booked_item,null);

        }
        TextView movieName = convertView.findViewById(R.id.movie_name_booked);
        TextView numberOfTickets1 = convertView.findViewById(R.id.textView6);
        TextView numberOfTickets2 = convertView.findViewById(R.id.textView7);
        TextView numberOfTickets3 = convertView.findViewById(R.id.textView8);
        TextView watchDate = convertView.findViewById(R.id.date_booked_ticket);
        movieName.setText(movieNames[position]);
        numberOfTickets1.setText(numberOfTicketsSlot1[position]+"");
        numberOfTickets2.setText(numberOfTicketsSlot2[position]+"");
        numberOfTickets3.setText(numberOfTicketsSlot3[position]+"");
        watchDate.setText(date);

        return convertView;
    }
}

package com.example.cinema.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cinema.R;

public class GridAdapter  extends BaseAdapter {
    Context context;
    String [] moviesName;
    int [] imageId;

    LayoutInflater inflater;

    public GridAdapter(Context context, String[] moviesName, int[] imageId) {
        this.context = context;
        this.moviesName = moviesName;
        this.imageId = imageId;
    }

    @Override
    public int getCount() {
        return moviesName.length;
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
            convertView = inflater.inflate(R.layout.grid_item,null);
        }
        ImageView imageView = convertView.findViewById(R.id.im_grid);
        TextView textView = convertView.findViewById(R.id.item_name);

        imageView.setImageResource(imageId[position]);
        textView.setText(moviesName[position]);

        return convertView;
    }
}

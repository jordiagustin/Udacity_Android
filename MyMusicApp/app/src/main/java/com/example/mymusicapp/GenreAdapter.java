package com.example.mymusicapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class GenreAdapter extends ArrayAdapter<Genre> {

    private ArrayList<Genre> genres;
    public GenreAdapter(Activity context, ArrayList<Genre> genres) {
        super(context, 0, genres);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.genre_item, parent, false);
        }

        Genre currentAndroidGenre = getItem(position);

        TextView genreTv = (TextView) listItemView.findViewById(R.id.genre_text_view);
        genreTv.setText(currentAndroidGenre.getBandName());

        return listItemView;
    }
}
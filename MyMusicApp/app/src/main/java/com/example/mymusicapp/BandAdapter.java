package com.example.mymusicapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class BandAdapter extends ArrayAdapter<Band> {

    private ArrayList<Band> bands;
    public BandAdapter(Activity context, ArrayList<Band> songs) {
        super(context, 0, songs);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.band_item, parent, false);
        }

        Band currentAndroidBand = getItem(position);

        TextView bandTv = (TextView) listItemView.findViewById(R.id.bandName_text_view);
        bandTv.setText(currentAndroidBand.getBandName());

        return listItemView;
    }
}
package com.example.jordismusicstructureapp;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class SongAdapter extends ArrayAdapter<Song> {

    //The adapter contains my array list of songs
    private ArrayList<Song> songs;
    public SongAdapter(Activity context, ArrayList<Song> songs) {
        super(context, 0, songs);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.song_item, parent, false);
        }

        //Gets the position on the list of every song object
        Song currentAndroidSong = getItem(position);

        //Sets song name text view
        TextView songNameTv = (TextView) listItemView.findViewById(R.id.song_name_text_view);
        songNameTv.setText(currentAndroidSong.getSongName());

        //Sets artist name text view
        TextView artistTv = (TextView) listItemView.findViewById(R.id.song_artist_text_view);
        artistTv.setText(currentAndroidSong.getSongArtistName());

        //Sets album name text view
        TextView albumTv = (TextView) listItemView.findViewById(R.id.song_album_text_view);
        albumTv.setText(currentAndroidSong.getSongAlbumName());

        //Sets genre name text view
        TextView genreTv = (TextView) listItemView.findViewById(R.id.song_genre_text_view);
        genreTv.setText(currentAndroidSong.getSongGenre());

        return listItemView;
    }
}
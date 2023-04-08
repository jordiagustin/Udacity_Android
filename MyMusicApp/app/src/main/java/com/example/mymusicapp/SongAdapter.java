package com.example.mymusicapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class SongAdapter extends ArrayAdapter<Song> {


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

        Song currentAndroidSong = getItem(position);

        TextView songNameTv = (TextView) listItemView.findViewById(R.id.songName_text_view);
        songNameTv.setText(currentAndroidSong.getSongName());

        TextView artistTv = (TextView) listItemView.findViewById(R.id.songArtist_text_view);
        artistTv.setText(currentAndroidSong.getSongArtistName());

        TextView albumTv = (TextView) listItemView.findViewById(R.id.songAlbum_text_view);
        albumTv.setText(currentAndroidSong.getSongAlbumName());

        TextView genreTv = (TextView) listItemView.findViewById(R.id.songGenre_text_view);
        genreTv.setText(currentAndroidSong.getSongGenre());

        return listItemView;
    }
}

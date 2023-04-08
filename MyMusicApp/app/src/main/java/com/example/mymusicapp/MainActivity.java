package com.example.mymusicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button songsBt = (Button) findViewById(R.id.songs_button);
        Button bandsBt = (Button) findViewById(R.id.bands_button);
        Button genresBt = (Button) findViewById(R.id.genres_button);
        Button playerBt = (Button) findViewById(R.id.player_button);


        songsBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSongsList();
            }
        });

        bandsBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBandsList();
            }
        });

        genresBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGenresList();
            }
        });

        playerBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPlayer(v);
            }
        });
    }

    public void openSongsList(){
        Intent songsListIntent = new Intent(this, SongsListActivity.class);
        startActivity(songsListIntent);
    }

    public void openBandsList(){
        Intent bandsListIntent = new Intent(this, BandsListActivity.class);
        startActivity(bandsListIntent);
    }

    public void openGenresList(){
        Intent genreListIntent = new Intent(this, GenreListActivity.class);
        startActivity(genreListIntent);
    }

    public void openPlayer(View v) {
        Intent intent = new Intent(this, SongPlayer.class);
        startActivity(intent);
    }
}
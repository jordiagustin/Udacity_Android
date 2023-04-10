package com.example.jordismusicstructureapp;

import static android.provider.MediaStore.INTENT_ACTION_MEDIA_PLAY_FROM_SEARCH;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

public class SurpriseSongsActivity extends AppCompatActivity {

    int aleatorySongIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.items_list);

        //Create an array of Song objects
        ArrayList<Song> songs = new ArrayList<Song>();
        ArrayList<Song> selectedSong = new ArrayList<Song>();

        songs.add(new Song("Hallowed be thy Name", "Iron Maiden", "The Number of the Beast", "Heavy Metal"));
        songs.add(new Song("I Want Out", "Helloween", "Keeper of the Seven Keys (Part 2)", "Power Metal"));
        songs.add(new Song("Dance Macabre", "Ghost", "Prequelle", "Hard Rock"));
        songs.add(new Song("Life in Hell","Megadeth","The Sick, the Dying... and the Dead!","Thrash Metal"));
        songs.add(new Song("Forever Chemicals","Placebo","Never Let Me Go", "Alternative Rock"));
        songs.add(new Song("And So it Went","The Pretty Reckless","Death by Rock and Roll", "Hard Rock"));
        songs.add(new Song("For Whom the Bell Tolls", "Metallica", "Ride The Lightning", "Thrash Metal"));
        songs.add(new Song("Stargazers", "Nightwish", "Oceanborn", "Simphonic Metal"));
        songs.add(new Song("John the Fisherman", "Primus", "Suck on This", "Funk Metal"));
        songs.add(new Song ("The Beginning of All Things", "In Flames", "The Beginning of All Things", "Melodic Death Metal"));
        songs.add(new Song("If Darkness Had a Son","Metallica","72 Seasons","Thrash Metal"));
        songs.add(new Song("Seal of Solomon","Epica", "Omega", "Simphonic Metal"));
        songs.add(new Song("Stratego","Iron Maiden","Senjutsu","Heavy Metal"));
        songs.add(new Song("Strange Girl", "Halestorm","Back from the Dead", "Hard Rock"));
        songs.add(new Song("Fear of the Fallen","Helloween", "Helloween", "Power Metal"));
        songs.add(new Song("Exiled from Earth","Arch Enemy", "Deceivers", "Melodic Death Metal"));
        songs.add(new Song("Monetary Gods", "Rage", "Resurrection Day", "Heavy Metal"));
        songs.add(new Song("Storm Troopers","Sabaton", "The War To End All Wars","Power Metal"));
        songs.add(new Song( "The Attitude", "Annihilator", "Ballistic, Sadistic", "Thrash Metal"));
        songs.add(new Song("Indians", "Anthrax","Among the Living", "Thrash Metal"));
        songs.add(new Song("Ancus", "Eluveitie","Ategnatus", "Folk Metal"));
        songs.add(new Song("One For All", "Hardcore Superstar", "Abrakadabra", "Glam Rock"));
        songs.add(new Song("Call Me Little Sunshine", "Ghost","Impera","Hard Rock"));
        songs.add(new Song("Tuonela", "Therion", "Leviathan","Simphonic Metal"));
        songs.add(new Song("Bitter End", "Placebo", "Sleeping with Ghosts", "Alternative Rock"));
        songs.add(new Song("All We Are", "Doro", "Triumph and Agony", "Heavy Metal"));
        songs.add(new Song("Breaking the Law", "Judas Priest", "British Steel", "Heavy Metal"));
        songs.add(new Song("Detroit Rock City", "Kiss", "Destroyer", "Glam Rock"));
        songs.add(new Song("No Class", "Motorhead", "OverKill", "Heavy Metal"));
        songs.add(new Song("Symphony of Destruction", "Megadeth", "Countdown to Extinction", "Thrash Metal"));

        //Generate an aleatory number to extract the song
        aleatorySongIndex = new Random().nextInt(songs.size()) + 0;

        //Gets the selected aleatory song from the songs list
        selectedSong.add(songs.get(aleatorySongIndex));

        //Creates the array of the selected song
        SongAdapter adapter = new SongAdapter(this, selectedSong);

        //Creates a list view and sets the items list layout to it
        ListView listView = (ListView) findViewById(R.id.list);

        //Sets the songs array adapter to he list view
        listView.setAdapter(adapter);

        //Add a click listener to every list item to open music player
        listView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                openPlayer(view);
            }

            public void openPlayer(View v) {
                Intent intent = new Intent(INTENT_ACTION_MEDIA_PLAY_FROM_SEARCH);
                startActivity(intent);
            }
        });
    }
}

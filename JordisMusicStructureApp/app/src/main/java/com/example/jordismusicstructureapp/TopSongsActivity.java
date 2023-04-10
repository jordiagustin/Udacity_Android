package com.example.jordismusicstructureapp;

import static android.provider.MediaStore.INTENT_ACTION_MEDIA_PLAY_FROM_SEARCH;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

/**
 * This class contains a list of top ten songs
 */
public class TopSongsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.items_list);

        //Create an array of Song objects
        ArrayList<Song> songs = new ArrayList<Song>();

                         songs.add(new Song("TOP 8 - Seal of Solomon","Epica", "Omega", "Simphonic Metal"));
        songs.add(new Song("TOP 1 - Stratego","Iron Maiden","Senjutsu","Heavy Metal"));
        songs.add(new Song("TOP 2 - Fear of the Fallen","Helloween", "Helloween", "Power Metal"));
        songs.add(new Song("TOP 3 - Call Me Little Sunshine", "Ghost","Impera","Hard Rock"));
        songs.add(new Song("TOP 4 - If Darkness Had a Son","Metallica","72 Seasons","Thrash Metal"));
        songs.add(new Song("TOP 5 - Seal of Solomon","Epica", "Omega", "Simphonic Metal"));
        songs.add(new Song("TOP 6 - Exiled from Earth","Arch Enemy", "Deceivers", "Melodic Death Metal"));
        songs.add(new Song("TOP 7 - Strange Girl", "Halestorm","Back from the Dead", "Hard Rock"));
        songs.add(new Song("TOP 8 - Ancus", "Eluveitie","Ategnatus", "Folk Metal"));
        songs.add(new Song("TOP 9 - One For All", "Hardcore Superstar", "Abrakadabra", "Glam Rock"));
        songs.add(new Song("TOP 10 - Life in Hell","Megadeth","The Sick, the Dying... and the Dead!","Thrash Metal"));

        //Creates the array of songs adapter
        SongAdapter adapter = new SongAdapter(this, songs);

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

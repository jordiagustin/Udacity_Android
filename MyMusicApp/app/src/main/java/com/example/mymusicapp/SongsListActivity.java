package com.example.mymusicapp;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
public class SongsListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.items_list);

        ArrayList<Song> songs = new ArrayList<Song>();

        songs.add(new Song("The Trooper","Iron Maiden","Piece of Mind","Heavy Metal"));
        songs.add(new Song("I Want Out","Helloween","Keeper of the Seven Keys Part II","Power Metal"));
        songs.add(new Song("Starman","David Bowie","Ziggy Stardust","Pop"));
        songs.add(new Song("Country House","Blur","The Great Scape","Brit Pop"));
        songs.add(new Song("Simpony of Destruction","Megadeth","CountDown to Extintion","Thrash Metal"));
        songs.add(new Song("Overkill","Motorhead","Overkill","Heavy Metal / Hard Rock"));
        songs.add(new Song("Tears of the Mandrake","EdGuy","Mandrake","Power Metal"));
        songs.add(new Song("We don't Celebrate Sundays","Hardcore Superstar","Hardcore Superstar","Hard / Glam Rock"));
        songs.add(new Song("John the Fisherman","Primus","Suck on This","Funck / Alternative Metal"));
        songs.add(new Song("Angst","Rammstein","Zeit","Alternative Metal"));
        songs.add(new Song("Bullet Ride","In Flames","Clayman","Alternative Metal"));
        songs.add(new Song("Rata Mahatta","Sepultura","Roots","Death Metal"));
        songs.add(new Song("Detroid Rock City","Kiss","Destroyer","Hard / Glam Rock"));
        songs.add(new Song("Holy Diver","Dio","Holy Diver","Heavy Metal"));
        songs.add(new Song("Rob the Bank","Placebo","Loud Like Love","Alternative Rock"));
        songs.add(new Song("Do Youn Want to","Franz Ferdinand","You Could Have It So Much Better","Pop"));

        SongAdapter adapter = new SongAdapter(this, songs);


        ListView listView = (ListView) findViewById(R.id.list);


        listView.setAdapter(adapter);



        listView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                openPlayer(view);
            }

            public void openPlayer(View v) {
                Intent intent = new Intent(SongsListActivity.this, SongPlayer.class);
                startActivity(intent);
            }

        });

    }

}

package com.example.mymusicapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class GenreListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.items_list);

        ArrayList<Genre> genres = new ArrayList<Genre>();

        genres.add(new Genre("Heavy Metal"));
        genres.add(new Genre("Power Metal"));
        genres.add(new Genre("Funk Metal"));
        genres.add(new Genre("Thrash Metal"));
        genres.add(new Genre("Pop"));
        genres.add(new Genre("Rock"));
        genres.add(new Genre("Punk"));
        genres.add(new Genre("Alternative Rock"));
        genres.add(new Genre("Brit Pop"));
        genres.add(new Genre("Hard Rock"));
        genres.add(new Genre("Glam Rock"));
        genres.add(new Genre("Death metal"));
        genres.add(new Genre("Alternative metal"));

        GenreAdapter adapter = new GenreAdapter(this, genres);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);



        listView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                openPlayer(view);
            }

            public void openPlayer(View v) {
                Intent intent = new Intent(GenreListActivity.this, SongPlayer.class);
                startActivity(intent);
            }

        });

    }

}
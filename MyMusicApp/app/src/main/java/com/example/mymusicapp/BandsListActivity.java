package com.example.mymusicapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class BandsListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.items_list);

        ArrayList<Band> bands = new ArrayList<Band>();

        bands.add(new Band("Iron Maiden"));
        bands.add(new Band("Helloween"));
        bands.add(new Band("Primus"));
        bands.add(new Band("Megadeth"));
        bands.add(new Band("David Bowie"));
        bands.add(new Band("Rem"));
        bands.add(new Band("Bad Religion"));
        bands.add(new Band("Motorhead"));
        bands.add(new Band("The Who"));
        bands.add(new Band("Edguy"));
        bands.add(new Band("Kiss"));
        bands.add(new Band("The Cure"));
        bands.add(new Band("Blur"));
        bands.add(new Band("Franz Ferdinand"));
        bands.add(new Band("Hardcore Superstar"));
        bands.add(new Band("Kiss"));
        bands.add(new Band("Sepultura"));
        bands.add(new Band("Dio"));
        bands.add(new Band("Placebo"));
        bands.add(new Band("Rammstein"));

        BandAdapter adapter = new BandAdapter(this, bands);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);



        listView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                openPlayer(view);
            }

            public void openPlayer(View v) {
                Intent intent = new Intent(BandsListActivity.this, SongPlayer.class);
                startActivity(intent);
            }

        });

    }

}
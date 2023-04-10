package com.example.jordismusicstructureapp;

import static android.provider.MediaStore.INTENT_ACTION_MEDIA_PLAY_FROM_SEARCH;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //Declare an array of user's auto list portraits from drawable
    ArrayList<MyAutoListPicture> autoListPictures = new ArrayList<MyAutoListPicture>();

    //Position of any myAutoListPictures position
    int autoListPictureIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Image view on main layout representing the portrait for the automatic generated song list
        ImageView autoListIv = (ImageView) findViewById(R.id.myAutoList_imageView);

        //Create all auto list picture objects from drawables
        MyAutoListPicture myAutoListPicture1 = new MyAutoListPicture(R.drawable.my_autolist_picture_1);
        MyAutoListPicture myAutoListPicture2 = new MyAutoListPicture(R.drawable.my_autolist_picture_2);
        MyAutoListPicture myAutoListPicture3 = new MyAutoListPicture(R.drawable.my_autolist_picture_3);
        MyAutoListPicture myAutoListPicture4 = new MyAutoListPicture(R.drawable.my_autolist_picture_4);
        MyAutoListPicture myAutoListPicture5 = new MyAutoListPicture(R.drawable.my_autolist_picture_5);

        //Adds all auto list picture objects to the array of auto list pictures
        autoListPictures.add(myAutoListPicture1);
        autoListPictures.add(myAutoListPicture2);
        autoListPictures.add(myAutoListPicture3);
        autoListPictures.add(myAutoListPicture4);
        autoListPictures.add(myAutoListPicture5);

        //Gets a random number between 0 and autoListPictures size to change the auto list picture randomly
        autoListPictureIndex = new Random().nextInt(autoListPictures.size()) + 0;
        //Sets the auto generated list picture
        autoListIv.setImageResource(autoListPictures.get(autoListPictureIndex).getAutoListPortraitDrawableId());

        //Find play button on main activity from the auto generated songs list
        ImageButton playBt = (ImageButton) findViewById(R.id.play_image_button);

        //Find category linear layout (we need that to be clicable)
        LinearLayout newSongsLl = (LinearLayout) findViewById(R.id.new_songs_linear_layout);
        LinearLayout topTenSongsLl = (LinearLayout) findViewById(R.id.top_songs_linear_layout);
        LinearLayout famousSongsLl = (LinearLayout) findViewById(R.id.fame_songs_linear_layout);
        LinearLayout surpriseSongLl = (LinearLayout) findViewById(R.id.surprise_song_linear_layout);

        //Set on click listener to the play button
        playBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(INTENT_ACTION_MEDIA_PLAY_FROM_SEARCH);
                startActivity(intent);
            }
        });

        //Set on click listener to new songs linear layout category
        newSongsLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Call method to open songs list activity
                openNewSongsList();
            }
        });

        //Set on click listener to top ten songs linear layout category
        topTenSongsLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Call method to open songs list activity
                openTopTenSongsList();
            }
        });

        //Set on click listener to most famous songs linear layout category
        famousSongsLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Call method to open most famous songs list activity
                openFamousSongsList();
            }
        });

        //Set on click listener to surprise song linear layout category
        surpriseSongLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Call method to open surprise songs list activity
                openSurpriseSong();
            }
        });
    }
    public void openNewSongsList(){
        //New intent to start NewSongsActivity class
        Intent newSongsListIntent = new Intent(this, NewSongsActivity.class);
        startActivity(newSongsListIntent);
    }
    public void openTopTenSongsList(){
        //New intent to start TopSongsActivity class
        Intent topTenSongsListIntent = new Intent(this, TopSongsActivity.class);
        startActivity(topTenSongsListIntent);
    }

    public void openFamousSongsList(){
        //New intent to start FamousSongsActivity class
        Intent famousSongsListIntent = new Intent(this, FamousSongsActivity.class);
        startActivity(famousSongsListIntent);
    }

    public void openSurpriseSong(){
        //New intent to start FamousSongsActivity class
        Intent surpriseSongListIntent = new Intent(this, SurpriseSongsActivity.class);
        startActivity(surpriseSongListIntent);
    }

}

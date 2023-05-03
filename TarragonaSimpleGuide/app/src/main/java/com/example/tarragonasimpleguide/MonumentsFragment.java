package com.example.tarragonasimpleguide;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * {@link Fragment} that displays a list of visit monuments options.
 */
public class MonumentsFragment extends Fragment {

    private MediaPlayer mMediaPlayer;

    public MonumentsFragment(){
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        /*
         * The LayoutInflater is the resource layout which we want to inflate
         * The ViewGroup container is where our view will be added.
         * The savedInstanceState parameter is a Bundle that provides data about the previous instance of the Fragment.
         */
        View rootView = inflater.inflate(R.layout.option_list, container, false);

        // Create a list of options
        final ArrayList<Option> options = new ArrayList<Option>();

        options.add(new Option(getString(R.string.monuments_walls_title), getString(R.string.monuments_walls_desc),R.drawable.roman_walls));
        options.add(new Option(getString(R.string.monuments_scipioni_title), getString(R.string.monuments_scipioni_desc),R.drawable.scipioni_tower));
        options.add(new Option(getString(R.string.monuments_arc_title), getString(R.string.monuments_arc_desc),R.drawable.roman_arc));
        options.add(new Option(getString(R.string.monuments_amphitheater_title), getString(R.string.monuments_amphitheater_desc),R.drawable.roman_amphitheater));
        options.add(new Option(getString(R.string.monuments_aqueduct_title), getString(R.string.monuments_aqueduct_desc),R.drawable.roman_aqueduct));

        // Create an {@link OptionAdapter}, whose data source is a list of {@link Option}s. The
        // adapter knows how to create list items for each item in the list.
        OptionAdapter adapter = new OptionAdapter(getActivity(), options);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // option_list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link OptionAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);

        // Set a click listener to open an extended information activity
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Gets monument title
                String detailTitle = options.get(position).getOptionTitle();

                //Gets monument image
                int detailImageResource = options.get(position).getImageResourceId();

                //Gets monument description
                String detailDescription = options.get(position).getOptionDescription();

                //Send data to the DetailedOptionActivity
                Intent intent = new Intent(getActivity().getBaseContext(),DetailedOptionActivity.class);
                intent.putExtra("option title", detailTitle);
                intent.putExtra("option image", detailImageResource);
                intent.putExtra("option description", detailDescription);
                startActivity(intent);

                // Get the {@link Option} object at the given position the user clicked on
                Option option = options.get(position);
            }
        });

        return rootView;
    }
}
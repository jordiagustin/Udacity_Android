package com.example.tarragonasimpleguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * {@link Fragment} that displays a list of information options.
 */
public class InformationFragment extends Fragment {

    //Every information place url
    private String url;
    public InformationFragment(){
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

        options.add(new Option(getString(R.string.tourist_info_title), getString(R.string.tourist_info_telf),R.drawable.info));
        options.add(new Option("Local Taxis", "977 22 14 14",R.drawable.local_taxi));
        options.add(new Option("City Hall", "977 29 61 00",R.drawable.city_hall));
        options.add(new Option("Local Hospital", "977 231 814",R.drawable.local_hospital));
        options.add(new Option("Local Police", "977 240 345",R.drawable.local_police));
        options.add(new Option("Local Fire Department", "937251234",R.drawable.fire_department));


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

                // Get the {@link Option} object at the given position the user clicked on
                Option option = options.get(position);

                //Depending on the position we can open one or another information web
                switch (position){
                    case 0: url = "https://www.tarragonaturisme.cat/ca";
                    break;
                    case 1: url = "https://www.radiotaxitarragona.com";
                    break;
                    case 2: url = "https://www.tarragona.cat";
                    break;
                    case 3: url = "https://www.xarxatecla.cat/";
                    break;
                    case 4: url = "https://www.tarragona.cat/la-ciutat/planol/ubicacions/dependencies-municipals/guardia-urbana";
                    break;
                    case 5: url = "https://interior.gencat.cat/ca/arees_dactuacio/bombers/";
                    break;
                }

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });

        return rootView;
    }
}
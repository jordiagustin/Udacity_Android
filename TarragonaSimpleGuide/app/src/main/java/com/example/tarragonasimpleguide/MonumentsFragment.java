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

        options.add(new Option("Walls of Tarragona", "Ancient roman Wall.\n"+
                "\nThe Roman wall was built at the end of the 3rd century BC. C., although specialists have not yet agreed on whether it was during the Second Punic War or later. " +
                "It is known that it underwent an enlargement throughout the 2nd century BC. C., probably during the formation of the Roman city of Tarraco. " +
                "Three original towers remain from this period: l'Arquebisbe, Cabiscol and Minerva.\n" +
                "\n" +
                "In 217 and 197 a. C. was enlarged and strengthened with a stone front of 6 meters and about 4.5 meters thick, with towers in the weak points. " +
                "It had a length around the 3rd century BC. C. about 4 km. However, today only about 1 km and an original voussoir door remain.\n" +
                "\n" +
                "After the Islamic invasion, Tarraco suffered a gradual depopulation and it was not until the occupation of Ramón Berenguer IV, in the 12th century, that the wall was reused and repaired. " +
                "\nVarious modifications and repairs are known from the modern and contemporary times, being modified during the Napoleonic occupation.\n" +
                "\n" +
                "Since the end of the 19th century it has been public property and a World Heritage Site, and is one of the characteristic symbols of the city of Tarragona.\n" +
                "\nReference: https://es.wikipedia.org/wiki/Muralla_de_Tarragona",R.drawable.roman_walls));

        options.add(new Option("Scipioni Tower", "Roman funerary tower. \n" +
                "\nThe Torre dels Escipions is a funerary monument in the form of a tower built in the first half of the 1st century AD next to the Via Augusta in the west-north/west of the city of Tarragona. " +
                "It is made up of three superimposed bodies and on the intermediate facade there are two figures of Atis—oriental funerary deity—who hold an inscription. " +
                "An erroneous identification of the figures with the brothers Publius and Gnaeus Scipio is the origin of the traditional name."+
                "\n" +
                "\nReference: https://ca.wikipedia.org/wiki/Torre_dels_Escipions", R.drawable.scipioni_tower));

        options.add(new Option("Arc of Berà", "Honorific roman arc. \n" +
                "\n" +
                "located in Roda de Berà, about 20 km north of the city of Tarragona. The arch is located on the route of what used to be Via Augusta. " +
                "It was erected by the will of Luci Licini Sura at the end of the 1st century BC, and dedicated to the emperor Augustus. " +
                "With a single opening, it is built with local stone blocks, with eight fluted pilasters, topped by Corinthian capitals, " +
                "which support a entablature with an inscription alluding to its construction. It is assumed that it was dedicated to Augustus or his genius, " +
                "and that it served to mark the territorial limits that depended on Tarraco." +
                "\n"+
                "\nReference: https://ca.wikipedia.org/wiki/Arc_de_Berà",R.drawable.roman_arc));

        options.add(new Option("Roman Amphitheater", "Ancient coast Amphitheater.\n" +
                "\nBuilt very close to the sea, behind the walls of the city of Tarraco, capital of the Roman province of Hispania Citerior Tarraconensis. " +
                "It is one of the locations of the World Heritage site called 'A'rchaeological Complex in Tarraco', specifically with the code 875-007 (current Tarragona), in Spain." +
                "\n"+
                "\nReference: https://es.wikipedia.org/wiki/Anfiteatro_de_Tarraco",R.drawable.roman_amphitheater));

        options.add(new Option("Devil's Bridge", "Roman aqueduct also known as 'Aqueducte de les Ferreres'.\n" +
                "\nThe so-called aqueduct of Ferreres, also known as 'Pont del Diable', is a Roman archway that forms part of the aqueduct that supplied water from the Francolí River to the city of Tarraco (Tarragona), from a distance of 25 km. " +
                "The archery is located on the outskirts of the city of Tarragona (Catalonia, Spain), which has been designated a World Heritage Site by Unesco, thanks to the fact that it is one of the monuments of the Roman era that are preserved in extraordinary good condition." +
                "\n"+
                "\nReference: https://es.wikipedia.org/wiki/Acueducto_de_les_Ferreres",R.drawable.roman_aqueduct));
        /*
        options.add(new Option("Roman Circus", "Roman circus inside the city.",R.drawable.roman_circus));
        options.add(new Option("Roman Theater", "Partially preserved roman theater",R.drawable.roman_theater));
        options.add(new Option("Forum colony", "Roman Colonial Forum of Tarraco",R.drawable.roman_forum));
        options.add(new Option("Necropolis", "Christian necropolis from the late Roman period",R.drawable.roman_necropolis));
        options.add(new Option("Roman Ville", "Villa-mausoleum of Centcelles, from Constantí",R.drawable.roman_ville));
        options.add(new Option("Santa Tecla's Cathedral", "Santa Tecla's Cathedral, built in the early gothic style",R.drawable.gothic_cathedral));
        options.add(new Option("Pilat's Tower", "Roman building rehabilitated into a castle in the 12th century",R.drawable.pilats_tower));
        options.add(new Option("House of the Blessed",   "Medieval building built on roman remains",R.drawable.voltes_pallol));
        */

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
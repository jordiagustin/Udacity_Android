package com.example.tarragonasimpleguide;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * {@link Fragment} that displays a list of visit museums options.
 */
public class MuseumsFragment extends Fragment {

    public MuseumsFragment(){
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

        options.add(new Option("Archeological Museum", "Dissemination of heritage from Tarraco.\n" +
                "\nIt is a public museum located in the city of Tarragona (Catalonia, Spain) that houses elements and remains of its rich past. " +
                "Created in the mid-19th century as a Provincial Museum —being the oldest museum of its kind in Catalonia—, it promotes the recovery, conservation, research and dissemination of heritage from the Roman city of Tarraco and its area of influence. " +
                "In addition to the Archaeological Museum, the MNAT manages the Paleochristian Museum and Necropolis, the Roman villa of Els Munts (Altafulla) and the Roman villa of Centcelles (Constantí), as well as the monuments of the Arch of Bará and the Tower of the Scipios and the roman Theater. " +
                "In order to carry out its objectives, it organizes activities and offers diverse services such as temporary exhibitions, conference cycles, seminars, workshops and historical reconstruction activities, publishing publications and audiovisual programs.\n"+
                "\nReference: https://es.wikipedia.org/wiki/Museo_Arqueológico_Nacional_de_Tarragona",R.drawable.archeologic_museum));

        options.add(new Option("Casa Castell Arnau", "An stately home protected as a cultural benef of local interest.\n" +
                "\nCasa Castellarnau is a stately home in the city of Tarragona protected as a cultural asset of local interest. " +
                "It is currently the headquarters of the History Museum of Tarragona. " +
                "The building was built inside what in Roman times was the administrative square of the Provincial Forum. " +
                "Excavations carried out in 1993 in the courtyard uncovered a whole series of structures from the Roman period corresponding to the podium of the portico of the great representation square of the province\n" +
                "\nReference: https://ca.wikipedia.org/wiki/Casa_Castellarnau",R.drawable.casa_castell_arnau));

        options.add(new Option("Casa Canals", "An eclectic work protected with a Cultural Award of Local Interest.\n" +
                "\nBuilding with ground floor and two floors. It features a large entrance courtyard with a staircase leading to the rooms on the first floor. " +
                "The main facade is on c/ Granada and was built using the Roman wall as can be seen on the facade of Passeig de Sant Antoni.\n" +
                "\nReference: https://ca.wikipedia.org/wiki/Casa_Canals_de_Tarragona",R.drawable.casa_canals));

        options.add(new Option("Maritim Museum", "Mainly dedicated to documenting and promoting the Port of Tarragona as well as its surroundings.\n" +
                "\nWalk through the history of the port from the time the Romans landed there to the present day. The different types of port: commercial, fishing and sports are also represented.\n" +
                "\n" +
                "The Banya lighthouse, the only witness of the metal lighthouses installed at the mouth of the Ebro River, was built at the end of the 19th century and in 2003 became the Lighthouse Museum and an extension of the Museum of the Port of Tarragona to show, in the tower's former home, a permanent exhibition related to the world of maritime signals.\n" +
                "\nReference: http://museusmaritims.mmb.cat/membres/llista-de-museus/museu-del-port,-tarragona",R.drawable.maritim_museum));

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
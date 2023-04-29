package com.example.tarragonasimpleguide;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import java.util.ArrayList;

public class OptionAdapter extends ArrayAdapter<Option> {

    /**
     * Create a new {@link OptionAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param options is the list of {@link Option}s to be displayed.
     */

    private ArrayList<Option> options;

    public OptionAdapter(Activity context, ArrayList<Option> options) {
        super(context,0, options);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Option currentOption = getItem(position);


        // Find the ImageView in the list_item.xml layout with the ID image.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        //Display the provided image based on the resource ID
        imageView.setImageResource(currentOption.getImageResourceId());
        imageView.setVisibility(View.VISIBLE);

        //Declarem la view del layout a list_item.xml que conté les dues text view amb les paraules
        View textContainer = listItemView.findViewById(R.id.text_container);


        // Find the TextView in the list_item.xml layout with the ID title_text_view.
        TextView optionTitleTextView = (TextView) listItemView.findViewById(R.id.title_text_view);
        // Get the title from the currentOption object and set this text on the Title TextView.
        optionTitleTextView.setText(currentOption.getOptionTitle());


        // Find the TextView in the list_item.xml layout with the ID description_text_view.
        TextView optionDescriptionTextView = (TextView) listItemView.findViewById(R.id.description_text_view);
        // Get the description from the currentOption object and set this text on the description TextView.
        optionDescriptionTextView.setText(currentOption.getOptionDescription());


        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in the ListView.
        return listItemView;
    }
}

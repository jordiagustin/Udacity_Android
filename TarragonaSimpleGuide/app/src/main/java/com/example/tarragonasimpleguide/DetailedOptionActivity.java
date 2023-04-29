package com.example.tarragonasimpleguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * {@link DetailedOptionActivity}
 * Represents a detailed page of a selected option
 * it basically expands the selected option image and it's description
 */
public class DetailedOptionActivity extends AppCompatActivity {

    private TextView mDetailedOptionTitle;
    private ImageView mDetailedOptionImage;
    private TextView mDetailedOptionDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_option);

        mDetailedOptionTitle = (TextView) findViewById(R.id.detail_title_text_view);
        mDetailedOptionImage = (ImageView) findViewById(R.id.detail_image);
        mDetailedOptionDescription = (TextView) findViewById(R.id.detail_description_text_view);

        Intent intent = getIntent();

        //Gets the selected option title from the fragment
        String mOptionTitle = intent.getStringExtra("option title");

        //Gets the selected option image from the fragment
        int mOptionImage = intent.getIntExtra("option image", R.id.detail_image);

        //Gets the selected option description from the fragment
        String mOptionDescription = intent.getStringExtra("option description");

        //Sets the selected option title from the fragment to the detailed activity layout
        mDetailedOptionTitle.setText(mOptionTitle);

        //Sets the selected option image from the fragment to the detailed activity layout
        mDetailedOptionImage.setImageResource(mOptionImage);

        //Sets the selected option description from the fragment to the detailed activity layout
        mDetailedOptionDescription.setText(mOptionDescription);
    }
}
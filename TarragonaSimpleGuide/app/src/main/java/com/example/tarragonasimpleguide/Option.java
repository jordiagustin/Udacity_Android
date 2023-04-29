package com.example.tarragonasimpleguide;

public class Option {
    /** String resource ID for the option title */
    private String mOptionTitle;

    /** String resource ID for the option description */
    private String mOptionDescription;

    /** Image resource ID for the word */
    private int mImageResourceId;

    /**
     * Create a new Option object.
     *
     * @param optionTitle is the string resource ID for the title of the tourist guide different options
     * @param optionDescription is the string resource Id for a short description of the tourist guide different options
     * @param imageResourceId is the drawable resource ID for the image associated with the guide different options
     */
    public Option(String optionTitle, String optionDescription, int imageResourceId) {
        mOptionTitle = optionTitle;
        mOptionDescription = optionDescription;
        mImageResourceId = imageResourceId;
    }

    /**
     * Get the string resource ID for the turist guide option title.
     */
    public String getOptionTitle() {
        return mOptionTitle;
    }

    /**
     * Get the string resource ID for the turist guide option short description.
     */
    public String getOptionDescription() {
        return mOptionDescription;
    }

    /**
     * Return the image resource ID for the tourist guide option image.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

}

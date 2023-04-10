package com.example.jordismusicstructureapp;

//Class with the different portraits stored on drawable folder

public class MyAutoListPicture {
    private int autolistPicture;

    public MyAutoListPicture(int myDrawableId){
        autolistPicture = myDrawableId;
    }

    public void setAutoListPortraitDrawableId(int myDrawableId){
        autolistPicture = myDrawableId;
    }

    public int getAutoListPortraitDrawableId(){
        return autolistPicture;
    }
}

package com.example.jordismusicstructureapp;

public class Song {

    private final String sName;
    private final String sArtist;
    private final String sAlbun;
    private final String sGenre;


    public Song(String name, String artist, String album, String genre){
        sName = name;
        sArtist = artist;
        sAlbun = album;
        sGenre = genre;
    }

    public String getSongName(){
        return sName;
    }
    public String getSongArtistName(){
        return sArtist;
    }
    public String getSongAlbumName(){
        return sAlbun;
    }
    public String getSongGenre(){
        return sGenre;
    }
}
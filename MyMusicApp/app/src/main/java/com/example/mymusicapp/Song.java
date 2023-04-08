package com.example.mymusicapp;

public class Song {

    private String sName;
    private String sArtist;
    private String sAlbun;
    private String sGenre;


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
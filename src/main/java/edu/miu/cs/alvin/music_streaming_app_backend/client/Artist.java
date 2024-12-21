package edu.miu.cs.alvin.music_streaming_app_backend.client;

import edu.miu.cs.alvin.music_streaming_app_backend.album.Album;
import edu.miu.cs.alvin.music_streaming_app_backend.song.Song;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Artist extends Client {


    private String name;
    private String biography;


    @OneToMany(mappedBy = "artist")
    private List<Album> albums;

    @ManyToMany(mappedBy = "artists", cascade = CascadeType.PERSIST)
    private List<Song> songs;


    public Artist() {}

    public Artist(String name, String biography) {
        this.name = name;
        this.biography = biography;

        this.albums = new ArrayList<>();
        this.songs = new ArrayList<>();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }











}

package edu.miu.cs.alvin.music_streaming_app_backend.album;

import edu.miu.cs.alvin.music_streaming_app_backend.artist.Artist;
import edu.miu.cs.alvin.music_streaming_app_backend.song.Song;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Album {

    @Id
    private int id;
    private String title;
    private String genre;
    private String releaseDate;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;

    @OneToMany(mappedBy = "album", cascade = CascadeType.PERSIST)
    private List<Song> songs;


    public Album() {}

    public Album(String title, String genre) {
        this.title = title;
        this.genre = genre;
        this.songs = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void addSong(Song song) {
        this.songs.add(song);
    }
}

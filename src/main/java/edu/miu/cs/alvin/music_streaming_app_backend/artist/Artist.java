package edu.miu.cs.alvin.music_streaming_app_backend.artist;

import edu.miu.cs.alvin.music_streaming_app_backend.album.Album;
import edu.miu.cs.alvin.music_streaming_app_backend.song.Song;
import edu.miu.cs.alvin.music_streaming_app_backend.user.ArtistUser;
import edu.miu.cs.alvin.music_streaming_app_backend.user.Listener;
import edu.miu.cs.alvin.music_streaming_app_backend.user.User;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private String name;
    private String biography;

    @OneToOne(mappedBy = "artistProfile")
    private ArtistUser artistUser;

    @OneToMany(mappedBy = "artist", cascade = CascadeType.PERSIST)
    private List<Album> albums;

    @ManyToMany(mappedBy = "artists", cascade = CascadeType.PERSIST)
    private List<Song> songs;

    @ManyToMany
    @JoinTable(name = "song_listener",
            joinColumns = @JoinColumn(name = "artist_id"),
            inverseJoinColumns = @JoinColumn(name = "listener_id")
    )
    private List<Listener> listeners;

    @ElementCollection
    private List<String> genres;


    public Artist() {}

    public Artist(String name, String biography) {
        this.name = name;
        this.biography = biography;
    }


    public ArtistUser getArtistUser() {
        return artistUser;
    }

    public int getId() {
        return id;
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

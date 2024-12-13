package edu.miu.cs.alvin.music_streaming_app_backend.playlist;


import edu.miu.cs.alvin.music_streaming_app_backend.song.Song;
import edu.miu.cs.alvin.music_streaming_app_backend.user.Listener;
import edu.miu.cs.alvin.music_streaming_app_backend.user.User;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private Listener createdBy;

    @ManyToMany
    @JoinTable(name = "playlist_song",
    joinColumns = @JoinColumn(name = "playlist_id"),
    inverseJoinColumns = @JoinColumn(name = "song_id")
    )
    private List<Song> songs;

    public Playlist() {}

    public Playlist(String name, String description) {
        this.name = name;
        this.description = description;
        this.songs = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void addSongs(Song song) {
        this.songs.add(song);
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Listener createdBy) {
        this.createdBy = createdBy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

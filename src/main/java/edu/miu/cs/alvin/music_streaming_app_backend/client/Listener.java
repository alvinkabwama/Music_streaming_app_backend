package edu.miu.cs.alvin.music_streaming_app_backend.client;


import edu.miu.cs.alvin.music_streaming_app_backend.playlist.Playlist;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("LISTENER")
public class Listener extends Client {

    @OneToMany(mappedBy = "createdBy")
    private List<Playlist> playlists;


    public Listener() {
    }

    public Listener(String name, String email) {
        super(name, email);
        this.playlists = new ArrayList<>();
    }

    public List<Playlist> getPlaylists() {
        return playlists;

    }
    public void addPlaylists(Playlist playlist) {
        this.playlists.add(playlist);
    }
}
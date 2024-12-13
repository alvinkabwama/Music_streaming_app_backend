package edu.miu.cs.alvin.music_streaming_app_backend.user;


import edu.miu.cs.alvin.music_streaming_app_backend.artist.Artist;
import edu.miu.cs.alvin.music_streaming_app_backend.playlist.Playlist;
import edu.miu.cs.alvin.music_streaming_app_backend.song.Song;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Listener extends User {



    @OneToMany(mappedBy = "createdBy")
    private List<Playlist> playlists;

    @ManyToMany(mappedBy = "listeners")
    private List<Song> favouriteSongs;

    @ManyToMany(mappedBy = "listeners")
    private List<Artist> followedArtists;


    public Listener() {}

    public Listener(String name, String email) {
        super(name, email);
        this.playlists = new ArrayList<>();
        this.favouriteSongs = new ArrayList<>();
        this.followedArtists = new ArrayList<>();
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public void addPlaylists(Playlist playlist) {
        this.playlists.add(playlist);
    }

    public List<Artist> getFollowedArtists() {
        return followedArtists;
    }

    public void addFollowedArtists(Artist followedArtist) {
        this.followedArtists.add(followedArtist);
    }

    public List<Song> getFavouriteSongs() {
        return favouriteSongs;
    }

    public void setFavouriteSongs(Song favouriteSong) {
        this.favouriteSongs.add(favouriteSong);
    }
}

package edu.miu.cs.alvin.music_streaming_app_backend.song;


import edu.miu.cs.alvin.music_streaming_app_backend.album.Album;
import edu.miu.cs.alvin.music_streaming_app_backend.artist.Artist;
import edu.miu.cs.alvin.music_streaming_app_backend.playlist.Playlist;
import edu.miu.cs.alvin.music_streaming_app_backend.user.Listener;
import edu.miu.cs.alvin.music_streaming_app_backend.user.User;
import jakarta.persistence.*;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String title;
    private String genre;
    private Duration duration;
    private LocalDate releaseDate;


    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;

    @ManyToMany
    @JoinTable(
            name = "song_artist",
            joinColumns = @JoinColumn(name = "song_id"),
            inverseJoinColumns = @JoinColumn(name = "artist_id")
    )
    private List<Artist> artists = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "song_listener",
            joinColumns = @JoinColumn(name = "song_id"),
            inverseJoinColumns = @JoinColumn(name = "listener_id")
    )
    private List<Listener> listeners = new ArrayList<>();

    @ManyToMany(mappedBy = "songs")
    private List<Playlist> playlists = new ArrayList<>();


    public Song() {

    }

    public Song(String title, String genre, Duration duration, LocalDate releaseDate) {
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.releaseDate = releaseDate;
        this.artists = new ArrayList<>();
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

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void addArtist(Artist artist) {
        this.artists.add(artist);
    }
}

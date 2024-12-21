package edu.miu.cs.alvin.music_streaming_app_backend.song;


import edu.miu.cs.alvin.music_streaming_app_backend.album.Album;
import edu.miu.cs.alvin.music_streaming_app_backend.client.Artist;
import edu.miu.cs.alvin.music_streaming_app_backend.playlist.Playlist;
import edu.miu.cs.alvin.music_streaming_app_backend.client.Listener;
import jakarta.persistence.*;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@NamedQuery(
        name = "Song.findByGenre",
        query = "SELECT s FROM Song s WHERE s.genre = :genre"
)

@Entity
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Version
    private int version;

    private String title;
    private String genre;
    private String duration;
    private LocalDate releaseDate;


    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;


    private Artist artist;

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

    public Song(String title, String genre, String duration, LocalDate releaseDate, Album album, Artist artist) {
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.releaseDate = releaseDate;
        this.album = album;
        this.artist = artist;
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

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
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

    public Artist getArtist() {
        return artist;
    }

    public void addArtist(Artist artist) {
        this.artist = artist;
    }
}

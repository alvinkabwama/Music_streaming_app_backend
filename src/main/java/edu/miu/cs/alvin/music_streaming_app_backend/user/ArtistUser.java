package edu.miu.cs.alvin.music_streaming_app_backend.user;


import edu.miu.cs.alvin.music_streaming_app_backend.artist.Artist;
import jakarta.persistence.*;

@Entity
public class ArtistUser extends User {


  @OneToOne
  @JoinColumn(name = "artist_id")
    private Artist artistProfile;

  public ArtistUser() {}

  public ArtistUser(String name, String email) {
    super(name, email);
  }


  public void setArtistProfile(Artist artistProfile) {
    this.artistProfile = artistProfile;
  }


}

package edu.miu.cs.alvin.music_streaming_app_backend.song;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {

    @Query("SELECT s FROM Song s WHERE s.artist.id = :artistId")
    List<Song> findSongsByArtist(@Param("artistId") int artistId);

    @Query("SELECT s FROM Song s JOIN s.playlists p JOIN p.createdBy l WHERE l.id = :listenerId")
    List<Song> findSongsInPlaylistsByListener(@Param("listenerId") int listenerId);
}

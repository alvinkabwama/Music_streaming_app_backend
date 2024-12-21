package edu.miu.cs.alvin.music_streaming_app_backend.song;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {
    @Autowired
    private SongRepository songRepository;

    public List<Song> findAll() {
        return songRepository.findAll();
    }

    public Song save(Song song) {
        return songRepository.save(song);
    }

    public void delete(int id) {
        songRepository.deleteById(id);
    }
}


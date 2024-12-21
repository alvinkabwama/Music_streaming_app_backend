package edu.miu.cs.alvin.music_streaming_app_backend.song;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/songs", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public class SongController {
    @Autowired
    private SongService songService;

    @GetMapping
    public List<Song> getAllSongs() {
        return songService.findAll();
    }

    @PostMapping
    public Song createSong(@RequestBody Song song) {
        return songService.save(song);
    }

    @DeleteMapping("/{id}")
    public void deleteSong(@PathVariable int id) {
        songService.delete(id);
    }
}


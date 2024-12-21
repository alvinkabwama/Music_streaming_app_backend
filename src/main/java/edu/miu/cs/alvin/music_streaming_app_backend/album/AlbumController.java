package edu.miu.cs.alvin.music_streaming_app_backend.album;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("albums")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @GetMapping
    public List<Album> getAllAlbums() {
        return albumService.findAll();
    }

    // Retrieve an Album by ID
    @GetMapping("/{id}")
    public Album getAlbumById(@PathVariable int id) {
        return albumService.findById(id);
    }

    // Create or Update an Album
    @PostMapping
    public Album createOrUpdateAlbum(@RequestBody Album album) {
        return albumService.save(album);
    }


    @GetMapping("/search")
    public List<Album> searchAlbums(
            @RequestParam String genre,
            @RequestParam String startDate,
            @RequestParam String endDate) {

        LocalDate start = LocalDate.parse(startDate, DateTimeFormatter.ISO_DATE);
        LocalDate end = LocalDate.parse(endDate, DateTimeFormatter.ISO_DATE);

        return albumService.findAlbumsByCriteria(genre, start, end);
    }






}

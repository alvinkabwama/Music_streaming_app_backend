package edu.miu.cs.alvin.music_streaming_app_backend.album;


import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private EntityManager entityManager;

    // Create or Update Album
    public Album save(Album album) {
        return albumRepository.save(album);
    }

    // Retrieve all Albums
    public List<Album> findAll() {
        return albumRepository.findAll();
    }

    // Retrieve Album by ID
    public Album findById(int id) {
        return albumRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Album not found"));
    }

    public List<Album> findAlbumsByCriteria(String genre, LocalDate startDate, LocalDate endDate) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Album> query = cb.createQuery(Album.class);
        Root<Album> root = query.from(Album.class);

        Predicate genrePredicate = cb.equal(root.get("genre"), genre);
        Predicate datePredicate = cb.between(root.get("releaseDate"), startDate, endDate);

        query.select(root).where(cb.and(genrePredicate, datePredicate));

        return entityManager.createQuery(query).getResultList();
    }


}

package edu.miu.cs.alvin.music_streaming_app_backend.repository;


import edu.miu.cs.alvin.music_streaming_app_backend.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TestRepo extends JpaRepository<Test, Integer> {

}
